package fr.afcepf.ai102.pattern.oldSystem;

import java.util.*;

/**
 * 
 */
public class Person {

    /**
     * Default constructor
     */
    public Person() {
    }

    /**
     * 
     */
    private int ident;

    /**
     * 
     */
    private String firstName;

    /**
     * 
     */
    private String mail;

    /**
     * 
     */
    private String password;

    public int getIdent() {
        return ident;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setIdent(int paramIdent) {
        ident = paramIdent;
    }

    public void setFirstName(String paramFirstName) {
        firstName = paramFirstName;
    }

    public void setMail(String paramMail) {
        mail = paramMail;
    }

    public void setPassword(String paramPassword) {
        password = paramPassword;
    }

    public Person(int paramIdent, String paramFirstName, String paramMail, String paramPassword) {
        super();
        ident = paramIdent;
        firstName = paramFirstName;
        mail = paramMail;
        password = paramPassword;
    }

}