package ua.fuego_2000;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shop")
public class Shop {
	private List<Good> listGood;

	public List<Good> getListGood() {
		return listGood;
	}
	@XmlElement(name = "goods")
	public void setListGood(List<Good> listGood) {
		this.listGood = listGood;
	}
	@Override
	public String toString() {
		return "Shop [listGood=" + listGood + "]";
	}
	
}
