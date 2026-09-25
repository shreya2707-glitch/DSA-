import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();

        // Add all 0s to the queue as multi-source BFS starting points
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0) {
                    dist[r][c] = 0;
                    queue.offer(new int[] { r, c });
                } else {
                    dist[r][c] = -1; // Unvisited
                }
            }
        }

        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        // Breadth-First Search
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // If within bounds and not yet visited
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }

        return dist;
    }
}