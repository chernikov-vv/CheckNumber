package com.company;

public class Main {

    public static void main(String[] args) {
        String number = " + 7 (955) 165 2222 ";
        checkNumber(number);
    }

    public static void checkNumber(String number) {
        String helpNumber = "";
        boolean checkPlusSeven = false;
        boolean checkIncorrectSym = false;
        boolean checkLengthNumber = false;
        String[] answer = new String[2];

        for (int i = 0; i < number.length(); i++) {
            if (number.substring(i, i + 1).equals(")") || number.substring(i, i + 1).equals("(")
                    || number.substring(i, i + 1).equals(" ")) {
                checkIncorrectSym = true;
                continue;
            } else
                helpNumber += number.substring(i, i + 1);
        }
        if (helpNumber.substring(0, 1).equals("+") && helpNumber.substring(1, 2).equals("7")) {
            checkPlusSeven = true;
            helpNumber = "8" + helpNumber.substring(2);
        }
        if (helpNumber.length() != 11)
            checkLengthNumber = true;

        if (checkLengthNumber)
            answer[0] = "Некорректный номер. Количество символов больше 11";
        else
            answer[0] = helpNumber;

        if (checkIncorrectSym)
            answer[1] = "В номере есть пробелы и/или скобки";

        if (checkPlusSeven) {
            if (checkIncorrectSym)
                answer[1] += "; ";
            answer[1] += "Замена +7 на 8";
        }

        if (!checkPlusSeven && !checkIncorrectSym)
            answer[1] = "Не было изменений";

        for(int i =0; i< answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}
