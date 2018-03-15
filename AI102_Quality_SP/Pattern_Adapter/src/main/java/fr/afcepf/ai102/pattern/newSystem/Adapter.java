package fr.afcepf.ai102.pattern.newSystem;

import fr.afcepf.ai102.pattern.oldSystem.DaoPerson;
import fr.afcepf.ai102.pattern.oldSystem.IDaoPerson;
public class Adapter implements IDaoPersonne {
    public Adapter() {
    }
    private IDaoPerson daoPerson = new DaoPerson();
    public Personne inscrire(Personne pers) {
        return Assembleur.personToPersonne(
                daoPerson.add(Assembleur.personneToPerson(pers))
               );
    }
    public Personne connexion(String courriel, String mdp) {
        return Assembleur.personToPersonne(daoPerson.connect(courriel, mdp));
    }
}