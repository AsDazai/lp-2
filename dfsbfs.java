import java.util.*;

public class Graph {
    Map<Integer, List<Integer>> adj = new HashMap<>();

    void addEdge(int u, int v) {
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    void dfs(int v, Set<Integer> visited) {
        if (visited.add(v)) {
            System.out.print(v + " ");
            for (int n : adj.get(v)) dfs(n, visited);
        }
    }

    void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start); visited.add(start);
        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v + " ");
            for (int n : adj.get(v)) if (visited.add(n)) q.add(n);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1); g.addEdge(0, 2); g.addEdge(1, 3); g.addEdge(2, 4); g.addEdge(3, 5);

        System.out.print("DFS: "); g.dfs(0, new HashSet<>());
        System.out.print("\nBFS: "); g.bfs(0);
    }
}
