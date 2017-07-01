///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package gui;
//
//import basics.ENoun;
//import basics.QNoun;
//import basics.Word;
//import basics.adjectives.EAdjective;
//import basics.adjectives.QAdjective;
//import basics.verbs.EVerb;
//import basics.verbs.QVerb;
//import java.util.Scanner;
//import vocab.Preposition;
//import vocab.Vocab;
//import vocab.VocabAdjective;
//import vocab.VocabNoun;
//import vocab.VocabVerb;
//
///**
// *
// * @author Michael
// */
//public class VocabFactory
//{
//    private static Scanner lector;
//    
//    public static Vocab randomWord(int type)
//    {
//        int index;
//        double rand = Math.random();
//        switch (type)
//        {
//            case 1:
//                index = (int) (rand * TextManipulation.getNumber("Noun"));
//                return makeNoun( index );
//            case 2:
//                index = (int) (rand * TextManipulation.getNumber("Verb"));
//                return makeVerb( index );
//            case 3:
//                index = (int) (rand * TextManipulation.getNumber("Adjective"));
//                return makeAdjective( index );
//            case 4:
//                index = (int) (rand * TextManipulation.getNumber("Preposition"));
//                return makePreposition( index );
//            case 5:
//                index = (int) (rand * TextManipulation.getNumber("All"));
//                
//                if( index < TextManipulation.getNumber( "Noun" ) )
//                    return makeNoun( index );
//                index -= TextManipulation.getNumber( "Noun" );
//                
//                if( index < TextManipulation.getNumber( "Verb" ) )
//                    return makeVerb( index );
//                index -= TextManipulation.getNumber( "Verb" );
//                
//                if( index < TextManipulation.getNumber( "Adjective" ) )
//                    return makeAdjective( index );
//                index -= TextManipulation.getNumber( "Adjective" );
//                
//                return makePreposition( index );
//            default:
//                throw new IllegalArgumentException("randomWord() input was invalid");
//        }
//    }
//
//    public static Vocab randomWord()
//    {
//        return randomWord(5);
//    }
//
//    private static String[] breakCluster(String cluster)
//    {
//        String[] result = new String[2];
//        result[0] = cluster.substring( 1, cluster.indexOf(','));
//        result[1] = cluster.substring(cluster.indexOf(',') + 1, cluster.length() - 1);
//        return result;
//    }
//
//    public static VocabVerb makeVerb(int index )
//    {
//        String word,
//                aorist,
//                presentParticiple,
//                past,
//                perfect,
//                stem,
//                stemType;
//        EVerb ev;
//        QVerb qv;
//        int[] objects, prepositions;
//        boolean isFunky = false;
//        
//        String line = TextManipulation.getLine(index, TextManipulation.ENGLISH_VERBS);
//        lector = new Scanner(line);
//        lector.next();
//        
//        word = lector.next(); word = word.substring(0, word.length() - 1);
//        if (word.contains("{"))
//        {
//            String[] broken = breakCluster(word);
//            word = broken[0];
//            aorist = broken[1];
//            isFunky = true;
//        }
//        else
//        {
//            aorist = word;
//        }
//        
//        presentParticiple = lector.next(); presentParticiple = presentParticiple.substring(0, presentParticiple.length() - 1);
//        
//        past = lector.next();
//        if (past.contains("{"))
//        {
//            String[] broken = breakCluster(past);
//            past = broken[0];
//            perfect = broken[1];
//        }
//        else
//        {
//            perfect = past;
//        }
//        
//        ev = new EVerb(word, aorist, isFunky, presentParticiple, past, perfect);
//        lector.close();
//        
//        line = TextManipulation.getLine(index, TextManipulation.QUENYA_VERBS);
//        lector = new Scanner(line); lector.next();
//        stem = lector.next(); stem = stem.substring(0, stem.length() - 1);
//        
//        stemType = lector.nextLine();
//        lector.close();
//        
//        qv = new QVerb(stem, stemType);
//        
//        prepositions = readArray(index, TextManipulation.ASSOCIATED_ACTIONS);
//        objects = readArray(index, TextManipulation.ASSOCIATED_OBJECTS);
//        
//        return new VocabVerb(ev, qv, objects, prepositions);
//    }
//
//    public static VocabNoun makeNoun( int index )
//    {
//        String eSingular,
//                ePlural,
//                qSingular,
//                qStem;
//        int [] adjectives, verbs;
//        ENoun en;
//        QNoun qn;
//        
//        String line = TextManipulation.getLine( index, TextManipulation.ENGLISH_NOUNS );
//        lector = new Scanner( line ); lector.next();
//        eSingular = lector.next(); eSingular = eSingular.substring( 0, eSingular.length() - 1 );
//        ePlural = lector.next();
//        lector.close();
//        
//        en = new ENoun( eSingular, ePlural );
//        
//        line = TextManipulation.getLine( index, TextManipulation.QUENYA_NOUNS );
//        lector = new Scanner( line ); lector.next();
//        qSingular = lector.next();
//        if( lector.hasNext() )
//        {
//            qSingular = qSingular.substring( 0, qSingular.length() - 1 );
//            qn = new QNoun( qSingular, lector.next() );
//        }
//        else
//            qn = new QNoun( qSingular );
//        
//        adjectives = readArray( index, TextManipulation.ASSOCIATED_ADJECTIVES );
//        verbs = readArray( index, TextManipulation.ASSOCIATED_VERBS );
//        
//        return new VocabNoun( en, qn, adjectives, verbs );
//    }
//    
//    public static VocabAdjective makeAdjective( int index )
//    {
//        String eAdj,
//                superType,
//                qAdj,
//                qEnding;
//        EAdjective ea;
//        QAdjective qa;
//        
//        String line = TextManipulation.getLine( index, TextManipulation.ENGLISH_ADJECTIVES );
//        lector = new Scanner( line ); lector.next();
//        eAdj = lector.next(); eAdj = eAdj.substring( 0, eAdj.length() - 1 );
//        superType = lector.next();
//        lector.close();
//        
//        ea = new EAdjective( eAdj, superType );
//        
//        line = TextManipulation.getLine( index, TextManipulation.QUENYA_ADJECTIVES );
//        lector = new Scanner( line ); lector.next();
//        qAdj = lector.next(); qAdj = qAdj.substring( 0, qAdj.length() - 1 );
//        qEnding = lector.next();
//        lector.close();
//        
//        qa = new QAdjective( qAdj, qEnding );
//        
//        return new VocabAdjective( ea, qa );
//    }
//    
//    public static Preposition makePreposition( int index )
//    {
//        String ePrep, qPrep, nounType;
//        int [] locations;
//        Word e, q;
//        
//        String line = TextManipulation.getLine( index, TextManipulation.ENGLISH_PREPOSITIONS );
//        lector = new Scanner( line ); lector.next();
//        ePrep = lector.next();
//        e = new Word( ePrep );
//        lector.close();
//        
//        line = TextManipulation.getLine( index, TextManipulation.QUENYA_PREPOSITIONS );
//        lector = new Scanner( line ); lector.next();
//        qPrep = lector.next(); qPrep = qPrep.substring( 0, qPrep.length() - 1 );
//        q = new Word( qPrep );
//        nounType = lector.next();
//        lector.close();
//        
//        locations = readArray( index, TextManipulation.ASSOCIATED_LOCATIONS );
//        
//        return new Preposition( e, q, locations, nounType );
//    }
//    
//    private static int[] readArray(int index, String source)
//    {
//        String line = TextManipulation.getLine(index, source);
//        lector = new Scanner(line);
//        lector.next();
//        
//        String num = lector.next();
//        int length = Integer.parseInt(num.substring(0, num.indexOf(':')));
//        if( length != 0 )
//        {
//            int[] array = new int[length];
//            int i = 0;
//            while( lector.hasNext() && i < length )
//            {
//                num = lector.next();
//                array[ i ] = Integer.parseInt( num.substring( 0, num.indexOf( "," ) ) );
//                i++;
//            }
//            lector.close();
//            return array;
//        }
//        return new int[ 0 ];
//    }
//    
//}
