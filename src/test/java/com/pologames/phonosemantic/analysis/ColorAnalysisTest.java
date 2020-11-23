package com.pologames.phonosemantic.analysis;

import com.pologames.phonosemantic.enums.Letter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class ColorAnalysisTest {

    private static Stream<Arguments> provideAlphabet() {
        return Stream.of(
                Arguments.of("А", new HashMap<Letter, Double>(){{put(Letter.А, 42.105);}}),
                Arguments.of("ЗапАл", new HashMap<Letter, Double>(){{put(Letter.А, 6.316);}}),
                Arguments.of("ПрорЫв", new HashMap<Letter, Double>(){{put(Letter.О, 1.603); put(Letter.Ы, 20.833);}}),
                Arguments.of("ПрорЫв гОда", new HashMap<Letter, Double>(){{put(Letter.О, 2.885); put(Letter.Ы, 12.5); put(Letter.А, 1.053);}}),
                Arguments.of("ЗанимАлся организАцией рабОты комАнды разрабОтчиков", new HashMap<Letter, Double>(){{
                    put(Letter.О, 2.046);
                    put(Letter.Ы, 2.66);
                    put(Letter.А, 2.464);
                    put(Letter.И, 2.076);
                    put(Letter.Я, 0.887);
                    put(Letter.Й, 1.418);
                    put(Letter.Е, 0.426);
                }})
        );
    }

    @ParameterizedTest
    @MethodSource("provideAlphabet")
    void testProcess(String text, Map<Letter, Double> expected) throws Exception {
        Map<Letter, Double> result = ColorAnalysis.process(text);
        result.forEach((key, value) -> Assertions.assertEquals(expected.get(key), value, key + ""));
    }
}