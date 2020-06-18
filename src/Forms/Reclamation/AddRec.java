package Forms.Reclamation;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;


public class AddRec extends Form  {
    public AddRec(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Box_Layout_X = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_TextField = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("AddRec");
        setName("AddRec");
        addComponent(gui_Box_Layout_X);
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setName("Box_Layout_X");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X.getParent().getLayout()).setInsets(gui_Box_Layout_X, "34.60076% 31.284916% auto 18.715084%").setReferenceComponents(gui_Box_Layout_X, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_X.addComponent(gui_Label);
        gui_Box_Layout_X.addComponent(gui_TextField);
        gui_Box_Layout_X.addComponent(gui_Button);
        gui_Label.setText("Search:");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
                gui_TextField.setInlineStylesTheme(resourceObjectInstance);
        gui_TextField.setName("TextField");
        gui_Button.setText("Submit");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setName("Box_Layout_X");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X.getParent().getLayout()).setInsets(gui_Box_Layout_X, "34.60076% 31.284916% auto 18.715084%").setReferenceComponents(gui_Box_Layout_X, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X, "0.0 0.0 0.0 0.0");
    }// </editor-fold>
//-- DON'T EDIT ABOVE THIS LINE!!!
}
