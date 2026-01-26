import BaseClasses.ParkingSpot;
import BaseClasses.VehicleType;
import Strategies.Allocation.AllocationStrategy;
import Strategies.Allocation.FIrstComeStrategy;
import Strategies.Fare.FareStrategy;
import Strategies.Fare.TimeBoundFareStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {
    private static ParkingLot INSTANCE;
    private static FareStrategy fareStrategy;
    private static AllocationStrategy allocationStrategy;
    private ParkingLotManager(int floors, List<List<ParkingSpot>> parkingSpace){
        this.fareStrategy = new TimeBoundFareStrategy();
        this.allocationStrategy = new FIrstComeStrategy();
        INSTANCE =  new ParkingLot(floors, parkingSpace, allocationStrategy, fareStrategy);
    }

    public static ParkingLot getInstance(){
        if(INSTANCE != null){
            return INSTANCE;
        }
        List<List<ParkingSpot>> newParkingSpace = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<ParkingSpot> floorSpots = new ArrayList<>();

            ParkingSpot parkingSpot = new ParkingSpot();
            parkingSpot.setVehicleType(VehicleType.BIKE);
            floorSpots.add(parkingSpot);

            ParkingSpot parkingSpot2 = new ParkingSpot();
            parkingSpot2.setVehicleType(VehicleType.CAR);
            floorSpots.add(parkingSpot2);

            ParkingSpot parkingSpot3 = new ParkingSpot();
            parkingSpot3.setVehicleType(VehicleType.TRUCK);
            floorSpots.add(parkingSpot3);

            newParkingSpace.add(floorSpots);
        }
        //INSTANCE = new ParkingLot(2, newParkingSpace, allocationStrategy, fareStrategy);
        new ParkingLotManager(2, newParkingSpace);
        return INSTANCE;
    }

//    public void addFloor(){
//        List<ParkingSpot> floorSpots = new ArrayList<>();
//
//        ParkingSpot parkingSpot = new ParkingSpot();
//        parkingSpot.setVehicleType(VehicleType.BIKE);
//        floorSpots.add(parkingSpot);
//
//        ParkingSpot parkingSpot2 = new ParkingSpot();
//        parkingSpot.setVehicleType(VehicleType.BIKE);
//        floorSpots.add(parkingSpot2);
//
//        INSTANCE.addFloor(floorSpots);
//    }
}
