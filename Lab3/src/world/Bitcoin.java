package world;

public class Bitcoin implements Comparable<Bitcoin>{
	
	private double price;
	private String initialDate;
	private String finalDate;
	private Bitcoin next;

	public Bitcoin getNext() {
		return next;
	}

	public void setNext(Bitcoin next) {
		this.next = next;
	}

	public Bitcoin(double price, String initialDate, String finalDate) {
		super();
		this.price = price;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.next = null;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}

	public String getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}

	@Override
	public int compareTo(Bitcoin o) {
		// TODO Auto-generated method stub
		 if (price > o.getPrice()) {
	            return 1;
	        } else if (price < o.getPrice()) {
	            return -1;
	        } else {
	            return 0;
	        }
	}
	
	

}
