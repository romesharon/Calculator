package Controller;

import Model.CalculatorModel;
import OperatorsPackage.Operators;
import View.CalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;
    private float operand1;
    private float operand2;
    private int currentParam;
    private Operators operator;
    private float outcome;
    private Boolean dotPressed;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        this.operand1 = 0;
        this.operand2 = 0;
        this.currentParam = 0;
        this.outcome = 0;
        this.dotPressed = false;
        this.view.addPressListener(new pressListener());
        this.view.addChangeParameterListener(new ChangeParameterListener());
        this.view.addEqualListener(new EqualListener());
        this.view.addDotListener(new DotListener());
    }

    private class pressListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JButton button = (JButton) actionEvent.getSource();
            float digit = Float.parseFloat(button.getText());
            if (currentParam == 0) {
                operand1 = operand1 * 10 + digit;
                view.printOutcome(operand1);
            } else if (currentParam == 1) {
                operand2 = operand2 * 10 + digit;
                view.printOutcome(operand2);
            }
        }
    }

    private class ChangeParameterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            currentParam = (currentParam + 1) % 2;
            JButton operatorButton = (JButton) actionEvent.getSource();
            String operatorName = operatorButton.getName().toUpperCase();
            operator =  Operators.valueOf(operatorName);
        }
    }

    private class EqualListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            outcome = model.calculate(operand1, operand2, operator);
            view.printOutcome(outcome);
            operand1 = outcome;
            operand2 = 0;
        }
    }

    private class DotListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            dotPressed = true;
        }
    }
}
