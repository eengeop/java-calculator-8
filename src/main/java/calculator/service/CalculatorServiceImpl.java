package calculator.service;

import java.util.ArrayList;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {

    private static final String START_CUSTOM_DELIMITER = "//";
    private static final String END_CUSTOM_DELIMITER = "\\n";
    private static final String DEFAULT_DELIMITER = ",:";

    @Override
    public String findNumber(String userInput) {

        List<Character> allDelimiters = new ArrayList<>();
        String trimedString = deleteCustomDefine(userInput, allDelimiters);

        for (char delimiters : DEFAULT_DELIMITER.toCharArray()) {
            allDelimiters.add(delimiters);
        }

        String replacedString = replaceCustomToDefault(trimedString, allDelimiters);

        return replacedString;
    }
}