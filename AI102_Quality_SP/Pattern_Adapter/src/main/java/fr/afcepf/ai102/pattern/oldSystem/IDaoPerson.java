package fr.afcepf.ai102.pattern.oldSystem;

import java.util.*;

/**
 * 
 */
public interface IDaoPerson {

    /**
     * @param pers 
     * @return
     */
    public Person add(Person pers);

    /**
     * @param mail 
     * @param pwd 
     * @return
     */
    public Person connect(String mail, String pwd);

}