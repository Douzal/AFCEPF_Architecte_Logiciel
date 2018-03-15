package fr.afcepf.ai102.jpa.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "compte_pro")
public class CompteSociete extends Compte {
    @ManyToOne
    @JoinColumn(name = "id_societe",
               foreignKey = @ForeignKey(name = "FK_compte_societe"))   
    private Societe societe;
    public CompteSociete() {
        super();
    }
    public CompteSociete(Integer paramNumero, Date paramDateCreation, Societe paramSociete) {
        super(paramNumero, paramDateCreation);
        societe = paramSociete;
    }

    public Societe getSociete() {
        return societe;
    }


    public void setSociete(Societe paramSociete) {
        societe = paramSociete;
    }
}
