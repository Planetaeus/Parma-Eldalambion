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
public final class EAdjective extends Adjective
{
    public EAdjective( String w, String t )
    {
        super( w, t );
        setUp();
    }
    
    @Override
    public void setUp()
    {
        superlative();
    }
    
    @Override
    public void superlative()
    {
        switch( type() )
        {
            case "Most":
                setSuperlative( "most " + toString() );
                break;
            case "-est":
                setSuperlative( toString() + "est" );
                break;
            case "-st":
                setSuperlative( toString() + "st" );
                break;
            case "-iest":
                setSuperlative( toString().substring( 0, toString().length() - 1 ) + "iest" );
                break;
            case "-_est":
                setSuperlative( toString() + toString().substring( toString().length() - 1 ) + "est" );
                break;
            default:
                throw new IllegalArgumentException( "Bad type for " + toString() );
        }
    }
}
