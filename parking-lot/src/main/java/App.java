import BaseClasses.ParkingSpot;
import BaseClasses.VehicleType;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ParkingLot parkingLot = ParkingLotManager.getInstance();
        String ticket1 = null;
        String ticket2 = null;
        String ticket3 = null;
        String ticket4 = null;
        String ticket5 = null;
        String ticket6 = null;
        String ticket7 = null;

        try {
            ticket1 = parkingLot.park("AP0001", VehicleType.CAR, Instant.now());
            System.out.println("Ticket issued: " + ticket1);
        } catch (Exception e) {
            System.out.println("Failed to park AP0001: " + e.getMessage());
        }

        try {
            ticket2 = parkingLot.park("AP0002", VehicleType.TRUCK, Instant.now());
            System.out.println("Ticket issued: " + ticket2);
        } catch (Exception e) {
            System.out.println("Failed to park AP0002: " + e.getMessage());
        }

        try {
            ticket3 = parkingLot.park("AP0003", VehicleType.BIKE, Instant.now());
            System.out.println("Ticket issued: " + ticket3);
        } catch (Exception e) {
            System.out.println("Failed to park AP0003: " + e.getMessage());
        }

        try {
            ticket4 = parkingLot.park("AP0004", VehicleType.BIKE, Instant.now());
            System.out.println("Ticket issued: " + ticket4);
        } catch (Exception e) {
            System.out.println("Failed to park AP0004: " + e.getMessage());
        }

        try {
            ticket5 = parkingLot.park("AP0005", VehicleType.BIKE, Instant.now());
            System.out.println("Ticket issued: " + ticket5);
        } catch (Exception e) {
            System.out.println("Failed to park AP0005: " + e.getMessage());
        }

        try {
            ticket6 = parkingLot.park("AP0006", VehicleType.BIKE, Instant.now());
            System.out.println("Ticket issued: " + ticket6);
        } catch (Exception e) {
            System.out.println("Failed to park AP0006: " + e.getMessage());
        }

        try {
            ticket7 = parkingLot.park("AP0007", VehicleType.BIKE, Instant.now());
            System.out.println("Ticket issued: " + ticket7);
        } catch (Exception e) {
            System.out.println("Failed to park AP0007: " + e.getMessage());
        }




        System.out.println("--------------------- UNPARKING --------------------");
        System.out.println("--------------------- UNPARKING --------------------");
        Double fare1 = parkingLot.unPark(ticket1);
        System.out.println("Fare1 for ticketid: " + ticket1 + " " + fare1);
        Double fare3 = parkingLot.unPark(ticket3);
        System.out.println("Fare3 for ticketid: " + ticket3 + " " + fare3);

        List<ParkingSpot> floorSpots = new ArrayList<>();

        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setVehicleType(VehicleType.BIKE);
        floorSpots.add(parkingSpot);

        ParkingSpot parkingSpot2 = new ParkingSpot();
        parkingSpot2.setVehicleType(VehicleType.TRUCK);
        floorSpots.add(parkingSpot2);

        parkingLot.addFloor(floorSpots);
        String ticket8 = parkingLot.park("AP0007", VehicleType.BIKE, Instant.now());
        Double fare8 = parkingLot.unPark(ticket8);
        System.out.println("fare8 for ticketid: " + ticket8 + " " + fare8);
    }
}
