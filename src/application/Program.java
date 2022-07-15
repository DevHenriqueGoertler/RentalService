package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Invoice;
import model.entities.Vehicle;
import model.service.BrazilTaxService;
import model.service.RentalService;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter rental data");
			System.out.print("Car model: ");
			String vehicle = sc.nextLine();
			System.out.print("PickUp (dd/MM/yyyy hh:mm): ");
			Date start = sdf.parse(sc.nextLine());
			System.out.print("Return (dd/MM/yyyy hh:mm): ");
			Date finish = sdf.parse(sc.nextLine());
			System.out.print("Enter price per hour: ");
			double pricePerHour = sc.nextDouble();
			System.out.print("Enter price per day: ");
			double pricePerDay = sc.nextDouble();
			
			CarRental carRental = new CarRental(start, finish, new Vehicle(vehicle));
			RentalService rs = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
			rs.processInvoice(carRental);
			
			System.out.println("INVOICE");
			for (Invoice x : carRental.getInvoices()) {
				System.out.print(x);
			}
			
		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
