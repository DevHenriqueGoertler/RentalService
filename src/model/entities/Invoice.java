package model.entities;

public class Invoice {
	
	private double basicPayment;
	private double tax;
	private double totalPayment;
	
	public Invoice(double basicPayment, double tax, double totalPayment) {
		this.basicPayment = basicPayment;
		this.tax = tax;
		this.totalPayment = totalPayment;
	}

	public double getBasicPayment() {
		return basicPayment;
	}

	public double getTax() {
		return tax;
	}

	public double getTotalPayement() {
		return totalPayment;
	}
		
	@Override
	public String toString() {
		return "Basic payment: " + String.format("%.2f%n", basicPayment)
			+ "Tax: " + String.format("%.2f%n", tax)
			+ "Total payment: " + String.format("%.2f%n", totalPayment);
	}
}
