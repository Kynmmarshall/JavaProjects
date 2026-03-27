public class house {

    public String address;
    public int numberOfRooms;
    public double price;
    private boolean hasElectricity;
    private boolean hasWater;
    private boolean isOccupied;

    // Constructor
    public house(String address, int numberOfRooms, double price) {
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.hasElectricity = false;
        this.hasWater = false;
        this.isOccupied = false;
    }

    // Getters

    public boolean hasElectricity() {
        return hasElectricity;
    }

    public boolean hasWater() {
        return hasWater;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    // Methods
    public void supplyElectricity() {
        if (!hasElectricity) {
            hasElectricity = true;
            System.out.println("Electricity supplied.");
        } else {
            System.out.println("Electricity already available.");
        }
    }

    public void supplyWater() {
        if (!hasWater) {
            hasWater = true;
            System.out.println("Water supplied.");
        } else {
            System.out.println("Water already available.");
        }
    }

    public void occupy() {
        if (!isOccupied) {
            isOccupied = true;
            System.out.println("House is now occupied.");
        } else {
            System.out.println("House is already occupied.");
        }
    }

    public void vacate() {
        if (isOccupied) {
            isOccupied = false;
            System.out.println("House is now vacant.");
        } else {
            System.out.println("House is already vacant.");
        }
    }

    public void displayInfo() {
        System.out.println("Address: " + address);
        System.out.println("Rooms: " + numberOfRooms);
        System.out.println("Price: $" + price);
        System.out.println("Electricity: " + (hasElectricity ? "Yes" : "No"));
        System.out.println("Water: " + (hasWater ? "Yes" : "No"));
        System.out.println("Occupied: " + (isOccupied ? "Yes" : "No"));
    }
}