import java.util.*;
import java.util.concurrent.TimeUnit;
public class data{
   public static String check(String arr[][]){
      if(arr[0][0]=="X"&&arr[0][1]=="X"&&arr[0][2]=="X")
         return "X";
      else if(arr[1][0]=="X"&&arr[1][1]=="X"&&arr[1][2]=="X")
         return "X";
      else if(arr[2][0]=="X"&&arr[2][1]=="X"&&arr[2][2]=="X")
         return "X";
      else if(arr[0][0]=="X"&&arr[1][1]=="X"&&arr[2][2]=="X")
         return "X";
      else if(arr[0][2]=="X"&&arr[1][1]=="X"&&arr[2][0]=="X")
         return "X";
      else if(arr[0][0]=="X"&&arr[1][0]=="X"&&arr[2][0]=="X")
         return "X";
      else if(arr[0][1]=="X"&&arr[1][1]=="X"&&arr[2][1]=="X")
         return "X";
      else if(arr[0][2]=="X"&&arr[1][2]=="X"&&arr[2][2]=="X")
         return "X";
      else if(arr[0][0]=="O"&&arr[0][1]=="O"&&arr[0][2]=="O")
         return "O";
      else if(arr[1][0]=="O"&&arr[1][1]=="O"&&arr[1][2]=="O")
         return "O";
      else if(arr[2][0]=="O"&&arr[2][1]=="O"&&arr[2][2]=="O")
         return "O";
      else if(arr[0][0]=="O"&&arr[1][1]=="O"&&arr[2][2]=="O")
         return "O";
      else if(arr[0][2]=="O"&&arr[1][1]=="O"&&arr[2][0]=="O")
         return "O";
      else if(arr[0][0]=="O"&&arr[1][0]=="O"&&arr[2][0]=="O")
         return "O";
      else if(arr[0][1]=="O"&&arr[1][1]=="O"&&arr[2][1]=="O")
         return "O";
      else if(arr[0][2]=="O"&&arr[1][2]=="O"&&arr[2][2]=="O")
         return "O";
      else
         return "";
   }
   public static boolean validate(int xrr[],int yrr[],int position){
      if(xrr[position]<1||xrr[position]>9)
         return true;
      for(int i=0;i<5;i++){
         for(int j=0;j<5;j++){
            if(xrr[i]==yrr[j]&&yrr[j]!=0&&xrr[i]!=0){
               return true;
            }
         }
      }
      for(int i=0;i<5;i++){
         for(int j=0;j<5;j++){
            if(position!=j&&i!=j){
               if(xrr[i]==xrr[j]&&xrr[j]!=0)
                  return true;
            }
         }
      }
      return false;
   }
   public static void show(String arr[][],int x,int y){
      int val=1;
      System.out.println();
      for(int i=0; i<arr.length; i++){
         for(int j=0;j<arr.length; j++){
            if(val==x){
               arr[i][j]="X";
            }
            if(val==y)
               arr[i][j]="O";
            val++;
            System.out.print("| "+arr[i][j]+" ");
         }
         System.out.println("|");
         if(i!=arr.length-1)
            System.out.println("- - - - - - -");
      }
      System.out.println();
   }
   public static void one_player(String arr[][],String player1_name ,String player2_name,int n){
      Scanner sc=new Scanner(System.in);
      int winner=0;
      int p1_array[]=new int[5];
      int p2_array[]=new int[5];
      System.out.println();
      int p1_position=0,p2_position=0;
      while(true){
         System.out.print(player1_name + " Trun :-- ");
         int x=sc.nextInt();
         p1_array[p1_position]=x;
         boolean bool=validate(p1_array, p2_array,p1_position);
         while(bool==true){
            System.out.println(player1_name+" :--  Try again  --:");
            System.out.print(player1_name + " Trun :-- ");
            x=sc.nextInt();
            p1_array[p1_position]=x;
            bool=validate(p1_array, p2_array,p1_position);
         }
         p1_position++;
         show(arr ,x,-1);
         String s=check(arr);
         if(s=="X"){
            winner=1;
            break;
         }
         if(p1_position==5){
            winner=0;
            break;
         }
         System.out.print(player2_name+" Trun :-- ");
         int y=0;
         if(n==1)
            y=(int)Math.floor(Math.random()*9+1);
         else
            y=sc.nextInt();
         p2_array[p2_position]=y;
         bool=validate(p2_array, p1_array,p2_position);
         while(bool==true){
            if(n==1)
               y=(int)Math.floor(Math.random()*9+1);
            else{
               System.out.println(player2_name+" :--  Try again  --:");
               System.out.print(player2_name + " Trun :-- ");
               y=sc.nextInt();
            }
            p2_array[p2_position]=y;
            bool=validate(p2_array, p1_array,p2_position);
         }
         p2_position++;
         if(n==1){
            try {
               Thread.sleep(1000);
             } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
             }
            System.out.println(y);
         }
         show(arr, -1, y);
         s=check(arr);
         if(s=="O"){
            winner=2;
            break;
         }
      }
      if(winner==0){
         System.out.println(":--  Match drow  --:");
      }
      else if(winner==1){
         System.out.println("Winner is :-- "+player1_name);
      }
      else{
         System.out.println("Winner is :-- "+player2_name);
      }
   }
   public static void main(String[] args) {
      String arr[][]={{"1","2","3"},{"4","5","6"},{"7","8","9"}};
      Scanner sc=new Scanner(System.in);
      System.out.println(":-- Welcome to my first computer game! --:");
      System.out.println(":-- Tic Tac Toe --:");
      System.out.println("------------------------------------------");
      System.out.println();
      int n=0;
      boolean check=true;
      while(check){
         System.out.print(":-- Enter number of players 1 or 2 --: ");
         n=sc.nextInt();
         if(n==1||n==2)
            check=false;
         else
            System.out.println("\n:-- Try again , Enter only 1 or 2 --:");
      }
      System.out.print("Enter first player  name :-- ");
      String player1_name=sc.next();
      String player2_name="Computer";
      if(n==2){
         System.out.print("Enter second player name :-- ");
         player2_name=sc.next();
      }
      show(arr,0,0);
      System.out.println("'X' for :-- "+player1_name+" | 'O' for :-- "+player2_name);
      System.out.println(":-- please press any key between 1 to 9 --:");
      one_player(arr,player1_name,player2_name,n);
      System.out.println();
      System.out.println(":-- Game is Ended --:");
      System.out.println(":-- Thank you for playing --:");
      System.out.println();
   }
}