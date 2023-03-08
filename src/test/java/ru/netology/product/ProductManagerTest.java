package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager productManager = new ProductManager(repo);
    Product book1 = new Book(1, "Little prince ums", 554, "Saint-Exupery");
    Product book2 = new Book(2, "Master and Margo ums", 495, "Bulgakov");
    Product book3 = new Book(3, "Litle prince ums", 554, "Saint-Exupery");
    Product smartphone1 = new Smartphone(4, "Sumsung", 25400, "Korea");
    Product smartphone2 = new Smartphone(5, "Sumsung", 25400, "USA");
    Product smartphone3 = new Smartphone(6, "Sumsang", 25400, "China");
    Product smartphone4 = new Smartphone(7, "Sumsang13", 25400, "China");

    @Test
    public void addProductBookWhenEmptyBasket() {
        productManager.add(book1);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addProductSmartphoneWhenEmptyBasket() {
        productManager.add(smartphone1);

        Product[] expected = {smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addProductWhenBasketWithProduct() {
        productManager.add(book1);
        productManager.add(smartphone1);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWithEmptyBasket() {
        Product[] expected = {};
        Product[] actual = productManager.searchBy("Lit");

        Assertions.assertArrayEquals(expected, actual);
    }

    //не работает
    @Test
    public void searchByNullCharacter() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);
        productManager.add(smartphone4);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3, smartphone4};
        Product[] actual = productManager.searchBy("");
        ;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySingleCharacter() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);
        productManager.add(smartphone4);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone3, smartphone4};
        Product[] actual = productManager.searchBy("a");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySingleWord() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);
        productManager.add(smartphone4);

        Product[] expected = {book1, book3};
        Product[] actual = productManager.searchBy("prince");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNumbers() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);
        productManager.add(smartphone4);

        Product[] expected = {smartphone4};
        Product[] actual = productManager.searchBy("1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySpace() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);
        productManager.add(smartphone4);

        Product[] expected = {book1, book2, book3};
        Product[] actual = productManager.searchBy(" ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhenNoMatch() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);
        productManager.add(smartphone4);

        Product[] expected = {};
        Product[] actual = productManager.searchBy("master");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhenOneMatch() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);
        productManager.add(smartphone4);

        Product[] expected = {book3};
        Product[] actual = productManager.searchBy("Litle");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhenAllMatches() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);
        productManager.add(smartphone4);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3, smartphone4};
        Product[] actual = productManager.searchBy("ums");

        Assertions.assertArrayEquals(expected, actual);
    }
}