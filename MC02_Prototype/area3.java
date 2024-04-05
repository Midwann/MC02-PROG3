import java.util.Random;

public class area3 extends map{
    public int [][] floor1 = new int[11][5]; // Y, X
    public int [][] floor2 = new int[9][9]; //
    public int [][] floor3 = new int[11][5]; // 


    int area_index = 3;

    int[] player_rune = {0};
    int[] player_HP = {0};

    public double[][] boss = {{800}, {0,250,500}, {0.25},{0.50},{0.40}};
 
    public area3(int POS_X, int POS_Y){
        super(POS_X, POS_Y);
    }

    public int bossencounter(int[] pHP, int DEX, int INT, int END, int STR, int FTH, int[] eqpdwpn){
     int rand = 0;
     Random random = new Random();
    
     String enemy_name ="THE ELDEN BEAST";

     player_rune[0] = 0;

     rand = random.nextInt(3)+1; //choosing enemy type


     int enemyatkUB = (int)boss[1][2];
     int enemyatkLB = (int)boss[1][1];

     double enemyphysdef = boss[2][0];
     double enemysorcdef = boss[3][0];
     double enemyincdef = boss[4][0]; 

     int enemyHP = (int)boss[0][0];


     double dodgerate = (double)(20+((END+eqpdwpn[3])/2))/(double)100;
     int dodge = (int)(dodgerate*100);
     int enemydmg = 0;
     int playerdmg = 0;

     player_rune[0] = enemyHP * 5;

     int inp = -1;
     int cinp = -1;
     boolean battle = true;

     int loose = 1;
     int win = 0;

     System.out.println("\n\nTHE ELDEN BEAST has appeared!");
     util.presstoContinue();
     while(battle){
          enemydmg = 0;
          playerdmg = 0;
          rand = 0;

          enemydmg = (random.nextInt(enemyatkUB-enemyatkLB) + enemyatkLB);
          
          util.clearConsole();
          System.out.println("AREA "+area_index+ "\tENEMY "+enemy_name+"\nINCOMING ATK DAMAGE " +enemydmg);
   
          System.out.println(enemy_name+"\tHP "+enemyHP);
          System.out.println("\nPLAYER HP: "+pHP[0]+ "\tDODGE CHANCE: " +dodgerate);
         
          System.out.println("\n1. Attack\t2. Dodge");
          inp = util.readInt("->", 2);
          if(inp == 1){
               System.out.println("1. PHYSICAL\t2.SORCERY\t3.INCANTATION");
               cinp=util.readInt("->", 3);
               if(cinp == 1){
               playerdmg = (int)((STR+eqpdwpn[4]) * (1-enemyphysdef));
               }
               else if(cinp == 2){
               playerdmg = (int)((INT+eqpdwpn[2]) * (1-enemysorcdef));
               }
               else if(cinp ==3){
               playerdmg = (int)((FTH+eqpdwpn[5]) * (1-enemyincdef));
               }

               System.out.println("You did "+playerdmg+ " Damage!");
               pHP[0] = pHP[0] - enemydmg;
          }
          else if (inp ==2){
               System.out.println("DODGING!");
               rand = random.nextInt(100)+1;

               if(rand<=dodge){
                    System.out.println("Attack dodged!");
     
               }
               else{
               System.out.println("Dodge failed...");
               pHP[0] = pHP[0] - enemydmg;
               }
          }

          
          util.presstoContinue();

          enemyHP = enemyHP - playerdmg;
          

          if(pHP[0] <= 0){
               
               player_rune[0] = 0;
               battle = false;
               return loose;
          }

          if(enemyHP <= 0 ){
               

               battle = false;
               
               return win;

          }
     
     }
     return win;
}

    public void initializefloor1(int [][] floor1){
        floor1[1][2] = 3; 
        floor1[5][2] = 2; 
        floor1[9][2] = 3; 
   }

    public void initializefloor2(int[][] floor2){
        floor2[1][4] = 3;
        floor2[4][4] = 5;
        floor2[7][4] = 4;
       
    }

    public void initializefloor3(int[][] floor3){
        floor3[1][2] = 6;

        floor3[2][1] = 2;
        floor3[4][1] = 2;
        floor3[6][1] = 2;
        floor3[8][1] = 2;

        floor3[2][3] = 2;
        floor3[4][3] = 2;
        floor3[6][3] = 2;
        floor3[8][3] = 2;
        
        floor3[9][2] = 3;
    }

}
