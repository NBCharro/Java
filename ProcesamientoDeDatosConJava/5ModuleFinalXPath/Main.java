import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) throws Exception {
		String fileName = "geografia.xml";
		Document document = getDocument(fileName);
		Scanner sc = new Scanner(System.in);
		int numero = 0;
		while (numero != 1567) {
			System.out.println("Seleccione una opcion:");
			System.out.println();
			System.out.println("1. Opcion 1: Lista de paises.");
			System.out.println("2. Opcion 2: Paises que tienen el Euro como moneda");
			System.out.println("3. Opcion 3: Paises con superficie mayor de 1.000.000");
			System.out.println("4. Opcion 4: Salir.");
			System.out.println();
			String xpathExpression = "";
			numero = sc.nextInt();
			if(numero == 1) {
				System.out.println("Lista de paises:");
				xpathExpression = "/geografia/paises/pais/@nombre";
				evaluateXPath(document, xpathExpression);
				
			}
			if(numero == 2) {
				System.out.println("Paises que tienen el Euro como moneda:");
				xpathExpression = "/geografia/paises/pais[moneda='euro']/@nombre";
				evaluateXPath(document, xpathExpression);
				
			}
			if(numero == 3) {
				System.out.println("Paises con superficie mayor de 1.000.000:");
				xpathExpression = "/geografia/paises/pais[superficie>1000000]/@nombre";
				evaluateXPath(document, xpathExpression);
				
			}
			if(numero == 4) {
				System.out.println();
				System.out.println("Gracias por usar nuestros servicios.");
				break;
			}
		}
	}

	private static Document getDocument(String fileName) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(fileName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static void makeQueries(Document document) throws Exception {
		String xpathExpression = "";
		xpathExpression = "/geografia/paises/pais[superficie>1000000]/@nombre";
		evaluateXPath(document, xpathExpression);
	}
	
	private static void evaluateXPath(Document document, String xpathExpression) throws Exception{
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		List<String> values = new ArrayList();
		try {
			XPathExpression expr = xpath.compile(xpathExpression);
			NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
			
			for (int i = 0; i < nodes.getLength(); i++) {
				values.add(nodes.item(i).getNodeValue());
				
			}
		} catch (Exception e) {
			System.out.println("Error to evaluate XPath");
			e.printStackTrace();
		}
		System.out.println(values);
		System.out.println();
	}

}
