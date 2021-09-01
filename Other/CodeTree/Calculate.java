import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("입력:");
        int n = scan.nextInt();
        String oper = "*";
        String blank = " ";
        System.out.println("출력:");
        for(int i=0; i<n-1; i++){
            
            System.out.println(blank.repeat((n-1)-i)+oper.repeat((2*i)+1)+blank.repeat((n-1)-i));

        }
        System.out.println(oper.repeat(2*(n-1)+1));
        for(int i=n-2; i>=0; i--) {
            System.out.println(blank.repeat((n-1)-i)+oper.repeat((2*i)+1)+blank.repeat((n-1)-i));
        }
    }
}