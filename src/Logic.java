public class Logic {
    private String[] player1; //X
    private String[] player2; //O
    private char[][] map;

    public Logic(){
        map = new char[8][8];
        this.player1 = new String[2];
        this.player2 = new String[2];
        this.player1[1] = "X";
        this.player2[1] = "O";
        startGame();
    }

    private void startGame(){
        IO.printStartText();
        this.player1[0] = IO.readPlayer();
        this.player2[0] = IO.readPlayer();

        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++)
                map[i][j] = '.';
        }
        IO.printMap(map);
        IO.nextPlayer(player1);
    }

    public void execGame(){
        int count = 0;
        do {
            int column = checkColumn();
            if (column != -1) {
                if (count % 2 == 0) {
                    insertCoin(column, player1[1].toCharArray()[0]);
                    checkHelper(player1, column);
                    IO.printMap(map);
                    IO.nextPlayer(player2);
                }
                else {
                    insertCoin(column, player2[1].toCharArray()[0]);
                    checkHelper(player2, column);
                    IO.printMap(map);
                    IO.nextPlayer(player1);
                }
            }
            count++;
        }while(count<42);
        IO.tieGame();
    }

    private void checkHelper(String[] player, int column) {
        if (checkCoins(player[1].toCharArray()[0], column)){
            IO.printMap(map);
            IO.win(player[0]);
            System.exit(0);
        }
    }

    private boolean checkCoins(char sign, int lastColumn) {
        //get position
        int i = 0;
        while(map[i][lastColumn] != sign && i <= 7)
            i++;

        //check if there's a vertical match
        boolean out = verticalMatch(i, lastColumn, sign);
        if (out)
            return out;

        //check if there's a horizontal match
        out = horizontalMatch(i, sign);
        if (out)
            return out;

        //check if there's a diagonal match
        out = diagonalMatch(sign);
        if (out)
            return out;
        else
            return false;
    }

    private boolean verticalMatch(int pos, int lastColumn, char sign) {
        boolean out = false;
        int count = 1;
        if (pos < 5) {
            for (int j = pos; j <= 7; j++) { //
                if (map[j][lastColumn] == sign)
                    if (count == 4) {
                        out = true;
                        break;
                    }
                    else
                        count++;
                else {
                    out = false;
                    break;
                }
            }
        }
        return out;
    }

    private boolean horizontalMatch(int pos, char sign) {
        boolean out = false;
        int count = 1;
        for (int j = 0; j <= 7; j++) {
            if (map[pos][j] == sign)
                if (count == 4) {
                    out = true;
                    break;
                }
                else
                    count++;
            else if(j > 4 && !out) {
                break;
            } else {
                out = false;
                count = 1;
            }
        }
        return out;
    }

    //FIXME: diagonal match debugging + tetsing
    private boolean diagonalMatch(char sign) {
        boolean out = false;

        //lower half - left to right
        for (int k = 0; k < 5; k++) {
            for (int h = 0; h <= (8-k); h++) {
                if (map[h + k][h] == sign)
                    out = true;
                else if (h >= 5 && !out)
                    break;
                else
                    out = false;
            }
        }
        if (out)
            return out;

        //upper half - left to right
        for (int k = 0; k < 5; k++) {
            for (int h = 0; h <= (8-k); h++) {
                if (map[h][h + k] == sign)
                    out = true;
                else if (h >= 5 && !out)
                    break;
                else
                    out = false;
            }
        }
        if (out)
            return out;

        //lower half - right to left
        for (int k = 7; k > 2; k--) {
            for (int h = 0; h <= k; h++) {
                if (map[7 - h][h] == sign)
                    out = true;
                else if (h >= 5 && !out)
                    break;
                else
                    out = false;
            }
        }
        if (out)
            return out;

        //upper half - right to left
        for (int k = 7; k > 2; k--) {
            for (int h = 0; h <= k; h++) {
                if (map[h][7 - h] == sign)
                    out = true;
                else if (h >= 5 && !out)
                    break;
                else
                    out = false;
            }
        }
        if (out)
            return out;
        else
            return false;
    }

    private void insertCoin(int column, char sign) {
        for (int i = 7; i >= 0; i--) {
            if (map[i][column] == '.' && i == 7) {
                map[i][column] = sign;
                break;
            }
            else if(map[i][column] == '.' && map[i + 1][column] != '.') {
                map[i][column] = sign;
                break;
            }
        }
    }
    
    private int checkColumn(){
        int column = IO.readColumn();
        if (column >= 0 && column < 8) {}
        else {
            IO.errorOutOfBounds();
            return -1;
        }

        if (map[0][column] == '.')
            return column;
        else {
            IO.errorStackOverflow();
            return -1;
        }
    }
}
