package com.bikerental;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RentalService service = new RentalService();

        while (true) {

            System.out.println("\n========== Bike Rental System ==========");
            System.out.println("1. Add Bike");
            System.out.println("2. Display Bikes");
            System.out.println("3. Remove Bike");
            System.out.println("4. Add Customer");
            System.out.println("5. Display Customers");
            System.out.println("6. Book Bike");
            System.out.println("7. Return Bike");
            System.out.println("8. Display Bookings");
            System.out.println("9. Dashboard");
            System.out.println("10. Display Available Bikes");
            System.out.println("11. Display Booked Bikes");
            System.out.println("12. Exit");
            System.out.print("Enter your choice : ");

            int choice;

            try {

                choice = sc.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Please enter numbers only.");
                sc.nextLine();
                continue;
            }

            switch (choice) {

            case 1:

                System.out.print("Enter Bike ID : ");
                int bikeId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Bike Name : ");
                String bikeName = sc.nextLine();

                System.out.print("Enter Brand : ");
                String brand = sc.nextLine();

                System.out.print("Enter Price Per Day : ");
                int price = sc.nextInt();

                Bike bike = new Bike(bikeId, bikeName, brand, price);

                service.addBike(bike);
                break;

            case 2:

                service.displayBikes();
                break;

            case 3:

                System.out.print("Enter Bike ID : ");
                bikeId = sc.nextInt();

                service.removeBike(bikeId);
                break;

            case 4:

                System.out.print("Enter Customer ID : ");
                int customerId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Customer Name : ");
                String customerName = sc.nextLine();

                System.out.print("Enter Mobile Number : ");
                String mobileNumber = sc.nextLine();

                System.out.print("Enter License Number : ");
                String licenseNumber = sc.nextLine();

                Customer customer = new Customer(customerId, customerName, mobileNumber, licenseNumber);

                service.addCustomer(customer);
                break;

            case 5:

                service.displayCustomers();
                break;

            case 6:

                System.out.print("Enter Bike ID : ");
                bikeId = sc.nextInt();

                System.out.print("Enter Customer ID : ");
                customerId = sc.nextInt();

                System.out.print("Enter Rental Days : ");
                int rentalDays = sc.nextInt();

                service.bookBike(bikeId, customerId, rentalDays);
                break;

            case 7:

                System.out.print("Enter Booking ID : ");
                int bookingId = sc.nextInt();

                service.returnBike(bookingId);
                break;

            case 8:

                service.displayBookings();
                break;

            case 9:

                service.displayDashboard();
                break;

            case 10:

                service.displayAvailableBikes();
                break;

            case 11:

                service.displayBookedBikes();
                break;

            case 12:

                System.out.println("Thank You...");
                sc.close();
                return;

            default:

                System.out.println("Invalid Choice. Please try again.");
            }
        }
    }
}