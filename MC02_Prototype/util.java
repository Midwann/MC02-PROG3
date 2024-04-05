import java.util.Scanner;
import java.util.Random;

 // Util also known as GameLobby
public class util {
    static Scanner scanner = new Scanner(System.in);
    static Player player;
    public static boolean isrunning = true;
    static area1 area1;
    static area2 area2;
    static area3 area3;
    static Random random = new Random();


    
    /** 
     * @param prompt stores string prompt
     * @param userChoices number of limited choices setup for inputs
     * @return int
     */
    /*  
    *readInt()
    *reads integers, also prevents other inputs aside from integers using the try catch function
    */
    public static int readInt(String prompt, int userChoices){  
        int input;

        do{
            System.out.println(prompt);
            try {
            input = Integer.parseInt(scanner.next());

            }catch  (Exception e){
                input = -1;
                System.out.println("Please enter an integer!");
            }

        }while(input < 1 || input > userChoices);
        return input;
    }
    /*  
    *LEVELUP()
    *This method calculates LEVELUP cost, and modifies player values for stat level ups
    */
    public static void LEVELUP (){
        boolean state= true;
        while(state){
            clearConsole();
            int cinput;
            int cost = (player.cLVL*100)/2;
            System.out.println("LEVEL UP\n");
            System.out.println("RUNES:"+player.cRUNE+"\n1. HP\n2. DEX\n3. INT \n4. END\n5. STR\n6. FTH\n\n7. EXIT");
            System.out.println("LEVEL UP COST =" +cost);
            cinput = readInt("->", 8);
            
            if(cinput == 1 && player.cRUNE >= cost){
                player.cHP+=1;
                player.cRUNE= player.cRUNE - cost;
                player.cLVL+=1;
            }
            else if(cinput == 2 && player.cRUNE >= cost){
                player.cDEX+=1;
                player.cRUNE= player.cRUNE - cost;
                player.cLVL+=1;
            }
            else if(cinput == 3 && player.cRUNE >= cost){
                player.cINT+=1;
                player.cRUNE= player.cRUNE - cost;
                player.cLVL+=1;
            }
            else if(cinput == 4 && player.cRUNE >= cost){
                player.cEND+=1;
                player.cRUNE= player.cRUNE - cost;
                player.cLVL+=1;
            }
            else if(cinput == 5 && player.cRUNE >= cost){
                player.cSTR+=1;
                player.cRUNE= player.cRUNE - cost;
                player.cLVL+=1;
            }
            else if(cinput == 6 && player.cRUNE >= cost){
                player.cFTH+=1;
                player.cRUNE= player.cRUNE - cost;
                player.cLVL+=1;
            }
            else if(cinput == 7){
                state = false;
            }
            else{
            System.out.println("Not Enough Runes");
            presstoContinue();
            }
        }
    }

    public static void SHOP(){
        boolean state = true;
        int cinput = -1;
        int input = -1;

        while(state){
            clearConsole();
            System.out.println("WELCOME TO THE SHOP\n");
            System.out.println("RUNES: "+player.cRUNE);
            cinput = readInt("\n1. Sword\n2.Katana\n3.Whips\n4.Greatswords\n5.Staves\n6.Seal\n7.Back", 7);
            
            if(cinput == 1){
                clearConsole();
                dispshop(player.wpn_name, cinput ,player.boughtstate, player.weaponstat, 1);
                input = readInt("->", 4);
                
                
                if(player.boughtstate[cinput][input] == 1){
                    System.out.println("ITEM IS ALREADY BOUGHT");
                    presstoContinue();
                }

                else if (player.boughtstate[cinput][input] == 0){
                    player.weaponstat(cinput, input, player.weaponstat);

                    if(player.weaponstat[6]<=player.cRUNE){
                    player.boughtstate[cinput][input] = 1;
                    System.out.println(player.wpn_name[cinput][input]);
                    player.cRUNE = player.cRUNE-player.weaponstat[6];
                    }
                    else{
                    System.out.println("NOT ENOUGH RUNES");
                    presstoContinue();
                    }
                }
            }
            else if(cinput == 2){
                clearConsole();
                dispshop(player.wpn_name, cinput ,player.boughtstate, player.weaponstat, 2);
                input = readInt("->", 4);
                
                
                if(player.boughtstate[cinput][input] == 1){
                    System.out.println("ITEM IS ALREADY BOUGHT");
                    presstoContinue();
                }

                else if (player.boughtstate[cinput][input] == 0){
                    player.weaponstat(cinput, input, player.weaponstat);

                    if(player.weaponstat[6]<=player.cRUNE){
                    player.boughtstate[cinput][input] = 1;
                    System.out.println(player.wpn_name[cinput][input]);
                    player.cRUNE = player.cRUNE-player.weaponstat[6];
                    }
                    else{
                    System.out.println("NOT ENOUGH RUNES");
                    presstoContinue();
                    }
                    
                }
            }
            else if(cinput == 3){
                clearConsole();
                dispshop(player.wpn_name, cinput ,player.boughtstate, player.weaponstat, 3);
                input = readInt("->", 4);
                
                
                if(player.boughtstate[cinput][input] == 1){
                    System.out.println("ITEM IS ALREADY BOUGHT");
                    presstoContinue();
                }

                else if (player.boughtstate[cinput][input] == 0){
                    player.weaponstat(cinput, input, player.weaponstat);

                    if(player.weaponstat[6]<=player.cRUNE){
                    player.boughtstate[cinput][input] = 1;
                    System.out.println(player.wpn_name[cinput][input]);
                    player.cRUNE = player.cRUNE-player.weaponstat[6];
                    }
                    else{
                    System.out.println("NOT ENOUGH RUNES");
                    presstoContinue();
                    }
                    
                }
            }
            else if(cinput == 4){
                clearConsole();
                dispshop(player.wpn_name, cinput ,player.boughtstate, player.weaponstat, 4);
                input = readInt("->", 4);
                
                
                if(player.boughtstate[cinput][input] == 1){
                    System.out.println("ITEM IS ALREADY BOUGHT");
                    presstoContinue();
                }

                else if (player.boughtstate[cinput][input] == 0){
                    player.weaponstat(cinput, input, player.weaponstat);

                    if(player.weaponstat[6]<=player.cRUNE){
                    player.boughtstate[cinput][input] = 1;
                    System.out.println(player.wpn_name[cinput][input]);
                    player.cRUNE = player.cRUNE-player.weaponstat[6];
                    }
                    else{
                    System.out.println("NOT ENOUGH RUNES");
                    presstoContinue();
                    }
                    
                }
            }
            else if(cinput == 5){
                clearConsole();
                dispshop(player.wpn_name, cinput ,player.boughtstate, player.weaponstat, 5);
                input = readInt("->", 4);
                
                
                if(player.boughtstate[cinput][input] == 1){
                    System.out.println("ITEM IS ALREADY BOUGHT");
                    presstoContinue();
                }

                else if (player.boughtstate[cinput][input] == 0){
                    player.weaponstat(cinput, input, player.weaponstat);

                    if(player.weaponstat[6]<=player.cRUNE){
                    player.boughtstate[cinput][input] = 1;
                    System.out.println(player.wpn_name[cinput][input]);
                    player.cRUNE = player.cRUNE-player.weaponstat[6];
                    }
                    else{
                    System.out.println("NOT ENOUGH RUNES");
                    presstoContinue();
                    }
                    
                }
            }
            else if(cinput == 6){
                clearConsole();
                dispshop(player.wpn_name, cinput ,player.boughtstate, player.weaponstat, 6);
                input = readInt("->", 4);
                
                
                if(player.boughtstate[cinput][input] == 1){
                    System.out.println("ITEM IS ALREADY BOUGHT");
                    presstoContinue();
                }

                else if (player.boughtstate[cinput][input] == 0){
                    player.weaponstat(cinput, input, player.weaponstat);

                    if(player.weaponstat[6]<=player.cRUNE){
                    player.boughtstate[cinput][input] = 1;
                    System.out.println(player.wpn_name[cinput][input]);
                    player.cRUNE = player.cRUNE-player.weaponstat[6];
                    }
                    else{
                    System.out.println("NOT ENOUGH RUNES");
                    presstoContinue();
                    }
                    
                }
            }
            else if(cinput == 7){
                state = false;
            }
            cinput = -1;
        }
    }
    
