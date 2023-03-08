package ru.netology.product;

public class Smartphone extends Product {
    private String manufacturer;

    @Override
    public boolean matches(String search) {
        if (!super.matches(search)) {
            if (getManufacturer().contains(search)) {
                return true;
            } else {
                return false;
            }
        } else {
            return super.matches(search);
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

}
