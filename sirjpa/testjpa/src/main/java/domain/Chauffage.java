package domain;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import antlr.collections.List;

    @Entity

    public class Chauffage {
        private long id;
        private Residence residence;


        public Chauffage(){

            super();
        }
        @Id
        @GeneratedValue
        public long getId() {

            return id;
        }

        public void setId(long id) {

            this.id = id;
        }
        @ManyToOne
        public Residence getResidence(){

            return this.residence;
        }
        public void setResidence(Residence residence){
            this.residence = residence;

        }





    }


