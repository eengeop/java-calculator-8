package calculator.model;

public class Calculator {

    private int result;

    public int sumNumber(String numbers){
        if(numbers == null || numbers.isEmpty()){
            return 0;
        }

        result = 0;
        String[] arr = numbers.split(",");

        for(String num : arr){
            validateNumber(num);
            result+=Integer.parseInt(num);
        }
        return result;
    }

    private void validateNumber(String inputNumber){
        try {
            int temp = Integer.parseInt(inputNumber);
            if (temp <= 0) {
                throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
            }
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
