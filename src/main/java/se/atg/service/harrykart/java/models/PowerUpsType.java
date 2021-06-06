
package se.atg.service.harrykart.java.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for powerUpsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="powerUpsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loop" type="{}loopType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name="PowerUpsType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "powerUpsType", propOrder = {
    "loop"
})
public class PowerUpsType {

    protected List<LoopType> loop;

    /**
     * Gets the value of the loop property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loop property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoop().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoopType }
     * 
     * 
     */
    public List<LoopType> getLoop() {
        if (loop == null) {
            loop = new ArrayList<LoopType>();
        }
        return this.loop;
    }

}
