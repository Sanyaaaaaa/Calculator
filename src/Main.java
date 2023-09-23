import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws InputException {
        while (true) {
            System.out.println("Введите числа и мат опрерацию в таком формате: [число] [операция] [число]\n" +
                    "Чтобы закончить работу программы введите любое слово");
            String result = calc(scanner.nextLine());
            System.out.println(result);
        }
    }
    public static String calc(String input) throws InputException {
        Integer[] arabic = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        String[] roman = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
        String[] operations = {"+", "-", "*", "/", "", "", "", "", "", ""};
        String[] str = input.split(" ");
        int isOk = 0;
        boolean isRoman = false;
        boolean isArab = false;
        if (str.length != 3){
            throw new InputException("Неверные аргументы");
        }

        for (int j = 0; j < 3; j++){
            for (int i = 0; i < roman.length; i++){
                if (str[j].equals(String.valueOf(arabic[i])) || str[j].equals(operations[i])){
                    isOk += 1;
                    isArab = true;
                }
                if (str[j].equals(roman[i])){
                    str[j] = romanToNumber(str[j]);
                    isOk += 1;
                    isRoman = true;
                }
                if (isRoman && isArab){
                    throw new InputException("Нельзя совмещать арабские и римские цифры");
                }
            }
        }
        if (isOk != 3){
            throw new InputException("\nНеверные входные данные,\n" +
                    "на вход могут идти только арабские и римские" +
                    " цифры от 1 до 10 (совмещать нельзя),\nа также операции +, - , *, /.");
        }

        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[2]);
        String operation = String.valueOf(str[1]);
        int res = 0;
        switch (operation) {
            case "+" -> res = x + y;
            case "-" -> res = x - y;
            case "*" -> res = x * y;
            case "/" -> res = x / y;
        }
        String resStr = String.valueOf(res);
        if (isRoman){
            resStr = numberToRoman(resStr);
        }
        else if (isRoman == true && res <= 0){
            throw new InputException("Ответ в вычислениях с римскими цифрами не может быть < или = 0");
        }
        return resStr;
    }
    private static String romanToNumber(String roman) {
        return switch (roman) {
            case "I" -> "1";
            case "II" -> "2";
            case "III" -> "3";
            case "IV" -> "4";
            case "V" -> "5";
            case "VI" -> "6";
            case "VII" -> "7";
            case "VIII" -> "8";
            case "IX" -> "9";
            case "X" -> "10";
            default -> "-1";
        };
    }
    public static String numberToRoman(String number) {
        return switch (number) {
            case "1" -> "I";
            case "2" -> "II";
            case "3" -> "III";
            case "4" -> "IV";
            case "5" -> "V";
            case "6" -> "VI";
            case "7" -> "VII";
            case "8" -> "VIII";
            case "9" -> "IX";
            case "10" -> "X";
            case "11" -> "XI";
            case "12" -> "XII";
            case "13" -> "XIII";
            case "14" -> "XIV";
            case "15" -> "XV";
            case "16" -> "XVI";
            case "17" -> "XVII";
            case "18" -> "XVIII";
            case "19" -> "XIX";
            case "20" -> "XX";
            case "21" -> "XXI";
            case "24" -> "XXIV";
            case "25" -> "XXV";
            case "27" -> "XXVII";
            case "28" -> "XXVIII";
            case "30" -> "XXX";
            case "32" -> "XXXII";
            case "35" -> "XXXV";
            case "36" -> "XXXVI";
            case "40" -> "XL";
            case "42" -> "XLII";
            case "45" -> "XLV";
            case "48" -> "XLVIII";
            case "49" -> "XLIX";
            case "50" -> "L";
            case "54" -> "LIV";
            case "56" -> "LVI";
            case "60" -> "LX";
            case "63" -> "LXIII";
            case "64" -> "LXIV";
            case "70" -> "LXX";
            case "72" -> "LXXII";
            case "80" -> "LXXX";
            case "81" -> "LXXXI";
            case "90" -> "XC";
            default -> "-1";
        };
    }
}
