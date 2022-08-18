package chapter4;

//Kormen ex.4.1.5
public class FindMaximumSubarray3 {
    //{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    public void run(int[] a){
        int imaxleft=0;
        int imaxright=0;
        int maxsum = a[0];

        int icurrentleft=0;
        int icurrentright=0;
        int currentsum=a[0];

        //можно создать вспомогательную структуру данных, чтобы хранить в ней двумерный массив с данными

        for(int i = 1; i < a.length; i++){
            if(currentsum > maxsum){
                imaxleft = icurrentleft;
                imaxright = icurrentright;
                maxsum = currentsum;
            }
            currentsum += a[i];

        }

    }
}
