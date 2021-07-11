
public class MergeSorter {
    //sortiing data
    public static void sort(int[] a) {
        if (a.length <= 1) { 
            return;
        }
        
        //declaring two new integer array of half length of the array
        int[] first = new int[a.length / 2];
        int[] second = new int[a.length - first.length];
        
        for (int i = 0; i < first.length; i++) {
            first[i] = a[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = a[first.length + i];
        }
        sort(first);
        sort(second);

        merge(first, second, a);
    }
    //merging data by ascending order
    public static void merge(int[] first, int[] second, int[] a) {
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        //As long as neither iFirst nor iSecond past the end, move
        //the smaller element into a
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                a[j] = first[iFirst];
                iFirst++;
            } else {
                a[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        while(iFirst<first.length)
        {
            a[j]=first[iFirst];
            iFirst++;
            j++;
        }
        while(iSecond<second.length)
        {
            a[j]=second[iSecond];
            iSecond++;
            j++;
        }
    }
    
    //method to sort data according to price
    public static String[][] getSortedData(){
        int row=AppliancesInfo.getRowCount(); //get total number of non empty row
        String[][] SortedData= AppliancesInfo.getTableData(); //get table data
        int[] price= AppliancesInfo.getPrice(); //gets data of price column only
        for(int i=0;i<price.length;i++){
            for(int j=0;j<price.length;j++){
                if(price[j]>price[i]){
                    //swapping data in ascending order of price
                    int a=price[i];
                    price[i]=price[j];
                    price[j]=a;
                    String b[]=SortedData[i];
                    SortedData[i]=SortedData[j];
                    SortedData[j]=b;
                }
            }
        }
        return SortedData;
    }

    //method to sort data according to price
    public static String[][] getSortedDataID(){
        int row=AppliancesInfo.getRowCount(); //get total number of non empty row
        String[][] SortedData= AppliancesInfo.getTableData(); //get table data
        int[] ID= AppliancesInfo.getID();//gets data of price product id only
        for(int i=0;i<ID.length;i++){
            for(int j=0;j<ID.length;j++){
                if(ID[j]>ID[i]){
                    //swapping data in ascending order of ID
                    int a=ID[i];
                    ID[i]=ID[j];
                    ID[j]=a;
                    String b[]=SortedData[i];
                    SortedData[i]=SortedData[j];
                    SortedData[j]=b;
                }
            }
        }
        return SortedData;
    }
}
