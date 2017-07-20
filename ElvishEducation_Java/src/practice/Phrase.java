/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author galin
 */
public class Phrase {
    
    private String prompt;
    private String answer;
    
    public Phrase( String p, String a )
    {
        prompt = p.trim();
        answer = a.trim();
    }
    
    public String prompt()
    {
        return prompt;
    }
    
    public boolean verify( String guess )
    {
        guess = guess.trim();
        return answer.equalsIgnoreCase( guess );
    }
}
