package fr.afcepf.ai102.hibernate.entity;

public class Toto {
    
    private int id;
    private String toto;
    public int getId() {
        return id;
    }
    public String getToto() {
        return toto;
    }
    public void setId(int paramId) {
        id = paramId;
    }
    public void setToto(String paramToto) {
        toto = paramToto;
    }
    public Toto(int paramId, String paramToto) {
        super();
        id = paramId;
        toto = paramToto;
    }
    public Toto() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    
    
}
