
/**
 * The abstract class representing a map.
 */
public abstract class map {
  public int[] POS = {0, 0};
  public String[] tile = {"SPACE","PLAYER", "SPAWN" ,"DOOR", "FAST TRAVEL", "BOSS", "END"};
  public int[]  tileID = {0,1,2,3,4,5};
  
  public double[][] enemy_type1 = {{0,20,30}, {0,70,80}, {0.20},{0.15},{0.10}};
  public double[][] enemy_type2 = {{0,25,35}, {0,110,120}, {0.50},{0.15},{0.20}};
  public double[][] enemy_type3 = {{0,70,80}, {0,120,130}, {0.25},{0.25},{0.20}};

  /**
   * Constructs a map with the given dimensions.
   * 
   * @param X the width of the map
   * @param Y the height of the map
   */
  public map(int X, int Y){   
      X = 0;
      Y = 0;
  }

  /**
   * Initializes the map with the specified dimensions.
   * 
   * @param MAP the map to be initialized
   * @param Y the height of the map
   * @param X the width of the map
   */
  void initizalizemap(int MAP[][], int Y, int X){
      for(int i = 0; i < Y; i++){
          for(int j = 0; j < X; j++){
              MAP[i][j] = 0; 
          }
      }
  }

  /**
   * Prints the map.
   * 
   * @param MAP the map to be printed
   * @param Y the height of the map
   * @param X the width of the map
   */
  public void printmap(int MAP[][], int Y, int X){
      for(int i = 0; i < Y; i++){
          for(int j = 0; j < X; j++){
              System.out.print(MAP[i][j]);
          }
          System.out.println();
      }
  }

  /**
   * Checks if the position is at the border of the map and adjusts it if necessary.
   * 
   * @param POS the position to be checked and adjusted
   * @param Y the height of the map
   * @param X the width of the map
   * @return the adjusted position
   */
  int[] checkborder(int[] POS, int Y, int  X){
      if(POS[0] == Y){
          POS[0]--;
      }
      else if(POS[1] == X){
          POS[1]--;
      }
      else if(POS[1] == 0){
          POS[1]++;
      }
      else if(POS[0] == 0){
          POS[0]++;
      }
      return POS;
  }

  /**
   * Placeholder method for door tile functionality.
   */
  void doorTile(){

  }

  /**
   * Assigns the player's position on the map.
   * 
   * @param playerpos the player's position to be assigned
   * @param Y the height of the map
   * @param X the width of the map
   */
  public void assignPLAYERTILE(int playerpos[] ,int Y , int  X){
      playerpos[0] = Y;
      playerpos[1] = X;
  }

  /**
   * Removes a tile from the map.
   * 
   * @param MAP the map from which the tile should be removed
   * @param Y the height of the map
   * @param X the width of the map
   */
  public void removeTILE(int MAP[][],int Y,int X){
      MAP[Y][X] = 0;
  }

  /**
   * Simulates an encounter and returns a value.
   * 
   * @return the value of the encounter
   */
  public int encounter(){
      int this1 = 0;
      return this1;
  }
}
