package fr.afcepf.ai102.qualimetrie.entity;
/**
 * entité representant une ville.
 * @author Formation
 *
 */
public class Ville {
    /**
     * Identifiant de la ville.
     */
    private Integer id;
    /**
     * nom de la ville.
     */
    private String libelle;
    /**
     * Default Constructor.
     */
    public Ville() {
        super();
    }
    /**
     * @param paramId the id to set
     * @param paramLibelle the libelle to set
     */
    public Ville(Integer paramId, String paramLibelle) {
        super();
        id = paramId;
        libelle = paramLibelle;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param paramId the id to set
     */
    public void setId(Integer paramId) {
        id = paramId;
    }
    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * @param paramLibelle the libelle to set
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }
}
