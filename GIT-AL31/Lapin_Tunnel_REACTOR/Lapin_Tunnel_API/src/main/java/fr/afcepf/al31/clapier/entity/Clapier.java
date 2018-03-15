package fr.afcepf.al31.clapier.entity;

public class Clapier {
	private Integer id;
	private Integer numero;
	public Clapier() {
		super();
	}
	public Clapier(Integer id, Integer numero) {
		super();
		this.id = id;
		this.numero = numero;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
}
