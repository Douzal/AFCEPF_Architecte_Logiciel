package fr.afcepf.al31.clapier.entity;

public class Affectation {
	private Integer id;
	private Lapin lapin;
	private Clapier clapier;
	public Affectation() {
		super();
	}
	public Affectation(Integer id, Lapin lapin, Clapier clapier) {
		super();
		this.id = id;
		this.lapin = lapin;
		this.clapier = clapier;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Lapin getLapin() {
		return lapin;
	}
	public void setLapin(Lapin lapin) {
		this.lapin = lapin;
	}
	public Clapier getClapier() {
		return clapier;
	}
	public void setClapier(Clapier clapier) {
		this.clapier = clapier;
	}
	
}
