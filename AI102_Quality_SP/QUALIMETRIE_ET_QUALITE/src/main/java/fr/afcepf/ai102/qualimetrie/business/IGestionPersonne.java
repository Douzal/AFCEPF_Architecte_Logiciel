package fr.afcepf.ai102.qualimetrie.business;

import java.sql.SQLException;
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
    /**
     * Méthode pour rechercher une Collection (ordonnée) d'entité(s) {@link Personne}
     * par un nom partiel.
     * @param paramNom le nom ou la partie du nom a rechercher.
     * @return
     * <ul>
     *  <li>une {@link java.util.List} de {@link Personne} dont le nom contient paramNom</li>
     *  <li>exemples :
     *      <ol>
     *          <li>une recherche de 'du' trouvera :
     *          <ul>
     *              <li>'du'pond</li>
     *              <li>'du'pont</li>
     *              <li>... 'du' ...</li>
     *          </ul>
     *          <li>
     *      </ol>
     *  </li>
     *  <li>une {@link java.util.List} vide si aucun résultat.</li>
     * </ul>
     * @throws QualitException
     * <ul>
     *  <li>serveur de données ne repond pas</li>
     *  <li>mal dév (mais faut pas le dire)!!!</li>
     * </ul>
     */
    List<Personne> rechercher(String paramNom) throws QualitException;
    Personne connexion(String paramNom, String paramPassword) throws SQLException, QualitException;
    List<Personne> getAllPersonne() throws SQLException, QualitException;
    void deletePersonne(Personne paramPersonne);
}
