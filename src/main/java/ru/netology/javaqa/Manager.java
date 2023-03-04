package ru.netology.javaqa;

public class Manager {

    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        if (repo.findById(product.id) == null) {
            repo.save(product);
        } else {
            throw new AlreadyExistsException("Element with id: " + product.getId() + " already added");
        }
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product prod : repo.findAll()) {
            if (matches(prod, text)) {
                Product[] search = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    search[i] = result[i];
                }
                search[search.length - 1] = prod;
                result = search;
            }
        }
        return result;
    }

    public boolean matches(Product product, String text) {
        if (product.getTitle().contains(text)) {
            return true;
        } else {
            return false;
        }
    }
}