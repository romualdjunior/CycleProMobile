/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Reclamation;

import Forms.Accessoire.Accessoire2;
import Forms.Accessoire.Accessoire3;
import Forms.BaseForm;
import Models.Commande.Adresse;
import Models.Reclamation.Reclamation;
import Services.Commande.AdresseService;
import Services.Reclamation.ReclamationService;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author pc
 */
public class AddReclamationForm_1 extends BaseForm {
    private Resources theme;


    public AddReclamationForm_1() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public AddReclamationForm_1(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        
         theme = UIManager.initNamedTheme("/theme", "Theme1");
                List<Button> list_button = new ArrayList<Button>();
        List<Form> list_form = new ArrayList<Form>();
        list_button.add(new Button("manger"));
        list_button.add(new Button("Boire"));

        list_form.add(new Accessoire2());
        list_form.add(new Accessoire3());

        //installSidemenu(theme, list_button, list_form);
    installSidemenu(resourceObjectInstance, list_button, list_form);
        gui_Send_Button.addActionListener((evt) -> {
            if (gui_Id_Field.getText().length() == 0 ||gui_Nom_Field.getText().length() == 0 || gui_Prenom_Field.getText().length() == 0  || gui_Tel_Field.getText().length() == 0  || gui_Adresse_Field.getText().length() == 0  || gui_Picker.getText().length() == 0  || gui_Raison_Field.getText().length() == 0  || gui_Details_Field.getText().length() == 0  || gui_RefVelo_Field.getText().length() == 0  || gui_IdClient_Field.getText().length() == 0 || gui_Email_Field.getText().length() == 0   ) {
                Dialog.show("Alert", "Please fill all the fields", "OK", null);

            } else {
                try {
                    if (new ReclamationService().addReclamation(new Reclamation( Integer.parseInt(gui_Id_Field.getText()),gui_Nom_Field.getText(), gui_Prenom_Field.getText(),gui_Tel_Field.getText(),gui_Adresse_Field.getText(), gui_Picker.getText(),gui_Raison_Field.getText(), gui_Details_Field.getText(),Integer.parseInt(gui_RefVelo_Field.getText()),Integer.parseInt(gui_IdClient_Field.getText()), gui_Email_Field.getText(), gui_Combo_Box_Type.getSelectedItem().toString())))  {
                        if (Dialog.show("Alert", "Reclamation ajoutée avec succès", "OK", null)) {
                            Message m = new Message("Body of message");
                            m.getAttachments().put("texte", "text/plain");
                            m.getAttachments().put("image", "image/png");
                            Display.getInstance().sendMessage(new String[]{"wiem.saddem@esprit.tn"}, "Subject of message", m);
                           AffichageReclamation f = new AffichageReclamation() ; 
                            f.show(); 
                        }

                    } else {
                        Dialog.show("Alert", "Erreur Serveur", "OK", null);

                    }
                } catch (NumberFormatException e) {
                }
            }
        });
        
        
        gui_Combo_Box_Type.addItem("produit");
        gui_Combo_Box_Type.addItem("prix");
        gui_Combo_Box_Type.addItem("Service");

    }
    @Override
      protected boolean is_current_adresse() {
        return true;
    }
    
    
    
    

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Box_Layout_X1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Id_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_Id_Field = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Nom_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_Nom_Field = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Prenom_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_Prenom_Field = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Tel_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_Tel_Field = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Adresse_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_Adresse_Field = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Date_Label = new com.codename1.ui.Label();
    private com.codename1.ui.spinner.Picker gui_Picker = new com.codename1.ui.spinner.Picker();
    private com.codename1.ui.Container gui_Box_Layout_X7 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Raison_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_Raison_Field = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X8 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Details_Labe = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_Details_Field = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X9 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_RefVelo_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_RefVelo_Field = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X10 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_IdClient_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_IdClient_Field = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X11 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Email_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_Email_Field = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Box_Layout_X12 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Type_Label = new com.codename1.ui.Label();
    private com.codename1.ui.ComboBox gui_Combo_Box_Type = new com.codename1.ui.ComboBox();
    private com.codename1.ui.Button gui_Send_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Picker.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Picker) {
                onPickerActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("AddReclamationForm_1");
        setName("AddReclamationForm_1");
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredWidthMM((float)70.899475);
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredHeightMM((float)139.15344);
        addComponent(gui_Box_Layout_Y);
        gui_Box_Layout_Y.setPreferredSizeStr("54.761906mm 137.56613mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "auto auto -3.4391532mm 5.5555553mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X1);
        gui_Box_Layout_X1.setPreferredSizeStr("76.98413mm 11.640212mm");
                gui_Box_Layout_X1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X1.setName("Box_Layout_X1");
        gui_Box_Layout_X1.addComponent(gui_Id_Label);
        gui_Box_Layout_X1.addComponent(gui_Id_Field);
        gui_Id_Label.setPreferredSizeStr("17.989418mm inherit");
        gui_Id_Label.setText("Id:");
                gui_Id_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Id_Label.setName("Id_Label");
        gui_Id_Field.setPreferredSizeStr("61.904762mm 5.291005mm");
                gui_Id_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Id_Field.setName("Id_Field");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X2);
        gui_Box_Layout_X2.setPreferredSizeStr("77.24868mm 10.31746mm");
                gui_Box_Layout_X2.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X2.setName("Box_Layout_X2");
        gui_Box_Layout_X2.addComponent(gui_Nom_Label);
        gui_Box_Layout_X2.addComponent(gui_Nom_Field);
        gui_Nom_Label.setPreferredSizeStr("17.460318mm inherit");
        gui_Nom_Label.setText("Nom:");
                gui_Nom_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Nom_Label.setName("Nom_Label");
                gui_Nom_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Nom_Field.setName("Nom_Field");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X3);
        gui_Box_Layout_X3.setPreferredSizeStr("77.24868mm 10.05291mm");
                gui_Box_Layout_X3.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X3.setName("Box_Layout_X3");
        gui_Box_Layout_X3.addComponent(gui_Prenom_Label);
        gui_Box_Layout_X3.addComponent(gui_Prenom_Field);
        gui_Prenom_Label.setPreferredSizeStr("17.724869mm inherit");
        gui_Prenom_Label.setText("Prenom:");
                gui_Prenom_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Prenom_Label.setName("Prenom_Label");
                gui_Prenom_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Prenom_Field.setName("Prenom_Field");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X4);
        gui_Box_Layout_X4.setPreferredSizeStr("78.04233mm 10.05291mm");
                gui_Box_Layout_X4.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X4.setName("Box_Layout_X4");
        gui_Box_Layout_X4.addComponent(gui_Tel_Label);
        gui_Box_Layout_X4.addComponent(gui_Tel_Field);
        gui_Tel_Label.setPreferredSizeStr("17.460318mm inherit");
        gui_Tel_Label.setText("Tel:");
                gui_Tel_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Tel_Label.setName("Tel_Label");
                gui_Tel_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Tel_Field.setName("Tel_Field");
        gui_Tel_Field.setRows(1);
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X5);
        gui_Box_Layout_X5.setPreferredSizeStr("86.507935mm 10.05291mm");
                gui_Box_Layout_X5.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X5.setName("Box_Layout_X5");
        gui_Box_Layout_X5.addComponent(gui_Adresse_Label);
        gui_Box_Layout_X5.addComponent(gui_Adresse_Field);
        gui_Adresse_Label.setPreferredSizeStr("17.195766mm inherit");
        gui_Adresse_Label.setText("Adresse:");
                gui_Adresse_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Adresse_Label.setName("Adresse_Label");
        gui_Adresse_Field.setPreferredSizeStr("inherit 6.6137567mm");
                gui_Adresse_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Adresse_Field.setName("Adresse_Field");
        gui_Adresse_Field.setRows(1);
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X6);
        gui_Box_Layout_X6.setPreferredSizeStr("74.07407mm 9.78836mm");
                gui_Box_Layout_X6.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X6.setName("Box_Layout_X6");
        gui_Box_Layout_X6.addComponent(gui_Date_Label);
        gui_Box_Layout_X6.addComponent(gui_Picker);
        gui_Date_Label.setPreferredSizeStr("16.666666mm 7.142857mm");
        gui_Date_Label.setText("Date :");
                gui_Date_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Date_Label.setName("Date_Label");
        gui_Picker.setPreferredSizeStr("70.899475mm inherit");
        gui_Picker.setText("....");
                gui_Picker.setInlineStylesTheme(resourceObjectInstance);
        gui_Picker.setName("Picker");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Picker,"\ue916".charAt(0));
        gui_Picker.setType(4);
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X7);
        gui_Box_Layout_X7.setPreferredSizeStr("72.22222mm 9.523809mm");
                gui_Box_Layout_X7.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X7.setName("Box_Layout_X7");
        gui_Box_Layout_X7.addComponent(gui_Raison_Label);
        gui_Box_Layout_X7.addComponent(gui_Raison_Field);
        gui_Raison_Label.setPreferredSizeStr("16.931217mm inherit");
        gui_Raison_Label.setText("Raison: ");
                gui_Raison_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Raison_Label.setName("Raison_Label");
                gui_Raison_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Raison_Field.setName("Raison_Field");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X8);
        gui_Box_Layout_X8.setPreferredSizeStr("70.899475mm 9.78836mm");
                gui_Box_Layout_X8.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X8.setName("Box_Layout_X8");
        gui_Box_Layout_X8.addComponent(gui_Details_Labe);
        gui_Box_Layout_X8.addComponent(gui_Details_Field);
        gui_Details_Labe.setPreferredSizeStr("16.402117mm inherit");
        gui_Details_Labe.setText("D\u00E9tails:");
                gui_Details_Labe.setInlineStylesTheme(resourceObjectInstance);
        gui_Details_Labe.setName("Details_Labe");
                gui_Details_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Details_Field.setName("Details_Field");
        gui_Details_Field.setRows(1);
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X9);
        gui_Box_Layout_X9.setPreferredSizeStr("79.62963mm 9.259259mm");
                gui_Box_Layout_X9.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X9.setName("Box_Layout_X9");
        gui_Box_Layout_X9.addComponent(gui_RefVelo_Label);
        gui_Box_Layout_X9.addComponent(gui_RefVelo_Field);
        gui_RefVelo_Label.setPreferredSizeStr("15.608466mm inherit");
        gui_RefVelo_Label.setText("Ref:");
                gui_RefVelo_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_RefVelo_Label.setName("RefVelo_Label");
                gui_RefVelo_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_RefVelo_Field.setName("RefVelo_Field");
        gui_RefVelo_Field.setRows(1);
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X10);
        gui_Box_Layout_X10.setPreferredSizeStr("inherit 9.259259mm");
                gui_Box_Layout_X10.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X10.setName("Box_Layout_X10");
        gui_Box_Layout_X10.addComponent(gui_IdClient_Label);
        gui_Box_Layout_X10.addComponent(gui_IdClient_Field);
        gui_IdClient_Label.setPreferredSizeStr("15.873016mm inherit");
        gui_IdClient_Label.setText("Id client:");
                gui_IdClient_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_IdClient_Label.setName("IdClient_Label");
                gui_IdClient_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_IdClient_Field.setName("IdClient_Field");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X11);
        gui_Box_Layout_X11.setPreferredSizeStr("75.92593mm 8.730159mm");
                gui_Box_Layout_X11.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X11.setName("Box_Layout_X11");
        gui_Box_Layout_X11.addComponent(gui_Email_Label);
        gui_Box_Layout_X11.addComponent(gui_Email_Field);
        gui_Email_Label.setPreferredSizeStr("15.608466mm inherit");
        gui_Email_Label.setText("Email:");
                gui_Email_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Email_Label.setName("Email_Label");
                gui_Email_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Email_Field.setName("Email_Field");
        gui_Email_Field.setRows(1);
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X12);
        gui_Box_Layout_X12.setPreferredSizeStr("inherit 7.142857mm");
                gui_Box_Layout_X12.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X12.setName("Box_Layout_X12");
        gui_Box_Layout_X12.addComponent(gui_Type_Label);
        gui_Box_Layout_X12.addComponent(gui_Combo_Box_Type);
        gui_Type_Label.setPreferredSizeStr("16.402117mm inherit");
        gui_Type_Label.setText("Type");
                gui_Type_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Type_Label.setName("Type_Label");
        gui_Combo_Box_Type.setPreferredSizeStr("61.11111mm 8.730159mm");
                gui_Combo_Box_Type.setInlineStylesTheme(resourceObjectInstance);
        gui_Combo_Box_Type.setName("Combo_Box_Type");
        gui_Box_Layout_Y.addComponent(gui_Send_Button);
        gui_Box_Layout_X1.setPreferredSizeStr("76.98413mm 11.640212mm");
                gui_Box_Layout_X1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X1.setName("Box_Layout_X1");
        gui_Box_Layout_X2.setPreferredSizeStr("77.24868mm 10.31746mm");
                gui_Box_Layout_X2.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X2.setName("Box_Layout_X2");
        gui_Box_Layout_X3.setPreferredSizeStr("77.24868mm 10.05291mm");
                gui_Box_Layout_X3.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X3.setName("Box_Layout_X3");
        gui_Box_Layout_X4.setPreferredSizeStr("78.04233mm 10.05291mm");
                gui_Box_Layout_X4.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X4.setName("Box_Layout_X4");
        gui_Box_Layout_X5.setPreferredSizeStr("86.507935mm 10.05291mm");
                gui_Box_Layout_X5.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X5.setName("Box_Layout_X5");
        gui_Box_Layout_X6.setPreferredSizeStr("74.07407mm 9.78836mm");
                gui_Box_Layout_X6.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X6.setName("Box_Layout_X6");
        gui_Box_Layout_X7.setPreferredSizeStr("72.22222mm 9.523809mm");
                gui_Box_Layout_X7.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X7.setName("Box_Layout_X7");
        gui_Box_Layout_X8.setPreferredSizeStr("70.899475mm 9.78836mm");
                gui_Box_Layout_X8.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X8.setName("Box_Layout_X8");
        gui_Box_Layout_X9.setPreferredSizeStr("79.62963mm 9.259259mm");
                gui_Box_Layout_X9.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X9.setName("Box_Layout_X9");
        gui_Box_Layout_X10.setPreferredSizeStr("inherit 9.259259mm");
                gui_Box_Layout_X10.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X10.setName("Box_Layout_X10");
        gui_Box_Layout_X11.setPreferredSizeStr("75.92593mm 8.730159mm");
                gui_Box_Layout_X11.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X11.setName("Box_Layout_X11");
        gui_Box_Layout_X12.setPreferredSizeStr("inherit 7.142857mm");
                gui_Box_Layout_X12.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X12.setName("Box_Layout_X12");
        gui_Send_Button.setText("Envoyer");
                gui_Send_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Send_Button.setName("Send_Button");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Send_Button,"\ue163".charAt(0));
        gui_Box_Layout_Y.setPreferredSizeStr("54.761906mm 137.56613mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "auto auto -3.4391532mm 5.5555553mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onPickerActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }

}
