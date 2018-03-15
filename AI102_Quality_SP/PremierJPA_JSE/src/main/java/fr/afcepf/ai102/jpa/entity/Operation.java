package fr.afcepf.ai102.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "foo")
    @TableGenerator(name = "foo", allocationSize = 1)
    @Column(name = "operation_id")
    private Integer id;
    @Column(name = "operation_date_operation", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOp;
    @Column(name = "operation_montant", nullable = false,
            columnDefinition = "DECIMAL(10,2)")    
    private Double montant;
    @ManyToOne
    @JoinColumn(name = "id_compte", foreignKey = @ForeignKey(name = "FK_compte_operation"))
    private Compte compte;
    public Compte getCompte() {
        return compte;
    }
    public void setCompte(Compte paramCompte) {
        compte = paramCompte;
    }
    public Operation() {
        super();
    }
    
    public Operation(Integer paramId, Date paramDateOp, Double paramMontant, Compte paramCompte) {
        super();
        id = paramId;
        dateOp = paramDateOp;
        montant = paramMontant;
        compte = paramCompte;
    }
    public Integer getId() {
        return id;
    }
    public Date getDateOp() {
        return dateOp;
    }
    public Double getMontant() {
        return montant;
    }
    public void setId(Integer paramId) {
        id = paramId;
    }
    public void setDateOp(Date paramDateOp) {
        dateOp = paramDateOp;
    }
    public void setMontant(Double paramMontant) {
        montant = paramMontant;
    }
    
}
