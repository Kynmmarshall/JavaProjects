public class neww {
    public static void main(String[] args){
        int a[][]={{1,3,4},{1,2,3},{6,7,8}};
        System.out.println(a[0][2]);
        for(int i=0;i<3;i++){
            for(int j=0; j<3;j++){
                System.out.print(" "+a[i][j]+" ");
            }
            System.out.println("  ");
        }
    }
}
