package fr.afcepf.ai102.qualimetrie.data;

import fr.afcepf.ai102.qualimetrie.entity.Adresse;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;
/**
 * implementation des services de persistence pour l'adresse.
 * @author Formation
 *
 */
public class DaoAdresse implements IDaoAdresse {

    @Override
    public Adresse ajouter(Adresse paramAdresse) throws QualitException {
        System.out.println("dans dao adresse");
        return null;
    }

}
