package fr.afcepf.ai102.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.afcepf.ai102.controller.formbean.AjouterForm;
import fr.afcepf.ai102.qualimetrie.business.GestionPersonne;
import fr.afcepf.ai102.qualimetrie.business.IGestionPersonne;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

public class AjouterAction extends Action {
    @Override
    public ActionForward execute(ActionMapping paramMapping, ActionForm paramForm, HttpServletRequest paramRequest,
            HttpServletResponse paramResponse) throws Exception {
        IGestionPersonne bu = new GestionPersonne();
        AjouterForm monForm = (AjouterForm) paramForm;
        try {
            monForm.setPers(bu.ajouter(monForm.getPers()));
            monForm.setMessage("Personne bien ajoutée");
        } catch (QualitException e) {
            monForm.setMessage("ERROR : " + e.getCodeErreur());
        }
        return paramMapping.findForward("success");
    }
}
