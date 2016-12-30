package basics;

/**
 * Represents a noun in a non-specified language
 * 
 * @author Michael Taft Morris 
 * @version 15.05.17
 */

public class ENoun extends Word
{
    private String plural; //15.05.12 removed deprecated adjectives and verbs arrays
    private final boolean hasPlural;
    
    /**
     * Constructor for a Noun object.
     * 
     * @param w The basic form of the noun.
     * @param p The plural form of the noun.
     */
    public ENoun( String w, String p )
    {
        super( w ); //Passes the basic form of the word to the superclass
        plural = p; //Plural form of the word
        hasPlural = true;
    }
    
    public ENoun( String w )
    {
        super( w );
        hasPlural = false;
    }
    
    /**
     * Fetches the plural form of the noun.
     * 
     * @return The plural form of the noun.
     */
    public String getPlural()
    {
        return plural;
    }
    
    public boolean hasPlural()
    {
        return hasPlural;
    }
}