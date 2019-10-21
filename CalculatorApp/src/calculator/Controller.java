package calculator;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;

import java.awt.*;

public class Controller {

    @FXML TextField window;
    @FXML Button AC;

    Boolean reset = false;

    double num1 = Double.NaN;
    double num2 = Double.NaN;
    double num3 = Double.NaN;
    double ans = Double.NaN;
    char operator = '\0';
    char lastOperator = '\0';
    boolean numLastClicked;
    boolean equalsClicked;
    boolean operatorLastClicked;
    boolean percentClicked;
    String curr;

    /*
        operator and non number handlers
     */


    public void handleClear(ActionEvent actionEvent) {
        num1 = Double.NaN;
        num2 = Double.NaN;
        num3 = Double.NaN;
        operator = '\0';
        ans = Double.NaN;
        window.setText("0");
        checkSize();
        setSize();
        reset = false;
        numLastClicked = false;
        equalsClicked = false;
        operatorLastClicked = false;
    }

    public void handlePercent(ActionEvent actionEvent) {
        String curr = window.getText();
        if(curr.equals("0")){return;}
        double num = Double.parseDouble(curr);
        curr = Double.toString(num/100);
        window.setText(curr);
        checkSize();
        setSize();
        reset = true;
        percentClicked = true;
    }

    public void handlePlusMinus(ActionEvent actionEvent) {
        String curr = window.getText();
        if(curr.contains("-")){
            int i = curr.indexOf("-");
            curr = curr.substring(i+1);
        }else {
            curr = "-" + curr;
        }
        window.setText(curr);
        checkSize();
        setSize();
    }

    public void handleDivision(ActionEvent actionEvent) {
        numClicked('/');
    }

    public void handleMultiply(ActionEvent actionEvent) {
        numClicked('x');
    }

    public void handlePlus(ActionEvent actionEvent) {
        numClicked('+');
    }
    public void handleMinus(ActionEvent actionEvent) {
        numClicked('-');
    }



    public void handleEquals(ActionEvent actionEvent) {
        if(equalsClicked && !(Double.isNaN(num1)) && !(Double.isNaN(num2))){
            this.operator = this.lastOperator;
            if(!(Double.isNaN(num3))) {
                setAnswer(ans, num3);
            }else{
                setAnswer(ans, num2);
            }
            window.setText(Double.toString(ans));
            checkSize();
            setSize();
            return;
        }
        if(Double.isNaN(num1) && Double.isNaN(num2)){
            window.setText(Double.toString(Double.parseDouble(window.getText())));
        }else if(Double.isNaN(num2)){
            num2 = Double.parseDouble(window.getText());
            setAnswer(num1, num2);
            reset = true;
            window.setText(Double.toString(ans));
            //ans = Double.NaN;
        }else{
            setAnswer(num2, Double.parseDouble(window.getText()));
            window.setText(Double.toString(ans));

            reset = true;
        }
        checkSize();
        setSize();
        operator = '=';
        operatorLastClicked = false;
        numLastClicked = false;
        equalsClicked = true;

    }

    public void handleDot(ActionEvent actionEvent) {
        String curr = window.getText();
        checkReset();
        if(numLastClicked) {
            if (curr.contains(".")) {
                return;
            } else {
                curr += ".";
                window.setText(curr);
            }
        }else if(equalsClicked || operatorLastClicked){
            curr = "0.";
            window.setText(curr);
        }
        checkPercent();
        checkSize();
        setSize();
        equalsClicked = false;
        operatorLastClicked = false;
        numLastClicked = true;
    }

    /*
        Number handlers
     */

    public void handleZero(ActionEvent actionEvent) {
        checkReset();
        setNumber("0");
        checkPercent();
        checkSize();
        setSize();
        setNumConditions();
    }

    public void handleOne(ActionEvent actionEvent) {
        checkReset();
        setNumber("1");
        checkPercent();
        checkSize();
        setSize();
        setNumConditions();
    }

    public void handleTwo(ActionEvent actionEvent) {
        checkReset();
        setNumber("2");
        checkPercent();
        checkSize();
        setSize();
        setNumConditions();
    }

    public void handleThree(ActionEvent actionEvent) {
        checkReset();
        setNumber("3");
        checkPercent();
        checkSize();
        setSize();
        setNumConditions();
    }

    public void handleFour(ActionEvent actionEvent) {
        checkReset();
        setNumber("4");
        checkPercent();
        checkSize();
        setSize();
        setNumConditions();
    }

    public void handleFive(ActionEvent actionEvent) {
        checkReset();
        setNumber("5");
        checkPercent();
        checkSize();
        setSize();
        setNumConditions();
    }

