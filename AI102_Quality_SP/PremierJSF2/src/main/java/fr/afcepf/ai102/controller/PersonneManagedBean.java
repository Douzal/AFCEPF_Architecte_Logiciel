package fr.afcepf.ai102.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai102.qualimetrie.business.GestionPersonne;
import fr.afcepf.ai102.qualimetrie.business.IGestionPersonne;
import fr.afcepf.ai102.qualimetrie.entity.Personne;
import fr.afcepf.ai102.qualimetrie.exception.QualitException;

@ManagedBean (name="mbPersonne")
@SessionScoped
public class PersonneManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Personne> personnes = new ArrayList<>();
    private IGestionPersonne bu = new GestionPersonne();
    private Map<Integer, Boolean> selected = new HashMap<>();
    
    public void deletePersonnes(){
        for(int x = 0; x < selected.size(); x++){
            if(selected.get(x)){
                bu.deletePersonne(personnes.get(x));
            }
        }
        selected.clear();
        try {
            personnes = bu.getAllPersonne();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (QualitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public List<Personne> getPersonnes() {
        return personnes;
    }
    public void setPersonnes(List<Personne> paramPersonnes) {
        personnes = paramPersonnes;
    }
    
    public void delete(Integer index){
        bu.deletePersonne(personnes.get(index.intValue()));
        try {
            personnes = bu.getAllPersonne();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (QualitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @PostConstruct
    public void init(){
        try {
            personnes = bu.getAllPersonne();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (QualitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public Map<Integer, Boolean> getSelected() {
        return selected;
    }
    public void setSelected(Map<Integer, Boolean> paramSelected) {
        selected = paramSelected;
    }
    

}
