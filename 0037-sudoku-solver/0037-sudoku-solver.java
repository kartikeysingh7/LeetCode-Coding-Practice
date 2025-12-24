class Solution {
    private final int[] rows = new int[9], cols = new int[9], boxes = new int[9];
    private static final int[][] cells = new int[81][3];
    private char[][] board;
    public void solveSudoku(char[][] board) {
        int index = 0;
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if(board[row][col] == '.') {
                    cells[index][0] = row;
                    cells[index][1] = col;
                    cells[index++][2] = row / 3 * 3 + col / 3;
                    continue;
                }
                int bitmask = 1 << board[row][col] - '1';
                rows[row] |= bitmask;
                cols[col] |= bitmask;
                boxes[row / 3 * 3 + col / 3] |= bitmask;
            }
        }
        this.board = board;
        generateCell(index - 1);
    }
    private boolean generateCell(int index) {
        if(index == -1) return true;
        int min = 10, bestIndex = -1;
        for(int i = index; i >= 0; i--) {
            int count = 9 - Integer.bitCount(rows[cells[i][0]] | cols[cells[i][1]] | boxes[cells[i][2]]);
            if(count < min) {
                min = count;
                bestIndex = i;
                if(count == 1) break;
            }
        }
        if(bestIndex != index) {
            int[] temp = cells[index];
            cells[index] = cells[bestIndex];
            cells[bestIndex] = temp;
        }

        int row = cells[index][0], col = cells[index][1], square = cells[index][2], temp = 0b111111111 - (rows[row] | cols[col] | boxes[square]);
        while(temp > 0) {
            int bitmask = temp & -temp;
            rows[row] |= bitmask;
            cols[col] |= bitmask;
            boxes[square] |= bitmask;
            if(generateCell(index - 1)) {
                board[row][col] = (char)(Integer.numberOfTrailingZeros(bitmask) + '1');
                return true;
            }
            temp ^= bitmask;
            rows[row] ^= bitmask;
            cols[col] ^= bitmask;
            boxes[square] ^= bitmask;
        }
        return false;
    }
}