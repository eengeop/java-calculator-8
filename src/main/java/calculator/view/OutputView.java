package calculator.view;

public class OutputView {

    public static final String RESULT_MESSAGE = "결과";

    public void showResult(int value){
        System.out.println(RESULT_MESSAGE + " : " + value);
    }
}
