/*
 * MoveSequence.java
 *
 * @author 2015-2016 APCS F-Block
 * @author Chris Kang
 * @author Justin Yu
 */

package chinesecheckers;

import java.util.*;

public class MoveSequence {
	
//Fields
	private ArrayList<Hole> moves;
	
//Constructors
	public MoveSequence(){
		moves = new ArrayList<Hole>();
	}
	
//Methods

	public void add(Hole h){
		moves.add(h);
	}
	
	public int size(){
		return moves.size();
	}
	
	public Hole get(int n){
		return moves.get(n);
	}
	
	//Returns distance traversed by move,
	public int getDistance(Marble m){
		if(Math.abs(moves.get(0).getRow() - m.getRow()) == 1 || Math.abs(moves.get(0).getCol() - m.getCol()) == 1) 
			return 1;
		else
			return moves.size() * 2;
	}
	
}
