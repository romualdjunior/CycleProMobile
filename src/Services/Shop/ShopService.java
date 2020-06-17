/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Shop;

import Models.Shop.Velo;
import Models.User.User;
import Utils.DataSource;
import Utils.SingletonDataBase;
import Utils.Statics;
import com.codename1.db.Cursor;
import com.codename1.db.Row;
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
    public final SingletonDataBase db ;

    private boolean responseResult;
    public ArrayList<Velo> velos;
    public String tmp = "pas de connexion avec le serveur distant";
    public ShopService() {
        request = DataSource.getInstance().getRequest();
                db =SingletonDataBase.getInstance();

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
    
     public void favProduit( Velo v){
        try {
            db.getBase().execute("Insert into fav (id , produit  , prix , image) values "
                    + "("+v.getId()+", '" +v.getMarque()+"',"+v.getPrixAchat()+" ,'"+v.getPhotoV() +"') ");
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
     
      public void deleteFav(Velo p) throws IOException{

        
       db.getBase().execute("Delete from fav where id=" +p.getId());
         }
      
        public void deleteFavAll() throws IOException{ 
        
        db.getBase().execute("Delete from fav" );
        
            }
    public  List <Velo> getFavoris(){
         
       List<Velo> list= new ArrayList<Velo>();
       
       
       
       try {
            Cursor c = db.getBase().executeQuery("Select * from fav");
            
            while (c.next()){
                
                Velo p = new Velo();
                Row r = c.getRow();
                
                p.setId(r.getInteger(0));
                p.setMarque(r.getString(1));
               
                p.setPrixAchat(r.getDouble(2));

                p.setPhotoV(r.getString(3));

                list.add(p);
                
                
                
            }
            c.close();
            
        }catch(IOException ex){
            
            System.out.println(ex.getMessage());
        }
       
       return list;
}
}