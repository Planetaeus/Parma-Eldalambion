/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import gui.Index;
import sql.SQLAmbassador;
import vocab.Word;

/**
 *
 * @author galin
 */
public class NounPractice {
    
    /*
        Nominative
        Randomly or specifically chooses a noun to use in the nominative form
    */
    public static Word nominative( int num )
    {
        String english = "";
        String eColumn = "";
        String qColumn = "";
        
        Word nom;
        
        if( num == 1 )
        {
            eColumn = "singular";
            qColumn = "singular";
        }   
        else
        {
            eColumn = "plural";
            qColumn = "plural";
            
            if( num == 2 )
            {
                qColumn = "dual";
                english += "two";
            }
        }
        
        nom = SQLAmbassador.getRandomWord( Index.E_NOUNS_TABLE, eColumn, Index.Q_NOUNS_TABLE, qColumn );
        nom.setEnglish( english + " " + nom.getEnglish() );
        
        return nom;
    }
    
    /*
        Genitive
    */
    
    
    /*
        Possessive
    */
    
    
    /*
        Dative
    */
    
    
    /*
        Allative
    */
    
    
    /*
        Ablative
    */
    
    
    /*
        Locative
    */
    
    
    /*
        Instrumental
    */
    
}
