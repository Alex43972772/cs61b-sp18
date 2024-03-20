

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
        int n = planets.length;
        double radius = readRadius(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet p : planets) p.draw();

        StdDraw.enableDoubleBuffering();

        double time = 0.0;
        while (time <= T){
            double[] xForces = new double[n];
            double[] yForces = new double[n];
            for (int i = 0; i < n; i++) {
                Planet p = planets[i];
                xForces[i] = p.calcNetForceExertedByX(planets);
                yForces[i] = p.calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < n; i++) {
                Planet p = planets[i];
                p.update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : planets) p.draw();
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }
}
