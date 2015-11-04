
package com.kthree.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kthree.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetServerStatusResponse_QNAME = new QName("http://ws.kthree.com/", "getServerStatusResponse");
    private final static QName _GetServerStatus_QNAME = new QName("http://ws.kthree.com/", "getServerStatus");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kthree.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetServerStatusResponse }
     * 
     */
    public GetServerStatusResponse createGetServerStatusResponse() {
        return new GetServerStatusResponse();
    }

    /**
     * Create an instance of {@link GetServerStatus }
     * 
     */
    public GetServerStatus createGetServerStatus() {
        return new GetServerStatus();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServerStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.kthree.com/", name = "getServerStatusResponse")
    public JAXBElement<GetServerStatusResponse> createGetServerStatusResponse(GetServerStatusResponse value) {
        return new JAXBElement<GetServerStatusResponse>(_GetServerStatusResponse_QNAME, GetServerStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServerStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.kthree.com/", name = "getServerStatus")
    public JAXBElement<GetServerStatus> createGetServerStatus(GetServerStatus value) {
        return new JAXBElement<GetServerStatus>(_GetServerStatus_QNAME, GetServerStatus.class, null, value);
    }

}
