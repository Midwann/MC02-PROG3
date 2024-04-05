/**
 * The abstract class representing a character in the game.
 */
public abstract class Character {

    public String name;
    public int job_class;
    public String class_name;

    public int cLVL;
    public int cHP;
    public int cEND;
    public int cDEX;
    public int cSTR;
    public int cINT;
    public int cFTH;
    public int cXP;
    public int cRUNE;
    public int playerTILE;
    
    String[] job_name  = {"Debug","Vagabond", "Samurai", "Warrior", "Hero", "Astrologer", "Prophet"};



//constructer
public Character(String name,int index){
    int arr[] = new int[6];
    this.name = name;
    this.cLVL = 1;
    this.job_class = index;
    this.class_name = job_name[index];
    this.cXP = 0;
    arr=util.assignclassval(index);
    this.cHP = arr[0];
    this.cDEX = arr[1];
    this.cINT = arr[2];
    this.cEND = arr[3];
    this.cSTR = arr[4];
    this.cFTH = arr[5];
    this.cRUNE = 0;
    this.playerTILE = 0;
    //int index, int health, int dexterity, int endurance, int strength, int intelligence, int faith, int RUNE
}

}