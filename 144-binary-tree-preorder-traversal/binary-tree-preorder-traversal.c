/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include <stdlib.h>

void preorder(struct TreeNode* root, int* result, int* returnSize) {
    if (root == NULL) return;
    result[(*returnSize)++] = root->val; // Process Root
    preorder(root->left, result, returnSize);
    preorder(root->right, result, returnSize);
}

int* preorderTraversal(struct TreeNode* root, int* returnSize) {
    *returnSize = 0;
    int* result = (int*)malloc(sizeof(int) * 100); // 100 is LeetCode max node constraint
    preorder(root, result, returnSize);
    return result;
}