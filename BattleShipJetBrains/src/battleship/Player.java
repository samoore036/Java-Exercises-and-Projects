package battleship;
import java.util.*;
public class Player {
    Scanner sc = new Scanner(System.in);
    protected char[][] gameBoard = new char[10][10];
    protected char[][] fogOfWar = new char[10][10];
    protected char[][] aircraftCarrier = new char[10][10];
    protected char[][] battleship = new char[10][10];
    protected char[][] submarine = new char[10][10];
    protected char[][] cruiser = new char[10][10];
    protected char[][] destroyer = new char[10][10];
    private int count = 0;
    private int currentShipLength = 0;
    private String shipName = "";

    public void printShipCoords(char[][] ship) {
        for (int i = 0; i < ship.length; i++) {
            for (int j = 0; j < ship[i].length; j++) {
                if (ship[i][j] == 'O') {
                    System.out.print(String.format("(%s,%s) ", i, j));
                }
            }
        }
        System.out.println("");
    }

    public void printGameboard() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        char row = 'A';
        for (int i = 0; i < 10; i++) {
            System.out.print(row + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(this.gameBoard[i][j] + " ");
            }
            row++;
            System.out.println("");
        }
    }

    public void printFogOfWar() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        char row = 'A';
        for (int i = 0; i < 10; i++) {
            System.out.print(row + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(this.fogOfWar[i][j] + " ");
            }
            row++;
            System.out.println("");
        }
    }

    public void setShips() {
        while (this.count != 5) {
            this.printShip(this.count);
            this.coordLoop();
        }
    }

    public void coordLoop() {
        if (count == 5) {
            System.out.println("");
            System.out.println("Press enter and pass the move to another player");
            String pass = this.sc.nextLine();
            while (!pass.isEmpty()) {
                System.out.println("Only press enter to pass to another player");
                pass = this.sc.nextLine();
            }
            return;
        }
        try {
            String coords = sc.nextLine().toUpperCase();
            System.out.println("");
            String[] split = coords.split(" ");
            int startRow = translate(split[0].substring(0, 1));
            int startColumn = Integer.valueOf(split[0].substring(1)) - 1;
            int endRow = translate(split[1].substring(0, 1));
            int endColumn = Integer.valueOf(split[1].substring(1)) - 1;
            if (startRow > endRow) {
                int save = endRow;
                endRow = startRow;
                startRow = save;
            }
            if (startColumn > endColumn) {
                int save = endColumn;
                endColumn = startColumn;
                startColumn = save;
            }
            this.checkCoords(startRow, endRow, startColumn, endColumn);
        } catch (RuntimeException e) {
            System.out.println("Error! You entered the wrong coordinates. Try again:");
            System.out.println("");
            this.coordLoop();
        }
    }

    public void checkCoords(int startRow, int endRow, int startColumn, int endColumn) {
        if (startRow < 0 || startRow > 9 || endRow < 0 || endRow > 9 || startColumn < 0 || startColumn > 9 || endColumn < 0 || endColumn > 9) {
            System.out.println("Error! Wrong ship location! Try again:");
            System.out.println("");
        }
        if ((startRow != endRow) && (startColumn != endColumn)) {
            System.out.println("");
            System.out.println("Error! Wrong ship location! Try again:");
            System.out.println("");
            this.coordLoop();
        }
        if (startRow == endRow) {
            if ((Math.abs(endColumn - startColumn)) != this.currentShipLength - 1) {
                System.out.println("");
                System.out.println(String.format("Error! Wrong length of the %s! Try again:", this.shipName));
                System.out.println("");
                this.coordLoop();
            }
        }
        if (startColumn == endColumn) {
            if ((Math.abs(endRow - startRow)) != this.currentShipLength - 1) {
                System.out.println("");
                System.out.println(String.format("Error! Wrong length of the %s! Try again:", this.shipName));
                System.out.println("");
                this.coordLoop();
            }
        }
        if (startRow == endRow) {
            for (int i = startColumn; i <= endColumn; i++) {
                if (gameBoard[startRow][i] == 'O') {
                    System.out.println("");
                    System.out.println("Error! Wrong ship location! Try again:");
                    System.out.println("");
                    this.coordLoop();
                }
            }
            this.checkAbove(startRow, endRow, startColumn, endColumn);
            this.checkBelow(startRow, endRow, startColumn, endColumn);
        }
        if (startColumn == endColumn) {
            for (int i = startRow; i <= endRow; i++) {
                if (gameBoard[i][startColumn] == 'O') {
                    System.out.println("");
                    System.out.println("Error! Wrong ship location! Try again:");
                    System.out.println("");
                    this.coordLoop();
                }
            }
            this.checkLeft(startRow, endRow, startColumn, endColumn);
            this.checkRight(startRow, endRow, startColumn, endColumn);
        }
        if (startRow == endRow) {
            for (int i = startColumn; i <= endColumn; i++) {
                this.gameBoard[startRow][i] = 'O';
                this.addShipCoords(startRow, i);
            }
            this.printGameboard();
            this.count++;
        }
        if (startColumn == endColumn) {
            for (int i = startRow; i <= endRow; i++) {
                this.gameBoard[i][startColumn] = 'O';
                this.addShipCoords(i, startColumn);
            }
            this.printGameboard();
            this.count++;
        }
    }

    public void checkAbove(int startRow, int endRow, int startColumn, int endColumn) {
        int aboveRow = 0;
        if (startRow - 1 >= 0) {
            aboveRow = startRow - 1;
        }
        for (int i = startColumn; i <= endColumn; i++) {
            if (gameBoard[aboveRow][i] == 'O') {
                System.out.println("");
                System.out.println("Error! You placed it too close to another one. Try again:");
                System.out.println("");
                this.coordLoop();
            }
        }
        int leftColumn = 0;
        if (startColumn - 1 >= 0) {
            leftColumn = startColumn - 1;
            if (gameBoard[startRow][leftColumn] == 'O') {
                System.out.println("");
                System.out.println("Error! You placed it too close to another one. Try again:");
                System.out.println("");
                this.coordLoop();
            }
        }
        int rightColumn = 0;
        if (endColumn + 1 <= 9) {
            rightColumn = endColumn + 1;
            if (gameBoard[startRow][rightColumn] == 'O') {
                System.out.println("");
                System.out.println("Error! You placed it too close to another one. Try again:");
                System.out.println("");
                this.coordLoop();
            }
        }
    }

    public void checkBelow(int startRow, int endRow, int startColumn, int endColumn) {
        int belowRow = 0;
        if (startRow + 1 <= 9) {
            belowRow = startRow + 1;
        }
        for (int i = startColumn; i <= endColumn; i++) {
            if (gameBoard[belowRow][i] == 'O') {
                System.out.println("");
                System.out.println("Error! You placed it too close to another one. Try again:");
                System.out.println("");
                this.coordLoop();
            }
        }
    }

    public void checkLeft(int startRow, int endRow, int startColumn, int endColumn) {
        int columnLeft = 0;
        if (startColumn - 1 >= 0) {
            columnLeft = startColumn - 1;
        }
        for (int i = startRow; i <= endRow; i++) {
            if (gameBoard[startRow][columnLeft] == 'O') {
                System.out.println("");
                System.out.println("Error! You placed it too close to another one. Try again:");
                System.out.println("");
                this.coordLoop();
            }
        }
        int aboveRow = 0;
        if (startRow - 1 >= 0) {
            aboveRow = startRow - 1;
            if (gameBoard[aboveRow][startColumn] == 'O') {
                System.out.println("");
                System.out.println("Error! You placed it too close to another one. Try again:");
                System.out.println("");
                this.coordLoop();
            }
        }
        int belowRow = 0;
        if (endRow + 1 <= 9) {
            belowRow = endRow + 1;
            if (gameBoard[belowRow][startColumn] == 'O') {
                System.out.println("");
                System.out.println("Error! You placed it too close to another one. Try again:");
                System.out.println("");
                this.coordLoop();
            }
        }
    }

    public void checkRight(int startRow, int endRow, int startColumn, int endColumn) {
        int columnRight = 0;
        if (endColumn + 1 <= 9) {
            columnRight = endColumn + 1;
        }
        for (int i = startRow; i <= endRow; i++) {
            if (gameBoard[startRow][columnRight] == 'O') {
                System.out.println("");
                System.out.println("Error! You placed it too close to another one. Try again:");
                System.out.println("");
                this.coordLoop();
            }
        }
        int aboveRow = 0;
        if (startRow - 1 >= 0) {
            aboveRow = startRow - 1;
            if (gameBoard[aboveRow][startColumn] == 'O') {
                System.out.println("");
                System.out.println("Error! You placed it too close to another one. Try again:");
                System.out.println("");
                this.coordLoop();
            }
        }
        int belowRow = 0;
        if (endRow + 1 <= 9) {
            belowRow = endRow + 1;
            if (gameBoard[belowRow][startColumn] == 'O') {
                System.out.println("");
                System.out.println("Error! You placed it too close to another one. Try again:");
                System.out.println("");
                this.coordLoop();
            }
        }
    }

    public void printShip(int count) {
        System.out.println("");
        switch (count) {
            case 0:
                System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
                System.out.println("");
                this.currentShipLength = 5;
                this.shipName = "Aircraft Carrier";
                break;
            case 1:
                System.out.println("Enter the coordinates of the Battleship (4 cells):");
                System.out.println("");
                this.currentShipLength = 4;
                this.shipName = "Battleship";
                break;
            case 2:
                System.out.println("Enter the coordinates of the Submarine (3 cells):");
                System.out.println("");
                this.currentShipLength = 3;
                this.shipName = "Submarine";
                break;
            case 3:
                System.out.println("Enter the coordinates of the Cruiser (3 cells):");
                System.out.println("");
                this.currentShipLength = 3;
                this.shipName = "Cruiser";
                break;
            case 4:
                System.out.println("Enter the coordinates of the Destroyer (2 cells):");
                System.out.println("");
                this.currentShipLength = 2;
                this.shipName = "Destroyer";
                break;
        }
    }

    public void addShipCoords(int row, int column) {
        switch (this.count) {
            case 0:
                this.aircraftCarrier[row][column] = 'O';
                break;
            case 1:
                this.battleship[row][column] = 'O';
                break;
            case 2:
                this.submarine[row][column] = 'O';
                break;
            case 3:
                this.cruiser[row][column] = 'O';
                break;
            case 4:
                this.destroyer[row][column] = 'O';
                break;
        }
    }

    public int translate(String coord) {
        switch (coord) {
            case "A": return 0;
            case "B": return 1;
            case "C": return 2;
            case "D": return 3;
            case "E": return 4;
            case "F": return 5;
            case "G": return 6;
            case "H": return 7;
            case "I": return 8;
            case "J": return 9;
        }
        return -1;
    }
}
