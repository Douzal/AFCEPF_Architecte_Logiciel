package fr.afcepf.squad.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin extends Membre {

    //bouarp
    //ca pourra peut etre servir
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Admin() {
        super();
    }
}
