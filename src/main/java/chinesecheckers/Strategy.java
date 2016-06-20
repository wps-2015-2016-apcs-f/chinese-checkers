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

    //compiles list of all initial moves of a single marble
	//BEING MOVED TO GRID!!!
	public ArrayList<Hole> initialMoves(Location m){
		ArrayList<Hole> moves = new ArrayList<Hole>(18);
		int count = 0;
		for(int n=1; count < 3; n++){
			for(int r = -1; count < 2; r++){
				for(int c = -1; count < 2; c++){
					Hole temp = new Hole(m.getRow()+r*n, m.getCol()+c*n);
					if(ChineseCheckers.getGrid().isValidMove(m, temp)){
						moves.add(temp);
					}
				}
			}
		}
		return moves;
	}
	
	public MoveSequence randomSequence(MoveSequence m, MoveSequence l){
		int random = (int)(Math.random() * 2);
		if(random == 1)
			return m;
		else
			return l;
	}
	
	//returns MoveSequence object with all possible moves, requires grid.isValidMove
	public MoveSequence allMoves(Marble m){
		MoveSequence bestSequence = new MoveSequence();
		MoveSequence tempSequence = new MoveSequence();
		bestSequence.add(new Hole(16,4));
		ArrayList<Hole> tempMoves = initialMoves(m);
		//ArrayList<Hole> tempMoves = new ArrayList<Hole>();

		int branch = 0;
		ArrayList<Integer> indices = new ArrayList<Integer>(0);
		/*indices is a list of indices for each branch, each element represents the indices for a different branch. 
		 * Branch variable keeps track of what branch you are currently on.
		 */
		while(indices.get(0) < initialMoves(m).size()){
			tempSequence.add(new Hole(tempMoves.get(indices.get(branch))));
			tempMoves = initialMoves(tempMoves.get(indices.get(branch)));
			if(tempMoves.size() == 0){
				if(bestSequence.distanceFromEnd() > tempSequence.distanceFromEnd()){
					bestSequence = tempSequence;
				}
				else if(bestSequence.distanceFromEnd() == tempSequence.distanceFromEnd())
					bestSequence = randomSequence(bestSequence, tempSequence);
				//goes backwards in tree multiple times if only one move is available at that branch level
				while(indices.get(branch) >= initialMoves(tempSequence.get(tempSequence.size()-2)).size()){
					
					tempSequence.removeLast();
					tempMoves = initialMoves(tempSequence.get(tempSequence.size()-2));
					indices.remove(indices.size()-1);
					branch--;
				}
				indices.set(branch, indices.get(branch)+1);
			}
			else{
				indices.add(0);
				branch++;
			}
		}
		return bestSequence;
	}
	
	public void computerMove(){
		
	}
	
	
}
