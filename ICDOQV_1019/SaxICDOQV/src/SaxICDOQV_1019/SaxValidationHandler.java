package SaxICDOQV_1019;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SaxValidationHandler extends DefaultHandler {

	public void warning(SAXParseException spe) throws SAXException {
	    System.out.println("Figyelmeztet�s:\n" + spe.getMessage());
	}
	        
	public void error(SAXParseException spe) throws SAXException {
	    String message = "Hiba:\n" + spe.getMessage();
	    throw new SAXException(message);
	}

	public void fatalError(SAXParseException spe) throws SAXException {
	    String message = "Fat�lis hiba:\n" + spe.getMessage();
	    throw new SAXException(message);
	}
}

