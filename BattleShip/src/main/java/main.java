/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        GameUI ui = new GameUI(board);
        ui.start();
    }
}
