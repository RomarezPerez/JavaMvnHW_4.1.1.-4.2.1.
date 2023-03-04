package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    Product prod1 = new Product(1, "Хлеб", 55);
    Book prod2 = new Book(2, "Книга", 550, "Курт Воннегут", "Колыбель для кошки");
    Smartphone prod3 = new Smartphone(3, "Смартфон", 5550, "Huawei", "X1");

    @Test
    public void shouldSetIdProduct() {
        prod1.setId(40);
        int expected = 40;
        int actual = prod1.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPriceProduct() {
        prod1.setPrice(630);
        int expected = 630;
        int actual = prod1.getPrice();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetTitleProduct() {
        prod1.setTitle("Молоко");
        String expected = "Молоко";
        String actual = prod1.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetProductAuthorBook() {
        prod2.setAuthor("Курт Воннегут");
        String expected = "Курт Воннегут";
        String actual = prod2.getAuthor();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetProductNameBook() {
        prod2.setName("Колыбель для кошки");
        String expected = "Колыбель для кошки";
        String actual = prod2.getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetProductManufacturerSmartphone() {
        prod3.setManufacturer("Siemens");
        String expected = "Siemens";
        String actual = prod3.getManufacturer();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetProductNameSmartphone() {
        prod3.setName("A335");
        String expected = "A335";
        String actual = prod3.getName();
        Assertions.assertEquals(expected, actual);
    }
}