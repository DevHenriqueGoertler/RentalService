package model.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private double pricePerHour;
	private double pricePerDay;
	
	private TaxService taxService;

	public RentalService(double pricePerHour, double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		double hours = (double)(t2 - t1) / 1000 / 60 / 60;
		
		double basicPayment;
		if (hours <= 12.0) {
			basicPayment = pricePerHour * Math.ceil(hours);
		}
		else {
			basicPayment = pricePerDay * Math.ceil(hours / 24);
		}

		double tax = taxService.tax(basicPayment);
		double totalPayment = tax + basicPayment;
		carRental.addInvoice(new Invoice(basicPayment, tax, totalPayment));
	}
	
	public static int compareHour(Date start, Date finish) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(finish);
		int hourFinish = GregorianCalendar.HOUR_OF_DAY;
		cal.setTime(start);
		int hourStart = GregorianCalendar.HOUR_OF_DAY;
		int hours = hourFinish - hourStart;
		
		return hours;
		}
	public static int compareDay(Date start, Date finish) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(finish);
		int dayFinish = GregorianCalendar.DAY_OF_MONTH;
		cal.setTime(start);
		int dayStart = GregorianCalendar.DAY_OF_MONTH;
		int day = dayFinish - dayStart;
		
		return day;
		
		}
	}

