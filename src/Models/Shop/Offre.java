/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Shop;



/**
 *
 * @author Yasmine
 */
public class Offre {
     public int id;
     public int pourcentage ;
     public String Velo ;
     public double nvPrix ;
  
    public Offre(int pourcentage, String Velo) {
        this.pourcentage = pourcentage;
        this.Velo = Velo;
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getVelo() {
        return Velo;
    }

    public void setVelo(String Velo) {
        this.Velo = Velo;
    }

    public double getNvPrix() {
        return nvPrix;
    }

    public void setNvPrix(double nvPrix) {
        this.nvPrix = nvPrix;
    }

    


    

    public Offre() {
    }

    public Offre(int id, int pourcentage, String Velo, double nvPrix) {
        this.id = id;
        this.pourcentage = pourcentage;
        this.Velo = Velo;
        this.nvPrix = nvPrix;
     
    }

    public Offre(int pourcentage, String Velo, double nvPrix) {
        this.pourcentage = pourcentage;
        this.Velo = Velo;
        this.nvPrix = nvPrix;

    }
}
