package fr.afcepf.squad.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="squad")
public class MessageSquad extends Message {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name="id_squad", foreignKey = @ForeignKey(name="fk_message_squad"))
    private Squad squad;
    
    @OneToMany(mappedBy="messageParent")
    private List<MessageSquad> reponses;

    @ManyToOne
    @JoinColumn(name="id_message_parent", foreignKey=@ForeignKey(name="fk_message_reponse"))
    private MessageSquad messageParent;

    public MessageSquad() {
        super();
    }

    public MessageSquad(Integer id, String titre, String message, Date dateMessage, Date dateEdit, Membre auteur,
            Squad squad, MessageSquad messageParent) {
        super(id, titre, message, dateMessage, dateEdit, auteur);
        this.squad = squad;
        this.messageParent = messageParent;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public List<MessageSquad> getReponses() {
        return reponses;
    }

    public void setReponses(List<MessageSquad> reponses) {
        this.reponses = reponses;
    }

    public MessageSquad getMessageParent() {
        return messageParent;
    }

    public void setMessageParent(MessageSquad messageParent) {
        this.messageParent = messageParent;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    
    
}
