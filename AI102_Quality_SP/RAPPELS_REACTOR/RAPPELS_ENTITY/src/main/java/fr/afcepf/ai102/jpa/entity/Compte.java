package fr.afcepf.ai102.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "banque_compte")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_de_compte")
public class Compte implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compte_numero")
    private Integer numero;
    @Column(name = "compte_date_creation", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @OneToMany(mappedBy = "compte")
    private List<Operation> operations;
    @Transient
    public Double getSolde() {
        return 0.0;
    }
    public Compte() {
        super();
    }
    public Compte(Integer paramNumero, Date paramDateCreation) {
        super();
        numero = paramNumero;
        dateCreation = paramDateCreation;
    }
    public Integer getNumero() {
        return numero;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setNumero(Integer paramNumero) {
        numero = paramNumero;
    }
    public void setDateCreation(Date paramDateCreation) {
        dateCreation = paramDateCreation;
    }
    
    public List<Operation> getOperations() {
        return operations;
    }
    public void setOperations(List<Operation> paramOperations) {
        operations = paramOperations;
    }
}
