import java.util.Random;
import java.util.Scanner;

public class Ships {
	//user input 
	static Scanner userX = new Scanner(System.in);
	static Scanner userY = new Scanner(System.in);
	static Scanner userOrientation = new Scanner(System.in);
	
	static int numberOfShips = 7; //number of ships in game 
	
	public static void setupMethod(){
		Scanner method = new Scanner(System.in);
		System.out.println("How would you like to place your ships?");
		System.out.println("for automatically enter: 1");
		System.out.println("for manually enter: 2");
		int choice = method.nextInt();
		if(choice == 1){
			setPlayerShips();
		}
		else{
			setPlayerShipsManual();
		}
		
	}
	
	public static void setPlayerShipsManual(){
			for(int i = 1; i <= numberOfShips; i++){
				Board.drawPlayer1Board();
				System.out.println("Enter ship X coordinate");
				int xCoordinate = (userX.nextInt()) - 1;
				System.out.println("Enter ship Y coordinate");
				int yCoordinate = (userY.nextInt()) - 1;
				System.out.println("Enter ship orientation");
				System.out.println("1 for horizontal");
				System.out.println("2 for verticle");
				int orentation = userOrientation.nextInt();
				
				if(Board.playerBoardStatus[xCoordinate][yCoordinate] == Console.empty && (xCoordinate  >= 0 && yCoordinate >= 0) && (xCoordinate  <= Board.boardSize && yCoordinate <= Board.boardSize)){ //test starting point
				
					Board.playerBoardStatus[xCoordinate][yCoordinate] = Console.ocupied; //starting point
					
					if(orentation == 1){ //vertical or horizontal 
						if(xCoordinate == 0 && Board.playerBoardStatus[xCoordinate + 1][yCoordinate] == Console.empty){  //near edge X? space to right empty?
							Board.playerBoardStatus[xCoordinate + 1][yCoordinate] = Console.ocupied;
						}
						else if(xCoordinate > 0 && Board.playerBoardStatus[xCoordinate - 1][yCoordinate] == Console.empty){ //space to left empty?
							Board.playerBoardStatus[xCoordinate - 1][yCoordinate] = Console.ocupied;
						}
						else{ //redo
							System.out.println("That is not a valid position");
							System.out.println("Please retry");
							i--;
						}
					}
					else{
						if(yCoordinate == 0 && Board.playerBoardStatus[xCoordinate][yCoordinate + 1] == Console.empty){  //near edge Y? space below empty?
							Board.playerBoardStatus[xCoordinate][yCoordinate + 1] = Console.ocupied;
						}
						else if(yCoordinate > 0 && Board.playerBoardStatus[xCoordinate][yCoordinate - 1] == Console.empty){ //space above empty?
							Board.playerBoardStatus[xCoordinate][yCoordinate - 1] = Console.ocupied;
						}
						else{ //redo
							System.out.println("That is not a valid position");
							System.out.println("Please retry");
							i--;
						}
					}
				}
				else{ //starting point test failed. redo
					System.out.println("That is not a valid position");
					System.out.println("Please retry");
					i--;
				}
		}
	}
	
	public static void setPlayerShips(){ 
		
		for(int i = 1; i <= numberOfShips; i++){
			
			//random variables
			int randX = new Random().nextInt(Board.boardSize);
			int randY = new Random().nextInt(Board.boardSize);
			boolean randOrentation = new Random().nextBoolean();
			
			if(Board.playerBoardStatus[randX][randY] == Console.empty && (randX  >= 0 && randY >= 0)){ //test starting point
			
				Board.playerBoardStatus[randX][randY] = Console.ocupied; //starting point
				
				if(randOrentation == true){ //vertical or horizontal 
					if(randX == 0 && Board.playerBoardStatus[randX + 1][randY] == Console.empty){  //near edge X? space to right empty?
						Board.playerBoardStatus[randX + 1][randY] = Console.ocupied;
					}
					else if(randX > 0 && Board.playerBoardStatus[randX - 1][randY] == Console.empty){ //space to left empty?
						Board.playerBoardStatus[randX - 1][randY] = Console.ocupied;
					}
					else{ //redo
						i--;
					}
				}
				else{
					if(randY == 0 && Board.playerBoardStatus[randX][randY + 1] == Console.empty){  //near edge Y? space below empty?
						Board.playerBoardStatus[randX][randY + 1] = Console.ocupied;
					}
					else if(randY > 0 && Board.playerBoardStatus[randX][randY - 1] == Console.empty){ //space above empty?
						Board.playerBoardStatus[randX][randY - 1] = Console.ocupied;
					}
					else{ //redo
						i--;
					}
				}
			}
			else{ //starting point test failed. redo
				i--;
			}
		}
	}
	
	public static void setComputerShips(){
		
		for(int i = 1; i <= numberOfShips; i++){
			
			//random variables
			int randX = new Random().nextInt(Board.boardSize);
			int randY = new Random().nextInt(Board.boardSize);
			boolean randOrentation = new Random().nextBoolean();
			
			if(Board.computerBoardStatus[randX][randY] == Console.empty && (randX  >= 0 && randY >= 0)){ //test starting point
			
				Board.computerBoardStatus[randX][randY] = Console.ocupied; //starting point
				
				if(randOrentation == true){ //vertical or horizontal 
					if(randX == 0 && Board.computerBoardStatus[randX + 1][randY] == Console.empty){  //near edge X? space to right empty?
						Board.computerBoardStatus[randX + 1][randY] = Console.ocupied;
					}
					else if(randX > 0 && Board.computerBoardStatus[randX - 1][randY] == Console.empty){ //space to left empty?
						Board.computerBoardStatus[randX - 1][randY] = Console.ocupied;
					}
					else{ //redo
						i--;
					}
				}
				else{
					if(randY == 0 && Board.computerBoardStatus[randX][randY + 1] == Console.empty){  //near edge Y? space below empty?
						Board.computerBoardStatus[randX][randY + 1] = Console.ocupied;
					}
					else if(randY > 0 && Board.computerBoardStatus[randX][randY - 1] == Console.empty){ //space above empty?
						Board.computerBoardStatus[randX][randY - 1] = Console.ocupied;
					}
					else{ //redo
						i--;
					}
				}
			}
			else{ //starting point test failed. redo
				i--;
			}
		}
	}
}
	
