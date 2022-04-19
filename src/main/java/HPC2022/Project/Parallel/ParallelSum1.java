package HPC2022.Project.Parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.ReentrantLock;

public class ParallelSum{

    public long parallelArraySum(long[] array, int threshold){
        ParallelSumTask parallelSumTask = new ParallelSumTask(array, 0, array.length, threshold);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(parallelSumTask);
        return parallelSumTask.getSum();
    }
}
