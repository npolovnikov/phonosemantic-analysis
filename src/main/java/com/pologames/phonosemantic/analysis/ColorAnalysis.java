package com.pologames.phonosemantic.analysis;

import com.pologames.phonosemantic.enums.Letter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ColorAnalysis {

    public static Map<Letter, Double> process(String text) {
        final Map<Letter, Integer> repeat = new ConcurrentHashMap<>();
        final AtomicInteger counter = new AtomicInteger(0);

        for (String word: text.split(" ")) {
            for (int i = 0; i< word.length(); i++) {
                char letter = word.charAt(i);
                if (Character.UnicodeBlock.of(letter).equals(Character.UnicodeBlock.CYRILLIC)) {
                    counter.incrementAndGet();
                    if (Letter.hasChar(letter)) {
                        Letter letter1 = Letter.getLetter(letter);
                        if (i == 0) {
                            repeat.merge(letter1, 4, Integer::sum);
                        } else if (!Character.isLowerCase(letter)) {
                            repeat.merge(letter1, 2, Integer::sum);
                        } else {
                            repeat.merge(letter1, 1, Integer::sum);
                        }
                    }
                }
            }
        }

        return repeat.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> round(e.getValue() / (double) counter.get() / e.getKey().getChastost(), 3) ));
    }

    private static double round(double value, int scale) {
        return Math.round(value * Math.pow(10, scale)) / Math.pow(10, scale);
    }
}
