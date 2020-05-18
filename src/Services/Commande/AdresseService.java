/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Commande;

import Models.Commande.Adresse;
import Models.User.User;
import Utils.DataSource;
import Utils.Statics;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;

/**
 *
 * @author toshiba
 */
public class AdresseService {
     private ConnectionRequest request;

    private boolean responseResult;
     public AdresseService() {
        request = DataSource.getInstance().getRequest();
    }
    public boolean addAdresse(Adresse adresse) {
        String url = Statics.BASE_URL + "/ajoutAdresseMobile/" + adresse.getNom() + "/" + adresse.getPrenom()+"/"+adresse.getPhone()+"/"+adresse.getEmail()+"/"+adresse.getPays()+"/"+adresse.getVille()+"/"+adresse.getEtat()+"/"+adresse.getPincode()+"/"+adresse.getAdresseLivraison();
        System.out.println(url);
        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
                System.out.println(new String("Données:"+request.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }
    
}
