package fr.afcepf.ai102.jpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "banque_conseiller")
public class Conseiller extends Personne {
    @OneToMany(mappedBy = "conseil")
    private List<Particulier> particuliers;
    @OneToMany(mappedBy = "conseil")
    private List<Societe> societes;
    public Conseiller() {
    }
    public Conseiller(Integer paramId, String paramNom, String paramMail, String paramPassword, Date paramDob) {
        super(paramId, paramNom, paramMail, paramPassword, paramDob);
    }
    public List<Particulier> getParticuliers() {
        return particuliers;
    }
    public List<Societe> getSocietes() {
        return societes;
    }
    public void setParticuliers(List<Particulier> paramParticuliers) {
        particuliers = paramParticuliers;
    }
    public void setSocietes(List<Societe> paramSocietes) {
        societes = paramSocietes;
    }
}
