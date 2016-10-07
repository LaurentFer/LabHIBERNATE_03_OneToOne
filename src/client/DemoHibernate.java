package client;

import org.hibernate.classic.Session;
import org.hibernate.stat.Statistics;
import org.hibernate.Transaction;
import modele.Adresse;
import modele.Agence;
import modele.Client;
import modele.util.HibernateUtil;

public class DemoHibernate {

	public static void main(String[] args) {
		
		Statistics stats = HibernateUtil.getSessionFactory().getStatistics();
		
		// 1 : Ouverture unité de travail hibernate
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// 2 : Ouverture transaction 
		Transaction tx = session.beginTransaction();
		
		try {

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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 5 : Fermeture transaction 
		tx.commit();
		
		// 6 : Fermeture unité de travail hibernate 
		session.close();
		
		// Afficher les statistiques
		stats.logSummary();
	}
}