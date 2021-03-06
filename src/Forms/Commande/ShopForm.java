package Forms.Commande;

import Forms.BaseForm;
import Forms.Frontend.SignInForm;
import Models.Commande.Panier;
import com.codename1.io.Storage;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import java.util.List;

public class ShopForm extends BaseForm {


    public ShopForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        List<Button> list_button = new ArrayList<Button>();
        List<Form> list_form = new ArrayList<Form>();
        ChartDemosForm s=new ChartDemosForm();
        Storage.getInstance().writeObject("Statistiques",s );
        list_button.add(new Button("Statistiques"));
        list_form.add(s.showChart(s.options[0]));

        //list_form.add(new AdresseForm(resourceObjectInstance));

        installSidemenu(resourceObjectInstance, list_button, list_form);

        gui_produit_1.addActionListener((evt) -> {
            String prix = gui_prix_1.getText();
            String prix2 = prix.substring(1, 3);
            System.out.println(prix2);
            List<Panier> ProduitSingle = new ArrayList<Panier>();
            ProduitSingle.add(new Panier(1, gui_produit_nom_1.getText(), Integer.parseInt(prix2), 0, gui_produit_1.getStyle().getBgImage(), 0));
            Storage.getInstance().writeObject("ProduitSingle", ProduitSingle);
            new ProduitSingleForm(resourceObjectInstance).show();
        });
        gui_produit_2.addActionListener((evt) -> {
            String prix = gui_prix_2.getText();
            String prix2 = prix.substring(1, 3);
            System.out.println(prix2);
            List<Panier> ProduitSingle = new ArrayList<Panier>();
            ProduitSingle.add(new Panier(2, gui_produit_nom_2.getText(), Integer.parseInt(prix2), 0, gui_produit_2.getStyle().getBgImage(), 0));
            Storage.getInstance().writeObject("ProduitSingle", ProduitSingle);
            this.setTransitionInAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 3000));
            new ProduitSingleForm(resourceObjectInstance).show();
        });
       
        gui_produit_4.addActionListener((evt) -> {
            String prix = gui_prix_4.getText();
            String prix2 = prix.substring(1, 3);
            System.out.println(prix2);
            List<Panier> ProduitSingle = new ArrayList<Panier>();
            ProduitSingle.add(new Panier(4, gui_produit_nom_4.getText(), Integer.parseInt(prix2), 0, gui_produit_4.getStyle().getBgImage(), 0));
            Storage.getInstance().writeObject("ProduitSingle", ProduitSingle);
            this.setTransitionInAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 3000));
            new ProduitSingleForm(resourceObjectInstance).show();
        });
        gui_produit_5.addActionListener((evt) -> {
            String prix = gui_prix_5.getText();
            String prix2 = prix.substring(1, 3);
            System.out.println(prix2);
            List<Panier> ProduitSingle = new ArrayList<Panier>();
            ProduitSingle.add(new Panier(5, gui_produit_nom_5.getText(), Integer.parseInt(prix2), 0, gui_produit_5.getStyle().getBgImage(), 0));
            Storage.getInstance().writeObject("ProduitSingle", ProduitSingle);
            this.setTransitionInAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 3000));
            new ProduitSingleForm(resourceObjectInstance).show();
        });
        gui_produit_6.addActionListener((evt) -> {
            String prix = gui_prix_6.getText();
            String prix2 = prix.substring(1, 3);
            System.out.println(prix2);
            List<Panier> ProduitSingle = new ArrayList<Panier>();
            ProduitSingle.add(new Panier(6, gui_produit_nom_6.getText(), Integer.parseInt(prix2), 0, gui_produit_6.getStyle().getBgImage(), 0));
            Storage.getInstance().writeObject("ProduitSingle", ProduitSingle);
            this.setTransitionInAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 3000));
            new ProduitSingleForm(resourceObjectInstance).show();
        });

    }



