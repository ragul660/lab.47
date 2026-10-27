public class OccurrenceFinder {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 20};
        int target = 20;
        int firstOccurrence = -1;
        int lastOccurrence = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                if (firstOccurrence == -1) {
                    firstOccurrence = i;
                }
                lastOccurrence = i;
            }
        }
        if (firstOccurrence != -1) {
            System.out.println("first occurrence:" + firstOccurrence);
            System.out.println("last occurance:" + lastOccurrence);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
