public class WordSearch {
    public static boolean dfs(char[][] board, String word, int i, int j, int idx){
        if (idx == word.length()) {
            return true;
        }

        if (i<0 || i>=board.length || j<0 || j>=board[0].length) {
            return false;
        }

        if (board[i][j] != word.charAt(idx)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean isFound = dfs(board, word, i-1, j, idx+1) || dfs(board, word, i+1, j, idx+1) ||
                          dfs(board, word, i, j+1, idx+1) || dfs(board, word, i, j-1, idx+1);
        
        //: Backtracking (Undo changes)
        board[i][j] = temp;

        return isFound;
    }
    public static boolean exist(char[][] board, String word){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'D'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}