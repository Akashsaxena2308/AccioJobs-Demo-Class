public class TypePromotions {
    static void showDuration(long number) {
        System.out.println("long");
    }

    static void showDuration(double number) {
        System.out.println("double");
    }

    // Uncomment to show that an exact int match takes priority over widening.
    // static void showDuration(int number) {
    //     System.out.println("int");
    // }

    public static void main(String[] args) {
        // byte -> short -> int -> long -> float -> double
        // char -> int -> long -> float -> double
        // boolean has no numeric widening conversion.
        byte small = 3;
        char letter = 'A';
        showDuration(small);  // long
        showDuration(letter); // long
        showDuration(3);      // long, unless the int overload is uncommented
        showDuration(3.5);    // double
    }
}
