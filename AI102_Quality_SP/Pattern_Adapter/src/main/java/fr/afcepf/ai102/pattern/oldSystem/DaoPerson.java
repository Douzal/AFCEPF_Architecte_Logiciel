package fr.afcepf.ai102.pattern.oldSystem;
public class DaoPerson implements IDaoPerson {
    public DaoPerson() {
    }
    public Person add(Person pers) {
        pers.setIdent(6);
        System.out.println("dans old system");
        return pers;
    }
    public Person connect(String mail, String pwd) {
        System.out.println("dans old system");
        return new Person(4, "FirstName", "Mail", "********");
    }

}