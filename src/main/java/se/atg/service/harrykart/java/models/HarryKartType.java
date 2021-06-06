
package se.atg.service.harrykart.java.models;

import java.math.BigInteger;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for harryKartType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="harryKartType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numberOfLoops" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="startList" type="{}startListType"/>
 *         &lt;element name="powerUps" type="{}powerUpsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name="HarryKartType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "harryKartType", propOrder = {
    "numberOfLoops",
    "startList",
    "powerUps"
})
public class HarryKartType {

    @XmlElement(required = true)
    protected BigInteger numberOfLoops;
    @XmlElement(required = true)
    protected StartListType startList;
    @XmlElement(required = true)
    protected PowerUpsType powerUps;

    /**
     * Gets the value of the numberOfLoops property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfLoops() {
        return numberOfLoops;
    }

    /**
     * Sets the value of the numberOfLoops property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfLoops(BigInteger value) {
        this.numberOfLoops = value;
    }

    /**
     * Gets the value of the startList property.
     * 
     * @return
     *     possible object is
     *     {@link StartListType }
     *     
     */
    public StartListType getStartList() {
        return startList;
    }

    /**
     * Sets the value of the startList property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartListType }
     *     
     */
    public void setStartList(StartListType value) {
        this.startList = value;
    }

    /**
     * Gets the value of the powerUps property.
     * 
     * @return
     *     possible object is
     *     {@link PowerUpsType }
     *     
     */
    public PowerUpsType getPowerUps() {
        return powerUps;
    }

    /**
     * Sets the value of the powerUps property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerUpsType }
     *     
     */
    public void setPowerUps(PowerUpsType value) {
        this.powerUps = value;
    }

}
