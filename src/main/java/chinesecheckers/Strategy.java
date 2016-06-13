/*
 * Strategy.java
 *
 * @author 2015-2016 APCS F-Block
 * @author Chris Kang
 * @author Justin Yu
 */

/*git commit testing*/

package chinesecheckers;

import java.util.ArrayList;

public class Strategy {
//Fields
	
	
//Methods
	
	public Location getBestMove()
	{
		int x=0, y=0;
		return new Hole(x,y);
	}

	//returns MoveSequence object with all possible moves, requires grid.isValidMove
	public ArrayList<MoveSequence> allMoves(Marble m){
		//Stub
		ArrayList<MoveSequence> allPossible = new ArrayList<MoveSequence>();
		
		
		MoveSequence moves = new MoveSequence();
		return allPossible;
	}
	
	public void computerMove(){
		
	}
	
	
}
