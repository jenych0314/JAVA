import java.util.Stack;

public class MazeSolver {
    int[][] map;
    Position start;
    Position end;
    Position current;
    Stack<Position> path = new Stack<Position>();
    Stack<Position> cross = new Stack<Position>();

    public MazeSolver(int[][] map, Position start, Position end) {
        this.map = map;
        this.start = start;
        this.end = end;
        this.current = new Position(start.getRow(), start.getCol());
    }

    public boolean canMove(int row, int col) {
        if (row >= this.map.length || row < 0) {
            return false;
        }

        if (col >= this.map[row].length || col < 0) {
            return false;
        }

        return this.map[row][col] == 0;
    }

    public boolean canMove(Position p) {
        return canMove(p.getRow(), p.getCol());
    }

    boolean findExit(Position previous, Position current) {
        if (current.equals(this.end)) {
            return true;
        }

        Position next = new Position();

        for (int i = 0; i < 2; i++) {
            next = new Position(current.getRow() + (2 * i - 1), current.getCol());
            if (canMove(next) && !previous.equals(next)) {
                this.path.push(current);
                if (findExit(current, next)) {
                    return true;
                }
                this.path.pop();
            }
        }

        for (int i = 0; i < 2; i++) {
            next = new Position(current.getRow(), current.getCol() + (2 * i - 1));
            if (canMove(next) && !previous.equals(next)) {
                this.path.push(current);
                if (findExit(current, next)) {
                    return true;
                }
                this.path.pop();
            }
        }

        return false;
    }

    public boolean findExit() {
        boolean result = this.findExit(this.current, this.current);
        System.out.println(this.path);
        return result;
    }

    /*
     * boolean findExitIterative() {
     * while (true) {
     * path.push(current);
     * 
     * if (current.equals(end)) {
     * return true;
     * }
     * 
     * else if (canMove(current.getRow(), current.getCol() + 1)) {
     * current.move_right();
     * }
     * else if (canMove(current.getRow() + 1, current.getCol())) {
     * current.move_down();
     * }
     * else if (canMove(current.getRow(), current.getCol() - 1)) {
     * current.move_left();
     * }
     * else if (canMove(current.getRow() - 1, current.getCol())) {
     * current.move_up();
     * }
     * 
     * else if (path.contains(Position next = new Position(current.getRow(),
     * current.getCol() - 1))) {
     * current = path.peek();
     * path.pop();
     * } else if (canMove(current.getRow() + 1, current.getCol())) {
     * current = path.peek();
     * path.pop();
     * } else if (canMove(current.getRow(), current.getCol() - 1)) {
     * current = path.peek();
     * path.pop();
     * } else if (canMove(current.getRow() - 1, current.getCol())) {
     * current = path.peek();
     * path.pop();
     * }
     * }
     * }
     */
    // public static void main(String[] args) {
    // int[][] map1 = {
    // { 0, 1, 1, 1 },
    // { 0, 0, 0, 0 },
    // { 1, 0, 1, 1 },
    // { 0, 0, 0, 0 }
    // };
    // MazeSolver solver = new MazeSolver(map1, new Position(0, 0), new Position(3,
    // 3));
    // // System.out.println(solver.findExit());
    // // System.out.println("map1: " + solver.findExitIterative());

    // int[][] map2 = {
    // { 0, 1, 1, 1 },
    // { 0, 1, 0, 0 },
    // { 1, 0, 1, 1 },
    // { 0, 0, 0, 0 }
    // };
    // solver = new MazeSolver(map2, new Position(0, 0), new Position(3, 3));
    // // System.out.println(solver.findExit());
    // // System.out.println("map2: " + solver.findExitIterative());

    // int[][] map3 = {
    // { 0, 0, 0, 0 },
    // { 1, 0, 1, 0 },
    // { 1, 0, 1, 0 },
    // { 0, 0, 0, 0 }
    // };
    // solver = new MazeSolver(map3, new Position(0, 0), new Position(3, 3));
    // // System.out.println(solver.findExit());
    // // System.out.println("map3: " + solver.findExitIterative());
    // }
}
