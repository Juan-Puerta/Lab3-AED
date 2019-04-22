package world;

import java.io.Serializable;
import java.util.Date;

public class Action implements Comparable<Action>, Serializable{

	private String name;
	private Date date;
	private double price;


	public Action(String name, Date date, double price) {
		super();
		this.name = name;
		this.date = date;
		this.price = price;
	}
	
	@Override
	public int compareTo(Action o) {
		// TODO Auto-generated method stub
		if (date.compareTo(o.getDate()) > 0) {
            return 1;
        } else if (date.compareTo(o.getDate()) < 0) {
            return -1;
        } else {
            return 0;
        }
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	

}
