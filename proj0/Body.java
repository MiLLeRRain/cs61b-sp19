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

    //Fx=F⋅dx/r
    public Double calcForceExertedByX(Body b){
        double r = calcDistance(b);
        double f = calcForceExertedBy(b);
        double dx = b.xxPos - this.xxPos;
        double fx = f*dx/r;
        return fx;
    }

    public Double calcForceExertedByY(Body b){
        double r = calcDistance(b);
        double f = calcForceExertedBy(b);
        double dy = b.yyPos - this.yyPos;
        double fy = f*dy/r;
        return fy;
    }

    public Double calcNetForceExertedByX(Body[] bs){
        double fnx = 0;
        for (Body b : bs){
            if (!b.equals(this)) fnx += calcForceExertedByX(b);
        }
        return fnx;
    }

    public Double calcNetForceExertedByY(Body[] bs){
        double fny = 0;
        for (Body b : bs){
            if (!b.equals(this)) fny += calcForceExertedByY(b);
        }
        return fny;
    }
    public void update(double dt, double fnx, double fny){
        double ax = fnx/this.mass;
        double ay = fny/this.mass;
        xxVel += dt*ax;
        yyVel += dt*ay;
        xxPos += dt*xxVel;
        yyPos += dt*yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos/1e9, yyPos/1e9, "./images/"+imgFileName);
        StdDraw.show();
    }

}
