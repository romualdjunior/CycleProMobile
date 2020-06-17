/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package Forms;

import Forms.Commande.AdresseForm;
import Forms.Commande.ShopForm;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import Forms.Frontend.SignInForm;
import Forms.Shop.FavoriesForm;
import Forms.Shop.ProduitsListForm;
import Forms.Shop.Shop2Form;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.RadioButtonList;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.Sheet;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.list.DefaultListModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility methods common to forms e.g. for binding the side menu
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {

    public BaseForm() {
    }

    public BaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }

    public BaseForm(String title) {
        super(title);
    }

    public BaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public void installSidemenu(Resources res, List<Button> list_button, List<Form> list_form) {
        Image selection = res.getImage("selection_in_sidemenu.png");

        Image inboxImage = null;

        if (isCurrentInbox()) {
            inboxImage = selection;
        }

        Image image_adresse = null;
        if (is_current_adresse()) {
            image_adresse = selection;
        }

        Image calendarImage = null;
        if (isCurrentCalendar()) {
            calendarImage = selection;
        }

        Image shop_image = null;
        if (is_current_shop()) {
            shop_image = selection;
        }

        Button inboxButton = new Button("Inbox", inboxImage);
        inboxButton.setUIID("SideCommand");
        inboxButton.getAllStyles().setPaddingBottom(0);
        Container inbox = FlowLayout.encloseMiddle(inboxButton,
                new Label("18", "SideCommandNumber"));
        inbox.setLeadComponent(inboxButton);
        inbox.setUIID("SideCommand");
        inboxButton.addActionListener(e -> new SignInForm(res).show());
        Style style_toolbar = getToolbar().getAllStyles();
        style_toolbar.setBgColor(0x1058D1);
        style_toolbar.setBgTransparency(255);

        getToolbar().addComponentToSideMenu(inbox); 
        
      
       
        
        getToolbar().addCommandToSideMenu("Adresse", image_adresse, e -> new AdresseForm(res).show());
        getToolbar().addCommandToSideMenu("Calendar", calendarImage, e -> new SignInForm(res).show());
        getToolbar().addCommandToSideMenu("Map", null, e -> {
        });
        getToolbar().addCommandToSideMenu("Shop", shop_image, e -> new Shop2Form().show());
        getToolbar().addCommandToSideMenu("Settings", null, e -> {
        });
        getToolbar().addCommandToSideMenu("Favories", shop_image, e -> new FavoriesForm(this).show());
        getToolbar().addCommandToSideMenu("Produits", shop_image, e -> new ProduitsListForm(this).show());

        // spacer
        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
        getToolbar().addComponentToSideMenu(new Label(res.getImage("profile_image.png"), "Container"));
        getToolbar().addComponentToSideMenu(new Label("Romuald Motcheho", "SideCommandNoPad"));

        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.setUIID("FloatingActionButton");

//        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
//        rb.uiid(false);
        fab.bindFabToContainer(getContentPane());
        fab.addActionListener(e -> {
            fab.setUIID("FloatingActionButtonClose");
            Image oldImage = fab.getIcon();
            FontImage image = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "FloatingActionButton", 3.8f);
            fab.setIcon(image);
            Dialog popup = new Dialog();
            popup.setDialogUIID("Container");
            popup.setLayout(new LayeredLayout());

            // Sheet 
            RadioButtonList sheetPos = new RadioButtonList(new DefaultListModel(
                    BorderLayout.NORTH, BorderLayout.EAST, BorderLayout.SOUTH, BorderLayout.WEST, BorderLayout.CENTER
            ));
            MySheet sheet = new MySheet(null, list_button, list_form);
            int positionIndex = sheetPos.getModel().getSelectedIndex();
            if (positionIndex >= 0) {
                String pos = (String) sheetPos.getModel().getItemAt(positionIndex);
                sheet.setPosition("South");
            }
            sheet.show();

            //popup
            popup.setTransitionInAnimator(CommonTransitions.createEmpty());
            popup.setTransitionOutAnimator(CommonTransitions.createEmpty());
            popup.setDisposeWhenPointerOutOfBounds(false);
            int t = BaseForm.this.getTintColor();
            BaseForm.this.setTintColor(0);
            //popup.showPopupDialog(new Rectangle(SignInForm.this.getWidth() - 10, SignInForm.this.getHeight() - 10, 10, 10));
            BaseForm.this.setTintColor(t);
            fab.setUIID("FloatingActionButton");
            fab.setIcon(oldImage);
            // ligne pour fermer 

        });

    }

    protected boolean isCurrentInbox() {
        return false;
    }

    protected boolean is_current_adresse() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean is_current_shop() {
        return false;
    }

    private class MySheet extends Sheet {

        MySheet(Sheet parent, List<Button> list_button, List<Form> list_form) {
            super(parent, "My Sheet");
            Container cnt = getContentPane();
            cnt.setLayout(BoxLayout.y());

            System.out.println(cnt);
            for (int i = 0; i < list_button.size(); i++) {
                Form t = list_form.get(i);
                if (!cnt.contains(list_button.get(i))) {
                    System.out.println(cnt.contains(list_button.get(i)) + "ici");
                    // System.out.println(cnt.getChildrenAsList(true));
                    list_button.get(i).addActionListener(e -> {
                        t.show();
                    });
                    cnt.add(list_button.get(i));
                }

            }
            addCloseListener((e) -> {
                getContentPane().removeAll();
            });
        }
    }

}
