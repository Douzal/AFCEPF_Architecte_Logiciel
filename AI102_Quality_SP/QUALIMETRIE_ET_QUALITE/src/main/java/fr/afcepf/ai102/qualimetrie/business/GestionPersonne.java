package fr.afcepf.ai102.qualimetrie.business;

import java.sql.SQLException;
import java.util.List;

import fr.afcepf.ai102.qualimetrie.data.DaoAdresse;
import fr.afcepf.ai102.qualimetrie.data.DaoPersonne;
import fr.afcepf.ai102.qualimetrie.data.DaoVille;
import fr.afcepf.ai102.qualimetrie.data.IDaoAdresse;
import fr.afcepf.ai102.qualimetrie.data.IDaoPersonne;
import fr.afcepf.ai102.qualimetrie.data.IDaoVille;
import fr.afcepf.ai102.qualimetrie.entity.CP;
import fr.afcepf.ai102.qualimetrie.entity.Personne;
import fr.afcepf.ai102.qualimetrie.entity.Ville;
import fr.afcepf.ai102.qualimetrie.exception.QualitEnum;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;
/**
 * Implementation des services metier.
 * @author Formation
 *
 */
public class GestionPersonne implements IGestionPersonne {
    /**
     * dependence vers le daoAdresse.
     */
    private IDaoAdresse daoAdresse = new DaoAdresse();
    /**
     * dependence vers le daoPersonne.
     */
    private IDaoPersonne daoPersonne = new DaoPersonne();
    /**
     * dependence vers le daoVille.
     */
    private IDaoVille daoVille = new DaoVille();
    @Override
    public List<Ville> getAllVille() throws QualitException {
        return daoVille.getAll();
    }

    @Override
    public List<Ville> getVillesByCP(CP paramCp) throws QualitException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CP> getAllCP() throws QualitException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CP> getCPByVille(Ville paramVille) throws QualitException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Personne ajouter(Personne paramPersonne) throws QualitException {
        if (!daoPersonne.verifMail(paramPersonne.getMail())) {
            if (paramPersonne.getAdresse() != null) {
                paramPersonne.setAdresse(
                        daoAdresse.ajouter(paramPersonne.getAdresse()));
            }
            paramPersonne = daoPersonne.ajouter(paramPersonne);
        } else {
            throw new QualitException("AHHhHHHHH!!!!",
                    QualitEnum.BUSINESS_MAIL_EXISTE);
        }
        return paramPersonne;
    }

    @Override
    public List<Personne> rechercher(String paramNom) throws QualitException {
        return daoPersonne.rechercher(paramNom);
    }

    @Override
    public Personne connexion(String paramNom, String paramPassword) throws SQLException, QualitException {
        // TODO Auto-generated method stub
        return daoPersonne.connexion(paramNom, paramPassword);
    }

    @Override
    public List<Personne> getAllPersonne() throws SQLException, QualitException {
        // TODO Auto-generated method stub
        return daoPersonne.getAllPersonne();
    }

    @Override
    public void deletePersonne(Personne paramPersonne) {
        daoPersonne.deletePersonne(paramPersonne);     
    }

}
