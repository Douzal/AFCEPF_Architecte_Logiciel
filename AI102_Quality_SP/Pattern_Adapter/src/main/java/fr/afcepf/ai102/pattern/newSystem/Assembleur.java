package fr.afcepf.ai102.pattern.newSystem;

import fr.afcepf.ai102.pattern.oldSystem.Person;

public final class Assembleur {
    private Assembleur() {
    }
    public static Personne personToPersonne(Person pers) {
        return new Personne(pers.getIdent(), pers.getFirstName(),
                            pers.getMail(), pers.getPassword());
    }
    public static Person personneToPerson(Personne pers) {
        return new Person(pers.getId(), pers.getNom(),
                          pers.getCourriel(), pers.getMdp());
    }
}