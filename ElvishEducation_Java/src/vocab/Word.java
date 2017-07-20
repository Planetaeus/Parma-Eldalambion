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
    private String english, quenya;
    private final int index;
    
    public Word( String e, String q, int id )
    {
        english = e;
        quenya = q;
        index = id;
    }
    
    public String getEnglish()
    {
        return english;
    }
    
    public String getQuenya()
    {
        return quenya;
    }
    
    public int getIndex()
    {
        return index;
    }
    
    public void setEnglish( String e )
    {
        english = e;
    }
    
    public void setQuenya( String q )
    {
        quenya = q;
    }
}