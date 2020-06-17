/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Shop;

import Models.Shop.Velo;
import Services.Shop.ShopService;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yasmine
 */
public class FavoriesForm extends Form {
    

    ShopService shopService = new ShopService();
    private  ShopService ligneC;
      private Resources theme; 
      
    private List<Velo> ListProduit ;
    public FavoriesForm (Form previous){
        
        setTitle("Favories");
        
         ligneC = new ShopService();
        ListProduit = new ArrayList<>();
   
    
     ListProduit = ligneC.getFavoris();
    
    for(int i = 0 ; i < ListProduit.size(); i++){
        
        add(this.AddProduit(ListProduit.get(i)));
    }
   getToolbar().addCommandToLeftBar("Back",null,ev ->{
            previous.showBack();
        });
    getToolbar().addCommandToOverflowMenu("Supprimer tous",null , (evt) -> {
            
             try{
                 shopService.deleteFavAll();
                 this.refreshLayout();
             }catch(IOException ex){
                 
                 System.out.println(ex.getMessage());;
                 
                 
             }
         });
    }
  public void refreshLayout(){
    
    this.removeAll();
    
   ListProduit =  ligneC.getFavoris();
   
   for(int i = 0 ; i < ListProduit.size(); i++){
        
        this.add(this.AddProduit(ListProduit.get(i)));
    }
    
    this.revalidate();
}    
       public Container AddProduit (Velo p){
            theme = UIManager.initNamedTheme("/theme", "Theme2"); 
           Container item = new Container(BoxLayout.x());
        EncodedImage enco = EncodedImage.createFromImage(theme.getImage("audi.png"), false);
        
        String url = "http://localhost:1020/ProjetWeb3A19/CyclingProjet/CyclePro/web/Frontend/images/store/"+p.getPhotoV();
        Image im =URLImage.createToStorage(enco,p.getPhotoV(), url); 
        
        ImageViewer imv = new ImageViewer(im);
         item.add(imv);
        
        
        
        
        Container data = new Container (BoxLayout.y());
        
        Label name = new Label ("Marque : ");
        
        
        
        Label tfname = new Label(p.getMarque());
        
        Container libelle = new Container (BoxLayout.x());
        
        libelle.add(name);
        libelle.add(tfname);
        
        data.add(libelle);
        
        
        
        
        
          Label prix = new Label ("Prix : ");
        
        
       
        
        Label Lprix = new Label(Double.toString(p.getPrixAchat()));
        
        Container prixC = new Container (BoxLayout.x());
        
        prixC.add(prix);
        prixC.add(Lprix);
        
        data.add(prixC);
        
        
        
        
        
     
        
        
          
       Button delete = new Button("Supprimer");
          
          
          
          delete.addPointerReleasedListener(ev -> {
              if(Dialog.show("Confirmation"," Supprimer "+p.getMarque()+" de la liste des favories  ?" ,"Oui","Non")){
                  
                  try{
                      shopService.deleteFav(p);
                     FavoriesForm.this.refreshLayout();
                     
                     System.out.println("Suppression OK ! ");
                     
                  }catch( IOException ex){
                      
                      Dialog.show(("Erreur"),"Erreur de suppression" ,"Oui", null);
                  }
                  
              }
          });
        
          data.add(delete);
        
        
        
        item.add(data);
        
        return item;
        
        
}}
    
    

