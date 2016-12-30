/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocab;

import basics.Word;
import gui.VocabFactory;
import practice.AdjectivePractice;
import practice.Practice;

/**
 *
 * @author Michael
 */
public class Preposition extends Vocab
{
    private final int [] nouns;
    private final String nounType;
    
    public Preposition( Word q, Word e, int [] n, String t )
    {
        super( q, e );
        nouns = n;
        nounType = t;
    }
    
    public String [] indObject()
    {
        String e, q;
        VocabNoun n = (VocabNoun) VocabFactory.makeNoun( nouns[ (int)( Math.random() * nouns.length ) ] );
        
        if( Practice.randomBoolean() )
        {
            String [] a = AdjectivePractice.adjectives(n, false, true );
            e = getWord( false ) + " " + a[ 1 ];
            q = getWord( true ) + " " + a[ 0 ];
        }
        else
        {
            String [] a = Practice.articles(n, false, true );
            e = getWord( false ) + " " + a[ 1 ];
            q = getWord( true ) + " " + a[ 0 ];
        }
        
        
        return new String [] { q, e };
    }
}
