import java.io.*;

public final class IO {
    public static void printStartText() {
        System.out.println("Welcome to Connect4!\n");
        System.out.println("Please take some time to read the rules.\n");
        System.out.println("Rules:");
        System.out.println("To win Connect Four, all you have to do is connect four of your checker pieces in a row.");
        System.out.println("This can be done horizontally, vertically or diagonally. Each player will drop in one checker piece at a time.");
        System.out.println("This will give you a chance to either build your row, or stop your opponent from getting four in a row.");
        System.out.println("The game is over either when you or your friend reaches four in a row, or when all forty two slots are filled, ending in a tie.\n\n");
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

    //TODO: tie game testing
    public static void tieGame() {
        System.out.println("All stones (21) were used! It's a tie!");
    }

    public static void nextPlayer(String[] player) {
        System.out.println();
        System.out.println(player[0] + " it's your turn! Choose a column to insert your coin (" + player[1] + ").");
    }
}
