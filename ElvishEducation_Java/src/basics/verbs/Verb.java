package basics.verbs;

import basics.Word;

/**
 * The parent abstract class for verbs. Contains the getTense method, and has abstract
 * methods for all tenses.
 * 
 * @author Michael
 * @version 15.09.01
 */
public abstract class Verb extends Word
{
    public static final int NUM_TENSES = 5;
    public Verb( String w )
    {
        super( w );
    }
    /**
     * Allows user to request a specific conjugation of the verb
     * in singular or plural form.
     * 
     * @param tense An int value used in the switch statement to return the desired conjugation of the verb.
     * @param sing A boolean value representing the number with which the verb is to agree; true : singular, false : plural.
     * 
     * @return The verb in the right tense agreeing with the given number.
     */
    public String getTense( int tense, boolean sing )
    {
        switch( tense )
        {
            case 1:
                return getPresentCont( sing );
            case 2:
                return getPast( sing );
            case 3:
                return getFuture( sing );
            case 4:
                return getAorist( sing );
            case 5:
                return getPerfect( sing );
            case 6:
                return getInfinitive();
            case 7:
                return getActiveParticiple();
            default:
                throw new IllegalArgumentException( "I am sorry, we have not gotten to that tense yet." );
        }
    }
    
    /**
     * The present continuous form of the verb. ("is -ing").
     * 
     * @param sing A boolean value representing the number with which the verb is to agree; true : singular, false : plural.
     * 
     * @return The present continuous form of the verb, agreeing with the given number.
     */
    public abstract String getPresentCont( boolean sing );
    
    /**
     * The past form of the verb ( "-ed" )
     * 
     * @param sing A boolean value representing the number of the subject
     * 
     * @return The past form of the verb, agreeing in number with the subject
     */
    public abstract String getPast( boolean sing );
    
    /**
     * The future form of the verb ( "will ___" )
     * 
     * @param sing A boolean value representing the number of the subject
     * 
     * @return The future form of the verb, agreeing in number with the subject
     */
    public abstract String getFuture( boolean sing );
    
    /**
     * The aorist form of the verb (in English, the simple present)
     * 
     * @param sing A boolean value representing the number of the subject
     * 
     * @return The aorist form of the verb, agreeing in number with the subject
     */
    public abstract String getAorist( boolean sing );
    
    /**
     * The perfect form of the verb ( "has ___-ed" )
     * 
     * @param sing A boolean value representing the number of the subject
     * 
     * @return The perfect past form of the verb, agreeing in number with the subject
     */
    public abstract String getPerfect( boolean sing );
    
    /**
     * The infinitive of the verb ( "to ___" )
     * 
     * @return The infinitive of the verb
     */
    public abstract String getInfinitive();
    
    /**
     * Negates the verb into the desired tense
     * 
     * @param tense The desired tense for the verb
     * @param sing The number of the subject
     * 
     * @return The negative form of the verb in the desired tense
     */
    public abstract String negativity( int tense, boolean sing );
    
    /**
     * Provides the active participle
     * 
     * @return The active participle of the verb
     */
    public abstract String getActiveParticiple();
}
