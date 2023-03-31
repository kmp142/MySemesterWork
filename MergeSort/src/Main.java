import java.io.*;
import java.util.*;


public class Main {
    private static int iterationsCounter;
    private static long startTime;
    private static long endTime;
    public static void main(String[] args) throws IOException {
        List<Integer[]> list = readFile("File.txt", true);
        List<ArrayList<Integer>> list2 = readFile("File.txt", false);

        list.remove(0);
        list.remove(1);
        list.remove(2);

        for (Integer[] arr : list) {
            startTime = System.nanoTime();
            mergeSort(arr);
            endTime = System.nanoTime();
            System.out.println(endTime - startTime);
        }
<<<<<<< HEAD
=======


>>>>>>> 265eee5 (my first commit)
    }

    public static void mergeSort(Integer[] arr) {
        int n = arr.length;
        if (n == 1) return;
        iterationsCounter++;
        int mid = n / 2;
        Integer[] l = new Integer[mid];
        Integer[] r = new Integer[n-mid];
        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int j = mid; j < n; j++) {
            r[j-mid] = arr[j];
        }
        mergeSort(l);
        mergeSort(r);
        merge(arr, l, r);
    }

    private static void merge(Integer[] arr, Integer[] l, Integer[] r){
        int left = l.length;
        int right = r.length;
        int i = 0, j = 0, index = 0;
        while (i < left && j < right) {
            if (l[i] < r[j]) {
                arr[index] = l[i];
                i++;
            } else {
                arr[index] = r[j];
                j++;
            }
            iterationsCounter++;
            index++;
        }
        while (j < right) {
            arr[index] = r[j];
            j++;
            index++;
        }
        while (i < left) {
            arr[index] = l[i];
            i++;
            index++;
        }
    }

    public static void mergeSortForArrayList(ArrayList<Integer> arr) {
        int n = arr.size();
        if (n == 1) return;
        iterationsCounter++;
        int mid = n / 2;
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> r = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            l.add(arr.get(i));
        }
        for (int i = mid; i < n; i++) {
            r.add(arr.get(i));
        }
        mergeSortForArrayList(l);
        mergeSortForArrayList(r);
        mergeArrayList(arr, l, r);
    }

    public static void mergeArrayList(ArrayList<Integer> arr, ArrayList<Integer> l, ArrayList<Integer> r) {
        int lSize = l.size();
        int rSize = r.size();
        int i = 0, j = 0, index = 0;
        while (i < lSize && j < rSize) {
            if (l.get(i) < r.get(j)) {
                arr.set(index, l.get(i));
                i++;
            } else {
                arr.set(index, r.get(j));
                j++;
            }
            index++;
            iterationsCounter++;
        }
        while (i < lSize) {
            arr.set(index, l.get(i));
            i++;
            index++;
        }
        while (j < rSize) {
            arr.set(index, r.get(j));
            j++;
            index++;
        }
    }

    private static void fillFile() throws IOException {
    Random random = new Random();
    BufferedWriter bw = new BufferedWriter(new FileWriter("File.txt"));
    for (int i = 0; i <= random.nextInt(50,100); i++) {
        for (int j = 0; j < random.nextInt(100,10000); j++) {
            bw.write(random.nextInt() + "\n");
        }
        bw.write("^" + "\n");
    }
    bw.close();
    }


    private static List readFile(String file, Boolean isArray) throws IOException {
        Scanner scanner = new Scanner(new File(file));
        Scanner scanner2 = new Scanner(new File(file));
        List<Integer[]> listOfArrays = new ArrayList<>();
        List<ArrayList<Integer>> listOfArrayList = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        while (scanner.hasNextLine()) {
            while (scanner2.hasNextInt()) {
                arr.add(scanner2.nextInt());
                scanner.nextLine();
            }
            if (isArray) {
                listOfArrays.add(arr.toArray(new Integer[0]));
            } else {
                listOfArrayList.add(arr);
            }
            arr = new ArrayList<>();
            scanner.nextLine();
            scanner2.next();
        }
        return isArray ? listOfArrays : listOfArrayList;
    }

}


