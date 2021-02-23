package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String number = "+79886554450";
        checkNumber(number);
        System.out.println(Arrays.toString(checkNumber(number)));
    }

    public static String[] checkNumber(String number) {
        String[] answer = new String[2];

        if (!number.isEmpty() && number.length() >= 11) {

            String helpNumber;
            boolean checkPlusSeven = false;
            boolean checkIncorrectSym = false;
            boolean checkLengthNumber = false;

            helpNumber = number.replace("+7", "8");
            if (!number.equals(helpNumber)) {
                checkPlusSeven = true;
                answer[1] = "Замена +7 на 8";
                number = helpNumber;
            }

            helpNumber = number.replaceAll("\\D", "");
            if (!number.equals(helpNumber)) {
                checkIncorrectSym = true;
                if (checkPlusSeven) {
                    answer[1] += "; " + "В номере есть пробелы и/или скобки";
                } else {
                    answer[1] = "В номере есть пробелы и/или скобки";
                }
            }

            if (helpNumber.length() != 11) {
                answer[0] = "Введен некорректный номер";
                checkLengthNumber = true;
                if((checkIncorrectSym || checkPlusSeven) && helpNumber.length()>11){
                    answer[1]+="; Количество символов больше 11";
                }
                if((checkIncorrectSym || checkPlusSeven) && helpNumber.length()<11){
                    answer[1]+="; Количество символов меньше 11";
                }
                if(helpNumber.length() > 11 && !checkIncorrectSym && !checkPlusSeven){
                    answer[1] = "Количество символов больше 11";
                }if(helpNumber.length() < 11 && !checkIncorrectSym && !checkPlusSeven){
                    answer[1] = "Количество символов меньше 11";
                }
            } else {
                answer[0] = helpNumber;
            }

            if (!checkIncorrectSym && !checkLengthNumber && !checkPlusSeven) {
                answer[1] = "Не было изменений";
            }
        } else {
            answer[0] = "Введен некорректный номер";
            answer[1] = "Количество символов меньше 11";
        }
        return answer;
    }
}
