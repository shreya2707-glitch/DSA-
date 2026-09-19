class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        
        // If the starting pixel already has the target color, no change is needed
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        
        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Boundary check and color match check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != originalColor) {
            return;
        }

        // Fill with the new color
        image[r][c] = newColor;

        // Traverse all 4 adjacent directions (up, down, left, right)
        dfs(image, r + 1, c, originalColor, newColor);
        dfs(image, r - 1, c, originalColor, newColor);
        dfs(image, r, c + 1, originalColor, newColor);
        dfs(image, r, c - 1, originalColor, newColor);
    }
}