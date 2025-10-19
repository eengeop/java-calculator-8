package calculator.controller;

import calculator.model.Calculator;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
   private InputView inputView = new InputView();
   private CalculatorService calculatorService = new CalculatorServiceImpl();
   private Calculator calculator = new Calculator();
   private OutputView outputView = new OutputView();

   public void run(){
      String userInput = inputView.getUserInput();
      String trimedNumber = calculatorService.findNumber(userInput);
      int result = calculator.sumNumber(trimedNumber);
      outputView.showResult(result);
   }
}
