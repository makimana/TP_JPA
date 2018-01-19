package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.List;


    @Entity
    public class Residence {
        private long id;
        private int taille;
        private int nb_pieces;
        private Personne self;
        private List<Chauffage> chauffage = new ArrayList<Chauffage>();

        public Residence(){

            super();
        }

        public Residence(int taille, int nb_pieces){
            this.taille= taille;
            this.nb_pieces= nb_pieces;
        }
        @Id
        @GeneratedValue
        public Long getId(){

            return id;
        }
        public void setId(long id){

            this.id=id;
        }
        public int getTaille(){

            return taille;
        }
        public void setTaille(int taille){
            this.taille=taille;

        }
        public int getNb_pieces(){

            return nb_pieces;
        }
        public void setNb_pieces(int nb_pieces){

            this.nb_pieces= nb_pieces;
        }
        @ManyToOne
        @JsonIgnore
        public Personne getSelf(){
            return this.self;
        }

        @Transient
        @JsonIgnore
        public List <Equipement> getResidenceEquipements() {
            return this.self.getEquipements();
        }

        @Transient
        @JsonIgnore
        public void setResidenceEquipements(Equipement equipements) {

            this.self.getEquipements().add(equipements);
        }

        public void setSelf(Personne self){

            this.self= self;
        }
        @OneToMany(mappedBy = "residence")
        public List<Chauffage> getChauffage(){

            return chauffage;
        }
        public void setChauffage(List<Chauffage> chauffage){

            this.chauffage = chauffage;
        }

        public void addChauffage(Chauffage ch1) {
            chauffage.add(ch1);

        }
    }