    public static void dispshop(String[][] name, int input, int[][] boughtstate, int[] weapon, int type){

        for(int i = 1; i<=4; i++){
        if(boughtstate[type][i] == 0){
            player.weaponstat(type, i, weapon);
        System.out.println(i+"."+name[type][i]+ " RUNE COST -> " +weapon[6]);
        }
        else if(boughtstate[type][i] == 1){
        System.out.println(i+"."+name[type][i]+" -BOUGHT-");
        }

        }
    }

    public static void OPENINV(){
        boolean state = true;
        int menuinp = -1;
        int input = -1;
        int cinput = -1;
        while(state){
        player.printinventory(player.boughtstate, player.wpn_name);
        
        player.printeqpd(player.eqpstat, player.eqpname);
        System.out.println("1.Equip a Weapon\n2.Back");
        menuinp = readInt("->", 2);

        if(menuinp == 1){
            System.out.println("Pick Weapon Type:\n1.Sword\n2.Katana\n3.Whips\n4.GreatSwordS\n5.Staves\n6.Seals");
            input = readInt("->", 6);

            System.out.println("OWNED:" +player.wpn_class[input]);
            player.printwpn(player.boughtstate, player.wpn_name, input);
            cinput = readInt("->", 4);

            if(player.boughtstate[input][cinput] == 1){
                player.weaponstat(input, cinput, player.tempstat);

                if(player.cDEX>=player.tempstat[7]){
                    player.assigneqpd(player.wpn_name, player.eqpname, player.eqpstat, cinput, input);
                    System.out.println(player.wpn_name[input][cinput] +" Equipped!");
                    presstoContinue();
                }
                else{
                    System.out.println("NOT ENOUGH DEX");
                    presstoContinue();
                }
            }
            else{
                System.out.println(player.wpn_name[input][cinput] +" not owned!");
                presstoContinue();
            }

        }
        else if(menuinp == 2){
        state = false;
        }

        }
    }

    /*  
    *clearConsole()
    *This method clears console by printing many spaces
    */
    public static void clearConsole(){
       for(int i=0; i < 100; i++)
       System.out.println();//prints blank spaces 

    }

    /*  
    *presstoContinue()
    *allows for gaps, and to allow reading
    */

    public static void presstoContinue(){
        System.out.println("Press to continue...");
        scanner.next();
    }

    
    /** 
     * @param name
     * @param job
     * @param job_index
     */
    /*  
    *printCharacterdetails()
    *This method prints character details for character creation
    */
    public static void printCharacterdetails(String name, String job, int job_index){
        
        System.out.println("\tCHARACTER CREATION\n\n");
        System.out.println("Character Name:"+name);
        System.out.println("\nJob Class:"+job);
        System.out.println("Level: 1");
        int[] arr = assignclassval(job_index);
        System.out.println("\nStatistics:");
        System.out.println("HP:" +arr[0]+ "\tEND:" +arr[3]);
        System.out.println("DEX:" +arr[1]+ "\tSTR:" +arr[4]);
        System.out.println("INT:" +arr[2]+ "\tFTH:" +arr[5]);
        System.out.println("--------------------");
        System.out.println("\n\n1.ENTER NAME");
        System.out.println("2.CHOOSE JOB");
        System.out.println("3.START GAME");
        System.out.println("4.BACK");
    
    }
    
    /** 
     * @param startGame(
     */
    /*  
    *printlobbymenu()
    *Prints the lobby menu choices, andd character stats
    */
    public static void printlobbymenu(){ //lobby

        System.out.println("\t\tLOBBY\n\n");
        System.out.println("STATS:");
        System.out.println("NAME:" +player.name+ "\nCLASS:" +player.class_name);
        System.out.println("LEVEL " +player.cLVL+ "\nHP:" +player.cHP+ "\tEND:" +player.cEND);
        System.out.println("DEX:" +player.cDEX+ "\tSTR:" +player.cSTR);
        System.out.println("INT:" +player.cINT+ "\tFTH:" +player.cFTH);
        System.out.println("RUNE: " +player.cRUNE);
        System.out.println("--------------------");

        System.out.println("\n\n1.FAST TRAVEL");
        System.out.println("2.LEVEL UP");
        System.out.println("3.INVENTORY");
        System.out.println("4.SHOP");
        System.out.println("5.QUIT GAME");
    }

