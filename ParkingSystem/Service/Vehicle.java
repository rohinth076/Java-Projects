package ParkingSystem.Service;

public class Vehicle {
    private String regNumber;
    private String ownerName;
    private long mobileNo;

    public Vehicle(String regNumber, String ownerName, long mobileNo) {
        this.regNumber = regNumber;
        this.ownerName = ownerName;
        this.mobileNo = mobileNo;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return   "regNumber= " + regNumber + "   "+
                 ", ownerName= " + ownerName + "   " +
                 ", mobileNo=" + mobileNo+ "   ";
    }
}
