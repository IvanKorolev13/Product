package ru.netology.product;

public class ProductRepository {
    private Product[] product = new Product[0];

    public void save(Product newProduct) {
        Product[] tmp = new Product[product.length + 1];
        for (int i = 0; i < product.length; i++) {
            tmp[i] = product[i];
        }
        tmp[tmp.length - 1] = newProduct;
        product = tmp;
    }

    public Product[] findAll() {
        return product;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[product.length - 1];
        int copyToIndex = 0;
        for (int i = 0; i < product.length; i++) {
            if (product[i].getId() != id) {
                tmp[copyToIndex] = product[i];
                copyToIndex++;
            }
        }
        //if (copyToIndex != product.length) {
        product = tmp;
        //}
    }

    public Product[] saveResult(Product[] result, Product newProduct) {
        Product[] tmp = new Product[result.length + 1];
        for (int i = 0; i < result.length; i++) {
            tmp[i] = result[i];
        }
        tmp[tmp.length - 1] = newProduct;
        return tmp;
    }
}
