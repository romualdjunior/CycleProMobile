/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Shop;

import Models.Shop.Velo;
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
 * @author Yasmine
 */
public class ShopService {

    private ConnectionRequest request;

    private boolean responseResult;
    public ArrayList<Velo> velos;
    public String tmp = "pas de connexion avec le serveur distant";

    public ShopService() {
        request = DataSource.getInstance().getRequest();
    }

    public ArrayList<Velo> getAllTasks() {
        String url = Statics.BASE_URL + "stock/shopMobile";

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                velos = parseVelos(new String(request.getResponseData()));
                System.out.println(velos);
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return velos;
    }

    public ArrayList<Velo> parseVelos(String jsonText) {
        try {
            velos = new ArrayList<Velo>();

            JSONParser jp = new JSONParser();
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                int id = (int) Float.parseFloat(obj.get("id").toString());
                String marque = obj.get("marque").toString();
                String photoV = obj.get("photoV").toString();
                String prixAchat = obj.get("prixAchat").toString();
                int qtEnStock = (int) Float.parseFloat(obj.get("qtEnStock").toString());

                String photoV1 = obj.get("photoV1").toString();
                String photoV2 = obj.get("photoV2").toString();

                velos.add(new Velo(id, marque, qtEnStock, Double.parseDouble(prixAchat), photoV, photoV1, photoV2));
            }

        } catch (IOException ex) {
        }

        return velos;
    }
}
