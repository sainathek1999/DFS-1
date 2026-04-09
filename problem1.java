 /**
    Time Complexity : O(M * N)
    Explanation:
    Each pixel in the grid can be visited at most once during BFS traversal.

    Space Complexity : O(M * N)
    Explanation:
    In the worst case the queue may store many pixels if the entire grid
    needs to be recolored.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially faced a time limit issue because the starting pixel was not
    checked against the new color. This caused repeated processing.
    Fixed it by adding an early return when the starting pixel already
    has the target color.
    */

    class Solution {

   

        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    
            if (image[sr][sc] == color) return image;
    
            int m = image.length;
            int n = image[0].length;
    
            // Directions: right, left, up, down
            int[][] adj = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    
            Queue<int[]> q = new LinkedList<>();
    
            int oldcolor = image[sr][sc];
    
            q.add(new int[]{sr, sc});
            image[sr][sc] = color;
    
            while (!q.isEmpty()) {
    
                int[] curr = q.poll();
    
                for (int[] dir : adj) {
    
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldcolor) {
    
                        q.add(new int[]{nr, nc});
                        image[nr][nc] = color;
                    }
                }
            }
    
            return image;
        }
    }