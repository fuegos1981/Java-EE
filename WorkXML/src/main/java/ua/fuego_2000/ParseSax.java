package ua.fuego_2000;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class ParseSax {
		public static void  ParseMetod(String fileName) throws Exception{
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			MyHandler def = new MyHandler();
			sp.parse(fileName,def);
		}

}
