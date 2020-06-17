/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Shop;

import Models.Shop.Velo;
import Services.Shop.ShopService;
import com.codename1.components.ImageViewer;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yasmine
 */
public class ProduitsListForm extends Form {
    
 Form f;
    
    ShopService shopService =new ShopService();
    
    ArrayList<Velo> produit = shopService.getAllTasks();
    
    private Resources theme ;
    
     
    public ProduitsListForm(Form previous){
        
        
    
    ShopService shopService =new ShopService();
         theme = UIManager.initNamedTheme("/theme", "Theme2"); 
        
        this.setLayout(BoxLayout.y());
                
                for (Velo p : produit){
                    
                    add(AddItems(p));
                
                 
                    show();
    }
                
                
                //add(AddItems(new ProduitAchat("2121", "aaaa", 54, 21)));
     getToolbar().addCommandToLeftBar("Back",null,ev ->{
            previous.showBack();
        });
        
   /*public ProduitsListForm(Form previous ) {
        
         
        
        super("Produits list", BoxLayout.y());
        

        this.add(new SpanLabel(new ServiceProduitAchat().getAllProduits().toString()));

          
        
       
        this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
            previous.showBack();
        });
        
        
    */

   
   /* public Container addProduit (ProduitAchat produit){
        
        Container holder = new Container (BoxLayout.x());
        
        Container cntDetails = new Container(BoxLayout.y());
        
        Label titre = new Label(produit.getLibelle());
        
        cntDetails.add(titre);
        
    return holder;
}*/
   
   
        
    }
    
    public Container AddItems( Velo p) {
        
       // Resources theme = UIManager.initFirstTheme("/theme");
         theme = UIManager.initNamedTheme("/theme", "Theme2"); 
        Container item = new Container(BoxLayout.x());
        
     
        
        
        Container data = new Container (BoxLayout.y());
        
        Label name = new Label ("Marque : ");
        Label tfname = new Label(p.getMarque());
        
        Container libelle = new Container (BoxLayout.x());
        
        libelle.add(name);
        libelle.add(tfname);
        
        data.add(libelle); 
          EncodedImage enco = EncodedImage.createFromImage(theme.getImage("audi.png"),false);
        
        String url = "http://localhost:1020/ProjetWeb3A19/CyclingProjet/CyclePro/web/Frontend/images/store/"+p.getPhotoV();
      Image im =URLImage.createToStorage(enco,p.getPhotoV(), url); 
      
       ImageViewer imv = new ImageViewer(im);
    
         item.add(imv);

          Label prix = new Label ("Prix : ");

        Label Lprix = new Label(Double.toString(p.getPrixAchat()));
        
        Container prixC = new Container (BoxLayout.x()); 
        
        prixC.add(prix);
        prixC.add(Lprix);
        
        data.add(prixC);
         

        Button btn  = new Button ("Ajouter au Favories");
        
        btn.addPointerReleasedListener(ev-> {
        Dialog.setDefaultBlurBackgroundRadius(15);
        
        if(Dialog.show("Confirmation", "Ajouter "+ p.getMarque()+ " au favories","oui","non")){

                shopService.favProduit(p);
                //api
          Message m = new Message("Forum Created");
          Display.getInstance().sendMessage(new String[] {"cycleproprojet@gmail.com"}, "liste de fav", m);
               
          System.out.println("Insertion OK ! ");
          Dialog.show("Success", "Produit ajouté", "OK" , null); 
          
        }
        
        
        });        
        
        data.add(btn);
        item.add(data);
   
        return item;
        
        
       
    }

}
       

      
        
    

          
       
    

