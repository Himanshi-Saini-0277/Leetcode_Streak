class Solution {

  private static class Segment implements Comparable<Segment> {
      int index;
      long value;
      long mergeCost;
      Segment left;
      Segment right;

      Segment(int idx, long val) {
          index = idx;
          value = val;
      }

      @Override
      public int compareTo(Segment o) {
          if (right == null || o.right == null) {
              return right == null ? 1 : -1;
          }
          long diff = mergeCost - o.mergeCost;
          if (diff != 0) return diff < 0 ? -1 : 1;
          return index - o.index;
      }
  }

  public int minimumPairRemoval(int[] nums) {
      TreeSet<Segment> heap = new TreeSet<>();
      int violations = 0;

      Segment current = null;

      for (int i = 0; i < nums.length; i++) {
          Segment node = new Segment(i, nums[i]);

          if (current != null) {
              if (node.value < current.value) violations++;

              current.right = node;
              node.left = current;

              current.mergeCost = current.value + node.value;
              heap.add(current);
          }
          current = node;
      }

      heap.add(current);

      int operations = 0;

      while (violations > 0) {
          operations++;

          Segment best = heap.pollFirst();
          Segment next = best.right;

          if (next.value < best.value) violations--;

          best.value += next.value;
          best.mergeCost = best.value + (next.right != null ? next.right.value : 0);

          best.right = next.right;
          if (next.right != null) {
              if (next.right.value < next.value) violations--;
              next.right.left = best;
              if (best.value > next.right.value) violations++;
          }

          heap.remove(next);
          heap.add(best);

          Segment prev = best.left;
          if (prev != null) {
              heap.remove(prev);

              if (prev.value > prev.mergeCost - prev.value) violations--;
              if (prev.value > best.value) violations++;

              prev.mergeCost = prev.value + best.value;
              prev.right = best;

              heap.add(prev);
          }
      }

      return operations;
  }
}