package fr.afcepf.ai102.qualimetrie.data;

import fr.afcepf.ai102.qualimetrie.entity.Personne;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

/**
 * définition des services de persistence
 * pour l'entité {@link Personne}.
 * @author Formation
 *
 */
public interface IDaoPersonne {
    /**
     * Méthode pour faire persister une entité {@link Personne}.
     * @param paramPersonne personne to persist.
     * @return
     * un objet personne avec sa clé primaire.
     * @throws QualitException
     * <ul>
     *  <li>données trop longues</li>
     *  <li>données nulles non autorisées</li>
     *  <li>violation de contraintes</li>
     *  <li>serveur de données ne repond pas</li>
     *  <li>mal dév (mais faut pas le dire)!!!</li>
     * </ul>
     */
    Personne ajouter(Personne paramPersonne)
        throws QualitException;
    /**
     * service permettant de verifier l'existance
     * d'un mail dans l'unité de persistence pour
     * l'entité {@link Personne}.
     * @param mail le mail a trouver.
     * @return
     * <ul>
     *  <li>true: il existe</li>
     *  <li>false: il existe pas</li>
     * </ul>
     * @throws QualitException
     * <ul>
     *  <li>serveur de données ne repond pas</li>
     *  <li>mal dév (mais faut pas le dire)!!!</li>
     * </ul>
     */
    Boolean verifMail(String mail) throws QualitException;
}
