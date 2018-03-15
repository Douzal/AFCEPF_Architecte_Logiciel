package fr.afcepf.ai102.pattern;

public class CanardPlastique extends Canard {

    public CanardPlastique(Comportement paramCompo) {
        super(paramCompo);
    }

    @Override
    void faireUnTruc() {
        System.out.println("le canard en plastique fait : " + 
                getComportement().foo());
    }
    
}
