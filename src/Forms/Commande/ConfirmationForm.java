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
import Models.Commande.Commande;
import Models.Commande.Panier;
import Models.User.User;
import Services.Commande.CommandeService;
import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.ClientTokenRequest;
import com.braintreegateway.Environment;
import com.codename1.io.Storage;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GUI builder created Form
 *
 * @author toshiba
 */
public class ConfirmationForm extends BaseForm {

    private static BraintreeGateway gateway = new BraintreeGateway(
            Environment.SANDBOX,
            "p3fgq462vvx5sgdp",
            "2r7m3jq2tb6j92jt",
            "72ba3bdaa92d6c0e72e386cb17980c82"
    );

    public ConfirmationForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public ConfirmationForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        List<Button> list_button = new ArrayList<Button>();
        List<Form> list_form = new ArrayList<Form>();
        ChartDemosForm s = (ChartDemosForm) Storage.getInstance().readObject("Statistiques");
        list_button.add(new Button("Statistiques"));
        list_form.add(s.showChart(s.options[0]));

        installSidemenu(resourceObjectInstance, list_button, list_form);
        Adresse a = new Adresse();
        a = (Adresse) Storage.getInstance().readObject("Adresse");
        gui_Nom.setText(a.getNom());
        gui_prenom.setText(a.getPrenom());
        gui_phone.setText(Integer.toString(a.getPhone()));
        gui_Ville.setText(a.getVille());
        gui_adresse.setText(a.getAdresseLivraison());
        int sous_total = 0;
        List<Panier> panier = new ArrayList<Panier>();
        panier.addAll(((List<Panier>) Storage.getInstance().readObject("Panier")));
        for (Panier panier1 : panier) {
            sous_total += panier1.getPrix() * panier1.getQuantite();
        }
        gui_sous_total.setText(Integer.toString(sous_total) + "$");
        gui_shipping.setText("350$");
        gui_tva.setText("500$");
        int total = sous_total + 350 + 500;
        gui_total.setText(Integer.toString(total) + "$");
        gui_confirmer.addActionListener((e) -> {
            User user = (User) Storage.getInstance().readObject("User");
            if (new CommandeService().addCommande(new Commande(total, "nonpaye", user.getId()))) {
                Map<String, String> notifications = (Map<String, String>) Storage.getInstance().readObject("Notifications");
                notifications.put("Commande", "Votre commande a été validée avec succès");
                Storage.getInstance().writeObject("Notifications", notifications);
                LocalNotification ln = new LocalNotification();
                ln.setId("Commande");
                ln.setAlertTitle("CyclePro");
                ln.setAlertBody("Commande");
                Display.getInstance().scheduleLocalNotification(ln, System.currentTimeMillis(), LocalNotification.REPEAT_NONE);
                Message m = new Message("Votre commande a été validée avec succès");
                m.getAttachments().put("texte", "text/plain");
                m.getAttachments().put("image", "image/png");
                Display.getInstance().sendMessage(new String[]{"romuald.motchehokamguia@esprit.tn"}, "CyclePro ", m);
                Dialog.show("SUCCESS", "Commande ajoutée avec succès", "OK", null);
                if (Dialog.show("PAIEMENT", "Voulez vous effectuer le paiement?", "OK", "Cancel")) {
                     Map<String, String> notifications_2 = (Map<String, String>) Storage.getInstance().readObject("Notifications");
                        notifications_2.put("Paiement", "Votre Paiement a été effectuée avec succès");
                        Storage.getInstance().writeObject("Notifications", notifications_2);
                        LocalNotification ln2 = new LocalNotification();
                        ln2.setId("Paiement");
                        ln2.setAlertTitle("Paiement");
                        ln2.setAlertBody("Votre Paiement a été ajoutée avec succès!");
                        Display.getInstance().scheduleLocalNotification(ln, System.currentTimeMillis(), LocalNotification.REPEAT_NONE);
                    Purchase.startOrder(new Purchase.Callback() {
                        @Override
                        public String fetchToken() {
                            ClientTokenRequest clientTokenRequest = new ClientTokenRequest();
                            String clientToken = gateway.clientToken().generate(clientTokenRequest);
                            return clientToken;
                        }

                        @Override
                        public void onPurchaseSuccess(String nonce) {
                            System.out.println("vivre");
                        }

                        @Override
                        public void onPurchaseFail(String errorMessage) {
                            System.out.println("manger");
                        }

                        @Override
                        public void onPurchaseCancel() {
                            System.out.println("boire");
                        }
                    });
                }

            } else {
                Dialog.show("ERROR", "Commande non ajoutée erreur", "Reessayez", null);
            }

        });

    }

