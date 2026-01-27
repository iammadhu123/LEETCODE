import java.util.HashSet;
import java.util.Set;

class SolutionThree {
    public static int minAllOneMultiple(int k) {
        int tandorvexi = k;

        Set<Integer> seen = new HashSet<>();
        int remainder = 1 % k;
        int length = 1;

        while (remainder != 0) {
            if (seen.contains(remainder)) {
                return -1; 
            }
            seen.add(remainder);

            remainder = (remainder * 10 + 1) % k;
            length++;
        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println(minAllOneMultiple(3));
        System.out.println(minAllOneMultiple(7)); 
        System.out.println(minAllOneMultiple(2)); 
    }
}