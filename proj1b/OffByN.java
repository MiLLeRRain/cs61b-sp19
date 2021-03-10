public class OffByN implements CharacterComparator{
    private final int n;

    public OffByN(int i) {
        n = i;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == n;
    }
}
