package com.pologames.phonosemantic.analysis;

/**
 * Created by npolovnikov on 26.04.17.
 */
public enum Enum {
    А("Густо-красный", 'а', 80/1000F),
    Я("Ярко-красный", 'я', 20/1000F),
    О("Светло-желтый, белый", 'о', 109/1000F),
    Е("Зеленый", 'е', 85/1000F),
    Ё("Желто-зеленый", 'ё', 1/10000F),
    И("Синий", 'и', 74/1000F),
    Й("Синеватый", 'й', 12/1000F),
    У("Темно-синий, темно-сине-зеленый, темно-лиловый", 'у', 26/1000F),
    Ю("Голубоватый", 'ю', 6/1000F),
    Ы("Темно-коричневый, черный", 'ы', 19/1000F);

    private String color;
    private  char word;
    private double chastost;
    Enum(String color, char word, double chastost){
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

    public static boolean hasChar(char c){
        for (Enum e: Enum.values()){
            if (Character.toLowerCase(c) == e.getWord()){
                return true;
            }
        }
        return false;
    }
}
