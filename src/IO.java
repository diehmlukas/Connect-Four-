import java.io.*;

public final class IO {
    public static void printStartText() {
        System.out.println("Welcome to Collect4!");
        System.out.println("Please take some time to read the rules and this brief description.");
        System.out.println("Rules:");
        System.out.println("Before you can start playing, please enter your names.");

    }

    public static void printMapHead() {
        System.out.println("12345678\n");
    }

    public String readPlayer() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    public static int readColumn() throws Exception{
        int in = Integer.parseInt(String.valueOf(System.in.read()));
        if (in >= 1 && in < 9)
            return in-1;
        else
            return -1;
    }

    public static void printMap(String[][] map, String player){
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
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

    private static void curPlayer(String player) {
        System.out.println();
        System.out.println(player + " it's your turn!\n");
    }
}
