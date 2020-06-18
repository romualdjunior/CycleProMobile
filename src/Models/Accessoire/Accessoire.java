/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Accessoire;

/**
 *
 * @author pc
 */
public class Accessoire {
    private int id ; 
    private String photoA ;
    private String photoA1 ;
    private String photoA2 ;
    private String photoA3 ;
    private int soldee ; 
    private String nom ;
    private String marque ;
    private String categorie;
    private double prix ;
    private String description ;
    private String Caracteristiques ;
    private int qtEnStock ;
    
    
    
    

    public int getId() {
        return id;
    }

    public Accessoire(int id, String photoA, String photoA1, String photoA2, String photoA3, int soldee, String nom, String marque, String categorie, double prix, String description, String Caracteristiques, int qtEnStock) {
        this.id = id;
        this.photoA = photoA;
        this.photoA1 = photoA1;
        this.photoA2 = photoA2;
        this.photoA3 = photoA3;
        this.soldee = soldee;
        this.nom = nom;
        this.marque = marque;
        this.categorie = categorie;
        this.prix = prix;
        this.description = description;
        this.Caracteristiques = Caracteristiques;
        this.qtEnStock = qtEnStock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoA() {
        return photoA;
    }

    public void setPhotoA(String photoA) {
        this.photoA = photoA;
    }

    public String getPhotoA1() {
        return photoA1;
    }

    public void setPhotoA1(String photoA1) {
        this.photoA1 = photoA1;
    }

    public String getPhotoA2() {
        return photoA2;
    }

    public void setPhotoA2(String photoA2) {
        this.photoA2 = photoA2;
    }

    public String getPhotoA3() {
        return photoA3;
    }

    public void setPhotoA3(String photoA3) {
        this.photoA3 = photoA3;
    }

    public int getSoldee() {
        return soldee;
    }

    public void setSoldee(int soldee) {
        this.soldee = soldee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaracteristiques() {
        return Caracteristiques;
    }

   

    public void setCaracteristiques(String Caracteristiques) {
        this.Caracteristiques = Caracteristiques;
    }

    public int getQtEnStock() {
        return qtEnStock;
    }

    public void setQtEnStock(int qtEnStock) {
        this.qtEnStock = qtEnStock;
    }
    
     @Override
    public String toString() {
        return "Accessoire{" + "id=" + id + ", photoA=" + photoA + ", photoA1=" + photoA1 + ", photoA2=" + photoA2 + ", photoA3=" + photoA3 + ", soldee=" + soldee + ", nom=" + nom + ", marque=" + marque + ", categorie=" + categorie + ", prix=" + prix + ", description=" + description + ", Caracteristiques=" + Caracteristiques + ", qtEnStock=" + qtEnStock + '}';
    }
    
    
    
    
}
