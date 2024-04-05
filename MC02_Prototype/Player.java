/**
 * The `Player` class represents a player character in the game. It extends the `Character` class.
 * It contains methods and attributes related to the player's inventory, equipped items, and movement.
 */
public class Player extends Character{

    String[] wpn_class = {"Debug","Swords", "Katanas", "Whips", "Greatswords", "Staves", "Seals"}; 
    
    String[][] wpn_name = {{"NONE", "DEBUG", "DEBUG", "DEBUG", "DEBUG"}, 
    {"DEBUG", "Short Sword", "Rogier's Rapier", "Coded Sword", "Sword of Night and Flame"},
    {"DEBUG", "Uchigatana","Moonveil", "Rivers of Blood", "Hand of Malenia"},
    {"DEBUG", "Whip", "Urumi", "Throned Whip", "Hoslow's Petal Whip"},
    {"DEBUG", "Claymore", "Starscourge Greatsword ", "Inseperable Sword", "Maliketh's Black Blade"},
    {"DEBUG", "Astrologer's Staff", "Albinauric Staff", "Staff of the Guilty", "Carian Regal Scepter"},
    {"DEBUG", "Finger Seal", "Godslayer's Seal", "Golden Order Seal", "Dragon Communion Seal"}};

    int[][] eqpstate = new int[8][8]; 
    int[][] boughtstate = new int[8][8];

    int[] weaponstat = new int[8];
    int[] eqpstat = new int[8];    

    int[] tempstat = new int[8];
    public int area1boss_state = 0;
    public int area2boss_state = 0;
    public int area3boss_state = 0;

    String[] eqpname = {"NONE", "DEBUG"};

    //player constructor
    public Player(String name, int index){
        super(name,index);   
    
    }

    

    public int[] moveYPOS(int[] POS, int input){
    
        if(input == 1){ // forward
            POS[0]--;
        }
        else if(input == 2){ //backward
            POS[0]++;
        }
        else if(input == 3){ //left
             POS[1]--;
        }
        else if(input == 4){ //right
            POS[1]++;
        }
    
        return POS;
    }
    public void resetweaponstat(int[] weapon){
        weapon[0] = 0;
        weapon[1] = 0;
        weapon[2] = 0;
        weapon[3] = 0;
        weapon[4] = 0;
        weapon[5] = 0;
    }

    public void initializestate(int[][] state){
        for(int i = 0; i<7; i++){
            for(int j = 0; j<7; j++){
                state[i][j] = 0;
            }
        }
    }

    public void printinventory(int[][] boughtstate, String[][] name){
        
        for(int i = 1; i<7; i++){
            System.out.print("\n\n"+wpn_class[i]+ ":\n\n");
            for(int j = 1; j <7; j++){
                if(boughtstate[i][j]==1){
                    System.out.println(name[i][j]);
                }
            }
        }
        
    }

    public void printwpn(int[][] boughtstate, String[][] name, int index){
        int[] temp = new int[8];
            for(int j = 1; j <5; j++){
                weaponstat(index, j, temp);
                if(boughtstate[index][j]==1){
                    System.out.println(j+". "+name[index][j]+" -"+temp[7]+"DEX RQRD-");
                }
                else if(boughtstate[index][j]==0){
                    System.out.println(j+". "+name[index][j]+"-NOT OWNED");
                }
            }
    }

    public void printeqpd(int[] eqpstat, String[] eqpname){
        System.out.println("\nEquipped: "+eqpname[0]);
        System.out.println("HP: " +eqpstat[0]+"\tEND: "+eqpstat[3]);
        System.out.println("DEX: " +eqpstat[1]+"\tSTR: "+eqpstat[4]);
        System.out.println("INT: " +eqpstat[2]+"\tFTH: "+eqpstat[5]);
    }

    public void assigneqpd(String[][] wpn_name, String[] eqpname, int[] eqpstat, int i, int j){
        weaponstat(j, i, eqpstat);
        eqpname[0] = wpn_name[j][i];
    }


