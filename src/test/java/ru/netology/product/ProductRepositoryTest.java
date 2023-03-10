package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    ProductManager productManager = new ProductManager(repo);

    @Test
    void removeById() {
        Product book1 = new Book(1, "Little prince ums", 554, "Saint-Exupery");
        Product book2 = new Book(2, "Master and Margo ums", 495, "Bulgakov");
        Product book3 = new Book(3, "Litle prince ums", 554, "Saint-Exupery");
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);

        repo.removeById(1);
        Product[] expected = {book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void removeByIdNotExist() {
        Product book1 = new Book(1, "Little prince ums", 554, "Saint-Exupery");
        Product book2 = new Book(2, "Master and Margo ums", 495, "Bulgakov");
        productManager.add(book1);
        productManager.add(book2);

        Assertions.assertThrows(NotFoundException.class, () ->{
            repo.removeById(4);
        });
    }

    @Test
    void saveWithNewId() {
        Product book1 = new Book(1, "Little prince ums", 554, "Saint-Exupery");
        repo.save(book1);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void saveWithExistId() {
        Product book1 = new Book(1, "Little prince ums", 554, "Saint-Exupery");
        Product book2 = new Book(1, "Master and Margo ums", 495, "Bulgakov");
        repo.save(book1);

        Assertions.assertThrows(AlreadyExistsException.class, () ->{
            repo.save(book2);
        });
    }
}