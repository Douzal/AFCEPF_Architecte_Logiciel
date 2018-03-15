package fr.afcepf.ai31.rappels.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

public final class TestMap {
    private TestMap() {
    }

    private static Logger log = Logger.getLogger(TestMap.class);
    public static void main(String[] args) {
        Map<Integer, String> uneMap = new HashMap<>();
        uneMap.put(1,"Javascript");
        uneMap.put(2,"CSS");
        uneMap.put(3,"C#");
        uneMap.put(4,"Java EE");
        uneMap.put(5,"Html");
        uneMap.put(6,"C");
        uneMap.put(7,"Python");
        
        log.debug(uneMap.get(2)); // CSS
        
        Set<Integer> keys = uneMap.keySet();
        for (Integer integer : keys) {
            log.debug(integer);
        }
        
        Collection<String> values = uneMap.values();
        for (String str : values) {
            log.debug(str);
        }
    }
}
