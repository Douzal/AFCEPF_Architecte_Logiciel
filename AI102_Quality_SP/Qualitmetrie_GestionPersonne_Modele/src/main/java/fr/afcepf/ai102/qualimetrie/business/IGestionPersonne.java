package fr.afcepf.ai102.qualimetrie.business;

import java.util.List;

import fr.afcepf.ai102.qualimetrie.entity.CP;
import fr.afcepf.ai102.qualimetrie.entity.Personne;
import fr.afcepf.ai102.qualimetrie.entity.Ville;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

/**
 * Service metier pour l'enregistrement d'une
 * entité {@link Personne}.
 * @author Formation
 *
 */
public interface IGestionPersonne {
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
     *  <li>une erreur dans le(s) DAO</li>
     *  <li>mal dév (mais faut pas le dire)!!!</li>
     * </ul>
     */
    List<Ville> getAllVille() throws QualitException;
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
     *  <li>une erreur dans le(s) DAO</li>
     *  <li>mal dév (mais faut pas le dire)!!!</li>
     * </ul>
     */
    List<Ville> getVillesByCP(CP paramCp) throws QualitException;
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
     *  <li>une erreur dans le(s) DAO</li>
     *  <li>mal dév (mais faut pas le dire)!!!</li>
     * </ul>
     */
    List<CP> getAllCP() throws QualitException;
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
     *  <li>une erreur dans le(s) DAO</li>
     *  <li>mal dév (mais faut pas le dire)!!!</li>
     * </ul>
     */
    List<CP> getCPByVille(Ville paramVille) throws QualitException;
    /**
     * Méthode pour faire persister une entité {@link Personne}.
     * le mail ne doit pas etre present dans le S.I.
     * @param paramPersonne personne to persist.
     * @return
     * un objet personne avec sa clé primaire.
     * @throws QualitException
     * <ul>
     *  <li>mail existe déjà</li>
     *  <li>une erreur dans le(s) DAO</li>
     *  <li>mal dév (mais faut pas le dire)!!!</li>
     * </ul>
     */
    Personne ajouter(Personne paramPersonne)
        throws QualitException;
}
