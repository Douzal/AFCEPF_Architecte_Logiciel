package fr.afcepf.ai31.rappels.object;

import org.apache.log4j.Logger;

public final class TestHeritage {
    private TestHeritage() {
        }
    
    private static Logger log = Logger.getLogger(TestHeritage.class);
    public static void main(String[] args) {
        // liste de stagiaires
        Stagiaire s1 = new Stagiaire(1, "Masson", "Doudouz");
        Personne s2 = new Stagiaire(2, "Zithman", "Daniel");
        IManger s3 = new Stagiaire(3, "Xopoulos", "Dimou");
        ITravailler s4 = new Stagiaire(4, "Xopoulos", "Dimou");
        Object s5 = new Stagiaire(5, "Xopoulos", "Dimou");
        Formateur f1 = new Formateur(6, "FormPéricard", "Séb");
        // typé en tant que personne, il ne peut donc faire que les actions de Formateur
        // ce qui compte, c'est ce qu'il y a dans le tas
        // ce qui compte c'est ce qui a été vraiment instancié
        Personne f2 = new Formateur(7, "Form2Mij", "Titi");
        Stagiaire s6 = new Stagiaire() {
            public boolean isMcDo() {
                return false;
            }
        };
        
        
        // on va faire manger tout le monde dans un array
        // on cast s4 et s5 pour accéder aux méthodes et avoir plus de visibilités sur l'objet
        IManger mangeurs[] = {s1, s2, s3, (IManger)s4, (IManger)s5, f1, f2};
        for (IManger iManger : mangeurs ) {
//            iManger.manger();
            if(iManger instanceof Stagiaire) {
                if(((Stagiaire) iManger).isMcDo()) {
                    log.debug("McDo");
                }
            } else if (iManger.getClass() == Formateur.class) {
                
            }
            log.debug(iManger.manger());
        }
        
    }
}
