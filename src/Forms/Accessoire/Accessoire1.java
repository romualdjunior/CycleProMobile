/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Accessoire;

import Forms.BaseForm;
import Forms.Frontend.SignInForm;
import Forms.Frontend.WalkthruForm;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class Accessoire1 extends BaseForm{
private Resources theme;
    public Accessoire1() {
                theme = UIManager.initNamedTheme("/theme", "Theme1");
                List<Button> list_button = new ArrayList<Button>();
        List<Form> list_form = new ArrayList<Form>();
        list_button.add(new Button("manger"));
        list_button.add(new Button("Boire"));

        list_form.add(new Accessoire2());
        list_form.add(new Accessoire3());

        installSidemenu(theme, list_button, list_form);
        
        

    }
    @Override
      protected boolean is_current_accessoire() {
        return true;
    }
    
}
