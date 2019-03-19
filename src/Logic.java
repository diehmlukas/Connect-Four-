public class Logic {
    private String[] player1 = new String[2]; //X
    private String[] player2 = new String[2]; //O
    private char[][] map;

    public Logic() throws Exception{
        map = new char[7][7];
        this.player1 = new String[2];
        this.player2 = new String[2];
        this.player1[1] = "X";
        this.player2[1] = "O";
        startGame();
    }

    private void startGame() throws Exception{
        IO.printStartText();
        this.player1[0] = IO.readPlayer();
        this.player2[0] = IO.readPlayer();

        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++)
                map[i][j] = '.';
        }
        IO.printMap(map, player1);
    }

    public void execGame() throws Exception{
        int count = 0;
        do {
            int column = checkColumn();
            if (column != -1) {
                if (count % 2 == 0) {
                    insertCoin(column, player1[1].toCharArray()[0]);
                    checkHelper(player1[0], column);
                }
                else {
                    insertCoin(column, player2[1].toCharArray()[0]);
                    checkHelper(player2[0], column);
                }
            }
            count++;
        }while(count<43);
        IO.tieGame();
    }

    private void checkHelper(String player, int column) {
        if (checkCoins(player.toCharArray()[0], column)){
            IO.win(player);
            System.exit(0);
        }
    }

    private boolean checkCoins(char sign, int lastColumn) {
        //get position
        int i = 0;
        while(map[i][lastColumn] != sign)
            i++;

        //check if there's a vertical match
        boolean out = false;
        if (i > 2) {
            for (int j = i; j >= (i-3); j--) {
                if (map[j][lastColumn] == sign)
                    out = true;
                else {
                    out = false;
                    break;
                }
            }
        }

        if (out)
            return out;
        else { //check if there's a horizontal match
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == sign)
                    out = true;
                else if(j >= 5 && !out) {
                    break;
                } else {
                    out = false;
                }
            }
        }

        if (out)
            return out;
        else { //check if there's a diagonal match

        }
    }

    private void insertCoin(int column, char sign) {
        for (int i = 0; i < 8; i++) {
            if (map[column][i] != '.')
                map[column][i - 1] = sign;
        }
    }
    
    private int checkColumn() throws Exception{
        int column = IO.readColumn();
        if (column >= 0 && column < 8)
            return column;
        else {
            IO.errorMessage();
            return -1;
        }
    }
}
