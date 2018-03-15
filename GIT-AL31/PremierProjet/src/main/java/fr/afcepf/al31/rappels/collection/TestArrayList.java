package fr.afcepf.al31.rappels.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import fr.afcepf.al31.rappels.objet.Personne;
import fr.afcepf.al31.rappels.objet.Stagiaire;

public final class TestArrayList {
	private TestArrayList() {
	}
	private static Logger log = Logger.getLogger(TestArrayList.class);
	public static void main(String[] args) {
		List<Integer> liste = new ArrayList<>();
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
		List<Personne> personnes = new ArrayList<>();
		personnes.add(new Stagiaire(1, "unnom", "unprenom"));
		personnes.add(new Stagiaire(2, "dupont", "unprenom"));
		personnes.add(new Stagiaire(3, "dupond", "unprenom"));
		personnes.add(new Stagiaire(4, "dupond", "prenom"));
		personnes.add(new Stagiaire(5, "unnom1", "unprenom1"));
		personnes.add(new Stagiaire(6, "unnom1", "unprenom3"));
		personnes.add(new Stagiaire(7, "unnom1", "unprenom2"));
		personnes.add(new Stagiaire(8, "nom", "prenom"));
		for (Personne personne : personnes) {
			log.debug(personne);
		}
		Collections.sort(personnes);
		for (Personne personne : personnes) {
			log.debug(personne);
		}
		
	}
}
