/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Reclamation;

import java.util.Date;

/**
 *
 * @author pc
 */
public class Reclamation {
    private int id ; 
    private String nomClient ;
    private String prenomClient; 
    private String tel ; 
    private String adresse ; 
    private String date ; 
    private String raison ; 
    private String details ; 
    private int RefVelo ;
    private int idClient ; 
    private String email ; 
    private String type ; 
    
    
    public Reclamation ( int ident , String nom , String prenom , String t , String add , String d , String r , String dt , int rf ,int idc , String e, String ty )
    {
    this.id = ident ; 
    this.nomClient= nom ;
    this.prenomClient=prenom ; 
    this.tel = t; 
    this.adresse = add ; 
    this.date = d; 
    this.raison = r ; 
    this.details = dt ; 
    this.RefVelo =rf ; 
    this.idClient =idc; 
    this.email = e ;
    this.type = ty ; 
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getRefVelo() {
        return RefVelo;
    }

    public void setRefVelo(int RefVelo) {
        this.RefVelo = RefVelo;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
          
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", tel=" + tel + ", adresse=" + adresse + ", date=" + date + ", raison=" + raison + ", details=" + details + ", RefVelo=" + RefVelo + ", idClient=" + idClient + ", email=" + email + ", type=" + type + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
    
}
