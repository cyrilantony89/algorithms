package cyril.train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 
 * Given arrival and departure times of all trains that reach a railway station,
 * find the minimum number of platforms required for the railway station so that no train waits.
 * We are given two arrays which represent arrival and departure times of trains that stop
 * 
 * Examples:
 * 
 * Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
 * dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 * Output: 3
 * There are at-most three trains at a time (time between 11:00 to 11:20)
 * 
 */
public class TrainPlatform {

    enum EventEnum {
        ARR(1),
        DEP(-1);
        private int value;

        private EventEnum(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        List<Train> l = new ArrayList<>();
        l.add(new Train("A", 9.24f, 12.15f));
        l.add(new Train("B", 11.24f, 12.5f));
        l.add(new Train("C", 12.04f, 14.15f));
        l.add(new Train("D", 15.24f, 17.15f));
        l.add(new Train("E", 16.24f, 18.15f));
        l.add(new Train("F", 12.04f, 14.15f));
        int s = calculateNumPlatform(l);
        System.out.println(s);
    }

    static class TrainEvent {
        float     t;
        EventEnum e;

        public TrainEvent(float time, EventEnum event) {
            t = time;
            e = event;
        }
    }

    private static int calculateNumPlatform(List<Train> l) {
        List<TrainEvent> trEvents = getAllEventsSorted(l);
        int max = 0;
        int sum = 0;
        for (TrainEvent trEvent : trEvents) {
            sum += trEvent.e.value;
            max = Math.max(max, sum);
        }
        return max;
    }

    private static List<TrainEvent> getAllEventsSorted(List<Train> trains) {
        List<TrainEvent> events = new ArrayList<TrainEvent>();
        for (Train train : trains) {
            TrainEvent eA = new TrainEvent(train.arr, EventEnum.ARR);
            events.add(eA);
            TrainEvent eD = new TrainEvent(train.dep, EventEnum.DEP);
            events.add(eD);
        }

        Collections.sort(events, new Comparator<TrainEvent>() {
            @Override
            public int compare(TrainEvent o1, TrainEvent o2) {
                return (o1.t > o2.t ? 1 : -1);
            }
        });
        return events;
    }

    static class Train {

        String name;
        float  arr;
        float  dep;

        public Train(String na, float a, float d) {
            name = na;
            arr = a;
            dep = d;
        }
    }

}