package HPC2022.Project.Sequential;

import java.io.File;
import java.util.Scanner;

public class SequentialSum {
    private long[] array;
    private int amount;
    long sum = 0;

        public SequentialSum(long[] array, int amount){
            this.array = array;
            this.amount = amount;
        }
    public long calculateSum(){
        for (int i = 0; i < amount; i++) {
            sum+=array[i];
        }
        System.out.println(sum);
        return sum;

    }


}
