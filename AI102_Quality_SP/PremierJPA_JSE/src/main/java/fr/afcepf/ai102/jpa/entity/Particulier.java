package fr.afcepf.ai102.jpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "banque_particulier")
public class Particulier extends Personne {
    @Column(name = "interdit_bancaire", columnDefinition = "TINYINT(1)", nullable = false)
    private boolean interditBancaire;
    @ManyToOne
    @JoinColumn(name = "id_conseiller", nullable = false,
            foreignKey = @ForeignKey(name = "FK_Particulier_Conseiller"))
    private Conseiller conseil;
    @OneToMany(mappedBy = "particulier")
    private List<CompteParticulier> comptes;
    
    public Particulier(Integer paramId, String paramNom, String paramMail, String paramPassword, Date paramDob,
            boolean paramInterditBancaire, Conseiller paramConseil) {
        super(paramId, paramNom, paramMail, paramPassword, paramDob);
        interditBancaire = paramInterditBancaire;
        conseil = paramConseil;
    }
    public Particulier() {
    }
    public boolean isInterditBancaire() {
        return interditBancaire;
    }
    public Conseiller getConseil() {
        return conseil;
    }
    public List<CompteParticulier> getComptes() {
        return comptes;
    }
    public void setInterditBancaire(boolean paramInterditBancaire) {
        interditBancaire = paramInterditBancaire;
    }
    public void setConseil(Conseiller paramConseil) {
        conseil = paramConseil;
    }
    public void setComptes(List<CompteParticulier> paramComptes) {
        comptes = paramComptes;
    }
}
