public class  {

    public static void traverse(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2};
        traverse(arr);
    }
}