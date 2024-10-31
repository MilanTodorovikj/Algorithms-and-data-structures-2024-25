package Aud03;

public class BruteForcePoints {

    int INF = 1000000;

    double min(double a, double b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    double distance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    double smallestDistance(Point p[], int n) {
        int i, j;
        double best = INF;

        for (i = 0; i < (n - 1); i++) {
            for (j = i + 1; j < n; j++) {
                best = min(best, distance(p[i], p[j]));
            }
        }

        return best;
    }

    public static void main(String[] args) {

        BruteForcePoints bf = new BruteForcePoints();

        Point a[] = new Point[10];

        a[0] = new Point(4, 5.5);
        a[1] = new Point(1.2, 12.3);
        a[2] = new Point(7.9, 9.8);
        a[3] = new Point(4.3, 5.5);
        a[4] = new Point(-9.9, 8.2);
        a[5] = new Point(1.2, 3);
        a[6] = new Point(9, 2.4);
        a[7] = new Point(2, 9.2);
        a[8] = new Point(1, 5.6);
        a[9] = new Point(2, 7);

        System.out.println("Smallest distance: " + bf.smallestDistance(a, 10));

    }

}
