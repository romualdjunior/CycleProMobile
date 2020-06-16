/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Blog;

import Forms.BaseForm;
import Forms.Frontend.SignInForm;
import Forms.Frontend.WalkthruForm;
import Models.Blog.Article;
import Models.Commande.Adresse;
import Services.Blog.ArticleService;
import Services.Commande.AdresseService;
import com.codename1.io.Storage;
import com.codename1.messaging.Message;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListCellRenderer;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class ReadArticles extends BaseForm {

    Form f;
    Resources res = UIManager.initNamedTheme("/theme", "Theme1");

    public ReadArticles(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

        List<Button> listButton = new ArrayList<Button>();
        List<Form> list_form = new ArrayList<Form>();
        Button sport = new Button("Sport");
        listButton.add(sport);

        Button bien = new Button("Bien Etre");
        listButton.add(bien);

        Button nutrition = new Button("Nutrition");
        listButton.add(nutrition);

        Button cyclisme = new Button("Cyclisme");
        listButton.add(cyclisme);
        Storage.getInstance().writeObject("Sport", new SportArticles(resourceObjectInstance));
        Storage.getInstance().writeObject("Bien", new BienArticles(resourceObjectInstance));
        Storage.getInstance().writeObject("Nutritition", new NutritionArticles(resourceObjectInstance));
        Storage.getInstance().writeObject("Cyclisme", new CyclismeArticles(resourceObjectInstance));

        list_form.add((BaseForm) Storage.getInstance().readObject("Sport"));
        list_form.add((BaseForm) Storage.getInstance().readObject("Bien"));
        list_form.add((BaseForm) Storage.getInstance().readObject("Nutritition"));
        list_form.add((BaseForm) Storage.getInstance().readObject("Cyclisme"));

        installSidemenu(resourceObjectInstance, listButton, list_form);
    }

    @Override
    protected boolean is_current_adresse() {
        return true;
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
        setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:fbfcfe;");
        setTitle("BLOG");

        ArticleService rs = new ArticleService();
        ArrayList<Article> p = rs.getAllArticles();

        ListModel<String> autoP = new DefaultListModel<>();

        ListModel<URLImage> pictures = new DefaultListModel<>();

        final int size = Display.getInstance().convertToPixels(7);
        final EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(size, size, 0xffcccccc), true);
        for (Article pr : p) {
            //ajouter dans la liste les titres des articles  
            autoP.addItem(pr.getTitre());
            URLImage urli = URLImage.createToStorage(placeholder,
                    "http://localhost/ProjetWeb3A19_3/CyclingProjet/CyclePro/web/Frontend/images/blog/"
                    + pr.getPhoto(),
                    "http://localhost/ProjetWeb3A19_3/CyclingProjet/CyclePro/web/Frontend/images/blog/"
                    + pr.getPhoto());
            pictures.addItem(urli);
        }

        Container Filter = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        AutoCompleteTextField ac = new AutoCompleteTextField(autoP);
        ac.setCompletionRenderer(new ListCellRenderer() {
            private final Label focus = new Label();
            private final Label line1 = new Label();
            private final Label icon = new Label();
            private final Container selection = BorderLayout.center(
                    BoxLayout.encloseY(line1)).add(BorderLayout.EAST, icon);

            @Override
            public Component getListCellRendererComponent(com.codename1.ui.List list, Object value,
                    int index, boolean isSelected) {
                for (int iter = 0; iter < autoP.getSize(); iter++) {
                    if (autoP.getItemAt(iter).equals(value)) {
                        line1.setText(autoP.getItemAt(iter));
                        System.out.println(autoP.getItemAt(iter));
                        icon.setIcon(pictures.getItemAt(iter));
                        break;
                    }
                }
                return selection;

            }

            @Override
            public Component getListFocusComponent(com.codename1.ui.List list) {
                return focus;
            }
        });
        Filter.add(ac);
        System.out.println(ac.getText());
        Container ctnlistProduct;
        System.err.println(p.size());
        ctnlistProduct = fillContainer(p);
        add(Filter);
        add(ctnlistProduct);

    }

    public Container fillContainer(ArrayList<Article> p) {
        Container ctnlistProduct = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        if (p.size() > 0) {
            for (Article pr : p) {
                Container c = new Container(new BoxLayout(BoxLayout.X_AXIS));
                Label label = new Label();
                System.out.println(pr.getPhoto());

                int deviceWidth = Display.getInstance().getDisplayWidth() / 4;
                Image placeholder = Image.createImage(deviceWidth, deviceWidth);
                EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
                label.setIcon(URLImage.createToStorage(encImage,
                        "Large_" + "http://localhost/ProjetWeb3A19_3/CyclingProjet/CyclePro/web/Frontend/images/blog/"
                        + pr.getPhoto()
                        + "", "http://localhost/ProjetWeb3A19_3/CyclingProjet/CyclePro/web/Frontend/images/blog/"
                        + pr.getPhoto()
                        + "", URLImage.RESIZE_SCALE_TO_FILL));

                c.add(label);
                Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                cnt.getAllStyles().setPaddingLeft(2);

                Container cat = new Container(new BoxLayout(BoxLayout.X_AXIS));
                Label catLab = new Label("Catégorie :");
                cat.add(catLab);
                cat.add(pr.getCategory());
                cnt.add(cat);

                Container tit = new Container(new BoxLayout(BoxLayout.X_AXIS));
                Label titLab = new Label("Titre :");
                tit.add(titLab);
                tit.add(pr.getTitre());
                cnt.add(tit);

                Container aut = new Container(new BoxLayout(BoxLayout.X_AXIS));
                Label autLab = new Label("Auteur :");
                aut.add(autLab);
                aut.add(pr.getAuteur());
                cnt.add(aut);

                c.add(cnt);

                Button show = new Button("Voir plus");
                show.setIcon(FontImage.createMaterial(FontImage.MATERIAL_INFO_OUTLINE,
                        show.getUnselectedStyle()));
                show.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        ArticleService AS = new ArticleService();
                        AS.getSingleArticle(pr);
                        //  new SingleArticle(pr).getF().show();
                        new SingleArticle(pr, res).show();

                    }
                });
                Container cnt1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                cnt1.add(show);
                Container cc = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                cc.add(c);
                cc.add(cnt1);
                cc.getAllStyles().setBorder(Border.createGrooveBorder(2));
                ctnlistProduct.add(cc);
            }
        } else {
            Label vide = new Label("No Article Available");
            ctnlistProduct.add(vide);
        }
        return ctnlistProduct;

    }

}
