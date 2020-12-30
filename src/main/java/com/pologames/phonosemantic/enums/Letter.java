package com.pologames.phonosemantic.enums;

import java.util.stream.Stream;

/**
 * Created by npolovnikov on 26.04.17.
 */
public enum Letter {
    GREEN("Зеленый", "эе", 0.085),
    YELLOW("Желтый", "оё", 0.109),
    BROWN("Темно-коричневый", "ы", 0.018),
    LIGHT_BLUE("Голубой", "ую", 0.035),
    BLUE("Синий", "и", 0.056),
    RED("Красный", "ая", 0.117);

    private String color;
    private String word;
    private double frequency;
    Letter(String color, String word, double frequency){
        this.color = color;
        this.word = word;
        this.frequency = frequency;
    }

    public String getColor() {
        return color;
    }

    public String getWord() {
        return word;
    }

    public double getFrequency() {
        return frequency;
    }

    public static boolean hasChar(int c) {
        return Stream.of(values())
                .anyMatch(v -> v.getWord().indexOf(Character.toLowerCase(c)) >= 0);
    }

    public static Letter getLetter(int c) {
        return Stream.of(values())
                .filter(v -> v.getWord().indexOf(Character.toLowerCase(c)) >= 0)
                .findAny().orElseThrow(RuntimeException::new);
    }
}
