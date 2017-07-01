//package vocab;
//
///**
// * An Adjective-based Vocab object
// * 
// * @author Michael Taft Morris
// * @version 15.05.17
// */
//
//import basics.adjectives.*;
//public class VocabAdjective extends Vocab
//{
//    /**
//     * Constructor for an Adjective-based Vocab object
//     * 
//     * @param e Adjective object for the word's representation in English
//     * @param q Adjective object for the word's representation in Quenya
//     */
//    public VocabAdjective( Adjective e, Adjective q )
//    {
//        super( e, q );
//        
//    }
//    
//    /**
//     * Gets the adjective's plural form in Quenya
//     * 
//     * @return The String value of the adjective's plural form in Quenya
//     */
//    public String getPlural()
//    {
//        return ((QAdjective)getWord( true )).getPlural();
//    }
//    
//    /**
//     * Gets the adjective's superlative form in the desired number and language
//     * 
//     * @param q A boolean value representing the desired language; true : Quenya, false : English.
//     * @param sing A boolean value representing the desired number; true : singular, false : plural.
//     * 
//     * @return The String value of the adjective's plural form in the desired number and language.
//     */
//    public String getSuperlative( boolean q, boolean sing )
//    {
//        if( q && !sing )
//            return ((QAdjective)getWord(q)).getSuperlativePl();
//        return ((Adjective)getWord(q)).getSuperlative();
//    }
//}
