package ua.fuego_2000;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseDom {
	public static void  ParseMetod(String fileName) throws Exception{
		List<Good> listGoodOb = new ArrayList<>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(fileName);
		Element root = doc.getDocumentElement();
		NodeList listGood = root.getElementsByTagName("goods");
		for (int i = 0; i < listGood.getLength(); i++) {
	          Node childNode = listGood.item(i); // текущий нод
	          listGoodOb.add(getGood(childNode));
	        }
		Shop  shop= new Shop();
		shop.setListGood(listGoodOb);
		System.out.println(shop);
	}

	private static Good getGood(Node node) {
		Good good = new Good();
		Element el = (Element) node;
		good.setId(Integer.parseInt(el.getAttribute("id")));
		NodeList list = el.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
	          Node childNode = list.item(i); // текущий нод
	          if (childNode.getNodeName().equals("name")){
	        	  good.setName(childNode.getFirstChild().getTextContent());  
	          }
	          else if (childNode.getNodeName().equals("price")){
	        	  good.setPrice(Double.parseDouble(childNode.getFirstChild().getTextContent()));  
	          }
	          else if (childNode.getNodeName().equals("category")){
	        	  good.setCategory(childNode.getFirstChild().getTextContent());  
	          }
	          else if (childNode.getNodeName().equals("description")){
	        	  good.setDescription(childNode.getFirstChild().getTextContent());  
	          }
	        }
		//System.out.println(good);	
	return good;
	}	
}
