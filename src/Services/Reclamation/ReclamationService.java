/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Reclamation;
import Models.Reclamation.Reclamation;
import Utils.DataSource;
import Utils.Statics;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 *
 * @author pc
 */
public class ReclamationService {
    
     private ConnectionRequest request;
     private boolean responseResult;
     
      public ReclamationService() {
        request = DataSource.getInstance().getRequest();
    }
    
    
/*
    @Override
    public void actionPerformed(ActionEvent evt) {
ConnectionRequest requete=new ConnectionRequest(){ 
    Map data; 
    @Override 
    protected void postResponse() { 
            Dialog.show("",(String)data.get("reponse"), "Ok", null); }
   
    
@Override
protected void readResponse(InputStream input) throws IOException {
JSONParser parser=new JSONParser(); 
data=parser.parseJSON(new InputStreamReader(input)); }}; 
requete.setUrl("http://localhost/reclamation.php");
requete.setPost(true); 
requete.addArgument("id", "100");
requete.addArgument("nomClient", "malek");
requete.addArgument("PrenomClient", "bembli");
requete.addArgument("tel", "24148022");
requete.addArgument("adresse", "32 rue mauritanie hc");
requete.addArgument("date", "30-05-2020");
requete.addArgument("raison", "casse");
requete.addArgument("details", "panne");
requete.addArgument("RefVelo", "156");
requete.addArgument("idClient", "156");
requete.addArgument("email", "malek@bembli.tn");
requete.addArgument("type", "default");

NetworkManager.getInstance().addToQueue(requete);
InfiniteProgress progress=new
InfiniteProgress();
Dialog d=progress.showInifiniteBlocking();
requete.setDisposeOnCompletion(d); 
}*/
      
   public boolean addReclamation(Reclamation reclamation) {    
      
       String url = Statics.BASE_URL + "/glob/ajoutReclamationMobile/"  + reclamation.getNomClient()+"/" + reclamation.getPrenomClient() + "/"+ reclamation.getTel() + "/" + reclamation.getAdresse() + "/" + reclamation.getDate() +"/"+ reclamation.getRaison() +"/" + reclamation.getDetails() +"/"+ reclamation.getRefVelo() +"/"+ reclamation.getIdClient() +"/" + reclamation.getEmail() +"/" + reclamation.getType();
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
      
   
   
   
    public boolean AfficheReclamation(Reclamation reclamation) {    
      
       String url = Statics.BASE_URL + "/glob/AfficherReclamationMobile/"  + reclamation.getId() ; 
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
      
      
      
      
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     



