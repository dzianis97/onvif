package de.onvif.soap;

import static org.apache.wss4j.common.WSS4JConstants.BASE64_ENCODING;
import static org.apache.wss4j.common.WSS4JConstants.CREATED_LN;
import static org.apache.wss4j.common.WSS4JConstants.NONCE_LN;
import static org.apache.wss4j.common.WSS4JConstants.PASSWORD_DIGEST;
import static org.apache.wss4j.common.WSS4JConstants.PASSWORD_LN;
import static org.apache.wss4j.common.WSS4JConstants.PASSWORD_TYPE_ATTR;
import static org.apache.wss4j.common.WSS4JConstants.USERNAME_LN;
import static org.apache.wss4j.common.WSS4JConstants.USERNAME_TOKEN_LN;
import static org.apache.wss4j.common.WSS4JConstants.WSSE_LN;
import static org.apache.wss4j.common.WSS4JConstants.WSSE_NS;
import static org.apache.wss4j.common.WSS4JConstants.WSSE_PREFIX;
import static org.apache.wss4j.common.WSS4JConstants.WSU_NS;
import static org.apache.wss4j.common.WSS4JConstants.WSU_PREFIX;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPHeader;
import jakarta.xml.soap.SOAPMessage;
import jakarta.xml.soap.SOAPPart;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import javax.xml.namespace.QName;

/*
 Utility class to add user/password onvif credentials to SOAP communications
*/
public class SimpleSecurityHandler implements SOAPHandler<SOAPMessageContext> {

  private final String username;
  private final String password;
  private final String nonce;
  private String utcTime;
  private static Random rnd = new SecureRandom();

  public SimpleSecurityHandler(String username, String password) {
    this.username = username;
    this.password = password;
    this.nonce = "" + rnd.nextInt();
  }

  @Override
  public boolean handleMessage(final SOAPMessageContext msgCtx) {
    // System.out.println("SimpleSecurityHandler");

    // Indicator telling us which direction this message is going in
    final Boolean outInd = (Boolean) msgCtx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

    // Handler must only add security headers to outbound messages
    if (outInd.booleanValue()) {
      try {
        // Create the xml
        SOAPMessage soapMessage = msgCtx.getMessage();
        SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();
        SOAPHeader header = envelope.getHeader();
        if (header == null) header = envelope.addHeader();

        SOAPPart sp = soapMessage.getSOAPPart();
        SOAPEnvelope se = sp.getEnvelope();
        se.addNamespaceDeclaration(WSSE_PREFIX, WSSE_NS);
        se.addNamespaceDeclaration(WSU_PREFIX, WSU_NS);

        SOAPElement securityElem = header.addChildElement(WSSE_LN, WSSE_PREFIX);
        // securityElem.setAttribute("SOAP-ENV:mustUnderstand", "1");

        SOAPElement usernameTokenElem =
            securityElem.addChildElement(USERNAME_TOKEN_LN, WSSE_PREFIX);

        SOAPElement usernameElem = usernameTokenElem.addChildElement(USERNAME_LN, WSSE_PREFIX);
        usernameElem.setTextContent(username);

        SOAPElement passwordElem = usernameTokenElem.addChildElement(PASSWORD_LN, WSSE_PREFIX);
        passwordElem.setAttribute(PASSWORD_TYPE_ATTR, PASSWORD_DIGEST);
        passwordElem.setTextContent(encryptPassword(password));

        SOAPElement nonceElem = usernameTokenElem.addChildElement(NONCE_LN, WSSE_PREFIX);
        nonceElem.setAttribute("EncodingType", BASE64_ENCODING);
        nonceElem.setTextContent(Base64.encodeBase64String(nonce.getBytes()));

        SOAPElement createdElem = usernameTokenElem.addChildElement(CREATED_LN, WSU_PREFIX);
        createdElem.setTextContent(getLastUTCTime());
      } catch (final Exception e) {
        e.printStackTrace();
        return false;
      }
    }
    return true;
  }

  public String getLastUTCTime() {
    return utcTime;
  }

  public String getUTCTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d'T'HH:mm:ss'Z'");
    sdf.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
    Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    String utcTime = sdf.format(cal.getTime());
    this.utcTime = utcTime;
    return utcTime;
  }

  public String encryptPassword(String password) {
    String timestamp = getUTCTime();
    String beforeEncryption = nonce + timestamp + password;
    byte[] encryptedRaw;
    try {
      encryptedRaw = sha1(beforeEncryption);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
    String encoded = Base64.encodeBase64String(encryptedRaw);
    return encoded;
  }
  // Other required methods on interface need no guts
  private static byte[] sha1(String s) throws NoSuchAlgorithmException {
    MessageDigest SHA1 = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
    SHA1.reset();
    SHA1.update(s.getBytes());
    return SHA1.digest();
  }

  @Override
  public boolean handleFault(SOAPMessageContext context) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void close(MessageContext context) {
    // TODO Auto-generated method stub

  }

  @Override
  public Set<QName> getHeaders() {
    // TODO Auto-generated method stub
    return null;
  }
}
