/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics.adjectives;

/**
 *
 * @author Michael
 */
public final class QAdjective extends Adjective
{
    private String plural, superlativePl;
    public QAdjective( String w, String t )
    {
        super( w, t );
        setUp();
    }
    
    @Override
    public void setUp()
    {
        plural();
        superlative();
        superlativePl();
    }
    
    /**
     * Method that sets the plural form of the adjective
     */
    private void plural()
    {
        plural = toString();
        int l = plural.length();
     
        switch( type() )
        {
            case "A":
                plural = plural.substring( 0, l - 1 ) + "ë";
                break;
            case "Ëa":
                plural = plural.substring( 0, l - 2 ) + "ië";
                break;
            case "Ë":
                plural = plural.substring( 0, l - 1 ) + "i";
                break;
            case "Consonant":
                plural = plural + "i";
                break;
            default:
                throw new IllegalArgumentException( "Bad type for " + toString() );
        }
    }

    @Override
    public void superlative()
    {
        String first = toString().substring( 0, 1 );
        if( first.equals( "p" ) )
            setSuperlative( "am" + toString() );
        else if( first.equals( "l" )
              || first.equals( "r" )
              || first.equals( "s" )
              || first.equals( "m" ) )
            setSuperlative( "a" + first + toString() );
        else
            setSuperlative( "an" + toString() );
    }
    
    private void superlativePl()
    {
        String first = plural.substring( 0, 1 );
        
        if( first.equals( "p" ) )
            superlativePl = "am" + plural;
        else if( first.equals( "l" )
              || first.equals( "r" )
              || first.equals( "s" )
              || first.equals( "m" ) )
            superlativePl = "a" + first + plural;
        else
            superlativePl = "an" + plural;
    }
    
    public String getPlural()
    {
        return plural;
    }
    
    public String getSuperlativePl()
    {
        return superlativePl;
    }
}
