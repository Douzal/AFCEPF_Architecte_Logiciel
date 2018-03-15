package fr.afcepf.ai31.rappels.collection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import fr.afcepf.ai31.rappels.object.Personne;

public class TestReflection {

    private static Logger log = Logger.getLogger(TestMap.class);

    public static void main(String[] args) throws NoSuchFieldException, SecurityException {
        // use reflexion
        List<Integer> liste = new ArrayList<>();
        Class<?> clazz = liste.getClass();
        Class[] parameterTypes =  new Class[] {};
        try {
            Method methodAdd = clazz.getMethod("add", parameterTypes);
            methodAdd.invoke(liste, "1");
            methodAdd.invoke(liste, "2");
            methodAdd.invoke(liste, "3");
            methodAdd.invoke(liste, "4");
            methodAdd.invoke(liste, "5");
        } catch (NoSuchMethodException |
                SecurityException |
                IllegalAccessException |
                IllegalArgumentException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
        
        for (Object ob : liste) {
            log.debug(ob.getClass());
            log.debug(ob);
        }
        
        try {
            Personne peon = (Personne) Class.forName("fr.afcepf.al31.rappels.objet.Stagiaire").newInstance();
            Field attrNom = peon.getClass().getSuperclass().getDeclaredField("nom");
            attrNom.setAccessible(true);
            attrNom.set(peon, "coucou");
            log.debug(peon.getNom());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
    }
}
