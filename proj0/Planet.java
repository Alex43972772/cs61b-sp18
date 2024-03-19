public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p) {
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        double r2 = dx * dx + dy * dy;
        return Math.sqrt(r2);
    }
    public double calcForceExertedBy(Planet p) {
        double G = 6.67 * 0.00000000001;
        double r = calcDistance(p);
        return G * this.mass * p.mass / (r * r);
    }
    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double r = calcDistance(p);
        double f = calcForceExertedBy(p);
        return f * dx / r;
    }
    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        double r = calcDistance(p);
        double f = calcForceExertedBy(p);
        return f * dy / r;
    }
    public double calcNetForceExertedByX(Planet[] planets){
        double nf = 0;
        for (Planet p : planets) {
            if (this.equals(p)) continue;
            nf += calcForceExertedByX(p);
        }
        return nf;
    }
    public double calcNetForceExertedByY(Planet[] planets){
        double nf = 0;
        for (Planet p : planets) {
            if (this.equals(p)) continue;
            nf += calcForceExertedByY(p);
        }
        return nf;
    }
    public void update(double dt, double fx, double fy) {
        double ax = fx / mass;
        double ay = fy / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }
}


