package Assignment4;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {
        ArrayList<LineSegment> foundSegments = new ArrayList<LineSegment>();
        checkDuplicatedEntries(points);
        Arrays.sort(points);

        for (int p = 0; p < points.length - 3; p++) {
            for (int q = p + 1; q < points.length - 2; q++) {
                for (int r = q + 1; r < points.length - 1; r++) {
                    for (int s = r + 1; s < points.length; s++) {
                        if (points[p].slopeTo(points[q]) == points[p].slopeTo(points[r]) &&
                                points[p].slopeTo(points[q]) == points[p].slopeTo(points[s])) {
                            foundSegments.add(new LineSegment(points[p], points[s]));
                        }
                    }
                }
            }
        }

        segments = foundSegments.toArray(new LineSegment[0]);
    }

    // finds all line segments containing 4 points
    public int numberOfSegments()  {
        return segments.length;

    }

    // the number of line segments
    public LineSegment[] segments() {
        return segments;
    }

    private void checkDuplicatedEntries(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Duplicated entries in given points.");
                }
            }
        }
    }
}
