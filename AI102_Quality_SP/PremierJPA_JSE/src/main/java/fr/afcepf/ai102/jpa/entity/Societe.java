package fr.afcepf.ai102.jpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "banque_societe")
public class Societe extends Personne {
    @Column(name = "societe_siret", nullable = false, length = 13)
    private String siret;
    @ManyToOne
    @JoinColumn(name = "id_conseiller", nullable = false,
            foreignKey = @ForeignKey(name = "FK_Societe_Conseiller"))
    private Conseiller conseil;
    @OneToMany(mappedBy = "societe")
    private List<CompteSociete> comptes;
    public Societe() {
        super();
    }
    public Societe(Integer paramId, String paramNom, String paramMail, String paramPassword, Date paramDob,
            String paramSiret, Conseiller paramConseil) {
        super(paramId, paramNom, paramMail, paramPassword, paramDob);
        siret = paramSiret;
        conseil = paramConseil;
    }
    public String getSiret() {
        return siret;
    }
    public Conseiller getConseil() {
        return conseil;
    }
    public List<CompteSociete> getComptes() {
        return comptes;
    }
    public void setSiret(String paramSiret) {
        siret = paramSiret;
    }
    public void setConseil(Conseiller paramConseil) {
        conseil = paramConseil;
    }
    public void setComptes(List<CompteSociete> paramComptes) {
        comptes = paramComptes;
    }
}
