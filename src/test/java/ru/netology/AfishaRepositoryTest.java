package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    Film first = new Film(1, "Bloodshot", "action");
    Film second = new Film(2, "Onward", "cartoon");
    Film third = new Film(3, "Hotel Belgrad", "comedy");
    Film fourth = new Film(4, "The Gentlemen", "action");
    Film fifth = new Film(5, "The Invisible Man", "horror");
    Film sixth = new Film(6, "Trolls World Tour", "cartoon");

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
    }

    @Test
    void shouldFindAll() {
        assertArrayEquals(new Film[]{first, second, third, fourth, fifth, sixth}, repository.findAll());
    }

    @Test
    void shouldFindById() {
        assertEquals(second, repository.findById(2));
        assertEquals(third, repository.findById(3));
        assertEquals(null, repository.findById(7));
    }

    @Test
    void shouldSave() {
        Film seventh = new Film(7, "Number One", "comedy");
        repository.save(seventh);
        assertArrayEquals(new Film[]{first, second, third, fourth, fifth, sixth, seventh}, repository.findAll());
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 3;
        repository.removeById(idToRemove);

        assertArrayEquals(new Film[]{first, second, fourth, fifth, sixth}, repository.findAll());
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        assertArrayEquals(new Film[]{}, repository.findAll());
    }
}
