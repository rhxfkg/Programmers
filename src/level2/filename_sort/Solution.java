package level2.filename_sort;

public class Solution {
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
            for (int j = i + 1; j < files.length; j++) {
                if (head[i].compareToIgnoreCase(head[j]) > 0){
                    String temp = head[i];
                    head[i] = head[j];
                    head[j] = temp;

                    temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;

                    temp = tail[i];
                    tail[i] = tail[j];
                    tail[j] = temp;
                } else if (head[i].compareToIgnoreCase(head[j]) == 0) {
                    if (Integer.parseInt(number[i]) > Integer.parseInt(number[j])) {
                        String temp = head[i];
                        head[i] = head[j];
                        head[j] = temp;

                        temp = number[i];
                        number[i] = number[j];
                        number[j] = temp;

                        temp = tail[i];
                        tail[i] = tail[j];
                        tail[j] = temp;
                    }
                }
            }
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
        try {
            Integer.parseInt(String.valueOf(value));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
