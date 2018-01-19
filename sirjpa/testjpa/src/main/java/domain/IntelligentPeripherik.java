package domain;

import javax.persistence.*;
/* SINGE_TABLE fait une seule table pour toutes les 3 tables(IntelligentPeripherik,  Equipement, Chauffage)

 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class IntelligentPeripherik {
    private long id;
    private String name;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
