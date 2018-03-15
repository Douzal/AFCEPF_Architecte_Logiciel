package fr.afcepf.ai102.qualimetrie.data;

import java.sql.SQLException;
import java.util.List;

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
    Personne connexion (String paramNom, String paramPassword) throws  QualitException;
    List<Personne> getAllPersonne() throws SQLException, QualitException;
    void deletePersonne(Personne paramPersonne);
}
