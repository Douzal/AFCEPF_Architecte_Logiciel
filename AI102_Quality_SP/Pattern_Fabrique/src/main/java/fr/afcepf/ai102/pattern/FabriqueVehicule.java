package fr.afcepf.ai102.pattern;
public final class FabriqueVehicule {
    private FabriqueVehicule() {
    }
    public static Vehicule createVehicule(String type) {
        try {
            return (Vehicule) Class.forName(type).newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}