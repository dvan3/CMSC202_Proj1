/**
 * File:    Project1
 * Project: 1
 * Author:  Dave Van
 * Date:    9/20/10
 * Section: 07
 * E-mail:  dvan3@umbc.edu
 * TEST
*/

package proj1;

//import scanner
import java.util.Scanner;

public class Project1 {
	
	//scanner
	private static Scanner input = new Scanner(System.in);
	
	//constants
	private static final int    REGISTERONE = 1,
								REGISTERTWO = 2,
			     				MINREG      = 1,
			     				MAXREG      = 2;
	
	//creating two cash registers
	private static CashRegister registerOne = new CashRegister();
	private static CashRegister registerTwo = new CashRegister();
	
	public static void main(String[] args){
				
		//initializing variables
		String choiceS = null;
		char choice;
		
		//opening the store
		openStore();
		
		//displaying main menu
		displayMenu();
		
		//Ask user to input their choice
		System.out.print("\nEnter your choice: ");
		choiceS = input.next();
		choice = choiceS.charAt(0);
		
		//Depending on the choice uses the specific case
		while (choice != '~' && choice != '`'){
			
			switch(choice){
				
				//If user chooses to add money
				case 'A':
				case 'a':		
					addMoney();				
					break;
					
				//If user chooses to remove money
				case 'R':
				case 'r':				
					removeMoney();				
					break;
					
				//If user chooses to transfer money
				case 'T':
				case 't':				
					transferMoney();				
					break;
					
				//If user chooses to lock a register
				case 'L':
				case 'l':				
					lockRegister();			
					break;
					
				//If user chooses to unlock a register
				case 'U':
				case 'u':				
					unlockRegister();						
					break;
					
				//If user chooses to display the state of  a register
				case 'S':
				case 's':		
					displayState();
					break;
					
				//If user chooses to close the store
				case 'C':
				case 'c':	
					closeStore();
					break;
				default:
					
					//user enters invalid choice
					System.out.println("\n" + choice + " is not a valid choice");
		
			}
			displayMenu();
			System.out.print("\nEnter your choice: ");
			choiceS = input.next();
			choice = choiceS.charAt(0);
		}
	}
	
	/**
	* Name: displayMenu
	* Description: Displays the menu for the user
	* PreCondition:  none
	* PostCondition: Prints out the main menu
	*/
	private static void displayMenu(){
		
		//prints menu
		System.out.println("\nA - Add money"
							+ "\nR - Remove money"
							+ "\nT - Transfer money"
							+ "\nL - Lock register"
							+ "\nU - Unlock register"
							+ "\nS - Display register state"
							+ "\nC - Close the store and quit");
		
	}
	
	/**
	* Name: getValidInt
	* Description: Gets a valid integer from the user, if it isn't, it will
	* 			   keep asking for a valid integer.
	* PreCondition: The value is an invalid integer
	* PostCondition: Returns a valid integer
	*/
	private static int getValidInt(int min, int max){
		
		//start off with invalid integer
		int value = min - 1;
		
		//prompts user for input
		System.out.print("\nWhich register(1 or 2): ");
		value = input.nextInt();
		
		//while invalid keep asking until a valid is inputed
		while(value < min || value > max){
			System.out.println("\nInvalid choice please try again");
			System.out.print("\nWhich register(1 or 2): ");
			value = input.nextInt();
			
		}
		return value;
		
	}
	
	/**
	* Name: openStore
	* Description: Adds money to both registers
	* PreCondition: none
	* PostCondition: Adds money to both registers
	*/
	private static void openStore(){
		
		System.out.println("Welcome to Pop's Convenience Store\n");
		
		//adding bills to both registers
		System.out.print("How many 1s: ");
        int ones = input.nextInt();
        
        if(ones < 0){            	
        	System.out.print("\nCannot be less than 0\n"
        					+ "No money was added to either register\n");
        }
        else{	            	
        	System.out.print("How many 5s: ");
        	int fives = input.nextInt();
        	
        	if(fives < 0){	            		
        		System.out.print("\nCannot be less than 0\n"
    					+ "No money was added to either register\n");           	
        	}
        	else{	            		
        		System.out.print("How many 10s: ");
	            int tens = input.nextInt();
	            
	            if(tens < 0){	    	            	
	            	System.out.print("\nCannot be less than 0\n"
        					+ "No money was added to either register\n");    	            	
	            }
	            else{
	            	System.out.print("How many 20s: ");
		            int twenty = input.nextInt();
	            	
		            if(twenty < 0){	    		            	
		            	System.out.print("\nCannot be less than 0\n"
	        					+ "No money was added to either register\n");    		            	
		            }
		            else{
		            	
		            	registerOne.addMoney(ones, fives, tens, twenty);
		        		registerTwo.addMoney(ones, fives, tens, twenty);	
		            }
	            }
        	}
        }
	}
	
