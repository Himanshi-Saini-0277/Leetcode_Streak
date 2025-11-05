import java.util.*;

class Solution {
    private static final class Entry {
        final int f;  
        final int v;  
        Entry(int f, int v) { this.f = f; this.v = v; }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Entry)) return false;
            Entry e = (Entry) o;
            return f == e.f && v == e.v;
        }
        @Override public int hashCode() { return Objects.hash(f, v); }
    }

    private final Comparator<Entry> byFreqDescValDesc = (a, b) -> {
        if (a.f != b.f) return Integer.compare(b.f, a.f);
        return Integer.compare(b.v, a.v);
    };

    private Map<Integer, Integer> freq;
    private TreeSet<Entry> top, rest;
    private long currSum;

    private void insertVal(int v, int x) {
        int f = freq.getOrDefault(v, 0);

        if (f > 0) {
            Entry old = new Entry(f, v);
            if (top.remove(old)) {
                currSum -= 1L * f * v;
            } else {
                rest.remove(old);
            }
        }

        f += 1;
        freq.put(v, f);
        Entry now = new Entry(f, v);
        top.add(now);
        currSum += 1L * f * v;

        if (top.size() > x) {
            Entry smallestTop = top.last();
            currSum -= 1L * smallestTop.f * smallestTop.v;
            rest.add(smallestTop);
            top.remove(smallestTop);
        }
    }

    private void eraseVal(int v, int x) {
        Integer cur = freq.get(v);
        if (cur == null || cur == 0) return;
        int f = cur;

        Entry curEntry = new Entry(f, v);
        if (top.remove(curEntry)) {
            currSum -= 1L * f * v;
        } else {
            rest.remove(curEntry);
        }

        f -= 1;
        if (f == 0) {
            freq.remove(v);
        } else {
            freq.put(v, f);
            rest.add(new Entry(f, v));
        }

        if (top.size() < x && !rest.isEmpty()) {
            Entry bestRest = rest.first();
            rest.remove(bestRest);
            top.add(bestRest);
            currSum += 1L * bestRest.f * bestRest.v;
        }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int sz = n - k + 1;
        long[] ans = new long[sz];

        freq = new HashMap<>(Math.max(16, n * 2));
        top = new TreeSet<>(byFreqDescValDesc);
        rest = new TreeSet<>(byFreqDescValDesc);
        currSum = 0L;

        for (int i = 0; i < k; i++) insertVal(nums[i], x);
        ans[0] = currSum;

        for (int l = 1, r = k; r < n; l++, r++) {
            eraseVal(nums[l - 1], x);
            insertVal(nums[r], x);
            ans[l] = currSum;
        }
        return ans;
    }
}