    public void handleSix(ActionEvent actionEvent) {
        checkReset();
        setNumber("6");
        checkPercent();
        checkSize();
        setSize();
        setNumConditions();
    }

    public void handleSeven(ActionEvent actionEvent) {
        checkReset();
        setNumber("7");
        checkPercent();
        checkSize();
        setSize();
        setNumConditions();
    }

    public void handleEight(ActionEvent actionEvent) {
        checkReset();
        setNumber("8");
        checkPercent();
        checkSize();
        setSize();
        setNumConditions();
    }

    public void handleNine(ActionEvent actionEvent) {
        checkReset();
        setNumber("9");
        checkPercent();
        checkSize();
        setSize();
        setNumConditions();
    }

    public void setSize(){
        String curr = window.getText();
        int length = curr.length();
        if(length<=10){
            window.setStyle("-fx-font-size: 35px;");
        }else if(length==11){
            window.setStyle("-fx-font-size: 32px;");
        }else if(length==12){
            window.setStyle("-fx-font-size: 29px;");
        }else if(length==13){
            window.setStyle("-fx-font-size: 27px;");
        }else if(length==14){
            window.setStyle("-fx-font-size: 25px;");
        }else if(length==15){
            window.setStyle("-fx-font-size: 23px;");
        }else if(length==16){
            window.setStyle("-fx-font-size: 21px;");
        }else if(length==17){
            window.setStyle("-fx-font-size: 20px;");
        }else if(length==18){
            window.setStyle("-fx-font-size: 19px;");
        }else if(length==19){
            window.setStyle("-fx-font-size: 16px;");
        }else if(length==20){
            window.setStyle("-fx-font-size: 16px;");
        }else if(length==21){
            window.setStyle("-fx-font-size: 16px;");
        }else if(length==22){
            window.setStyle("-fx-font-size: 16px;");
        }else if(length>22){
            window.setStyle("-fx-font-size: 13px;");
        }
    }

    public void checkSize(){
        String curr = window.getText();
        int length = curr.length();
        if(!(curr.equals("0"))){AC.setText("C");}else{AC.setText("AC");}
    }

    public void setNumber(String num){
        checkReset();
        String curr = window.getText();
        if(curr.equals("0")) {
            curr = num;
        }else if(curr.equals("-0")){
            curr = "-" + num;
        }else{
            curr += num;
        }
        window.setText(curr);
    }

    public void checkReset(){
        if(reset){
            window.setText("0");
            reset = false;
        }else{
            return;
        }
    }

    private void setAnswer(double x, double y) {
        if(operator == '+'){
            ans = x + y;
            num3 = y;
        }else if(operator == '='){
            return;
        }else if(operator == '-'){
            ans = x - y;
            num3 = y;
        }else if(operator == 'x'){
            ans = x * y;
            num3 = y;
        }else if(operator == '/'){
            ans = x / y;
            num3 = y;
        }
    }

    private void setNumConditions(){
        equalsClicked = false;
        operatorLastClicked = false;
        numLastClicked = true;
        percentClicked = false;
    }

    private void numClicked(char operator){
        double num = Double.parseDouble(window.getText());
        if(operatorLastClicked){
            this.operator = operator;
            this.lastOperator = operator;
            return;
        }
        if(equalsClicked){
            this.operator = operator;
            this.lastOperator = operator;
            num2 = num;
            numLastClicked = false;
            equalsClicked = false;
            operatorLastClicked = true;
            return;
        }
        if(Double.isNaN(num1)){
            this.operator = operator;
            num1 = num;
            reset = true;
        }else if(Double.isNaN(num2)){

            num2 = num;
            setAnswer(num1, num2);
            window.setText(Double.toString(ans));
            this.operator = operator;
            num2 = ans;
            reset = true;
        }else{
            setAnswer(num2, Double.parseDouble(window.getText()));
            window.setText(Double.toString(ans));
            this.operator = operator;
            //num1 = num2;

            num2 = ans;
            reset = true;
        }
        this.lastOperator = operator;
        numLastClicked = false;
        equalsClicked = false;
        operatorLastClicked = true;
    }


    public void checkPercent(){
        if(percentClicked){
            num1 = Double.NaN;
            num2 = Double.NaN;
            num3 = Double.NaN;
            operator = '=';
        }
    }

    /*public void keyPress(KeyEvent keyEvent) {
        curr = window.getText();

    }

    public void keyRelease(KeyEvent keyEvent) {
        window.setText(curr);
    }*/
}
