package Forms.Commande;

import Forms.Frontend.SignInForm;
import Models.Commande.Panier;
import com.codename1.io.Storage;
import com.codename1.payment.Product;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.NumericSpinner;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import java.util.List;

public class ProduitSingleForm extends Form {

    static int nbr_chargement = 0;

    public ProduitSingleForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        List<Panier> ProduitSingle = new ArrayList<Panier>();
        List<Panier> panier = new ArrayList<Panier>();

        ProduitSingle.addAll(((List<Panier>) Storage.getInstance().readObject("ProduitSingle")));
        gui_produit.getStyle().setBgImage(ProduitSingle.get(0).getImage());
        gui_produit_nom.setText(ProduitSingle.get(0).getNomProduit());
        gui_produit_prix.setText("$" + Integer.toString(ProduitSingle.get(0).getPrix()));
        gui_sous_produit_1.addActionListener((evt) -> {
            ProduitSingle.get(0).setImage(gui_sous_produit_1.getStyle().getBgImage());
            gui_produit.getAllStyles().setBgImage(gui_sous_produit_1.getStyle().getBgImage());
        });
        gui_sous_produit_2.addActionListener((evt) -> {
            ProduitSingle.get(0).setImage(gui_sous_produit_2.getStyle().getBgImage());
            gui_produit.getStyle().setBgImage(gui_sous_produit_2.getStyle().getBgImage());
        });
        gui_catalogue.addActionListener((evt) -> {
            new ShopForm(resourceObjectInstance).showBack();
        });
        gui_ajouter.addActionListener((evt) -> {
            ProduitSingle.get(0).setQuantite(Integer.parseInt(gui_quantite.getText()));
            if (this.nbr_chargement == 0) {
                panier.add(ProduitSingle.get(0));
                Storage.getInstance().writeObject("Panier", panier);
                new PanierForm(resourceObjectInstance).show();

                this.nbr_chargement++;
            } else {
                panier.clear();
                panier.addAll(((List<Panier>) Storage.getInstance().readObject("Panier")));
                panier.add(ProduitSingle.get(0));
                Storage.getInstance().writeObject("Panier", panier);
                new PanierForm(resourceObjectInstance).show();

            }
            System.out.println(panier);
        });

    }

