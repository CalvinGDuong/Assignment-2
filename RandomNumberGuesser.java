/*
 * Class: CMSC203 
 * Instructor: Professor Khandan Vahabzadeh Monshi
 * Description: Driver class for RNG
 * Due: 9/28/2021
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Calvin Duong
*/
import java.util.*;

public class RandomNumberGuesser {
	
	public static void main(String[] args) {
		System.out.println("\t\tRandom Number Guesser\t\t\n");//header
		
		Scanner input = new Scanner(System.in);//scanner object to store user input
		
		//variables
		int flag1 = 1;
		int flag2 = 1;
		int guess;
		int max = 100;
		int min = 0;
		String entry = " ";
		
		while(flag1 > 0){
			
			System.out.println("Enter your first guess (between 0 and 100)");//request user input and stores it
			guess = input.nextInt();
			input.nextLine();
			
			int nbr = RNG.rand();//generates random numb
			
			while(flag2 == 1) {
				RNG.inputValidation(guess, min, max);
				System.out.println("Number of guesses is " + RNG.getCount());//displays the number of guesses
				
				if(guess == nbr) {//if input matches with randomly generated number
				System.out.println("Congratulations, you guessed correctly \n Try again?(yes or no)");
				entry = input.nextLine();
					if(entry.equals("yes")){
					RNG.resetCount();//resets guesses
					flag2 = 0;
					max = 100;//resets variables if user runs game again
					min = 0;
					entry = " ";
					break;
					}	
					else {
					flag1 = 0;//shuts off while loops
					flag2 = 0;
					break;
					}
				}
				
				else if(guess > nbr) {//checks if guess is lower than random generated number
					System.out.println("Your guess is too high");
					if(guess < max) {
						max = guess;
					}
				}
				
				else {//checks if guess is higher than generated number
					System.out.println("Your guess is too low");
					if(guess > min) {
						min = guess;
					}
				}
				System.out.println("Enter your next guess between " + min + " and " + max);//displays message for next guess to be in between 2 numbers
				guess = input.nextInt();
				input.nextLine();
			}
			flag2 = 1;

		}
			System.out.println("Thanks for playing");//displays thank you message
			input.close();
			System.out.println("Programmer: Calvin Duong");//programmer message
		}
}

