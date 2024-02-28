import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        for(int i = 1; i<=10 ; i++){
            Process.outPut(String.valueOf(word),i);
        }

    }
}