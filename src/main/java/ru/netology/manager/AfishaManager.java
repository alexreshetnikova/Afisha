package ru.netology.manager;

import ru.netology.domain.Film;

public class AfishaManager {
    private Film[] items = new Film[0];
    private int itemsToShow;

    public AfishaManager(int itemsToShow) {
        this.itemsToShow = itemsToShow;
    }

    public void add(Film item) {
        int length = items.length + 1;
        Film[] tmp = new Film[length];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Film[] getLastAddedItems() {
        int length = itemsToShow;
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