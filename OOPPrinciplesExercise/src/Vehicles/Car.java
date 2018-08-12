package Vehicles;

public class Car extends Vehicle{

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    public void drive(double kms){
        if(getFuelQuantity() - kms * (getFuelConsumption() + 0.9) >= 0){
            setFuelQuantity(getFuelQuantity() - kms * (getFuelConsumption() + 0.9));
            System.out.println("Car travelled " + kms + " km");
        }
        else{
            System.out.println("Car needs refueling!");
        }
    }

    public void refuel(double lts){
        setFuelQuantity(getFuelQuantity() + lts);
    }
}
