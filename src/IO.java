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

    public static String readPlayer() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    public static int readColumn() throws Exception{    //error with Integer.parseInt(String.valueOf(System.in.read())); I used 4 to testing
        int out = 4;//Integer.parseInt(String.valueOf(System.in.read()));
       // System.in.read();
        return out;
    }

    public static void printMap(char[][] map, String[] player){
        printMapHead();
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
        printMapHead();
        System.out.println();
        curPlayer(player);
    }

    public static void win(String player) {
        System.out.println(player + "has won!\n");
    }

    public static void errorMessage() {
        System.out.println("Invalid turn! PLease enter a number between 1 and 8 next time!\n");
    }

    public static void tieGame() {
        System.out.println("All stones (21) were used! It's a tie!");
    }

    private static void curPlayer(String[] player) {
        System.out.println();
        System.out.println(player[0] + " it's your turn! Choose a column to insert your coin (" + player[1] + ").");
    }
}
