package ru.netology.manager;

import ru.netology.domain.Film;

public class AfishaRepository {
    private Film[] items = new Film[0];

    public Film[] findAll () {
        return items;
    }

    public void save (Film item) {
        int length = items.length + 1;
        Film[] tmp = new Film[length];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Film findById(int id) {
        for (Film item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public boolean removeById(int id) {
        int length = items.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        boolean founded = false;
        for (Film item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            } else {
                founded = true;
            }
        }
        items = tmp;
        return founded;
    }

    public void removeAll() {
        items = new Film[0];
    }
}
