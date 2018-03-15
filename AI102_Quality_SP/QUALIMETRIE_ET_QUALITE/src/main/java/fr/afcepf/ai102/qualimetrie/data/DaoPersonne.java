package fr.afcepf.ai102.qualimetrie.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
     * Requete pour l'ajout d'une personne.
     */
    private static final String REQ_AJOUT_SANS_ADRESSE =
            "INSERT INTO personne "
            + "(nom, prenom, mail, naissance, password) "
            + "VALUES (?, ?, ?, ?, ?)";
    /**
     * Requete pour la recherche de personne par nom partiel.
     */
    private static final String REQ_FIND_BY_NAME =
            "SELECT id, nom, prenom, password, naissance, mail FROM personne WHERE nom like ?";
    /**
     * indice du param nom dans la requete de recherche.
     */
    private static final int REQ_FIND_INDEX_NOM = 1;
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
            PreparedStatement pstmt = null;
            if (paramPersonne.getAdresse() != null) {
                pstmt = cnx.prepareStatement(
                    REQ_AJOUT, Statement.RETURN_GENERATED_KEYS);
                pstmt.setInt(REQ_AJOUT_INDEX_ADRESSE,
                        paramPersonne.getAdresse().getId());
            } else {
                pstmt = cnx.prepareStatement(
                    REQ_AJOUT_SANS_ADRESSE, Statement.RETURN_GENERATED_KEYS);
            }
            pstmt.setString(REQ_AJOUT_INDEX_NOM, paramPersonne.getNom());
            pstmt.setString(REQ_AJOUT_INDEX_MAIL, paramPersonne.getMail());
            pstmt.setString(REQ_AJOUT_INDEX_MDP, paramPersonne.getMdp());
            pstmt.setString(REQ_AJOUT_INDEX_PRENOM, paramPersonne.getPrenom());
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
    @Override
    public List<Personne> rechercher(String paramNom) throws QualitException {
        List<Personne> liste = new ArrayList<>();
        try (Connection cnx = ds.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(REQ_FIND_BY_NAME);
            pstmt.setString(REQ_FIND_INDEX_NOM, new StringBuilder()
                                                    .append("%")
                                                    .append(paramNom)
                                                    .append("%").toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                liste.add(new Personne(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("mail"),
                        "************",
                        null,
                        rs.getDate("naissance")));
            }
            return liste;
        } catch (Exception e) {
            QualitException qe = new QualitException(e.getMessage(),
                    QualitEnum.SERVEUR_DONNEES_HS);
            qe.setStackTrace(e.getStackTrace());
            log.debug(e.getMessage());
            throw qe;
        }
    }
    private final static String REQ_CONNEXION = "SELECT * from Personne p where "
            + "p.nom = ? and p.password = ?";
    private final  static int indexParamNomConnect = 1;
    private final static int indexParamPasswordConnect = 2;
    @Override
    public Personne connexion(String paramNom, String paramPassword) throws QualitException {
        Connection cnx = null;
        Personne pers = null;
        System.out.println("Dans le DAO");
        try {
            cnx = ds.getConnection();
            PreparedStatement ps = cnx.prepareStatement(REQ_CONNEXION);
            ps.setString(indexParamNomConnect, paramNom);
            ps.setString(indexParamPasswordConnect, paramPassword);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                pers = new Personne(rs.getInt("id"), 
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("mail"),
                        rs.getString("password"),
                        null,
                        rs.getDate("naissance"));
                System.out.println(pers.toString());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            
        }
        return pers;
    }
    private final static String REQ_GET_ALL = "SELECT * from Personne";
    @Override
    public List<Personne> getAllPersonne() throws QualitException {
        List<Personne> personnes = new ArrayList<>();
        Connection cnx = null;
        try {
            cnx = ds.getConnection();
            PreparedStatement ps = cnx.prepareStatement(REQ_GET_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                personnes.add(new Personne(rs.getInt("id"), 
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("mail"),
                            rs.getString("password"),
                            null,
                            rs.getDate("naissance")));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       
        return personnes;
    }
    private final static String REQ_DELETE = "DELETE from Personne where id = ?";
    private final static int paramDeletePersonne = 1;
    @Override
    public void deletePersonne(Personne paramPersonne) {
        Connection cnx = null;
        
        try {
            cnx = ds.getConnection();
            PreparedStatement ps = cnx.prepareStatement(REQ_DELETE);
            ps.setInt(paramDeletePersonne, paramPersonne.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        
    }

}