    public void weaponstat( int cinput, int input, int[] weapon){
        if(cinput == 1){//swords
            if(input == 1){//short sword
                weapon[0] = 0;
                weapon[1] = 0;
                weapon[2] = 15;
                weapon[3] = 15;
                weapon[4] = 15;
                weapon[5] = 15;
                weapon[6] = 1000;
                weapon[7] = 13;
            }
            else if(input == 2){ //rogiers rapier
                weapon[0] = 10;
                weapon[1] = 0;
                weapon[2] = 35;
                weapon[3] = 25;
                weapon[4] = 35;
                weapon[5] = 35;
                weapon[6] = 2000;
                weapon[7] = 18;
            }
            else if(input == 3){
                weapon[0] = 20;
                weapon[1] = 0;
                weapon[2] = 40;
                weapon[3] = 35;
                weapon[4] = 40;
                weapon[5] = 40;
                weapon[6] = 4000;
                weapon[7] = 21;
            }
            else if(input == 4){
                weapon[0] = 30;
                weapon[1] = 0;
                weapon[2] = 55;
                weapon[3] = 45;
                weapon[4] = 55;
                weapon[5] = 55;
                weapon[6] = 8000;
                weapon[7] = 25;
            }
        }
        else if(cinput == 2){//katanas
            if(input == 1){
                weapon[0] = 20;
                weapon[1] = 0;
                weapon[2] = 0;
                weapon[3] = 35;
                weapon[4] = 30;
                weapon[5] = 0;
                weapon[6] = 1875;
                weapon[7] = 15;
            }
            else if(input == 2){
                weapon[0] = 30;
                weapon[1] = 0;
                weapon[2] = 0;
                weapon[3] = 40;
                weapon[4] = 45;
                weapon[5] = 0;
                weapon[6] = 3750;
                weapon[7] = 20;
            }
            else if(input == 3){
                weapon[0] = 40;
                weapon[1] = 0;
                weapon[2] = 0;
                weapon[3] = 45;
                weapon[4] = 60;
                weapon[5] = 0;
                weapon[6] = 7500;
                weapon[7] = 25;
            }
            else if(input == 4){
                weapon[0] = 50;
                weapon[1] = 0;
                weapon[2] = 0;
                weapon[3] = 50;
                weapon[4] = 75;
                weapon[5] = 0;
                weapon[6] = 15000;
                weapon[7] = 30;
            }
        }
        else if(cinput == 3){//whips
            if(input == 1){
                weapon[0] = 15;
                weapon[1] = 0;
                weapon[2] = 0;
                weapon[3] = 60;
                weapon[4] = 20;
                weapon[5] = 0;
                weapon[6] = 1500;
                weapon[7] = 20;
            }
            else if(input == 2){
                weapon[0] = 20;
                weapon[1] = 0;
                weapon[2] = 10;
                weapon[3] = 70;
                weapon[4] = 40;
                weapon[5] = 0;
                weapon[6] = 3000;
                weapon[7] = 25;
            }
            else if(input == 3){
                weapon[0] = 30;
                weapon[1] = 0;
                weapon[2] = 0;
                weapon[3] = 80;
                weapon[4] = 50;
                weapon[5] = 40;
                weapon[6] = 5000;
                weapon[7] = 30;
            }
            else if(input == 4){
                weapon[0] = 35;
                weapon[1] = 0;
                weapon[2] = 20;
                weapon[3] = 90;
                weapon[4] = 55;
                weapon[5] = 20;
                weapon[6] = 10000;
                weapon[7] = 35;
            }
        }
        else if(cinput == 4){//greatsword
            if(input == 1){
                weapon[0] = 15;
                weapon[1] = 0;
                weapon[2] = 0;
                weapon[3] = 10;
                weapon[4] = 20;
                weapon[5] = 0;
                weapon[6] = 3000;
                weapon[7] = 9;
            }
            else if(input == 2){
                weapon[0] = 20;
                weapon[1] = 0;
                weapon[2] = 0;
                weapon[3] = 15;
                weapon[4] = 40;
                weapon[5] = 20;
                weapon[6] = 6000;
                weapon[7] = 14;
            }
            else if(input == 3){
                weapon[0] = 25;
                weapon[1] = 0;
                weapon[2] = 60;
                weapon[3] = 20;
                weapon[4] = 70;
                weapon[5] = 60;
                weapon[6] = 12000;
                weapon[7] = 19;
            }
            else if(input == 4){
                weapon[0] = 30;
                weapon[1] = 0;
                weapon[2] = 40;
                weapon[3] = 25;
                weapon[4] = 80;
                weapon[5] = 60;
                weapon[6] = 24000;
                weapon[7] = 24;
            }
        }
        else if(cinput == 5){//staves
            if(input == 1){
                weapon[0] = 5;
                weapon[1] = 0;
                weapon[2] = 25;
                weapon[3] = 20;
                weapon[4] = 5;
                weapon[5] = 15;
                weapon[6] = 2000;
                weapon[7] = 12;
            }
            else if(input == 2){
                weapon[0] = 10;
                weapon[1] = 0;
                weapon[2] = 45;
                weapon[3] = 30;
                weapon[4] = 10;
                weapon[5] = 35;
                weapon[6] = 4000;
                weapon[7] = 14;
            }
            else if(input == 3){
                weapon[0] = 15;
                weapon[1] = 0;
                weapon[2] = 65;
                weapon[3] = 40;
                weapon[4] = 15;
                weapon[5] = 60;
                weapon[6] = 8000;
                weapon[7] = 16;
            }
            else if(input == 4){
                weapon[0] = 25;
                weapon[1] = 0;
                weapon[2] = 85;
                weapon[3] = 50;
                weapon[4] = 20;
                weapon[5] = 75;
                weapon[6] = 16000;
                weapon[7] = 18;
            }
        }
        else if(cinput == 6){//seal
            if(input == 1){
                weapon[0] = 10;
                weapon[1] = 0;
                weapon[2] = 15;
                weapon[3] = 45;
                weapon[4] = 0;
                weapon[5] = 20;
                weapon[6] = 2500;
                weapon[7] = 10;
            }
            else if(input == 2){
                weapon[0] = 15;
                weapon[1] = 0;
                weapon[2] = 35;
                weapon[3] = 50;
                weapon[4] = 0;
                weapon[5] = 40;
                weapon[6] = 5000;
                weapon[7] = 12;
            }
            else if(input == 3){
                weapon[0] = 20;
                weapon[1] = 0;
                weapon[2] = 65;
                weapon[3] = 55;
                weapon[4] = 0;
                weapon[5] = 65;
                weapon[6] = 10000;
                weapon[7] = 14;
            }
            else if(input == 4){
                weapon[0] = 25;
                weapon[1] = 0;
                weapon[2] = 75;
                weapon[3] = 60;
                weapon[4] = 0;
                weapon[5] = 80;
                weapon[6] = 15000;
                weapon[7] = 18;
            }
        }


    }
}


