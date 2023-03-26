
package org.onvif.ver10.events.wsdl;

import jakarta.xml.ws.WebFault;
import org.oasis_open.docs.wsn.b_2.TopicNotSupportedFaultType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "TopicNotSupportedFault", targetNamespace = "http://docs.oasis-open.org/wsn/b-2")
public class TopicNotSupportedFault
    extends Exception
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8129474819371121353L;
	/**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private TopicNotSupportedFaultType faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public TopicNotSupportedFault(String message, TopicNotSupportedFaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public TopicNotSupportedFault(String message, TopicNotSupportedFaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.oasis_open.docs.wsn.b_2.TopicNotSupportedFaultType
     */
    public TopicNotSupportedFaultType getFaultInfo() {
        return faultInfo;
    }

}
