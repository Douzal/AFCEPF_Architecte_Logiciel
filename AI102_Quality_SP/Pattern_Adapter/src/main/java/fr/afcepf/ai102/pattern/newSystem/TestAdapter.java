package fr.afcepf.ai102.pattern.newSystem;

public class TestAdapter {
    public static void main(String[] args) {
        IDaoPersonne dao = new Adapter();
        Personne pers = dao.connexion("", "");
        System.out.println(pers.getNom());
        dao.inscrire(new Personne(0, "paramNom", "paramCourriel", "paramMdp"));
    }
}
