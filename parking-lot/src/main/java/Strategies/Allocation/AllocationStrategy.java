package Strategies.Allocation;

import BaseClasses.ParkingSpot;
import BaseClasses.VehicleType;

import java.util.List;

public interface AllocationStrategy {
    public int[] getNextSpot(List<List<ParkingSpot>> parkingSpace, VehicleType vehicleType);
}
