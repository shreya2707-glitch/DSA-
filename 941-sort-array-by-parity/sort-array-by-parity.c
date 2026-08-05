/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* sortArrayByParity(int* nums, int numsSize, int* returnSize) {
    // 1. Allocate memory for the result array
    int* result = (int*)malloc(numsSize * sizeof(int));
    *returnSize = numsSize;

    // 2. Initialize two pointers for filling the result array
    int left = 0;
    int right = numsSize - 1;

    // 3. Populate result from front for evens and back for odds
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] % 2 == 0) {
            result[left++] = nums[i];
        } else {
            result[right--] = nums[i];
        }
    }

    return result;
    
}