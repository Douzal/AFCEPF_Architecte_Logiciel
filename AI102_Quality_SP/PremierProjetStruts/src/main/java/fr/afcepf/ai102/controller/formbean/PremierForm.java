package fr.afcepf.ai102.controller.formbean;

import org.apache.struts.action.ActionForm;

public class PremierForm extends ActionForm {
    private String saisie;
    private String label;
    public String getSaisie() {
        return saisie;
    }
    public void setSaisie(String paramSaisie) {
        saisie = paramSaisie;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String paramLabel) {
        label = paramLabel;
    }
}
