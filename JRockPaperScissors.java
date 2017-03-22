/* JRockPaperScissors JApplet
   A Rock Paper Scissors game in which the user can click one of three buttons labeled "Rock","Paper", or
   "Scissors".  Then, compare to the computer's choice of "Rock", "Paper", and "Scissors" that is randomly selected.
   Display the result that shows the number of games that the player has won, tied, or lost. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JRockPaperScissors extends JApplet implements ActionListener 
{
   // Declare variables and named constants
   int choice;
   int comChoice;
   int count = 0;
   int countTies = 0;
   int countYou = 0;
   int countCom = 0;
   final int ONE = 1;
   final int TWO = 2;
   final int THREE = 3;
      
   // Declare a String for the drawString() method
   String myInfo = new String("Chonlada Morse, CIS 263AA Section number 36454 MEID CHO2060527");
   
   // Instantiate JLabel and JButton objects
   JLabel display1 = new JLabel("Rock, Paper, Scissors Game");
   JLabel display2 = new JLabel("To play game, please choose button from following");
   JLabel display3 = new JLabel("---------Results----------");
   JLabel display4 = new JLabel("");
   JLabel display5 = new JLabel("");
   JLabel display6 = new JLabel("");
   JLabel display7 = new JLabel("");
   JButton rock = new JButton("Rock");
   JButton paper = new JButton("Paper");
   JButton scissors = new JButton("Scissors");
   
   // Create the init() method that sets up the applet surface 
   public void init()
   {      
      // Set the JApplet's layout manager to FlowLayout
      setLayout(new FlowLayout());
      
      // Set fonts for display1 JLabel and add to the JApplet
      display1.setFont(new Font("Arial", Font.BOLD, 20));
      add(display1);
      
      // Set fonts for display2 JLabel and add to the JApplet
      display2.setFont(new Font("Arial", Font.BOLD, 14));
      add(display2);
      
      // Add JButtons to the JApplet
      add(rock);
      add(paper);
      add(scissors);
      
      // Add JLabels to the JApplet
      add(display3);
      add(display4);
      add(display5);
      add(display6);
      add(display7);
      
      // Add actionListerner to the JButtons
      rock.addActionListener(this);
      paper.addActionListener(this);
      scissors.addActionListener(this);
   }
   
   //Create the actionPerformed() method
   public void actionPerformed(ActionEvent e)
   {  
      // Call generateRandom() method
      generateRandom();
            
      // Use the named ActionEvent argument and the getSource() method to determine the source of the event
      Object source = e.getSource();
      
      // Use if-else statements to check which button the user selected
      // If the user selected rock JButton  
      if(source == rock)
      {  
         // Use setText() method to display text on the JLabel
         display4.setText("You picked rock");   
         
         // Assign ONE named constant to choice variable    
         choice = ONE;
         
         // Call compareResult() method 
         compareResult(choice, comChoice);
         
      }
      // If the user selected paper JButton 
      if(source == paper)
      {  
         // Use setText() method to display text on the JLabel
         display4.setText("You picked paper");
         
         // Assign TWO named constant to choice variable  
         choice = TWO;
         
         // Call compareResult() method
         compareResult(choice, comChoice);
      }
      
      // If user selected scissors JButton 
      if(source == scissors)
      {  
         // Use setText() method to display text on the JLabel
         display4.setText("You picked scissors");
         
         // Assign THREE named constant to choice variable 
         choice = THREE;
         
         // Call compareResult() method
         compareResult(choice, comChoice);    
      }
      
      // Display the result using setText() method
      display6.setText("You: " + countYou + "  Computer: " + countCom + "  Ties: " + countTies);
      
      // Increment count to count total play
      count++;
      
      /* Display the result that shows the number of total play, number of games that the player has won, tied, or lost
         using setText() method */
      display7.setText("Total play: " + count + "  Player won: " + countYou + "  lost: " + countCom + 
                        "  tied: " + countTies);
   } 
   
   /* Create generateRandom() method to Create random number of 1 to 3 and use if-else statements as well as setText() method 
      to assign text for each random selected number */ 
   public void generateRandom()
   {  
      comChoice = 1 + (int)(Math.random() * 3);
      if(comChoice == ONE)
      {
         display5.setText("Computer picked Rock"); 
      }
      else if(comChoice == TWO)
      {
         display5.setText("Computer picked Paper");
      }
      else if(comChoice == THREE)
      {
         display5.setText("Computer picked Scissors");
      }
   }
   /* Create compareResult method with two parameters.  The method consists of if-else statements to compare number 
      assigned to choice variable with number randomly chosen from computer.
      If numbers are equal, increment countTies, countCom, or countYou variables for each case. */
   public void compareResult(int c, int cCom)
   {
      if(c == cCom)
      {
         countTies++; 
      }
      else if(c != cCom)
      {
         if(c-2 == cCom || c+1 == cCom)
         {
            countCom++;
         }
         if(c+2 == cCom || c-1 == cCom)
         {
            countYou++;
         }        
      }
   }
   
   // Apply paint()method that calls the super() method and uses a Graphic object to draw the myInfo String
   public void paint(Graphics gr)
   {
      super.paint(gr);
      gr.drawString(myInfo,5,400);
   }
}