    /*  
    *startGame()
    *Starts the game loop, calls player object, contains character creation
    */

    public static void startGame(){
    
        int cinput=-1;
        int state = 1;
        String name = " ";
        int job_index = 1; //base vagabond
        String[] job_class  = {"DEBUG","Vagabond", "Samurai", "Warrior", "Hero", "Astrologer", "Prophet"};

        while(state==1){
        clearConsole();
        printCharacterdetails(name, job_class[job_index], job_index);
        cinput = readInt("->", 4);

        if(cinput == 1){
            System.out.println("INPUT NAME:");
            name = scanner.next();
            cinput = -1;
        }
        else if (cinput == 2){ //pick a job, basejob is Vagabond 
            System.out.println("Pick a job");
            System.out.println("\n1.Vagabond\n2.Samurai\n3.Warrior\n4.Hero\n5.Astrologer\n6.Prophet\n");
            job_index = readInt("->", 6);
            cinput =-1;
        }
        else if (cinput == 3){

            if(name == " "){ //if name is empty
                System.out.println("PLEASE INPUT A NAME BEFORE STARTING THE GAME");
                presstoContinue();
                cinput = -1;
            }

            else{ //if name is not empty
            state = 0;
            }

         }
        else if (cinput == 4){
            state = 0;
        }

        } //end of while loop 

        //start of gameloop

        if(cinput == 3){
            clearConsole();
            player = new Player(name, job_index); //calling the player object
            player.initializestate(player.boughtstate);
            gameloop();
            isrunning = true;
        }

    
    }


    
    /** 
     * @param 1
     */
    /*  
    *gameloop()
    *this method is the gameloop itself
    *this method contains fast travel, level up, etc.
    */
     public static void gameloop(){ //main game loop
        while(isrunning){ //boolean, is running default set to true
        int input=0;
        clearConsole();
        printlobbymenu();

        if(player.area1boss_state==1){
            System.out.println("-GODRICK DEFEATED!-");
        }
        if(player.area2boss_state==1){
            System.out.println("-RENNALA DEFEATED!-");
        }
        if(player.area1boss_state == 1 && player.area2boss_state == 1){
            System.out.println("-ELDEN THRONE UNLOCKED-");
        }
        
        
        input = readInt("->",  6);

        if(input == 1){

            clearConsole();
            System.out.println("1.Stormveil Castle \n2.Raya Lucaria Academy \n3.The Elden Throne");
            int finput = readInt("Where to fast travel to?", 4);

            if(finput == 1){
                area1 = new area1(0,0); //creates the area1 object
                startarea1(7,2);  //starts area1 floor1, stormveil castle
                clearConsole();
            }
            else if(finput == 2){
                area2 = new area2(0,0); 
                startmap2area1(1,3);  //starts area2 floor2, raya lucaria academy
                clearConsole();
            }
            else if(finput == 3){
                if(player.area1boss_state==1 && player.area2boss_state==1){
                    area3 = new area3(0, 0);
                    startmap3area1(9, 2);
                }
                else{
                    System.out.println("AREA LOCKED!");
                }
            }
            else
            System.out.println("WIP");
            presstoContinue();
        }
        else if(input == 2){
            LEVELUP();
        }
        else if(input == 3){
        System.out.println("\tWEAPONS OWNED\n");
        OPENINV();
        presstoContinue();
            
        }
        else if(input == 4){
            player.cRUNE = 1000000;
            SHOP();
        }
        else if (input == 5){
            isrunning = false;
        }
        
        }

    }
    

    
    /** 
     * @param index
     * @return int[]
     */
    /*  
    *assignclassval()
    *stores base stats for jobs
    *assigns stats to player object
    */
    public static int[] assignclassval(int index){
        int arr[] = new int[6];

        if(index == 1){ //vagabond base
            arr[0] = 15;//hp
            arr[1] = 13;//dex
            arr[2] = 9;//int
            arr[3] = 11;//end
            arr[4] = 14;//str
            arr[5] = 9;//fth
            

            return arr;
        }
        else if(index == 2){//samurai base
            arr[0] = 12;
            arr[1] = 15;
            arr[2] = 9;
            arr[3] = 13;
            arr[4] = 12;
            arr[5] = 8;
            

            return arr;
        }
        else if(index == 3){//warrior base
            arr[0] = 11;
            arr[1] = 16;
            arr[2] = 10;
            arr[3] = 11;
            arr[4] = 10;
            arr[5] = 8;
            

            return arr;
        }
        else if(index == 4){//hero base
            arr[0] = 14;
            arr[1] = 9;
            arr[2] = 7;
            arr[3] = 12;
            arr[4] = 16;
            arr[5] = 8;
            

            return arr;
        }
        else if(index == 5){//astroleger base
            arr[0] = 9;
            arr[1] = 12;
            arr[2] = 16;
            arr[3] = 9;
            arr[4] = 8;
            arr[5] = 7;
            

            return arr;
        }
        else if(index == 6){//prophet base
            arr[0] = 10;
            arr[1] = 10;
            arr[2] = 7;
            arr[3] = 8;
            arr[4] = 11;
            arr[5] = 16;
            

            return arr;
        }
        
        else return arr;
    
    }


    
   
    /*  
    *startarea1()
    *contains the loop for area1, and the object for area1
    *contains many methods of the area class and player class, such as map initialization and tile initialization etc.
    */

