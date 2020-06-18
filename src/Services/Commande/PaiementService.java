/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Commande;

import Models.Commande.Adresse;
import Utils.DataSource;
import Utils.Statics;
import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.ClientTokenRequest;
import com.braintreegateway.Environment;
import com.braintreegateway.Request;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;

/**
 *
 * @author toshiba
 */
public class PaiementService {

    private ConnectionRequest request;

    private boolean responseResult;
    private static BraintreeGateway gateway = new BraintreeGateway(
            Environment.SANDBOX,
            "p3fgq462vvx5sgdp",
            "2r7m3jq2tb6j92jt",
            "72ba3bdaa92d6c0e72e386cb17980c82"
    );

    public PaiementService() {
        request = DataSource.getInstance().getRequest();
    }

    public boolean addPaiement(Adresse adresse) {
        String url = Statics.BASE_URL_ROMUALD + "/ajoutPaiement/" + adresse.getNom() + "/" + adresse.getPrenom() + "/" + adresse.getPhone() + "/" + adresse.getEmail() + "/" + adresse.getPays() + "/" + adresse.getVille() + "/" + adresse.getEtat() + "/" + adresse.getPincode() + "/" + adresse.getAdresseLivraison();
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

    public boolean Payer() {
        ClientTokenRequest clientTokenRequest = new ClientTokenRequest();
        String clientToken = gateway.clientToken().generate(clientTokenRequest);
        return false;
    }
}
