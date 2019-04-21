package world;

public class Badge implements Comparable<Badge>{
	
	private double price;
	private String initialDate;
	private String finalDate;


	public Badge(double price, String initialDate, String finalDate) {
		super();
		this.price = price;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
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
	public int compareTo(Badge o) {
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
