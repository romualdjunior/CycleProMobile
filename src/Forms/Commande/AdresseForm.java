/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Commande;

import Forms.BaseForm;
import Forms.Frontend.SignInForm;
import Forms.Frontend.WalkthruForm;
import Models.Commande.Adresse;
import Services.Commande.AdresseService;
import com.codename1.io.Storage;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author toshiba
 */
public class AdresseForm extends BaseForm {

    public AdresseForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public AdresseForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

        List<Button> list_button = new ArrayList<Button>();
        List<Form> list_form = new ArrayList<Form>();
        list_button.add(new Button("manger"));
        list_button.add(new Button("Boire"));

        list_form.add(new SignInForm(resourceObjectInstance));
        list_form.add(new WalkthruForm(resourceObjectInstance));

        installSidemenu(resourceObjectInstance, list_button, list_form);
        gui_valider.addActionListener((evt) -> {
            if (gui_nom.getText().length() == 0 || gui_prenom.getText().length() == 0 || gui_phone.getText().length() == 0 || gui_email.getText().length() == 0 || gui_pays.getText().length() == 0 || gui_ville.getText().length() == 0 || gui_etat.getText().length() == 0 || gui_pincode.getText().length() == 0 || gui_adresse.getText().length() == 0) {
                Dialog.show("Alert", "Please fill all the fields", "OK", null);

            } else {
                try {
                    if (new AdresseService().addAdresse(new Adresse(gui_nom.getText(), gui_prenom.getText(), Integer.parseInt(gui_phone.getText()), gui_email.getText(), gui_pays.getText(), gui_ville.getText(), gui_etat.getText(), Integer.parseInt(gui_pincode.getText()), gui_adresse.getText()))) {
                        if (Dialog.show("Alert", "Adresse ajoutée avec succès", "OK", null)) {
                            Message m = new Message("Body of message");
                            m.getAttachments().put("texte", "text/plain");
                            m.getAttachments().put("image", "image/png");
                            Display.getInstance().sendMessage(new String[]{"romuald.motchehokamguia@esprit.tn"}, "Subject of message", m);
                        }

                    } else {
                        Dialog.show("Alert", "Erreur Serveur", "OK", null);

                    }
                } catch (NumberFormatException e) {
                }
            }
        });
    }
    @Override
      protected boolean is_current_adresse() {
        return true;
    }

