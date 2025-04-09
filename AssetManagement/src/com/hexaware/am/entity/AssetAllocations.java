package com.hexaware.am.entity;

import java.time.LocalDate;

public class AssetAllocations {
	private int allocationID;
	private Assets AssetID;
	private Employees EmployeeID;
	private LocalDate allocationDate;
	private LocalDate returnDate;
	
	// Default Constructor
	public AssetAllocations() {
		super();
	}
	
	// Parameterized Constructor
	public AssetAllocations(int allocationID, Assets assetID, Employees employeeID, LocalDate allocationDate, LocalDate returnDate) {
		super();
		setAssetID(AssetID);
        setEmployeeID(EmployeeID);
        setAllocationDate(allocationDate);
	}

	// Getters and Setters
	public int getAllocationID() {
		return allocationID;
	}

	public void setAllocationID(int allocationID) {
		if (allocationID <= 0) {
            throw new IllegalArgumentException("Allocation ID must be positive.");
        }
		this.allocationID = allocationID;
	}

	public Assets getAssetID() {
		return AssetID;
	}

	public void setAssetID(Assets assetID) {
		if (assetID == null || assetID.getAssetID() <= 0) {
            throw new IllegalArgumentException("Asset ID must be positive.");
        }
		this.AssetID = assetID;
	}

	public Employees getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Employees employeeID) {
		if (employeeID == null || employeeID.getEmployeeID() <= 0) {
            throw new IllegalArgumentException("A valid Employee must be assigned as the asset owner.");
        }
		this.EmployeeID = employeeID;
	}

	public LocalDate getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(LocalDate allocationDate) {
	    if (allocationDate == null) {
	        throw new IllegalArgumentException("Allocation date cannot be null.");
	    }
	    this.allocationDate = allocationDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	 public void setReturnDate(LocalDate returnDate) {
	        if (returnDate != null && returnDate.isBefore(this.allocationDate)) {
	            throw new IllegalArgumentException("Return date cannot be before allocation date.");
	        }
	        this.returnDate = returnDate;
	    }
		

}
