import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class task01 {
    public static void main(String[] args) {
        int[] array = {19, 5, 2, 8, 12, 3};

        bubbleSort(array);
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;

                        swapped = true;
                    }
                }

                writer.write("Iteration " + (i + 1) + ": ");
                for (int element : array) {
                    writer.write(element + " ");
                }
                writer.newLine();

                if (!swapped) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
