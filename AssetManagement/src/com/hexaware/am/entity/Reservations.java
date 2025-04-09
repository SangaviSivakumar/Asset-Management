package com.hexaware.am.entity;

import java.time.LocalDate;

public class Reservations {
	private int reservationID;
	private Assets AssetID;
	private Employees EmployeeID;
	private LocalDate reservationDate;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
	
	// Default Constructor
	public Reservations() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Parameterized Constructor
	public Reservations(int reservationID, Assets assetID, Employees employeeID, LocalDate reservationDate, LocalDate startDate,
			LocalDate endDate, String status) {
		super();
		this.reservationID = reservationID;
		AssetID = assetID;
		EmployeeID = employeeID;
		this.reservationDate = reservationDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	// Getters and Setters
	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		if (reservationID <= 0) {
            throw new IllegalArgumentException("Reservation ID must be a positive number.");
        }
		this.reservationID = reservationID;
	}

	public Assets getAssetID() {
		return AssetID;
	}

	public void setAssetID(Assets assetID) {
		if (assetID == null || assetID.getAssetID() <= 0) {
            throw new IllegalArgumentException("A valid asset must be selected for reservation.");
        }
		this.AssetID = assetID;
	}

	public Employees getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Employees employeeID) {
		if (employeeID == null || employeeID.getEmployeeID() <= 0) {
            throw new IllegalArgumentException("A valid employee must be assigned to the reservation.");
        }
		this.EmployeeID = employeeID;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		if (reservationDate == null || reservationDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Reservation date must not be in the future.");
        }
		this.reservationDate = reservationDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		if (startDate == null || startDate.isBefore(reservationDate)) {
            throw new IllegalArgumentException("Start date must be on or after the reservation date.");
        }
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		 if (endDate == null || startDate == null || endDate.isBefore(startDate)) {
	            throw new IllegalArgumentException("End date must be on or after the start date.");
	        }
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Reservation status is required.");
        }

        String[] allowedStatuses = {"pending", "approved", "canceled"};
        boolean valid = false;
        for (String s : allowedStatuses) {
            if (s.equalsIgnoreCase(status.trim())) {
                valid = true;
                break;
            }
        }

        if (!valid) {
            throw new IllegalArgumentException("Status must be one of: pending, approved, canceled.");
        }

        this.status = status.trim().toLowerCase();  
	}
	
	
	
	
	
	
	

}
