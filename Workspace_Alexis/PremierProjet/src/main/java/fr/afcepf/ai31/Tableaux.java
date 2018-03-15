package fr.afcepf.ai31;

import java.util.Arrays;

import org.apache.log4j.Logger;

public class Tableaux {
	private static Logger log = Logger.getLogger(Tableaux.class);
	public static void main (String[] args) {
		log.info("--- test tableaux ---");
		// Type [] = ne Type[taille];
		// Type nom[] = {..,..,...,...};
		int[] tab = new int[4];
		tab[0] = 1;
		tab[1] = 2;
		tab[2] = 3;
		tab[3] = 4;
		
		int tab2[] = {1,2,3,4};
		log.debug(tab.length);
		log.debug(tab2.length);
		
		for (int i = 0; i < tab2.length; i++) {
			log.debug(tab[i]);
		}
		
		
		int[][] tab2D = new int[3][2];
		tab2D[0][0] = 1;
		tab2D[0][1] = 2;
		tab2D[1][0] = 3;
		tab2D[1][1] = 4;
		tab2D[2][0] = 5;
		tab2D[2][1] = 6;
		
		log.debug(tab2D.length); // 3
		log.debug(tab2D[0].length); // 2
		log.debug(tab2D[1].length); // 2
		log.debug(tab2D[2].length); // 2
		
		int[][] tab2D2 = {
				{1,2,3},
				{4,5},
				{6,7,8,9,10}
		};
		
		log.debug(tab2D2.length); // 3     
		log.debug(tab2D2[0].length); // 3  
		log.debug(tab2D2[1].length); // 2  
		log.debug(tab2D2[2].length); // 5
		
		
		
		for (int i = 0; i < tab2D2.length; i++) {
			for (int j = 0; j < tab2D2[i].length; j++) {
				log.debug(tab2D2[i][j]);
			}
		}
		
		for(int[] soustab : tab2D2) {
			for(int i : soustab) {
				log.debug(i);
			}
		}
		
		// les tris
		int[] aTrier = {15, 0, 12, -125, 5656, 15156, 262, 61, 0, 256};
		Arrays.sort(aTrier);
		for (int i : aTrier) {
			log.debug(i);
		}
		
		Arrays.sort(aTrier);
		for (int i = aTrier.length-1;i >= 0;i--) {
			log.debug(aTrier[i]);
		}
		
		Arrays.sort(aTrier);
		for (int i = aTrier.length-1;i >= 0;) {
			log.debug(aTrier[i--]);
		}
		
		
	}
}
