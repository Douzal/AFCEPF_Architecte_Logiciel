package fr.afcepf.ai102.qualimetrie.exception;
/**
 * Liste des codes d'erreur de l'application.
 * @author Formation
 *
 */
public enum QualitEnum {
    /**
     * on sait pas mais ca marche pas.
     */
    CA_MARCHE_PAS,
    /**
     * le serveur ne repond pas.
     */
    SERVEUR_DONNEES_HS,
    /**
     * probleme de not-null dans le systeme de persistence.
     */
    DATA_VIOLATION_CONTRAINTE_DONNEES_NULL,
    /**
     * probleme de volume de données dans le systeme de persistence.
     */
    DATA_VIOLATION_CONTRAINTE_DONNEES_TOO_LONG,
    /**
     * probleme de cle etrangere.
     */
    DATA_VIOLATION_CONTRAINTE_INTEGRITE,
    /**
     * le mail existe (dans regle metier voir SFD).
     */
    BUSINESS_MAIL_EXISTE
}
