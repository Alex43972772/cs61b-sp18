public class HelloNumber {
    public static void main(String[] args) {
        int x = 0;
        int prev = 0;
        while (x < 10){
            prev = prev + x;
            System.out.print(prev + " ");
            x = x + 1;
        }
    }
}
