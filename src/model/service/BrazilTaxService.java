package model.service;

public class BrazilTaxService implements TaxService{

	@Override
	public double tax(double amount) {
		double totalTax = 0;
		if (amount < 100.00) {
			totalTax = amount * 0.15;
		} else {
			totalTax = amount * 0.2;
		}
		return totalTax;
	}
}
