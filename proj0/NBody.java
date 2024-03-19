public class NBody {
    public double readRadius(String filename) {
        In in = new In(filename);
        return in.readDouble();
    }
}
