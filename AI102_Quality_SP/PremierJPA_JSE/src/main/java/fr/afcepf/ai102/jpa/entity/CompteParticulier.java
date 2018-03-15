package fr.afcepf.ai102.jpa.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "compte_particulier")
public class CompteParticulier extends Compte {
    @ManyToOne
    @JoinColumn(name = "id_particulier",
               foreignKey = @ForeignKey(name = "FK_compte_particulier"))   
    private Particulier particulier;
    public CompteParticulier() {
    }
    public CompteParticulier(Integer paramNumero, Date paramDateCreation, Particulier paramParticulier) {
        super(paramNumero, paramDateCreation);
        particulier = paramParticulier;
    }
    public Particulier getParticulier() {
        return particulier;
    }
    public void setParticulier(Particulier paramParticulier) {
        particulier = paramParticulier;
    }
}
