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

void postorder(struct TreeNode* root, int* result, int* returnSize) {
    if (root == NULL) return;
    postorder(root->left, result, returnSize);
    postorder(root->right, result, returnSize);
    result[(*returnSize)++] = root->val; // Process Root
}

int* postorderTraversal(struct TreeNode* root, int* returnSize) {
    *returnSize = 0;
    int* result = (int*)malloc(sizeof(int) * 100);
    postorder(root, result, returnSize);
    return result;
}