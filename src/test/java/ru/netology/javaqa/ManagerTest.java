package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {

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
        repo.save(products4);

    }


    @Test
    public void shouldProductSearchByTitle() {
        Product[] expected = {products2};
        Product[] actual = (manager.searchBy("Смартфон"));
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAllProductSearchByTitle() {
        Product[] expected = {products1, products4};
        Product[] actual = (manager.searchBy("Книга"));
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchingTheProductToTheSearchQuery() {
        boolean expected = true;
        boolean actual = manager.matches(products2, "Смартфон");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noShouldMatchingTheProductToTheSearchQuery() {
        boolean expected = false;
        boolean actual = manager.matches(products2, "Хлеб");
        Assertions.assertEquals(expected, actual);
    }
}