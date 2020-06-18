/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Reclamation;

import Forms.Accessoire.Accessoire2;
import Forms.Accessoire.Accessoire3;
import Forms.BaseForm;
import Services.Reclamation.ReclamationService;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author pc
 */
public class AffichageReclamation extends BaseForm {
    private Resources theme;

    public AffichageReclamation() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public AffichageReclamation(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
          theme = UIManager.initNamedTheme("/theme", "Theme1");
                List<Button> list_button = new ArrayList<Button>();
        List<Form> list_form = new ArrayList<Form>();
        list_button.add(new Button("manger"));
        list_button.add(new Button("Boire"));

        list_form.add(new Accessoire2());
        list_form.add(new Accessoire3());
        
        ReclamationService rs = new ReclamationService() ; 
       //  if (rs.AfficheReclamation()
        
        
        
        

        
      
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("AffichageReclamation");
        setName("AffichageReclamation");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
