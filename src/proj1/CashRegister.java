/**
 * File:    CashRegister
 * Project: 1
 * Author:  Dave Van
 * Date:    9/20/10
 * Section: 07
 * E-mail:  dvan3@umbc.edu
*/

package proj1;

public class CashRegister {
	
	//constants
	private static final int BILLS     = 4, 
							 FIVE      = 5, 
							 TEN       = 10, 
							 TWENTY    = 20,
							 SLOTONE   = 0,
							 SLOTTWO   = 1,
							 SLOTTHREE = 2,
							 SLOTFOUR  = 3;
	
	//variables
	private boolean unlockReg;
	
	//array 
	private int [] cash = new int[BILLS];
	
	/**
	* Name: CashRegister
	* Description: CashRegister Constructor 
	* PreCondition: none
	* PostCondition: Stores each variable into the array
	*/
	public CashRegister(){
		
		cash[SLOTONE] = 0;
		cash[SLOTTWO] = 0;
		cash[SLOTTHREE] = 0;
		cash[SLOTFOUR] = 0;
		unlockReg = true;
		
	}
	
	/**
	* Name: addMoney
	* Description: Adds money
	* PreCondition: none
	* PostCondition: Adds the amount to the array
	*/
	public void addMoney(int one, int five, int ten, int twenty){
		
		cash[SLOTONE] += one;
		cash[SLOTTWO] += five;
		cash[SLOTTHREE] += ten;
		cash[SLOTFOUR] += twenty;
		
	}
	
	/**
	* Name: removeMoney
	* Description: Removes money and checks if there is enough money to remove
	* PreCondition: The indexed array is less than zero
	* PostCondition: Returns an error or subtracts the array with the amount
	*/
	public String removeMoney(int one, int five, int ten, int twenty){
		
		if(cash[SLOTONE] - one < 0){
			return "\nRemoving too much or no money\n";
		}
		else{
			cash[SLOTONE] -= one;
		}
		if(cash[SLOTTWO] - five < 0){
			return "\nRemoving too much or no money\n";
		}
		else{
			cash[SLOTTWO] -= five;
		}
		if(cash[SLOTTHREE] - ten < 0){
			return "\nRemoving too much or no money\n";
		}
		else{
			cash[SLOTTHREE] -= ten;
		}
		if(cash[SLOTFOUR] - twenty < 0){
			return "\nRemoving too much or no money\n";
		}
		else{
			cash[SLOTFOUR] -= twenty;
		}
		return "";
		
	}
	
	/**
	* Name: setLockRegister
	* Description: Locks the register
	* PreCondition: The register is unlocked
	* PostCondition: Returns false to lock the register
	*/
	public boolean setLockRegister(){
		
		unlockReg = false;
		
		return unlockReg;
		
	}
	
	/**
	* Name: setUnlockRegister
	* Description: Unlocks the register
	* PreCondition: The register is locked
	* PostCondition: Returns true to unlock the register
	*/
	public boolean setUnlockRegister(){
		
		unlockReg = true;
		
		return unlockReg;
		
	}
	
	/**
	* Name: getOneDollars
	* Description: Gets how many one dollar bills
	* PreCondition: none
	* PostCondition: Returns how many one dollar bills there are
	*/
	private int getOneDollars(){
		
		return cash[SLOTONE];
		
	}
	
	/**
	* Name: getFiveDollars
	* Description: Gets how many five dollar bills
	* PreCondition: none
	* PostCondition: Returns how many five dollar bills there are
	*/
	private int getFiveDollars(){
		
		return cash[SLOTTWO];
		
	}
	
	/**
	* Name: getTenDollars
	* Description: Gets how many ten dollar bills
	* PreCondition: none
	* PostCondition: Returns how many ten dollar bills there are
	*/
	private int getTenDollars(){
	
		return cash[SLOTTHREE];
	
	}

	/**
	* Name: getTwentyDollars
	* Description: Gets how many ten dollar bills
	* PreCondition: none
	* PostCondition: Returns how many twenty dollar bills there are
	*/
	private int getTwentyDollars(){
	
		return cash[SLOTFOUR];
	
	}
	
	/**
	* Name: getLockState
	* Description: Gets whether the register is locked or unlocked
	* PreCondition: UnlockReg is unlocked
	* PostCondition: Returns whether it is locked or unlocked
	*/
	private String getLockState(){
		
		if(unlockReg == true){
			return "Unlocked";
		}
		else{
			return "Locked";
		}
		
	}
	
	/**
	* Name: getLockStateTwo
	* Description: Gets whether the register is locked or unlocked
	* PreCondition: UnlockReg is unlocked
	* PostCondition: Returns true if register is unlocked, returns false if
	*                register is locked
	*/
	public boolean getLockStateTwo(){
			
		if(unlockReg == true){
			return true;
		}
		else{
			return false;	
		}
		
	}
	
	/**
	* Name: getTotalMoney
	* Description: Gets the total money in the register
	* PreCondition: none
	* PostCondition: Returns the total money
	*/
	private int getTotalMoney(){
		
		return cash[SLOTONE] + (cash[SLOTTWO] * FIVE) + (cash[SLOTTHREE] * TEN) + (cash[SLOTFOUR] * TWENTY);
	}
	
	/**
	* Name: setMoney
	* Description: Sets all of the indexes in the array to 0
	* PreCondition: none
	* PostCondition: Sets all of the indexes in the array to 0
	*/
	public void setMoney(){
		
		cash[SLOTONE] = 0;
		cash[SLOTTWO] = 0;
		cash[SLOTTHREE] = 0;
		cash[SLOTFOUR] = 0;
		
	}
	
	/**
	* Name: toString
	* Description: Displays the status of the register
	* PreCondition: none
	* PostCondition: The calling object is returned in the format
	*                <Label> <state>
	*/
	public String toString(){
		
		return "\nRegister status:      " + getLockState()
				+ "\nOne dollar bills:        " + getOneDollars()
				+ "\nFive dollar bills:       " + getFiveDollars()
				+ "\nTen dollar bills:        " + getTenDollars()
				+ "\nTwenty dollar bills:     " + getTwentyDollars()
				+ "\nTotal Cash in register: $" + getTotalMoney();
		
	}
	
}