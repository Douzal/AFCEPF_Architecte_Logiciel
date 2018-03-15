package fr.afcepf.al31.rappels.collection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import fr.afcepf.al31.rappels.objet.Personne;
import fr.afcepf.al31.rappels.objet.Stagiaire;

public final class TestReflection {
	private static Logger log = Logger.getLogger(TestReflection.class);
	public static void main(String[] args) {
		// use Reflexion ...
		List<Integer> liste = new ArrayList<>();
		Class<?> clazz = liste.getClass();
		Class[] parameterTypes = new Class[1];
		parameterTypes[0] = Object.class;
		
		try {
			Method methodAdd = clazz.getMethod("add", parameterTypes);
			methodAdd.invoke(liste, "1");
			methodAdd.invoke(liste, 2);
			methodAdd.invoke(liste, 3.5);
			methodAdd.invoke(liste, new Stagiaire());
			methodAdd.invoke(liste, "5");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Object integer : liste) {
			log.debug(integer.getClass());
			log.debug(integer);
		}
		try {
			Personne pers = (Personne) Class.forName("fr.afcepf.al31.rappels.objet.Stagiaire").newInstance();
			Field attrNom = pers.getClass().getSuperclass().getDeclaredField("nom");
			attrNom.setAccessible(true);
			attrNom.set(pers, "coucou");
			log.debug(pers.getNom());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
