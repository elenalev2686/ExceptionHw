package ru.netology.exeption;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldRemove() {
        ShopRepository repo = new ShopRepository();
        Product productOne = new Product(5, "тетрадь", 26);
        Product productTwo = new Product(13, "компьютер", 50000);
        Product productThree = new Product(201, "чайник", 2000);
        repo.add(productOne);
        repo.add(productTwo);
        repo.add(productThree);
        repo.remove(13);
        Product[] actual = repo.findAll();
        Product[] expected = {productOne, productThree};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotRemove() {
        ShopRepository repo = new ShopRepository();
        Product productOne = new Product(5, "тетрадь", 26);
        Product productTwo = new Product(13, "компьютер", 50000);
        Product productThree = new Product(201, "чайник", 2000);

        repo.add(productOne);
        repo.add(productTwo);
        repo.add(productThree);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(555)
        );
    }
}
