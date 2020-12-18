package ParkingSystem.Service;

public class VisitorVehicle extends Vehicle{
    private int visitingFlatNumber;
    private String inTime;
    private String outTime;

    public VisitorVehicle(String regNumber, String ownerName, long mobileNo, int visitingFlatNumber, String inTime) {
        super(regNumber, ownerName, mobileNo);
        this.visitingFlatNumber = visitingFlatNumber;
        this.inTime = inTime;
        this.outTime = null;
    }

    public int getVisitingFlatNumber() {
        return visitingFlatNumber;
    }

    public void setVisitingFlatNumber(int visitingFlatNumber) {
        this.visitingFlatNumber = visitingFlatNumber;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "visitingFlatNumber= " + visitingFlatNumber +"  "+
                ", inTime= " + inTime + "   "+
                ", outTime= " + outTime+"\n" ;
    }
}
