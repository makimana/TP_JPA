package domain;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


    @Entity
    public class Equipement {
        private long id;
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


        @Id
        @GeneratedValue
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
        @ManyToOne
        public Personne getP(){

            return p;
        }
        public void setP(Personne pers){

            this.p= pers;
        }

    }


