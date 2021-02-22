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
    }
}
