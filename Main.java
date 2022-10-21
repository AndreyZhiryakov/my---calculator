import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введи цифры  в одну строку.Цифры и знак операции должны быть разделены пробелами." +
                    "Римские цифры необходимо вводить заглавными латинскими буквами.   " + "Input: ");
            String expression = in.nextLine();
            int count = 0;for(int i =0; i < expression.length();i++){ count++;}
            if((count<5)||(count>7)) {
                try {throw new IllegalArgumentException();} catch (IllegalArgumentException e) {
                    System.out.println("Неверный ввод данных. Должны быть введены только два числа и знак операции." +
                            "Цифры и знак операции должны быть разделены пробелами.Калькулятор работает только " +
                            "с целыми числами ");System.exit(0);}
            }
            try {
                System.out.println(calc(expression));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Некорректный ввод данных.Цифры и знак операции должны быть разделены пробелами.");
                System.exit(0);
            }
        }
    }

    public static String calc(String input) {
        String[] splitString = input.split(" ");
        String figure1str = splitString[0];
        String sign = splitString[1];
        String figure2str = splitString[2];
        String[] roman = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        List romanList = new ArrayList<>(Arrays.asList(roman));
        String[] arabic = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        List arabicList = new ArrayList<>(Arrays.asList(arabic));
        String sumFinal = " ";

        if ((romanList.contains(figure1str) && arabicList.contains(figure2str))||
                (romanList.contains(figure2str) && arabicList.contains(figure1str))) {
            try{throw new IllegalArgumentException();}catch(IllegalArgumentException e){
            System.out.println("Неверный ввод данных. Должны быть введены только римские " +
                    "или только арабские цифры.");
                System.exit(0);}
             } else if (arabicList.contains(figure2str) && arabicList.contains(figure1str)) {
            ArabicRoman expression1ArabicRoman = new ArabicRoman();
            expression1ArabicRoman.figure1ArabicRoman = figure1str;
            expression1ArabicRoman.figure2ArabicRoman = figure2str;
            expression1ArabicRoman.signArabicRoman = sign;
            expression1ArabicRoman.parseArabic1();
            expression1ArabicRoman.parseArabic2();
            return sumFinal = "Output:" + expression1ArabicRoman.switcher();}
              else if (romanList.contains(figure1str) && romanList.contains(figure2str)) {
            ArabicRoman expression2ArabicRoman = new ArabicRoman();
            expression2ArabicRoman.figure1ArabicRoman = figure1str;
            expression2ArabicRoman.figure2ArabicRoman = figure2str;
            expression2ArabicRoman.signArabicRoman = sign;
            expression2ArabicRoman.Roman1();
            expression2ArabicRoman.Roman2();
            int sumToRoman = expression2ArabicRoman.switcher();
            if(sumToRoman<=0){try{throw new IllegalArgumentException();}catch(IllegalArgumentException e){
                System.out.println("Результат вычисления римских цифр должен быть больше 0");}}
            return sumFinal = "Output:" + expression2ArabicRoman.ArabicToRoman(sumToRoman);
        } else { try{throw new IllegalArgumentException();}catch(IllegalArgumentException e){
            System.out.println("Неверный ввод данных. Калькулятор работает только с целыми числами " +
                    "и с числами меньше  или равными  10");System.exit(0);}
        }
        return sumFinal;
    }
}
class ArabicRoman {
    String figure1ArabicRoman;
    String figure2ArabicRoman;
    String signArabicRoman;
    int figure1IntArabicRoman = 0;
    int figure2IntArabicRoman = 0;
    int sum = 0;
    String sumString = " ";

