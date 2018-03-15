package fr.afcepf.ai102.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "banque_debit")
public class Debit extends Operation {
    public Debit() {
        super();
    }

    public Debit(Integer paramId, Date paramDateOp, Double paramMontant, Compte paramCompte) {
        super(paramId, paramDateOp, paramMontant, paramCompte);
        // TODO Auto-generated constructor stub
    }
    
}
