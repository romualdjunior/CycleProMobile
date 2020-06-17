/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Blog;

import Models.Blog.Article;
import Models.Blog.FavoriArticle;
import Utils.DataSource;
import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author asus
 */
public class FavoritService {
          ConnectionRequest request;
           public ArrayList<Article> articles;
    private boolean responseResult;

    public FavoritService(){
            request = DataSource.getInstance().getRequest();
    }        
    
    
    public ArrayList<Article> getFavoritArticles(int id) {
        ArrayList<FavoriArticle> listConseils = new ArrayList<>();
        String url = Statics.BASE_URL_NADA+"/ArticleUser/findFavorit/"+id;
        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                articles = parseArticles(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
        return articles;    
    }   
    
    public boolean AddFavorit(FavoriArticle fav) {
        String url = Statics.BASE_URL_NADA + "/ArticleUser/createfavorit/" + fav.getUser()
                +"/" + fav.getArticle();

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

         public ArrayList<Article> parseArticles(String jsonText) {
        try {
            articles=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            java.util.List<Map<String,Object>> list = (java.util.List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                int id = (int)Float.parseFloat(obj.get("id").toString());
                String category = obj.get("category").toString();
                String titre = obj.get("titre").toString();
                String auteur = obj.get("auteur").toString();
                String contenue = obj.get("contenue").toString();
                int likes = (int)Float.parseFloat(obj.get("likes").toString());
                String photo = obj.get("photo").toString();
                //String date_art=obj.get("date_art").toString();
                articles.add(new Article(id,category,titre,auteur,photo,contenue,likes));
            }
            
            
        } catch (IOException ex) {
            
        }
        return articles;
    }
   
}
