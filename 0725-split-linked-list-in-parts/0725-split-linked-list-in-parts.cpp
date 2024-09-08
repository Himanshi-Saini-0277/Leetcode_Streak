/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        vector<ListNode*> ans(k);

        int size = 0;
        ListNode* current = head;
        while (current != nullptr) {
            size++;
            current = current->next;
        }

        int splitSize = size / k;

        int numRemainingParts = size % k;

        current = head;
        ListNode* prev = current;
        for (int i = 0; i < k; i++) {
            ListNode* newPart = current;
            int currentSize = splitSize;
            if (numRemainingParts > 0) {
                numRemainingParts--;
                currentSize++;
            }

            int j = 0;
            while (j < currentSize) {
                prev = current;
                if (current != nullptr) {
                    current = current->next;
                }
                j++;
            }

            if (prev != nullptr) {
                prev->next = nullptr;
            }

            ans[i] = newPart;
        }

        return ans;
    }
};