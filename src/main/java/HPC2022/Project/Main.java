package HPC2022.Project;

import HPC2022.Project.Parallel.ParallelSum;
import HPC2022.Project.Sequential.SequentialSum;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        long start, end;
        double timeSequential, timeParallel;
        int resSequental, resParallel;

        ParallelSum parallelSum = new ParallelSum();

        int cores = Runtime.getRuntime().availableProcessors();

        Scanner scanner = new Scanner(new File("input.txt"));
        int n = scanner.nextInt();
        int [] array = new int [n];
        int x = 0;

        while(scanner.hasNextInt())
        {
            array[x++] = scanner.nextInt();
        }

        int threshold = (array.length/cores);

        System.out.println("SEQUENTIAL SUMMING");
        System.out.println("The sum is: ");
        start = System.nanoTime();
        resSequental = new SequentialSum(array, n).calculateSum();
        end = System.nanoTime();
        timeSequential = (end-start)/1000000.0;
        System.out.println("Time used is: " + timeSequential + "milliseconds");
        System.out.println("PARALLEL SUMMING");
        System.out.println("The sum is: ");
        start = System.nanoTime();
        resParallel = parallelSum.parallelArraySum(array, n, threshold);
        end = System.nanoTime();
        timeParallel = (end-start)/1000000.0;
        System.out.println("time used is: " + timeParallel + "milliseconds");


    }
}
