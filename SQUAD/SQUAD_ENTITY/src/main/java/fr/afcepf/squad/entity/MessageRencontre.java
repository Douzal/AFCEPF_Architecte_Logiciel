package fr.afcepf.squad.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "rencontre")
public class MessageRencontre extends Message {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @ManyToOne()
    @JoinColumn(name = "id_rencontre",
               foreignKey = @ForeignKey(name = "FK_message_rencontre"))   
    private Rencontre rencontre;
    
    @OneToMany(mappedBy="messageParent")
    private List<MessageRencontre> reponses;

    @ManyToOne
    @JoinColumn(name="id_message_parent", foreignKey=@ForeignKey(name="fk_message_reponse"))
    private MessageRencontre messageParent;

    public MessageRencontre() {
        super();
    }

    public MessageRencontre(Integer id, String titre, String message, Date dateMessage, Date dateEdit, Membre auteur,
            Rencontre rencontre, MessageRencontre messageParent) {
        super(id, titre, message, dateMessage, dateEdit, auteur);
        this.rencontre = rencontre;
        this.messageParent = messageParent;
    }

    public Rencontre getRencontre() {
        return rencontre;
    }

    public void setRencontre(Rencontre rencontre) {
        this.rencontre = rencontre;
    }

    public List<MessageRencontre> getReponses() {
        return reponses;
    }

    public void setReponses(List<MessageRencontre> reponses) {
        this.reponses = reponses;
    }

    public MessageRencontre getMessageParent() {
        return messageParent;
    }

    public void setMessageParent(MessageRencontre messageParent) {
        this.messageParent = messageParent;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    
    
}
