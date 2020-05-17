/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Frontend;

import com.codename1.components.ScaleImageButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.DefaultLookAndFeel;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;

/**
 * GUI builder created Form
 *
 * @author toshiba
 */
public class WalkthruForm extends com.codename1.ui.Form {

    public WalkthruForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public WalkthruForm(com.codename1.ui.util.Resources res) {
//        super(new LayeredLayout());
//       getTitleArea().removeAll();
//        getTitleArea().setUIID("Container");

        setTransitionOutAnimator(CommonTransitions.createUncover(CommonTransitions.SLIDE_HORIZONTAL, true, 400));
        this.getStyle().setBgColor(0x3C80F7);
        Tabs walkthruTabs = new Tabs();
        walkthruTabs.setUIID("Container");
        walkthruTabs.getContentPane().setUIID("Container");
        walkthruTabs.getTabsContainer().setUIID("Container");
        walkthruTabs.hideTabs();

        Image notes = res.getImage("notes.png");
        Image duke = res.getImage("duke.png");

        Label notesPlaceholder = new Label("", "ProfilePic");
        ScaleImageLabel notesLabel = new ScaleImageLabel(res.getImage("Phone Medium.png"));

        Component.setSameHeight(notesLabel, notesPlaceholder);
        Component.setSameWidth(notesLabel, notesPlaceholder);
        Label bottomSpace = new Label();
        SpanLabel Text1 = new SpanLabel("Never miss an appointment, never forget about your "
                + "daily team meeting and remember when your favorite "
                + "team is playing.", "WalkthruBody");
        Text1.getStyle().setFgColor(0xFFFFFF);
        Container tab1 = BorderLayout.centerAbsolute(BoxLayout.encloseY(
                notesPlaceholder, new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""), 
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                Text1,
                bottomSpace
        ));
        tab1.setUIID("WalkthruTab1");

        walkthruTabs.addTab("", tab1);

        Label bottomSpaceTab2 = new Label();
        Label notesPlaceholder2 = new Label("", "ProfilePic");

        ScaleImageLabel notesLabel2 = new ScaleImageLabel(res.getImage("Phone Right.png"));

        Component.setSameHeight(notesLabel2, notesPlaceholder2);
        Component.setSameWidth(notesLabel2, notesPlaceholder2);
        Container tab2 = BorderLayout.centerAbsolute(BoxLayout.encloseY(
                notesLabel2,
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new SpanLabel("Write once run anywhere native mobile development "
                        + "Get Java working on all devices as it was always meant "
                        + "to be!", "WalkthruBody"),
                bottomSpaceTab2
        ));

        tab2.setUIID("WalkthruTab2");
        ScaleImageLabel notesLabel3 = new ScaleImageLabel(res.getImage("Phone Left 2.png"));
        walkthruTabs.addTab("", tab2);
        Container tab3 = BorderLayout.centerAbsolute(BoxLayout.encloseY(
                notesLabel3,
               new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new Label(""),
                new SpanLabel("Write once run anywhere native mobile development "
                        + "Get Java working on all devices as it was always meant "
                        + "to be!", "WalkthruBody"),
                new Label("")
        ));

        tab3.setUIID("WalkthruTab3");
         for (int i = 0; i < 20; i++) {
            this.add(new Label(" "));
        }
        walkthruTabs.addTab("", tab3);
        add(walkthruTabs);
     
        ButtonGroup bg = new ButtonGroup();
        Image unselectedWalkthru = res.getImage("notselected.png");
        Image selectedWalkthru = res.getImage("checked.png");
        RadioButton[] rbs = new RadioButton[walkthruTabs.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(CENTER);
        Container radioContainer = new Container(flow);
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

        rbs[0].setSelected(true);
        walkthruTabs.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });

        Button skip = new Button(res.getImage("Button.png"));
        skip.setUIID("SkipButton");
        //skip.addActionListener(e -> new ProfileForm(res).show());
        Container southLayout = BoxLayout.encloseX(
                radioContainer,
                new Label("                                      "),
                skip
        );
        add(BorderLayout.south(
                southLayout
        ));

        Component.setSameWidth(bottomSpace, bottomSpaceTab2, southLayout);
        Component.setSameHeight(bottomSpace, bottomSpaceTab2, southLayout);

        // visual effects in the first show
        addShowListener(e -> {
            notesPlaceholder.getParent().replace(notesPlaceholder, notesLabel, CommonTransitions.createFade(1500));
        });

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:1058d1; bgType:none; bgImage:null;");
        setTitle("WalkthruForm");
        setName("WalkthruForm");
        gui_Button.setText("SUIVANT");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        addComponent(gui_Button);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "auto 25.74627% 33.273056% auto").setReferenceComponents(gui_Button, "-1 -1 -1 -1").setReferencePositions(gui_Button, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