    public static void startarea1(int Y, int X){ //main loop for area1 experimental

        boolean game = true;
        area1.initizalizemap(area1.floor1, 9, 5);
        area1.initializefloor1(area1.floor1);
        area1.POS[0] = Y;
        area1.POS[1] = X; //PLAYER POS Y X
        int POS_inp = 0;
        area1.floor1[area1.POS[0]][area1.POS[1]] = 1; //setting player tile

        int battle = 0;
        area1.player_HP[0] =  100 * ((player.cHP+player.eqpstat[0])/2);

        while(game){
            
            clearConsole();
            area1.initizalizemap(area1.floor1, 9, 5); //initialize space
            area1.initializefloor1(area1.floor1); //initialize tiles

            player.playerTILE = area1.floor1[area1.POS[0]][area1.POS[1]]; //get player tile from player POS
            area1.floor1[area1.POS[0]][area1.POS[1]] = area1.tileID[1]; //set to PLAYER tileid

            area1.printmap(area1.floor1, 9, 5);
            
            System.out.println("POSITION   X: " +area1.POS[1]+ " Y: "+area1.POS[0]);
            System.out.println("Current tile:" +area1.tile[player.playerTILE]+"\tHP: "+area1.player_HP[0]);

            POS_inp = readInt("1 FORWARD\t3 LEFT\n2 BACKWARD\t4 RIGHT\nINPUT:\t5 INTERACT", 7);

            player.moveYPOS(area1.POS, POS_inp);
                   
                 //enemy encounter
                if(player.playerTILE == 2){


                int encounter = 0;
                int add = 0;
                encounter = random.nextInt(4)+1;
                if(encounter == 1){
                    add = random.nextInt(100)+50;
                    player.cRUNE = player.cRUNE + add;
                    System.out.println("YOU GAINED" +add+ "RUNES!");
                    presstoContinue();
                }

                else if (encounter > 1){
                    battle = area1.enemyencounter(area1.player_HP, player.cDEX, player.cINT, player.cEND, player.cSTR, player.cFTH, player.eqpstat);
                    if(battle == 1){
                        System.out.println("YOU DIED!");
                        player.cRUNE = 0;
                        game = false;
                        util.presstoContinue();
                    }
                    else if(battle == 0){
                        System.out.println("YOU WON!");
                        System.out.println("GAINED "+area1.player_rune[0]+" RUNES");
                        player.cRUNE = player.cRUNE + area1.player_rune[0];
                        util.presstoContinue();
                    }
                }
                }

                area1.checkborder(area1.POS, 8, 4);
            
        
            if(POS_inp == 5 && player.playerTILE == 3){ //interact
                game = false;
            }
            else if(POS_inp == 5 && player.playerTILE == 4){
                game = false;
                gameloop();
            }
                   
           

            

        }
        if(player.playerTILE == 3)
        startarea2(7,4); //starting pos Y, X

   }
  
   /*  
    *startarea2()
    *contains the loop for area1 floor2
    */
    public static void startarea2(int Y, int X){
        boolean game = true;
        area1.initizalizemap(area1.floor2, 9, 9);
        area1.POS[0] = Y;
        area1.POS[1] = X; //PLAYER POS
        int POS_inp = 0;
        area1.floor2[area1.POS[0]][area1.POS[1]] = 1; //setting player 
        

        int battle = 0;
        while(game){
            
            clearConsole();
            area1.initizalizemap(area1.floor2, 9, 9); //initialize space
            area1.initializefloor2(area1.floor2); //initialize tiles

            

            player.playerTILE = area1.floor2[area1.POS[0]][area1.POS[1]]; //get player tile from player POS
            area1.floor2[area1.POS[0]][area1.POS[1]] = area1.tileID[1]; //set to PLAYER tileid

            area1.printmap(area1.floor2, 9, 9);

            System.out.println("POSITION   X: " +area1.POS[1]+ " Y: "+area1.POS[0]);
            System.out.println("Current tile:" +area1.tile[player.playerTILE]+"\tHP: "+area1.player_HP[0]);

            POS_inp = readInt("1 FORWARD\t3 LEFT\n2 BACKWARD\t4 RIGHT\nINPUT:\t5 INTERACT", 7);
            
            player.moveYPOS(area1.POS, POS_inp);
  

                if(player.playerTILE == 2){
                    //  area1.removeTILE(area1.floor1, area1.POS[0], area1.POS[1]);
                int encounter = 0;
                int add = 0;
                encounter = random.nextInt(4)+1;
                if(encounter == 1){
                    add = random.nextInt(100)+50;
                    player.cRUNE = player.cRUNE + add;
                    System.out.println("YOU GAINED" +add+ "RUNES!");
                    presstoContinue();
                }
                else if (encounter > 1){
                    battle = area1.enemyencounter(area1.player_HP, player.cDEX, player.cINT, player.cEND, player.cSTR, player.cFTH, player.eqpstat);

                    if(battle == 1){
                        System.out.println("YOU DIED!");
                        player.cRUNE = 0;
                        game = false;
                        util.presstoContinue();
                    }
                    else if(battle == 0){
                        System.out.println("YOU WON!");
                        System.out.println("GAINED "+area1.player_rune[0]+" RUNES");
                        player.cRUNE = player.cRUNE + area1.player_rune[0];
                        util.presstoContinue();
                    }
                    
                    }
      
                  }    

            area1.checkborder(area1.POS, 8, 8);

            if(POS_inp == 5 && player.playerTILE == 3){ //interact
                game = false;
            }
            else if(POS_inp == 5 && player.playerTILE == 4){
                game = false;
                gameloop();
            }
            
        
        }    
           

        
        
        if(player.playerTILE == 3 && area1.floor2[1][4] == 1)
        startarea3(7,3);
        else if(player.playerTILE == 3 && area1.floor2[7][4] == 1)
        startarea1(1,2);
   }

