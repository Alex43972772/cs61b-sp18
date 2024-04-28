public class offByN implements CharacterComparator {
    private final int N;
    public offByN(int N) {
        this.N = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return x - y == N || y - x == N;
    }
}
