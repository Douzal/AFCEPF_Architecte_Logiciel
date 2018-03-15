package fr.afcepf.ai102.qualimetrie.data;

import java.util.List;

import fr.afcepf.ai102.qualimetrie.entity.CP;
import fr.afcepf.ai102.qualimetrie.entity.Ville;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

/**
 * définition des services de persistence
 * pour l'entité {@link CP}.
 * @author Formation
 *
 */
public interface IDaoCP {
    /**
     * service permettant de rechercher toutes
     * les entités {@link Ville} dans l'unité de
     * persistance.
     * @return
     * <ul>
     *  <li>une {@link List} de toutes les {@link CP}.</li>
     *  <li>vide si aucunes</li>
     * </ul>
     * @throws QualitException
     * <ul>
     *  <li>serveur de données ne repond pas</li>
     *  <li>mal dév (mais faut pas le dire)!!!</li>
     * </ul>
     */
    List<CP> getAll() throws QualitException;
    /**
     * service permettant de rechercher toutes
     * les entités {@link CP} dans l'unité de
     * persistance pour un {@link Ville} donné.
     * @param paramVille la ville.
     * @return
     * <ul>
     *  <li>une {@link List} de toutes les {@link CP}.</li>
     *  <li>vide si aucunes</li>
     * </ul>
     * @throws QualitException
     * <ul>
     *  <li>serveur de données ne repond pas</li>
     *  <li>mal dév (mais faut pas le dire)!!!</li>
     * </ul>
     */
    List<CP> getByVille(Ville paramVille) throws QualitException;
}
