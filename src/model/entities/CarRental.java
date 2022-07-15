package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarRental {
	
	private Date start;
	private Date finish;
	
	private Vehicle vehicle;

	List<Invoice> list = new ArrayList<>();
	
	public CarRental(Date start, Date finish, Vehicle vehicle) {
		this.start = start;
		this.finish = finish;
		this.vehicle = vehicle;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<Invoice> getInvoices() {
		return list;
	}

	public void setInvoice(List<Invoice> list) {
		this.list = list;
	}
	
	public void addInvoice(Invoice invoice) {
		list.add(invoice);
	}
	
	public void removeInvoice(Invoice invoice) {
		list.remove(invoice);
	}
}
