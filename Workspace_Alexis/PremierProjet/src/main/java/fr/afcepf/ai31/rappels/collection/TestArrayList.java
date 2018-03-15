package fr.afcepf.ai31.rappels.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import fr.afcepf.ai31.rappels.object.Personne;
import fr.afcepf.ai31.rappels.object.Stagiaire;

public final class TestArrayList {
    private TestArrayList() {
        
    }
    
    private static Logger log = Logger.getLogger(TestArrayList.class);
    
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<Integer>();
        liste.add(12);
        liste.add(13);
        liste.add(1);
        liste.add(524);
        liste.add(4);
        liste.add(0);
        
        for (Integer integer : liste) {
            log.debug(integer);
        }
        liste.remove(4);
        for (Integer integer : liste) {
            log.debug(integer);
        }
        
        
        // liste de péons
        List<Personne> peons = new ArrayList<Personne>();
        peons.add(new Stagiaire(1, "unNom", "unPrenom"));
        peons.add(new Stagiaire(2, "unPeon", "2Prenom"));
        peons.add(new Stagiaire(3, "unAutrePeon", "3Prenom"));
        peons.add(new Stagiaire(4, "Magic", "4Prenom"));
        peons.add(new Stagiaire(5, "Duras", "5Prenom"));
        peons.add(new Stagiaire(6, "Duchmol", "6Prenom"));
        peons.add(new Stagiaire(7, "Mondieuxx", "7Prenom"));
        peons.add(new Stagiaire(8, "Martel", "DernierPrenom"));
        
        // sort ? --> pas terminé
        Collections.sort(peons);
        
        
        
    }
}
