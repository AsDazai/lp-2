import java.util.*;

public class AStar {
    static class N {
        int x, y, g, h;
        N(int x, int y, int g, int h) {
            this.x = x; this.y = y; this.g = g; this.h = h;
        }
    }

    static int H(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void main(String[] a) {
        int[][] G = {
            {0,0,0,0},
            {1,1,0,1},
            {0,0,0,0},
            {0,1,1,0}
        };
        int n = G.length, m = G[0].length;
        boolean[][] V = new boolean[n][m];
        PriorityQueue<N> Q = new PriorityQueue<>(Comparator.comparingInt(n1 -> n1.g + n1.h));
        Q.add(new N(0, 0, 0, H(0, 0, 3, 3)));
        int[][] D = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!Q.isEmpty()) {
            N c = Q.poll();
            if (V[c.x][c.y]) continue;
            V[c.x][c.y] = true;
            if (c.x == 3 && c.y == 3) {
                System.out.println("Cost: " + c.g); return;
            }
            for (int[] d : D) {
                int nx = c.x + d[0], ny = c.y + d[1];
                if (nx>=0 && ny>=0 && nx<n && ny<m && G[nx][ny]==0 && !V[nx][ny])
                    Q.add(new N(nx, ny, c.g+1, H(nx, ny, 3, 3)));
            }
        }
        System.out.println("No path");
    }
}
