package service;

import domain.Personne;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonneDAO implements GenericDAO<Personne,Long>{


    EntityManager manager;


    public PersonneDAO(EntityManager m ){
        this.manager= m;
    }


    @Override
    public Personne create(Personne personne) {
       EntityTransaction t = manager.getTransaction();
       t.begin();
        manager.persist(personne);
        t.commit();
        return  personne;
    }

    @Override
    public Personne read(Long id) {
        return  manager.find(Personne.class, id);
    }

    @Override
    public Personne update(Personne personne) {
        EntityTransaction t = manager.getTransaction();
        t.begin();
        manager.merge(personne);
        t.commit();
        return  personne;
    }


    @Override
    public void delete(Personne personne) {
        EntityTransaction t = manager.getTransaction();
        t.begin();
        manager.remove(personne);
        t.commit();

    }
}