	/**
	* Name: addMoney
	* Description: Adds money to the chosen register
	* PreCondition: none
	* PostCondition: Adds money to the chosen register
	*/
	private static void addMoney(){
		
		//choosing a register
		int register = getValidInt(MINREG, MAXREG);
		
		//add to register one
		if(register == REGISTERONE){
			
			//check if locked
			if(registerOne.getLockStateTwo() == false){
				System.out.print("\nThis register is locked\n");			
			}
			else{
				System.out.println("\nOpenning register one...\n");				
				System.out.print("How many 1s: ");
	            int ones = input.nextInt();
	            
	            if(ones < 0){            	
	            	System.out.print("\nCannot be less than 0\n");            	
	            }
	            else{	            	
	            	System.out.print("How many 5s: ");
	            	int fives = input.nextInt();
	            	
	            	if(fives < 0){	            		
	            		System.out.print("\nCannot be less than 0\n");	           	
	            	}
	            	else{	            		
	            		System.out.print("How many 10s: ");
	    	            int tens = input.nextInt();
	    	            
	    	            if(tens < 0){	    	            	
	    	            	System.out.print("\nCannot be less than 0\n");	    	            	
	    	            }
	    	            else{
	    	            	System.out.print("How many 20s: ");
	    		            int twenty = input.nextInt();
	    	            	
	    		            if(twenty < 0){	    		            	
	    		            	System.out.print("\nCannot be less than 0\n");	    		            	
	    		            }
	    		            else{
	    		            	
	    		            	System.out.print("\nAdding money...done\n");
	    						registerOne.addMoney(ones, fives, tens, twenty);	
	    		            	}
	    	            	}
	            		}
					}
				}	
			}
		//add to register two
		else if(register == REGISTERTWO){
			
			//check if locked
			if(registerTwo.getLockStateTwo() == false){			
				System.out.print("\nThis register is locked\n");
			}
			else{
				System.out.println("\nOpenning register two...\n");				
				System.out.print("How many 1s: ");
	            int ones = input.nextInt();
	            if(ones < 0){
	            	
	            	System.out.print("\nCannot be less than 0\n");	            	
	            }
	            else{	            	
	            	System.out.print("How many 5s: ");
	            	int fives = input.nextInt();
	            	
	            	if(fives < 0){	            		
	            		System.out.print("\nCannot be less than 0\n");	           	
	            	}
	            	else{	            		
	            		System.out.print("How many 10s: ");
	    	            int tens = input.nextInt();
	    	            
	    	            if(tens < 0){	    	            	
	    	            	System.out.print("\nCannot be less than 0\n");	    	            	
	    	            }
	    	            else{
	    	            	System.out.print("How many 20s: ");
	    		            int twenty = input.nextInt();
	    	            	
	    		            if(twenty < 0){	    		            	
	    		            	System.out.print("\nCannot be less than 0\n");	    		            	
	    		            }
	    		            else{	    		            	
	    		            	System.out.print("\nAdding money...done\n");
	    						registerTwo.addMoney(ones, fives, tens, twenty);		
	    		            	}
	    	            	}
	            		}
					}
				}
			}
		}
	/**
	* Name: removeMoney
	* Description: Removes money from the chosen register
	* PreCondition: none
	* PostCondition: Removes money from the chosen register
	*/
	private static void removeMoney(){
		
		//choosing register
		int register = getValidInt(MINREG, MAXREG);
		
		//remove from register one
		if(register == REGISTERONE){
			
			//check if locked
			if(registerOne.getLockStateTwo() == false){	
				System.out.print("\nThis register is locked\n");
			}
			else{
				System.out.println("\nOpenning register one...\n");				
				System.out.print("How many 1s: ");
	            int ones = input.nextInt();
	            
	            if(ones < 0){	            	
	            	System.out.print("\nCannot be less than 0\n");	            	
	            }
	            else{	            	
	            	System.out.print("How many 5s: ");
	            	int fives = input.nextInt();
	            	
	            	if(fives < 0){	            		
	            		System.out.print("\nCannot be less than 0\n");	           	
	            	}
	            	else{	            		
	            		System.out.print("How many 10s: ");
	    	            int tens = input.nextInt();
	    	            
	    	            if(tens < 0){	    	            	
	    	            	System.out.print("\nCannot be less than 0\n");	    	            	
	    	            }
	    	            else{
	    	            	System.out.print("How many 20s: ");
	    		            int twenty = input.nextInt();
	    	            	
	    		            if(twenty < 0){	    		            	
	    		            	System.out.print("\nCannot be less than 0\n");	    		            	
	    		            }
	    		            else{
	    		            	String word = registerOne.removeMoney(ones, fives, tens, twenty);	
	    		            	System.out.print(word);
	    		            	}
	    	            	}
	            		}
					}
				}	
			}
		//remove from register two
		else if(register == REGISTERTWO){
			
			//check if locked
			if(registerTwo.getLockStateTwo() == false){
				System.out.print("\nThis register is locked\n");
			}
			else{
				System.out.println("\nOpenning register two...\n");				
				System.out.print("How many 1s: ");
	            int ones = input.nextInt();
	            
	            if(ones < 0){	            	
	            	System.out.print("\nCannot be less than 0\n");	            	
	            }
	            else{	            	
	            	System.out.print("How many 5s: ");
	            	int fives = input.nextInt();
	            	
	            	if(fives < 0){	            		
	            		System.out.print("\nCannot be less than 0\n");	           	
	            	}
	            	else{
	            		
	            		System.out.print("How many 10s: ");
	    	            int tens = input.nextInt();
	    	            
	    	            if(tens < 0){	    	            	
	    	            	System.out.print("\nCannot be less than 0\n");	    	            	
	    	            }
	    	            else{
	    	            	System.out.print("How many 20s: ");
	    		            int twenty = input.nextInt();
	    	            	
	    		            if(twenty < 0){	    		            	
	    		            	System.out.print("\nCannot be less than 0\n");	    		            	
	    		            }
	    		            else{
	    						String word = registerTwo.removeMoney(ones, fives, tens, twenty);	
	    						System.out.print(word);
	    		            	}
	    	            	}
	            		}
					}
				}
			}
		}
	
