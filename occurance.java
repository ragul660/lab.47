public class Main {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 10, 40, 20, 20, 10};
        int target = 10;
        int count = 0;
         for (int num : numbers) {
            if (num == target) {
                count++;
            }
        }
        System.out.println(target + " occurs " + count + " times");
    }
}