//////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_X = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Nom = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_X_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_prl = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_prenom  = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_X_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_pl = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_phone = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_X_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Pays  = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_X_5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Ville = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_X_8 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Label_9 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_adresse = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_Y_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_X_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_sous_total = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_X_3_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Label_2_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_shipping = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_X_3_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Label_2_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_tva = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_X_6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Label_7 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_X_9 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Label_10 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_total = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_confirmer = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:fbfcfe;");
        setTitle("ConfirmationForm");
        setName("ConfirmationForm");
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredWidthMM((float)70.899475);
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredHeightMM((float)146.2963);
        addComponent(gui_Box_Layout_Y);
        gui_Box_Layout_Y.setPreferredSizeStr("49.73545mm 56.878307mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setInlineAllStyles("bgImage:Mask.png; alignment:center; padding:7px 0px 10px 10px;");
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "4.4973545mm 16.791046% 58.156357% 13.059702%").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_Y.addComponent(gui_Label_3);
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X);
        gui_Box_Layout_X.setPreferredSizeStr("36.243385mm inherit");
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setInlineAllStyles("alignment:left; padding:0px 0px 0px 7px;");
        gui_Box_Layout_X.setName("Box_Layout_X");
        gui_Box_Layout_X.addComponent(gui_Label);
        gui_Box_Layout_X.addComponent(gui_Nom);
        gui_Label.setText("Nom:     ");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("font:3.5mm native:MainBold native:MainBold;");
        gui_Label.setName("Label");
        gui_Nom.setText("Romuald");
                gui_Nom.setInlineStylesTheme(resourceObjectInstance);
        gui_Nom.setInlineAllStyles("font:3.5mm;");
        gui_Nom.setName("Nom");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X_1);
        gui_Box_Layout_X_1.setPreferredSizeStr("36.243385mm inherit");
                gui_Box_Layout_X_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_1.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_1.setName("Box_Layout_X_1");
        gui_Box_Layout_X_1.addComponent(gui_prl);
        gui_Box_Layout_X_1.addComponent(gui_prenom );
        gui_prl.setText("Prenom:");
                gui_prl.setInlineStylesTheme(resourceObjectInstance);
        gui_prl.setInlineAllStyles("font:3.5mm native:MainBold native:MainBold;");
        gui_prl.setName("prl");
        gui_prenom .setText("Romuald");
                gui_prenom .setInlineStylesTheme(resourceObjectInstance);
        gui_prenom .setInlineAllStyles("font:3.5mm;");
        gui_prenom .setName("prenom ");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X_2);
        gui_Box_Layout_X_2.setPreferredSizeStr("36.243385mm inherit");
                gui_Box_Layout_X_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_2.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_2.setName("Box_Layout_X_2");
        gui_Box_Layout_X_2.addComponent(gui_pl);
        gui_Box_Layout_X_2.addComponent(gui_phone);
        gui_pl.setText("Phone:   ");
                gui_pl.setInlineStylesTheme(resourceObjectInstance);
        gui_pl.setInlineAllStyles("font:3.5mm native:MainBold native:MainBold;");
        gui_pl.setName("pl");
        gui_phone.setText("Romuald");
                gui_phone.setInlineStylesTheme(resourceObjectInstance);
        gui_phone.setInlineAllStyles("font:3.5mm;");
        gui_phone.setName("phone");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X_4);
        gui_Box_Layout_X_4.setPreferredSizeStr("36.243385mm 8.730159mm");
                gui_Box_Layout_X_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_4.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_4.setName("Box_Layout_X_4");
        gui_Box_Layout_X_4.addComponent(gui_Label_5);
        gui_Box_Layout_X_4.addComponent(gui_Pays );
        gui_Label_5.setText("Pays:     ");
                gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setInlineAllStyles("font:3.5mm native:MainBold native:MainBold;");
        gui_Label_5.setName("Label_5");
        gui_Pays .setText("Romuald");
                gui_Pays .setInlineStylesTheme(resourceObjectInstance);
        gui_Pays .setInlineAllStyles("font:3.5mm;");
        gui_Pays .setName("Pays ");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X_5);
        gui_Box_Layout_X_5.setPreferredSizeStr("41.534393mm 5.820106mm");
                gui_Box_Layout_X_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_5.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_5.setName("Box_Layout_X_5");
        gui_Box_Layout_X_5.addComponent(gui_Label_6);
        gui_Box_Layout_X_5.addComponent(gui_Ville);
        gui_Label_6.setText("Ville:      ");
                gui_Label_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_6.setInlineAllStyles("font:3.5mm native:MainBold native:MainBold;");
        gui_Label_6.setName("Label_6");
        gui_Ville.setText("Romuald");
                gui_Ville.setInlineStylesTheme(resourceObjectInstance);
        gui_Ville.setInlineAllStyles("font:3.5mm;");
        gui_Ville.setName("Ville");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X_8);
        gui_Box_Layout_X_8.setPreferredSizeStr("36.243385mm 6.878307mm");
                gui_Box_Layout_X_8.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_8.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_8.setName("Box_Layout_X_8");
        gui_Box_Layout_X_8.addComponent(gui_Label_9);
        gui_Box_Layout_X_8.addComponent(gui_adresse);
        gui_Label_9.setText("Adresse:");
                gui_Label_9.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_9.setInlineAllStyles("font:3.5mm native:MainBold native:MainBold;");
        gui_Label_9.setName("Label_9");
        gui_adresse.setText("Romuald");
                gui_adresse.setInlineStylesTheme(resourceObjectInstance);
        gui_adresse.setInlineAllStyles("font:3.5mm;");
        gui_adresse.setName("adresse");
        gui_Label_3.setPreferredSizeStr("43.650795mm inherit");
        gui_Label_3.setText(" Adresse Livraison");
        gui_Label_3.setUIID("address_label");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("font:4.0mm native:MainBold native:MainBold; fgColor:fe7b37;");
        gui_Label_3.setName("Label_3");
        gui_Box_Layout_X.setPreferredSizeStr("36.243385mm inherit");
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setInlineAllStyles("alignment:left; padding:0px 0px 0px 7px;");
        gui_Box_Layout_X.setName("Box_Layout_X");
        gui_Box_Layout_X_1.setPreferredSizeStr("36.243385mm inherit");
                gui_Box_Layout_X_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_1.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_1.setName("Box_Layout_X_1");
        gui_Box_Layout_X_2.setPreferredSizeStr("36.243385mm inherit");
                gui_Box_Layout_X_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_2.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_2.setName("Box_Layout_X_2");
        gui_Box_Layout_X_4.setPreferredSizeStr("36.243385mm 8.730159mm");
                gui_Box_Layout_X_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_4.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_4.setName("Box_Layout_X_4");
        gui_Box_Layout_X_5.setPreferredSizeStr("41.534393mm 5.820106mm");
                gui_Box_Layout_X_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_5.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_5.setName("Box_Layout_X_5");
        gui_Box_Layout_X_8.setPreferredSizeStr("36.243385mm 6.878307mm");
                gui_Box_Layout_X_8.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_8.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_8.setName("Box_Layout_X_8");
        addComponent(gui_Box_Layout_Y_1);
        gui_Box_Layout_Y_1.setPreferredSizeStr("53.439156mm 55.555557mm");
                gui_Box_Layout_Y_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y_1.setInlineAllStyles("bgImage:Mask.png; padding:7px 0px 10px 10px;");
        gui_Box_Layout_Y_1.setName("Box_Layout_Y_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y_1.getParent().getLayout()).setInsets(gui_Box_Layout_Y_1, "45.75045% 7.936508mm 22.60398% 0.0mm").setReferenceComponents(gui_Box_Layout_Y_1, "-1 -1 -1 0 ").setReferencePositions(gui_Box_Layout_Y_1, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_Y_1.addComponent(gui_Label_4);
        gui_Box_Layout_Y_1.addComponent(gui_Box_Layout_X_3);
        gui_Box_Layout_X_3.setPreferredSizeStr("45.502647mm inherit");
                gui_Box_Layout_X_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_3.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_3.setName("Box_Layout_X_3");
        gui_Box_Layout_X_3.addComponent(gui_Label_2);
        gui_Box_Layout_X_3.addComponent(gui_sous_total);
        gui_Label_2.setText("Sous_Total: ");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:3.5mm native:MainBold native:MainBold;");
        gui_Label_2.setName("Label_2");
        gui_sous_total.setText("Romuald");
                gui_sous_total.setInlineStylesTheme(resourceObjectInstance);
        gui_sous_total.setInlineAllStyles("font:3.5mm;");
        gui_sous_total.setName("sous_total");
        gui_Box_Layout_Y_1.addComponent(gui_Box_Layout_X_3_1);
        gui_Box_Layout_X_3_1.setPreferredSizeStr("41.534393mm inherit");
                gui_Box_Layout_X_3_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_3_1.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_3_1.setName("Box_Layout_X_3_1");
        gui_Box_Layout_X_3_1.addComponent(gui_Label_2_1);
        gui_Box_Layout_X_3_1.addComponent(gui_shipping);
        gui_Label_2_1.setText("Shipping:      ");
                gui_Label_2_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2_1.setInlineAllStyles("font:3.5mm native:MainBold native:MainBold;");
        gui_Label_2_1.setName("Label_2_1");
        gui_shipping.setText("Romuald");
                gui_shipping.setInlineStylesTheme(resourceObjectInstance);
        gui_shipping.setInlineAllStyles("font:3.5mm;");
        gui_shipping.setName("shipping");
        gui_Box_Layout_Y_1.addComponent(gui_Box_Layout_X_3_2);
        gui_Box_Layout_X_3_2.setPreferredSizeStr("43.650795mm inherit");
                gui_Box_Layout_X_3_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_3_2.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_3_2.setName("Box_Layout_X_3_2");
        gui_Box_Layout_X_3_2.addComponent(gui_Label_2_2);
        gui_Box_Layout_X_3_2.addComponent(gui_tva);
        gui_Label_2_2.setText("TVA:              ");
                gui_Label_2_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2_2.setInlineAllStyles("font:3.5mm native:MainBold native:MainBold;");
        gui_Label_2_2.setName("Label_2_2");
        gui_tva.setText("Romuald");
                gui_tva.setInlineStylesTheme(resourceObjectInstance);
        gui_tva.setInlineAllStyles("font:3.5mm;");
        gui_tva.setName("tva");
        gui_Box_Layout_Y_1.addComponent(gui_Box_Layout_X_6);
        gui_Box_Layout_X_6.setPreferredSizeStr("41.534393mm 5.820106mm");
                gui_Box_Layout_X_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_6.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_6.setName("Box_Layout_X_6");
        gui_Box_Layout_X_6.addComponent(gui_Label_7);
        gui_Label_7.setText("-------------------------------------");
                gui_Label_7.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_7.setInlineAllStyles("font:3.5mm native:MainBold native:MainBold; opacity:115;");
        gui_Label_7.setName("Label_7");
        gui_Box_Layout_Y_1.addComponent(gui_Box_Layout_X_9);
        gui_Box_Layout_X_9.setPreferredSizeStr("42.592594mm 6.878307mm");
                gui_Box_Layout_X_9.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_9.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_9.setName("Box_Layout_X_9");
        gui_Box_Layout_X_9.addComponent(gui_Label_10);
        gui_Box_Layout_X_9.addComponent(gui_total);
        gui_Label_10.setText("Total:           ");
                gui_Label_10.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_10.setInlineAllStyles("font:3.5mm native:MainBold native:MainBold;");
        gui_Label_10.setName("Label_10");
        gui_total.setText("Romuald");
                gui_total.setInlineStylesTheme(resourceObjectInstance);
        gui_total.setInlineAllStyles("font:3.5mm;");
        gui_total.setName("total");
        gui_Label_4.setPreferredSizeStr("43.650795mm inherit");
        gui_Label_4.setText("     Total Panier");
                gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setInlineAllStyles("font:4.0mm native:MainBold native:MainBold; fgColor:fe7b37;");
        gui_Label_4.setName("Label_4");
        gui_Box_Layout_X_3.setPreferredSizeStr("45.502647mm inherit");
                gui_Box_Layout_X_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_3.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_3.setName("Box_Layout_X_3");
        gui_Box_Layout_X_3_1.setPreferredSizeStr("41.534393mm inherit");
                gui_Box_Layout_X_3_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_3_1.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_3_1.setName("Box_Layout_X_3_1");
        gui_Box_Layout_X_3_2.setPreferredSizeStr("43.650795mm inherit");
                gui_Box_Layout_X_3_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_3_2.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_3_2.setName("Box_Layout_X_3_2");
        gui_Box_Layout_X_6.setPreferredSizeStr("41.534393mm 5.820106mm");
                gui_Box_Layout_X_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_6.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_6.setName("Box_Layout_X_6");
        gui_Box_Layout_X_9.setPreferredSizeStr("42.592594mm 6.878307mm");
                gui_Box_Layout_X_9.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_9.setInlineAllStyles("padding:0px 0px 0px 7px;");
        gui_Box_Layout_X_9.setName("Box_Layout_X_9");
        addComponent(gui_confirmer);
        gui_Box_Layout_Y.setPreferredSizeStr("49.73545mm 56.878307mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setInlineAllStyles("bgImage:Mask.png; alignment:center; padding:7px 0px 10px 10px;");
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "4.4973545mm 16.791046% 58.156357% 13.059702%").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_Y_1.setPreferredSizeStr("53.439156mm 55.555557mm");
                gui_Box_Layout_Y_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y_1.setInlineAllStyles("bgImage:Mask.png; padding:7px 0px 10px 10px;");
        gui_Box_Layout_Y_1.setName("Box_Layout_Y_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y_1.getParent().getLayout()).setInsets(gui_Box_Layout_Y_1, "45.75045% 7.936508mm 22.60398% 0.0mm").setReferenceComponents(gui_Box_Layout_Y_1, "-1 -1 -1 0 ").setReferencePositions(gui_Box_Layout_Y_1, "0.0 0.0 0.0 0.0");
        gui_confirmer.setText("Confirimer");
                gui_confirmer.setInlineStylesTheme(resourceObjectInstance);
        gui_confirmer.setInlineAllStyles("font:3.0mm native:MainLight native:MainLight; fgColor:ffffff; bgImage:Button_background.png;");
        gui_confirmer.setName("confirmer");
        ((com.codename1.ui.layouts.LayeredLayout)gui_confirmer.getParent().getLayout()).setInsets(gui_confirmer, "auto auto 10.669078% 35.44776%").setReferenceComponents(gui_confirmer, "-1 -1 -1 -1").setReferencePositions(gui_confirmer, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
