
public class Game {
	//necessary variables
	private Queue player1;
	private Queue player2;
	private int p1Score;
	private int p2Score;
	
	//constructor
	public Game() {
		player1 = new Queue(100000);
		player2 = new Queue(100000);
		p1Score=0;
		p2Score=0;
	}
	
	//main method for the game
	public void run() {
		for(int i=0;i<15;i++) {
			boolean Yahtzee=false; //flag for yahtzee situation
			boolean Straight=false;//flag for straight situation
			for(int j=0;j<3;j++) {
			int p1Dice=(int)(Math.random()*6)+1;//initializion random for player 1
			player1.enqueu(p1Dice);//enqueue random into player1 queue
			}
			
			for(int j=0;j<3;j++) {
				int p2Dice=(int)(Math.random()*6)+1;//initializion random for player 2
				player2.enqueu(p2Dice);//enqueue random into player1 queue
			}
			System.out.print("\n-------------- TURN "+(i+1)+"-----------------");
			//displaying method for player 1
			System.out.print("\nPlayer 1: ");
			for(int j=0;j<player1.size();j++) {
				System.out.print(player1.peek()+" ");
				player1.enqueu(player1.dequeue());
			}
			System.out.print("                  score: "+p1Score);
			//displaying method for player 1
			
			//displaying method for player 2
			System.out.print("\nPlayer 2: ");
			for(int j=0;j<player2.size();j++) {
				System.out.print(player2.peek()+" ");
				player2.enqueu(player2.dequeue());
			}
			System.out.print("                  score: "+p2Score);
			//displaying method for player 2
			
			//controlling yahtzee and straight for player 1
			if(!(player1.isEmpty())) {
				int straight=0;//initializion counter for straight situation.
				for(int j=1;j<=6;j++) {
					int sameCounter=0;//initializion counter for yahtzee situation.
					for(int k=0;k<player1.size();k++) {
						if((int)(player1.peek())==j) {//if there ara same number same counter will increase
							sameCounter++;
						}
						player1.enqueu(player1.dequeue());
					}
					// if there are 4 or more than same counter, program find 4 of these numbers and dequeue them.
					if(sameCounter>=4) { 
						int counter=0;
						int tempSize=player1.size();
						for(int k=0;k<tempSize;k++) {
							if(Integer.parseInt(player1.peek().toString())==j & counter<4) {
								player1.dequeue();
								counter++;
							}
							else {
								player1.enqueu(player1.dequeue());
							}
						}
						// if there are 4 or more than same counter, program find 4 of these numbers and dequeue them.
						p1Score+=20;//and then player 1 gain 20 point
						Yahtzee=true; //yahtzee flag returns true for second display
					}
					boolean straightFlag=false;//initializion flag for straight situation.
					//program find the numbers between 1 to 6 and if find it, flag returns true.
					for(int k=0;k<player1.size();k++) {
						if((int)(player1.peek())==j) {
							straightFlag=true;
						}
						else {
							player1.enqueu(player1.dequeue());
						}
					}
					//program find the numbers between 1 to 6 and if find it, flag returns true.
					if(straightFlag) {
						straight++; //if flag is true , counter increase
					}
					if(straight==6) {//if counter is 6, that is mean there are six number between 1 to 6.
						for(int m=1;m<=6;m++) {//Numbers from 1 to 6 are checked sequentially
							int tempSize=player1.size();//initialize the size of queue according to player 1's queue
							boolean flag=false;//if the number has not been found before, flag is false
							for(int k=0;k<tempSize;k++) {
								if(Integer.parseInt(player1.peek().toString())==m) {//program find the number and dequeue them.
									if(!flag) {//if the number has been found before,program dont enter this condition
										player1.dequeue();
										flag=true;//flag return if number is found.
									}
								}
								else {
									player1.enqueu(player1.dequeue());
								}
							}
						}
						p1Score+=10;//and then player 1 gain 10 point
						Straight=true;//Straight flag returns true for second display
					}
					}
				}
			//controlling yahtzee and straight for player 1
			
			//controlling yahtzee and straight for player 2
			if(!(player2.isEmpty())) {
				int straight=0;//initializion counter for straight situation.
				for(int j=1;j<=6;j++) {
					int sameCounter=0;//initializion counter for yahtzee situation.
					for(int k=0;k<player2.size();k++) {
						if((int)player2.peek()==j) {//if there are same number same counter will increase
							sameCounter++;
						}
						player2.enqueu(player2.dequeue());
					}
					// if there are 4 or more than same counter, program find 4 of these numbers and dequeue them.
					if(sameCounter>=4) {
						int counter=0;
						int tempSize=player2.size();
						for(int k=0;k<tempSize;k++) {
							if(Integer.parseInt(player2.peek().toString())==j && counter<4) {
								player2.dequeue();
								counter++;
							}
							else {
								player2.enqueu(player2.dequeue());
							}
						}
						// if there are 4 or more than same counter, program find 4 of these numbers and dequeue them.
						p2Score+=20;//and then player 2 gain 20 point
						Yahtzee=true;//yahtzee flag returns true for second display
					}
					boolean straightFlag=false;//initializion flag for straight situation.
					//program find the numbers between 1 to 6 and if find it, flag returns true.
					for(int k=0;k<player2.size();k++) {
						if((int)(player2.peek())==j) {
							straightFlag=true;
						}
						else {
							player2.enqueu(player2.dequeue());
						}
					}
					//program find the numbers between 1 to 6 and if find it, flag returns true.
					
					if(straightFlag) {
						straight++;//if flag is true , counter increase
					}
					if(straight==6) {//if counter is 6, that is mean there are six number between 1 to 6.
						for(int m=1;m<=6;m++) {//Numbers from 1 to 6 are checked sequentially
							int tempSize=player2.size();//initialize the size of queue according to player 2's queue
							boolean flag=false;//if the number has not been found before, flag is false
							for(int k=0;k<tempSize;k++) {
								if(Integer.parseInt(player2.peek().toString())==m) {//program find the number and dequeue them.
									if(!flag) {//if the number has been found before,program dont enter this condition
										player2.dequeue();
										flag=true;//flag return if number is found.
									}
								}
								else {
									player2.enqueu(player2.dequeue());
								}
							}
						}
						p2Score+=10;//and then player 2 gain 10 point
						Straight=true;//Straight flag returns true for second display
					}
				}
			}
			//controlling yahtzee and straight for player 2
			
			//controlling the yahtzee and straight flag and secon display
			System.out.println();
			if(i>0 && (Yahtzee || Straight)) {
			System.out.print("\nPlayer 1: ");
			for(int j=0;j<player1.size();j++) {
				System.out.print(player1.peek()+" ");
				player1.enqueu(player1.dequeue());
			}
			System.out.print("                  score: "+p1Score);
			
			System.out.print("\nPlayer 2: ");
			for(int j=0;j<player2.size();j++) {
				System.out.print(player2.peek()+" ");
				player2.enqueu(player2.dequeue());
			}
			System.out.print("                  score: "+p2Score);
			}
			System.out.println();
			//controlling the yahtzee and straight flag and secon display
		}
		
		
		//controolling the scores
		if(p1Score>p2Score) {
			System.out.println("\nGame is over!\nThe winner is Player 1!");
		}
		else if(p2Score>p1Score) {
			System.out.println("\nGame is over!\nThe winner is Player 2!");
		}
		else {
			System.out.println("\nGame is over without any winner!");
		}
		//controolling the scores
	}
}
