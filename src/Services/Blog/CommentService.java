/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Blog;

import Models.Blog.CommentaireArticle;
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
import java.util.Map;


/**
 *
 * @author asus
 */
public class CommentService {
    public ConnectionRequest request;
    private boolean responseResult;

    public CommentService(){
            request = DataSource.getInstance().getRequest();
    }
    
    
    public boolean AddComment(CommentaireArticle comt) {
        String url = Statics.BASE_URL_NADA + "/ArticleUser/createCommentaire/" + comt.getArticle()
                +"/" + comt.getUser()
                + "/" + comt.getContenue();

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

}
    