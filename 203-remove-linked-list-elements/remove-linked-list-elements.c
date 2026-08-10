/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeElements(struct ListNode* head, int val) {
    // Create a dummy node that points to the head to simplify edge cases (e.g., removing head)
    struct ListNode dummy;
    dummy.next = head;
    
    struct ListNode* curr = &dummy;
    
    while (curr->next != NULL) {
        if (curr->next->val == val) {
            struct ListNode* temp = curr->next;
            curr->next = curr->next->next;
            free(temp); // Free the memory of the removed node
        } else {
            curr = curr->next;
        }
    }
    
    return dummy.next;
}