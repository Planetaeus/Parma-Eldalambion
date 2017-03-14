package basics.verbs;


/**
 * A verb in Quenya.
 * 
 * @author Michael
 * @version 15.09.01
 */
public class QVerb extends Verb
{
    private final String stemType;
    
    /**
     * Constructor for a Quenya verb
     * 
     * @param w The stem of the Quenya verb
     * @param st The type of stem: "P" for Primary; "A" for A-Stem; "Y" for Ya; "c" ends in a consonant cluster; "d" has a dipthong as the stem vowel;
     */
    public QVerb( String w, String st )
    {
        super( w );
        stemType = st;
    }
    
    @Override
    public String getPresentCont( boolean sing )
    {
        String verb = toString();
        String singEnd;
        
        if( stemType.contains( "P" ) )
        {
            verb = lengthenVowel( verb );
            singEnd = "a";
        }
        else if( stemType.contains( "C" ) || stemType.contains( "D" ) || stemType.contains( "Y" ) )
        {
            verb = verb.substring( 0, verb.length() - 1 );
            singEnd = "ëa";
        }
        else
        {
            verb = verb.substring( 0, verb.length() - 1 );
            verb = lengthenVowel( verb );
            singEnd = "ëa";
        }
        
        if( sing )
            return verb + singEnd;
        else
            return verb + singEnd + "r";
    }
    
    public static String getPast( String stem )
    {
        String past;
        String end = end( stem );
        String penEnd = stem.substring( stem.length() - 2, stem.length() - 1 );
        
        if( end.equals("a") || penEnd.equals( "y" ) || end.equals( "r" ) || end.equals( "m" ) || end.equals( "n" ) )
        {
            past = stem + "n";
        }
        else if( end.equals( "l" ) )
        {
            past = stem + "l";
        }
        else if( end.equals( "p" ) )
        {
            past = stem.substring( 0, stem.length() - 1) + "mp";
        }
        else
        {
            past = stem.substring( 0, stem.length() - 1 ) + "n" + end;
        }
        return past + "ë";
    }
    
    public static String getFuture( String stem )
    {
        String future = stem;
        String end = end( stem );
        if( end.equals( "a" ) )
        {
            future = future.substring( 0, future.length() - 1 ) + "uva";
        }
        else
        {
            future += "uva";
        }
        
        return future;
    }
    
    @Override
    public String getAorist( boolean sing )
    {
        String aorist = toString();
        if( stemType.contains("P") && !sing )
        {
            aorist += "ir";
        }
        else if( stemType.contains( "P" ) )
        {
            aorist += "ë";
        }
        else if( !sing )
        {
            aorist += "r";
        }
        
        return aorist;
    }
    
    public String getPerfect( String stem )
    {
        String perfect = stem,
               augment = findVowel( perfect );
        
        int augmentIndex = perfect.indexOf( augment );
        
        if( augmentIndex == 0 )
            augment = "";
        String rest = perfect.substring( augmentIndex );
        if( findVowel( rest ) != null && perfect.indexOf( findVowel( rest ) ) == augmentIndex + 1 )
            
        
        if( stemType.contains( "P" ) )
        {
            perfect = augment + lengthenVowel( perfect );
        }
        else if( stemType.contains( "Y" ) )
        {
            perfect = augment + lengthenVowel( perfect ).substring( 0, perfect.length() - 2 );
        }
        else if( stemType.contains( "C" ) )
        {
            perfect = augment + perfect.substring( 0, perfect.length() - 1 );
        }
        else if( stemType.contains( "D" ) )
        {
            perfect = augment + perfect.substring( 0, perfect.length() - 1 );
        }
        else if( stemType.contains( "A" ) )
        {
            perfect = augment + lengthenVowel( perfect ).substring( 0, perfect.length() - 1 );
        }
        
        perfect += "ië";
        
        return perfect;
    }
    
    @Override
    public String getInfinitive()
    {
        String infinitive = toString();
        if( stemType.contains( "P" ) )
            infinitive += "ë";
        return infinitive;
    }
    
    /**
     * Identifies the stem vowel of the verb
     * 
     * @param v The verb whose stem vowel is to be identified
     * @return The stem vowel of the verb
     */
    private String findVowel( String v )
    {
        int index = v.length();
        int [] vowels = { v.indexOf("a"),
                          v.indexOf("e"),
                          v.indexOf("i"),
                          v.indexOf("o"),
                          v.indexOf("u") };
        
        int i, vowel = -1;
        for( i = 0; i < vowels.length; i++ )
        {
            int j = vowels[ i ];
            if( j < 0 ){}
            else if( i == 4 && v.indexOf( "q" ) == 0 )
                break;
            else if( j < index )
            {
                index = j;
                vowel = i;
            }
        }
        
        switch( vowel )
        {
            case 0:
                return "a";
            case 1:
                return "e";
            case 2:
                return "i";
            case 3:
                return "o";
            case 4:
                return "u";
            default:
                return null;
        }
    }
    
    /**
     * Lengthens the stem vowel of the Quenya verb
     * 
     * @param v The verb of which to lengthen the vowel
     * 
     * @return The verb with its newly lengthened vowel
     */
    private String lengthenVowel( String v )
    {
        if( stemType.contains( "D" ) )
            return v;
        
        String vowel = findVowel( v );
        
        switch( vowel )
        {
            case "a":
                return v.replaceFirst( "a", "á" );
            case "e":
                return v.replaceFirst( "e", "é" );
            case "i":
                return v.replaceFirst( "i", "í" );
            case "o":
                return v.replaceFirst( "o", "ó" );
            case "u":
                return v.replaceFirst( "u", "ú" );
            default:
                return v;
        }
    }
    
    @Override
    public String negativity( int tense, boolean sing )
    {
        String negative;
        switch( tense )
        {
            case 1: //Present continuous
                negative = "úma";
                break;
            case 2: //Past
                if( sing )
                    negative = "úmë";
                else
                    negative = "úme";
                break;
            case 3: //Future
                negative = "úva";
                break;
            case 4: //Aorist
                if( sing )
                    negative = "umë";
                else
                    negative = "umi";
                break;
            default:
                throw new IllegalArgumentException( "There are only 4 types of negativity right now." );
        }
        
        if( !sing )
            negative += "r";
        
        negative += " " + getInfinitive();
        
        return negative;
    }
    
    @Override
    public String getActiveParticiple()
    {
        if( stemType.equals( "P" ) )
            return toString() + "ala";
        return toString() + "la";
    }
    
    public static String end( String s )
    {
        return s.substring( s.length() - 1 );
    }
}
