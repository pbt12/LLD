import BaseClasses.ParkingSpot;
import BaseClasses.VehicleType;
import Strategies.Allocation.AllocationStrategy;
import Strategies.Fare.FareStrategy;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    int floors;
    private List<List<ParkingSpot>> parkingSpaces;
    private AllocationStrategy allocationStrategy;
    private FareStrategy fareStrategy;
    ConcurrentHashMap<String, int[]> ticketSpotMap;

    public ParkingLot(int floors, List<List<ParkingSpot>> parkingSpaces, AllocationStrategy allocationStrategy, FareStrategy fareStrategy){
        this.floors = floors;
        this.parkingSpaces = new ArrayList<>();
        this.parkingSpaces.addAll(parkingSpaces);
        this.allocationStrategy = allocationStrategy;
        this.fareStrategy = fareStrategy;
        this.ticketSpotMap = new ConcurrentHashMap<String, int[]>();
    }

    public String park(String vehicleNo, VehicleType vehicleType, Instant entryTime){
        //1. Allocate spot using strategies
        int[] parkingSpotLocation = allocationStrategy.getNextSpot(parkingSpaces, vehicleType);
        fillSpot(parkingSpotLocation, vehicleNo, vehicleType, entryTime);
        //2. make Ticket number or ticket
        String ticketId = generateTicketNumber();
        ticketSpotMap.put(ticketId, parkingSpotLocation);
        //3. return ticket
        System.out.println("Vehicle parked with no: " + vehicleNo);
        return ticketId;
    }

    public Double unPark(String ticketId){
        //1. Retrieve spot using ticketno and unfill the spot
        int[] parkingSpotLocation = ticketSpotMap.get(ticketId);
        ParkingSpot parkingSpot = parkingSpaces.get(parkingSpotLocation[0]).get(parkingSpotLocation[1]);
        Double fare = fareStrategy.getFare(parkingSpot);
        parkingSpot.setEntryTime(null);
        //parkingSpot.setVehicleType(null);
        parkingSpot.setVehicleNo(null);
        parkingSpot.setFilled(Boolean.FALSE);
        ticketSpotMap.remove(ticketId);
        //2. find fare using strategy

        //3. Return fare
        System.out.println("Vehicle unparked with id and fare: " + ticketId + " " + fare);
        return fare;
    }

    private void fillSpot(int[] parkingSpotLocation, String vehicleNo, VehicleType vehicleType, Instant entryTime){
        if(parkingSpotLocation[0] == -1 || parkingSpotLocation[1] == -1){

           //System.out.println("No vacant spot found for the vehicle");
            throw new IllegalStateException("No vacant spot found for the vehicle");
        }
        if(parkingSpaces.get(parkingSpotLocation[0]).get(parkingSpotLocation[1]).getFilled() == Boolean.TRUE){
            throw new IllegalStateException("Spot already filled: floor - " + parkingSpotLocation[0] + " and index - " + parkingSpotLocation[1]);

        }
        parkingSpaces.get(parkingSpotLocation[0]).get(parkingSpotLocation[1]).setFilled(Boolean.TRUE);
        parkingSpaces.get(parkingSpotLocation[0]).get(parkingSpotLocation[1]).setVehicleNo(vehicleNo);
        //parkingSpaces.get(parkingSpotLocation[0]).get(parkingSpotLocation[1]).setVehicleType(vehicleType);
        parkingSpaces.get(parkingSpotLocation[0]).get(parkingSpotLocation[1]).setEntryTime(entryTime);
    }

    private String generateTicketNumber(){
        return UUID.randomUUID().toString();
    }

    public void addFloor(List<ParkingSpot> parkingFloor){
        parkingSpaces.add(parkingFloor);
    }

}
