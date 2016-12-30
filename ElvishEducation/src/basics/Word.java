package basics;

/**
 * Basic representation of a word in a single,
 * non-specified language.
 * 
 * @author Michael Taft Morris
 * @version 15.05.17
 */
public class Word
{
    private String word;
    
    public Word( String w )
    {
        word = w;
    }
    
    public String toString()
    {
        return word;
    }
}