   /*  
    *startarea3()
    *contains the loop for area1 floor3
    */
   public static void startarea3(int Y, int X){
    boolean game = true;
    area1.initizalizemap(area1.floor3, 9, 7);
    area1.POS[0] = Y;
    area1.POS[1] = X; //PLAYER POS
    int POS_inp = 0;
    area1.floor3[area1.POS[0]][area1.POS[1]] = 1; //setting player 

    int battle = 0;
    
    
        while(game){
            
            clearConsole();
            area1.initizalizemap(area1.floor3, 9, 7); //initialize space
            area1.initializefloor3(area1.floor3); //initialize tiles

            player.playerTILE = area1.floor3[area1.POS[0]][area1.POS[1]]; //get player tile from player POS
            area1.floor3[area1.POS[0]][area1.POS[1]] = area1.tileID[1]; //set to PLAYER tileid

            
            area1.printmap(area1.floor3, 9, 7);
            System.out.println("POSITION   X: " +area1.POS[1]+ " Y: "+area1.POS[0]);
            System.out.println("Current tile:" +area1.tile[player.playerTILE]+"\tHP: "+area1.player_HP[0]);

            POS_inp = readInt("1 FORWARD\t3 LEFT\n2 BACKWARD\t4 RIGHT\nINPUT:\t5 INTERACT", 7);

            player.moveYPOS(area1.POS, POS_inp);  

            if(player.playerTILE == 2){
                //  area1.removeTILE(area1.floor1, area1.POS[0], area1.POS[1]);
                int encounter = 0;
                int add = 0;
                encounter = random.nextInt(4)+1;
                if(encounter == 1){
                    add = random.nextInt(100)+50;
                    player.cRUNE = player.cRUNE + add;
                    System.out.println("YOU GAINED" +add+ "RUNES!");
                    presstoContinue();
                }
                else if (encounter > 1){
                    battle = area1.enemyencounter(area1.player_HP, player.cDEX, player.cINT, player.cEND, player.cSTR, player.cFTH, player.eqpstat);
                    if(battle == 1){
                        System.out.println("YOU DIED!");
                        player.cRUNE = 0;
                        game = false;
                        util.presstoContinue();
                    }
                    else if(battle == 0){
                        System.out.println("YOU WON!");
                        System.out.println("GAINED "+area1.player_rune[0]+" RUNES");
                        player.cRUNE = player.cRUNE + area1.player_rune[0];
                        util.presstoContinue();
                    }
                }
      
                }
            
                area1.checkborder(area1.POS, 8, 6);


            if(player.playerTILE == 5){
                battle = area1.bossencounter(area1.player_HP, player.cDEX, player.cINT, player.cEND, player.cSTR, player.cFTH, player.eqpstat);
                    if(battle == 1){
                        System.out.println("YOU DIED!");
                        player.cRUNE = 0;
                        game = false;
                        util.presstoContinue();
                    }
                    else if(battle == 0){
                        System.out.println("GREAT ENEMY FELLED!");
                        System.out.println("GAINED "+area1.player_rune[0]+" RUNES");
                        player.cRUNE = player.cRUNE + area1.player_rune[0];
                        player.area1boss_state =1;
                        util.presstoContinue();
                    }
            }

            if(POS_inp == 5 && player.playerTILE == 3 ){ //interact
                game = false;
            }
            else if(POS_inp == 5 && player.playerTILE == 4){
                game = false;
                gameloop();
            }
        
        }
        if(player.playerTILE == 3 && area1.floor3[7][3] == 1)
        startarea2(1,4);
   }

   public static void startmap2area1(int Y, int X){
    boolean game = true;
    area2.initizalizemap(area2.floor1, 7, 7);
    area2.POS[0] = Y;
    area2.POS[1] = X; //PLAYER POS
    int POS_inp = 0;
    area2.floor1[area2.POS[0]][area2.POS[1]] = 1; //setting player 

    int battle = 0;
    area2.player_HP[0] =  100 * ((player.cHP+player.eqpstat[0])/2);

        while(game){
            
            clearConsole();
            area2.initizalizemap(area2.floor1, 7, 7); //initialize space
            area2.initializefloor1(area2.floor1); //initialize tiles

            player.playerTILE = area2.floor1[area2.POS[0]][area2.POS[1]]; //get player tile from player POS
            area2.floor1[area2.POS[0]][area2.POS[1]] = area2.tileID[1]; //set to PLAYER tileid

            
            area2.printmap(area2.floor1, 7, 7);
            System.out.println("POSITION   X: " +area2.POS[1]+ " Y: "+area2.POS[0]);
            System.out.println("Current tile:" +area2.tile[player.playerTILE]+"\tHP: "+area2.player_HP[0]);

            POS_inp = readInt("1 FORWARD\t3 LEFT\n2 BACKWARD\t4 RIGHT\nINPUT:\t5 INTERACT", 7);

            player.moveYPOS(area2.POS, POS_inp);  

            if(player.playerTILE == 2){
                //  area2.removeTILE(area2.floor1, area2.POS[0], area2.POS[1]);
                int encounter = 0;
                int add = 0;
                encounter = random.nextInt(4)+1;
                if(encounter == 1){
                    add = random.nextInt(100)+50;
                    player.cRUNE = player.cRUNE + add;
                    System.out.println("YOU GAINED" +add+ "RUNES!");
                    presstoContinue();
                }
                else if (encounter > 1){
                    battle = area2.enemyencounter(area2.player_HP, player.cDEX, player.cINT, player.cEND, player.cSTR, player.cFTH, player.eqpstat);
                    if(battle == 1){
                        System.out.println("YOU DIED!");
                        player.cRUNE = 0;
                        game = false;
                        util.presstoContinue();
                    }
                    else if(battle == 0){
                        System.out.println("YOU WON!");
                        System.out.println("GAINED "+area2.player_rune[0]+" RUNES");
                        player.cRUNE = player.cRUNE + area2.player_rune[0];
                        util.presstoContinue();
                    }
                }
      
                }
            
                area2.checkborder(area2.POS, 6, 6);


            if(POS_inp == 5 && player.playerTILE == 3 ){ //interact
                game = false;
            }
            else if(POS_inp == 5 && player.playerTILE == 4){
                game = false;
                gameloop();
            }
        
        }
        if(player.playerTILE == 3 && area2.floor1[5][3] == 1)
        startmap2area2(1,2);
   }

