package fr.afcepf.ai102.pattern;

public class Test {
    public static void main(String[] args) {
        Canard c = new CanardPlastique(new CoinCoin());
        c.faireUnTruc();
        c.setComportement(new Vol());
        c.faireUnTruc();
        c.setComportement(new Cuire());
        c.faireUnTruc();
    }
}
