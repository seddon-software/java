package forms;

////////////////////////////////////////////////////////////
//
//    ItemBean.java
//
////////////////////////////////////////////////////////////

import java.io.*;

@SuppressWarnings("serial")
public class ItemBean implements Serializable {
	String name;
	double cost;
	int quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ItemBean() {
		name = "Beer";
		cost = 6.00;
		quantity = 1;
	}

}
