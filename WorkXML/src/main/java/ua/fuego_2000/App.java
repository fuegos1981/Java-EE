package ua.fuego_2000;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {
		Shop shop = new Shop();
		List<Good> list = new ArrayList<Good>();
		list.add(new Good("Телевизор", 200.50, "Техника", "Крупная", 1));
		list.add(new Good("Микроволновка", 400.00, "Техника", "Кухонная", 2));
		list.add(new Good("Планшет", 5000, "Техника", "Мелкая", 3));
		shop.setListGood(list);
		String fileName = "Shop.xml";
		ParseJaxB.createXML(shop, fileName);
		int var = 3;
		if (var ==1){
			ParseJaxB.ParseMetod(fileName);
		}
		else if (var ==2){
			ParseDom.ParseMetod(fileName);
		}
		else if (var ==3){
			ParseSax.ParseMetod(fileName);
		}

	}

}
