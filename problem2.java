   /**
    Time Complexity : O(M * N)
    Explanation:
    Each cell in the matrix is processed at most once during BFS.

    Space Complexity : O(M * N)
    Explanation:
    The queue may contain many cells when expanding BFS levels
    from all 0-cells simultaneously.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially tried solving from each 1 cell individually which
    resulted in high time complexity.
    Later optimized using multi-source BFS by pushing all 0-cells
    into the queue first and expanding outward to compute the
    minimum distance for every 1-cell.
    */

    class Solution {

 

        public int[][] updateMatrix(int[][] mat) {
    
            int[][] adj = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            Queue<int[]> q = new LinkedList<>();
    
            int m = mat.length;
            int n = mat[0].length;
    
            // Step 1: Push all zero cells to queue and mark 1s as -1 (unvisited)
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
    
                    if (mat[i][j] == 0) {
                        q.add(new int[]{i, j});
                    } else {
                        mat[i][j] = -1;
                    }
                }
            }
    
            int l = 1;
    
            // Step 2: BFS expansion
            while (!q.isEmpty()) {
    
                int size = q.size();
    
                for (int k = 0; k < size; k++) {
    
                    int[] curr = q.poll();
    
                    for (int[] dir : adj) {
    
                        int nr = curr[0] + dir[0];
                        int nc = curr[1] + dir[1];
    
                        if (nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1) {
    
                            q.add(new int[]{nr, nc});
                            mat[nr][nc] = l;
                        }
                    }
                }
    
                l++;
            }
    
            return mat;
        }
    }