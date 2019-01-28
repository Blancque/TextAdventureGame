import java.util.Scanner;

public class Game {
	
	Scanner enterScanner = new Scanner(System.in);;//if you think other methods will use the variable then enter them here in the public class
	Scanner myScanner = new Scanner(System.in);; //we have decreed that this is myScanner to the entire class which holds all (entered)methods
	int playerHP; //we have established player HP as integer
	String playerName;//we have established player name
	String playerWeapon;//we have established player weapon
	int choice; //we have established choice as integer
    int enemyHP;
    String enemyWeapon;
    int silverRing;
    
    
    
	public static void main(String[] args) {
	                        //if you want to access another method from this main method, you must give it a name (as seen in first line) 
		Game dublin;          // here we gave Game a name, dublin
		dublin = new Game();  // dublin is game class
		
		dublin.playerSetUp(); // We are calling playerSetUp method(below) which is inside game class hence game. (this is the games playerSetUp method)
	    dublin.townGate();    // now this main method is going to call the townGate method below(which it will do AFTER playerSetUp)
	    dublin.ending();
	    dublin.dead();
	    dublin.win();
		
		
	}

	public void playerSetUp() {
		
		
	    
		playerHP = 15;
		enemyHP = 9;
		
		playerWeapon = "Knife";
		
		System.out.println("Your HP: "+ playerHP);
		System.out.println("Your Weapon is: " + playerWeapon);
		
		
		
		
 
		
		System.out.println("Please Enter your Name: "); //ask player their name
		
		playerName = myScanner.nextLine(); //this way we can receive what what player typed with their input and puts it in the playerName string
		
		System.out.println("Hello " + playerName +"," + " let's start your adventure!");
		
	}
	
	
	public void townGate() {
	    System.out.println("\n------------------------------------------------\n"); //this will work as a blank line, you can do multiple line breaks in one line of string
		System.out.println("You are at the towngate.");
		System.out.println("A guard is standing infront of you.");
		System.out.println("What do you want to do? "); //this represent the choice
		System.out.println("\n");
		System.out.println("1: Talk to the Guard");
		System.out.println("2: Attack the Guard");
		System.out.println("3: Leave");
		System.out.println("\n------------------------------------------------\n");
		
		
		choice = myScanner.nextInt(); //choice is empty. We are asking player to type some number and it will be put in "choice" variable
		
		if(choice==1) {//this means if the number the player input is equal to one then 
			if(silverRing==1) {
				ending();
				
			}
			else {
			 System.out.println("Guard: Hello there stranger. So your name is " + playerName + "?\nGuard: Sorry but we cannot allow a stranger into our town.");//this text will be printed
			 enterScanner.nextLine();//the program will stop because it is wating for an input
			 townGate();//here all we are doing is saying after the system.out print return to the beginning of this method
			}
		}
		else if(choice==2) {
			playerHP = playerHP -1;
			System.out.println("Guard: Hey, don't be stupid. \n\nThe guard hit you very hard, and you decide to give up.\n(You recieve 1 damage.)");
			System.out.println("Your HP: " + playerHP);
			enterScanner.nextLine();
			townGate();

		}
		else if (choice==3) {
			crossRoad(); //this can be called here as it is not important to the main method ie. playerSetup and e.g gameIntro
			
		}
		else {
			townGate();
		}
	}
	
	public void crossRoad() {
		System.out.println("\n------------------------------------------------\n");
		System.out.println("You are at a crossroad. If you go south, you will arrive back at the town.\n\n");
		System.out.println("1: Go north?");
		System.out.println("2: Go east?");
		System.out.println("3: Go west?");
		System.out.println("4: Go south?");
		System.out.println("\n------------------------------------------------\n");
		
		choice = myScanner.nextInt();
		
		if (choice==1) {
			north();
		}
		if (choice==2) {
			east();
		}
		if (choice==3) {
			west();
		}
		if (choice==4) {
			townGate();
		}
		else {
			crossRoad();
		}
	}
	
	
	public void north() {
		System.out.println("\n------------------------------------------------\n");
		System.out.println("There is a river, you drink the water and rest at the riverside.");
		System.out.println("Your HP is recovered.");
		playerHP = playerHP +1;
		System.out.println("Your HP is: "+ playerHP);
		System.out.println("\n\n 1: Go back to the crossroad?");
		System.out.println("\n------------------------------------------------\n");
		
		choice = myScanner.nextInt();
		
		if (choice==1) {
			crossRoad();
		}
		else {
			playerHP = playerHP -1;
			north();
			
		}
	}
	
