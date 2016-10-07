package test;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.Transaction;
import modele.Adresse;
import modele.Agence;
import modele.Client;
import modele.util.HibernateUtil;

public class TestPersistence extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testInsertion() {
		// 1 : Ouverture unité de travail Hibernate
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// 2 : Ouverture transaction 
		Transaction tx = session.beginTransaction();

		try {

			// Début de la transaction
			tx.begin();

			// 3 : Instanciation Objets métier
			Client c1 = new Client("Davis", "Miles", "Jazzman");
			Adresse a1 = new Adresse("75000", "Champs elysees", "Paris");
			c1.setAdresse(a1);

			Client c2 = new Client("Parker", "Tony", "Basketeur");
			Adresse a2 = new Adresse("45999", "Parc privé", "San Antonio");
			c2.setAdresse(a2);

			Agence a = new Agence();
			a.setNom("Agence des ammandiers");
			Adresse a3 = new Adresse("01", "rue des jazzmen", "Lausanne");
			a.setAdresse(a3);

			// 4 : Persistance Objet/Relationnel : création enregistrements en base
			session.persist(a);
			session.persist(c1);
			session.persist(c2);
			
			// 5 : Fermeture transaction
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}