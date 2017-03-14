package vocab;

/**
 * A word's representation in English and Quenya.
 * 
 * @author Michael Taft Morris 
 * @version 15.05.17
 */
import basics.*;
public class Vocab
{
    private final Word english, quenya;
    
    public Vocab( Word e, Word q )
    {
        english = e;
        quenya = q;
    }
    
    /**
     * Overrides toString method in Object class
     * 
     * @return Basic form of the word in English and Quenya.
     */
    @Override
    public String toString()
    {
        return english + ", " + quenya;
    }
    
    /**
     * Used to get the word in one language or the other.
     * 
     * @param q A boolean value representing the language; true : Quenya, false : English.
     * 
     * @return The Word object representing the word in the desired language.
     */
    public Word getWord( boolean q )
    {
        if( q )
        {
            return quenya;
        }
        else
        {
            return english;
        }
    }
}