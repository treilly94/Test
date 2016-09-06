
public class Console {
	//location states
	public final static String empty = " -";
	public final static String emptyHit = " /";
	public final static String ocupied = " S";
	public final static String ocupiedHit = " *";
	
	public static void main(String[] args) {
		
		//setup
		//Player.namePlayers();
		
		GUI.myGridLayout();
		
		Board.setBoards();
		Player.selectOpponent();
		Ships.setupMethod();
		Ships.setComputerShips();
		
		
		//gameplay
		while(Player.winner == false && Player.opponent == 1){
			System.out.println();
			Board.drawAIBoard();
			System.out.println();
			Board.drawPlayer1Board();
			System.out.println();
			if(Player.winner == false && Player.turn == 0){ //player 1 turn
				Player.checkWinner();
				Player.player1Shoot();
			}
			else if(Player.winner == false && Player.turn == 1){ //AI turn
				Player.checkWinner();
				Player.aiShoot();
			}
			Player.nextTurn();
		}
		
		while(Player.winner == false && Player.opponent == 2){
			System.out.println();
			Board.drawPlayer2Board();
			System.out.println();
			Board.drawPlayer1Board();
			System.out.println();
			if(Player.winner == false && Player.turn == 0){ //player 1 turn
				Player.player1Shoot();
				Player.checkWinner();
			}
			else if(Player.winner == false && Player.turn == 1){ //player 2 turn
				Player.player2Shoot();
				Player.checkWinner();
			}
			Player.nextTurn();
		}
		
	}

}
