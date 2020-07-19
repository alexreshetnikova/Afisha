package ru.netology;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.netology.domain.Film;
import ru.netology.manager.AfishaManager;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.repository.AfishaRepository;

@ExtendWith(MockitoExtension.class)


public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;

    private  Film first = new Film(1, "Bloodshot", "action");
    private Film second = new Film(2, "Onward", "cartoon");
    private Film third = new Film(3, "Hotel Belgrad", "comedy");
    private Film fourth = new Film(4, "The Gentlemen", "action");
    private Film fifth = new Film(5, "The Invisible Man", "horror");
    private Film sixth = new Film(6, "Trolls World Tour", "cartoon");
    private Film seventh = new Film(7, "Number One", "comedy");
    private Film eighth = new Film(8, "Titanic", "drama");
    private Film ninth = new Film(9, "The Terminator", "action");
    private Film tenth = new Film(10, "Forrest Gump", "drama");
    private Film eleventh = new Film(11, "The Lion King", "cartoon");
    private Film twelfth = new Film(12, "Frozen", "cartoon");


    @Test
    void shouldAdd() {

        Film[] returned = new Film[]{first, second, third};
        doReturn(returned).when(repository).findAll();

        Film[] actual = manager.getLastAddedItems(10);
        Film[] expected = new Film[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAfishaEmpty() {

        Film[] returned = new Film[]{};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(first);

        manager.add(first);
        Film[] actual = manager.getLastAddedItems(10);
        Film[] expected = new Film[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddMoreThan10() {

        Film[] returned = new Film[]
                {first, second, third, fourth, fifth, sixth, seventh, eighth,
                        ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();

        Film[] actual = manager.getLastAddedItems(10);
        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth,
                fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowLessThan10() {

        Film[] returned = new Film[]
                {first, second, third, fourth, fifth, sixth, seventh};
        doReturn(returned).when(repository).findAll();

        Film[] actual = manager.getLastAddedItems(5);
        Film[] expected = new Film[]{seventh, sixth, fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowMinus() {

        Film[] returned = new Film[]
                {first, second, third};
        doReturn(returned).when(repository).findAll();

        Film[] actual = manager.getLastAddedItems(-1);
        Film[] expected = new Film[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowMoreThan10() {

        Film[] returned = new Film[]
                {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth,
                        eleventh, twelfth};
        doReturn(returned).when(repository).findAll();

        Film[] actual = manager.getLastAddedItems(12);
        Film[] expected = new Film[]{twelfth, eleventh, tenth, ninth, eighth, seventh,
                sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }
}