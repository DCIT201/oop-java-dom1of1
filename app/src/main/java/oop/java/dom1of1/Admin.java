package oop.java.dom1of1;


import java.util.ArrayList;
import java.util.List;

public class Admin {
    private final List<Vehicle> vehicleFleet;
    private final String password;

    public Admin() {
        this.vehicleFleet = new ArrayList<>();
        this.password = "password";
        fillFleet();
    }

    private void fillFleet() {
        vehicleFleet.add(new Car("CAR1", "Bmw M5", 34.0));
        vehicleFleet.add(new Car("CAR2", "Mclaren F1", 87.0));
        vehicleFleet.add(new Car("CAR3", "Dodge Escapade", 23.0));
        vehicleFleet.add(new Car("CAR4", "Hyundai i10", 98.0));
        vehicleFleet.add(new Car("CAR5", "Ferrari f60", 25.0));

        vehicleFleet.add(new Motorcycle("MOTOR1", "BMW R 1250 GS", 15.0));
        vehicleFleet.add(new Motorcycle("MOTOR2", "KTM 390 Duke", 53.0));
        vehicleFleet.add(new Motorcycle("MOTOR3", "Royal Enfield Classic 350", 39.0));
        vehicleFleet.add(new Motorcycle("MOTOR4", "Honda Gold Wing", 92.0));
        vehicleFleet.add(new Motorcycle("MOTOR5", "Ducati Panigale V4", 17.0));

        vehicleFleet.add(new Truck("TRUCK1", "Nissan Frontier ", 18.0));
        vehicleFleet.add(new Truck("TRUCK2", "Jeep Gladiator", 46.0));
        vehicleFleet.add(new Truck("TRUCK3", "GMC Sierra 2500HD", 78.0));
        vehicleFleet.add(new Truck("TRUCK4", "Tesla Cybertruck", 99.0));
        vehicleFleet.add(new Truck("TRUCK5", "Toyota Tacoma", 12.0));
    }

    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleFleet.add(vehicle);
        System.out.println(vehicle.getClass().getSimpleName() + " added to the fleet.");
    }

    public void displayFleet() {
        if (vehicleFleet.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
        } else {
            System.out.println("Vehicle Fleet:");
            for (Vehicle vehicle : vehicleFleet) {
                System.out.println(String.format("%s - ID: %s, Model: %s", vehicle.getClass().getSimpleName(), vehicle.getVehicleId(), vehicle.getModel()));
            }
        }
    }

    public void displayAvailableVehicles() {
        boolean hasAvailableVehicles = false;
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.isAvailable()) {
                System.out.println(String.format("%s - ID: %s, Model: %s, Rate: $%.2f per day", vehicle.getClass().getSimpleName(), vehicle.getVehicleId(), vehicle.getModel(), vehicle.getBaseRentalRate()));
                hasAvailableVehicles = true;
            }
        }
        if (!hasAvailableVehicles) {
            System.out.println("No available vehicles.");
        }
    }

    public Vehicle getVehicleById(String vehicleId) {
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }
}

