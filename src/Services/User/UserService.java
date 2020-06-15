/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.User;

import Models.User.User;
import Utils.DataSource;
import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author toshiba
 */
public class UserService {

    private ConnectionRequest request;

    private boolean responseResult;
    public static ArrayList<User> users;
    public String tmp = "pas de connexion avec le serveur distant";

    public UserService() {
        request = DataSource.getInstance().getRequest();
    }

    public boolean addUser(User user) {
        String url = Statics.BASE_URL + "/connexionMobile/users/" + user.getUsername() + "/" + user.getPassword();

        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }

    public String connection(String username, String password) {
        String url = Statics.BASE_URL + "/connexionMobile/" + username + "/" + password;
        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                if (responseResult) {
                    String responseString = new String(request.getResponseData());
                    if (responseString.startsWith("{\"id\":")) {
                        tmp = "Utilisateur existant";
                        System.out.println("responseString: " + responseString);
                        users = parseUsers(new String(request.getResponseData()));

                    } else {
                        tmp = "Utilisateur non existant";
                    }
                }
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
        return tmp;
    }

    public ArrayList<User> getUser() {
        return this.users;
    }

    public ArrayList<User> parseUsers(String jsonText) {
        try {
            users = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            System.out.println("tasksListJson: " + tasksListJson);
            int id = 0;
            String username = "", email = "";
            for (Map.Entry<String, Object> entry : tasksListJson.entrySet()) {
                if (entry.getKey().equals("id")) {
                    id = (int)Float.parseFloat(entry.getValue().toString());

                } else if (entry.getKey().equals("username")) {
                    username = entry.getValue().toString();

                } else if (entry.getKey().equals("email")) {
                    email = entry.getValue().toString();

                }

            }

            users.add(new User(id, username, email));
        } catch (IOException ex) {
        }

        return users;
    }
}
