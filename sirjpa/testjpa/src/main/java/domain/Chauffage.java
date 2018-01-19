package domain;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import antlr.collections.List;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity

    public class Chauffage extends IntelligentPeripherik {
        private Residence residence;
        private String power;


        public Chauffage(){

            super();
        }

        @ManyToOne
        @JsonIgnore
        public Residence getResidence(){

            return this.residence;
        }
        public void setResidence(Residence residence){
            this.residence = residence;

        }
        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
        }





    }