////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Layered_Layout = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    private com.codename1.ui.Label gui_label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_produit_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_prix_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_produit_nom_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Layered_Layout_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    private com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_produit_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_prix_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_produit_nom_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Layered_Layout_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    private com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_produit_5 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_prix_5 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_produit_nom_5 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Layered_Layout_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    private com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_produit_4 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_prix_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_produit_nom_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Layered_Layout_5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    private com.codename1.ui.Label gui_Label_7 = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_produit_6 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_prix_6 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_produit_nom_6 = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:fbfcfe;");
        setTitle("Shop");
        setName("Shop");
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredWidthMM((float)70.91197);
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredHeightMM((float)137.7668);
        addComponent(gui_Layered_Layout);
        gui_Layered_Layout.setPreferredSizeStr("35.185184mm 89.94709mm");
                gui_Layered_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout.setName("Layered_Layout");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getLayout()).setPreferredWidthMM((float)35.185184);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getLayout()).setPreferredHeightMM((float)89.94709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getParent().getLayout()).setInsets(gui_Layered_Layout, "-0.26455027mm 50.373135% 38.69801% 0.0mm").setReferenceComponents(gui_Layered_Layout, "-1 -1 -1 -1").setReferencePositions(gui_Layered_Layout, "0.0 0.0 0.0 0.0");
        gui_Layered_Layout.addComponent(gui_label_1);
        gui_Layered_Layout.addComponent(gui_produit_1);
        gui_Layered_Layout.addComponent(gui_prix_1);
        gui_Layered_Layout.addComponent(gui_produit_nom_1);
        gui_label_1.setPreferredSizeStr("34.126984mm 36.50794mm");
                gui_label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_label_1.setInlineAllStyles("bgImage:Mask.png;");
        gui_label_1.setName("label_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_label_1.getParent().getLayout()).setInsets(gui_label_1, "20.496895% 0.0mm -3.7037072mm 0.0mm").setReferenceComponents(gui_label_1, "-1 -1 2 -1").setReferencePositions(gui_label_1, "0.0 0.0 0.0 0.0");
        gui_produit_1.setPreferredSizeStr("25.396826mm 14.550264mm");
        gui_produit_1.setText(" ");
                gui_produit_1.setInlineStylesTheme(resourceObjectInstance);
        gui_produit_1.setInlineAllStyles("bgImage:camaro.png;");
        gui_produit_1.setName("produit_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produit_1.getParent().getLayout()).setInsets(gui_produit_1, "14.705882% auto auto 3.439154mm").setReferenceComponents(gui_produit_1, "-1 -1 -1 -1").setReferencePositions(gui_produit_1, "0.0 0.0 0.0 0.0");
        gui_prix_1.setText("$89");
                gui_prix_1.setInlineStylesTheme(resourceObjectInstance);
        gui_prix_1.setInlineAllStyles("font:3.0mm native:MainBold native:MainBold; fgColor:fe7b37;");
        gui_prix_1.setName("prix_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_prix_1.getParent().getLayout()).setInsets(gui_prix_1, "-1.5873016mm auto auto 0.0mm").setReferenceComponents(gui_prix_1, "3 -1 -1 3 ").setReferencePositions(gui_prix_1, "1.0 0.0 0.0 0.0");
        gui_produit_nom_1.setText("Road Bicycles");
                gui_produit_nom_1.setInlineStylesTheme(resourceObjectInstance);
        gui_produit_nom_1.setInlineAllStyles("font:3.0mm native:MainBold native:MainBold; fgColor:333333;");
        gui_produit_nom_1.setName("produit_nom_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produit_nom_1.getParent().getLayout()).setInsets(gui_produit_nom_1, "2.1164021mm auto auto 3.7037034mm").setReferenceComponents(gui_produit_nom_1, "1 -1 -1 1 ").setReferencePositions(gui_produit_nom_1, "1.0 0.0 0.0 0.0");
        addComponent(gui_Layered_Layout_1);
        gui_Layered_Layout_1.setPreferredSizeStr("35.714287mm 89.94709mm");
                gui_Layered_Layout_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout_1.setName("Layered_Layout_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getLayout()).setPreferredWidthMM((float)35.714287);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getLayout()).setPreferredHeightMM((float)89.94709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getParent().getLayout()).setInsets(gui_Layered_Layout_1, "-0.26455027mm 0.0mm 56.613754mm 0.0mm").setReferenceComponents(gui_Layered_Layout_1, "-1 -1 -1 0 ").setReferencePositions(gui_Layered_Layout_1, "0.0 0.0 0.0 1.0");
        gui_Layered_Layout_1.addComponent(gui_Label_3);
        gui_Layered_Layout_1.addComponent(gui_produit_2);
        gui_Layered_Layout_1.addComponent(gui_prix_2);
        gui_Layered_Layout_1.addComponent(gui_produit_nom_2);
        gui_Label_3.setPreferredSizeStr("35.978836mm 36.50794mm");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("bgImage:Mask.png;");
        gui_Label_3.setName("Label_3");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "20.496895% 0.0mm -3.7037072mm 0.0mm").setReferenceComponents(gui_Label_3, "-1 -1 2 -1").setReferencePositions(gui_Label_3, "0.0 0.0 0.0 0.0");
        gui_produit_2.setPreferredSizeStr("25.396826mm 14.550264mm");
        gui_produit_2.setText(" ");
                gui_produit_2.setInlineStylesTheme(resourceObjectInstance);
        gui_produit_2.setInlineAllStyles("bgImage:audi.png;");
        gui_produit_2.setName("produit_2");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produit_2.getParent().getLayout()).setInsets(gui_produit_2, "14.705882% auto auto 3.439154mm").setReferenceComponents(gui_produit_2, "-1 -1 -1 -1").setReferencePositions(gui_produit_2, "0.0 0.0 0.0 0.0");
        gui_prix_2.setText("$50");
                gui_prix_2.setInlineStylesTheme(resourceObjectInstance);
        gui_prix_2.setInlineAllStyles("font:3.0mm native:MainBold native:MainBold; fgColor:fe7b37;");
        gui_prix_2.setName("prix_2");
        ((com.codename1.ui.layouts.LayeredLayout)gui_prix_2.getParent().getLayout()).setInsets(gui_prix_2, "-1.5873016mm auto auto 0.0mm").setReferenceComponents(gui_prix_2, "3 -1 -1 3 ").setReferencePositions(gui_prix_2, "1.0 0.0 0.0 0.0");
        gui_produit_nom_2.setText("Freight Bikes");
                gui_produit_nom_2.setInlineStylesTheme(resourceObjectInstance);
        gui_produit_nom_2.setInlineAllStyles("font:3.0mm native:MainBold native:MainBold; fgColor:333333;");
        gui_produit_nom_2.setName("produit_nom_2");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produit_nom_2.getParent().getLayout()).setInsets(gui_produit_nom_2, "2.1164021mm auto auto 3.7037034mm").setReferenceComponents(gui_produit_nom_2, "1 -1 -1 1 ").setReferencePositions(gui_produit_nom_2, "1.0 0.0 0.0 0.0");
        addComponent(gui_Layered_Layout_3);
        gui_Layered_Layout_3.setPreferredSizeStr("36.50794mm 89.94709mm");
                gui_Layered_Layout_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout_3.setName("Layered_Layout_3");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_3.getLayout()).setPreferredWidthMM((float)36.50794);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_3.getLayout()).setPreferredHeightMM((float)89.68254);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_3.getParent().getLayout()).setInsets(gui_Layered_Layout_3, "54.082626% -1.3227501mm -22.486774mm 0.0mm").setReferenceComponents(gui_Layered_Layout_3, "-1 0 -1 0 ").setReferencePositions(gui_Layered_Layout_3, "0.0 0.0 0.0 0.0");
        gui_Layered_Layout_3.addComponent(gui_Label_5);
        gui_Layered_Layout_3.addComponent(gui_produit_5);
        gui_Layered_Layout_3.addComponent(gui_prix_5);
        gui_Layered_Layout_3.addComponent(gui_produit_nom_5);
        gui_Label_5.setPreferredSizeStr("34.126984mm 36.50794mm");
                gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setInlineAllStyles("bgImage:Mask.png;");
        gui_Label_5.setName("Label_5");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_5.getParent().getLayout()).setInsets(gui_Label_5, "20.496895% 0.0mm -3.7037072mm 0.0mm").setReferenceComponents(gui_Label_5, "-1 -1 2 -1").setReferencePositions(gui_Label_5, "0.0 0.0 0.0 0.0");
        gui_produit_5.setPreferredSizeStr("25.396826mm 14.550264mm");
        gui_produit_5.setText(" ");
                gui_produit_5.setInlineStylesTheme(resourceObjectInstance);
        gui_produit_5.setInlineAllStyles("bgImage:mercedes.png;");
        gui_produit_5.setName("produit_5");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produit_5.getParent().getLayout()).setInsets(gui_produit_5, "14.705882% auto auto 3.439154mm").setReferenceComponents(gui_produit_5, "-1 -1 -1 -1").setReferencePositions(gui_produit_5, "0.0 0.0 0.0 0.0");
        gui_prix_5.setText("$60");
                gui_prix_5.setInlineStylesTheme(resourceObjectInstance);
        gui_prix_5.setInlineAllStyles("font:3.0mm native:MainBold native:MainBold; fgColor:fe7b37;");
        gui_prix_5.setName("prix_5");
        ((com.codename1.ui.layouts.LayeredLayout)gui_prix_5.getParent().getLayout()).setInsets(gui_prix_5, "-1.5873016mm auto auto 0.0mm").setReferenceComponents(gui_prix_5, "3 -1 -1 3 ").setReferencePositions(gui_prix_5, "1.0 0.0 0.0 0.0");
        gui_produit_nom_5.setText("Sport Bikes");
                gui_produit_nom_5.setInlineStylesTheme(resourceObjectInstance);
        gui_produit_nom_5.setInlineAllStyles("font:3.0mm native:MainBold native:MainBold; fgColor:333333;");
        gui_produit_nom_5.setName("produit_nom_5");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produit_nom_5.getParent().getLayout()).setInsets(gui_produit_nom_5, "2.1164021mm auto auto 3.7037034mm").setReferenceComponents(gui_produit_nom_5, "1 -1 -1 1 ").setReferencePositions(gui_produit_nom_5, "1.0 0.0 0.0 0.0");
        addComponent(gui_Layered_Layout_4);
        gui_Layered_Layout_4.addComponent(gui_Label_6);
        gui_Layered_Layout_4.addComponent(gui_produit_4);
        gui_Layered_Layout_4.addComponent(gui_prix_4);
        gui_Layered_Layout_4.addComponent(gui_produit_nom_4);
        gui_Label_6.setPreferredSizeStr("35.978836mm 36.50794mm");
                gui_Label_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_6.setInlineAllStyles("bgImage:Mask.png;");
        gui_Label_6.setName("Label_6");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_6.getParent().getLayout()).setInsets(gui_Label_6, "20.496895% 0.0mm -3.7037072mm 0.0mm").setReferenceComponents(gui_Label_6, "-1 -1 2 -1").setReferencePositions(gui_Label_6, "0.0 0.0 0.0 0.0");
        gui_produit_4.setPreferredSizeStr("25.396826mm 14.550264mm");
        gui_produit_4.setText(" ");
                gui_produit_4.setInlineStylesTheme(resourceObjectInstance);
        gui_produit_4.setInlineAllStyles("bgImage:mustang.png;");
        gui_produit_4.setName("produit_4");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produit_4.getParent().getLayout()).setInsets(gui_produit_4, "14.705882% auto auto 3.439154mm").setReferenceComponents(gui_produit_4, "-1 -1 -1 -1").setReferencePositions(gui_produit_4, "0.0 0.0 0.0 0.0");
        gui_prix_4.setText("$45");
                gui_prix_4.setInlineStylesTheme(resourceObjectInstance);
        gui_prix_4.setInlineAllStyles("font:3.0mm native:MainBold native:MainBold; fgColor:fe7b37;");
        gui_prix_4.setName("prix_4");
        ((com.codename1.ui.layouts.LayeredLayout)gui_prix_4.getParent().getLayout()).setInsets(gui_prix_4, "-1.5873016mm auto auto 0.0mm").setReferenceComponents(gui_prix_4, "3 -1 -1 3 ").setReferencePositions(gui_prix_4, "1.0 0.0 0.0 0.0");
        gui_produit_nom_4.setText("Road Bikes  ");
                gui_produit_nom_4.setInlineStylesTheme(resourceObjectInstance);
        gui_produit_nom_4.setInlineAllStyles("font:3.0mm native:MainBold native:MainBold; fgColor:333333;");
        gui_produit_nom_4.setName("produit_nom_4");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produit_nom_4.getParent().getLayout()).setInsets(gui_produit_nom_4, "2.1164021mm auto auto 3.7037034mm").setReferenceComponents(gui_produit_nom_4, "1 -1 -1 1 ").setReferencePositions(gui_produit_nom_4, "1.0 0.0 0.0 0.0");
        addComponent(gui_Layered_Layout_5);
        gui_Layered_Layout_5.setPreferredSizeStr("35.714287mm 89.94709mm");
                gui_Layered_Layout_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout_5.setName("Layered_Layout_5");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_5.getLayout()).setPreferredWidthMM((float)35.714287);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_5.getLayout()).setPreferredHeightMM((float)89.94709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_5.getParent().getLayout()).setInsets(gui_Layered_Layout_5, "2.6455023mm 0.0mm -10px 0.0mm").setReferenceComponents(gui_Layered_Layout_5, "2 -1 -1 0 ").setReferencePositions(gui_Layered_Layout_5, "0.0 0.0 0.0 1.0");
        gui_Layered_Layout_5.addComponent(gui_Label_7);
        gui_Layered_Layout_5.addComponent(gui_produit_6);
        gui_Layered_Layout_5.addComponent(gui_prix_6);
        gui_Layered_Layout_5.addComponent(gui_produit_nom_6);
        gui_Label_7.setPreferredSizeStr("35.978836mm 36.50794mm");
                gui_Label_7.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_7.setInlineAllStyles("bgImage:Mask.png;");
        gui_Label_7.setName("Label_7");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_7.getParent().getLayout()).setInsets(gui_Label_7, "20.496895% 0.0mm -3.7037072mm 0.0mm").setReferenceComponents(gui_Label_7, "-1 -1 2 -1").setReferencePositions(gui_Label_7, "0.0 0.0 0.0 0.0");
        gui_produit_6.setPreferredSizeStr("25.396826mm 14.550264mm");
        gui_produit_6.setText(" ");
                gui_produit_6.setInlineStylesTheme(resourceObjectInstance);
        gui_produit_6.setInlineAllStyles("bgImage:camaro.png;");
        gui_produit_6.setName("produit_6");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produit_6.getParent().getLayout()).setInsets(gui_produit_6, "14.705882% auto auto 3.439154mm").setReferenceComponents(gui_produit_6, "-1 -1 -1 -1").setReferencePositions(gui_produit_6, "0.0 0.0 0.0 0.0");
        gui_prix_6.setText("$30");
                gui_prix_6.setInlineStylesTheme(resourceObjectInstance);
        gui_prix_6.setInlineAllStyles("font:3.0mm native:MainBold native:MainBold; fgColor:fe7b37;");
        gui_prix_6.setName("prix_6");
        ((com.codename1.ui.layouts.LayeredLayout)gui_prix_6.getParent().getLayout()).setInsets(gui_prix_6, "-1.5873016mm auto auto 0.0mm").setReferenceComponents(gui_prix_6, "3 -1 -1 3 ").setReferencePositions(gui_prix_6, "1.0 0.0 0.0 0.0");
        gui_produit_nom_6.setText("Hobby Bikes");
                gui_produit_nom_6.setInlineStylesTheme(resourceObjectInstance);
        gui_produit_nom_6.setInlineAllStyles("font:3.0mm native:MainBold native:MainBold; fgColor:333333;");
        gui_produit_nom_6.setName("produit_nom_6");
        ((com.codename1.ui.layouts.LayeredLayout)gui_produit_nom_6.getParent().getLayout()).setInsets(gui_produit_nom_6, "2.1164021mm auto auto 3.7037034mm").setReferenceComponents(gui_produit_nom_6, "1 -1 -1 1 ").setReferencePositions(gui_produit_nom_6, "1.0 0.0 0.0 0.0");
        gui_Layered_Layout.setPreferredSizeStr("35.185184mm 89.94709mm");
                gui_Layered_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout.setName("Layered_Layout");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getLayout()).setPreferredWidthMM((float)35.185184);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getLayout()).setPreferredHeightMM((float)89.94709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout.getParent().getLayout()).setInsets(gui_Layered_Layout, "-0.26455027mm 50.373135% 38.69801% 0.0mm").setReferenceComponents(gui_Layered_Layout, "-1 -1 -1 -1").setReferencePositions(gui_Layered_Layout, "0.0 0.0 0.0 0.0");
        gui_Layered_Layout_1.setPreferredSizeStr("35.714287mm 89.94709mm");
                gui_Layered_Layout_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout_1.setName("Layered_Layout_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getLayout()).setPreferredWidthMM((float)35.714287);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getLayout()).setPreferredHeightMM((float)89.94709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_1.getParent().getLayout()).setInsets(gui_Layered_Layout_1, "-0.26455027mm 0.0mm 56.613754mm 0.0mm").setReferenceComponents(gui_Layered_Layout_1, "-1 -1 -1 0 ").setReferencePositions(gui_Layered_Layout_1, "0.0 0.0 0.0 1.0");
        gui_Layered_Layout_3.setPreferredSizeStr("36.50794mm 89.94709mm");
                gui_Layered_Layout_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout_3.setName("Layered_Layout_3");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_3.getLayout()).setPreferredWidthMM((float)36.50794);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_3.getLayout()).setPreferredHeightMM((float)89.68254);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_3.getParent().getLayout()).setInsets(gui_Layered_Layout_3, "54.082626% -1.3227501mm -22.486774mm 0.0mm").setReferenceComponents(gui_Layered_Layout_3, "-1 0 -1 0 ").setReferencePositions(gui_Layered_Layout_3, "0.0 0.0 0.0 0.0");

        gui_Layered_Layout_4.setPreferredSizeStr("35.714287mm 89.94709mm");
                gui_Layered_Layout_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout_4.setName("Layered_Layout_4");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_4.getLayout()).setPreferredWidthMM((float)35.714287);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_4.getLayout()).setPreferredHeightMM((float)89.94709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_4.getParent().getLayout()).setInsets(gui_Layered_Layout_4, "36.514374mm 0.0mm 16.757805mm 35.27959mm").setReferenceComponents(gui_Layered_Layout_4, "-1 -1 -1 -1").setReferencePositions(gui_Layered_Layout_4, "0.0 0.0 0.0 0.0");
                gui_Layered_Layout_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout_4.setName("Layered_Layout_4");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_4.getLayout()).setPreferredWidthMM((float)35.714287);
        gui_Layered_Layout_5.setPreferredSizeStr("35.714287mm 89.94709mm");
                gui_Layered_Layout_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Layered_Layout_5.setName("Layered_Layout_5");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_5.getLayout()).setPreferredWidthMM((float)35.714287);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_5.getLayout()).setPreferredHeightMM((float)89.94709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Layered_Layout_5.getParent().getLayout()).setInsets(gui_Layered_Layout_5, "2.6455023mm 0.0mm -10px 0.0mm").setReferenceComponents(gui_Layered_Layout_5, "2 -1 -1 0 ").setReferencePositions(gui_Layered_Layout_5, "0.0 0.0 0.0 1.0");
            gui_Layered_Layout_4.setPreferredSizeStr("35.714287mm 89.94709mm");

    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
}
