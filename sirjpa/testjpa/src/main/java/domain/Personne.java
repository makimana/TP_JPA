package domain;


import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import java.util.List;

    @Entity
    public class Personne {

        private String nom;
        private long id;
        private String prenom;
        private String mail;
        private List <Residence> residences = new ArrayList<Residence>();
        private List <Personne> amis = new ArrayList<Personne>();
        private List <Equipement> equipements = new ArrayList<Equipement>();

        @Id
        @GeneratedValue
        public long getId() {

            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
        @Column
        public String getNom() {
            return nom;
        }
        public void setNom(String nom) {

            this.nom = nom;
        }
        @Column
        public String getPrenom() {

            return prenom;
        }
        public void setPrenom(String prenom) {

            this.prenom = prenom;
        }
        @Column
        public String getMail() {
            return mail;
        }
        public void setMail(String mail) {

            this.mail = mail;
        }
        @OneToMany(mappedBy= "self")
        @JsonIgnore
        public List<Residence> getResidences() {

            return residences;
        }
        public void setResidences(List<Residence> residences) {

            this.residences = residences;
        }
        @OneToMany(mappedBy= "p")
        @JsonIgnore
        public List<Equipement> getEquipements() {

            return this.equipements;
        }
        public void setEquipements(List<Equipement> equipements) {

            this.equipements = equipements;
        }
        @ManyToMany
        @JsonIgnore
        public List<Personne> getAmis(){
            return this.amis;
        }
        public void setAmis(List<Personne> amis){
            this.amis = amis;
        }
        public Personne(){
            super();
        }
        public Personne(String nom, String prenom, String mail){
            this.nom = nom;
            this.prenom = prenom;
            this.mail = mail;

        }
    }



