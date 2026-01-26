package BaseClasses;

import java.sql.Timestamp;
import java.time.Instant;

public class ParkingSpot {
    private VehicleType vehicleType;
    private String vehicleNo;
    private Instant entryTime;

    public ParkingSpot(){
        this.filled = Boolean.FALSE;
    }

    public Boolean getFilled() {
        return filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    private Boolean filled;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Instant entryTime) {
        this.entryTime = entryTime;
    }
}
