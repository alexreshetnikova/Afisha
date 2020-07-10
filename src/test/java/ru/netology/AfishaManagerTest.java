package ru.netology;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.netology.domain.Film;
import ru.netology.manager.AfishaManager;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.manager.AfishaRepository;

@ExtendWith(MockitoExtension.class)


public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;

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

        manager.add(first);
        manager.add(second);
        manager.add(third);

        Film[] returned = new Film[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(fourth);

        manager.add(fourth);
        Film[] actual = manager.getLastAddedItems();
        Film[] expected = new Film[]{third, second, first};

        assertArrayEquals(expected, actual);
        verify(repository).save(fourth);
    }

    @Test
    void getAfishaEmpty() {

        Film[] returned = new Film[]{};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(first);

        manager.add(first);
        Film[] actual = manager.getLastAddedItems();
        Film[] expected = new Film[]{};

        assertArrayEquals(expected, actual);
        verify(repository, times(1)).save(first);
    }

    @Test
    void shouldAddMoreThanMax() {

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

        Film[] returned = new Film[]
                {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(twelfth);

        manager.add(twelfth);
        Film[] actual = manager.getLastAddedItems();
        Film[] expected = new Film[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
        verify(repository, times(1)).save(twelfth);
    }
}