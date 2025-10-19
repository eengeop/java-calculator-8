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

    private String deleteCustomDefine(String userInput, List<Character> allDelimiters) {
        StringBuilder sb = new StringBuilder(userInput);
        int searchIndex = 0;

        while (sb.indexOf(START_CUSTOM_DELIMITER) != -1) {
            int startIndex = sb.indexOf(START_CUSTOM_DELIMITER, searchIndex);
            int endIndex = sb.indexOf(END_CUSTOM_DELIMITER, startIndex);

            if (endIndex - startIndex != 3) {
                System.out.println(endIndex - startIndex);
                throw new IllegalArgumentException("구분자는 단일문자만 가능합니다.");
            }

            int customDelimiterIndex = sb.indexOf(START_CUSTOM_DELIMITER) + 2;
            char customDelimiter = sb.charAt(customDelimiterIndex);

            if(Character.getNumericValue(customDelimiter) != -1){
                throw new IllegalArgumentException("숫자는 커스텀 구분자가 될 수 없습니다.");
            }

            allDelimiters.add(customDelimiter);
            sb.delete(startIndex, endIndex + 2);
            searchIndex = startIndex;
        }
        return sb.toString();
    }

    private String replaceCustomToDefault(String trimedString, List<Character> allDelimiters) {
        StringBuilder sb = new StringBuilder(trimedString);

        for (int i = 0; i < trimedString.length(); i++) {
            if (allDelimiters.contains(sb.charAt(i))) {
                sb.replace(i, i + 1, ",");
            }
        }
        return sb.toString();
    }
}