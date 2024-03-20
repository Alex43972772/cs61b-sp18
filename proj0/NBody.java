

public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        int planets = in.readInt();
        return in.readDouble();
    }
    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        double radius = in.readDouble();
        Planet[] res = new Planet[n];
        for (int i = 0; i < n; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planet added = new Planet(xP, yP, xV, yV, m, img);
            res[i] = added;
        }
        return res;
    }
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);

        StdDraw.setScale(-100, 100);
        StdDraw.picture(0, 0, filename);
    }
}
