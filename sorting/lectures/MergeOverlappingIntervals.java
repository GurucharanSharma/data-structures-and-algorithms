package sorting.lectures;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <strong>NOTE:</strong> Here overlapping does not necessarily mean coinciding.
 */
public class MergeOverlappingIntervals {

  public static void main(String[] args) {

    Interval[] intervals = {new Interval(5, 10), new Interval(3, 15), new Interval(18, 30), new Interval(2, 7)};
    int index = mergeIntervals(intervals);
    for (int i = 0; i <= index; i++) {
      System.out.println(intervals[i]);
    }
  }

  private static int mergeIntervals(Interval[] intervals) {
    Arrays.sort(intervals, new IntevalComparator());

    int res = 0;
    for (int i = 1; i < intervals.length; i++) {
      // This if condition checks if the current interval (intervals[i]) overlaps with the interval at intervals[res]
      // (the most recent merged interval). Overlapping occurs when the start time of the current interval is less
      // than or equal to the end time of the interval at res.
      if (intervals[i].startTime <= intervals[res].endTime) {
        intervals[res].startTime = Math.min(intervals[i].startTime, intervals[res].startTime);
        intervals[res].endTime = Math.max(intervals[i].endTime, intervals[res].endTime);
      } else {
        res++;
        intervals[res] = intervals[i];
      }
    }

    return res;
  }

}

class Interval {

  int startTime;
  int endTime;

  public Interval(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  @Override
  public String toString() {
    return "Interval{" + "startTime=" + startTime + ", endTime=" + endTime + '}';
  }
}

class IntevalComparator implements Comparator<Interval> {

  @Override
  public int compare(Interval o1, Interval o2) {
    return o1.startTime - o2.startTime;
  }

  @Override
  public Comparator<Interval> reversed() {
    return Comparator.super.reversed();
  }
}