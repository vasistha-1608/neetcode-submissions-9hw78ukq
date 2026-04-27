interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    // Write your code here
    private Car car;
    Vehicle createVehicle(){
        car = new Car();
        return car;
    }
}

class BikeFactory extends VehicleFactory {
    // Write your code here
     private Bike bike;
    Vehicle createVehicle(){
        bike = new Bike();
        return bike;
    }
}

class TruckFactory extends VehicleFactory {
    // Write your code here
     private Truck truck;
    Vehicle createVehicle(){
        truck = new Truck();
        return truck;
    }
}
