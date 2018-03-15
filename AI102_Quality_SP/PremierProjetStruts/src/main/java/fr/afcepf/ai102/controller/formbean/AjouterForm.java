package fr.afcepf.ai102.controller.formbean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import fr.afcepf.ai102.qualimetrie.entity.Personne;

public class AjouterForm extends ActionForm {
    private Personne pers = new Personne();
    private String naissance;
    private String message;
    @Override
    public void reset(ActionMapping paramMapping, HttpServletRequest paramRequest) {
        // init des elements de la Vue
        naissance = "dd/mm/yyyy";
    }
    @Override
    public ActionErrors validate(ActionMapping paramMapping, HttpServletRequest paramRequest) {
        // controle de saisie avant Action
        try {
            pers.setDob(
                new SimpleDateFormat("dd/MM/yyyy").parse(naissance));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return super.validate(paramMapping, paramRequest);
    }
    public Personne getPers() {
        return pers;
    }
    public void setPers(Personne paramPers) {
        pers = paramPers;
    }
    public String getNaissance() {
        return naissance;
    }
    public void setNaissance(String paramNaissance) {
        naissance = paramNaissance;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String paramMessage) {
        message = paramMessage;
    }
}
