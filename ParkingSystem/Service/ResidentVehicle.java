package ParkingSystem.Service;

public class ResidentVehicle extends Vehicle{
    private int flatNo;
    private boolean parkingStatus;

    public ResidentVehicle(String regNumber, String ownerName, long mobileNo, int flatNo, boolean parkingStatus) {
        super(regNumber, ownerName, mobileNo);
        this.flatNo = flatNo;
        this.parkingStatus = parkingStatus;
    }

    public int getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(int flatNo) {
        this.flatNo = flatNo;
    }

    public boolean isParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(boolean parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    @Override
    public String toString() {
        return   super.toString()+
                "flatNo= " + flatNo +"   "+
                ", parkingStatus= " + parkingStatus+"\n";
    }
}
