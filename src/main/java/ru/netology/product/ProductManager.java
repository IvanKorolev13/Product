package ru.netology.product;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (product.matches(text)) {
                result = repo.saveResult(result, product);
            }
        }
        return result;
    }

//    public boolean matches(Product product, String search) {
//
//        if (product.getName().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }

//        или в одну строку
//        return product.getName().contains(search);
//    }

}
