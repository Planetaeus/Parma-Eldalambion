package practice;
/**
 * Contains a method to randomly generate a boolean value.
 * 
 * @author Michael Taft Morris 
 * @version 15.05.17
 */

import basics.verbs.Verb;
import gui.TextManipulation;
import gui.Index;
import vocab.*;
public class Practice
{
    /**
     * Method to retrieve a random boolean value
     * 
     * @return A random boolean value.
     */
    public static boolean randomBoolean()
    {
        double i = Math.random() * 2;
        if( i < 1 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static String getLang( boolean l )
    {
        if( l )
        {
            return "Quenya";
        }
        else
        {
            return "English";
        }
    }
    
    public static String [] articles( VocabNoun n, boolean sing, boolean definite )
    {
        String e = n.toString( sing )[ 1 ], q = n.toString( sing )[ 0 ];
        
        if( definite )
        {
            e = "the " + e;
            q = "i " + q;
        }
        else if( sing && ( e.substring(0, 1).equals("a") || e.substring(0, 1).equals("e") || e.substring(0, 1).equals("i") || e.substring(0, 1).equals("o") || e.substring(0, 1).equals("u") ) )
        {
            e = "an " + e;
        }
        else if( sing )
        {
            e = "a " + e;
        }
        
        return new String [] { q, e };
    }

    public static String[] phrases( int tense, boolean negativity )
    {
        String e;
        String q;
        String[] subject,
                 verb,
                 object;
        if (tense == Verb.NUM_TENSES + 1)
        {
            tense = (int) (Math.random() * Verb.NUM_TENSES) + 1;
        }
        
        VocabNoun n = (VocabNoun) VocabFactory.randomWord( 1 );
        while( n.getVerbs().length == 0 )
        {
            n = (VocabNoun) VocabFactory.randomWord(1);
        }
        VocabVerb v = n.getAction();
        boolean l = randomBoolean(); //true: The prompt will be in Quenya, the answer will be in English
        boolean num = randomBoolean(); //true: the subject is singular
        boolean subAdj = randomBoolean(); //true: the subject has an adjective
        boolean inf = randomBoolean(); //true: The verb of the sentence will be followed by an infinitive
        
        //Adds adjectives and articles to the subject
        if (subAdj)
        {
            subject = AdjectivePractice.adjectives(n, num, l);
        } else
        {
            subject = Practice.articles(n, num, randomBoolean());
        }
        
        //Negates and/or conjugates the verb
        if( !negativity )
            verb = v.getVerb( tense, num, true );
        else
            verb = v.getNegative( tense, num, true );
        
        while( inf && v.getInfinitive() != null )
        {
            v = v.getInfinitive();
            String [] i = v.infinitive();
            verb[ 0 ] += " " + i[ 0 ];
            verb[ 1 ] += " " + i[ 1 ];
            
            inf = randomBoolean();
        }
        
        object = v.getObjects();
        
        //Returns the answer and prompt in the determined order
        if (l)
        {
            e = (subject[1] + " " + verb[1] + " " + object[1]).trim();
            q = (subject[0] + " " + verb[0] + " " + object[0]).trim();
            return new String[]{q, e};
        }
        else
        {
            if (subAdj)
            {
                e = (subject[0] + " " + verb[1] + " " + object[1]).trim();
                q = (subject[1] + " " + verb[0] + " " + object[0]).trim();
            } else
            {
                e = (subject[1] + " " + verb[1] + " " + object[1]).trim();
                q = (subject[0] + " " + verb[0] + " " + object[0]).trim();
            }
        }
        
        return new String[]{e, q};
    }

    /**
     * @return An array containing a random word and its counterpart in the other language
     */
    public static String[] words()
    {
        boolean q = randomBoolean();
        Vocab v = VocabFactory.randomWord();
        return new String[]{v.getWord(q).toString(), v.getWord(!q).toString()};
    }
}
