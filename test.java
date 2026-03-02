class test{
 public static void main(String[] args) {
int arr[]={9,5,0,2,4};
 int i =0; int j=4; int k=0;

 while(i<4){
  k=arr[j];
  arr[j]=arr[j+1];
  arr[j+1]=k;

   while(i<j){

 j++;
   }
   j++;
 }
 System.out.println(arr[i]);
 };
};