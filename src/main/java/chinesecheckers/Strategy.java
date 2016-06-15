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

 public ArrayList<Hole> initialMoves(Marble m){
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
