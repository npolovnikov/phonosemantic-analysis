package com.pologames.phonosemantic;

import com.pologames.phonosemantic.analysis.ColorAnalysis;
import com.pologames.phonosemantic.enums.Letter;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by npolovnikov on 26.04.17.
 */
public class Main {

    public static void main(String... args) throws Exception {
        try(final Scanner sc = new Scanner(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("test.txt")))){
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                final String line = sc.nextLine();
                sb.append(line).append(' ');
            }

            final Map<Letter, Double> percent = ColorAnalysis.process(sb.toString());
            percent.entrySet()
                    .stream()
                    .filter(e -> e.getValue() >= 1.5)
                    .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                    .forEach((e) -> System.out.printf("%s %s: %s\n", e.getKey().getWord(), e.getKey().getColor(), e.getValue()));
        }
    }
}