//////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Layered_Layout = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    private com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_produit = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_produit_nom = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_produit_prix = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_ = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_produt_description = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Layered_Layout_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    private com.codename1.ui.Label gui_Label_10 = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_sous_produit_2  = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label_10_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_13 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Layered_Layout_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    private com.codename1.ui.Label gui_Label_12 = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_sous_produit_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label_12_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_14 = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_catalogue = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_ajouter = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_quantite = new com.codename1.ui.TextField();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:fbfcfe;");
        setTitle("ProduitSingleForm");
        setName("ProduitSingleForm");
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredWidthMM((float)70.899475);
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredHeightMM((float)146.2963);
        addComponent(gui_Layered_Layout);
        gui_Layered_Layout.setPreferredSizeStr("60.582012mm 67.46032mm");
                gui_Layered_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout.setName("Layered_Layout");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getLayout()).setPreferredWidthMM((float)60.84656);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getLayout()).setPreferredHeightMM((float)67.46032);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getParent().getLayout()).setInsets(gui_Layered_Layout, "0.0mm 3.7037027mm 7.4074078mm 9.328358%").setReferenceComponents(gui_Layered_Layout, "-1 -1 1 -1").setReferencePositions(gui_Layered_Layout, "0.0 0.0 1.0 0.0");
        gui_Layered_Layout.addComponent(gui_Label_6);
        gui_Layered_Layout.addComponent(gui_produit);
        gui_Layered_Layout.addComponent(gui_produit_nom);
        gui_Layered_Layout.addComponent(gui_produit_prix);
        gui_Layered_Layout.addComponent(gui_);
        gui_Layered_Layout.addComponent(gui_produt_description);
        gui_Label_6.setPreferredSizeStr("61.11111mm 66.93122mm");
                gui_Label_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_6.setInlineAllStyles("bgImage:Mask.png;");
        gui_Label_6.setName("Label_6");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_6.getParent().getLayout()).setInsets(gui_Label_6, "0.0mm 0.0mm 4.2328043mm 0.0mm").setReferenceComponents(gui_Label_6, "-1 -1 -1 -1").setReferencePositions(gui_Label_6, "0.0 0.0 0.0 0.0");
        gui_produit.setPreferredSizeStr("38.62434mm 28.042328mm");
                gui_produit.setInlineStylesTheme(resourceObjectInstance);
        gui_produit.setInlineAllStyles("bgImage:audi.png;");
        gui_produit.setName("produit");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produit.getParent().getLayout()).setInsets(gui_produit, "25.390625% auto 33.203125% 0.0mm").setReferenceComponents(gui_produit, "-1 0 -1 2 ").setReferencePositions(gui_produit, "0.0 0.0 0.0 0.0");
        gui_produit_nom.setPreferredSizeStr("inherit 3.1746032mm");
        gui_produit_nom.setText("Cross Bikes");
                gui_produit_nom.setInlineStylesTheme(resourceObjectInstance);
        gui_produit_nom.setInlineAllStyles("font:3.0mm; fgColor:333333;");
        gui_produit_nom.setName("produit_nom");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produit_nom.getParent().getLayout()).setInsets(gui_produit_nom, "6.878307mm auto 83.59375% 8.201058mm").setReferenceComponents(gui_produit_nom, "-1 0 -1 0 ").setReferencePositions(gui_produit_nom, "0.0 0.0 0.0 0.0");
        gui_produit_prix.setPreferredSizeStr("inherit 3.968254mm");
        gui_produit_prix.setText("$89");
                gui_produit_prix.setInlineStylesTheme(resourceObjectInstance);
        gui_produit_prix.setInlineAllStyles("font:4.0mm native:MainBold native:MainBold; fgColor:fe7b37;");
        gui_produit_prix.setName("produit_prix");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produit_prix.getParent().getLayout()).setInsets(gui_produit_prix, "1.5873013mm auto auto 1.5873013mm").setReferenceComponents(gui_produit_prix, "2 0 -1 2 ").setReferencePositions(gui_produit_prix, "1.0 0.0 0.0 0.0");
        gui_.setPreferredSizeStr("3.4391534mm 3.4391534mm");
                gui_.setInlineStylesTheme(resourceObjectInstance);
        gui_.setInlineAllStyles("font:3.0mm; fgColor:333333; bgImage:Outlined-UI-favourite.png;");
        gui_.setName("");
        ((com.codename1.ui.layouts.LayeredLayout)gui_.getParent().getLayout()).setInsets(gui_, "auto 8.994709mm 5.820106mm auto").setReferenceComponents(gui_, "0 0 1 2 ").setReferencePositions(gui_, "0.0 0.0 1.0 1.0");
        gui_produt_description.setPreferredSizeStr("inherit 3.968254mm");
        gui_produt_description.setText("lorep ipsum dmslkdsdcvxvxxdsfds");
                gui_produt_description.setInlineStylesTheme(resourceObjectInstance);
        gui_produt_description.setInlineAllStyles("font:3.0mm native:MainRegular native:MainRegular; fgColor:333333;");
        gui_produt_description.setName("produt_description");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produt_description.getParent().getLayout()).setInsets(gui_produt_description, "auto 0.0mm 11.790393% 0.0mm").setReferenceComponents(gui_produt_description, "-1 1 0 1 ").setReferencePositions(gui_produt_description, "0.0 0.0 0.0 0.0");
        addComponent(gui_Layered_Layout_1);
        gui_Layered_Layout_1.setPreferredSizeStr("35.714287mm 63.227512mm");
                gui_Layered_Layout_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout_1.setName("Layered_Layout_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getLayout()).setPreferredWidthMM((float)35.714287);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getLayout()).setPreferredHeightMM((float)63.227512);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getParent().getLayout()).setInsets(gui_Layered_Layout_1, "1.8518524mm 0.0mm 0.0mm auto").setReferenceComponents(gui_Layered_Layout_1, "2 -1 2 -1").setReferencePositions(gui_Layered_Layout_1, "0.0 0.0 0.0 0.0");
        gui_Layered_Layout_1.addComponent(gui_Label_10);
        gui_Layered_Layout_1.addComponent(gui_sous_produit_2 );
        gui_Layered_Layout_1.addComponent(gui_Label_10_1);
        gui_Layered_Layout_1.addComponent(gui_Label_13);
        gui_Label_10.setPreferredSizeStr("32.010582mm 35.978836mm");
                gui_Label_10.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_10.setInlineAllStyles("bgImage:Mask.png;");
        gui_Label_10.setName("Label_10");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_10.getParent().getLayout()).setInsets(gui_Label_10, "19.485294% -0.52910054mm 16.16228% 3.174603mm").setReferenceComponents(gui_Label_10, "-1 -1 -1 -1").setReferencePositions(gui_Label_10, "0.0 0.0 0.0 0.0");
        gui_sous_produit_2 .setPreferredSizeStr("24.074074mm 14.814815mm");
                gui_sous_produit_2 .setInlineStylesTheme(resourceObjectInstance);
        gui_sous_produit_2 .setInlineAllStyles("bgImage:mercedes.png;");
        gui_sous_produit_2 .setName("sous_produit_2 ");
        ((com.codename1.ui.layouts.LayeredLayout)gui_sous_produit_2 .getParent().getLayout()).setInsets(gui_sous_produit_2 , "28.963062% 5.8201056mm auto 25.497513%").setReferenceComponents(gui_sous_produit_2 , "-1 -1 -1 -1").setReferencePositions(gui_sous_produit_2 , "0.0 0.0 0.0 0.0");
        gui_Label_10_1.setText("Cross Bikes");
                gui_Label_10_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_10_1.setInlineAllStyles("font:3.0mm; fgColor:333333;");
        gui_Label_10_1.setName("Label_10_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_10_1.getParent().getLayout()).setInsets(gui_Label_10_1, "0.5291003mm auto 68.12404% 2.6455026mm").setReferenceComponents(gui_Label_10_1, "1 -1 -1 1 ").setReferencePositions(gui_Label_10_1, "1.0 0.0 0.0 0.0");
        gui_Label_13.setText("728 ITEM");
                gui_Label_13.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_13.setInlineAllStyles("font:2.0mm native:MainLight native:MainLight; fgColor:333333;");
        gui_Label_13.setName("Label_13");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_13.getParent().getLayout()).setInsets(gui_Label_13, "5.8201056mm auto auto 0.52910054mm").setReferenceComponents(gui_Label_13, "1 2 0 2 ").setReferencePositions(gui_Label_13, "1.0 0.0 0.0 0.0");
        addComponent(gui_Layered_Layout_2);
        gui_Layered_Layout_2.setPreferredSizeStr("36.772488mm 58.73016mm");
                gui_Layered_Layout_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout_2.setName("Layered_Layout_2");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_2.getLayout()).setPreferredWidthMM((float)36.772488);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_2.getLayout()).setPreferredHeightMM((float)58.73016);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_2.getParent().getLayout()).setInsets(gui_Layered_Layout_2, "49.909584% auto 9.94575% -4.7619076mm").setReferenceComponents(gui_Layered_Layout_2, "-1 -1 -1 -1").setReferencePositions(gui_Layered_Layout_2, "0.0 0.0 0.0 0.0");
        gui_Layered_Layout_2.addComponent(gui_Label_12);
        gui_Layered_Layout_2.addComponent(gui_sous_produit_1);
        gui_Layered_Layout_2.addComponent(gui_Label_12_1);
        gui_Layered_Layout_2.addComponent(gui_Label_14);
        gui_Label_12.setPreferredSizeStr("37.301586mm 36.772488mm");
                gui_Label_12.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_12.setInlineAllStyles("bgImage:Mask.png;");
        gui_Label_12.setName("Label_12");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_12.getParent().getLayout()).setInsets(gui_Label_12, "21.838236% -0.52910054mm 14.264994% 3.4391532mm").setReferenceComponents(gui_Label_12, "-1 -1 -1 -1").setReferencePositions(gui_Label_12, "0.0 0.0 0.0 0.0");
        gui_sous_produit_1.setPreferredSizeStr("24.074074mm 14.814815mm");
                gui_sous_produit_1.setInlineStylesTheme(resourceObjectInstance);
        gui_sous_produit_1.setInlineAllStyles("bgImage:audi.png;");
        gui_sous_produit_1.setName("sous_produit_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_sous_produit_1.getParent().getLayout()).setInsets(gui_sous_produit_1, "28.963062% 5.8201056mm auto 25.497513%").setReferenceComponents(gui_sous_produit_1, "-1 -1 -1 -1").setReferencePositions(gui_sous_produit_1, "0.0 0.0 0.0 0.0");
        gui_Label_12_1.setText("Cross Bikes");
                gui_Label_12_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_12_1.setInlineAllStyles("font:3.0mm; fgColor:333333;");
        gui_Label_12_1.setName("Label_12_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_12_1.getParent().getLayout()).setInsets(gui_Label_12_1, "0.5291003mm auto 68.12404% 2.6455026mm").setReferenceComponents(gui_Label_12_1, "1 -1 -1 1 ").setReferencePositions(gui_Label_12_1, "1.0 0.0 0.0 0.0");
        gui_Label_14.setText("728 ITEM");
                gui_Label_14.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_14.setInlineAllStyles("font:2.0mm native:MainLight native:MainLight; fgColor:333333;");
        gui_Label_14.setName("Label_14");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_14.getParent().getLayout()).setInsets(gui_Label_14, "5.8201056mm auto auto 0.52910054mm").setReferenceComponents(gui_Label_14, "1 2 0 2 ").setReferencePositions(gui_Label_14, "1.0 0.0 0.0 0.0");
        addComponent(gui_catalogue);
        addComponent(gui_ajouter);
        addComponent(gui_Label);
        addComponent(gui_quantite);
        gui_Layered_Layout.setPreferredSizeStr("60.582012mm 67.46032mm");
                gui_Layered_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout.setName("Layered_Layout");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getLayout()).setPreferredWidthMM((float)60.84656);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getLayout()).setPreferredHeightMM((float)67.46032);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getParent().getLayout()).setInsets(gui_Layered_Layout, "0.0mm 3.7037027mm 7.4074078mm 9.328358%").setReferenceComponents(gui_Layered_Layout, "-1 -1 1 -1").setReferencePositions(gui_Layered_Layout, "0.0 0.0 1.0 0.0");
        gui_Layered_Layout_1.setPreferredSizeStr("35.714287mm 63.227512mm");
                gui_Layered_Layout_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout_1.setName("Layered_Layout_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getLayout()).setPreferredWidthMM((float)35.714287);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getLayout()).setPreferredHeightMM((float)63.227512);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getParent().getLayout()).setInsets(gui_Layered_Layout_1, "1.8518524mm 0.0mm 0.0mm auto").setReferenceComponents(gui_Layered_Layout_1, "2 -1 2 -1").setReferencePositions(gui_Layered_Layout_1, "0.0 0.0 0.0 0.0");
        gui_Layered_Layout_2.setPreferredSizeStr("36.772488mm 58.73016mm");
                gui_Layered_Layout_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout_2.setName("Layered_Layout_2");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_2.getLayout()).setPreferredWidthMM((float)36.772488);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_2.getLayout()).setPreferredHeightMM((float)58.73016);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_2.getParent().getLayout()).setInsets(gui_Layered_Layout_2, "49.909584% auto 9.94575% -4.7619076mm").setReferenceComponents(gui_Layered_Layout_2, "-1 -1 -1 -1").setReferencePositions(gui_Layered_Layout_2, "0.0 0.0 0.0 0.0");
        gui_catalogue.setPreferredSizeStr("24.867725mm 7.936508mm");
        gui_catalogue.setText("Catalogue");
                gui_catalogue.setInlineStylesTheme(resourceObjectInstance);
        gui_catalogue.setInlineAllStyles("font:3.0mm native:MainRegular native:MainRegular; border:roundRect +top-left +top-right +bottom-left +bottom-right 3.0mm; bgColor:1058d1; fgColor:ffffff; transparency:234; bgImage:; alignment:center;");
        gui_catalogue.setName("catalogue");
        ((com.codename1.ui.layouts.LayeredLayout)gui_catalogue.getParent().getLayout()).setInsets(gui_catalogue, "auto 56.64336% 4.4973545mm 6.878307mm").setReferenceComponents(gui_catalogue, "-1 -1 -1 2 ").setReferencePositions(gui_catalogue, "0.0 0.0 0.0 0.0");
        gui_ajouter.setPreferredSizeStr("26.455027mm 7.4074073mm");
        gui_ajouter.setText("Ajouter");
                gui_ajouter.setInlineStylesTheme(resourceObjectInstance);
        gui_ajouter.setInlineAllStyles("font:3.0mm; border:roundRect +top-left +top-right +bottom-left +bottom-right 3.0mm; bgColor:1058d1; fgColor:ffffff; transparency:255; bgImage:;");
        gui_ajouter.setName("ajouter");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ajouter.getParent().getLayout()).setInsets(gui_ajouter, "auto 2.3809524mm 4.4973545mm 30.246914%").setReferenceComponents(gui_ajouter, "-1 -1 -1 3 ").setReferencePositions(gui_ajouter, "0.0 0.0 0.0 1.0");
        gui_Label.setPreferredSizeStr("21.16402mm inherit");
        gui_Label.setText("Quantite:");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("fgColor:0;");
        gui_Label.setInlineDisabledStyles("fgColor:0;");
        gui_Label.setName("Label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "auto 37.30159mm 0.0mm auto").setReferenceComponents(gui_Label, "-1 -1 1 0 ").setReferencePositions(gui_Label, "0.0 0.0 1.0 0.0");
        gui_quantite.setPreferredSizeStr("23.015873mm 5.555556mm");
                gui_quantite.setInlineStylesTheme(resourceObjectInstance);
        gui_quantite.setName("quantite");
        ((com.codename1.ui.layouts.LayeredLayout)gui_quantite.getParent().getLayout()).setInsets(gui_quantite, "0.0mm 35.37415% 0.0mm 0.0mm").setReferenceComponents(gui_quantite, "0 -1 1 2 ").setReferencePositions(gui_quantite, "1.0 0.0 1.0 1.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
