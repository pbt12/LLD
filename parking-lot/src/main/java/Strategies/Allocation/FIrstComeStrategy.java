package Strategies.Allocation;

import BaseClasses.ParkingSpot;
import BaseClasses.VehicleType;

import java.util.List;

public class FIrstComeStrategy implements AllocationStrategy {

    public int[] getNextSpot(List<List<ParkingSpot>> parkingSpace, VehicleType vehicleType){
        int floors = parkingSpace.size();
        for(int i=0;i<floors;i++){
            for(int j=0;j<parkingSpace.get(i).size();j++){
                ParkingSpot currentParkingSpot = parkingSpace.get(i).get(j);
                if(currentParkingSpot.getVehicleType() == vehicleType && currentParkingSpot.getFilled() == Boolean.FALSE){
                    return new int[] {i, j};
                }
            }
        }
        System.out.println("ERROR: No Vacant Spot Found");
        return new int[] {-1, -1};
    }
}
