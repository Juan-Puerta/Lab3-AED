package world;

public class Bitcoin implements Comparable{
	
	private double price;
	private String initialDate;
	private String finalDate;

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Bitcoin(double price, String initialDate, String finalDate) {
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
	
	

}
