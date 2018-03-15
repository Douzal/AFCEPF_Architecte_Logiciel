package fr.afcepf.ai102.qualimetrie.data;

import java.util.List;

import fr.afcepf.ai102.qualimetrie.entity.CP;
import fr.afcepf.ai102.qualimetrie.entity.Ville;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

/**
 * définition des services de persistence
 * pour l'entité {@link Ville}.
 * @author Formation
 *
 */
public interface IDaoVille {
    /**
     * service permettant de rechercher toutes
     * les entités {@link Ville} dans l'unité de
     * persistance.
     * @return
     * <ul>
     *  <li>une {@link List} de toutes les {@link Ville}.</li>
     *  <li>vide si aucunes</li>
     * </ul>
     * @throws QualitException
     * <ul>
     *  <li>serveur de données ne repond pas</li>
     *  <li>mal dév (mais faut pas le dire)!!!</li>
     * </ul>
     */
    List<Ville> getAll() throws QualitException;
    /**
     * service permettant de rechercher toutes
     * les entités {@link Ville} dans l'unité de
     * persistance pour un {@link CP} donné.
     * @param paramCp le CP.
     * @return
     * <ul>
     *  <li>une {@link List} de toutes les {@link Ville}.</li>
     *  <li>vide si aucunes</li>
     * </ul>
     * @throws QualitException
     * <ul>
     *  <li>serveur de données ne repond pas</li>
     *  <li>mal dév (mais faut pas le dire)!!!</li>
     * </ul>
     */
    List<Ville> getByCP(CP paramCp) throws QualitException;
}
