package com.pologames.phonosemantic.analysis;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by npolovnikov on 26.04.17.
 */
public class Main {
    public static String RUS_LANG = "ёйцукенгшщзхъфывапролджэячсмитьбю";

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(new FileInputStream(args[1]));

        int wordCount = 0;
        final Map<Enum, Integer> repeat = new HashMap<>();

        while (sc.hasNextLine()){
            final String line = sc.nextLine();
            for (char c: line.toCharArray()){
                if (RUS_LANG.indexOf(c) >= 0){
                    wordCount++;
                    if (Enum.hasChar(c)){
                        Enum c1 = Enum.valueOf(String.valueOf(Character.toUpperCase(c)));
                        final Integer count = repeat.get(c1);
                        if (count == null){
                            repeat.put(c1, 1);
                        }else {
                            repeat.put(c1, count + 1);
                        }
                    }
                }
            }
        }
        final Map<Enum, Double> percent = new HashMap<>();
        for (Map.Entry<Enum, Integer> entry: repeat.entrySet()){
            final double ch =  entry.getValue() / (double) wordCount - entry.getKey().getChastost();
            percent.put(entry.getKey(), round(ch, 3));
        }

        System.out.println(percent);
    }

    public static double round(double value, int scale) {
        return Math.round(value * Math.pow(10, scale)) / Math.pow(10, scale);
    }
}
