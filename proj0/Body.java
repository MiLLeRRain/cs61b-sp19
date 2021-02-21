public class Body {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    static final double G = 6.67e-11;


    public Body(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos=xP;
        this.yyPos=yP;
        this.xxVel=xV;
        this.yyVel=yV;
        this.mass=m;
        this.imgFileName=img;
    }

    public Body(Body b) {
        this.xxPos=b.xxPos;
        this.yyPos=b.yyPos;
        this.xxVel=b.xxVel;
        this.yyVel=b.yyVel;
        this.mass=b.mass;
        this.imgFileName=b.imgFileName;
    }

    public Double calcDistance(Body b){
        double r = Math.sqrt(Math.pow((this.xxPos-b.xxPos),2)+Math.pow((this.yyPos-b.yyPos),2));
        return r;
    }

    public Double calcForceExertedBy(Body b){
        double r = calcDistance(b);
        double f = G*this.mass*b.mass/Math.pow(r,2);
        return f;
    }
}
