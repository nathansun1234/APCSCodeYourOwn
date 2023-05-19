public class Car {
    private String model;
    private int mileage;
    private int gas;
    private int capacity;

    public Car(int id) {
        gas = 15;
        if (id == 0) {
            model = "Lamborghini Aventador";
            mileage = 15;
            capacity = 100;
        }
        else if (id == 1) {
            model = "Ford F150";
            mileage = 20;
            capacity = 500;
        }
        else if (id == 2) {
            model = "Honda Civic";
            mileage = 40;
            capacity = 300;
        }
    }

    public String getModel() {
        return model;
    }
    public int getMileage() {
        return mileage;
    }
    public int getFoodCapacity() {
        return capacity;
    }
    public int getGas() {
        return gas;
    }

    public void setGas(int n) {
        gas = n;
    }
    public void decreaseGas(int n) {
        gas -= n;
    }
    public void increaseGas(int n) {
        gas += n;
    }
}
