package fr.afcepf.squad.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="confrontation")
public class Confrontation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_confrontation")
	private Integer id;

	@Column(name="round", nullable=true)
	private Integer round;

	@ManyToOne()
	@JoinColumn(name="id_evenement", foreignKey=@ForeignKey(name="fk_confrontation_evenement"))
	private Evenement evenement;

	@OneToMany(mappedBy="confrontation", cascade={CascadeType.MERGE,CascadeType.PERSIST})
	private List<ResultatConfrontation> resultats;

	public Confrontation() {
		super();
	}

	public Confrontation(Integer id, Integer round, Evenement evenement) {
		super();
		this.id = id;
		this.round = round;
		this.evenement = evenement;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public List<ResultatConfrontation> getResultats() {
		return resultats;
	}

	public void setResultats(List<ResultatConfrontation> resultats) {
		this.resultats = resultats;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getRound() {
		return round;
	}

	public void setRound(Integer round) {
		this.round = round;
	}
}
