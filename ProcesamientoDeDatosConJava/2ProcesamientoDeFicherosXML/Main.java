import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Main {

	public static void main(String[] args) throws Exception {
		/*
		 * Crea una aplicacion que lea el fichero: libros.xml y cree para cada item un objeto "Book".
		 * Al finalizar la ejecucion, la aplicacion debera mostrar en pantalla toda la informacion de cada libro
		 */
		
		//Creamos el bojeto DocumentBuilder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		//Cargamos el fichero en memoria
		Document document = builder.parse(new FileInputStream("libros.xml"));
		//Obtenemos la raiz del XML
		Element root = document.getDocumentElement();
		//Iteramos sobre la lista de nodos
		List<Libros> BookList = new ArrayList<>();
		//Obtenemos los nodos hijos
		NodeList nodeList = root.getChildNodes();
		//Obtenemos los elementos de cada nodo hijo
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node instanceof Element) {
//Creamos un objeto llamado Book de la clase Libros para cada item
				Libros Book = new Libros();
				//Mediante el ID obtenemos el contenido de cada nodo
				Book.id = node.getAttributes().getNamedItem("id").getNodeValue();
				NodeList childNodes = node.getChildNodes();
				//Obtenemos la informacion de los nodos
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node cNode = childNodes.item(j);
					//Identificamos el tag de los hijos de los libros encontrados
					if (cNode instanceof Element) {
						String content = cNode.getLastChild().getTextContent().trim();
						switch (cNode.getNodeName()) {
						case "Author":
							Book.Author = content;
							break;
						case "Title":
							Book.Title = content;
							break;
						case "Genre":
							Book.Genre = content;
							break;
						case "Price":
							Book.Price = content;
							break;
						case "PublishDate":
							Book.PublishDate = content;
							break;
						case "Description":
							Book.Description = content;
							break;
						}
					}
				}
				//Agregamos a la ArrayList cada libro
				BookList.add(Book);
			}
		}
		//Mostramos por pantalla el resultado de la lista de libros creada
		System.out.println("Books:");
		for(Libros Book: BookList) {
			System.out.println(Book);
		}
	}	
}
