package fr.afcepf.ai31.rappels.collection;

import java.util.Collections;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Vector;

import org.apache.log4j.Logger;

import fr.afcepf.ai31.rappels.object.Stagiaire;

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
        for (int i = 0; i < taille; i++) {
            log.debug(vector.get(i));
        }
        
        log.info("avec un foreach");
        for (Object object : vector) {
            log.debug(object);
//            vector.remove(object);
        }
        
        log.info("avec un lambda");
        vector.forEach(v -> {
            log.debug(v);
        });

        log.info("avec un iterator");
        ListIterator li = vector.listIterator();
        while (li.hasNext()) {
            Object object = (Object) li.next();
            log.debug(object);
            li.remove();
        }
        log.debug(vector.size()); // 0
        
        
        Stack<Integer> v2 = new Stack<>();
        v2.add(5);
        v2.add(15);
        v2.add(2);
        v2.add(45);
        v2.add(4);
        v2.add(6);
        v2.push(1);
        
        for (Integer integer : v2) {
            log.debug(integer);
        }
        
        log.debug(v2.pop());
        for (Integer integer : v2) {
            log.debug(integer);
        }
        
        Collections.sort(v2);
//        for (Integer)
        
        
        
        
        
        
    }
}
