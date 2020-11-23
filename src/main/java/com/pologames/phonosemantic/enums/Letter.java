package com.pologames.phonosemantic.enums;

import java.util.stream.Stream;

/**
 * Created by npolovnikov on 26.04.17.
 */
public enum Letter {
    А("Густо-красный", 'а', 0.049 + 0.046),
    Я("Ярко-красный", 'я', 0.013 + 0.011),
    О("Светло-желтый, белый", 'о', 0.067 + 0.037),
    Е("Зеленый", 'е', 0.050),
    Ё("Желто-зеленый", 'ё', 0.039),
    И("Синий", 'и', 0.041),
    Й("Синеватый", 'й', 0.015),
    У("Темно-синий, темно-сине-зеленый, темно-лиловый", 'у', 0.017+0.012),
    Ю("Голубоватый", 'ю', 0.004+0.002),
    Ы("Темно-коричневый, черный", 'ы', 0.010 + 0.006);

    private String color;
    private char word;
    private double chastost;
    Letter(String color, char word, double chastost){
        this.color = color;
        this.word = word;
        this.chastost = chastost;
    }

    public String getColor() {
        return color;
    }

    public char getWord() {
        return word;
    }

    public double getChastost() {
        return chastost;
    }

    public static boolean hasChar(int c) {
        return Stream.of(values())
                .anyMatch(v -> Character.toLowerCase(c) == v.getWord());
    }

    public static Letter getLetter(int c) {
        return Stream.of(values())
                .filter(v -> Character.toLowerCase(c) == v.getWord())
                .findAny().orElseThrow(RuntimeException::new);
    }
}
