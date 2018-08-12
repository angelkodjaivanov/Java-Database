package Vehicles;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    public void drive(double kms){
        if(getFuelQuantity() - kms * (getFuelConsumption() + 1.6) >= 0){
            setFuelQuantity(getFuelQuantity() - kms * (getFuelConsumption() + 1.6));
            System.out.println("Truck travelled " + kms + " km");
        }
        else{
            System.out.println("Truck needs refueling!");
        }
    }

    public void refuel(double lts){
        setFuelQuantity(getFuelQuantity() + (lts * 0.95));
    }
}
