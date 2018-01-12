package jpa;

import domain.Personne;
import domain.Residence;

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

			Personne p = new Personne();
			p.setNom("marlene");
			p.setMail("akimana@yahoo.fr");
			p.setResidences(Arrays.asList(a, b));
			a.setSelf(p);
			b.setSelf(p);
			manager.persist(a);
			manager.persist(b);
			manager.persist(p);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		String s = "SELECT e FROM Personne as e where e.nom=:nom";

		Query q = manager.createQuery(s,Personne.class);
		q.setParameter("nom", "martin");
		List<Personne> res = q.getResultList();

		System.err.println(res.size());
//		System.err.println(res.get(0).getNom());

		manager.close();
		factory.close();

	}

}
