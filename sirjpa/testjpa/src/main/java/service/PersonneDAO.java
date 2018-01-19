package service;

import domain.Personne;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonneDAO implements GenericDAO<Personne,Long>{



    @Override
    public Personne create(Personne personne) {
       EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
       t.begin();
        EntityManagerHelper.getEntityManager().persist(personne);
        t.commit();
        return  personne;
    }

    @Override
    public Personne read(Long id) {

        return  EntityManagerHelper.getEntityManager().find(Personne.class, id);
    }

    @Override
    public Personne update(Personne personne) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().merge(personne);
        t.commit();
        return  personne;
    }


    @Override
    public void delete(Personne personne) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().remove(personne);
        t.commit();

    }
}
