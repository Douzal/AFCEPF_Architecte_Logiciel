package fr.afcepf.ai102.qualimetrie.data;

import fr.afcepf.ai102.qualimetrie.entity.Adresse;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

/**
 * définition des services de persistence
 * pour l'entité {@link Adresse}.
 * @author Formation
 *
 */
public interface IDaoAdresse {
    /**
     * Méthode pour faire persister une entité {@link Adresse}.
     * @param paramAdresse Adresse to persist.
     * @return
     * un objet adresse avec sa clé primaire.
     * @throws QualitException
     * <ul>
     *  <li>données trop longues</li>
     *  <li>données nulles non autorisées</li>
     *  <li>serveur de données ne repond pas</li>
     *  <li>mal dév (mais faut pas le dire)!!!</li>
     * </ul>
     */
    Adresse ajouter(Adresse paramAdresse)
        throws QualitException;
}
