
package org.onvif.ver10.media.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.onvif.ver10.schema.VideoAnalyticsConfiguration;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Configuration" type="{http://www.onvif.org/ver10/schema}VideoAnalyticsConfiguration"/&gt;
 *         &lt;element name="ForcePersistence" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "configuration",
    "forcePersistence"
})
@XmlRootElement(name = "SetVideoAnalyticsConfiguration")
public class SetVideoAnalyticsConfiguration {

    @XmlElement(name = "Configuration", required = true)
    protected VideoAnalyticsConfiguration configuration;
    @XmlElement(name = "ForcePersistence")
    protected boolean forcePersistence;

    /**
     * Gets the value of the configuration property.
     * 
     * @return
     *     possible object is
     *     {@link VideoAnalyticsConfiguration }
     *     
     */
    public VideoAnalyticsConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * Sets the value of the configuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link VideoAnalyticsConfiguration }
     *     
     */
    public void setConfiguration(VideoAnalyticsConfiguration value) {
        this.configuration = value;
    }

    /**
     * Gets the value of the forcePersistence property.
     * This getter has been renamed from isForcePersistence() to getForcePersistence() by cxf-xjc-boolean plugin.
     * 
     */
    public boolean getForcePersistence() {
        return forcePersistence;
    }

    /**
     * Sets the value of the forcePersistence property.
     * 
     */
    public void setForcePersistence(boolean value) {
        this.forcePersistence = value;
    }

}