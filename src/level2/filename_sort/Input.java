package level2.filename_sort;

import java.util.Scanner;

public class Input {
    public static String[] getInput() {
        //영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-")
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine().split(",");
    }
}
