/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */

package de.hdm.cefx.client.net;

import org.w3c.dom.Element;

import de.hdm.cefx.util.CEFXUtil;
import de.hdm.cefx.util.XMLHelper;

public class InsertExtension extends OperationExtension {

	private Element element;

	public String getNamespace() {
		return super.getNamespace()+OperationExtension.INSERT;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	private String Element2String() {
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        OutputStreamWriter steamWriter;
//		try {
//			steamWriter = new OutputStreamWriter(out,"UTF-8");
//	        XMLWriterImpl writer = new XMLWriterImpl();
//	        writer.setWriter(steamWriter);
//
//	        NamedNodeMap nnm=element.getAttributes();
//	        AttributesImpl a=new AttributesImpl();
//	        int ii;
//	        for (ii=0; ii<nnm.getLength(); ii++) {
//	        	Attr n=(Attr)nnm.item(ii);
//	        	String pre=n.getPrefix();
//	        	String name=n.getName();
//	        	if ((pre==null) || ("".equals(pre))) {
//	        		pre = DOM3Methods.lookupPrefix(n, n.getNamespaceURI());
//	        	}
////	        	if (pre!=null) {
////	        		name=pre+':'+name;
////	        	}
//	        	a.addAttribute(n.getNamespaceURI(),n.getLocalName(),name, "", n.getValue());
//	        }
//	        writer.startElement(null,null,element.getTagName(),a);
//
//	        writer.endElement("x");
//	        steamWriter.flush();
//	        return 	out.toString();
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		} catch (SAXException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "";
		
////		// add CEFX namespace to the element (needed for parsing it again on the other site)
////		element.setAttribute("xmlns:" + CEFXUtil.CEFX_PREFIX, CEFXUtil.CEFX_NAMESPACE);
////		
////		// serialize the Element
////		String elStr = XMLHelper.getElementString(element, false);
////		
////		return elStr;

		// CURRENTLY, THIS METHOD IS NOT USED - the serialized inserted element is transmitted in the message body (see OperationXMLTransformer)
		return XMLHelper.getElementString(element, false);
		
//		return "";	
	}

	public String toXML() {
		setContent(Element2String());
		return super.toXML();
	}

	public void setParameterValue(String parameter,String val) {
		super.setParameterValue(parameter, val);
	}
}
