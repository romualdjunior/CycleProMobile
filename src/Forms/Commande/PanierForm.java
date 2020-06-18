/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Commande;

import Models.Commande.Panier;
import com.codename1.io.Storage;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Forms.BaseForm;
import Forms.Frontend.SignInForm;
import Forms.Frontend.WalkthruForm;

/**
 * GUI builder created Form
 *
 * @author toshiba
 */
public class PanierForm extends BaseForm {

    public PanierForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public PanierForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        new Form("Border Layout", new BorderLayout());
        initGuiBuilderComponents(resourceObjectInstance);
        List<Button> list_button = new ArrayList<Button>();
        List<Form> list_form = new ArrayList<Form>();
        list_button.add(new Button("manger"));
        list_button.add(new Button("Boire"));

        list_form.add(new SignInForm(resourceObjectInstance));
        list_form.add(new WalkthruForm(resourceObjectInstance));
        installSidemenu(resourceObjectInstance, list_button, list_form);

        Container C = BoxLayout.encloseY();
        List<Panier> panier = new ArrayList<Panier>();
        panier.addAll(((List<Panier>) Storage.getInstance().readObject("Panier")));
        for (Panier panier1 : panier) {
            Label produit_nom = new Label(panier1.getNomProduit());
            Label produit_prix = new Label("$" + Integer.toString(panier1.getPrix()));
            Label produit_quantite = new Label("quantite: " + Integer.toString(panier1.getQuantite()));
            Button supprimer = new Button(resourceObjectInstance.getImage("Icon material-delete.png"));
            supprimer.getAllStyles().setMarginUnit(Style.UNIT_TYPE_DIPS);
            supprimer.getAllStyles().setMargin(0, 0, 0, 15);
            produit_prix.getAllStyles().setFgColor(0xFE7B37);
            Container C1_1 = BoxLayout.encloseY(
                    produit_nom,
                    produit_quantite,
                    produit_prix,
                    supprimer);
            C1_1.getAllStyles().setMarginUnit(Style.UNIT_TYPE_DIPS);
            C1_1.getAllStyles().setMargin(2, 2, 2, 2);
            Container C1_2 = new Container();
            C1_2.getAllStyles().setBgImage(panier1.getImage());
            C1_2.add(new Label("                                              "));
            C1_2.getAllStyles().setMarginUnit(Style.UNIT_TYPE_DIPS);
            C1_2.getAllStyles().setMargin(3, 3, 2, 4);
            Container C1 = BoxLayout.encloseX(C1_1,
                    C1_2);
            C1.setUIID(Integer.toString(panier1.getIdProduit()));
            C1.getAllStyles().setBgColor(0xFF0000);
            C1.getStyle().setBgTransparency(255);
            C1.getAllStyles().setMarginUnit(Style.UNIT_TYPE_DIPS);
            C1.getAllStyles().setMargin(3, 3, 1, 2);
            C1.getAllStyles().setBgImage(resourceObjectInstance.getImage("Mask2.png"));
            supprimer.addActionListener((evt) -> {
                System.out.println(supprimer.getParent().getChildrenAsList(true).get(0));
                System.out.println(C1.getUIID());

                Iterator<Panier> it = panier.iterator();
                while (it.hasNext()) {
                    Panier p = it.next();
                    System.out.println("idProduit" + p.getIdProduit());
                    if (p.getIdProduit() == Integer.parseInt(C1.getUIID())) {
                        it.remove();
                        C1.remove();
                        this.refreshTheme();

                    }
                }
                Storage.getInstance().writeObject("Panier", panier);

            });

            C.add(C1);
        }
        gui_catalogue.addActionListener((evt) -> {
            new ShopForm(resourceObjectInstance).showBack();
        });
        gui_commande.addActionListener((evt) -> {
            new AdresseForm(resourceObjectInstance).show();
        });
        this.add(BorderLayout.CENTER, C);

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Button gui_catalogue = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_commande = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:fbfcfe; bgImage:null;");
        setTitle("PanierForm");
        setName("PanierForm");
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredWidthMM((float)70.899475);
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredHeightMM((float)146.2963);
        addComponent(gui_catalogue);
        addComponent(gui_commande);
        gui_catalogue.setPreferredSizeStr("21.693121mm 6.878307mm");
        gui_catalogue.setText("Catalogue");
                gui_catalogue.setInlineStylesTheme(resourceObjectInstance);
        gui_catalogue.setInlineAllStyles("font:3.0mm native:MainLight native:MainLight; border:roundRect +top-left +top-right +bottom-left +bottom-right 3.0mm; bgColor:1058d1; fgColor:ffffff; transparency:247; bgImage:;");
        gui_catalogue.setName("catalogue");
        ((com.codename1.ui.layouts.LayeredLayout)gui_catalogue.getParent().getLayout()).setInsets(gui_catalogue, "auto auto 3.7037058mm 7.671959mm").setReferenceComponents(gui_catalogue, "-1 -1 -1 -1").setReferencePositions(gui_catalogue, "0.0 0.0 0.0 0.0");
        gui_commande.setPreferredSizeStr("21.428572mm 6.878307mm");
        gui_commande.setText("Commande");
                gui_commande.setInlineStylesTheme(resourceObjectInstance);
        gui_commande.setInlineAllStyles("font:2.5mm native:MainRegular native:MainRegular; border:roundRect +top-left +top-right +bottom-left +bottom-right 3.0mm; bgColor:1058d1; fgColor:ffffff; transparency:236; bgImage:;");
        gui_commande.setName("commande");
        ((com.codename1.ui.layouts.LayeredLayout)gui_commande.getParent().getLayout()).setInsets(gui_commande, "auto 2.9100528mm 3.7037039mm auto").setReferenceComponents(gui_commande, "-1 -1 -1 -1").setReferencePositions(gui_commande, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
