public class TestBody {
    public static void main(String[] args) {
        checkUpdate();
    }

    private static void checkUpdate() {
        System.out.println("Checking update...");

        Body b1 = new Body(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Body b2 = new Body(4.0, 5.0, 2.0, 6.0, 8.0, "jupiter.gif");

        System.out.println("F1: "+b1.calcForceExertedBy(b2));
        System.out.println("F2: "+b2.calcForceExertedBy(b1));

    }

}
