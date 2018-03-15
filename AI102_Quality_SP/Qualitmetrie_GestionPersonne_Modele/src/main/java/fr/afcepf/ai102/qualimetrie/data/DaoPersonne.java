package fr.afcepf.ai102.qualimetrie.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import fr.afcepf.ai102.qualimetrie.entity.Personne;
import fr.afcepf.ai102.qualimetrie.exception.QualitEnum;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;
/**
 * Implementation des services de persistence pour l'entité {@link Personne}.
 * @author Formation
 *
 */
public class DaoPersonne implements IDaoPersonne {
    /**
     * definition de la datasource pour l'accès a la bdd.
     */
    private DataSource ds = new Ai102DataSource();
    /**
     * Pour les logs (INTERDIT AUX SYSO).
     */
    private Logger log = Logger.getLogger(getClass());
    /**
     * Requete pour la verification du mail.
     */
    private static final String REQ_VERIF_MAIL =
            "SELECT count(mail) FROM personne WHERE mail = ?";
    /**
     * Requete pour l'ajout d'une personne.
     */
    private static final String REQ_AJOUT =
            "INSERT INTO personne "
            + "(nom, prenom, mail, naissance, password, id_adresse) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    /**
     * index du parametre nom dans la requete d'ajout.
     */
    private static final int REQ_AJOUT_INDEX_NOM = 1;
    /**
     * index du parametre prenom dans la requete d'ajout.
     */
    private static final int REQ_AJOUT_INDEX_PRENOM = 2;
    /**
     * index du parametre mail dans la requete d'ajout.
     */
    private static final int REQ_AJOUT_INDEX_MAIL = 3;
    /**
     * index du parametre naissance dans la requete d'ajout.
     */
    private static final int REQ_AJOUT_INDEX_NAISSANCE = 4;
    /**
     * index du parametre password dans la requete d'ajout.
     */
    private static final int REQ_AJOUT_INDEX_MDP = 5;
    /**
     * index du parametre id_adresse dans la requete d'ajout.
     */
    private static final int REQ_AJOUT_INDEX_ADRESSE = 6;
    /**
     * index de l'id generé par la requete d'ajout.
     */
    private static final int REQ_AJOUT_ID = 1;
    @Override
    public Personne ajouter(Personne paramPersonne) throws QualitException {
        try (Connection cnx = ds.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(
                    REQ_AJOUT, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(REQ_AJOUT_INDEX_NOM, paramPersonne.getNom());
            pstmt.setString(REQ_AJOUT_INDEX_MAIL, paramPersonne.getMail());
            pstmt.setString(REQ_AJOUT_INDEX_MDP, paramPersonne.getMdp());
            pstmt.setString(REQ_AJOUT_INDEX_PRENOM, paramPersonne.getPrenom());
            pstmt.setInt(REQ_AJOUT_INDEX_ADRESSE,
                            paramPersonne.getAdresse().getId());
            pstmt.setDate(REQ_AJOUT_INDEX_NAISSANCE,
                    new java.sql.Date(paramPersonne.getDob().getTime()));
            pstmt.executeUpdate();
            ResultSet rsKey = pstmt.getGeneratedKeys();
            if (rsKey.next()) {
                paramPersonne.setId(rsKey.getInt(REQ_AJOUT_ID));
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            QualitException exept = new QualitException();
            exept.setStackTrace(e.getStackTrace());
            setCodeError(e, exept);
            throw exept;
        }
        return paramPersonne;
    }
    /**
     * définition du code error pour l'ajout.
     * @param e l'exception native.
     * @param paramExept la notre.
     */
    private void setCodeError(Exception e, QualitException paramExept) {
        if (e.getMessage().contains("too long")) {
            paramExept.setCodeErreur(
                    QualitEnum.DATA_VIOLATION_CONTRAINTE_DONNEES_TOO_LONG);
        } else if (e.getMessage().contains("null")) {
            paramExept.setCodeErreur(
                    QualitEnum.DATA_VIOLATION_CONTRAINTE_DONNEES_NULL);
        } else if (e.getMessage().contains("constraint")) {
            paramExept.setCodeErreur(
                    QualitEnum.DATA_VIOLATION_CONTRAINTE_INTEGRITE);
        } else {
            paramExept.setCodeErreur(
                    QualitEnum.SERVEUR_DONNEES_HS);
        }
    }

    @Override
    public Boolean verifMail(String paramMail) throws QualitException {
        try (Connection cnx = ds.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(REQ_VERIF_MAIL);
            pstmt.setString(1, paramMail);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt(1) == 1;
        } catch (Exception e) {
            QualitException qe = new QualitException(e.getMessage(),
                    QualitEnum.SERVEUR_DONNEES_HS);
            qe.setStackTrace(e.getStackTrace());
            log.debug(e.getMessage());
            throw qe;
        }
    }

}
