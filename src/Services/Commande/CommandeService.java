/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Commande;

import Models.Commande.Commande;
import Models.User.User;
import static Services.User.UserService.users;
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
public class CommandeService {

    private ConnectionRequest request;

    private boolean responseResult;
    double[] Stats = {};

    public CommandeService() {
        request = DataSource.getInstance().getRequest();
    }

    public boolean addCommande(Commande commande) {
        String url = Statics.BASE_URL_ROMUALD + "/ajoutCommandeMobile/" + commande.getTotal() + "/" + commande.getEtat() + "/" + commande.getIdUser();
        System.out.println(url);
        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
                System.out.println(new String("Données:" + request.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }

    public double[] statistiques() {
        String url = Statics.BASE_URL_ROMUALD + "/afficherStatistiquesMobile";
        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Stats = parseDate(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return Stats;
    }

    public double[] parseDate(String jsonText) {
        double[] stats = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        try {
            JSONParser jp = new JSONParser();
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                if (obj.get("date").toString().contains("-01-")) {
                    stats[0]++;

                } else if (obj.get("date").toString().contains("-02-")) {
                    stats[1]++;

                } else if (obj.get("date").toString().contains("-03-")) {
                    stats[2]++;

                } else if (obj.get("date").toString().contains("-04-")) {
                    stats[3]++;

                }
                if (obj.get("date").toString().contains("-05-")) {
                    stats[4]++;

                } else if (obj.get("date").toString().contains("-06-")) {
                    stats[5]++;

                } else if (obj.get("date").toString().contains("-07-")) {
                    stats[6]++;

                } else if (obj.get("date").toString().contains("-08-")) {
                    stats[7]++;

                } else if (obj.get("date").toString().contains("-09-")) {
                    stats[8]++;

                } else if (obj.get("date").toString().contains("-10-")) {
                    stats[9]++;

                } else if (obj.get("date").toString().contains("-11-")) {
                    stats[10]++;

                } else if (obj.get("date").toString().contains("-12-")) {
                    stats[11]++;

                }
            }
            for (int i = 0; i < stats.length; i++) {
                 stats[i]*= 1000;
            }

        } catch (IOException ex) {
        }
        System.out.println("stats"+stats);
        return stats;
    }
}
