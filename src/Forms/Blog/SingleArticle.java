/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Blog;

import Forms.BaseForm;
import Forms.Frontend.SignInForm;
import Forms.Frontend.WalkthruForm;
import Models.Blog.Article;
import Models.Blog.CommentaireArticle;
import Models.Blog.FavoriArticle;
import Models.Commande.Adresse;
import Services.Blog.ArticleService;
import Services.Blog.CommentService;
import Services.Blog.FavoritService;
import Services.Commande.AdresseService;
import com.codename1.components.SpanLabel;
import com.codename1.messaging.Message;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListCellRenderer;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author asus
 */
public class SingleArticle extends BaseForm{
  Form f;
Resources res=UIManager.initNamedTheme("/theme", "Theme1");

    public SingleArticle(Article ar, com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(ar,resourceObjectInstance);

     
        List<Button> listButton = new ArrayList<Button>();
        List<Form> list_form = new ArrayList<Form>();
        Button favorit=new Button("Mes favoris");
        listButton.add(favorit);
        
        list_form.add(new FavoritArticles(resourceObjectInstance));
        installSidemenu(resourceObjectInstance, listButton, list_form);
           }
    @Override
      protected boolean is_current_adresse() {
        return true;
    }


    private void initGuiBuilderComponents(Article ar,com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
        setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:fbfcfe;");
        setTitle("BLOG UNIQUE");
        
        ArticleService rs = new ArticleService();
        ArrayList<Article> p = rs.getSingleArticle(ar);

       Container c = new Container(new BoxLayout(BoxLayout.X_AXIS));        
                Label label = new Label();
                //int deviceWidth = Display.getInstance().getDisplayWidth() / 4;
                Image placeholder = Image.createImage(500, 400); 
                EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
                label.setIcon(URLImage.createToStorage(encImage,
                        "Large_" + "http://localhost/ProjetWeb3A19_3/CyclingProjet/CyclePro/web/Frontend/images/blog/"
                                + ar.getPhoto()
                        + "", "http://localhost/ProjetWeb3A19_3/CyclingProjet/CyclePro/web/Frontend/images/blog/"
                                + ar.getPhoto()
                        + "", URLImage.RESIZE_SCALE_TO_FILL));
                c.add(label);
                
        Container single=new Container(BoxLayout.y());  
                Container aimeShare=new Container(BoxLayout.x());
                        //aime
                        Container aimeCont=new Container(BoxLayout.x()); 
                        Label nbrLike=new Label();
                        int nbr=ar.getLikes();
                        nbrLike.setText("" + nbr);
                        Button aime=new Button("J'aime");
                        aime.addActionListener((evt)->{
                        ArticleService sa=new ArticleService();
                        sa.AddLike(ar);
                        ArrayList<Article>art=sa.getSingleArticle(ar);
                        aime.setEnabled(false);
                        for (Article pr : art) {
                        int nbrr=pr.getLikes();
                        nbrLike.setText("" + nbrr);}  
                        });
                        aimeCont.add(nbrLike);
                        aimeCont.add(aime);
                
                        //share
                        Container share=new Container(BoxLayout.x());
                        Button partage = new Button();
                        partage.setIcon(FontImage.createMaterial(FontImage.MATERIAL_SHARE, 
                        partage.getUnselectedStyle()));    
                        partage.addActionListener((evt) -> {
                        Display.getInstance().execute("https://www.facebook.com/sharer/sharer.php?u="
                        + "http://127.0.0.1:8000/ArticleUser/singleArticle/"+ar.getId());
                        });
                        share.add(partage);
            aimeShare.addAll(aimeCont,share);   
                        
                        //détail article
                        Container cat = new Container(new BoxLayout(BoxLayout.X_AXIS));
                        Label catLab=new Label("Catégorie :");
                        cat.add(catLab);
                        cat.add(ar.getCategory());

                        Container tit = new Container(new BoxLayout(BoxLayout.X_AXIS));
                        Label titLab=new Label("Titre :");
                        tit.add(titLab);
                        tit.add(ar.getTitre());

                        Container aut = new Container(new BoxLayout(BoxLayout.X_AXIS));
                        Label autLab=new Label("Auteur :");
                        aut.add(autLab);
                        aut.add(ar.getAuteur());

                        Container cont = new Container(new BoxLayout(BoxLayout.X_AXIS));
                        SpanLabel contLab=new SpanLabel("Contenu :");
                        cont.add(contLab);
                        cont.add(ar.getContenue());  
                       
                        //favoris
                        Container favCont=new Container(BoxLayout.x());
                        Button fav=new Button("Ajouter à mes favoris");
                        fav.setIcon(FontImage.createMaterial(FontImage.MATERIAL_LOCAL_ATTRACTION, 
                        fav.getUnselectedStyle())); 
                        fav.addActionListener( (evt)-> {
                        FavoritService FS=new FavoritService();
                        FavoriArticle F=new FavoriArticle();
                        F.setArticle(ar.getId());
                        F.setUser(1);
                        fav.setEnabled(false);
                                if (FS.AddFavorit(F)) {
                                Dialog.show("SUCCESS", "L'article est ajouté à votre liste des favoris", "OK", null);
                                } else {
                                Dialog.show("ERROR", "Erreur", "OK", null);
                                }
                                }  );
                        favCont.add(fav);
                        
                        //commentaire
                        Container Comtcont=new Container(BoxLayout.y());
                        Comtcont.getAllStyles().setBorder(Border.createGrooveBorder(2));
                        
                        TextField comtxt = new TextField("","Votre commentaire...");       
                        Validator v = new Validator();
                        v.addConstraint(comtxt, new LengthConstraint(5));
                        
                        Comtcont.add(comtxt);
                        
                        Button btnaddComment = new Button("Commenter");
                        btnaddComment.setIcon(FontImage.createMaterial(FontImage.MATERIAL_ADD_COMMENT, 
                        btnaddComment.getUnselectedStyle())); 
                        Comtcont.add(btnaddComment);
                        
                        v.addSubmitButtons(btnaddComment);
       
                            btnaddComment.addActionListener((evt) -> {
                            if ((v.isValid())) {
                            CommentaireArticle com = new CommentaireArticle(ar.getId(),1,comtxt.getText());
                            CommentService CS= new CommentService();        
                            Label C1=new Label();
                            C1.setText(comtxt.getText());
                            Comtcont.add(C1);

                            if (CS.AddComment(com)) {
                            Dialog.show("SUCCESS", "Votre commentaire est ajouté", "OK", null);
                            } else {
                            Dialog.show("ERROR", "Server error", "OK", null);
                            }
                            }
                            });

        single.add(c);                
        single.add(cat);
        single.add(tit);
        single.add(aut);
        single.add(cont);
        single.add(aimeShare);
        single.add(favCont);
        single.add(Comtcont);
    add(single);
        
 
           }


}