	public void east() {
		System.out.println("\n------------------------------------------------\n");
		System.out.println("You walked into a forest and found a Rusty Rapier!");
		playerWeapon = "Rusty Rapier";
		System.out.println("Your Weapon: " + playerWeapon);
		System.out.println("\n\n 1: Go back to the crossroad?");
		System.out.println("\n------------------------------------------------\n");
		
		choice = myScanner.nextInt();
		
		if (choice==1) {
			crossRoad();
		}
		else {
			east();
		}
		
	}
	
	public void west() {
		System.out.println("\n------------------------------------------------\n");
		System.out.println("You encounter a goblin!\n");
		System.out.println("1: Fight?");
		System.out.println("2: Run!");
		System.out.println("\n------------------------------------------------\n");
		
		choice = myScanner.nextInt();
		
		if (choice==1) {
			fight();
		}
		if (choice==2) {
			crossRoad();
		}
		else {
			west();
		}
	}
	public void fight() {
		
		System.out.println("\n------------------------------------------------\n");
		System.out.println("Your HP: "+ playerHP);
		System.out.println("Your Weapon: " + playerWeapon);
		System.out.println("\n");
		System.out.println("Enemy HP: " + enemyHP);
		System.out.println("1: Attack?");
		System.out.println("2: Run!");
		System.out.println("\n------------------------------------------------\n");
		
		choice = myScanner.nextInt();
		
		if (choice==1) {
			attack();
		}
		if (choice==2) {
			crossRoad();
		}
		else {
			fight();
		}
	}
	public void attack() {
		int playerDamage =0;
		
		
		
		if(playerWeapon.equals("Knife")) {
			playerDamage = new java.util.Random().nextInt(5);//this code will pick up some random number in this case between 0-4
		}
		if(playerWeapon.equals("Rusty Rapier")) {
			playerDamage = new java.util.Random().nextInt(8);
		}
		
		System.out.println("You attacked the enemy and gave "+ playerDamage + " damage.\n");
		
		enemyHP = enemyHP  - playerDamage;
		
		System.out.println("Enemy HP: " + enemyHP);
		
		if (enemyHP <1) {
			win();
		}
		else if(enemyHP >0) {
			int monsterDamage =0;
			
			monsterDamage = new java.util.Random().nextInt(4);
			System.out.println("The monster attacked you and gave "+ monsterDamage +" damage!\n");
			playerHP = playerHP -monsterDamage;
			
			System.out.println("Your HP: "+ playerHP);
			
		    if (playerHP<1){
			  dead();
			
		}
		    else if (playerHP>0) {
			  fight();
		}
		    
		}

		
		
		
	}
	public void dead() {
		System.out.println("\n------------------------------------------------\n");
		System.out.println("You are DEAD!!!");
		System.out.println("\n------------------------------------------------\n");
		System.out.println("\n GAME OVER!!!");
		System.out.println("\n------------------------------------------------\n");
		
		
	}
	public void win() {
		System.out.println("\n------------------------------------------------\n");
		System.out.println("You killed the enemy!");
		System.out.println("You notice a glint of silver as the goblin falls to the ground.");
		System.out.println("The goblin dropped a ring!");
		System.out.println("Congratulations! You obtained the Silver Ring!\n\n");
		System.out.println("\n------------------------------------------------\n");
		System.out.println("1: Go East?");
		System.out.println("\n------------------------------------------------\n");
		
		silverRing = 1;
		
		choice = myScanner.nextInt();
		if (choice==1) {
			crossRoad();
		
	}
		else {
			win();
			
		}
}
	public void ending() {
		System.out.println("\n------------------------------------------------\n");
		System.out.println("Guard: Oh you killed that goblin!?? Great!");
		System.out.println("Guard: You seem like a trustworthy guy. Welcome to our town.");
		System.out.println("\n-\n");
		System.out.println("\n-------------------THE END ---------------------\n");
		System.out.println("\n------------------------------------------------\n");
		
	}
	
}
