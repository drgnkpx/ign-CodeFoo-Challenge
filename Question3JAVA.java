import java.util.Random;
import java.awt.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.ImageIcon;


/*
 * The Board class solves for the minimum number of moves for a knight
 * to cover every space on the chessboard
 * @Jacob Browning
 * @May 23, 2011
 * @Java 6
 */
public class Board {
Board(){}

   
  public int solve() 
    {

   /*
   * The solve method solves for the number of moves made at each attempt to cover the board
   * @return numTries the number of moves
   */

    int[][] board = new int[8][8]; //new chessboard 64 sq units
    int check = 0;//used to check the spaces covered
    int numTries = 0;//used to check number of moves made
    int spaceCovered = 1; //total distance traveled
    Random gen = new Random(); //used to simulate every possible combination of moves
    
    int startposX = gen.nextInt(8); //generate random starting row 0 - 7
    int startposY = gen.nextInt(8); //generate random starting column 0 - 7
    
     while (check < 64) // check for 64 spaces covered at each method call
     {
        check = 0;//check to count number of spaces covered
        int direct = gen.nextInt(4);
        //generate a random direction to move the knight 0 = north, 1 = east, 2 = south, 3 = west
        
        int direct0 = gen.nextInt(2);
        if (direct0 == 0) direct0 = -1;
        // generate a random second direction to move the knight -1 left or 1 right
        
        int flag = 0;//check for a completed move
        
        while (flag == 0)
        {
            
            if (gen.nextInt(2) == 0)//check for two types of movement, 2 and 1 steps or 1 and 2 steps
            {//first moveset, 2 and 1 steps indirection of movement
         if (direct == 0)//north direction movement
         {
            if (startposY - 2 >= 0)//check for a possible move location
                {
                    board[startposX][startposY - 1] = 1;//set equal to one to show a covered unit
                    board[startposX][startposY - 2] = 1;//set equal to one to show a covered unit
                    
                    if(startposX + direct0 < 0)//check for a possible move location
                    {board[startposX + direct0 + 2][startposY - 2] = 1;//set equal to one to show a covered unit
                    startposX = startposX + direct0 + 2;}//set new position after move
                    else if (startposX + direct0 >= 8)//check for a possible move location
                    {board[startposX + direct0 - 2][startposY - 2] = 1;//set equal to one to show a covered unit
                    startposX = startposX + direct0 - 2;}//set new position after move
                    else
                    {board[startposX + direct0][startposY - 2] = 1;//set equal to one to show a covered unit
                    startposX = startposX + direct0;}//set new position after move
                    
                    startposY = startposY - 2;//set new position after move
                    flag = 1;//set having moved
                    spaceCovered += 3;
                }
                else if (startposY - 2 < 0)//if move was invalid
                {direct = 1 + gen.nextInt(3);//set new dorection other than current
                }
         }
         //east direction movement
         if (direct == 1)
         {
            if (startposX + 2 < 8)//check for a possible move location
                {
                    board[startposX + 1][startposY] = 1;//set equal to one to show a covered unit
                    board[startposX + 2][startposY] = 1;//set equal to one to show a covered unit
                    
                    if(startposY + direct0 < 0)//check for a possible move location
                    {board[startposX + 2][startposY + direct0 + 2] = 1;//set equal to one to show a covered unit
                    startposY = startposY + direct0 + 2;}//set new position after move
                    else if (startposY + direct0 >= 8)//check for a possible move location
                    {board[startposX + 2][startposY + direct0 - 2] = 1;//set equal to one to show a covered unit
                    startposY = startposY + direct0 - 2;}//set new position after move
                    else
                    {board[startposX + 2][startposY + direct0] = 1;//set equal to one to show a covered unit
                    startposY = startposY + direct0;}//set new position after move
                    
                    startposX = startposX + 2;//set new position after move
                    flag = 1;//set having moved
                    spaceCovered += 3;
                }
                else if (startposX + 2 >= 8)//if move was invalid
                {direct = 1 + gen.nextInt(3);//set new dorection other than current
                    if (direct == 1) direct = 0;//set new dorection other than current
                }
         }
         //south direction movement
         if (direct == 2)
         {
            if (startposY + 2 < 8)//check for a possible move location
                {
                    board[startposX][startposY + 1] = 1;//set equal to one to show a covered unit
                    board[startposX][startposY + 2] = 1;//set equal to one to show a covered unit
                    
                    if(startposX + direct0 < 0)//check for a possible move location
                    {board[startposX + direct0 + 2][startposY + 2] = 1;//set equal to one to show a covered unit
                    startposX = startposX + direct0 + 2;}//set new position after move
                    else if (startposX + direct0 >= 8)//check for a possible move location
                    {board[startposX + direct0 - 2][startposY + 2] = 1;//set equal to one to show a covered unit
                    startposX = startposX + direct0 - 2;}//set new position after move
                    else
                    {board[startposX + direct0][startposY + 2] = 1;//set equal to one to show a covered unit
                    startposX = startposX + direct0;}//set new position after move
                    
                    startposY = startposY + 2;//set new position after move
                    flag = 1;//set having moved
                    spaceCovered += 3;
                }
                else if (startposY + 2 >= 8)//if move was invalid
                {direct = gen.nextInt(3);//set new dorection other than current
                if (direct == 2) direct = 3;}//set new dorection other than current
         }
         //west direction movement
         if (direct == 3)
         {
            if (startposX - 2 >= 0)//check for a possible move location
                {
                    board[startposX - 1][startposY] = 1;//set equal to one to show a covered unit
                    board[startposX - 2][startposY] = 1;//set equal to one to show a covered unit
                    
                    if(startposY + direct0 < 0)//check for a possible move location
                    {board[startposX - 2][startposY + direct0 + 2] = 1;//set equal to one to show a covered unit
                    startposY = startposY + direct0 + 2;}//set new position after move
                    else if (startposY + direct0 >= 8)//check for a possible move location
                    {board[startposX - 2][startposY + direct0 - 2] = 1;//set equal to one to show a covered unit
                    startposY = startposY + direct0 - 2;}//set new position after move
                    else
                    {board[startposX - 2][startposY + direct0] = 1;//set equal to one to show a covered unit
                    startposY = startposY + direct0;}//set new position after move
                    
                    startposX = startposX - 2;//set new position after move
                    flag = 1;//set having moved
                    spaceCovered += 3;
                }
                else if (startposX - 2 < 0)//if move was invalid
                {direct = gen.nextInt(3);}//set new dorection other than current
                
         }
        }
        
        else// second moveset, 1 and 2 steps
        {
            if (direct == 0)//north direction of movement
         {
            if (startposY - 1 >= 0)//check for a possible move location
                {
                    board[startposX][startposY - 1] = 1;//set equal to one to show a covered unit
                    
                    if(startposX + 2 * direct0 < 0)//check for a possible move location
                    {board[startposX + direct0 + 2][startposY - 1] = 1;//set equal to one to show a covered unit
                     board[startposX + direct0 + 3][startposY - 1] = 1;//set equal to one to show a covered unit
                     startposX = startposX + direct0 + 3;}//set new position after move
                    else if (startposX + 2 * direct0 >= 8)//check for a possible move location
                    {board[startposX + direct0 - 2][startposY - 1] = 1;//set equal to one to show a covered unit
                     board[startposX + direct0 - 3][startposY - 1] = 1;//set equal to one to show a covered unit
                     startposX = startposX + direct0 - 3;}//set new position after move
                    else
                    {board[startposX + 2 * direct0][startposY - 1] = 1;//set equal to one to show a covered unit
                     startposX = startposX + 2 * direct0;}//set new position after move
                    
                    startposY = startposY - 1;//set new position after move
                    flag = 1;//set having moved
                    spaceCovered += 3;
                }
                else if (startposY - 1 < 0)//if move was invalid
                {direct = 1 + gen.nextInt(3);//set new dorection other than current
                }
         }
         //east direction movement
         if (direct == 1)
         {
            if (startposX + 1 < 8)//check for a possible move location
                {
                    board[startposX + 1][startposY] = 1;//set equal to one to show a covered unit
                    
                    if(startposY + 2 * direct0 < 0)//check for a possible move location
                    {board[startposX + 1][startposY + direct0 + 2] = 1;//set equal to one to show a covered unit
                     board[startposX + 1][startposY + direct0 + 3] = 1;//set equal to one to show a covered unit
                     startposY = startposY + direct0 + 3;}//set new position after move
                    else if (startposY + 2 * direct0 >= 8)//check for a possible move location
                    {board[startposX + 1][startposY + direct0 - 2] = 1;//set equal to one to show a covered unit
                     board[startposX + 1][startposY + direct0 - 3] = 1;//set equal to one to show a covered unit
                     startposY = startposY + direct0 - 3;}//set new position after move
                    else
                    {board[startposX + 1][startposY + 2 * direct0] = 1;//set equal to one to show a covered unit
                     startposY = startposY + 2 * direct0;}//set new position after move
                    
                    startposX = startposX + 1;//set new position after move
                    flag = 1;//set having moved
                    spaceCovered += 3;
                }
                else if (startposX + 1 >= 8)//if move was invalid
                {direct = 1 + gen.nextInt(3);//set new dorection other than current
                    if (direct == 1) direct = 0;//set new dorection other than current
                }
         }
         //south direction movement
         if (direct == 2)
         {
            if (startposY + 1 < 8)//check for a possible move location
                {
                    board[startposX][startposY + 1] = 1;//set equal to one to show a covered unit
                    
                    if(startposX + 2 * direct0 < 0)//check for a possible move location
                    {board[startposX + direct0 + 2][startposY + 1] = 1;//set equal to one to show a covered unit
                     board[startposX + direct0 + 3][startposY + 1] = 1;//set equal to one to show a covered unit
                     startposX = startposX + direct0 + 3;}//set new position after move
                    else if (startposX + 2 * direct0 >= 8)//check for a possible move location
                    {board[startposX + direct0 - 2][startposY + 1] = 1;//set equal to one to show a covered unit
                     board[startposX + direct0 - 3][startposY + 1] = 1;//set equal to one to show a covered unit
                     startposX = startposX + direct0 - 3;}//set new position after move
                    else
                    {board[startposX + 2 * direct0][startposY + 1] = 1;//set equal to one to show a covered unit
                     startposX = startposX + 2 * direct0;}//set new position after move
                    
                    startposY = startposY + 1;//set new position after move
                    flag = 1;//set having moved
                    spaceCovered += 3;
                }
                else if (startposY + 1 >= 8)//if move was invalid
                {direct = gen.nextInt(3);//set new dorection other than current
                if (direct == 2) direct = 3;}//set new dorection other than current
                }
         //west direction of movement
         if (direct == 3)
         {
            if (startposX - 1 >= 0)//check for a possible move location
                {
                    board[startposX - 1][startposY] = 1;//set equal to one to show a covered unit
                    
                    if(startposY + 2 * direct0 < 0)//check for a possible move location
                    {board[startposX - 1][startposY + direct0 + 2] = 1;//set equal to one to show a covered unit
                     board[startposX - 1][startposY + direct0 + 3] = 1;//set equal to one to show a covered unit
                     startposY = startposY + direct0 + 3;}//set new position after move
                    else if (startposY + 2 * direct0 >= 8)//check for a possible move location
                    {board[startposX - 1][startposY + direct0 - 2] = 1;//set equal to one to show a covered unit
                     board[startposX - 1][startposY + direct0 - 3] = 1;//set equal to one to show a covered unit
                     startposY = startposY + direct0 - 3;}//set new position after move
                    else
                    {board[startposX - 1][startposY + 2 * direct0] = 1;//set equal to one to show a covered unit
                     startposY = startposY + 2 * direct0;}//set new position after move
                    
                    startposX = startposX - 1;//set new position after move
                    flag = 1;//set having moved
                    spaceCovered += 3;
                }
                else if (startposX - 1 < 0)//if move was invalid
                {direct = gen.nextInt(3);}//set new dorection other than current               
         }
        }
      }
        //check each space on the board for covered spaces indicated by one
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                if (board[x][y] == 1) check++;//increment the number of covered spaces
                }
            }
            numTries++;//increment the number of tries
        }
        
        return numTries;//when every space has been covered
    }

    
    public static void main(String[]args)
    {
        Board board = new Board();
        int min = board.solve() + 1;//set minimum to an initial solve value that is not the absolute minimum
        //show each solution as it approaches the minimum as the number of guesses approaches infinity
        for (int x = 0; x < 100000000; x++)
        {     
            int next0 = board.solve();
            if (next0 < min)
            {System.out.println("Current minimum: " + next0);
                min = next0;}
                }
    }
}


