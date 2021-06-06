
package se.atg.service.harrykart.java.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for startListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="startListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="participant" type="{}participantType" maxOccurs="unbounded" minOccurs="4"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name="StartListType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "startListType", propOrder = {
    "participant"
})
public class StartListType {

    @XmlElement(required = true)
    protected List<ParticipantType> participant;

    /**
     * Gets the value of the participant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the participant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParticipant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParticipantType }
     * 
     * 
     */
    public List<ParticipantType> getParticipant() {
        if (participant == null) {
            participant = new ArrayList<ParticipantType>();
        }
        return this.participant;
    }

}
