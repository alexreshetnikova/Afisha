package ru.netology.manager;

import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void add(Film item) {
        repository.save(item);
    }

    public Film[] getLastAddedItems(int itemsToShow) {
        int length = itemsToShow;
        Film[] items = repository.findAll();

        if (itemsToShow < 0) {
            length = 0;
        }
        if (length > items.length) {
            length = items.length;
        }

        Film[] result = new Film[length];

        for (int i = 0; i < length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}