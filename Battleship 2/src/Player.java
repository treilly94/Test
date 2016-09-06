import java.util.Random;
import java.util.Scanner;
import javax.swing.JRadioButton;

public class Player {
	
	static int turn = 0; //whos turn is it?
	static String[] player = new String[2]; //player names
	static Scanner userName = new Scanner(System.in); //input for user name
	static Scanner userShot = new Scanner(System.in); //input for shooting 
	static Scanner opponentSelection = new Scanner(System.in);//input for player v player or player v AI
	static int opponent = 0; //player v player or player v AI
	static int playerScore = 0;
	static int computerScore = 0;
	static boolean hit = false;
	static boolean winner = false;
	
	public static void namePlayers(){ //set player names
		System.out.println("What would you like us to call you?");
		player[0] = userName.nextLine();
		player[1] = "Computer";
		System.out.println();
	}
	
	public static void nextTurn(){ //next turn
		if(turn == 1 && hit == false){
			turn = 0;
		}
		else if(hit == true){
			
		}
		else{
			turn++;
		}
	}
	
	public static void checkWinner(){ //check for a winner
		if(playerScore == (2* Ships.numberOfShips)){
			winner = true;
			System.out.println("Player 1 wins");
		}
		else if(computerScore == (2* Ships.numberOfShips)){
			winner = true;
			System.out.println("Player 2 wins");
		}
	}
	
	public static void player1Shoot(){ //player 1 shoots
		System.out.println("Player 1 take a shot");
		System.out.println("X coordinate");
		int xCoordinate = userShot.nextInt();
		xCoordinate--; //Making base zero
		System.out.println("Y coordinate");
		int yCoordinate = userShot.nextInt();
		yCoordinate--; //Making base zero
		
		if(Board.computerBoardStatus[xCoordinate][yCoordinate] == Console.empty){ //empty changes to empty hit 
			Board.computerBoardStatus[xCoordinate][yCoordinate] = Console.emptyHit;
			hit = false;
		}
		else if(Board.computerBoardStatus[xCoordinate][yCoordinate] == Console.emptyHit){ //empty hit stays the same 
			hit = false;
		}
		else if(Board.computerBoardStatus[xCoordinate][yCoordinate] == Console.ocupied){ //occupied changes to occupied hit 
			Board.computerBoardStatus[xCoordinate][yCoordinate] = Console.ocupiedHit;
			hit = true;
			playerScore++;
		}
		else if(Board.computerBoardStatus[xCoordinate][yCoordinate] == Console.ocupiedHit){ //occupied hit stays the same 
			hit = false;
		}
		
	}
	
	public static void player2Shoot(){ //player 2 shoots
		System.out.println("Player 2 take a shot");
		System.out.println("X coordinate");
		int xCoordinate = userShot.nextInt();
		xCoordinate--; //Making base zero
		System.out.println("Y coordinate");
		int yCoordinate = userShot.nextInt();
		yCoordinate--; //Making base zero
		
		if(Board.playerBoardStatus[xCoordinate][yCoordinate] == Console.empty){ //empty changes to empty hit 
			Board.playerBoardStatus[xCoordinate][yCoordinate] = Console.emptyHit;
			hit = false;
		}
		else if(Board.playerBoardStatus[xCoordinate][yCoordinate] == Console.emptyHit){ //empty hit stays the same 
			hit = false;
		}
		else if(Board.playerBoardStatus[xCoordinate][yCoordinate] == Console.ocupied){ //occupied changes to occupied hit 
			Board.playerBoardStatus[xCoordinate][yCoordinate] = Console.ocupiedHit;
			hit = true;
			computerScore++;
		}
		else if(Board.playerBoardStatus[xCoordinate][yCoordinate] == Console.ocupiedHit){ //occupied hit stays the same 
			hit = false;
		}
	}
	
	public static void aiShoot(){ //AI shoots
		//random variables
		int randX = new Random().nextInt(Board.boardSize - 1);
		int randY = new Random().nextInt(Board.boardSize - 1);
		
		for(int i = 1; i <= 1; i++){
			
			
			if(Board.playerBoardStatus[randX][randY] == Console.empty){ //empty changes to empty hit 
				Board.playerBoardStatus[randX][randY] = Console.emptyHit;
				hit = false;
			}
			else if(Board.playerBoardStatus[randX][randY] == Console.emptyHit){ //AI retakes shot 
				i--;
				hit = false;
			}
			else if(Board.playerBoardStatus[randX][randY] == Console.ocupied){ //occupied changes to occupied hit 
				Board.playerBoardStatus[randX][randY] = Console.ocupiedHit;
				hit = true;
				computerScore++;
				
				boolean randOrentation1 = new Random().nextBoolean(); //move verticle or horizontal
				boolean randOrentation2 = new Random().nextBoolean(); //plus or minus 1
				
				if(randOrentation1 == true){
					if(randOrentation2 == true){
						randX++;
					}
					else{
						randX--;
					}
				}
				else{
					if(randOrentation2 == true){
						randY++;
					}
					else{
						randY--;
					}
				}
				i--;
			}
			else if(Board.playerBoardStatus[randX][randY] == Console.ocupiedHit){ //AI retakes shot 
				i--;
				hit = false;
			}
		}
	}
	
	public static void selectOpponent(){
		System.out.println("To play against a computer enter 1");
		System.out.println("To play against another player press 2");
		opponent = opponentSelection.nextInt();
	}
}
