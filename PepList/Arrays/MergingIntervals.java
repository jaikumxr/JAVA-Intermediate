import java.util.ArrayList;
import java.util.Arrays;

class MergingIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        // Sort array wrt starting time of intervals
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        ArrayList<int[]> res = new ArrayList<>();// *
        int[] curInt = intervals[0];

        for (int[] interval : intervals) {
            int cbeg = curInt[0];
            int cend = curInt[1];
            int nbeg = interval[0];
            int nend = interval[1];

            if (cend >= nbeg) {
                curInt[1] = Math.max(nend, cend);
            } else {
                res.add(curInt);
                curInt = interval;
            }

        }

//check if res is empty or last element of res if different than curInt

        if ((res.size() > 0 && curInt[0] != res.get(res.size() - 1)[0]) || res.size() == 0) {
            res.add(curInt);
        }
        return res.toArray(new int[res.size()][]);// *
    }
}

// * very important. do remember in future!!
// if you don't know the size of the resulting array and the output is to be in
// int[],
// use ArrayList and then return arr.toArray(new int[arr.size()]);