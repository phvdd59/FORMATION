package mfa.sql;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MfaMain {

	public static void main(String[] args) {
		MfaMain m = new MfaMain();
		m.init();
	}

	private void init() {
		lectureDom();

	}

	private void lectureDom() {
		File fLecture = new File("C:/DevFormation/GIT/FORMATION/ProjectCV/WebContent/WEB-INF/xml/CVAdelineCapel.xml");
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(fLecture);

			Element racine = document.getDocumentElement();
			NodeList list = racine.getChildNodes();
			int nbList = list.getLength();
			for (int i = 0; i < nbList; i++) {
				if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element eExp = (Element) list.item(i);
					NodeList lExp = eExp.getChildNodes();

					String dateExp = eExp.getAttribute("dateExp");
					String entreprise = eExp.getAttribute("entreprise");
					String poste = eExp.getAttribute("poste");
					String description = eExp.getTextContent();
					System.out.println(dateExp + " " + entreprise + " " + poste + " " + description);
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
