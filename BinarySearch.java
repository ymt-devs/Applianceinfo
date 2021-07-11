

public class BinarySearch {
//    static int index;
    static int notFound=0;
    
    // method for 
    public static String[] binary(int SearchPrice){
        int row= AppliancesInfo.getRowCount();// getting the number of rows
        int[] price = new int[row];
        price=AppliancesInfo.getPrice();// getting the price 
        MergeSorter.sort(price);// sorting the price array
        String[][] SortedData=MergeSorter.getSortedData();
        String s[]=new String[6];
        int find=SearchPrice;
        int low=0;
        int high=price.length-1;
        int index=binarySearch(price,low,high,find);
        if(index>=0){
            for(int i=0;i<6;i++){
                s[i]=SortedData[index][i]+" ";
            }
        }
        return s;
    }
    // method for searching the price
    public static int binarySearch(int price[], int low,int high,int find){
        if(low<=high){
            int mid=(low+high)/2;
            if(price[mid]==find){
                return mid;
            }else if(price[mid]<find){
                return binarySearch(price,mid+1,high,find);
            }else{
                return binarySearch(price,low,mid-1,find);
            }
        }else{
            return -1;
        }
    }
}
