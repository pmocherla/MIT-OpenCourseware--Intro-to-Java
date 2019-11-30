/*
 * MIT Open Courseware
 * Intro to Programming in Java
 *
 * Assignment 3: Marathon
 * Sort lists of ints from smallest to largest
 *
 * Assignments can be found at the following link:
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/index.htm
 */

public class Marathon {

    public static void main(String[] arguments) {
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275,
                       243, 334, 412, 393, 299, 343, 317, 265};

        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
                "Aaron", "Kate"};

        int[] sorted = new int[times.length];
        sorted = bubbleSort(times);

        for (int i : sorted){
            System.out.println(names[i] + ": " + times[i]);
        }

        //long startTime = System.nanoTime();

        //long stopTime = System.nanoTime();
        //long elapsedTime = stopTime - startTime;
        //System.out.println("Bubble sort: " + (double) elapsedTime/10e9 + "s");

//        startTime = System.nanoTime();
//        selectionSort(times);
//        stopTime = System.nanoTime();
//        elapsedTime = stopTime - startTime;
//        System.out.println("Selection sort: " + (double) elapsedTime/10e9 + "s");

    }

    //bubble sort algorithm
    public static int[] bubbleSort(int[] times) {
        int swapCounter = 8;
        int numTimes = times.length;
        int temp;

        int[] indArray = new int [numTimes];
        for (int m =0; m < numTimes; m++){
            indArray[m] = m;
        }

        int[] tmpArray = new int[numTimes];
        for (int m =0; m < numTimes; m++){
            tmpArray[m] = times[m];
        }

        while (swapCounter != 0) {
            swapCounter = 0;

            for (int i = 1; i < numTimes; i++) {
                if (tmpArray[i-1] > tmpArray[i]) {
                        temp = tmpArray[i-1];
                        tmpArray[i-1] = tmpArray[i];
                        tmpArray[i] = temp;

                        temp = indArray[i-1];
                        indArray[i-1] = indArray[i];
                        indArray[i] = temp;

                        System.out.println(i);
                        swapCounter++;
                }
            }

        }
        for (int k = 0; k < numTimes; k++){
            System.out.print(""+indArray[k] +" ");
        }
        System.out.println();

        return indArray;
    }

    //Selection sort algorithm
    public static void selectionSort(int[] times) {
        int numTimes = times.length;
        int min = 0;
        int minInd = 0;

        int[] tmpArray = new int[numTimes];
        for (int m =0; m < numTimes; m++){
            tmpArray[m] = times[m];
        }

        for (int j = 0; j < numTimes; j++) {
            minInd = j;
            for (int i = j; i < numTimes; i++) {
                if (tmpArray[minInd] > tmpArray[i]) {
                    minInd = i;
                }
            }

            int temp = tmpArray[j];
            tmpArray[j] = tmpArray[minInd];
            tmpArray[minInd] = temp;

        }
        for (int k = 0; k < numTimes; k++) {
            System.out.print(""+tmpArray[k] +" ");
        }
        System.out.println();
    }

}
