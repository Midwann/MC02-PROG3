import java.util.Random;

public class area1 extends map {
    
    public int [][] floor1 = new int[9][5]; // Y, X
    public int [][] floor2 = new int[9][9]; //
    public int [][] floor3 = new int[9][7]; // 

    String[] enemy = {"DEBUG", "Godrick Soldier", "Godrick Archer", "Godrick Knight"};

     
     
     int area_index = 1;

     int[] player_rune = {0};
     int[] player_HP = {0}; 

     public double[][] boss = {{200}, {0,150,300}, {0.35},{0.20},{0.15}};

  
    public area1(int POS_X, int POS_Y){
        super(POS_X, POS_Y);
    }
    
    
    public int enemyencounter(int[] pHP, int DEX, int INT, int END, int STR, int FTH, int[] eqpdwpn){
     int rand = 0;
     Random random = new Random();
     double[][] enemy_stat = new double[5][5];
     String enemy_name ="";

     player_rune[0] = 0;

     rand = random.nextInt(3)+1; //choosing enemy type

     if(rand == 1){
          enemy_stat = enemy_type1;
          enemy_name=enemy[1];
     }
     else if(rand == 2){
          enemy_stat = enemy_type2;
          enemy_name=enemy[2];
     }
     else if(rand == 3){
          enemy_stat = enemy_type3;
          enemy_name=enemy[3];
     }

     int enemyUB = (int)enemy_stat[0][2];
     int enemyLB =(int)enemy_stat[0][1];

     int enemyatkUB = (int)enemy_stat[1][2];
     int enemyatkLB = (int)enemy_stat[1][1];

     double enemyphysdef = enemy_stat[2][0];
     double enemysorcdef = enemy_stat[3][0];
     double enemyincdef = enemy_stat[4][0]; 

     int enemyHP = area_index*(random.nextInt(enemyUB-enemyLB) + enemyLB);


     double dodgerate = (double)(20+((END+eqpdwpn[3])/2))/(double)100;
     int dodge = (int)(dodgerate*100);
     int enemydmg = 0;
     int playerdmg = 0;

     player_rune[0] = enemyHP * 2;

     int inp = -1;
     int cinp = -1;
     boolean battle = true;

     int loose = 1;
     int win = 0;

     System.out.println("\n\nYou encountered " +enemy_name);
     util.presstoContinue();
     while(battle){
          enemydmg = 0;
          playerdmg = 0;
          rand = 0;

          enemydmg = area_index*(random.nextInt(enemyatkUB-enemyatkLB) + enemyatkLB);
          
          util.clearConsole();
          System.out.println("AREA "+area_index+ "\tENEMY "+enemy_name+"\nINCOMING ATK DAMAGE " +enemydmg);
 
          System.out.println(enemy_name+"\tHP "+enemyHP);
          System.out.println("\nPLAYER HP: "+pHP[0]+"\tDODGE CHANCE: " +dodgerate);
         
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


public int bossencounter(int[] pHP, int DEX, int INT, int END, int STR, int FTH, int[] eqpdwpn){
     int rand = 0;
     Random random = new Random();
    
     String enemy_name ="GODRICK THE GRAFTED";

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

     System.out.println("\n\nGODRICK THE GRAFTED has appeared!");
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
        floor1[1][2] = 3; //door    YX
        floor1[2][1] = 2; //spawner
        floor1[2][3] = 2;
        floor1[7][2] = 4; //fast travel
   }
    

   public void initializefloor2(int [][] floor2){
        floor2[2][4]=2;
        floor2[4][1]=2;
        floor2[4][3]=2;
        floor2[4][4]=2;
        floor2[4][5]=2;
        floor2[4][7]=2;
        floor2[6][3]=2;
        floor2[6][5]=2;
        
        floor2[1][4]=3;//doors
        floor2[7][4]=3;//doors
   }

   

   public void initializefloor3(int [][] floor3){

     floor3[7][3] = 3; //door

     floor3[4][3] = 5; //boss

     floor3[1][3] = 4;//fast travel

   }
    
    

}
