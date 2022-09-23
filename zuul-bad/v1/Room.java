package v1;
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author Abel DIDOUH
 */
public class Room
{
    /**
     * Attributs (private)
     */
    private String aDescription;
    /**
     * Attributs (public)
     */
    public Room aNorthExit;
    public Room aEastExit;
    public Room aSouthExit;
    public Room aWestExit;
    
    /**
     * Constructeur naturel
     * @param pDescription chaine pour initialiser aDescription
     */
    public Room(final String pDescription)
    {
        this.aDescription = pDescription;
    }//Room()
    
    /**
     *Accesseur sur l'attribut aDescription
     */
    public String getDescription()
    {
        return this.aDescription;
    }
    
    /**
     * Modificateur
     * @param pNorthExit Room pour modifier l'attribut aNorthExit
     * @param pEastExit  Room pour modifier l'attribut aEastExit
     * @param pSouthExit Room pour modifier l'attribut aSouthExit
     * @param pWestExit  Room pour modifier l'attribut aWestExit
     */
    public void setExits(final Room pNorthExit, final Room pEastExit, 
                         final Room pSouthExit, final Room pWestExit)
    {
        this.aNorthExit = pNorthExit;
        this.aEastExit  = pEastExit;
        this.aSouthExit = pSouthExit;
        this.aWestExit  = pWestExit;
    }
                          
} // Room