    int parseArabic1() {
        figure1IntArabicRoman = Integer.parseInt(figure1ArabicRoman);
        return figure1IntArabicRoman;
    }
    int parseArabic2() {
        figure2IntArabicRoman = Integer.parseInt(figure2ArabicRoman);
        return figure2IntArabicRoman;
    }
    int switcher() {
        switch (signArabicRoman) {
            case "+":sum = figure1IntArabicRoman + figure2IntArabicRoman;return sum;
            case "-":sum = figure1IntArabicRoman - figure2IntArabicRoman;return sum;
            case "*":sum = figure1IntArabicRoman * figure2IntArabicRoman;return sum;
            case "/":sum = figure1IntArabicRoman / figure2IntArabicRoman;return sum;
        }
        return sum;
    }
    int Roman1() {if (figure1ArabicRoman.equals("I")) { figure1IntArabicRoman = 1;return figure1IntArabicRoman;}
        else if (figure1ArabicRoman.equals("II")) {figure1IntArabicRoman = 2;return figure1IntArabicRoman;}
        else if (figure1ArabicRoman.equals("III")) {figure1IntArabicRoman = 3;return figure1IntArabicRoman;}
        else if (figure1ArabicRoman.equals("IV")) {figure1IntArabicRoman = 4;return figure1IntArabicRoman;}
        else if (figure1ArabicRoman.equals("V")) {figure1IntArabicRoman = 5;return figure1IntArabicRoman;}
        else if (figure1ArabicRoman.equals("VI")) {figure1IntArabicRoman = 6;return figure1IntArabicRoman;}
        else if (figure1ArabicRoman.equals("VII")) {figure1IntArabicRoman = 7;return figure1IntArabicRoman;}
        else if (figure1ArabicRoman.equals("VIII")) {figure1IntArabicRoman = 8;return figure1IntArabicRoman;}
        else if (figure1ArabicRoman.equals("IX")) {figure1IntArabicRoman = 9;return figure1IntArabicRoman;}
        else if (figure1ArabicRoman.equals("X")) {figure1IntArabicRoman = 10;return figure1IntArabicRoman;}
        else {System.exit(0);}return figure1IntArabicRoman;}
    int Roman2() {if (figure2ArabicRoman.equals("I")) { figure2IntArabicRoman = 1;return figure2IntArabicRoman;}
    else if (figure2ArabicRoman.equals("II")) {figure2IntArabicRoman = 2;return figure2IntArabicRoman;}
    else if (figure2ArabicRoman.equals("III")) {figure2IntArabicRoman = 3;return figure2IntArabicRoman;}
    else if (figure2ArabicRoman.equals("IV")) {figure2IntArabicRoman = 4;return figure2IntArabicRoman;}
    else if (figure2ArabicRoman.equals("V")) {figure2IntArabicRoman = 5;return figure2IntArabicRoman;}
    else if (figure2ArabicRoman.equals("VI")) {figure2IntArabicRoman = 6;return figure2IntArabicRoman;}
    else if (figure2ArabicRoman.equals("VII")) {figure2IntArabicRoman = 7;return figure2IntArabicRoman;}
    else if (figure2ArabicRoman.equals("VIII")) {figure2IntArabicRoman = 8;return figure2IntArabicRoman;}
    else if (figure2ArabicRoman.equals("IX")) {figure2IntArabicRoman = 9;return figure2IntArabicRoman;}
    else if (figure2ArabicRoman.equals("X")) {figure2IntArabicRoman = 10;return figure2IntArabicRoman;}
    else {System.exit(0);}return figure2IntArabicRoman;}
enum RomanArabic {
    C(100), XC(90), LX(60),L(50),XL(40),X(10),IX(9), V(5),IV(4),
    I(1);
    int value;
    RomanArabic(int value) {
        this.value = value;
    }
    int getValue() {
        return value;
    }
    static List getValues (){return List.of(values());}
 }
    String ArabicToRoman(int number){
        List romanFigures = RomanArabic.getValues();
        int i=0;
        StringBuilder roman = new StringBuilder();
        while((number>0)&&(i< romanFigures.size())){
            RomanArabic newSymbol = (RomanArabic) romanFigures.get(i);
            if(newSymbol.getValue()<= number){
                roman.append(newSymbol.name());
                number-=newSymbol.getValue();}
            else {
                i++;
             }
          }
        return roman.toString();
    }
}