/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Frontend;

import Support.GifImage;
import static com.codename1.ui.CN.getResourceAsStream;
import static com.codename1.ui.CN.log;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.util.UITimer;
import java.io.IOException;
import Forms.Frontend.SignInForm;
import com.codename1.io.Log;
import com.codename1.ui.FontImage;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;

/**
 * GUI builder created Form
 *
 * @author toshiba
 */
public class HomeForm extends com.codename1.ui.Form {

    public HomeForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        this.getToolbar().addCommandToLeftBar("<-", null, (evt) -> {
            this.showBack();
        });
        try {
            gui_logo_gif.getStyle().setBgImage(GifImage.decode(getResourceAsStream("/Splash_1.gif"), 1177720));
            UITimer uit = new UITimer(() -> {
                this.setTransitionInAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 3000));
                SignInForm s = new SignInForm();
                Style style = UIManager.getInstance().getComponentStyle("TitleCommand");
                FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_WARNING, style);
                s.getToolbar().addCommandToOverflowMenu("Overflow", icon, (e) -> Log.p("Clicked"));
                s.getToolbar().addCommandToSideMenu("Sidemenu", icon, (e) -> Log.p("Clicked"));
                s.show();
            });
            uit.schedule(3000, false, this);

            // gui_Logo.setIcon();
        } catch (IOException err) {
            log(err);
        }
    }

    public HomeForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_logo_gif = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgImage:Group 278.png;");
        setTitle("HomeForm");
        setName("HomeForm");
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredWidthMM((float)70.899475);
        ((com.codename1.ui.layouts.LayeredLayout)getLayout()).setPreferredHeightMM((float)146.2963);
        addComponent(gui_logo_gif);
        gui_logo_gif.setPreferredSizeStr("inherit 119.84127mm");
                gui_logo_gif.setInlineStylesTheme(resourceObjectInstance);
        gui_logo_gif.setName("logo_gif");
        ((com.codename1.ui.layouts.LayeredLayout)gui_logo_gif.getParent().getLayout()).setInsets(gui_logo_gif, "0px 0px 0px 0px").setReferenceComponents(gui_logo_gif, "-1 -1 -1 -1").setReferencePositions(gui_logo_gif, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
