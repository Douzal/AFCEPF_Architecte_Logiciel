package fr.afcepf.ai102.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "banque_credit")
public class Credit extends Operation {

    public Credit() {
        super();
    }

    public Credit(Integer paramId, Date paramDateOp, Double paramMontant, Compte paramCompte) {
        super(paramId, paramDateOp, paramMontant, paramCompte);
        // TODO Auto-generated constructor stub
    }

    
    
}
