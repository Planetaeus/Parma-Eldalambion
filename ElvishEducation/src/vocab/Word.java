/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocab;

/**
 * This object is simply a vessel to carry the String contents and int index of 
 * each word that is retrieved.
 * 
 * @author Michael
 */
public class Word
{
    private String word;
    private int index;
    
    public Word( String s, int id )
    {
        word = s;
        index = id;
    }
    
    public String getWord()
    {
        return word;
    }
    
    public int getIndex()
    {
        return index;
    }
}
