class Solution {
public:
    bool isNum(char c) {
        return c <= '9'  &&  c >= '0';
    }


    vector<int> dp[21][21];

    vector<int> solve(int i, int j, string &exp) {
        if (j == i) return {exp[i] - '0'};

        if (j - i <= 1  &&  isNum(exp[i])  &&  isNum(exp[j]))  return {((exp[i] - '0') * 10) + (exp[j] - '0')};
        

        if (dp[i][j].size() > 0) return dp[i][j];

        vector<int> posAns;


        for (int k = i + 1; k < j; k++) {

            if (isNum(exp[k])) continue;


            auto leftSolution = solve(i, k - 1, exp);
            auto rightSolution = solve(k + 1, j, exp);

            for (int x: leftSolution) {
                for (int y: rightSolution) {
                    switch(exp[k]) {
                        case '*':
                            posAns.push_back(x * y);
                        break;
                        case '-':
                            posAns.push_back(x - y);
                        break;
                        case '+':
                            posAns.push_back(x + y);
                        break;
                    }
                }
            }
        }

        return dp[i][j] = posAns;
    }

    vector<int> diffWaysToCompute(string expression) {
        return solve(0, expression.size() - 1, expression);   
    }
};