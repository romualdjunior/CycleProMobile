/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Shop;

import Models.Shop.Velo;
import Services.Shop.ShopService;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Yasmine
 */
public class Shop3Form extends Form{
    ShopService sa = new ShopService();
    private Resources theme;
     public Shop3Form() {
      ScaleImageLabel sl = new ScaleImageLabel();
     // Container contenant = BoxLayout.encloseY();
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
          Container contenant = BoxLayout.encloseY();
        //Container aff =new Container(BoxLayout.y());
        
        for(Velo v : sa.getAllTasks()){
             Container cat =new Container(BoxLayout.y());
             Container carte = new Container(BoxLayout.x());
       
       //      
             Label marque = new Label(v.getMarque());
           
        
            
             
             Label V = new Label(v.toString());
          
             cat.addAll( marque);
          
             // ImageViewer i = new ImageViewer(theme2.getImage("iconLettre.png").scaled(300, 300));
          //  ImageViewer i = new ImageViewer(img);
              carte.addAll(cat);
            
              
               contenant.add(carte);
        // aff.add(carte);
        //this.add(new SpanLabel(new ServiceChauffeur().getAllTasks().toString()));
        }}

    
}
       
    
    
     
