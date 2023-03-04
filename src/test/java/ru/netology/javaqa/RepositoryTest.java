package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Product products1 = new Book(1, "Книга", 550, "Курт Воннегут", "Колыбель для кошки");
    Product products2 = new Smartphone(2, "Смартфон", 5550, "Huawei", "X1");
    Product products3 = new Product(3, "Хлеб", 55);
    Product products4 = new Book(4, "Книга", 498, "Федор Достоевский", "Преступление и наказание");

    @BeforeEach
    public void save() {
        repo.save(products1);
        repo.save(products2);
        repo.save(products3);

    }

    @Test
    public void shouldRemoveProductById() {
        repo.removeById(1);
        Product[] expected = {products2, products3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNonExistentProductById() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(45);
        });
    }
    @Test
    public void shouldAddNewProductInRepo() {
        manager.add(products4);
        Product[] expected = {products1, products2, products3, products4};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThereIsNoProductWithTheSameId() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            manager.add(products3);
        });
    }
}