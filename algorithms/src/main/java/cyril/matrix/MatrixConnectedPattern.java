package cyril.matrix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MatrixConnectedPattern {

    static List<Cell>  visited;
    static int         row;
    static int         col;
    static int[][]     mat;
    static Stack<Cell> stack;

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(MatrixConnectedPattern.class.getResourceAsStream("MatrixConnectedPattern.txt"));
        row = s.nextInt();
        col = s.nextInt();
        mat = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = s.nextInt();
            }
        }

        stack = new Stack<Cell>();
        visited = new ArrayList<Cell>();
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;

                visit(i, j);
                while (!stack.isEmpty()) {
                    Cell cell = stack.pop();
                    int r = cell.i;
                    int c = cell.j;

                    count++;

                    // above row
                    visit(r - 1, c - 1);
                    visit(r - 1, c);
                    visit(r - 1, c + 1);

                    // same row
                    visit(r, c - 1);
                    visit(r, c + 1);

                    // below row
                    visit(r + 1, c - 1);
                    visit(r + 1, c);
                    visit(r + 1, c + 1);
                }
                max = Math.max(max, count);
            }
        }

        System.out.println("Max :" + max);

    }

    private static void visit(int i, int j) {
        if (i >= 0 && i < row && j >= 0 && j < col && mat[i][j] == 1) {
            Cell c = new Cell(i, j);
            if (!visited.contains(c)) {
                visited.add(c);
                stack.push(c);
            }
        }
    }

    static class Cell {
        int i;
        int j;

        public Cell(int k, int l) {
            i = k;
            j = l;
        }

        @Override
        public boolean equals(Object obj) {
            Cell s = (Cell) obj;
            return i == s.i && j == s.j;
        }

    }

}
