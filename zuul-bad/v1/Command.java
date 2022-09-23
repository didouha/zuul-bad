package v1;

/**
 * Classe Command - une commande du jeu d'aventure Zuul.
 *
 * @author DIDOUH Abel
 */
public class Command
{
    /**
     * Attributs (private)
     */
    private String aCommandWord;
    private String aSecondWord;
    
    /**
     * Constructeur naturel
     * @param chaine pour initialiser aCommandWord
     * @param chaine pour initialiser aSecondWord
     */
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord  = pSecondWord; 
    }//Command()
    
    /**
     * Accesseurs
     */
    public String getCommandWord()
    {
        return this.aCommandWord;
    }//getCommandWord
    public String getSecondWord()
    {
        return this.aSecondWord;
    }//getSecondWord
    
    /**
     * Fonction booléenne qui permettra de vérifier qu'un second 
     * mot a bien été tapé.
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    }//hasSecondWord
    
    /**
     * Fonction booléenne qui retourne vrai si le premier mot est null.
     */
    public boolean isUnknown()
    {
        return this.aCommandWord == null;
    }//isUnknown
} // Command
