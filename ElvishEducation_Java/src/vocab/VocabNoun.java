package vocab;

/**
 * A Vocabulary object specifically representing a Noun
 * 
 * @author Michael Taft Morris
 * @version 15.05.17
 */

import basics.ENoun;
import basics.QNoun;
import gui.VocabFactory;
public class VocabNoun extends Vocab
{
    private final int [] adjectives, verbs;
    
    /**
     * Constructor for a noun-based Vocab object
     * 
     * @param e A Noun object for the word in English
     * @param q A Noun object for the word in Quenya
     * @param a An int array containing the index values of the adjectives associated with the noun.
     * @param v An int array containing the index values of the verbs associated with the noun.
     */
    public VocabNoun( ENoun e, QNoun q, int [] a, int [] v )
    {
        super( e, q );
        
        adjectives = a;
        verbs = v;
    }
    
    /**
     *  Fetches a random adjective associated with the
     *  noun vocab word.
     *  
     *  @return A random adjective from the list of those associated with the noun.
     */
    public VocabAdjective getDescriptor()
    {
        int i = (int)(Math.random() * adjectives.length );
        return VocabFactory.makeAdjective( adjectives[ i ] );
    }
    
    /**
     * Fetches a random verb associated with the noun vocab
     * word.
     * 
     * @return A random VocabVerb object that is associated with the noun.
     */
    public VocabVerb getAction()
    {
        int i = (int)(Math.random() * verbs.length );
        return VocabFactory.makeVerb( verbs[ i ] );
    }
    
    /**
     * Returns the String value of the noun represented in
     * singular or plural across English and Quenya
     * 
     * @param sing A boolean value representing the desired number; true : singular, false : plural.
     * 
     * @return The String value of the noun in the desired number and language.
     */
    public String [] toString( boolean sing )
    {
        if( sing || !((ENoun)getWord( false )).hasPlural() )
        {
            return new String [] { getWord( true ).toString(), getWord( false).toString() };
        }
        else
        {
            return new String [] { ( (QNoun)getWord( true ) ).getPlural(), ( (ENoun)getWord( false ) ).getPlural() };
        }
    }
    
    public int [] getVerbs()
    {
        return verbs;
    }
    
    public int [] getAdjectives()
    {
        return adjectives;
    }
}
