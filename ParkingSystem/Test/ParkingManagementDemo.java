package ParkingSystem.Test;

import ParkingSystem.Exceptions.ParkingSlotNotAvailableException;
import ParkingSystem.Exceptions.VehicleNotFoundException;
import ParkingSystem.Service.ParkingManagement;
import ParkingSystem.Service.ResidentVehicle;
import ParkingSystem.Service.Vehicle;
import ParkingSystem.Service.VisitorVehicle;

public class ParkingManagementDemo
{
    public static void main(String[] args) throws ParkingSlotNotAvailableException, VehicleNotFoundException {
        ParkingManagement pm = new ParkingManagement();
        Vehicle v1 = new ResidentVehicle("Tn472","Dharanie",12345667,100,true);
        Vehicle v2 = new ResidentVehicle("Tn572","Simren",98765432,200,false);
        Vehicle v3 = new ResidentVehicle("Tn123","Nila",45367281,300,true);
        Vehicle v4 = new VisitorVehicle("Tn879","Dharanie",12345667,100,"15");
        Vehicle v5 = new VisitorVehicle("Tn784","Simren",98765432,200,"12");
        Vehicle v6 = new VisitorVehicle("Tn908","Nila",45367281,300,"18");
        System.out.println(pm.addVehicle(v1));
        System.out.println(pm.addVehicle(v2));
        System.out.println(pm.addVehicle(v3));
        System.out.println(pm.addVehicle(v4));
        System.out.println(pm.addVehicle(v5));
        System.out.println(pm.addVehicle(v6));
        System.out.println(pm.setVisitorVehicleOutTime("Tn879","18"));
        System.out.println(pm.setVisitorVehicleOutTime("Tn908","19"));
        System.out.println(pm.getParkedResidentVehicleCount());
        System.out.println(pm.displayAllVehicles());
    }
}
