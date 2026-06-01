class ReverseNo {
    public int reverse(int x) {

        int revNo=0;
        while(x!=0){      

            int rem = x % 10;                //get last digit one by one as remainder -> rem   ex 123-> 123%10 -> rem =3 || 12%10=2(rem) || 1%10=1
            revNo = revNo*10 +rem;           //revNo = 0*10 + 3 = 3 | 3*10+2=32 || 32*10+1 = 321
            x = x/10;                        //Remove last digit from original number    123=123/10 -> 12  | 12/10=1 
        
        }
        return revNo;
 

    }
}
/*Time Complexity:
O(log n)
(Because loop runs once per digit)

Space Complexity:
O(1)
(Uses constant extra memory)*/
