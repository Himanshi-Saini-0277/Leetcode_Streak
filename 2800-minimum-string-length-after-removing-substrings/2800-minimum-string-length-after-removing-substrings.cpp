class Solution {
public:
    int minLength(string s) {
        stack<char> charStack;
        for (char currentChar : s) {
            if (!charStack.empty() && 
                ((charStack.top() == 'A' && currentChar == 'B') || 
                 (charStack.top() == 'C' && currentChar == 'D'))) {
                charStack.pop();
            } else {
                charStack.push(currentChar);
            }
        }
        return charStack.size();
    }
};