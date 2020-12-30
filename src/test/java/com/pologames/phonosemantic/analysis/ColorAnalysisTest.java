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
                Arguments.of("А", new HashMap<Letter, Double>(){{put(Letter.RED, 34.188);}}),
                Arguments.of("ЗапАл", new HashMap<Letter, Double>(){{put(Letter.RED, 5.128);}}),
                Arguments.of("ПрорЫв", new HashMap<Letter, Double>(){{put(Letter.YELLOW, 1.529); put(Letter.BROWN, 18.519);}}),
                Arguments.of("ПрорЫв гОда", new HashMap<Letter, Double>(){{put(Letter.YELLOW, 2.752); put(Letter.BROWN, 11.111); put(Letter.RED, 0.855);}}),
                Arguments.of("ЗанимАлся организАцией рабОты комАнды разрабОтчиков", new HashMap<Letter, Double>(){{
                    put(Letter.YELLOW, 1.952);
                    put(Letter.BROWN, 2.364);
                    put(Letter.RED, 2.182);
                    put(Letter.BLUE, 1.52);
                    put(Letter.GREEN, 0.25);
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