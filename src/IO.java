import java.io.*;

public final class IO {
    public static void printStartText() {
        System.out.println("Welcome to Collect4!");
        System.out.println("Please take some time to read the rules and this brief description.");
        System.out.println("Rules:");
        System.out.println("In order to start playing, please enter your names.");
    }

    public static void printMapHead() {
        System.out.println("12345678");
    }

    public static String readPlayer(){
        String out = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            out = bufferedReader.readLine();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return out;
    }

    public static int readColumn(){
        int out = -1;
        try {
            out = System.in.read() - 49;
            System.in.read();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return out;
    }

    public static void printMap(char[][] map){
        System.out.println();
        printMapHead();
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
        printMapHead();
    }

    public static void win(String player) {
        System.out.println(player + " has won!");
        System.out.println();
    }

    public static void errorOutOfBounds() {
        System.out.println("Invalid turn! PLease enter a number between 1 and 8 next time!");
        System.out.println("Next player!");
        System.out.println();
    }

    public static void errorStackOverflow() {
        System.out.println("Current stack already full! Your coin has been removed.");
        System.out.println("Next player!");
        System.out.println();
    }

    public static void tieGame() {
        System.out.println("All stones (21) were used! It's a tie!");
    }

    public static void nextPlayer(String[] player) {
        System.out.println();
        System.out.println(player[0] + " it's your turn! Choose a column to insert your coin (" + player[1] + ").");
    }
}
