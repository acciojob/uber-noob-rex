package com.driver.services.impl;

import com.driver.model.*;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Override
	public void register(Customer customer) {
		//Save the customer in database
		customerRepository2.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// Delete customer without using deleteById function
		Customer customer = customerRepository2.findById(customerId).get();
		customerRepository2.delete(customer);
	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception{
		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
		Driver driver = null;
		TripBooking bookTrip = new TripBooking();
		List<Driver> driverList = driverRepository2.findAll();
		for (Driver d : driverList) {
			if (d.getCab().getAvailable()) {
				if ((driver == null) || (driver.getDriverId() > d.getDriverId())) {
					driver = d;
				}
			}
		}
		if(driver == null) {
			throw new Exception("No cab available!");
		}
		Customer customer = customerRepository2.findById(customerId).get();

		bookTrip.setCustomer(customer);
		bookTrip.setDriver(driver);
		driver.getCab().setAvailable(Boolean.FALSE);
		bookTrip.setFromLocation(fromLocation);
		bookTrip.setToLocation(toLocation);
		bookTrip.setDistanceInKm(distanceInKm);
		bookTrip.setStatus(TripStatus.CONFIRMED);

		customer.getTripBookingList().add(bookTrip);
		customerRepository2.save(customer); //saving the parent.

		driver.getTripBookingList().add(bookTrip);
		driverRepository2.save(driver);

		return bookTrip;

	}

	@Override
	public void cancelTrip(Integer tripId){
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking trip = tripBookingRepository2.findById(tripId).get();
		trip.setStatus(TripStatus.CANCELED);
		trip.getDriver().getCab().setAvailable(true);
		trip.setBill(0);
		tripBookingRepository2.save(trip);
	}

	@Override
	public void completeTrip(Integer tripId){
		//Complete the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking trip = tripBookingRepository2.findById(tripId).get();
		trip.setStatus(TripStatus.COMPLETED);
		trip.getDriver().getCab().setAvailable(true);

		int dist = trip.getDistanceInKm();
		int cabPrice = trip.getDriver().getCab().getPerKmRate();
		int bill = dist * cabPrice;
		trip.setBill(bill);
		tripBookingRepository2.save(trip);
	}
}
