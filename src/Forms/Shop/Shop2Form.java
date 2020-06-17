/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Shop;

import Forms.BaseForm;
import Models.Shop.Velo;
import Services.Shop.ShopService;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yasmine
 */
public class Shop2Form extends BaseForm {

    private Resources theme;

    public Shop2Form() {
        super("Border Layout", new BorderLayout());
        theme = UIManager.initNamedTheme("/theme", "Theme1");
        List<Button> list_button = new ArrayList<Button>();
        List<Form> list_form = new ArrayList<Form>();
        list_button.add(new Button("Accessoires"));
        list_form.add(new AccessoireForm());
        installSidemenu(theme, list_button, list_form);

        List<Velo> velos = new ShopService().getAllTasks();
        Container contenant = BoxLayout.encloseY();
        int i = 1;
        List<Velo> velos_2 = new ArrayList<Velo>();
        for (Velo velo : velos) {
            velos_2.add(velo);
            if (i % 2 == 0) {
                Container C = BoxLayout.encloseX();
                Label produit_nom_1 = new Label(velos_2.get(0).getMarque());
                Label produit_prix_1 = new Label(Double.toString(velos_2.get(0).getPrixAchat()) + "$");
                produit_nom_1.setUIID("produit_nom");
                produit_prix_1.setUIID("produit_prix");
                Container velo_1 = new Container();
                String image_1 =  StringUtil.replaceAll(velos_2.get(0).getPhotoV(), "C:\\Users\\Yasmine\\Desktop\\yasmine\\ProjetJava\\CycleProJava\\CyclePro\\src\\GUI\\Images\\", "");

                velo_1.add(new Label(theme.getImage(image_1)));
                Container C1 = BoxLayout.encloseY(
                        velo_1,
                        produit_nom_1,
                        produit_prix_1
                );
                C1.getAllStyles().setBgColor(0xFF0000);
                C1.getStyle().setBgTransparency(255);
                C1.getAllStyles().setMarginUnit(Style.UNIT_TYPE_DIPS);
                C1.getAllStyles().setMargin(0, 3, 0, 3);

                C1.getAllStyles().setBgImage(theme.getImage("Mask2.png"));
                
                Label produit_nom_2 = new Label(velos_2.get(1).getMarque());
                Label produit_prix_2 = new Label(Double.toString(velos_2.get(1).getPrixAchat()) + "$");
                produit_nom_2.setUIID("produit_nom");

                produit_prix_2.setUIID("produit_prix");

                Container velo_2 = new Container();
                String image_2 = StringUtil.replaceAll(velos_2.get(1).getPhotoV(), "C:\\Users\\Yasmine\\Desktop\\yasmine\\ProjetJava\\CycleProJava\\CyclePro\\src\\GUI\\Images\\", "");

                velo_2.add(new Label(theme.getImage(image_2)));
                Container C2 = BoxLayout.encloseY(
                        velo_2,
                        produit_nom_2,
                        produit_prix_2
                );
                C2.getAllStyles().setBgColor(0xFF0000);
                C2.getStyle().setBgTransparency(255);
                C2.getAllStyles().setMarginUnit(Style.UNIT_TYPE_DIPS);
                C2.getAllStyles().setMargin(0, 3, 3, 0);
                C2.getAllStyles().setBgImage(theme.getImage("Mask2.png"));
                getAllStyles().setBgColor(0xfbfcfe);
                C.getAllStyles().setMarginUnit(Style.UNIT_TYPE_DIPS);
                C.getAllStyles().setMargin(1, 1, 3, 3);
                C.addAll(C1, C2);
                contenant.add(C);
                velos_2.clear();
            }

            i++;
        }

//        getAllStyles().setBgColor(0xfbfcfe);
//        C.getAllStyles().setMarginUnit(Style.UNIT_TYPE_DIPS);
//        C.getAllStyles().setMargin(3, 3, 3, 3);
        Container contenant2 = new Container();
        contenant2.add(contenant);
        this.add(BorderLayout.CENTER, contenant2);

    }

}
