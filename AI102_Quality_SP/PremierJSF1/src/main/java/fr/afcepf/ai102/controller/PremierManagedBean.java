package fr.afcepf.ai102.controller;

public class PremierManagedBean {
    private String saisie;
    private String label;
    
    public String click(){
        label = saisie;
        return label;
    }
    
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
