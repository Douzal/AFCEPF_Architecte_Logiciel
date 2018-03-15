package fr.afcepf.ai102.pattern;

public class TestFabrique {
    public static void main(String[] args) {
        Vehicule v = FabriqueVehicule.createVehicule(Voiture.class.getName());
        Vehicule v2 = FabriqueVehicule.createVehicule(Camion.class.getName());
        v.rouler();
        v2.rouler();
        FabriqueVehicule.createVehicule(VeloSolex.class.getName()).rouler();
    }
}