   public static void startmap2area2(int Y, int X){
    boolean game = true;
    area2.initizalizemap(area2.floor2, 9, 5);
    area2.POS[0] = Y;
    area2.POS[1] = X; //PLAYER POS
    int POS_inp = 0;
    area2.floor2[area2.POS[0]][area2.POS[1]] = 1; //setting player 

    int battle = 0;
        while(game){
            
            clearConsole();
            area2.initizalizemap(area2.floor2, 9, 5); //initialize space
            area2.initializefloor2(area2.floor2); //initialize tiles

            player.playerTILE = area2.floor2[area2.POS[0]][area2.POS[1]]; //get player tile from player POS
            area2.floor2[area2.POS[0]][area2.POS[1]] = area2.tileID[1]; //set to PLAYER tileid

            
            area2.printmap(area2.floor2, 9, 5);
            System.out.println("POSITION   X: " +area2.POS[1]+ " Y: "+area2.POS[0]);
            System.out.println("Current tile:" +area2.tile[player.playerTILE]+"\tHP: "+area2.player_HP[0]);

            POS_inp = readInt("1 FORWARD\t3 LEFT\n2 BACKWARD\t4 RIGHT\nINPUT:\t5 INTERACT", 7);

            player.moveYPOS(area2.POS, POS_inp);  

            if(player.playerTILE == 2){
                int encounter = 0;
                int add = 0;
                encounter = random.nextInt(4)+1;
                if(encounter == 1){
                    add = random.nextInt(100)+50;
                    player.cRUNE = player.cRUNE + add;
                    System.out.println("YOU GAINED" +add+ "RUNES!");
                    presstoContinue();
                }
                else if (encounter > 1){
                    battle = area2.enemyencounter(area2.player_HP, player.cDEX, player.cINT, player.cEND, player.cSTR, player.cFTH, player.eqpstat);
                    if(battle == 1){
                        System.out.println("YOU DIED!");
                        player.cRUNE = 0;
                        game = false;
                        util.presstoContinue();
                    }
                    else if(battle == 0){
                        System.out.println("YOU WON!");
                        System.out.println("GAINED "+area2.player_rune[0]+" RUNES");
                        player.cRUNE = player.cRUNE + area2.player_rune[0];
                        util.presstoContinue();
                    }
                }
      
                }
            
                area2.checkborder(area2.POS, 8, 4);


            if(POS_inp == 5 && player.playerTILE == 3 ){ //interact
                game = false;
            }
            else if(POS_inp == 5 && player.playerTILE == 4){
                game = false;
                gameloop();
            }
        
        }
        if(player.playerTILE == 3 && area2.floor2[1][2] == 1)
        startmap2area1(5,3);
        if(player.playerTILE == 3 && area2.floor2[4][3] == 1)
        startmap2area3(4, 1);
   }
   
   public static void startmap2area3(int Y, int X){
    boolean game = true;
    area2.initizalizemap(area2.floor3, 9, 7);
    area2.POS[0] = Y;
    area2.POS[1] = X; //PLAYER POS
    int POS_inp = 0;

    int battle = 0;
    area2.floor3[area2.POS[0]][area2.POS[1]] = 1; //setting player 
        while(game){
            
            clearConsole();
            area2.initizalizemap(area2.floor3, 9, 7); //initialize space
            area2.initializefloor3(area2.floor3); //initialize tiles

            player.playerTILE = area2.floor3[area2.POS[0]][area2.POS[1]]; //get player tile from player POS
            area2.floor3[area2.POS[0]][area2.POS[1]] = area2.tileID[1]; //set to PLAYER tileid

            
            area2.printmap(area2.floor3, 9, 7);
            System.out.println("POSITION   X: " +area2.POS[1]+ " Y: "+area2.POS[0]);
            System.out.println("Current tile:" +area2.tile[player.playerTILE]+"\tHP: "+area2.player_HP[0]);

            POS_inp = readInt("1 FORWARD\t3 LEFT\n2 BACKWARD\t4 RIGHT\nINPUT:\t5 INTERACT", 7);

            player.moveYPOS(area2.POS, POS_inp);  

            if(player.playerTILE == 2){
                int encounter = 0;
                int add = 0;
                encounter = random.nextInt(4)+1;
                if(encounter == 1){
                    add = random.nextInt(100)+50;
                    player.cRUNE = player.cRUNE + add;
                    System.out.println("YOU GAINED" +add+ "RUNES!");
                    presstoContinue();
                }
                else if (encounter > 1){
                    battle = area2.enemyencounter(area2.player_HP, player.cDEX, player.cINT, player.cEND, player.cSTR, player.cFTH, player.eqpstat);
                    if(battle == 1){
                        System.out.println("YOU DIED!");
                        player.cRUNE = 0;
                        game = false;
                        util.presstoContinue();
                    }
                    else if(battle == 0){
                        System.out.println("YOU WON!");
                        System.out.println("GAINED "+area2.player_rune[0]+" RUNES");
                        player.cRUNE = player.cRUNE + area2.player_rune[0];
                        util.presstoContinue();
                    }
                }
      
                }
            
                area2.checkborder(area2.POS, 8, 6);


            if(POS_inp == 5 && player.playerTILE == 3 ){ //interact
                game = false;
            }
        }

        if(player.playerTILE == 3 && area2.floor3[4][1] == 1)
        startmap2area2(4,3);
        if(player.playerTILE == 3 && area2.floor3[1][3] == 1)
        startmap2area5(8,4);
        if(player.playerTILE == 3 && area2.floor3[4][5] == 1)
        startmap2area4(2, 1);
   }

