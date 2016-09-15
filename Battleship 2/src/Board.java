
public class Board {

	static int boardSize = 12; //size of game
	static String[][] playerBoardStatus = new String[boardSize][boardSize]; //locations within board
	static String[][] computerBoardStatus = new String[boardSize][boardSize]; //locations within board

	public static void setBoards(){ //set the board to all empty at the start of the game
		for(int i = 0; i < boardSize; i++){
			for(int j = 0; j < boardSize; j++){
				playerBoardStatus[j][i] = Console.empty;
				computerBoardStatus[j][i] = Console.empty;
			}
		}
	}

	public static void drawPlayer1Board(){ //draw the Player board
		System.out.println("Player 1");
		for(int k = 0; k < boardSize; k++){
			System.out.print("\t");
			System.out.print(k + 1); //guide //guide
		}
		System.out.println();
		for(int i = 0; i < boardSize; i++){
			System.out.print(i + 1); //guide
			for(int j = 0; j < boardSize; j++){ //x axis
				System.out.print("\t");
				System.out.print(playerBoardStatus[j][i]);
			}
		System.out.println();
		}
	}
	public static void drawPlayer2Board(){ //draw player 2s  board
		System.out.println("Player 2");
		for(int k = 0; k < boardSize; k++){
			System.out.print("\t");
			System.out.print(k + 1); //guide
		}
		System.out.println();
		for(int i = 0; i < boardSize; i++){
			System.out.print(i + 1); //guide
			for(int j = 0; j < boardSize; j++){ //x axis
				System.out.print("\t");
				System.out.print(playerBoardStatus[j][i]);
			}
		System.out.println();
		}
	}

	public static void drawAIBoard(){ //draw the computer board
		System.out.println("Computer");
		for(int k = 0; k < boardSize; k++){
			System.out.print("\t");
			System.out.print(k + 1); //guide
		}
		System.out.println();
		for(int i = 0; i < boardSize; i++){
			System.out.print(i + 1); //guide
			for(int j = 0; j < boardSize; j++){ //x axis
				System.out.print("\t");
				if(computerBoardStatus[j][i] == Console.ocupied){
					System.out.print(Console.empty);
				}
				else{
					System.out.print(computerBoardStatus[j][i]);
				}
			}
		System.out.println();
		}
	}
}

#test
