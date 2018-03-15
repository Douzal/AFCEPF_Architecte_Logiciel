package fr.afcepf.al31.rappels.collection;

import java.util.Collections;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Vector;

import org.apache.log4j.Logger;

import fr.afcepf.al31.rappels.objet.Personne;
import fr.afcepf.al31.rappels.objet.Stagiaire;

public final class TestVector {
	private TestVector() {
	}
	private static Logger log = Logger.getLogger(TestVector.class);
	public static void main(String[] args) {
		Vector vector = new Vector();
		vector.add(7);
		vector.add("ca marche");
		vector.add(true);
		vector.add(new Stagiaire());
		int taille = vector.size();
		log.info("avec un for");
		for(int i = 0 ; i < taille ; i++) {
			log.debug(vector.get(i));
		}
		log.info("avec un foreach");
		for (Object object : vector) {
			log.debug(object);
			//vector.remove(object);
		}
		log.info("avec une lambda");
		vector.forEach(v -> {
			log.debug(v);
		});
		log.info("avec iterator");
		ListIterator li = vector.listIterator();
		while (li.hasNext()) {
			Object object = (Object) li.next();
			log.debug(object);
			li.remove();
		}
		log.debug(vector.size());
		
		Stack<Integer> vector2 = new Stack<>();
		vector2.add(5);
		vector2.add(15);
		vector2.add(2);
		vector2.add(45);
		vector2.add(4);
		vector2.add(6);
		vector2.push(1);
		for (Integer integer : vector2) {
			log.debug(integer);
		}
		log.debug(vector2.pop());
		for (Integer integer : vector2) {
			log.debug(integer);
		}
		Collections.sort(vector2);
		for (Integer integer : vector2) {
			log.debug(integer);
		}
	}
}
