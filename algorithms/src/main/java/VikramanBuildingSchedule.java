import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VikramanBuildingSchedule {

	static Map<String, Integer> weekMap = new HashMap<>();

	static {
		weekMap.put("mon", 0);
		weekMap.put("tue", 1);
		weekMap.put("wed", 2);
		weekMap.put("thu", 3);
		weekMap.put("fri", 4);
		weekMap.put("sat", 5);
		weekMap.put("sun", 6);
	}

	static class Interval implements Comparable<Interval> {
		String week;
		Float start;
		Float end;
		Float absoluteStart;
		Float absoluteEnd;

		Interval(String week, float start, float end) {
			this.week = week;
			this.start = start;
			this.end = end;
			absoluteStart = weekMap.get(week) * 24 + start;
			absoluteEnd = weekMap.get(week) * 24 + end;
		}

		@Override
		public int compareTo(VikramanBuildingSchedule.Interval o) {
			int s = weekMap.get(this.week).compareTo(weekMap.get(o.week));
			if (s != 0) {
				return s;
			}
			s = this.start.compareTo(o.start);
			if (s != 0) {
				return s;
			}
			s = this.end.compareTo(o.end);
			if (s != 0) {
				return s;
			}
			return 0;
		}

		@Override
		public String toString() {
			return "{" + week + ":" + this.start + "-" + this.end + "}";
		}

		public boolean contains(VikramanBuildingSchedule.Interval interval) {
			return weekMap.get(this.week).equals(weekMap.get(interval.week)) && this.start <= interval.start
					&& this.end >= interval.end;
		}

		public boolean later(VikramanBuildingSchedule.Interval interval) {
			return weekMap.get(this.week) > weekMap.get(interval.week)
					|| (weekMap.get(this.week) == weekMap.get(interval.week) && this.start > interval.start);
		}

	}

	static int cnt = 0;

	public static void main(String[] args) {

		List<Interval> given = new ArrayList<>();

		given.add(new Interval("mon", 10, 12));
		given.add(new Interval("mon", 13, 17));
		given.add(new Interval("mon", 18, 20));
		given.add(new Interval("tue", 10, 12));
		given.add(new Interval("wed", 14, 16));
		given.add(new Interval("wed", 18, 20));

		Collections.sort(given);

		List<Interval> test = new ArrayList<>();

		test.add(new Interval("mon", 10, 12));
		test.add(new Interval("mon", 12, 15));
		test.add(new Interval("mon", 18, 21));
		test.add(new Interval("fri", 10, 12));
		test.add(new Interval("wed", 14, 16));
		test.add(new Interval("thu", 18, 20));

		for (Interval interval : test) {
			testContains(interval, given);

		}

	}

	private static boolean testContains(VikramanBuildingSchedule.Interval interval,
			List<VikramanBuildingSchedule.Interval> givenL) {

		for (Interval given : givenL) {
			if (given.later(interval)) {
				return false;
			}

			// This is O(n)
			if (given.contains(interval)) {
				return true;
			}
		}

		return false;
	}

}
