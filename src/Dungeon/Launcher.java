import java.util.Scanner;

public class Launcher 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name, Hero.");
        Game game = new Game(scanner.nextLine());
        game.getCurrentFloor().print();
        boolean isRunning = true;
        while(isRunning)
        {
            String input = scanner.nextLine();
            isRunning = game.processInput(input);
        }
        System.out.println("The game has ended.");
        scanner.close();
    }
}
