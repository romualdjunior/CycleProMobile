package MyApp;

import Forms.Commande.PanierForm;
import Forms.Frontend.HomeForm;
import Forms.Commande.ProduitSingleForm;
import Forms.Commande.ShopForm;
import Forms.Frontend.SignInForm;
import Forms.Frontend.SplashForm;
import Forms.Frontend.WalkthruForm;
import Forms.Frontend.WalkthruForm;
import Forms.Shop.Shop2Form;
import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.codename1.io.Storage;
import static com.codename1.ui.ComponentSelector.$;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;

/**
 * Thomes file was generated by <a href="https://www.codenameone.com/">Codename
 * One</a> for the purpose of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        //theme = UIManager.initFirstTheme("/theme");
        theme = UIManager.initNamedTheme("/theme", "Theme1");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if (err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });
    }

    public void start() {
        if (current != null) {
            current.show();
            return;
        }

//         new HomeForm().show();
//        SplashForm s = new SplashForm(theme);
//        s.show();
          Shop2Form s=new Shop2Form();
          s.show();
//                new ProduitSingleForm(theme).show();
//       new PanierForm().show();

    }

    public void stop() {
        current = getCurrentForm();
        if (current instanceof Dialog) {
            ((Dialog) current).dispose();
            current = getCurrentForm();
        }
    }

    public void destroy() {
    }

}
