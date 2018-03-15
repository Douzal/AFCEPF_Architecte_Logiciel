package fr.afcepf.ai102.qualimetrie.exception;
/**
 * Exception de l'application de qualité.
 * @author Formation
 *
 */
@SuppressWarnings("serial")
public class QualitException extends Exception {
    /**
     * Code d'erreur de l'exception.
     */
    private QualitEnum codeErreur = QualitEnum.CA_MARCHE_PAS;
    /**
     * Default Constructor.
     */
    public QualitException() {
    }
    /**
     * @param paramMessage the message to set.
     * @param paramCode the errorCode to set
     */
    public QualitException(String paramMessage, QualitEnum paramCode) {
        super(paramMessage);
        codeErreur = paramCode;
    }
    /**
     * @return the codeErreur
     */
    public QualitEnum getCodeErreur() {
        return codeErreur;
    }
    /**
     * @param paramCodeErreur the code to set.
     */
    public void setCodeErreur(QualitEnum paramCodeErreur) {
        codeErreur = paramCodeErreur;
    }
}
