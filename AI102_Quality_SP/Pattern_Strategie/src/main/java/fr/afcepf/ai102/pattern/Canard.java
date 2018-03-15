package fr.afcepf.ai102.pattern;

public abstract class Canard {
    private Comportement comportement;
    abstract void faireUnTruc();
    public Canard(Comportement compo) {
        comportement = compo;
    }
    public void setComportement(Comportement paramComportement) {
        comportement = paramComportement;
    }
    public Comportement getComportement() {
        return comportement;
    }
    
}
