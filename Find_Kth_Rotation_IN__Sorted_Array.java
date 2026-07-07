class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int n=arr.length;
        int [] temp= new int [n];
        
        for(int i=0;i<n;i++){
            int newIndex=(i+k)%n;
            temp[newIndex]=arr[i];
            
        }
        for(int i=0;i<n;i++){
            arr[i]=temp[i];
        }
    }
}
