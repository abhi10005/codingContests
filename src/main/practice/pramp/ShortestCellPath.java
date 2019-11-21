package main.practice.pramp;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestCellPath {

    public static void main(String[] args) {
        assertTestCase(new int[][]{{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 1, 1}}, new Cell(0,0, 0),new Cell(2,0, 0), 8);
        assertTestCase(new int[][]{{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 0, 1, 1}}, new Cell(0,0, 0),new Cell(2,0, 0), -1);
        assertTestCase(new int[][]{{1, 1, 1}, {0, 0, 0}, {0, 0, 0}}, new Cell(0,1, 0),new Cell(0,0, 0), 1);
        assertTestCase(new int[][]{{0,1,0}, {1,0,0}, {1,0,1}}, new Cell(2,0, 0),new Cell(1,0, 0), 1);
    }

    private static void assertTestCase(int[][] input, Cell source, Cell target, int exected){
        int actual = shortestCellPath(input, source.x, source.y, target.x, target.y);
        assert actual == exected : "Shortest distance returned "+actual+", whereas expected = "+exected;
    }

    private static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(sr, sc, 0));
        Cell target = new Cell(tr, tc, -1);
        while(!q.isEmpty()){
            // Removing element from my queue
            Cell cell = q.remove();
            if(cell.x == target.x && cell.y == target.y){
                return cell.distanceFromSrc;
            }

            if(visited[cell.x][cell.y])  continue;
            // Checking it's qualified neighbours and adding to the queue and updating mat for cell to true
            // Check left
            if(cell.y-1 >= 0 && grid[cell.x][cell.y-1] == 1 && !visited[cell.x][cell.y-1]){
                q.add(new Cell(cell.x, cell.y-1, cell.distanceFromSrc+1));
            }

            // Check right
            if(cell.y+1 < cols && grid[cell.x][cell.y+1] == 1 && !visited[cell.x][cell.y+1]){
                q.add(new Cell(cell.x, cell.y+1, cell.distanceFromSrc+1));
            }

            // Check bottom
            if(cell.x+1 < rows && grid[cell.x+1][cell.y] == 1 && !visited[cell.x+1][cell.y]){
                q.add(new Cell(cell.x+1, cell.y, cell.distanceFromSrc+1));
            }

            // Check top
            if(cell.x-1 >=0 && grid[cell.x-1][cell.y] == 1 && !visited[cell.x-1][cell.y]){
                q.add(new Cell(cell.x-1, cell.y, cell.distanceFromSrc+1));
            }
            visited[cell.x][cell.y] = true;
        }
        return -1;
    }

    static class Cell{
        int x;
        int y;
        int distanceFromSrc;

        Cell(int row, int col, int distanceFromSrc){
            this.x = row;
            this.y = col;
            this.distanceFromSrc = distanceFromSrc;
        }
    }
}
