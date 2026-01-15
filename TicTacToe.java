import java.util.*;
class TicTacToe{
    static  String board[];
    static String turn;
     
    static String checkWinner(){
        String line=null;
        for(int i=0;i<8;i++){
           switch (i) {
            case 0:
                line=board[0]+board[1]+board[2];
                break;
            case 1:
                line=board[3]+board[4]+board[5];
                break;
            case 2:
                line=board[6]+board[7]+board[8];
                break;
            case 3:
                line=board[0]+board[3]+board[6];
                break;
            case 4:
                line=board[1]+board[4]+board[7];
                break;
            case 5:
                line=board[2]+board[5]+board[8];
                break;
            case 6:
                line=board[0]+board[4]+board[8];
                break;
            case 7:
                line=board[2]+board[4]+board[6];
                break;
           }
           if(line.equals("XXX")){
            return "X";
           }
           if(line.equals("OOO")){
            return "O";
           }
        }
        for(int i=0;i<9;i++){
            if(Arrays.asList(board).contains(String.valueOf(i+1))){
                break;
            }
            else if(i==8){
                return "draw";
            }

        }
     System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return null;

    }
    static void printboard(){
        System.out.println("|-----|-----|-----|");
        System.out.println(" | "+board[0]+" | "+board[1]+" | "+board[2]+" | ");
        System.out.println("-----------------");
         System.out.println(" | "+board[3]+" | "+board[4]+" | "+board[5]+" | ");
         System.out.println("-----------------");
         System.out.println(" | "+board[6]+" | "+board[7]+" | "+board[8]+" | ");
         System.out.println("|-----|-----|-----|");

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        board=new String[9];
         for(int i=0;i<9;i++){
            board[i]=String.valueOf(i+1);
         }
         turn="X";
         String winner=null;
         System.out.println("------Welcome to 3x3 Tic-Tac-Toe game------");
         printboard();
         System.out.println("X will play first. Enter a slot number to place X in:");
         while (winner==null) {
            int num;
            try{
               num=sc.nextInt();
               if(num<=0 || num>9){
                System.out.println("Invalid slot number....re-enter the slot number...");
                continue;
               }
               if(board[num-1].equals(String.valueOf(num))){
                board[num-1]=turn;
                turn=turn.equals("X")?"O":"X";
                printboard();
                winner=checkWinner();
               }
               else{
                 System.out.println("Slot already taken; re-enter slot number:");
               }
            }
            catch(InputMismatchException e){
                  System.out.println("Invalid input..re-enter slot number");
                  sc.nextLine();
            } 
         }
         if(winner.equalsIgnoreCase("draw")){
              System.out.println("It's a draw! Thanks for playing.");
         }
         else{
             System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
         }

         sc.close();
          }
    }
