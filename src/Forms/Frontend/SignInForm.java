/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Frontend;

import Forms.BaseForm;
import Forms.Commande.ShopForm;
import Services.User.UserService;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.RadioButtonList;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Sheet;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 * GUI builder created Form
 *
 * @author toshiba
 */
public class SignInForm extends Form {

    String tmp = "";

    public SignInForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public SignInForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        gui_login.addActionListener((evt) -> {
            if ((gui_username.getText().length() == 0) || (gui_password.getText().length() == 0)) {
                Dialog.show("Alert", "Please fill all the fields", "OK", null);
            } else {
                try {
                    tmp = new UserService().connection(gui_username.getText(), gui_password.getText());

                    if (tmp.startsWith("Utilisateur existant")) {

                        if (Dialog.show("SUCCESS", tmp, "OK", null)) {
                            new ShopForm(resourceObjectInstance).show();
                        }

                    } else {
                        Dialog.show("ERROR", tmp, "Reessayez", null);
                    }
                } catch (NumberFormatException e) {
                    Dialog.show("ERROR", "Status must be a number", "OK", null);
                }

            }
        });

      

    }

   

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_username = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_password = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_login  = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:ffffff;");
        setTitle("SignIn");
        setName("SignIn");
        gui_Label.setPreferredSizeStr("137.03703mm 131.21693mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:Top Photo.png;");
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("12.698413mm 16.666666mm");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("bgImage:Logo.png;");
        gui_Label_1.setName("Label_1");
        gui_Label_2.setPreferredSizeStr("30.68783mm inherit");
        gui_Label_2.setText("Cyclisme,");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:6.0mm native:MainRegular native:MainRegular; bgColor:0; fgColor:0; opacity:219;");
        gui_Label_2.setName("Label_2");
        gui_Label_3.setPreferredSizeStr("41.534393mm inherit");
        gui_Label_3.setText("Ev\u00E8nement,V\u00E9lo");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("font:4.0mm native:MainRegular native:MainRegular; bgColor:0; fgColor:0; opacity:219;");
        gui_Label_3.setName("Label_3");
        gui_username.setPreferredSizeStr("58.99471mm 9.259259mm");
        gui_username.setHint("Username");
                gui_username.setInlineStylesTheme(resourceObjectInstance);
        gui_username.setInlineAllStyles("border:roundRect stroke(0.2mm 42777777) +top-left +top-right +bottom-left +bottom-right 1.0mm;");
        gui_username.setName("username");
        gui_username.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue7fd".charAt(0), gui_username.getUnselectedStyle()));
        gui_password.setPreferredSizeStr("58.201057mm 10.8465605mm");
        gui_password.setHint("Password");
                gui_password.setInlineStylesTheme(resourceObjectInstance);
        gui_password.setInlineAllStyles("border:roundRect stroke(0.2mm 42777777) +top-left +top-right +bottom-left +bottom-right 1.0mm;");
        gui_password.setName("password");
        gui_password.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue897".charAt(0), gui_password.getUnselectedStyle()));
        gui_login .setPreferredSizeStr("59.52381mm 10.58201mm");
                gui_login .setInlineStylesTheme(resourceObjectInstance);
        gui_login .setInlineAllStyles("bgImage:Login me.png;");
        gui_login .setName("login ");
        gui_Label_4.setPreferredSizeStr("26.190475mm inherit");
        gui_Label_4.setText("pas de compte?");
                gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setInlineAllStyles("font:3.0mm native:MainLight native:MainLight; bgColor:0; fgColor:0; opacity:219;");
        gui_Label_4.setName("Label_4");
        gui_Button_1.setText("Inscrivez vous!");
                gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setInlineAllStyles("font:3.0mm; fgColor:0;");
        gui_Button_1.setName("Button_1");
        addComponent(gui_Label);
        addComponent(gui_Label_1);
        addComponent(gui_Label_2);
        addComponent(gui_Label_3);
        addComponent(gui_username);
        addComponent(gui_password);
        addComponent(gui_login );
        addComponent(gui_Label_4);
        addComponent(gui_Button_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "-60.58202mm -69.57671mm auto 2.3809521mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "53.452686% 77.99228% 40.79284% 5.5555553mm").setReferenceComponents(gui_Label_1, "0 -1 -1 0 ").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "44.84629% auto auto 3.4391537mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 0 ").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "-0.7936508mm 34.552845% auto 0.0mm").setReferenceComponents(gui_Label_3, "2 -1 -1 2 ").setReferencePositions(gui_Label_3, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_username.getParent().getLayout()).setInsets(gui_username, "auto 3.968254mm 30.018085% 0.0mm").setReferenceComponents(gui_username, "-1 -1 -1 2 ").setReferencePositions(gui_username, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_password.getParent().getLayout()).setInsets(gui_password, "1.3227539mm 3.4391537mm 70.55215% 0.0mm").setReferenceComponents(gui_password, "4 -1 -1 2 ").setReferencePositions(gui_password, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_login .getParent().getLayout()).setInsets(gui_login , "2.910057mm 3.968254mm 54.62963% 1.3227513mm").setReferenceComponents(gui_login , "5 -1 -1 2 ").setReferencePositions(gui_login , "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_4.getParent().getLayout()).setInsets(gui_Label_4, "93.49005% auto 1.5873009mm 0.0mm").setReferenceComponents(gui_Label_4, "-1 2 -1 1 ").setReferencePositions(gui_Label_4, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button_1.getParent().getLayout()).setInsets(gui_Button_1, "auto 2.910053mm 0.7936508mm auto").setReferenceComponents(gui_Button_1, "-1 6 7 -1").setReferencePositions(gui_Button_1, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
