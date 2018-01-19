package service;

import domain.Opower;
import jpa.EntityManagerHelper;

import javax.persistence.*;

import java.util.List;

public class OpowerDAO implements GenericDAO<Opower,Long>{






    @Override
    public Opower create(Opower opower) {
        EntityTransaction et = EntityManagerHelper.getEntityManager().getTransaction();
        et.begin();
        EntityManagerHelper.getEntityManager().persist(opower);
        et.commit();
        return  opower;
    }

    @Override
    public Opower read(Long id) {
        return EntityManagerHelper.getEntityManager().find(Opower.class, id);
    }


    public List<Opower> readAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select o from Opower as o").getResultList();
    }


    @Override
    public Opower update(Opower opower) {
        EntityTransaction et = EntityManagerHelper.getEntityManager().getTransaction();
        et.begin();
        EntityManagerHelper.getEntityManager().merge(opower);
        et.commit();
        return  opower;
    }


    @Override
    public void delete(Opower opower) {
        EntityTransaction et = EntityManagerHelper.getEntityManager().getTransaction();
        et.begin();
        EntityManagerHelper.getEntityManager().remove(opower);
        et.commit();
    }

}
