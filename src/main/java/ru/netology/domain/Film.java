package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Film {
    private int id;
    private String filmName;
    private String filmGenre;
}
