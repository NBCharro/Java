import javax.xml.parsers.*;

import org.w3c.dom.Document;

public class DOM {
	
	public DOM(String ruta) throws Exception {
		//Creamos el archivo en memoria.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document = builder.parse(ClassLoader.getSystemResourceAsStream(ruta));
		
		System.out.println(document.getBaseURI());
		
		
	}
}