   public static void startmap2area4(int Y, int X){
    boolean game = true;
    area2.initizalizemap(area2.floor4, 5, 8);
    area2.POS[0] = Y;
    area2.POS[1] = X; //PLAYER POS
    int POS_inp = 0;
    area2.floor4[area2.POS[0]][area2.POS[1]] = 1; //setting player 
    int battle = 0;
        while(game){
            
            clearConsole();
            area2.initizalizemap(area2.floor4, 5, 8); //initialize space
            area2.initializefloor4(area2.floor4); //initialize tiles

            player.playerTILE = area2.floor4[area2.POS[0]][area2.POS[1]]; //get player tile from player POS
            area2.floor4[area2.POS[0]][area2.POS[1]] = area2.tileID[1]; //set to PLAYER tileid

            
            area2.printmap(area2.floor4, 5, 8);
            System.out.println("POSITION   X: " +area2.POS[1]+ " Y: "+area2.POS[0]);
            System.out.println("Current tile:" +area2.tile[player.playerTILE]+"\tHP: "+area2.player_HP[0]);

            POS_inp = readInt("1 FORWARD\t3 LEFT\n2 BACKWARD\t4 RIGHT\nINPUT:\t5 INTERACT", 7);

            player.moveYPOS(area2.POS, POS_inp);  

            if(player.playerTILE == 2){
                int encounter = 0;
                int add = 0;
                encounter = random.nextInt(4)+1;
                if(encounter == 1){
                    add = random.nextInt(100)+50;
                    player.cRUNE = player.cRUNE + add;
                    System.out.println("YOU GAINED" +add+ "RUNES!");
                    presstoContinue();
                }
                else if (encounter > 1){
                    battle = area2.enemyencounter(area2.player_HP, player.cDEX, player.cINT, player.cEND, player.cSTR, player.cFTH, player.eqpstat);
                    if(battle == 1){
                        System.out.println("YOU DIED!");
                        player.cRUNE = 0;
                        game = false;
                        util.presstoContinue();
                    }
                    else if(battle == 0){
                        System.out.println("YOU WON!");
                        System.out.println("GAINED "+area2.player_rune[0]+" RUNES");
                        player.cRUNE = player.cRUNE + area2.player_rune[0];
                        util.presstoContinue();
                    }
                }
      
                }
            
                area2.checkborder(area2.POS, 4, 7);


            if(POS_inp == 5 && player.playerTILE == 3 ){ //interact
                game = false;
            }
            else if(POS_inp == 5 && player.playerTILE == 4){
                game = false;
                gameloop();
            }
        
        }
        if(player.playerTILE == 3 && area2.floor4[2][1] == 1)
        startmap2area3(4,5);
   }

   public static void startmap2area5(int Y, int X){
    boolean game = true;
    area2.initizalizemap(area2.floor5, 10, 9);
    area2.POS[0] = Y;
    area2.POS[1] = X; //PLAYER POS
    int POS_inp = 0;
    area2.floor5[area2.POS[0]][area2.POS[1]] = 1; //setting player 
    int battle = 0;
        while(game){
            
            clearConsole();
            area2.initizalizemap(area2.floor5, 10, 9); //initialize space
            area2.initializefloor5(area2.floor5); //initialize tiles

            player.playerTILE = area2.floor5[area2.POS[0]][area2.POS[1]]; //get player tile from player POS
            area2.floor5[area2.POS[0]][area2.POS[1]] = area2.tileID[1]; //set to PLAYER tileid

            
            area2.printmap(area2.floor5, 10, 9);
            System.out.println("POSITION   X: " +area2.POS[1]+ " Y: "+area2.POS[0]);
            System.out.println("Current tile:" +area2.tile[player.playerTILE]+"\tHP: "+area2.player_HP[0]);

            POS_inp = readInt("1 FORWARD\t3 LEFT\n2 BACKWARD\t4 RIGHT\nINPUT:\t5 INTERACT", 7);

            player.moveYPOS(area2.POS, POS_inp);  

            if(player.playerTILE == 2){
                int encounter = 0;
                int add = 0;
                encounter = random.nextInt(4)+1;
                if(encounter == 1){
                    add = random.nextInt(100)+50;
                    player.cRUNE = player.cRUNE + add;
                    System.out.println("YOU GAINED" +add+ "RUNES!");
                    presstoContinue();
                }
                else if (encounter > 1){
                    battle = area2.enemyencounter(area2.player_HP, player.cDEX, player.cINT, player.cEND, player.cSTR, player.cFTH, player.eqpstat);
                    if(battle == 1){
                        System.out.println("YOU DIED!");
                        player.cRUNE = 0;
                        game = false;
                        util.presstoContinue();
                    }
                    else if(battle == 0){
                        System.out.println("YOU WON!");
                        System.out.println("GAINED "+area2.player_rune[0]+" RUNES");
                        player.cRUNE = player.cRUNE + area2.player_rune[0];
                        util.presstoContinue();
                    }
                }
      
                }
            
                area2.checkborder(area2.POS, 9, 8);
            
                if(player.playerTILE == 5){
                    battle = area2.bossencounter(area2.player_HP, player.cDEX, player.cINT, player.cEND, player.cSTR, player.cFTH, player.eqpstat);
                        if(battle == 1){
                            System.out.println("YOU DIED!");
                            player.cRUNE = 0;
                            game = false;
                            util.presstoContinue();
                        }
                        else if(battle == 0){
                            System.out.println("GREAT ENEMY FELLED!");
                            System.out.println("GAINED "+area2.player_rune[0]+" RUNES");
                            player.cRUNE = player.cRUNE + area2.player_rune[0];
                            player.area2boss_state =1;
                            util.presstoContinue();
                        }
                }

            if(POS_inp == 5 && player.playerTILE == 3 ){ //interact
                game = false;
            }
            else if(POS_inp == 5 && player.playerTILE == 4){
                game = false;
                gameloop();
            }
        
        }
        if(player.playerTILE == 3 && area2.floor5[8][4] == 1)
        startmap2area2(1,3);
   }


