class Solution(object):
    def maxFreqSum(self, s):
        """
        :type s: str
        :rtype: int
        """
        from collections import Counter

        vowels = set('aeiou')
        freq = Counter(s)

        vowel_freqs = [freq[c] for c in vowels if c in freq]
        consonant_freqs = [freq[c] for c in freq if c not in vowels]

        max_vowel = max(vowel_freqs) if vowel_freqs else 0
        max_consonant = max(consonant_freqs) if consonant_freqs else 0

        return max_vowel + max_consonant
