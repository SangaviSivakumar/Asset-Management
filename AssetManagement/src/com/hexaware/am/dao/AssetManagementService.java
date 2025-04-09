package com.hexaware.am.dao;

import com.hexaware.am.entity.Assets;
import com.hexaware.am.entity.Employees;

public interface AssetManagementService {
	
	boolean addAsset(Assets asset);
	boolean updateAsset(Assets asset);
    boolean deleteAsset(int assetID);
    boolean allocateAsset(int assetId, int employeeId, String allocationDate);
//	boolean deallocateAsset(int assetId, int employeeId, String returnDate);
//	boolean performMaintenance(int assetId, String maintenanceDate,String description, double cost);
//	boolean reserveAsset(int assetId, int employeeId, String reservationDate, String startDate, String endDate);
//	boolean withdrawReservation(int reservationId);

}
