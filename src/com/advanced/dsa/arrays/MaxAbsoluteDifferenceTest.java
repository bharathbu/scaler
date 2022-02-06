/**
 * Maximum Absolute Difference
 *
 * Problem Description
 *
 * You are given an array of N integers, A1, A2, …. AN.
 *
 * Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 100000
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the maximum value of f(i, j).
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 3, -1]
 * Input 2:
 *
 *
 * A = [2]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 5
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * f(1, 1) = f(2, 2) = f(3, 3) = 0
 * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 *
 * So, we return 5.
 * Explanation 2:
 *
 * Only possibility is i = 1 and j = 1. That gives answer = 0.
 *
 */
package com.advanced.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxAbsoluteDifferenceTest {
    public static void main(String args[]) {
        int[] ints = {699, 2, 690, 936, 319, 784, 562, 35, 151, 698, 126, 730, 587, 157, 201, 761, 956,
                359, 198, 986, 915, 7, 703, 324, 814, 382, 294, 204, 120, 731, 615, 330, 486, 52,
                223, 376, 649, 458, 564, 971, 72, 605, 177, 20, 461, 790, 872, 363, 916, 435, 991,
                184, 410, 320, 16, 480, 768, 801, 117, 338, 650, 786, 17, 369, 979, 304, 445, 688,
                862, 229, 311, 351, 985, 697, 135, 299, 310, 3, 643, 221, 831, 196, 887, 679, 484,
                209, 824, 292, 588, 721, 140, 675, 827, 913, 271, 170, 812, 552, 334, 860, 981,
                550, 308, 584, 442, 328, 251, 456, 976, 31, 507, 954, 982, 742, 45, 727, 794, 309,
                527, 623, 56, 843, 436, 681, 143, 130, 689, 870, 362, 580, 560, 474, 385, 525, 881,
                51, 890, 917, 820, 826, 139, 443, 978, 144, 512, 205, 682, 188, 344, 429, 497, 181,
                749, 864, 664, 145, 621, 629, 886, 572, 89, 725, 945, 29, 553, 977, 783, 590, 236,
                728, 125, 90, 492, 261, 543, 259, 662, 622, 285, 392, 561, 670, 200, 504, 246, 513,
                910, 583, 460, 179, 207, 709, 127, 926, 816, 426, 520, 174, 464, 883, 780, 5, 268,
                606, 1, 109, 704, 391, 661, 924, 516, 241, 477, 952, 405, 522, 247, 335, 356, 839,
                423, 779, 4, 43, 720, 238, 965, 951, 914, 10, 496, 775, 651, 788, 373, 491, 746, 799,
                518, 93, 86, 774, 652, 955, 494, 252, 781, 946, 412, 202, 741, 719, 612, 673, 896, 1000,
                289, 554, 69, 424, 980, 506, 593, 889, 25, 959, 28, 736, 8, 969, 865, 657, 567, 434, 9, 167,
                357, 929, 645, 250, 565, 94, 928, 473, 509, 823, 313, 762, -1, 208, 903, 922, 655, 948, 326,
                485, 150, 73, 505, 225, 122, 129, 648, 838, 811, 972, 735, 78, 428, 740, 782, 632, 316, 440, 737,
                297, 873, 281, 479, 654, 0, 633, 212, 152, 154, 470, 866, 79, 722, 958, 732, 900, 832, 278, 58, 842,
                745, 540, 169, 347, 592, 438, 882, 462, 53, 34, 519, 489, 85, 757, 919, 701, 15, 211, 667, 637, 74,
                573, 240, 559, -2, 472, 203, 112, 162, 776, -4, 155, 837, 99, 98, 64, 101, 983, 366, 853, 970, 482, 40,
                921, 374, 758, 413, 339, 705, 771, 360, 734, 282, 219, 766, 535, 133, 532, 254};
        ArrayList<Integer> A = (ArrayList<Integer>) Arrays.stream(ints).boxed().collect(Collectors.toList());
        //A.add(2);A.add(3);A.add(1);A.add(2);
        //A.add(10);A.add(-1);A.add(2);A.add(3);A.add(-4);A.add(100);
        //A.add(1);A.add(2);A.add(5);A.add(-9);
        /*A.add(10);A.add(-1);A.add(1);A.add(3);A.add(9);A.add(11);
        A.add(9);A.add(-5);A.add(6);A.add(7);A.add(-4);A.add(100);*/
        System.out.println(maxArr(A));
    }

    public static int maxArr(ArrayList<Integer> A) {
        int result=0;

        return result;
    }
}
