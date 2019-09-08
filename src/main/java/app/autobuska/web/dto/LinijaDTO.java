package app.autobuska.web.dto;

public class LinijaDTO {
	
	private Long id;
	
	private int brojmesta;
	
	private String vremepolaska;
	
	private double cenakarte;
	
	private String destinacija;
	
	private Long prevoznikId;
	
	private String prevoznikNaziv;

	
	public Long getId() {
		return id;
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
	
	public String getVremepolaska() {
		return vremepolaska;
	}

	public void setVremepolaska(String vremepolaska) {
		this.vremepolaska = vremepolaska;
	}

	public String getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}

	public Long getPrevoznikId() {
		return prevoznikId;
	}

	public void setPrevoznikId(Long prevoznikId) {
		this.prevoznikId = prevoznikId;
	}

	public String getPrevoznikNaziv() {
		return prevoznikNaziv;
	}

	public void setPrevoznikNaziv(String prevoznikNaziv) {
		this.prevoznikNaziv = prevoznikNaziv;
	}
	
	

}
