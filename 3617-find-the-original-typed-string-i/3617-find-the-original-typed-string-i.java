class Solution {
  public int possibleStringCount(String word) {
    int ans = 1;
    int count = 1;
    char last = word.charAt(0);

    for (int i = 1; i < word.length(); i++) {
      if (word.charAt(i) != last) {
        ans += count - 1;
        count = 1;
        last = word.charAt(i);
      } else {
        count++;
      }
    }
    ans += count - 1;
    return ans;
  }
}