	/**
	* Name: transferMoney
	* Description: Transfers money from one register to another
	* PreCondition: none
	* PostCondition: Transfers money from one register to another
	*/
	private static void transferMoney(){
		
		//choosing register
		int register = getValidInt(MINREG, MAXREG);
		
		//transferring money from register one to two
		if( register == REGISTERONE){
			
			//check if one or both register is locked
			if(registerOne.getLockStateTwo() == false || registerTwo.getLockStateTwo() == false){
				System.out.print("\nOne or both registers is locked\n");
			}
			else{
				System.out.println("\nOpenning register one and two...\n");				
				System.out.print("How many 1s: ");
	            int ones = input.nextInt();
	            
	            if(ones < 0){     	
	            	System.out.print("\nCannot be less than 0\n");	            	
	            }
	            else{	            	
	            	System.out.print("How many 5s: ");
	            	int fives = input.nextInt();
	            	
	            	if(fives < 0){	            		
	            		System.out.print("\nCannot be less than 0\n");	           	
	            	}
	            	else{	            		
	            		System.out.print("How many 10s: ");
	    	            int tens = input.nextInt();
	    	            
	    	            if(tens < 0){	    	            	
	    	            	System.out.print("\nCannot be less than 0\n");	    	            	
	    	            }
	    	            else{
	    	            	System.out.print("How many 20s: ");
	    		            int twenty = input.nextInt();
	    	            	
	    		            if(twenty < 0){	    		            	
	    		            	System.out.print("\nCannot be less than 0\n");
	    		            }
	    		            else{
	    		            	String removeTran = registerOne.removeMoney(ones, fives, tens, twenty);
	    						System.out.print(removeTran);
	    						if(removeTran == ""){
	    							registerTwo.addMoney(ones, fives, tens, twenty);
	    						}
	    						else{
	    							System.out.println("Cannot add cash");
	    		            	}
	    	            	}
	            		}
					}
				}	
			}
		}
		
		//transferring money from register two to one
		else if(register == REGISTERTWO){
			
			//check if one or both register is locked
			if(registerOne.getLockStateTwo() == false || registerTwo.getLockStateTwo() == false){
				System.out.print("\nOne or both registers is locked\n");
			}
			else{
				System.out.println("\nOpenning register two and one...\n");
				System.out.print("How many 1s: ");
	            int ones = input.nextInt();
	            
	            if(ones < 0){     	
	            	System.out.print("\nCannot be less than 0\n");     	
	            }
	            else{	            	
	            	System.out.print("How many 5s: ");
	            	int fives = input.nextInt();
	            	
	            	if(fives < 0){	            		
	            		System.out.print("\nCannot be less than 0\n");
	            	}
	            	else{
	            		System.out.print("How many 10s: ");
	    	            int tens = input.nextInt();
	    	            
	    	            if(tens < 0){
	    	            	System.out.print("\nCannot be less than 0\n");
	    	            }
	    	            else{
	    	            	System.out.print("How many 20s: ");
	    		            int twenty = input.nextInt();
	    	            	
	    		            if(twenty < 0){
	    		            	System.out.print("\nCannot be less than 0\n");
	    		            }
	    		            else{
	    		            	String removeTranTwo = registerTwo.removeMoney(ones, fives, tens, twenty);
	    						System.out.print(removeTranTwo);
	    						if(removeTranTwo == ""){
	    							registerOne.addMoney(ones, fives, tens, twenty);
	    						}
	    						else{
	    							System.out.println("Cannot add cash");
	    		            	}
	    	            	}
	            		}
					}
				}
			}
		}
	}
	
