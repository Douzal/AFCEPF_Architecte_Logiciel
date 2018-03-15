package fr.afcepf.ai102.service.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = 
"http://monservice.ai102.afcepf.fr",
name = "Toto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Foo {
    @XmlAttribute(name = "identifiant")
    private Integer id;
    @XmlElement(name = "nom")
    private String firstName;
    @XmlElement(name = "prenom")
    private String lastName;
    public Foo() {
    }
    public Foo(Integer paramId, String paramFirstName, String paramLastName) {
        id = paramId;
        firstName = paramFirstName;
        lastName = paramLastName;
    }
    public Integer getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setId(Integer paramId) {
        id = paramId;
    }
    public void setFirstName(String paramFirstName) {
        firstName = paramFirstName;
    }
    public void setLastName(String paramLastName) {
        lastName = paramLastName;
    }
}
