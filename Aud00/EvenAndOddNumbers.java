package Aud00;

//Print the number of even and odd numbers as well as their average from a given input integers.

public class EvenAndOddNumbers {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0, even = 0, odd = 0;
        Double average = 0.0;

        for (int number : numbers) {
            sum += number;
            if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        int arraySize = numbers.length;

        average = ((double) sum / (double) arraySize);

        System.out.println("number of even numbers: " + even);
        System.out.println("number of odd numbers: " + odd);
        System.out.println("average:: " + average);
    }
}
