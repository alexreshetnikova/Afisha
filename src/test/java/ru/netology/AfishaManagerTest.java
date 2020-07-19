package ru.netology;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.manager.AfishaManager;

public class AfishaManagerTest {
    private AfishaManager manager = new AfishaManager(10);

    Film first = new Film(1, "Bloodshot", "action");
    Film second = new Film(2, "Onward", "cartoon");
    Film third = new Film(3, "Hotel Belgrad", "comedy");
    Film fourth = new Film(4, "The Gentlemen", "action");
    Film fifth = new Film(5, "The Invisible Man", "horror");
    Film sixth = new Film(6, "Trolls World Tour", "cartoon");
    Film seventh = new Film(7, "Number One", "comedy");
    Film eighth = new Film(8, "Titanic", "drama");
    Film ninth = new Film(9, "The Terminator", "action");
    Film tenth = new Film(10, "Forrest Gump", "drama");
    Film eleventh = new Film(11, "The Lion King", "cartoon");
    Film twelfth = new Film(12, "Frozen", "cartoon");

    @Test
    void shouldAdd() {

        manager.add(ninth);
        manager.add(second);
        manager.add(seventh);

        Film[] actual = manager.getLastAddedItems();
        Film[] expected = new Film[]{seventh, second, ninth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAfishaEmpty() {

        Film[] actual = manager.getLastAddedItems();
        Film[] expected = new Film[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddMoreThan10() {

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

    @Test
    void shouldShowLessThan10() {
        AfishaManager manager = new AfishaManager(5);

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

        Film[] actual = manager.getLastAddedItems();
        Film[] expected = new Film[]{tenth, ninth, eighth, seventh, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowMinus() {
        AfishaManager manager = new AfishaManager(-1);

        manager.add(first);
        manager.add(second);
        manager.add(third);

        Film[] actual = manager.getLastAddedItems();
        Film[] expected = new Film[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowMoreThan10() {
        AfishaManager manager = new AfishaManager(12);

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
        Film[] expected = new Film[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }
}