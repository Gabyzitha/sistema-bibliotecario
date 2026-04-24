package Sort;

public class BubbleSort {

    public static int comparacoes = 0;

    public static String[] ordenar(String[] oldArr) {

        String[] arr = oldArr.clone();

        int n = arr.length;

        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i; j++){

                comparacoes++;

                if(arr[j].compareTo(arr[j + i]) > 0) {

                    String temp = arr[j];

                    arr[j] = arr[j + 1];

                    arr[j +1] = temp;
                }
            }
        }
        return arr;
    }
}
