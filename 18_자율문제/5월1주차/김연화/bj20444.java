import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        long n = sc.nextInt();
        long k = sc.nextLong();
 
        long left = 0;
        long right = n / 2;
        while(left <= right) {
            long row = (left + right) / 2;
            long col = n - row;
 
            long total = cut_paper(row, col);
            if(total == k) {
                System.out.println("YES");
                return;
            } else if(total > k) { //row col의 차이가 더 커야한다.
                right = row - 1;
            } else if (total < k){
                left = row + 1;
            }  
        }
        System.out.println("NO");
    }
 
    public static long cut_paper(long row, long col) {
        return (row + 1) * (col + 1);
    }
}
