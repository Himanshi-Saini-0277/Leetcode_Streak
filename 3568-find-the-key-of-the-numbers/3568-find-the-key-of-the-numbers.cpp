class Solution {
public:
    int generateKey(int num1, int num2, int num3) {
        std::string str1 = padWithZeros(num1);
        std::string str2 = padWithZeros(num2);
        std::string str3 = padWithZeros(num3);
        
        std::string key = "";
        
        for (int i = 0; i < 4; ++i) {
            char minDigit = std::min({str1[i], str2[i], str3[i]});
            key += minDigit;
        }
        
        std::stringstream ss(key);
        int result;
        ss >> result;
        
        return result;
    }
    
private:
    std::string padWithZeros(int num) {
        std::string str = std::to_string(num);
        while (str.length() < 4) {
            str = '0' + str;
        }
        return str;
    }
};