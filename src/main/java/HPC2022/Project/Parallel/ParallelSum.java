package HPC2022.Project.Parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.ReentrantLock;

public class ParallelSum{

    public int parallelArraySum(int[] array, int amount, int threshold){
        ParallelSumTask parallelSumTask = new ParallelSumTask(array, 0, array.length, amount, threshold);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(parallelSumTask);
        return parallelSumTask.getSum();
    }
}
