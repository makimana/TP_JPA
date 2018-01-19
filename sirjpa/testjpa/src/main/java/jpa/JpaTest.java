package jpa;

import domain.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class JpaTest {

	private EntityManager manager;
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			Residence a =  new Residence();
			Residence b =  new Residence();
			a.setTaille(10);
			b.setTaille(20);
			Residence x =  new Residence();
			Residence y =  new Residence();
			a.setTaille(30);
			b.setTaille(40);

			Personne p = new Personne();
			p.setNom("marlene");
			p.setPrenom("akimana");
			p.setMail("akimana@yahoo.fr");
			p.setResidences(Arrays.asList(a, b));
			a.setSelf(p);
			b.setSelf(p);
			manager.persist(a);
			manager.persist(b);
			manager.persist(p);
			Personne l = new Personne();
			l.setNom("laura");
			l.setPrenom("akira");
			l.setMail("akira@yahoo.fr");
			l.setResidences(Arrays.asList(x, y));
			x.setSelf(l);
			y.setSelf(l);
			manager.persist(x);
			manager.persist(y);
			manager.persist(l);

			Chauffage c = new Chauffage();
			c.setResidence(a);
			manager.persist(c);
			Chauffage d = new Chauffage();
			d.setResidence(b);
			manager.persist(d);
			Equipement device = new Equipement();
			device.setWatts(220);
			device.setP(p);
			manager.persist(device);
			Equipement vis = new Equipement();
			vis.setWatts(200);
			vis.setP(p);
			manager.persist(vis);


			Opower Op = new Opower();
			Op.setNom("nellya");
			Op.setPrenom("zohoun");
			Op.setAge(25);
			manager.persist(Op);


		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		String s = "SELECT e FROM Personne as e where e.nom=:nom";


		Query q = manager.createQuery(s,Personne.class);
		//Query m = manager.createNamedQuery("Select );

		q.setParameter("nom", "martin");
		List<Personne> res = q.getResultList();

		System.err.println(res.size());
//		System.err.println(res.get(0).getNom());

		manager.close();
		factory.close();

	}

}
