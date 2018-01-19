package domain;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


    @Entity
    public class Equipement extends IntelligentPeripherik {
        private int watts;
        private Personne p;

        public Equipement(){
            super();
        }
        public Equipement(int watts){
            this.watts = watts;
        }

        public int getWatts() {
            return watts;
        }

        public void setWatts(int watts) {
            this.watts = watts;
        }


        @ManyToOne
        @JsonIgnore
        public Personne getP(){

            return p;
        }
        public void setP(Personne pers){

            this.p= pers;
        }

    }


