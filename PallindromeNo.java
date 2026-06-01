class PallindromeNo {
    public boolean isPalindrome(int x) {
        int revNo=0,originalNo=x;

        while(x >0){

           int temp =x%10;      //ex:121  121%10=1 -> temp=1 , 12%10=2 temp->2 , 1%10=1 temp->1
            x=x/10;              //121/10= 12 , 12/10 = 1  , 1/10 = 0
            revNo = revNo*10+temp;    //revNo=0*10+1=1  ,revNo=1*10+2=12  , revNo=0*10+1=1
        }
    return revNo==originalNo;
            
    }
}
