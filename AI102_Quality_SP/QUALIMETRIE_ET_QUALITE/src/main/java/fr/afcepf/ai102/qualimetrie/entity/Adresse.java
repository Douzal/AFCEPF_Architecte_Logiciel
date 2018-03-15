package fr.afcepf.ai102.qualimetrie.entity;
/**
 * entité representant une Adresse d'une personne.
 * @author Formation
 *
 */
public class Adresse {
    /**
     * Identifiant de l'adresse.
     */
    private Integer id;
    /**
     * numero de l'adresse.
     */
    private String num;
    /**
     * rue de l'adresse.
     */
    private String rue;
    /**
     * Ville de l'adresse.
     */
    private Ville ville;
    /**
     * Code Postal de l'adresse.
     */
    private CP cp;
    /**
     * Default constructor.
     */
    public Adresse() {
        super();
    }
    /**
     * @param paramId the id to set.
     * @param paramNum the num to set.
     * @param paramRue the rue to set.
     * @param paramVille the ville to set.
     * @param paramCp th cp to set.
     */
    public Adresse(Integer paramId, String paramNum, String paramRue, Ville paramVille, CP paramCp) {
        super();
        id = paramId;
        num = paramNum;
        rue = paramRue;
        ville = paramVille;
        cp = paramCp;
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
     * @return the num
     */
    public String getNum() {
        return num;
    }
    /**
     * @param paramNum the num to set
     */
    public void setNum(String paramNum) {
        num = paramNum;
    }
    /**
     * @return the rue
     */
    public String getRue() {
        return rue;
    }
    /**
     * @param paramRue the rue to set
     */
    public void setRue(String paramRue) {
        rue = paramRue;
    }
    /**
     * @return the ville
     */
    public Ville getVille() {
        return ville;
    }
    /**
     * @param paramVille the ville to set
     */
    public void setVille(Ville paramVille) {
        ville = paramVille;
    }
    /**
     * @return the cp
     */
    public CP getCp() {
        return cp;
    }
    /**
     * @param paramCp the cp to set
     */
    public void setCp(CP paramCp) {
        cp = paramCp;
    }
}
