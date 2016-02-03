package ua.fuego_2000;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class ParseJaxB {
	public static void  ParseMetod(String fileName) throws Exception{
		 JAXBContext context = JAXBContext.newInstance(Shop.class);
		 Unmarshaller unmarshaller = context.createUnmarshaller();
		 Object ob = unmarshaller.unmarshal(new File(fileName));
		 Shop sh = (Shop) ob;
		 System.out.println(sh);
		
	}

	public static void createXML(Shop shop, String fileName) throws Exception {
		
		 JAXBContext context = JAXBContext.newInstance(Shop.class);
		 Marshaller marshaller = context.createMarshaller();
		 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		 File file = new File(fileName);
		 marshaller.marshal(shop, file);
		
	}
}
