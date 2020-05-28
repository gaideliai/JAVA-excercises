package pirmas;

import java.util.Scanner;

public class Pirmas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("0 - pabaiga");
        System.out.println("1 - akmuo");
        System.out.println("2 - popierius");
        System.out.println("3 - zirkles");
        int pasirinkimas = sc.nextInt();
        int kp = (int)( Math.random()*3)+1;
        do {        
            
            if (pasirinkimas > 0) {
                System.out.println(pasirinkimas);
                System.out.println(kp);
                if (pasirinkimas == kp) {
                    System.out.println("It's a tie.");
                }else if (pasirinkimas == 1 && kp == 3) {
                    System.out.println("Rock against Scissors: Congrats! You win!");
                }else if (pasirinkimas == 2 && kp == 1) {
                    System.out.println("Paper against Rock: Congrats! You win!");
                }else if (pasirinkimas == 3 && kp == 2) {
                    System.out.println("Scissors against paper: Congrats! You win!");
                }
                else {
                    System.out.println("You lose...");
                }
                pasirinkimas = sc.nextInt();
                kp = (int)(Math.random()*3)+1;
            }
        } while (pasirinkimas > 0);
        if (pasirinkimas == 0){
            System.out.println(pasirinkimas);
            System.out.println("Thanks for playing!");
        }
    }
}
