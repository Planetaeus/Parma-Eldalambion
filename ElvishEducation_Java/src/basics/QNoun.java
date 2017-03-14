/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

/**
 *
 * @author Michael
 */
public class QNoun extends Word
{
    private final String stem;
    
    public QNoun( String sing, String s )
    {
        super( sing );
        stem = s.substring( 0, s.indexOf( '-' ));
    }
    
    public QNoun( String sing )
    {
        super( sing );
        stem = sing;
    }
    
    public String getPlural()
    {
        String end = stem.substring( stem.length() - 1 );
        String plural = stem;
        if( end.contains( "a" )
                || end.contains( "i" )
                || end.contains( "o" )
                || end.contains( "u" ) )
        {
            plural += "r";
        }
        else if( end.contains( "e" ) )
        {
            if( stem.substring( stem.length() - 2 ).contains( "i" ) )
                    plural += "r";
            else
                plural = plural.substring( 0, plural.length() - 1 ) + "i";
        }
        else
            plural += "i";
        return plural;
    }
    
    public String getGenitive( boolean sing )
    {
        String genitive = stem;
        if( sing )
        {
            String end = stem.substring( stem.length() - 1 );
            if( end.contains( "a" ) )
                genitive = genitive.substring( 0, genitive.length() - 1 ) + "o";
            else if( !end.contains( "o" ) )
                genitive += "o";
        }
        else
        {
            genitive = getPlural() + "on";
        }
        return genitive;
    }
}
