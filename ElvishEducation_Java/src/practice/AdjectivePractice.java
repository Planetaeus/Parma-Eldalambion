//package practice;
///**
// * Methods for practicing Adjective forms and usage.
// * 
// * @author Michael Taft Morris
// * @version 15.08.15
// */
//
//import gui.VocabFactory;
//import vocab.*;
//public class AdjectivePractice extends Practice
//{
//    
//    public static String [] adjectives()
//    {
//        return adjectives( (VocabNoun)VocabFactory.randomWord( 1 ), randomBoolean(), randomBoolean() );
//    }
//    
//    public static String [] adjectives( VocabNoun n, boolean sing, boolean q )
//    {
//        VocabAdjective a = n.getDescriptor();
//        boolean superlative = randomBoolean(),
//                definite = randomBoolean();
//        String english, quenya;
//        String [] p = articles( n, sing, definite );
//        english = p[ 1 ];
//        quenya = p[ 0 ];
//        
//        if( definite )
//        {
//            if( superlative )
//            {
//                p[ 1 ] = a.getSuperlative( false, sing );
//                p[ 0 ] = a.getSuperlative( true, sing );
//            }
//            else if( sing )
//            {
//                p[ 1 ] = a.getWord( false ).toString();
//                p[ 0 ] = a.getWord( true ).toString();
//            }
//            else
//            {
//                p[ 1 ] = a.getWord( false ).toString(); 
//                p[ 0 ] = a.getPlural();
//            }
//            english = english.substring( 0, 4 ) + p[ 1 ] + " " + english.substring( 4 );
//            quenya = quenya + " " + p[ 0 ];
//        }
//        else
//        {
//            if( superlative )
//            {
//                p[ 0 ] = a.getSuperlative( true, sing );
//                if( sing )
//                    english = "a most " + a.getWord( false ).toString() + " " + english.substring( 2 ).trim();
//                else
//                    english = a.getSuperlative( false, sing ) + " " + english;
//                quenya = quenya + " " + p[ 0 ];
//            }
//            else if( sing )
//            {
//                p[ 1 ] = a.getWord( false ).toString();
//                p[ 0 ] = a.getWord( true ).toString();
//                
//                if( ( p[ 1 ].substring(0, 1).equals("a") || p[ 1 ].substring(0, 1).equals("e") || p[ 1 ].substring(0, 1).equals("i") || p[ 1 ].substring(0, 1).equals("o") || p[ 1 ].substring(0, 1).equals("u") ) )
//                    p[ 1 ] = "an " + p[ 1 ];
//                else
//                    p[ 1 ] = "a " + p[ 1 ];
//                english = p[ 1 ] + " " + english.substring( 2 ).trim();
//                quenya = quenya + " " + p[ 0 ];
//            }
//            else
//            {
//                english = a.getWord( false ).toString() + " " + english; 
//                quenya = quenya + " " + a.getPlural();
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
