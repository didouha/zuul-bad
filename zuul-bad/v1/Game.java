package v1;

/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author DIDOUH Abel
 */
public class Game
{
    /**
     * Attributs (private)
     */
    private Room   aCurrentRoom;
    private Parser aParser;
      
    /**
     * Procedure privée createRooms
     */
    private void createRooms()
    {
       //Création des pieces
       
       Room vCampusPub      = new Room("in the campus pub");
       Room vLectureTheatre = new Room("in a lecture theatre");
       Room vComputingLab   = new Room("in a computing lab ");
       Room vComputingAdmin = new Room("in the computing admin office");
       Room vOutside        = new Room("outside the main entrance of the university");
       
       //Definition des sorties
       //Nord Est Sud Ouest
       vCampusPub.setExits(null,vOutside,null,null);
       vOutside.setExits(null,vLectureTheatre, vComputingLab, vCampusPub);
       vLectureTheatre.setExits(null, null, null, vOutside);
       vComputingLab.setExits(vOutside, vComputingAdmin, null, null);
       vComputingAdmin.setExits(null, null, null, vComputingLab); 
       
       //Definition du point de depart
       this.aCurrentRoom = vOutside;  
       
    }
    
    /**
     * Constructeur par defaut
     */
    public Game()
    {
        this.createRooms();
        this.aParser = new Parser();
    }
    /**
     * Procédure privée goRoom
     */
    private void goRoom(final Command pDir)
    {
        //a
        if(!pDir.hasSecondWord())
        {
            System.out.println("Go where ?");
            return;
        }
        
        //b
        Room vNextRoom = null;
        String vDirection = pDir.getSecondWord();
        
        if(vDirection.equals("north"))
        {
            vNextRoom = this.aCurrentRoom.aNorthExit;
        }
        else if(vDirection.equals("east"))
        {
            vNextRoom = this.aCurrentRoom.aEastExit;
        }
        else if(vDirection.equals("south"))
        {
            vNextRoom = this.aCurrentRoom.aSouthExit;
        }
        else if(vDirection.equals("west"))
        {
            vNextRoom = this.aCurrentRoom.aWestExit;
        }
        else
        {
           System.out.println("Unknown direction !");
           return;
        }
        
        //c
        if(vNextRoom == null)
        {
            System.out.println("There is no door !");
            return;
        }
        
        //d
        this.aCurrentRoom = vNextRoom;
        System.out.println(this.aCurrentRoom.getDescription());
        String vNorthExit = "";
        String vEastExit  = "";
        String vSouthExit = "";
        String vWestExit  = "";
        
        if(this.aCurrentRoom.aNorthExit != null)
        {
            vNorthExit = "north";
        }
        if(this.aCurrentRoom.aEastExit != null)
        {
            vEastExit = "east";
        }
        if(this.aCurrentRoom.aSouthExit != null)
        {
            vSouthExit = "south";
        }
        if(this.aCurrentRoom.aWestExit != null)
        {
            vWestExit = "west";
        }
        System.out.print("Exits: " + vNorthExit + vEastExit + vSouthExit + vWestExit);
    }//goRoom(Command pDir)
    /**
     * Procédure privée printWelcome
     */
    private void printWelcome()
    {
        String vNorthExit = "";
        String vEastExit  = "";
        String vSouthExit = "";
        String vWestExit  = "";
        
        if(this.aCurrentRoom.aNorthExit != null)
        {
            vNorthExit = "north";
        }
        if(this.aCurrentRoom.aEastExit != null)
        {
            vEastExit = "east";
        }
        if(this.aCurrentRoom.aSouthExit != null)
        {
            vSouthExit = "south";
        }
        if(this.aCurrentRoom.aWestExit != null)
        {
            vWestExit = "west";
        }
        
        System.out.println("Welcome to the World of Zuul !");
        System.out.print("World of Zuul is a new,");
        System.out.println("incredibly boring adventure game");
        System.out.println("Type 'help' if you need help");
        System.out.println(" ");
        System.out.println("You are " + this.aCurrentRoom.getDescription());
        System.out.print("Exits:");
        System.out.print(" " + vNorthExit);
        System.out.print(" " + vEastExit);
        System.out.print(" " + vSouthExit);
        System.out.println(" " + vWestExit);
    }//printWelcome
    /**
     * Procédure printHelp
     */
    private void printHelp()
    {
        System.out.println("You are lost. You are alone");
        System.out.println("You wander around at the university.");
        System.out.println("");
        System.out.println("Your command words are:");
        System.out.println("    go quit help");  
    }//printHelp
    /**
     * Fonction booléenne quit
     * @param Command pCommand 
     */
    private boolean quit(final Command pCommand)
    {
        if(pCommand.hasSecondWord() == true)
        {
            System.out.println("Quit what ?");
            return false;
        }
        else
        {
            return true;
        }
    }//quit
    /**
     * Fonction booléenne privée processCommand : appeler la bonne méthode 
     * en fonction de la commande passée en paramètre.
     * @param Command pCommand
     */
    private boolean processCommand(final Command pCommand)
    {
        String vCommand = pCommand.getCommandWord();
        if(vCommand.equals("quit"))
        {
            return quit(pCommand);
        }
        else if (vCommand.equals("go"))
        {
            this.goRoom(pCommand);
            return false;
        }
        else if (vCommand.equals("help"))
        {
            this.printHelp();
            return false;
        }
        else
        {
            System.out.println("I don't know what you mean ...");
            return false;
        }
    }//processCommand
    /**
     * Procédure play() sans paramètre qui devra lire  répétitivement des 
     * commandes au clavier et les exécuter jusqu'à ce qu'on tape "quit"
     */
    public void play()
    {
        this.printWelcome();
        boolean vFinished = false;
        Command vCommand;
        while(vFinished == false)
        {
            vCommand = this.aParser.getCommand();
            vFinished = processCommand(vCommand);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
} // Game
