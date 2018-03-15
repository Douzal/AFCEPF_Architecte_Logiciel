package fr.afcepf.ai102.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.afcepf.ai102.controller.formbean.PremierForm;

public class PremiereAction extends Action {
    @Override
    public ActionForward execute(ActionMapping paramMapping,
                                 ActionForm paramForm,
                                 HttpServletRequest paramRequest,
                                 HttpServletResponse paramResponse) throws Exception {
        PremierForm monForm = (PremierForm)paramForm;
        monForm.setLabel(monForm.getSaisie().toUpperCase());  
        return paramMapping.findForward("cequonveut");
    }
}
