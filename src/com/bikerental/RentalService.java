package com.bikerental;

import java.util.ArrayList;

public class RentalService {
	
	private ArrayList<Bike> bikes = new ArrayList<>();
	private ArrayList<Customer> customers=new ArrayList<>();
	private ArrayList<Booking> bookings=new ArrayList<>();
	 private int nextBookingId = 1;
		public void addBike(Bike bike) {
			if (searchBike(bike.getBikeId()) != null) {
			    System.out.println("Bike ID already exists.");
			    return;
			}

			bikes.add(bike);
	    }
		
		public void addCustomer(Customer customer) {
			if (searchCustomer(customer.getCustomerId())!= null) {
			    System.out.println("Customer ID already exists.");
			    return;
			}
			customers.add(customer);
		}
		
		public void displayBikes() {
			
			if (bikes.isEmpty()) {
			    System.out.println("No bikes available.");
			    return;
			}
			
			for(int i=0;i<bikes.size();i++) {
				Bike bike = bikes.get(i);
				System.out.println("----------------------------");
				System.out.println("Bike ID       : " + bike.getBikeId());
				System.out.println("Bike Name     : " + bike.getBikeName());
				System.out.println("Brand         : " + bike.getBrand());
				System.out.println("Price Per Day : " + bike.getPricePerDay());
				System.out.println("Status : " +(bike.isAvailable() ? "Available" : "Booked"));
				System.out.println("----------------------------");
			}
		}
		public void displayBookedBikes() {

		    boolean found = false;

		    for (int i = 0; i < bikes.size(); i++) {

		        Bike bike = bikes.get(i);

		        if (!bike.isAvailable()) {

		            found = true;

		            System.out.println("----------------------------");
		            System.out.println("Bike ID       : " + bike.getBikeId());
		            System.out.println("Bike Name     : " + bike.getBikeName());
		            System.out.println("Brand         : " + bike.getBrand());
		            System.out.println("Price Per Day : " + bike.getPricePerDay());
		            System.out.println("----------------------------");
		        }
		    }

		    if (!found) {
		        System.out.println("No Booked Bikes.");
		    }
		}
		
		public void displayAvailableBikes() {

		    boolean found = false;

		    for (int i = 0; i < bikes.size(); i++) {

		        Bike bike = bikes.get(i);

		        if (bike.isAvailable()) {

		            found = true;

		            System.out.println("----------------------------");
		            System.out.println("Bike ID       : " + bike.getBikeId());
		            System.out.println("Bike Name     : " + bike.getBikeName());
		            System.out.println("Brand         : " + bike.getBrand());
		            System.out.println("Price Per Day : " + bike.getPricePerDay());
		            System.out.println("----------------------------");
		        }
		    }

		    if (!found) {
		        System.out.println("No Available Bikes.");
		    }
		}
		
		
		public Bike searchBike(int bikeId) {
			for(int i=0;i<bikes.size();i++) {
				Bike bike=bikes.get(i);
				if(bike.getBikeId() == bikeId) {
					return bike;
				}
			}
			return null;
		}
         
		public Customer searchCustomer(int customerId) {
			for(int i=0;i<customers.size();i++) {
				Customer customer=customers.get(i);
				if(customer.getCustomerId()==customerId) {
					return customer;
				}
			}
			return null;
		}
		
		public Booking searchBooking(int bookingId) {
		    for (int i = 0; i < bookings.size(); i++) {
		        Booking booking = bookings.get(i);

		        if (booking.getBookingId() == bookingId) {
		            return booking;
		        }
		    }

		    return null;
		}
		
		public void removeBike(int bikeId) {
            for (int i = 0; i < bikes.size(); i++) {
		        Bike bike = bikes.get(i);
		        if (bike.getBikeId() == bikeId) {
		            if (!bike.isAvailable()) {
		                System.out.println("Cannot remove. Bike is currently booked.");
		                return;
		            }
		            bikes.remove(i);
		            System.out.println("Bike removed successfully.");
		            return;
		        }
		    }
		    System.out.println("Bike not found.");
		}
		
		
		public void bookBike(int bikeId, int customerId, int rentalDays) {
			Bike bike = searchBike(bikeId);
			
			if (bike == null) {
		        System.out.println("Bike not found.");
		        return;
		    }
			
			Customer customer = searchCustomer(customerId);
		    if (customer == null) {
		        System.out.println("Customer not found.");
		        return;
		    }
		    if (rentalDays <= 0) {
			    System.out.println("Rental days must be greater than zero.");
			    return;
			}

		    if (!bike.isAvailable()) {
		        System.out.println("Bike is already booked.");
		        return;
		    }

		   

		    Booking booking = new Booking( nextBookingId++, bike, customer, rentalDays);

		    bookings.add(booking);

		    bike.setAvailable(false);

		    System.out.println("Bike booked successfully.");
		    System.out.println("Booking ID : " + booking.getBookingId());
		    System.out.println("Customer : " + customer.getCustomerName());
		    System.out.println("Bike : " + bike.getBikeName());
		    System.out.println("Rental Days : " + rentalDays);
		    System.out.println("Total Amount : " + booking.getTotalAmount());
		}
		
		
		public void returnBike(int bookingId) {
			Booking booking=searchBooking(bookingId);
			if(booking==null) {
				System.out.println("Booking not found");
				return;
			}
			Bike bike=booking.getBike();
			bike.setAvailable(true);
            bookings.remove(booking);
            
            System.out.println("Bike return successfully");
			
		}
		
		public void displayCustomers() {

		    if (customers.isEmpty()) {
		        System.out.println("No customers found.");
		        return;
		    }

		    for (int i = 0; i < customers.size(); i++) {

		        Customer customer = customers.get(i);

		        System.out.println("----------------------------");
		        System.out.println("Customer ID     : " + customer.getCustomerId());
		        System.out.println("Customer Name   : " + customer.getCustomerName());
		        System.out.println("Mobile Number   : " + customer.getMobileNumber());
		        System.out.println("License Number  : " + customer.getLicenseNumber());
		        System.out.println("----------------------------");
		    }
		}
		
		public void displayBookings() {

		    if (bookings.isEmpty()) {
		        System.out.println("No bookings found.");
		        return;
		    }

		    for (int i = 0; i < bookings.size(); i++) {

		        Booking booking = bookings.get(i);

		        System.out.println("----------------------------");
		        System.out.println("Booking ID     : " + booking.getBookingId());
		        System.out.println("Customer Name  : " + booking.getCustomer().getCustomerName());
		        System.out.println("Bike Name      : " + booking.getBike().getBikeName());
		        System.out.println("Rental Days    : " + booking.getRentalDays());
		        System.out.println("Total Amount   : " + booking.getTotalAmount());
		        System.out.println("----------------------------");
		    }
		}
		public void displayDashboard() {

		    int availableBikes = 0;
		    int bookedBikes = 0;

		    for (int i = 0; i < bikes.size(); i++) {

		        Bike bike = bikes.get(i);

		        if (bike.isAvailable()) {
		            availableBikes++;
		        } else {
		            bookedBikes++;
		        }
		    }

		    System.out.println("\n========== Bike Rental Dashboard ==========");
		    System.out.println("Total Bikes       : " + bikes.size());
		    System.out.println("Available Bikes   : " + availableBikes);
		    System.out.println("Booked Bikes      : " + bookedBikes);
		    System.out.println("Total Customers   : " + customers.size());
		    System.out.println("Active Bookings   : " + bookings.size());
		    System.out.println("===========================================");
		}
		
	    
}
