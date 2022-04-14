package HPC2022.Project.Sequential;

import java.io.File;
import java.util.Scanner;

public class SequentialSum {
    private int[] array;
    private int amount;
    int sum = 0;

        public SequentialSum(int[] array, int amount){
            this.array = array;
            this.amount = amount;
        }
    public int calculateSum(){
        for (int i = 0; i < amount; i++) {
            sum+=array[i];
        }
        System.out.println(sum);
        return sum;

    }


}
