package TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		char [][] gameboard = {{' ', '|', ' ', '|', ' '},
				   			   {'-', '+', '-', '+', '-'},
				   			   {' ', '|', ' ', '|', ' '},
				   			   {'-', '+', '-', '+', '-'},
				   			   {' ', '|', ' ', '|', ' '}};
		
		board(gameboard);
	
		while(true) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1 - 9!: ");
		
			//Taking player inputs and making sure player and cpu doesn't contain the same spot.
			int playerInput = scan.nextInt();
			while(playerPositions.contains(playerInput) || cpuPositions.contains(playerInput)) {
				System.out.println("Position is taken! Choose another please.");
				playerInput = scan.nextInt();
			}
			insert(gameboard, playerInput, "Player");
			//taking cpu inputs and making sure cpu and player doesn't contain same spot.
			Random rand = new Random();
			int cpuInput = rand.nextInt(9) + 1;
			while(playerPositions.contains(cpuInput) || cpuPositions.contains(cpuInput)) {
				cpuInput = rand.nextInt(9) + 1;
			}
			insert(gameboard, cpuInput, "CPU");
		
		board(gameboard);
		String results = checkWinner();
		System.out.println(results);
	}
	
	}

		//display game board in method
	static void board(char [][] gameboard1) {

		for(char[] row : gameboard1) {
			for( char col : row) {
				System.out.print(col);
			}
			System.out.println();
		}
	}
	
		
		//position placement for users
	public static void insert(char[][]gameboard, int position, String user) {
			
		char symbol = ' ';
			
		if(user.equals("Player")) {
			symbol = 'X';
			playerPositions.add(position);
		} else if(user.equals("CPU")) {
			symbol = 'O';
			cpuPositions.add(position);
		}
			
			switch(position) {
				case 1: 
					gameboard[0][0] = symbol;
					break;
				case 2:
					gameboard[0][2] = symbol;
					break;
				case 3:
					gameboard[0][4] = symbol;
					break;
				case 4:
					gameboard[2][0] = symbol;
					break;
				case 5:
					gameboard[2][2] = symbol;
					break;
				case 6:
					gameboard[2][4] = symbol;
					break;
				case 7:
					gameboard[4][0] = symbol;
					break;
				case 8:
					gameboard[4][2] = symbol;
					break;
				case 9:
					gameboard[4][4] = symbol;
					break;
			}
	}
		
		//method to check the winner
	public static String checkWinner() {
			
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(3,5,7);
			
		List<List> winnerConditions = new ArrayList<List>();
			winnerConditions.add(topRow);
			winnerConditions.add(midRow);
			winnerConditions.add(botRow);
			winnerConditions.add(leftCol);
			winnerConditions.add(midCol);
			winnerConditions.add(rightCol);
			winnerConditions.add(cross1);
			winnerConditions.add(cross2);
			
		for(List l : winnerConditions) {
			if(playerPositions.containsAll(l)) {
				System.out.println("Congrats! You won!");
			} else if(cpuPositions.containsAll(l)) {
				System.out.println("Sorry you loss!");
			} else if(playerPositions.size() + cpuPositions.size() == 9) {
				System.out.println("It's a tie!");
			}
		}
			
			return "";
	}
	
}