import es.datastructur.synthesizer.GuitarString;

public class GuitarHero {

    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static GuitarString[] strings;

    public static void main(String[] args) {
        GuitarHero test = new GuitarHero();
        test.initialize();

        while (true) {

            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int keyIndex = keyboard.indexOf(key);
                if (keyIndex >= 0 && keyIndex < 37) {
                    strings[keyIndex].pluck();
                }
            }

            double sample = test.sample();

            StdAudio.play(sample);

            test.tic();

        }
    }

    private void initialize() {
        strings = new GuitarString[37];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new GuitarString(1760.0 * Math.pow(2.0, (i - 24.0) / 12.0));
        }
    }

    private void tic() {
        for (int i = 0; i < strings.length; i++) {
                strings[i].tic();
        }
    }

    private double sample() {
        double sum = 0.0f;
        for (int i = 0; i < strings.length; i++) {
            sum += strings[i].sample();
        }
        return sum;
    }

}
