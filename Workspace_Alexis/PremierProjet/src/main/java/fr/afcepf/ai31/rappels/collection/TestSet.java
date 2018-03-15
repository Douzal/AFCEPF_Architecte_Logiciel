package fr.afcepf.ai31.rappels.collection;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

public class TestSet {

    private TestSet() {
    }
    
    private static Logger log = Logger.getLogger(TestSet.class);
    public static void main(String[] args) {
        Set<Integer> unSet = new HashSet<Integer>();
        unSet.add(2);
        unSet.add(55);
        unSet.add(12);
        unSet.add(10);
        unSet.add(55);
        unSet.add(87);
        
        // TODO terminer ici
    }
}