//////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_commande_image = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_X = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_phone_label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_phone = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_adresse_label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_adresse = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_pincode_label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_pincode = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_etat_label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_etat = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_ville_label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_ville = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X_5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_pays_label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_pays = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X_6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_email_label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_email = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X_7 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Label_7 = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_nom = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X_8 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_prenom_label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_prenom = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_valider = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:fbfcfe;");
        setTitle("CommandeForm");
        setName("CommandeForm");
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredWidthMM((float)70.899475);
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredHeightMM((float)146.2963);
        addComponent(gui_commande_image);
        addComponent(gui_Box_Layout_X);
        gui_Box_Layout_X.setPreferredSizeStr("51.587303mm 7.4074073mm");
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setName("Box_Layout_X");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X.getParent().getLayout()).setInsets(gui_Box_Layout_X, "38.517178% 17.537312% auto 10.074629%").setReferenceComponents(gui_Box_Layout_X, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X.addComponent(gui_phone_label);
        gui_Box_Layout_X.addComponent(gui_phone);
        gui_phone_label.setText("Phone:");
                gui_phone_label.setInlineStylesTheme(resourceObjectInstance);
        gui_phone_label.setName("phone_label");
                gui_phone.setInlineStylesTheme(resourceObjectInstance);
        gui_phone.setName("phone");
        addComponent(gui_Box_Layout_X_1);
        gui_Box_Layout_X_1.setPreferredSizeStr("51.851852mm 7.4074073mm");
                gui_Box_Layout_X_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_1.setName("Box_Layout_X_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_1.getParent().getLayout()).setInsets(gui_Box_Layout_X_1, "auto 19.997654% 13.562387% 5.026455mm").setReferenceComponents(gui_Box_Layout_X_1, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_1, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_1.addComponent(gui_adresse_label);
        gui_Box_Layout_X_1.addComponent(gui_adresse);
        gui_adresse_label.setText("Adresse:");
                gui_adresse_label.setInlineStylesTheme(resourceObjectInstance);
        gui_adresse_label.setName("adresse_label");
                gui_adresse.setInlineStylesTheme(resourceObjectInstance);
        gui_adresse.setName("adresse");
        addComponent(gui_Box_Layout_X_2);
        gui_Box_Layout_X_2.setPreferredSizeStr("51.851852mm 7.142857mm");
                gui_Box_Layout_X_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_2.setName("Box_Layout_X_2");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_2.getParent().getLayout()).setInsets(gui_Box_Layout_X_2, "auto 19.997652% 20.253166% 5.026455mm").setReferenceComponents(gui_Box_Layout_X_2, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_2, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_2.addComponent(gui_pincode_label);
        gui_Box_Layout_X_2.addComponent(gui_pincode);
        gui_pincode_label.setText("PIncode:");
                gui_pincode_label.setInlineStylesTheme(resourceObjectInstance);
        gui_pincode_label.setName("pincode_label");
                gui_pincode.setInlineStylesTheme(resourceObjectInstance);
        gui_pincode.setName("pincode");
        addComponent(gui_Box_Layout_X_3);
        gui_Box_Layout_X_3.setPreferredSizeStr("49.4709mm 7.4074073mm");
                gui_Box_Layout_X_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_3.setName("Box_Layout_X_3");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_3.getParent().getLayout()).setInsets(gui_Box_Layout_X_3, "auto 19.62452% 26.58228% 10.972496%").setReferenceComponents(gui_Box_Layout_X_3, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_3, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_3.addComponent(gui_etat_label);
        gui_Box_Layout_X_3.addComponent(gui_etat);
        gui_etat_label.setText("Etat:    ");
                gui_etat_label.setInlineStylesTheme(resourceObjectInstance);
        gui_etat_label.setName("etat_label");
                gui_etat.setInlineStylesTheme(resourceObjectInstance);
        gui_etat.setName("etat");
        addComponent(gui_Box_Layout_X_4);
        gui_Box_Layout_X_4.setPreferredSizeStr("49.73545mm 7.6719575mm");
                gui_Box_Layout_X_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_4.setName("Box_Layout_X_4");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_4.getParent().getLayout()).setInsets(gui_Box_Layout_X_4, "auto 19.62452% 33.453888% 10.599361%").setReferenceComponents(gui_Box_Layout_X_4, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_4, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_4.addComponent(gui_ville_label);
        gui_Box_Layout_X_4.addComponent(gui_ville);
        gui_ville_label.setText("Ville:    ");
                gui_ville_label.setInlineStylesTheme(resourceObjectInstance);
        gui_ville_label.setName("ville_label");
                gui_ville.setInlineStylesTheme(resourceObjectInstance);
        gui_ville.setName("ville");
        addComponent(gui_Box_Layout_X_5);
        gui_Box_Layout_X_5.setPreferredSizeStr("50.0mm 7.6719575mm");
                gui_Box_Layout_X_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_5.setName("Box_Layout_X_5");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_5.getParent().getLayout()).setInsets(gui_Box_Layout_X_5, "auto 19.251385% 41.59132% 10.599361%").setReferenceComponents(gui_Box_Layout_X_5, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_5, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_5.addComponent(gui_pays_label);
        gui_Box_Layout_X_5.addComponent(gui_pays);
        gui_pays_label.setText("Pays:   ");
                gui_pays_label.setInlineStylesTheme(resourceObjectInstance);
        gui_pays_label.setName("pays_label");
                gui_pays.setInlineStylesTheme(resourceObjectInstance);
        gui_pays.setName("pays");
        addComponent(gui_Box_Layout_X_6);
        gui_Box_Layout_X_6.setPreferredSizeStr("50.529102mm 7.936508mm");
                gui_Box_Layout_X_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_6.setName("Box_Layout_X_6");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_6.getParent().getLayout()).setInsets(gui_Box_Layout_X_6, "45.04103% 18.505116% auto 10.599361%").setReferenceComponents(gui_Box_Layout_X_6, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_6, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_6.addComponent(gui_email_label);
        gui_Box_Layout_X_6.addComponent(gui_email);
        gui_email_label.setText("Email:  ");
                gui_email_label.setInlineStylesTheme(resourceObjectInstance);
        gui_email_label.setName("email_label");
                gui_email.setInlineStylesTheme(resourceObjectInstance);
        gui_email.setName("email");
        addComponent(gui_Box_Layout_X_7);
        gui_Box_Layout_X_7.setPreferredSizeStr("51.851852mm 7.4074073mm");
                gui_Box_Layout_X_7.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_7.setName("Box_Layout_X_7");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_7.getParent().getLayout()).setInsets(gui_Box_Layout_X_7, "25.149532% 16.791044% auto 10.074628%").setReferenceComponents(gui_Box_Layout_X_7, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_7, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_7.addComponent(gui_Label_7);
        gui_Box_Layout_X_7.addComponent(gui_nom);
        gui_Label_7.setText("Nom:   ");
                gui_Label_7.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_7.setName("Label_7");
                gui_nom.setInlineStylesTheme(resourceObjectInstance);
        gui_nom.setName("nom");
        addComponent(gui_Box_Layout_X_8);
        gui_Box_Layout_X_8.setPreferredSizeStr("53.703705mm 7.4074073mm");
                gui_Box_Layout_X_8.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_8.setName("Box_Layout_X_8");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_8.getParent().getLayout()).setInsets(gui_Box_Layout_X_8, "32.201973% 17.910444% auto 4.7619047mm").setReferenceComponents(gui_Box_Layout_X_8, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_8, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_8.addComponent(gui_prenom_label);
        gui_Box_Layout_X_8.addComponent(gui_prenom);
        gui_prenom_label.setText("Prenom:");
                gui_prenom_label.setInlineStylesTheme(resourceObjectInstance);
        gui_prenom_label.setName("prenom_label");
                gui_prenom.setInlineStylesTheme(resourceObjectInstance);
        gui_prenom.setName("prenom");
        addComponent(gui_valider);
        gui_commande_image.setPreferredSizeStr("28.571428mm 25.396826mm");
                gui_commande_image.setInlineStylesTheme(resourceObjectInstance);
        gui_commande_image.setInlineAllStyles("bgImage:6974122_preview.png;");
        gui_commande_image.setName("commande_image");
        ((com.codename1.ui.layouts.LayeredLayout)gui_commande_image.getParent().getLayout()).setInsets(gui_commande_image, "1.5873017mm auto auto 28.35821%").setReferenceComponents(gui_commande_image, "-1 -1 -1 -1").setReferencePositions(gui_commande_image, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X.setPreferredSizeStr("51.587303mm 7.4074073mm");
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setName("Box_Layout_X");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X.getParent().getLayout()).setInsets(gui_Box_Layout_X, "38.517178% 17.537312% auto 10.074629%").setReferenceComponents(gui_Box_Layout_X, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_1.setPreferredSizeStr("51.851852mm 7.4074073mm");
                gui_Box_Layout_X_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_1.setName("Box_Layout_X_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_1.getParent().getLayout()).setInsets(gui_Box_Layout_X_1, "auto 19.997654% 13.562387% 5.026455mm").setReferenceComponents(gui_Box_Layout_X_1, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_1, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_2.setPreferredSizeStr("51.851852mm 7.142857mm");
                gui_Box_Layout_X_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_2.setName("Box_Layout_X_2");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_2.getParent().getLayout()).setInsets(gui_Box_Layout_X_2, "auto 19.997652% 20.253166% 5.026455mm").setReferenceComponents(gui_Box_Layout_X_2, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_2, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_3.setPreferredSizeStr("49.4709mm 7.4074073mm");
                gui_Box_Layout_X_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_3.setName("Box_Layout_X_3");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_3.getParent().getLayout()).setInsets(gui_Box_Layout_X_3, "auto 19.62452% 26.58228% 10.972496%").setReferenceComponents(gui_Box_Layout_X_3, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_3, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_4.setPreferredSizeStr("49.73545mm 7.6719575mm");
                gui_Box_Layout_X_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_4.setName("Box_Layout_X_4");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_4.getParent().getLayout()).setInsets(gui_Box_Layout_X_4, "auto 19.62452% 33.453888% 10.599361%").setReferenceComponents(gui_Box_Layout_X_4, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_4, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_5.setPreferredSizeStr("50.0mm 7.6719575mm");
                gui_Box_Layout_X_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_5.setName("Box_Layout_X_5");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_5.getParent().getLayout()).setInsets(gui_Box_Layout_X_5, "auto 19.251385% 41.59132% 10.599361%").setReferenceComponents(gui_Box_Layout_X_5, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_5, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_6.setPreferredSizeStr("50.529102mm 7.936508mm");
                gui_Box_Layout_X_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_6.setName("Box_Layout_X_6");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_6.getParent().getLayout()).setInsets(gui_Box_Layout_X_6, "45.04103% 18.505116% auto 10.599361%").setReferenceComponents(gui_Box_Layout_X_6, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_6, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_7.setPreferredSizeStr("51.851852mm 7.4074073mm");
                gui_Box_Layout_X_7.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_7.setName("Box_Layout_X_7");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_7.getParent().getLayout()).setInsets(gui_Box_Layout_X_7, "25.149532% 16.791044% auto 10.074628%").setReferenceComponents(gui_Box_Layout_X_7, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_7, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X_8.setPreferredSizeStr("53.703705mm 7.4074073mm");
                gui_Box_Layout_X_8.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_8.setName("Box_Layout_X_8");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X_8.getParent().getLayout()).setInsets(gui_Box_Layout_X_8, "32.201973% 17.910444% auto 4.7619047mm").setReferenceComponents(gui_Box_Layout_X_8, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X_8, "0.0 0.0 0.0 0.0");
        gui_valider.setPreferredSizeStr("24.074074mm inherit");
        gui_valider.setText("Valider");
                gui_valider.setInlineStylesTheme(resourceObjectInstance);
        gui_valider.setInlineAllStyles("font:3.0mm native:MainLight native:MainLight; border:roundRect +top-left +top-right +bottom-left +bottom-right 3.0mm; bgColor:ffffff; fgColor:ffffff; bgImage:Background.png;");
        gui_valider.setName("valider");
        ((com.codename1.ui.layouts.LayeredLayout)gui_valider.getParent().getLayout()).setInsets(gui_valider, "auto auto 4.232804mm 31.343285%").setReferenceComponents(gui_valider, "-1 -1 -1 -1").setReferencePositions(gui_valider, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
