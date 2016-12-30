package vocab;

/**
 * Write a description of class VocabV here.
 * 
 * @author (your name) 
 * @version 15.09.27
 */

import basics.verbs.*;
import gui.VocabFactory;
import practice.AdjectivePractice;
import practice.Practice;
public class VocabVerb extends Vocab
{
    private final int [] objects, indObjects, infinitives;
    
    public VocabVerb( EVerb e, QVerb q, int [] o, int [] iO )
    {
        super( e, q );
        objects = o;
        indObjects = iO;
        infinitives = null;
    }
    
    public VocabVerb( EVerb e, QVerb q, int [] o, int [] iO, int [] i )
    {
        super( e, q );
        objects = o;
        indObjects = iO;
        infinitives = i;
    }

    /**
     * Used to get a verb in the desired tense, and number.
     * 
     * @param tense An int value used to distinguish the tense to which the verb is to be conjugated.
     * @param sing A boolean value representing whether the subject is singular or plural; true : singular, false : plural.
     * @param thirdPerson A boolean identifying whether the subject is in the third person
     * 
     * @return The verb conjugated to the specified tense, agreeing with a subject of the specified number.
     */
    public String [] getVerb( int tense, boolean sing, boolean thirdPerson )
    {
        if( tense == 4 || tense == 5 || tense == 1 )
            return new String [] { ((Verb)getWord( true )).getTense( tense, sing ), ((Verb)getWord( false )).getTense( tense, sing && thirdPerson ) };
        
        return new String [] { ((Verb)getWord( true )).getTense( tense, sing ), ((Verb)getWord( false )).getTense( tense, sing ) };
    }
    
    /**
     * Used to get a negated verb in the desired tense and number
     * 
     * @param tense An int value used to identify the tense of the verb
     * @param sing A boolean value representing the singularity of the subject
     * @param thirdPerson A boolean value representing whether the subject is in third person
     * 
     * @return The negated verb conjugated to the specified tense, and agreeing in number with the subject
     */
    public String [] getNegative( int tense, boolean sing, boolean thirdPerson )
    {
        if( tense == 4  || tense == 1 )
            return new String [] { ((Verb)getWord( true )).negativity( tense, sing ), ((Verb)getWord( false )).negativity( tense, sing && thirdPerson ) };
        if( tense == 5 )
            return getVerb( tense, sing, thirdPerson );
        return new String [] { ((Verb)getWord( true )).negativity( tense, sing ), ((Verb)getWord( false )).negativity( tense, sing ) };
    }
    
    public String [] getActiveParticiple()
    {
        return new String [] { ((Verb)getWord( true )).getActiveParticiple(), ((Verb)getWord( false )).getActiveParticiple() };
    }
    
    public String [] infinitive()
    {
        return new String [] { ((Verb)getWord( true )).getInfinitive(), ((Verb)getWord( false )).getInfinitive() };
    }
    
    /**
     * @return A random object that can follow the verb. If there are no such objects, no word is returned.
     */
    public String [] getObjects()
    {
        String [] dirObj = new String [] { "", "" };
        String [] indObj = new String [] { "", "" };
        
        if( indObjects.length > 0 && Practice.randomBoolean() )
        {    
            int i = (int)( Math.random() * ( indObjects.length ) );
            indObj = VocabFactory.makePreposition( indObjects[ i ] ).indObject();
        }
        
        if( objects.length > 0 )
        {
            int i = (int)( Math.random() * ( objects.length ) );
            
            dirObj = AdjectivePractice.adjectives( VocabFactory.makeNoun( objects[ i ] ), Practice.randomBoolean(), true );
        }
        
        return new String [] { ( dirObj[ 0 ] + " " + indObj[ 0 ]).trim(), ( dirObj[ 1 ] + " " + indObj[ 1 ]).trim() };
    }
    
    /**
     * @return An indirect object to follow the verb
     */
    public String [] getIndObject()
    {
        String [] indObj = new String [] { "", "" };
        if( indObjects.length > 0 )
        {    
            int i = (int)( Math.random() * ( indObjects.length ) );
            indObj = VocabFactory.makePreposition( indObjects[ i ] ).indObject();
        }
        return indObj;
    }
    
    public VocabVerb getInfinitive()
    {
        VocabVerb inf = null;
        if( infinitives != null )
        {
            int i = (int)( Math.random() * infinitives.length );
            inf = VocabFactory.makeVerb( infinitives[ i ] );
        }
        return inf;
    }
}
