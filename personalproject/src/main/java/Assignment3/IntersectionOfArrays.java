package Assignment3;

import edu.princeton.cs.algs4.Shell;

public class IntersectionOfArrays {
    public class Point implements Comparable<Point> {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point that) {
            if (that.x > this.x) return -1;
            if (that.x < this.x) return 1;
            if (that.y > this.y) return -1;
            if (that.y < this.y) return 1;
            return 0;
        }

        public int countIntersection(Point[] a, Point[] b) {
            Shell.sort(a);
            Shell.sort(b);

            int i = 0;
            int j = 0;
            int count = 0;

            while (i < a.length && j < b.length) {
                if (a[i].compareTo(b[j]) == 0) {
                    count++;
                    i++;
                    j++;
                } else if (a[i].compareTo(b[j]) < 0) i++;
                else j++;
            }
            return count;
        }
    }
}
