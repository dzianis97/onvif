
package org.onvif.ver10.events.wsdl;

import jakarta.xml.ws.WebFault;
import org.oasis_open.docs.wsn.b_2.InvalidMessageContentExpressionFaultType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "InvalidMessageContentExpressionFault", targetNamespace = "http://docs.oasis-open.org/wsn/b-2")
public class InvalidMessageContentExpressionFault
    extends Exception
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5385785654122567628L;
	/**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private InvalidMessageContentExpressionFaultType faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public InvalidMessageContentExpressionFault(String message, InvalidMessageContentExpressionFaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public InvalidMessageContentExpressionFault(String message, InvalidMessageContentExpressionFaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.oasis_open.docs.wsn.b_2.InvalidMessageContentExpressionFaultType
     */
    public InvalidMessageContentExpressionFaultType getFaultInfo() {
        return faultInfo;
    }

}
