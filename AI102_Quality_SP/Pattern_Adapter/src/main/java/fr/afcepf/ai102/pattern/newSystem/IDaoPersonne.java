package fr.afcepf.ai102.pattern.newSystem;
public interface IDaoPersonne {
    public Personne inscrire(Personne pers);
    public Personne connexion(String courriel, String mdp);
}