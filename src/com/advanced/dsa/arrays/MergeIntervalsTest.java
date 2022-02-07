/**
 * Merge Intervals
 *
 * Problem Description
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 *
 *
 * Problem Constraints
 *
 * 0 <= |intervals| <= 105
 *
 *
 *
 * Input Format
 *
 * First argument is the vector of intervals
 *
 * second argument is the new interval to be merged
 *
 *
 *
 * Output Format
 *
 * Return the vector of intervals after merging
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 * Input 2:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [ [1, 5], [6, 9] ]
 * Output 2:
 *
 *  [ [1, 9] ]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * (2,5) does not completely merge the given intervals
 * Explanation 2:
 *
 * (2,6) completely merges the given intervals
 *
 */
package com.advanced.dsa.arrays;

import java.util.ArrayList;

public class MergeIntervalsTest {
    public static void main(String args[]){
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(33,36));
        Interval newInterval = new Interval(8,12);
        ArrayList<Interval> result = insert(intervals,newInterval);
        int n = result.size();
        for(int i=0;i<n;i++){
            System.out.println("["+result.get(i).start+","+result.get(i).end+"]");
        }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        int n = intervals.size(),si=-1,ej=-1,fh=0,oi=0;
        boolean sFlag=false;
        Interval temp = null;
        for(int i=0;i<n;i++){
            temp = intervals.get(i);
            if(overlap(temp,newInterval)){
                oi++;
                if(!sFlag){
                    si = Math.min(temp.start,newInterval.start);
                    ej = Math.max(temp.end,newInterval.end);
                    sFlag=true;
                }else
                    ej = Math.max(temp.end,newInterval.end);
            }
            if(!sFlag && temp.start<newInterval.start)
                fh++;
        }
        if(n>0 && !sFlag && newInterval.start<intervals.get(0).start)
            fh=0;
        for(int i=0;i<fh;i++){
            result.add(intervals.get(i));
        }
        if(si>-1 && ej>-1)
            result.add(new Interval(si,ej));
        else{
            si=Math.min(newInterval.start, newInterval.end);
            ej=Math.max(newInterval.start, newInterval.end);
            result.add(new Interval(si,ej));
        }
        for(int i=fh+oi;i<n;i++){
            result.add(intervals.get(i));
        }

        return result;
    }

    private static boolean overlap(Interval temp, Interval newInterval) {
        if(!(temp.end<newInterval.start || newInterval.end<temp.start))
            return true;
        else
            return false;
    }
}
