class Solution(object):
    def stringHash(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        n = len(s)
        result = []

        for i in range(0, n, k):
            substring = s[i:i+k]
            hash_value = 0
            
            for char in substring:
                hash_value += ord(char) - ord('a')
            
            hashed_char = chr((hash_value % 26) + ord('a'))
            result.append(hashed_char)
        
        return ''.join(result)