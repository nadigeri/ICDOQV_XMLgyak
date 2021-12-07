package SaxICDOQV_1019;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;

import org.xml.sax.*;

public class SaxICDOQV {

	public static void main(String[] args) {
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			SaxHandler saxHandler = new SaxHandler();
			saxParser.parse(new File("src/SaxICDOQV_1019/szemelyekICDOQV.xml"), saxHandler);
		
		}catch(ParserConfigurationException | SAXException | IOException pce) {
			System.out.println("Hiba: "+pce.getMessage());
		}
	}
}
