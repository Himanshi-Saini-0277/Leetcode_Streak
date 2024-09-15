class Solution {
public:
    static int findTheLongestSubstring(string& s) {
        char vow[26];
        memset(vow, -1, 26);
        vow[0]=0, vow['e'-'a']=1, vow['i'-'a']=2, vow['o'-'a']=3, vow['u'-'a']=4;
        const int n=s.size();
        vector<char> bmask(n+1, 0);
        int first_seen[32];
        memset(first_seen, -1, sizeof(first_seen));
        int len=0;
        first_seen[0]=0;
        for(int i=0; i<n; i++){
            const char x=vow[s[i]-'a'];
            const char curr=bmask[i+1]=bmask[i]^(x==-1?0:(1<<x));
            if (first_seen[curr]==-1) first_seen[curr]=i+1;
            len=max(len, i+1-first_seen[curr]);
        }
        return len;
    }
};
