package ua.fuego_2000;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	boolean isGoods = false;
	boolean isName = false;
	boolean isPrice = false;
	boolean isDescription = false;
	boolean isCategory = false;
	List<Good> listGoodOb = new ArrayList<>();
	Good good;
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		Shop shop = new Shop();
		shop.setListGood(listGoodOb);
		System.out.println("shop = "+shop);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {
		// TODO Auto-generated method stub
		
		if (qName.equals("goods")){
			good = new Good();
			good.setId(Integer.parseInt(attributes.getValue("id")));
			isGoods = true;
		}
		else if (qName.equals("name")){
			isName = true;
		}
		else if (qName.equals("price")){
			isPrice = true;
		}
		else if (qName.equals("category")){
			isCategory = true;
		}
		else if (qName.equals("description")){
			isDescription = true;
		} 
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if (qName.equals("goods")){
			listGoodOb.add(good);
			isGoods = false;
		}
		else if (qName.equals("name")){
			isName = false;
		}
		else if (qName.equals("price")){
			isPrice = false;
		}
		else if (qName.equals("category")){
			isCategory = false;
		}
		else if (qName.equals("description")){
			isDescription = false;
		}
			
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (isName){
			good.setName(new String(ch, start, length));
		}
		else if (isPrice){
			good.setPrice(Double.parseDouble(new String(ch, start, length)));
		}
		else if (isCategory){
			good.setCategory(new String(ch, start, length));
		}
		else if (isDescription){
			good.setDescription(new String(ch, start, length));
		}
		
	}
	
}

