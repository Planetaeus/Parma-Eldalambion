package basics.verbs;

/**
 * A Verb in English
 * 
 * @author Michael Taft Morris
 * @version 15.09.01
 */
public class EVerb extends Verb
{
    //15.05.12 Changed presentContSing to presentCont, as well as relevant parameters.
    private final String presentParticiple, past, aorist, perfect;
    private final boolean irregularAorist;
    
    /**
     * Constructor for an English Verb
     * 
     * @param w The infinitive of the verb.
     * @param presentPart The present participle of the verb
     * @param a The aorist form of the verb
     * @param isFunky Identifies whether the verb has an irregular aorist form
     * @param p The Past tense of the verb
     * @param pastPart The past participle of the verb
     */
    public EVerb( String w, String a, boolean isFunky, String presentPart, String p, String pastPart )
    {
        super( w );
        aorist = a;
        irregularAorist = isFunky;
        presentParticiple = presentPart;
        past = p;
        perfect = pastPart;
    }
    
    @Override
    public String getPresentCont( boolean sing )
    {
        if( sing )
        {
            return "is " + presentParticiple;
        }
        else
        {
            return "are " + presentParticiple;
        }
    }
    
    @Override
    public String getPast( boolean sing )
    {
        return past;
    }
    
    @Override
    public String getFuture( boolean sing )
    {
        return "will " + toString();
    }
    
    @Override
    public String getAorist( boolean sing )
    {
        if( sing && irregularAorist )
            return aorist;
        else if( sing )
            return toString() + "s";
        else
            return toString();
    }
    
    @Override
    public String getPerfect( boolean thirdPersonSing )
    {
        if( thirdPersonSing )
        {
            return "has " + perfect;
        }
        return "have " + perfect;
    }
    
    @Override
    public String getInfinitive()
    {
        return "to " + toString();
    }
    
    @Override
    public String negativity( int tense, boolean sing )
    {
        String neg;
        switch( tense )
        {
            case 1:
                if( sing )
                    neg = "is not ";
                else
                    neg = "are not ";
                neg += presentParticiple;
                break;
            case 2:
                neg = "did not " + toString();
                break;
            case 3:
                neg = "will not " + toString();
                break;
            case 4:
                if( sing )
                    neg = "does not ";
                else
                    neg = "do not ";
                neg += toString();
                break;
            default:
                throw new IllegalArgumentException( "We only have 4 negatives right now." );
        }
        
        return neg;
    }
    
    @Override
    public String getActiveParticiple()
    {
        return presentParticiple;
    }
}
