package HPC2022.Project.Parallel;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ParallelSumTask extends RecursiveAction {

    //private final int threshold = 100000001;
    private int start, end, threshold;
    private long[] array;
    private long sum;

    public ParallelSumTask(long[] array, int start, int end, int threshold){
        this.array = array;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if ((end-start) <= threshold) {
            for (int i = start; i < end; i++) {
                this.sum += array[i];
            }
        }
        else {
            int middle = (end+start)/2;
            ParallelSumTask left = new ParallelSumTask(array, 0, middle, threshold);
            ParallelSumTask right = new ParallelSumTask(array, middle, end, threshold);
            invokeAll(left,right);

            try{
                sum += left.getSum() + right.getSum();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public long getSum() {
        return sum;
    }

}

