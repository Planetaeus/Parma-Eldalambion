
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**package badlands;

import gui.VocabFactory;
import vocab.Vocab;
import vocab.VocabVerb;

/**
 *
 * @author Michael
 */
/**public class VocabPronoun extends Vocab
{   
    private final int [] verbs;
    private final int person;
    private final boolean singular;
    
    public VocabPronoun( Pronoun e, Pronoun q, int p, boolean sing, int [] v )
    {
        super( e, q );
        person = p;
        singular = sing;
        verbs = v;
    }
    
    public String [] pronounify( int tense, int verb )
    {
        String e = getWord( false ).toString(), q = getWord( true ).toString();
        VocabVerb v = VocabFactory.makeVerb( verb );
        
        String [] p = v.getVerb( tense, singular, ( person == 3 ) );
        
        if( person == 1 && singular && tense == 1 )
            p[ 1 ] = "am" + p[ 1 ].substring( 3 );
        
        e = e + " " + p[ 1 ];
        
        if( tense == 4 )
        {
            q = p[ 0 ].substring( 0, p[ 0 ].length() - 1) + "i" + q;
        }
        else if( p[ 0 ].substring( p[ 0 ].length() - 1 ).equals( "ë" ) )
        {
            q = p[ 0 ].substring( 0, p[ 0 ].length() - 1) + "e" + q;
        }
        else
        {
            q = p[ 0 ] + q;
        }
        
        
        
        return new String [] { q, e };
    }
    
    public String [] objectify( String [] s )
    {
        String q = s[ 0 ];
        if( q.substring( q.length() - 1 ).equals( "ë" ) )
            s[ 0 ] = q.substring( 0, q.length() - 1 ) + "e" + ((Pronoun)getWord( true )).object();
        else
            s[ 0 ] = q + ((Pronoun)getWord( true )).object();
        
        s[ 1 ] = s[ 1 ] + " " + ((Pronoun)getWord( false )).object();
        return s;
    }
    
    public int getVerb()
    {
        return (int)( Math.random() * verbs.length );
    }
}
*/