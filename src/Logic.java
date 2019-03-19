public class Logic {
    private String player1;
    private String player2;
    private char[][] size;

    public Logic(String player1, String player2){
        this.player1 = player1;
        this.player2 = player2;

        size = new char[7][7];
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++)
                size[i][j] = '.';
        }
    }


}
