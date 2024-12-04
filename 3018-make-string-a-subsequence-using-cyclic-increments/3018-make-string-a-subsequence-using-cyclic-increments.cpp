class Solution {
public:
    bool canMakeSubsequence(string source, string target) {
        int srcLen = source.size();
        int tgtLen = target.size();
        int srcIdx = 0;
        int tgtIdx = 0;
        
        while(srcIdx < srcLen && tgtIdx < tgtLen) {
            if((source[srcIdx] == target[tgtIdx]) || 
               (source[srcIdx] == 'z' && target[tgtIdx] == 'a') || 
               (source[srcIdx] + 1 == target[tgtIdx])) {
                srcIdx++;
                tgtIdx++;
            } else {
                srcIdx++;
            }
        }
        return tgtIdx == tgtLen;
    }
};