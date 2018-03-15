package fr.afcepf.al31.rappels.collection;

import java.util.Collection;
import java.util.Collections;
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
		uneMap.put(1, "java");
		uneMap.put(2, "C#");
		uneMap.put(3, "php");
		uneMap.put(4, "javaScript");
		uneMap.put(2, "dart");
		uneMap.put(5, "ruby");
		uneMap.put(6, "c");
		uneMap.put(7, "perl");
		log.debug(uneMap.get(2));
		Set<Integer> keys = uneMap.keySet();
		for (Integer integer : keys) {
			log.debug(integer);
		}
		Collection<String> values = uneMap.values();
		for (String string : values) {
			log.debug(string);
		}
	}
}
