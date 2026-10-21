//import java.util.HashSet;
//import java.util.Set;
//
//public class SudokuValidator {
//
//    public static boolean isValid(char[][] board) {
//        Long start = System.nanoTime();
//        boolean result = isValidRow(board) && isValidColumn(board) && isValidBox(board);
//        Long endTime = System.nanoTime();
//        Long duration = endTime - start;
//        System.out.println("Duration: " + duration);
//        return result;
//    }
//
//    private static boolean isValidRow(char[][] board) {
//        for (char[] row : board) {
//            Set<Character> set = new HashSet<>();
//            for (char c : row) {
//                if (c == '.') continue;
//                if (!set.add(c)) return false;
//            }
//        }
//        return true;
//    }
//
//    private static boolean isValidColumn(char[][] board) {
//        for (int i = 0; i < board[0].length; i++) {
//            Set<Character> set = new HashSet<>();
//            for (char[] chars : board) {
//                char c = chars[i];
//                if (c == '.') continue;
//                if (!set.add(c)) return false;
//            }
//        }
//        return true;
//    }
//
//    private static boolean isValidBox(char[][] board) {
//        int boxCount = 1;
//        int rowStart = 0;
//        int columnStart = 0;
//
//        while (boxCount <= 9) {
//            Set<Character> set = new HashSet<>();
//            for (int i = rowStart; i < rowStart + 3; i++) {
//                for (int j = columnStart; j < columnStart + 3; j++) {
//                    char c = board[i][j];
//                    if (c == '.') continue;
//                    if (!set.add(c)) return false;
//                }
//            }
//
//            columnStart = (columnStart + 3) % 9;
//            boxCount++;
//            if (boxCount == 4) rowStart = 3;
//            if (boxCount == 7) rowStart = 6;
//        }
//        return true;
//    }
//}
public class SudokuValidator {

    public static boolean isValid(char[][] board) {
        boolean[][] rows  = new boolean[9][9];
        boolean[][] cols  = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int d = c - '1';
                int box = (i / 3) * 3 + (j / 3);

                if (rows[i][d] || cols[j][d] || boxes[box][d]) {
                    return false;
                }

                rows[i][d]  = true;
                cols[j][d]  = true;
                boxes[box][d] = true;
            }
        }
        return true;
    }
}