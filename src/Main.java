//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Method to perform Karatsuba multiplication
    public static long karatsubaMultiply(long x, long y) {
        // Base case: if either number is small, use standard multiplication
        if (x < 10 || y < 10) {
            return x * y;
        }

        // Determine the length of the numbers
        int length = Math.max(Long.toString(x).length(), Long.toString(y).length());
        int halfLength = length / 2;

        // Split the numbers into two halves
        long max1 = x / (long) Math.pow(10, halfLength);
        long min1 = x % (long) Math.pow(10, halfLength);
        long max2 = y / (long) Math.pow(10, halfLength);
        long min2 = y % (long) Math.pow(10, halfLength);


        // Compute ac = max1 * max2
        long ac = karatsubaMultiply(max1, max2);

        // Compute bd = min1 * min2
        long bd = karatsubaMultiply(min1, min2);

        // Compute (a+b)(c+d) - ac - bd
        long ab_cd = karatsubaMultiply(max1 + min1, max2 + min2) - ac - bd;

        // Combine the results
        return (ac * (long) Math.pow(10, 2 * halfLength)) + (ab_cd * (long) Math.pow(10, halfLength)) + bd;
    }
    public static void main(String[] args) {

        long num1 = 123456789;
        long num2 = 123;

        long result = karatsubaMultiply(num1, num2);

        System.out.println("Product of " + num1 + " and " + num2 + " is " + result);
    }
}