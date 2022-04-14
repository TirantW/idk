package HPC2022.Project.Parallel;

import java.util.concurrent.RecursiveAction;

public class ParallelSumTask extends RecursiveAction {

    private int start, end, threshold;
    private int[] array;
    private int amount, sum;

    public ParallelSumTask(int[] array, int start, int end, int amount, int threshold){
        this.array = array;
        this.start = start;
        this.end = end;
        this.amount = amount;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if (end-start <= threshold) {
            for (int i = start; i < end; i++) {
                this.sum += array[i];
            }
        }
        else {
            int middle = (end+start)/2;
            ParallelSumTask left = new ParallelSumTask(array, 0, middle, amount, threshold);
            ParallelSumTask right = new ParallelSumTask(array, middle+1, end, amount, threshold);
            invokeAll(left,right);

            //Compute the sum of the two sub-tasks.
            try{
                sum = left.getSum() + right.getSum();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(sum);
        }
    }

    public int getSum() {
        return sum;
    }

}

