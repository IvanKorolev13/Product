package ru.netology.product;

public class Book extends Product {
    private String author;

    @Override
    public boolean matches(String search) {
        if (!super.matches(search)) {
            if (getAuthor().contains(search)) {
                return true;
            } else {
                return false;
            }
        } else {
            return super.matches(search);
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }
}
