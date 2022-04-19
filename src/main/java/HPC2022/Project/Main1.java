package HPC2022.Project;

import HPC2022.Project.Parallel.ParallelSum;
import HPC2022.Project.Parallel.ParallelSumTask;
import HPC2022.Project.Sequential.SequentialSum;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws Exception {
        long start, end;
        double timeSequential, timeParallel;
        long resSequental, resParallel;

        ParallelSum parallelSum = new ParallelSum();

        int cores = Runtime.getRuntime().availableProcessors();

        Scanner scanner = new Scanner(new File("testcase6.txt"));
        int n = scanner.nextInt();
        long [] array = new long [n];
        int x = 0;

        while(scanner.hasNextLong())
        {
            array[x++] = scanner.nextLong();
        }

        int threshold = n/4;

        System.out.println("SEQUENTIAL SUMMING");
        System.out.println("The sum is: ");
        start = System.nanoTime();
        resSequental = new SequentialSum(array, n).calculateSum();
        end = System.nanoTime();
        timeSequential = (end-start)/1000000.0;
        System.out.println("Time used is: " + timeSequential + "milliseconds");
        System.out.println("PARALLEL SUMMING");
        start = System.nanoTime();
        //ParallelSumTask parallelSumming = new ParallelSumTask(array, 0, n, threshold);
        //ForkJoinPool pool = new ForkJoinPool();
        //pool.execute(parallelSumming);
        resParallel = parallelSum.parallelArraySum(array, threshold);
        System.out.println("The sum is: " + resParallel);
        end = System.nanoTime();
        timeParallel = (end-start)/1000000.0;
        System.out.println("time used is: " + timeParallel + "milliseconds");
        System.out.println("Speedup is: " + timeSequential/timeParallel);
        System.out.println("Efficency is: " + (timeSequential/timeParallel)/cores);
    }
}
