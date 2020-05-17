/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Commande;

import com.codename1.ui.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;


/**
 *
 * @author toshiba
 */
public class Panier {

    private int id;
    private int idProduit;// clé étrangère de la table produit 
    private String nomProduit;
    private int idCommande;
    private int prix;
    private int quantite;
    private Image image;

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", idCommande=" + idCommande + ", prix=" + prix + ", quantite=" + quantite + ", image=" + image + '}';
    }
 

    public Panier( int idProduit, String nomProduit, int prix,int quantite,Image image,int idCommande) {
        this.image=image;
        this.quantite = quantite;
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.idCommande=idCommande;
        
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public int getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public Image getImage() {
        return image;
    }


}
