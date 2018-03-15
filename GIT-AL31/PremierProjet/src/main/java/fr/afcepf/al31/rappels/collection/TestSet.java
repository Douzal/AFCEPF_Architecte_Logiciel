package fr.afcepf.al31.rappels.collection;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

public final class TestSet {
	private TestSet() {
	}
	private static Logger log = Logger.getLogger(TestSet.class);
	public static void main(String[] args) {
		Set<Integer> unSet = new HashSet<>();
		unSet.add(5);
		unSet.add(15);
		unSet.add(15);
		unSet.add(25);
		unSet.add(25);
		unSet.add(35);
		unSet.add(35);
		unSet.add(35);
		unSet.add(35);
		unSet.add(35);
		unSet.add(5);
		unSet.add(5);
		unSet.add(5);
		unSet.add(5);
		log.debug(unSet.size());
		for (Integer integer : unSet) {
			log.debug(integer);
		}
		log.fatal(0101); // 65 en base 8
		log.fatal(0x3F09); 
	}
}
