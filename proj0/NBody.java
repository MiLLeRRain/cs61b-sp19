public class NBody {
    private static int planetsNum;
    private static double radiusUni;
    private static Body[] planets;

    public static Double readRadius(String planetsTxtPath){
        In sc = new In(planetsTxtPath);
        sc.readLine();
        radiusUni = sc.readDouble();
        sc.close();
        return radiusUni;
    }

    public static Body[] readBodies(String planetsTxtPath) {
        In sc = new In(planetsTxtPath);
        planetsNum = sc.readInt();
        sc.readLine();
        planets = new Body[planetsNum];
        sc.readLine();
        for (int i = 0; i < planetsNum; i++){
            double xxPos = sc.readDouble();
            double yyPos = sc.readDouble();
            double xxVel = sc.readDouble();
            double yyVel = sc.readDouble();
            double mass = sc.readDouble();
            String img = sc.readString();
            planets[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, img);
        }
        sc.close();
        return planets;
    }

    public static void main(String args[]){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        radiusUni = readRadius(filename);
        planets = readBodies(filename);
        StdAudio.play("./audio/2001.mid");
        redraw(radiusUni, planets);
        StdDraw.enableDoubleBuffering();
        double t = 0;
        while (t<T) {
            double[] xForces = new double[planetsNum];
            double[] yForces = new double[planetsNum];
            for (int i = 0; i < planetsNum; i++){
                xForces[i] = (planets[i].calcNetForceExertedByX(planets));
                yForces[i] = (planets[i].calcNetForceExertedByY(planets));
            }
            for (int i = 0; i < planetsNum; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            redraw(radiusUni, planets);
            StdDraw.show();
            StdDraw.pause(10);
            t+=dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radiusUni);
        for (int i = 0; i < planetsNum; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }

    private static void redraw(double radiusUni, Body[] planets) {
        drawBackground(radiusUni);
        drawBodys(planets);
    }

    private static void drawBackground(double r) {
        StdDraw.setScale(-r/1e9, r/1e9);
        StdDraw.clear();
        StdDraw.picture(0, 0, "./images/starfield.jpg");
//        StdDraw.show();
//        StdDraw.pause(2000);
    }

    private static void drawBodys(Body[] planets) {
        for (Body b : planets){
            b.draw();
        }
    }

}
