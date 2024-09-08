import java.util.Scanner;

public class XO {
    private String name1, name2;
    private char p1 = 'X', p2 = 'O';
    private char[][] arr = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
    private Scanner sc = new Scanner(System.in);

    XO() {
        System.out.println("Enter the name 0f player1: ");
        String temp1 = this.sc.next();
        System.out.println("Enter the name 0f player2: ");
        String temp2 = this.sc.next();
        System.out.println("Name saved!");
        if (rand() == 0) {
            this.name1 = temp1;
            this.name2 = temp2;

        } else {
            this.name1 = temp2;
            this.name2 = temp1;
        }
        this.displayName();
    }

    void displayName() {
        System.out.println("\nplayer1: " + this.name1 + " gets " + this.p1);
        System.out.println("player2: " + this.name2 + " gets " + this.p2
                + "\n\n### Who gets X or O was decided randomly so please don't fight over it ###\n");
    }

    void showGrid() {
        System.out.print("\n     ");
        for (int i = 0; i < 3; i++) {
            if (i == 1 || i == 2 || i == 3) {
                System.out.print("\n    - - - - - - \n     ");

            }
            for (int j = 0; j < 2; j++) {
                System.out.print(this.arr[i][j] + " | ");
            }
            System.out.print(this.arr[i][2]);
        }
        System.out.print("\n\n");
    }

    void setXorO(int i, int j, char c) {
        this.arr[i][j] = c;
    }

    void askplayer() {
        int[] cordinateArr = { 0, 0 };
        int count = 0;
        System.out.println("\nLET'S START THE GAME.\n");
        while (count < 5) {
            System.out.print(this.name1 + "'s turn: ");
            for (int i = 0; i < cordinateArr.length; i++) {
                cordinateArr[i] = this.sc.nextInt();
            }
            setXorO(cordinateArr[0], cordinateArr[1], this.p1);
            this.showGrid();
            if (this.checkWin() == true) {
                System.out.println(this.name1 + " has won the game!");
                break;
            }
            if (count == 4 && this.checkWin() == false) {
                System.out.println("The game is tied!!");
                break;
            }
            System.out.print(this.name2 + "'s turn: ");
            for (int i = 0; i < cordinateArr.length; i++) {
                cordinateArr[i] = this.sc.nextInt();
            }
            setXorO(cordinateArr[0], cordinateArr[1], this.p2);
            this.showGrid();
            if (this.checkWin() == true) {
                System.out.println(this.name2 + " has won the game!");
                break;
            }
            count++;
        }
    }

    boolean checkWin() {
        if (arr[0][0] == 'X' && arr[0][1] == 'X' && arr[0][2] == 'X'
                || arr[0][0] == 'O' && arr[0][1] == 'O' && arr[0][2] == 'O') {
            return true;
        }
        if (arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X'
                || arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O') {
            return true;
        }
        if (arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X'
                || arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O') {
            return true;
        }
        if (arr[0][0] == 'X' && arr[1][0] == 'X' && arr[2][0] == 'X'
                || arr[0][0] == 'O' && arr[1][0] == 'O' && arr[2][0] == 'O') {
            return true;
        }
        if (arr[1][0] == 'X' && arr[1][1] == 'X' && arr[1][2] == 'X'
                || arr[1][0] == 'O' && arr[1][1] == 'O' && arr[1][2] == 'O') {
            return true;
        }
        if (arr[2][0] == 'X' && arr[2][1] == 'X' && arr[2][2] == 'X'
                || arr[2][0] == 'O' && arr[2][1] == 'O' && arr[2][2] == 'O') {
            return true;
        }
        if (arr[0][2] == 'X' && arr[1][2] == 'X' && arr[2][2] == 'X'
                || arr[0][2] == 'O' && arr[1][2] == 'O' && arr[2][2] == 'O') {
            return true;
        }
        if (arr[0][1] == 'X' && arr[1][1] == 'X' && arr[2][1] == 'X'
                || arr[0][1] == 'O' && arr[1][1] == 'O' && arr[2][1] == 'O') {
            return true;
        }
        return false;
    }

    int rand() {
        int max = 1;
        int min = 0;
        int range = max - min + 1;

        return (int) (Math.random() * range) + min;
    }

    void startGame() {
        this.askplayer();
        System.out.println("\n\nDo you want to play another round??      (y/n)");
        while (sc.next().charAt(0) == 'y') {
            this.askplayer();
            System.out.println("\n\nDo you want to play another round??      (y/n)");
        }
        this.sc.close();

    }

    public static void main(String[] args) {
        XO xo = new XO();
        xo.startGame();
    }
}