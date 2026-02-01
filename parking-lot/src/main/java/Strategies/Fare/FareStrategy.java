package Strategies.Fare;

import BaseClasses.ParkingSpot;

public interface FareStrategy {
    public Double getFare(ParkingSpot parkingSpot)
//        Double fare;
//        Instant currentTime = Instant.now();
//        Instant entryTime = parkingSpot.getEntryTime();
//        Duration duration = Duration.between(entryTime, currentTime);
//        long minutes = duration.toMinutes();
//        if(parkingSpot.getVehicleType() == VehicleType.BIKE){
//            return (double) (10*minutes);
//        }
    ;
}
