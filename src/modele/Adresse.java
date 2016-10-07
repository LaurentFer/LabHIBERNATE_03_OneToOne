package modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {
	
	private Long id;
	
	private String codePostal;

	private String rue;

	private String ville;

	// Constructeurs
	public Adresse() {
	}

	public Adresse(String codePostal, String rue, String ville) {
		this.codePostal = codePostal;
		this.rue = rue;
		this.ville = ville;
	}
	
	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}