package fr.afcepf.ai102.jee.data.api;

import java.util.List;

import fr.afcepf.ai102.jpa.entity.Compte;
import fr.afcepf.ai102.jpa.entity.Operation;

public interface IDaoOperation {
    List<Operation> rechercherOperation(Compte cpt);
}
