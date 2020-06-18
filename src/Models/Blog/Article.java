/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Blog;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asus
 */
public class Article {
    private int id;
    private String titre;
    private String contenue;
    private String auteur;
    private String photo;
    private String category;
    private int likes;
    private Date date_art;
    private ArrayList<CommentaireArticle> Commentaires;

    public Article() {
    }
    
    public Article(int id,String category, String titre, String auteur, String photo , String contenue,
            int likes) {
        this.id = id;
        this.titre = titre;
        this.auteur=auteur;
        this.category=category;
        this.contenue=contenue;
        this.photo=photo;
        this.likes=likes;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getDate_art() {
        return date_art;
    }

    public void setDate_art(Date date_art) {
        this.date_art = date_art;
    }
    
        @Override
    public String toString() {
        return "Article{" + ", titre=" + titre + ", category=" + category +
                ", photo=" + photo +", likes=" + likes +", auteur=" + auteur +", date=" + date_art +'}';
         

    }


   
}
