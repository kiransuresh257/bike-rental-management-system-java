package com.bikerental;

public class Booking {
	
	private int bookingId;
	private Bike bike;
	private Customer customer;
	private int rentalDays;
	private double totalAmount;
	
	public Booking(int bookingId,Bike bike,Customer customer,int rentalDays ){
		this.bookingId=bookingId;
		this.bike=bike;
		this.customer=customer;
		this.rentalDays=rentalDays;
		this.totalAmount = bike.getPricePerDay()*rentalDays;	
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
		this.totalAmount=bike.getPricePerDay()*rentalDays;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getRentalDays() {
		return rentalDays;
	}

	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
		this.totalAmount=bike.getPricePerDay()*rentalDays;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	
	
}
