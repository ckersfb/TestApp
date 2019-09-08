package app.autobuska.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Linija {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(nullable=false)
	private int brojmesta;
	@Column
	private String vremepolaska;
	@Column
	private double cenakarte;
	@Column(nullable=false)
	private String destinacija;
	@ManyToOne(fetch=FetchType.EAGER)
	private Prevoznik prevoznik;
	
	public Linija() {
		super();
	}

	public Long getId() {
		return id;
	}
	

	public String getVremepolaska() {
		return vremepolaska;
	}

	public void setVremepolaska(String vremepolaska) {
		this.vremepolaska = vremepolaska;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojmesta() {
		return brojmesta;
	}

	public void setBrojmesta(int brojmesta) {
		this.brojmesta = brojmesta;
	}

	public double getCenakarte() {
		return cenakarte;
	}

	public void setCenakarte(double cenakarte) {
		this.cenakarte = cenakarte;
	}

	public String getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}

	public Prevoznik getPrevoznik() {
		return prevoznik;
	}

	public void setPrevoznik(Prevoznik prevoznik) {
		this.prevoznik = prevoznik;
		if(prevoznik!=null && !prevoznik.getLinije().contains(this)){
			prevoznik.getLinije().add(this);
	}
	
	
	
	

}
}