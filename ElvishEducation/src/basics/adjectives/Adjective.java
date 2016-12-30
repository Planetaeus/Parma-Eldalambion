package basics.adjectives;

import basics.Word;

/**
 * Representation of an adjective in a non-specified language
 * 
 * @author Michael Taft Morris
 * @version 15.05.17
 */
public abstract class Adjective extends Word
{   
    private final String type;
    private String superlative;
    /**
     * Constructor for a Quenya adjective.
     * 
     * @param w The basic form of the adjective.
     * @param t The type of adjective, used for comparatives and superlatives
     */
    public Adjective( String w, String t )
    {
        super( w );
        type = t;
    }
    
    public String type()
    {
        return type;
    }
    
    public abstract void superlative();
    public abstract void setUp();
    
    public void setSuperlative( String s )
    {
        superlative = s;
    }
    
    public String getSuperlative()
    {
        return superlative;
    }
}
