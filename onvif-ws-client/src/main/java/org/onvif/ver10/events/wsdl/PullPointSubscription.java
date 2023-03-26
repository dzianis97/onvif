
package org.onvif.ver10.events.wsdl;

import java.util.concurrent.Future;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.AsyncHandler;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.Response;
import jakarta.xml.ws.ResponseWrapper;
import org.oasis_open.docs.wsn.b_2.Unsubscribe;
import org.oasis_open.docs.wsn.b_2.UnsubscribeResponse;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PullPointSubscription", targetNamespace = "http://www.onvif.org/ver10/events/wsdl")
@XmlSeeAlso({
    ObjectFactory.class,
    org.oasis_open.docs.wsn.b_2.ObjectFactory.class,
    org.oasis_open.docs.wsrf.bf_2.ObjectFactory.class,
    org.oasis_open.docs.wsn.t_1.ObjectFactory.class,
    org.oasis_open.docs.wsrf.r_2.ObjectFactory.class,
    org.w3._2005._08.addressing.ObjectFactory.class
})
public interface PullPointSubscription {


    /**
     * 
     * @param parameters
     * @return
     *     returns jakarta.xml.ws.Response<org.onvif.ver10.events.wsdl.PullMessagesResponse>
     */
    @WebMethod(operationName = "PullMessages", action = "http://www.onvif.org/ver10/events/wsdl/PullPointSubscription/PullMessagesRequest")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public Response<PullMessagesResponse> pullMessagesAsync(
        @WebParam(name = "PullMessages", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", partName = "parameters")
        PullMessages parameters);

    /**
     * 
     * @param asyncHandler
     * @param parameters
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "PullMessages", action = "http://www.onvif.org/ver10/events/wsdl/PullPointSubscription/PullMessagesRequest")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public Future<?> pullMessagesAsync(
        @WebParam(name = "PullMessages", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", partName = "parameters")
        PullMessages parameters,
        @WebParam(name = "PullMessagesResponse", targetNamespace = "", partName = "asyncHandler")
        AsyncHandler<PullMessagesResponse> asyncHandler);

    /**
     * 
     * @param parameters
     * @return
     *     returns org.onvif.ver10.events.wsdl.PullMessagesResponse
     * @throws PullMessagesFaultResponse_Exception
     */
    @WebMethod(operationName = "PullMessages", action = "http://www.onvif.org/ver10/events/wsdl/PullPointSubscription/PullMessagesRequest")
    @WebResult(name = "PullMessagesResponse", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", partName = "parameters")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public PullMessagesResponse pullMessages(
        @WebParam(name = "PullMessages", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", partName = "parameters")
        PullMessages parameters)
        throws PullMessagesFaultResponse_Exception
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns jakarta.xml.ws.Response<org.onvif.ver10.events.wsdl.SeekResponse>
     */
    @WebMethod(operationName = "Seek", action = "http://www.onvif.org/ver10/events/wsdl/PullPointSubscription/SeekRequest")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public Response<SeekResponse> seekAsync(
        @WebParam(name = "Seek", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", partName = "parameters")
        Seek parameters);

    /**
     * 
     * @param asyncHandler
     * @param parameters
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "Seek", action = "http://www.onvif.org/ver10/events/wsdl/PullPointSubscription/SeekRequest")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public Future<?> seekAsync(
        @WebParam(name = "Seek", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", partName = "parameters")
        Seek parameters,
        @WebParam(name = "SeekResponse", targetNamespace = "", partName = "asyncHandler")
        AsyncHandler<SeekResponse> asyncHandler);

    /**
     * 
     * @param parameters
     * @return
     *     returns org.onvif.ver10.events.wsdl.SeekResponse
     */
    @WebMethod(operationName = "Seek", action = "http://www.onvif.org/ver10/events/wsdl/PullPointSubscription/SeekRequest")
    @WebResult(name = "SeekResponse", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", partName = "parameters")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public SeekResponse seek(
        @WebParam(name = "Seek", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", partName = "parameters")
        Seek parameters);

    /**
     * Properties inform a client about property creation, changes and
     * 				deletion in a uniform way. When a client wants to synchronize its properties with the
     * 				properties of the device, it can request a synchronization point which repeats the current
     * 				status of all properties to which a client has subscribed. The PropertyOperation of all
     * 				produced notifications is set to ��Initialized��. The Synchronization Point is
     * 				requested directly from the SubscriptionManager which was returned in either the
     * 				SubscriptionResponse or in the CreatePullPointSubscriptionResponse. The property update is
     * 				transmitted via the notification transportation of the notification interface. This method is mandatory.
     * 			
     * 
     * @return
     *     returns jakarta.xml.ws.Response<org.onvif.ver10.events.wsdl.SetSynchronizationPointResponse>
     */
    @WebMethod(operationName = "SetSynchronizationPoint", action = "http://www.onvif.org/ver10/events/wsdl/PullPointSubscription/SetSynchronizationPointRequest")
    @RequestWrapper(localName = "SetSynchronizationPoint", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", className = "org.onvif.ver10.events.wsdl.SetSynchronizationPoint")
    @ResponseWrapper(localName = "SetSynchronizationPointResponse", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", className = "org.onvif.ver10.events.wsdl.SetSynchronizationPointResponse")
    public Response<SetSynchronizationPointResponse> setSynchronizationPointAsync();

    /**
     * Properties inform a client about property creation, changes and
     * 				deletion in a uniform way. When a client wants to synchronize its properties with the
     * 				properties of the device, it can request a synchronization point which repeats the current
     * 				status of all properties to which a client has subscribed. The PropertyOperation of all
     * 				produced notifications is set to ��Initialized��. The Synchronization Point is
     * 				requested directly from the SubscriptionManager which was returned in either the
     * 				SubscriptionResponse or in the CreatePullPointSubscriptionResponse. The property update is
     * 				transmitted via the notification transportation of the notification interface. This method is mandatory.
     * 			
     * 
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "SetSynchronizationPoint", action = "http://www.onvif.org/ver10/events/wsdl/PullPointSubscription/SetSynchronizationPointRequest")
    @RequestWrapper(localName = "SetSynchronizationPoint", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", className = "org.onvif.ver10.events.wsdl.SetSynchronizationPoint")
    @ResponseWrapper(localName = "SetSynchronizationPointResponse", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", className = "org.onvif.ver10.events.wsdl.SetSynchronizationPointResponse")
    public Future<?> setSynchronizationPointAsync(
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<SetSynchronizationPointResponse> asyncHandler);

    /**
     * Properties inform a client about property creation, changes and
     * 				deletion in a uniform way. When a client wants to synchronize its properties with the
     * 				properties of the device, it can request a synchronization point which repeats the current
     * 				status of all properties to which a client has subscribed. The PropertyOperation of all
     * 				produced notifications is set to ��Initialized��. The Synchronization Point is
     * 				requested directly from the SubscriptionManager which was returned in either the
     * 				SubscriptionResponse or in the CreatePullPointSubscriptionResponse. The property update is
     * 				transmitted via the notification transportation of the notification interface. This method is mandatory.
     * 			
     * 
     */
    @WebMethod(operationName = "SetSynchronizationPoint", action = "http://www.onvif.org/ver10/events/wsdl/PullPointSubscription/SetSynchronizationPointRequest")
    @RequestWrapper(localName = "SetSynchronizationPoint", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", className = "org.onvif.ver10.events.wsdl.SetSynchronizationPoint")
    @ResponseWrapper(localName = "SetSynchronizationPointResponse", targetNamespace = "http://www.onvif.org/ver10/events/wsdl", className = "org.onvif.ver10.events.wsdl.SetSynchronizationPointResponse")
    public void setSynchronizationPoint();

    /**
     * 
     * @param unsubscribeRequest
     * @return
     *     returns jakarta.xml.ws.Response<org.oasis_open.docs.wsn.b_2.UnsubscribeResponse>
     */
    @WebMethod(operationName = "Unsubscribe", action = "http://docs.oasis-open.org/wsn/bw-2/SubscriptionManager/UnsubscribeRequest")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public Response<UnsubscribeResponse> unsubscribeAsync(
        @WebParam(name = "Unsubscribe", targetNamespace = "http://docs.oasis-open.org/wsn/b-2", partName = "UnsubscribeRequest")
        Unsubscribe unsubscribeRequest);

    /**
     * 
     * @param asyncHandler
     * @param unsubscribeRequest
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "Unsubscribe", action = "http://docs.oasis-open.org/wsn/bw-2/SubscriptionManager/UnsubscribeRequest")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public Future<?> unsubscribeAsync(
        @WebParam(name = "Unsubscribe", targetNamespace = "http://docs.oasis-open.org/wsn/b-2", partName = "UnsubscribeRequest")
        Unsubscribe unsubscribeRequest,
        @WebParam(name = "UnsubscribeResponse", targetNamespace = "", partName = "asyncHandler")
        AsyncHandler<UnsubscribeResponse> asyncHandler);

    /**
     * 
     * @param unsubscribeRequest
     * @return
     *     returns org.oasis_open.docs.wsn.b_2.UnsubscribeResponse
     * @throws ResourceUnknownFault
     * @throws UnableToDestroySubscriptionFault
     */
    @WebMethod(operationName = "Unsubscribe", action = "http://docs.oasis-open.org/wsn/bw-2/SubscriptionManager/UnsubscribeRequest")
    @WebResult(name = "UnsubscribeResponse", targetNamespace = "http://docs.oasis-open.org/wsn/b-2", partName = "UnsubscribeResponse")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public UnsubscribeResponse unsubscribe(
        @WebParam(name = "Unsubscribe", targetNamespace = "http://docs.oasis-open.org/wsn/b-2", partName = "UnsubscribeRequest")
        Unsubscribe unsubscribeRequest)
        throws ResourceUnknownFault, UnableToDestroySubscriptionFault
    ;

}