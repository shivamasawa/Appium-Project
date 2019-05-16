package pages;

public class exmples {
    public static void main(String[] args) {
        System.out.println("Shivam");
        int x=1;
        for(int i=0;i<4;i++) {
            for(int j=3;j>i;j--) {
                System.out.print(" ");
            }
            for(int k=0;k<=i;k++) {
                System.out.print(x++);
            }
            System.out.println();
        }
    }
}
