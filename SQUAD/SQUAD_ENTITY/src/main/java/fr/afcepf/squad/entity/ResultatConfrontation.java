package fr.afcepf.squad.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import fr.afcepf.squad.key.ResultatConfrontationPK;

@Entity
@Table(name="resultat_confrontation")
public class ResultatConfrontation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id_equipe", foreignKey=@ForeignKey(name="fk_resultat_equipe"),nullable=false)
	private Equipe equipe;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id_confrontation", foreignKey=@ForeignKey(name="fk_resultat_confrontation"),nullable=false)
	private Confrontation confrontation;

	//pas necessaire de distinguer score et temps je pense, why ?:
	//dans tous les cas on stockera un nombre: soit le nombre de point, soit un temps exprimé en nombre de secondes genre timestamp.
	@Column(name="score", nullable=true)
	private Integer score;

	public ResultatConfrontation() {
		super();
	}


	public ResultatConfrontation(Integer id, Equipe equipe, Confrontation confrontation, Integer score) {
		super();
		this.id = id;
		this.equipe = equipe;
		this.confrontation = confrontation;
		this.score = score;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Confrontation getConfrontation() {
		return confrontation;
	}

	public void setConfrontation(Confrontation confrontation) {
		this.confrontation = confrontation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}

}
