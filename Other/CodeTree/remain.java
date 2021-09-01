import java.util.Scanner;
class remain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("입력:");
        int first = scan.nextInt();
        int second = scan.nextInt();
        int result = 0;
        if(first > second)  {
            int a = first;
            first = second;
            second = a;
        }
        if(first >=1 && second>=1 && first <=1000 && second <=1000) {
            
            for(int i=first; i<=second; i++) {
                int count = 0;
                for(int j=2; j<i; j++) {
                    if(i%j == 0) {
                        count++;
                    }
            
                }
                if(count==1) {
                    result +=1;
                }
            }
        }
        System.out.println("출력:\n"+result);
    }
}