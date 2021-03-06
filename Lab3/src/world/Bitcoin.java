package world;

import java.io.Serializable;
import java.util.Date;

public class Bitcoin implements Comparable<Bitcoin>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3476279828461051682L;
	
	private String name;
	private double price;
	private Date date;
	private Bitcoin next;

	public Bitcoin getNext() {
		return next;
	}

	public void setNext(Bitcoin next) {
		this.next = next;
	}

	public Bitcoin(String name, Date date, double price) {
		super();
		this.name = name;
		this.date = date;
		this.price = price;
		this.next = null;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int compareTo(Bitcoin o) {
		// TODO Auto-generated method stub
		 if (date.compareTo(o.getDate()) > 0) {
	            return 1;
	        } else if (date.compareTo(o.getDate()) < 0) {
	            return -1;
	        } else {
	            return 0;
	        }
	}
	
	

}
