package ParkingSystem.Service;

import ParkingSystem.Exceptions.ParkingSlotNotAvailableException;
import ParkingSystem.Exceptions.VehicleNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingManagement {
    private List<Vehicle> allVehicles;
    private int slot =10,s=0;
    public ParkingManagement() {
        allVehicles = new ArrayList<Vehicle>();
    }
    public String addVehicle(Vehicle vehicle) throws ParkingSlotNotAvailableException {
        if(vehicle instanceof ResidentVehicle){
            allVehicles.add(vehicle);
            return "Vehicle parked at parking slot No :R"+(allVehicles.size()-s);
        }
        else if(slot == 0){
            throw new ParkingSlotNotAvailableException();
        }
        allVehicles.add(vehicle);
        slot--;
        s++;
        return "Vehicle parked at parking slot No :V"+allVehicles.size();
    }
    public String setVisitorVehicleOutTime(String regNumber, String outTime) throws VehicleNotFoundException {
      List<Vehicle> ve =  allVehicles.stream().filter(i->i instanceof VisitorVehicle)
                         .filter(j->j.getRegNumber().equalsIgnoreCase(regNumber)).
                          collect(Collectors.toList());
      if(ve.isEmpty())
          throw new VehicleNotFoundException();
        ((VisitorVehicle)ve.get(0)).setOutTime(outTime);
        slot++;
      return "Vehicle with RegNo: "+regNumber+" updated successfully";
    }
    public int getParkedResidentVehicleCount()
    {
     return (int) allVehicles.stream().filter(i->i instanceof ResidentVehicle)
                .filter(j->((ResidentVehicle) j).isParkingStatus()).count();
    }

    public  boolean setParkingStatus(String regNumber,boolean flag){
        List<Vehicle> l= allVehicles.stream()
                                    .filter(i->i.getRegNumber().equalsIgnoreCase(regNumber))
                                    .limit(1).collect(Collectors.toList());
        if(l.isEmpty())return false;
        ((ResidentVehicle)l.get(0)).setParkingStatus(flag);
        return true;
    }

    public int getParkedVisitorVehicleCount()
    {
        return (int) allVehicles.stream().filter(i->i instanceof ResidentVehicle)
                .filter(j-> ((ResidentVehicle)j).getRegNumber() != null).count();
    }

    public String displayAllVehicles()
    {
        String s = "Resident Vehicle\n\n";
        int j = 1;
        for(Vehicle i: allVehicles)
            if(i instanceof ResidentVehicle) {
                s += j+".   ";
                s += i;
                j++;
            }
        j = 1;
        s += "\n\nVisitor Vehicle\n\n";
        for(Vehicle i: allVehicles)
            if(i instanceof VisitorVehicle){
                s += j+".   ";
                s += i;
                j++;
            }


            return s;
    }
}