	/**
	* Name: lockRegister
	* Description: Locks the chosen register
	* PreCondition: either locked or unlocked
	* PostCondition: Locks the chosen register
	*/
	private static void lockRegister(){
		
		//choosing register
		int register = getValidInt(MINREG, MAXREG);
		
		//locking register one
		if(register == REGISTERONE){
			
			//check if locked
			if(registerOne.getLockStateTwo() == false){
				System.out.print("\nThis registers is already locked\n");
			}
			else{
				System.out.println("\nLocking register " + register);
				registerOne.setLockRegister();
			}
		}	
		//locking register two
		else if(register == REGISTERTWO){
			
			//check if locked
			if(registerTwo.getLockStateTwo() == false){
				System.out.print("\nThis registers is already locked\n");
			}
			else{
				System.out.println("\nLocking register " + register);
				registerTwo.setLockRegister();
			}
		}
	}
	
	/**
	* Name: unlockRegister
	* Description: Unlocks the chosen register
	* PreCondition: either locked or unlocked
	* PostCondition: Unlocks the chosen register
	*/
	private static void unlockRegister(){
		
		//choosing register
		int register = getValidInt(MINREG, MAXREG);
		
		//unlocking reigster one
		if(register == REGISTERONE){
			
			//check if unlocked
			if(registerOne.getLockStateTwo() == true){
				System.out.print("\nThis registers is already unlocked\n");
			}
			else{
				System.out.println("\nUnlocking register " + register);
				registerOne.setUnlockRegister();
			}	
		}	
		//unlocking register two
		else if(register == REGISTERTWO){
			
			//check if unlocked
			if(registerTwo.getLockStateTwo() == true){
				System.out.print("\nThis registers is already unlocked\n");
			}
			else{
				System.out.println("\nUnlocking register " + register);
				registerTwo.setUnlockRegister();
			}
		}
	}
	
	/**
	* Name: displayState
	* Description: Displays the status of the chosen register
	* PreCondition: none
	* PostCondition: Displays the status of the chosen register
	*/
	private static void displayState(){
		
		//choosing register
		int register = getValidInt(MINREG, MAXREG);
		
		//displaying status of reigster one
		if(register == REGISTERONE){
			System.out.println("\nDisplaying status of register one...");
			System.out.println(registerOne.toString());
		}	
		
		//displaying status of reigster two
		else if(register == REGISTERTWO){
			System.out.println("\nDisplaying status of register two...");
			System.out.println(registerTwo.toString());
		}					
	}
	
	/**
	* Name: closeStore
	* Description: Closes the store by remove money from both registers
	*              and locking both registers
	* PreCondition: none
	* PostCondition: Removes money from both registers, locks both registers
	*                and displays the status of both registers
	*/
	private static void closeStore(){
		
		//removing all the money
		System.out.println("\nClosing up shop...removing money...");
		registerOne.setMoney();
		registerTwo.setMoney();
		
		//locking registers
		System.out.println("\nLocking registers...");
		registerOne.setLockRegister();
		registerTwo.setLockRegister();
		
		//displaying status of registers
		System.out.println("\nDisplaying status of register one...");
		System.out.println(registerOne.toString() + "\n");
		System.out.println("Displaying status of register two...");
		System.out.println(registerTwo.toString());
		System.out.println("\nHave a nice day! =]");
		
		//exit program
		System.exit(0);
		
	}
	
}
