package level2.filename_sort;

public class Solution {
    //처음 삽입정렬 사용시 순서 변경되는 문제 발생 -> 버블정렬 사용해서 해결
    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[] head = new String[files.length];
        String[] number = new String[files.length];
        String[] tail = new String[files.length];

        String[] splitResult;
        int index = 0;
        for (String file : files) {
            splitResult = splitFileName(file);
            head[index] = splitResult[0];
            number[index] = splitResult[1];
            tail[index] = splitResult[2];
            index++;
        }

        //정렬하면 됨 -> 파일 개수가 1000개 이하이므로 n^2이여도 1000000번
        for (int i = 0; i < files.length; i++) {
            for (int j = 0; j < files.length - 1; j++) {
                if (head[j].compareToIgnoreCase(head[j + 1]) > 0){
                    String temp = head[j];
                    head[j] = head[j + 1];
                    head[j + 1] = temp;

                    temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;

                    temp = tail[j];
                    tail[j] = tail[j + 1];
                    tail[j + 1] = temp;
                } else if (head[j].compareToIgnoreCase(head[j + 1]) == 0) {
                    if (Integer.parseInt(number[j]) > Integer.parseInt(number[j + 1])) {
                        String temp = head[j];
                        head[j] = head[j + 1];
                        head[j + 1] = temp;

                        temp = number[j];
                        number[j] = number[j + 1];
                        number[j + 1] = temp;

                        temp = tail[j];
                        tail[j] = tail[j + 1];
                        tail[j + 1] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < files.length; i++) {
            answer[i] = head[i] + number[i] + tail[i];
        }

        return answer;
    }

    private static String[] splitFileName(String file) {
        String[] splitResult = new String[]{"", "", ""};

        for (int i = 0; i < file.length(); i++) {
            if (isInt(file.charAt(i))) {
                splitResult[0] = file.substring(0, i);
                file = file.substring(i);
                break;
            }
        }

        if (splitResult[0].isBlank()) {
            splitResult[0] = file;
            return splitResult;
        }

        //NUMBER는 1~5글자 -> 5글자 넘게 숫자가 나오면 뒤는 TAIL로 처리
        for (int i = 0; i < file.length(); i++) {
            if (i < 5 && !isInt(file.charAt(i))) {
                splitResult[1] = file.substring(0, i);
                splitResult[2] = file.substring(i);
                break;
            } else if (i == 4 && isInt(file.charAt(i))) {
                splitResult[1] = file.substring(0, 5);
                splitResult[2] = file.substring(5);
                break;
            }
        }

        if (splitResult[1].isBlank()) {
            splitResult[1] = file;
        }

        return splitResult;
    }

    private static boolean isInt(char value) {
        return value >= '0' && value <= '9';
    }
}
