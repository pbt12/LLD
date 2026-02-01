package Strategies.Fare;

import BaseClasses.ParkingSpot;
import BaseClasses.VehicleType;

import java.time.Duration;
import java.time.Instant;

public class TimeBoundFareStrategy implements FareStrategy {
    public Double getFare(ParkingSpot parkingSpot) {
        Double fare;
        Instant currentTime = Instant.now();
        Instant entryTime = parkingSpot.getEntryTime();
        Duration duration = Duration.between(entryTime, currentTime);
        long minutes = duration.toMinutes();
        if(parkingSpot.getVehicleType() == VehicleType.BIKE){
            fare = (double) (10*2);
        }
        else if(parkingSpot.getVehicleType() == VehicleType.CAR){
            fare = (double) (15*2);
        }
        else if(parkingSpot.getVehicleType() == VehicleType.TRUCK){
            fare = (double) (20*2);
        }else{
            throw new IllegalArgumentException("Illegal vehicle type recieved - " + parkingSpot.getVehicleType());
        }
        return fare;
    }
}
