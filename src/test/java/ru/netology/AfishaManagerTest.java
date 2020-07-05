package ru.netology;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.manager.AfishaManager;

public class AfishaManagerTest {

    AfishaManager manager = new AfishaManager(10);

    @Test
    void shouldAdd() {
        Film first = new Film(1, "Bloodshot", "action");
        Film second = new Film(2, "Onward", "cartoon");
        Film third = new Film(3, "Hotel Beograd", "comedy");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        Film[] actual = manager.getLastAddedItems();
        Film[] expected = new Film[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAfishaEmpty() {

        Film[] actual = manager.getLastAddedItems();
        Film[] expected = new Film[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddMoreThanMax() {
        Film first = new Film(1, "Bloodshot", "action");
        Film second = new Film(2, "Onward", "cartoon");
        Film third = new Film(3, "Hotel Beograd", "comedy");
        Film fourth = new Film(4, "The Gentlemen", "action");
        Film fifth = new Film(5, "The Invisible Man", "horror");
        Film sixth = new Film(6, "Trolls World Tour", "cartoon");
        Film seventh = new Film(7, "Number One", "comedy");
        Film eighth = new Film(8, "Titanic", "drama");
        Film ninth = new Film(9, "The Terminator", "action");
        Film tenth = new Film(10, "Forrest Gump", "drama");
        Film eleventh = new Film(11, "The Lion King", "cartoon");
        Film twelfth = new Film(12, "Frozen", "cartoon");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

        Film[] actual = manager.getLastAddedItems();
        Film[] expected = new Film[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }
}