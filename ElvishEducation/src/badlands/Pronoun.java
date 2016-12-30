/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badlands;

import basics.Word;

/**
 *
 * @author Michael
 */
public class Pronoun extends Word
{
    private final String asObject;
    
    public Pronoun( String sub, String obj)
    {
        super( sub );
        asObject = obj;
    }
    
    public String object()
    {
        return asObject;
    }
}
