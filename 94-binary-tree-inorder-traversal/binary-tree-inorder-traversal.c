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

void inorder(struct TreeNode* root, int* result, int* returnSize) {
    if (root == NULL) return;
    inorder(root->left, result, returnSize);
    result[(*returnSize)++] = root->val; // Process Root
    inorder(root->right, result, returnSize);
}

int* inorderTraversal(struct TreeNode* root, int* returnSize) {
    *returnSize = 0;
    int* result = (int*)malloc(sizeof(int) * 100);
    inorder(root, result, returnSize);
    return result;
}