   public static void startmap3area1(int Y, int X){
    boolean game = true;
    area3.initizalizemap(area3.floor1, 11, 5);
    area3.POS[0] = Y;
    area3.POS[1] = X; //PLAYER POS
    int POS_inp = 0;
    area3.floor1[area3.POS[0]][area3.POS[1]] = 1; //setting player 
    area3.player_HP[0] =  100 * ((player.cHP+player.eqpstat[0])/2);
        while(game){
            
            clearConsole();
            area3.initizalizemap(area3.floor1, 11, 5); //initialize space
            area3.initializefloor1(area3.floor1); //initialize tiles

            player.playerTILE = area3.floor1[area3.POS[0]][area3.POS[1]]; //get player tile from player POS
            area3.floor1[area3.POS[0]][area3.POS[1]] = area3.tileID[1]; //set to PLAYER tileid

            
            area3.printmap(area3.floor1, 11, 5);
            System.out.println("POSITION   X: " +area3.POS[1]+ " Y: "+area3.POS[0]);
            System.out.println("Current tile:" +area3.tile[player.playerTILE]);

            POS_inp = readInt("1 FORWARD\t3 LEFT\n2 BACKWARD\t4 RIGHT\nINPUT:\t5 INTERACT", 7);

            player.moveYPOS(area3.POS, POS_inp);  

            if(player.playerTILE == 2){
                int add = 0;
                    add = random.nextInt(100)+50;
                    player.cRUNE = (player.cRUNE + add)*3;
                    System.out.println("YOU GAINED" +add+ "RUNES!");
                    presstoContinue();
                }
            
      
            
                area3.checkborder(area3.POS, 10, 4);


            if(POS_inp == 5 && player.playerTILE == 3 ){ //interact
                game = false;
            }
            else if(POS_inp == 5 && player.playerTILE == 4){
                game = false;
                gameloop();
            }
            
        }
        if(player.playerTILE == 3 && area3.floor1[1][2] == 1)
        startmap3area2(7,4);
   }


   public static void startmap3area2(int Y, int X){
    boolean game = true;
    area3.initizalizemap(area3.floor2, 9, 9);
    area3.POS[0] = Y;
    area3.POS[1] = X; //PLAYER POS
    int POS_inp = 0;
    area3.floor2[area3.POS[0]][area3.POS[1]] = 1; //setting player 
    int battle = 0;
        while(game){
            
            clearConsole();
            area3.initizalizemap(area3.floor2, 9, 9); //initialize space
            area3.initializefloor2(area3.floor2); //initialize tiles

            player.playerTILE = area3.floor2[area3.POS[0]][area3.POS[1]]; //get player tile from player POS
            area3.floor2[area3.POS[0]][area3.POS[1]] = area3.tileID[1]; //set to PLAYER tileid

            
            area3.printmap(area3.floor2, 9, 9);
            System.out.println("POSITION   X: " +area3.POS[1]+ " Y: "+area3.POS[0]);
            System.out.println("Current tile:" +area3.tile[player.playerTILE]);

            POS_inp = readInt("1 FORWARD\t3 LEFT\n2 BACKWARD\t4 RIGHT\nINPUT:\t5 INTERACT", 7);

            player.moveYPOS(area3.POS, POS_inp);  

            if(player.playerTILE == 2){
                int encounter = 0;
                int add = 0;
                encounter = random.nextInt(4)+1;
                if(encounter == 1){
                    add = random.nextInt(100)+50;
                    player.cRUNE = player.cRUNE + add;
                    System.out.println("YOU GAINED" +add+ "RUNES!");
                    presstoContinue();
                }
                else if (encounter > 1){
                    System.out.println(" YOU ENCOUNTERED AN ENEMY!");
                    presstoContinue();
                }
      
                }
            
                area3.checkborder(area3.POS, 8, 8);

            if(player.playerTILE == 5){
                battle = area3.bossencounter(area3.player_HP, player.cDEX, player.cINT, player.cEND, player.cSTR, player.cFTH, player.eqpstat);
                    if(battle == 1){
                        System.out.println("YOU DIED!");
                        player.cRUNE = 0;
                        game = false;
                        util.presstoContinue();
                    }
                    else if(battle == 0){
                        System.out.println("GREAT ENEMY FELLED!");
                        System.out.println("GAINED "+area3.player_rune[0]+" RUNES");
                        player.cRUNE = player.cRUNE + area3.player_rune[0];
                        util.presstoContinue();
                    }
               }

            if(POS_inp == 5 && player.playerTILE == 3 ){ //interact
                game = false;
            }
            else if(POS_inp == 5 && player.playerTILE == 4){
                game = false;
                gameloop();
            }
        
        }
        if(player.playerTILE == 3 && area3.floor2[7][4] == 1)
        startmap3area1(1,2);
        if(player.playerTILE == 3 && area3.floor2[1][4] == 1)
        startmap3area3(9,2);
   }

   public static void startmap3area3(int Y, int X){
    boolean game = true;
    area3.initizalizemap(area3.floor3, 11, 5);
    area3.POS[0] = Y;
    area3.POS[1] = X; //PLAYER POS
    int POS_inp = 0;
    area3.floor3[area3.POS[0]][area3.POS[1]] = 1; //setting player 
        while(game){
            
            clearConsole();
            area3.initizalizemap(area3.floor3, 11, 5); //initialize space
            area3.initializefloor3(area3.floor3); //initialize tiles

            player.playerTILE = area3.floor3[area3.POS[0]][area3.POS[1]]; //get player tile from player POS
            area3.floor3[area3.POS[0]][area3.POS[1]] = area3.tileID[1]; //set to PLAYER tileid

            
            area3.printmap(area3.floor3, 11, 5);
            System.out.println("POSITION   X: " +area3.POS[1]+ " Y: "+area3.POS[0]);
            System.out.println("Current tile:" +area3.tile[player.playerTILE]);

            POS_inp = readInt("1 FORWARD\t3 LEFT\n2 BACKWARD\t4 RIGHT\nINPUT:\t5 INTERACT", 7);

            player.moveYPOS(area3.POS, POS_inp);  

            if(player.playerTILE == 2){
                int add = 0;
                    add = random.nextInt(100)+50;
                    player.cRUNE = (player.cRUNE + add)*3;
                    System.out.println("YOU GAINED" +add+ "RUNES!");
                    presstoContinue();
                }
            
                area3.checkborder(area3.POS, 10, 4);

            
            if(POS_inp == 5 && player.playerTILE == 3 ){ //interact
                game = false;
            }
            else if(POS_inp == 5 && player.playerTILE == 4){
                game = false;
                gameloop();
            }

            if(POS_inp == 5 && player.playerTILE == 6){
                game = false;
            }
        
        }
        if(player.playerTILE == 3 && area3.floor3[9][2] == 1)
        startmap3area2(1,4);


        clearConsole();
        System.out.println(" YOU BEAT THE GAME CONGRATS !!!");
        presstoContinue();
        isrunning = false;
   }
   

}