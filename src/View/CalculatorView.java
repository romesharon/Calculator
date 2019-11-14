package View;

import OperatorsPackage.Operators;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorView extends JFrame {
    private JPanel panel = new JPanel();
    private JButton zero=new JButton("0");
    private JButton one=new JButton("1");
    private JButton two=new JButton("2");
    private JButton three=new JButton("3");
    private JButton four=new JButton("4");
    private JButton five=new JButton("5");
    private JButton six =new JButton("6");
    private JButton seven=new JButton("7");
    private JButton eight=new JButton("8");
    private JButton nine=new JButton("9");
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton mul = new JButton("*");
    private JButton div = new JButton("/");
    private JButton dot = new JButton(".");
    private JButton equal = new JButton("=");

    private JTextField text= new JTextField(3);

    public CalculatorView() {
        super("Calculator");
        panel.setLayout(new GridLayout(4,3));
        this.plus.setName(Operators.PLUS.name());
        this.minus.setName(Operators.MINUS.name());
        this.mul.setName(Operators.MUL.name());
        this.div.setName(Operators.DIV.name());
        this.dot.setName(Operators.DOT.name());
        this.equal.setName(Operators.EQUAL.name());
        this.text.setPreferredSize(new Dimension(200, 20));
        add(text);
        panel.add(zero);
        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);
        panel.add(plus);
        panel.add(minus);
        panel.add(mul);
        panel.add(div);
        panel.add(dot);
        panel.add(equal);
        add(panel,BorderLayout.SOUTH);
        setSize (200,300);
    }

    public void printOutcome(float outcome) {
        this.text.setText(String.valueOf(outcome));
    }

    public void addPressListener(ActionListener pressListener) {
        this.zero.addActionListener(pressListener);
        this.one.addActionListener(pressListener);
        this.two.addActionListener(pressListener);
        this.three.addActionListener(pressListener);
        this.four.addActionListener(pressListener);
        this.five.addActionListener(pressListener);
        this.six.addActionListener(pressListener);
        this.seven.addActionListener(pressListener);
        this.eight.addActionListener(pressListener);
        this.nine.addActionListener(pressListener);
    }

    public void addChangeParameterListener(ActionListener changeParameterListener) {
        this.plus.addActionListener(changeParameterListener);
        this.minus.addActionListener(changeParameterListener);
        this.mul.addActionListener(changeParameterListener);
        this.div.addActionListener(changeParameterListener);
        this.equal.addActionListener(changeParameterListener);
    }

    public void addEqualListener(ActionListener equalListener) {
        this.equal.addActionListener(equalListener);
    }

    public void addDotListener(ActionListener dotListener) {
        this.dot.addActionListener(dotListener);
    }
}