//package practice;
///**
// * Methods and menus for practicing with Verbs.
// * 
// * @author Michael Taft Morris
// * @version 15.09.27
// */
//import gui.VocabFactory;
//import vocab.*;
//
//public class VerbPractice extends Practice
//{
//
//    /**
//     * Returns a random verb with random plurality in the desired tense
//     * 
//     * @param type The desired tense of conjugation for the verbs.
//     * @return A String array containing the prompt and the correct response.
//     */
//    public static String [] verbs( int type )
//    {
//        VocabVerb v = (VocabVerb)VocabFactory.randomWord( 2 );
//        
//        boolean sing = randomBoolean();
//        
//        return v.getVerb( type, sing, true );
//    }
//    
//    /**
//     * Returns a random negative verb with random plurality in the desired tense
//     * 
//     * @param type The tense for the verb
//     * @return A String array containing the prompt and the correct response
//     */
//    public static String [] negativeVerbs( int type )
//    {
//        VocabVerb v = (VocabVerb)VocabFactory.randomWord( 2 );
//        
//        boolean sing = randomBoolean();
//        
//        return v.getNegative( type, sing, true );
//    }
//    
//    public static String [] activeParticiples( VocabNoun n, boolean q )
//    {
//        VocabVerb v = n.getAction();
//        boolean definite = randomBoolean(),
//                sing = randomBoolean();
//        String english, quenya;
//        String [] p = articles( n, sing, definite );
//        english = p[ 1 ];
//        quenya = p[ 0 ];
//        p = v.getActiveParticiple();
//        
//        if( definite )
//        {
//            english = english.substring( 0, 4 ) + p[ 1 ] + " " + english.substring( 4 );
//            quenya = quenya + " " + p[ 0 ];
//        }
//        else
//        {
//            if( sing )
//            {
//                if( ( p[ 1 ].substring(0, 1).equals("a") || p[ 1 ].substring(0, 1).equals("e") || p[ 1 ].substring(0, 1).equals("i") || p[ 1 ].substring(0, 1).equals("o") || p[ 1 ].substring(0, 1).equals("u") ) )
//                    p[ 1 ] = "an " + p[ 1 ];
//                else
//                    p[ 1 ] = "a " + p[ 1 ];
//                english = p[ 1 ] + " " + english.substring( 2 ).trim();
//                quenya = quenya + " " + p[ 0 ];
//            }
//            else
//            {
//                english = p[ 1 ] + " " + english; 
//                quenya = quenya + " " + p[ 0 ];
//            }
//            
//        }
//        
//        if( q )
//            return new String [] { quenya, english };
//        else
//            return new String [] { english, quenya };
//    }
//}
