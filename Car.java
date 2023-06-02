public class Car {
    private String model;
    private int mileage; //must be factor of 100
    private int gas; //max of 20
    private int capacity; //days of food it can carry
    private int food; //max of capacity

    public Car(int id) {
        gas = 20;
        if (id == 0) {
            model = "Lamborghini Aventador";
            mileage = 10;
            capacity = 2;
        }
        else if (id == 1) {
            model = "Ford F150";
            mileage = 20;
            capacity = 10;
        }
        else if (id == 2) {
            model = "Honda Civic";
            mileage = 25;
            capacity = 5;
        }
        food = capacity;
    }

    public String getModel() {
        return model;
    }
    public int getMileage() {
        return mileage;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getGas() {
        return gas;
    }
    public int getFood() {
        return food;
    }

    public void setGas(int n) {
        gas = n;
    }
    public void incrementGas(int n) {
        gas += n;
    }
    public void setFood(int n) {
        food = n;
    }
    public void incrementFood(int n) {
        food += n;
    }
}
