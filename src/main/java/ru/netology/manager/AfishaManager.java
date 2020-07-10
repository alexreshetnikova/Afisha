package ru.netology.manager;

import ru.netology.domain.Film;

public class AfishaManager {
    private AfishaRepository repository;
    private int itemsToShow;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
        this.itemsToShow = 10;
    }

    public void add(Film item) {
        repository.save(item);
    }

    public Film[] getLastAddedItems() {
        int length = itemsToShow;
        Film[] items = repository.findAll();
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