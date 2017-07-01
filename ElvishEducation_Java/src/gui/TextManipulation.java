/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Map;
import javax.swing.DefaultListModel;
import sql.SQLAmbassador;

/**
 * This file exists to contain all of the methods and class paths required to 
 * read and modify the text files containing the program's vocabulary.
 * 
 * @author Michael
 * @version 16.04.02
 */
public class TextManipulation
{
    
    /**
     * This method goes through the necessary processes of adding an adjective
     * to the program's vocabulary as well as modifying the related nouns
     * already in the system.
     * 
     * @param qi The currently running instance of the Instructor GUI
     */
    public static void addAdjective( Instructor qi )
    {
        String eSing = qi.adjectiveESingBox.getText(), eAdverb = qi.adjectiveEAdverbBox.getText(),
               qSing = qi.adjectiveQSingBox.getText(), qPlural = qi.adjectiveQPluralBox.getText(),
               qAdverb = qi.adjectiveQAdverbBox.getText();
        
        String [] components = { eSing, eAdverb };
        
        SQLAmbassador.addWord( Index.E_ADJECTIVES_TABLE, Index.E_ADJECTIVES_COLUMNS, components );
        
        components = new String [] { qSing, qPlural, qAdverb };
        
        SQLAmbassador.addWord( Index.Q_ADJECTIVES_TABLE, Index.Q_ADJECTIVES_COLUMNS, components );
        
        int index = SQLAmbassador.findIndex( Index.E_ADJECTIVES_TABLE, "singular", eSing );
        int [] associates;
        
        //Nouns
        associates = qi.adjectiveNouns.getSelectedIndices();
        addAssociate( "Descriptor", associates, index );
        
        //Verbs
        associates = qi.adverbVerbs.getSelectedIndices();
        addAssociate( "Adverb", associates, index );
    }
    
    /**
     * This method goes through the necessary processes of adding a noun to the
     * program's vocabulary as well as modifying the related verbs, adjectives, 
     * and prepositions already in the system.
     * 
     * @param qi The currently running instance of the Instructor GUI
     */
    public static void addNoun( Instructor qi )
    {
        String eSing = qi.nounESingBox.getText(), ePlural = qi.nounEPluralBox.getText(),
               qStem = qi.nounQStemBox.getText(), qSing = qi.nounQSingBox.getText(),
               qDual = qi.nounQDualBox.getText(), qPlural = qi.nounQPluralBox.getText();
        
        String [] components = { eSing, ePlural };
        
        SQLAmbassador.addWord( Index.E_NOUNS_TABLE, Index.E_NOUNS_COLUMNS, components );
        
        components = new String [] { qStem, qSing, qDual, qPlural };
        
        SQLAmbassador.addWord( Index.Q_NOUNS_TABLE, Index.Q_NOUNS_COLUMNS, components );
        
        int index = SQLAmbassador.findIndex( Index.E_NOUNS_TABLE, "singular", eSing );
        int [] associates;
        
        //Actions
        associates = qi.nounActions.getSelectedIndices();
        addAssociate( "Subject", index, associates );
        
        //Adjectives
        associates = qi.nounAdjectives.getSelectedIndices();
        addAssociate( "Descriptor", index, associates );
        
        //Objectifying Actions
        associates = qi.nounObjected.getSelectedIndices();
        addAssociate( "Object", index, associates );
    }

    /**
     * This method goes through the necessary processes of adding a preposition to the
     * program's vocabulary as well as modifying the related verbs already in the system.
     * 
     * @param qi The currently running instance of the Instructor GUI
     */
    public static void addPreposition( Instructor qi )
    {
        String english = qi.prepEnglishBox.getText(), singular = qi.prepSingBox.getText(),
               dual = qi.prepDualBox.getText(), plural = qi.prepPluralBox.getText();
        
        String [] components = { english, singular, dual, plural };
        
        SQLAmbassador.addWord( Index.PREPOSITIONS_TABLE, Index.PREPOSITIONS_COLUMNS, components);
        
        //Subjects
        int[] associates = qi.prepVerbs.getSelectedIndices();
        int index = SQLAmbassador.findIndex( Index.PREPOSITIONS_TABLE, "english", english );
        
        addAssociate( "Preposition", associates, index );
    }

    /**
     * This method goes through the necessary processes of adding a verb to the
     * program's vocabulary as well as associating it with the proper subjects,
     * objects, and prepositions.
     * 
     * @param qi The currently running instance of the Instructor GUI
     */
    public static void addVerb( Instructor qi )
    {   
        //English
        String eInfinitive = qi.eInfinitiveBox.getText(), ePast = qi.ePastBox.getText(),
               ePerfect = qi.ePerfectBox.getText(), eAorist = qi.eAoristBox.getText(),
               eAorist3 = qi.eAoristAltBox.getText(), eActive = qi.eActiveBox.getText(),
               ePassive = qi.ePassiveBox.getText();
        
        String [] components = { eInfinitive, ePast, ePerfect, eAorist, eAorist3, eActive, ePassive };
        
        SQLAmbassador.addWord( Index.E_VERBS_TABLE, Index.E_VERBS_COLUMNS, components );
        
        //Quenya
        String qStem = qi.qStemBox.getText(), qPast = qi.qPastBox.getText(),
               qFuture = qi.qFutureBox.getText(), qPerfect = qi.qPerfectBox.getText(),
               qPresent = qi.qPresentBox.getText(), qAorist = qi.qAoristBox.getText(),
               qInfinitive = qi.qInfinitiveBox.getText(), qActive = qi.qActiveBox.getText(),
               qPassive = qi.qPassiveBox.getText(), qVerbal = qi.qVerbalBox.getText();
        
        components = new String [] { qStem, qPast, qFuture, qPerfect, qPresent, qAorist, qInfinitive, qActive, qPassive, qVerbal };
        
        SQLAmbassador.addWord( Index.Q_VERBS_TABLE, Index.Q_VERBS_COLUMNS, components );
        
        int[] associates;
        int index = SQLAmbassador.findIndex( Index.Q_VERBS_TABLE, "stem", qStem );
        
        //Subjects
        associates = qi.verbSubjects.getSelectedIndices();
        addAssociate( "Subject", associates, index );
        
        //Prepositions
        associates = qi.verbPreposition.getSelectedIndices();
        addAssociate( "Preposition", index, associates );
        
        //Adverbs
        associates = qi.verbAdverbs.getSelectedIndices();
        addAssociate( "Adverb", index, associates );
        
        //Objects
        associates = qi.verbObjects.getSelectedIndices();
        addAssociate( "Object", index, associates );
    }

    /**
     * Reads the first words from each line in a file in order to create a model
     * to be used by the JList components used in selecting related words
     * 
     * @param tableName
     * @param columnName
     * @return A DefaultListModel object containing the first word of each line in the file
     */
    public static DefaultListModel createModel( String tableName, String columnName )
    {
        Map wordList = SQLAmbassador.mapWords( tableName, columnName );
        
        return mapModel( wordList );
    }
    
    public static DefaultListModel mapModel( Map map )
    {
        DefaultListModel model = new DefaultListModel();
        
        if( map.size() > 0 )
        {
            for( int i = 0; i < map.size(); i++ )
            {
                model.add( i, map.get( i ) );
                
                System.out.println( i + " " + model.get( i ) );
            }
        }   
        else
        {
            model.add( 0, "Null" );
        }
        
        return model;
    }
    //For when the item described by index comes first in the association
    public static void addAssociate( String type, int index, int [] associates )
    {
        switch( type )
        {
            case "Subject":
                addAssociate( Index.SUBJECTS_TABLE, Index.SUBJECTS_COLUMNS, index, associates );
                break;
            case "Object":
                addAssociate( Index.OBJECTS_TABLE, Index.OBJECTS_COLUMNS, index, associates );
                break;
            case "Preposition":
                addAssociate( Index.INDIRECT_TABLE, Index.INDIRECT_COLUMNS, index, associates );
                break;
            case "Adverb":
                addAssociate( Index.ADVERBS_TABLE, Index.ADVERBS_COLUMNS, index, associates );
                break;
            case "Descriptor":
                addAssociate( Index.DESCRIPTORS_TABLE, Index.DESCRIPTORS_COLUMNS, index, associates );
                break;
            default:
                System.out.println( "Oh bother." );
                break;
        }
    }
    
    //For when the item described by index comes second in the association
    public static void addAssociate( String type, int [] associates, int index )
    {
        switch( type )
        {
            case "Subject":
                addAssociate( Index.SUBJECTS_TABLE, Index.SUBJECTS_COLUMNS, associates, index );
                break;
            case "Object":
                addAssociate( Index.OBJECTS_TABLE, Index.OBJECTS_COLUMNS, associates, index );
                break;
            case "Preposition":
                addAssociate( Index.INDIRECT_TABLE, Index.INDIRECT_COLUMNS, associates, index );
                break;
            case "Adverb":
                addAssociate( Index.ADVERBS_TABLE, Index.ADVERBS_COLUMNS, associates, index );
                break;
            case "Descriptor":
                addAssociate( Index.DESCRIPTORS_TABLE, Index.DESCRIPTORS_COLUMNS, associates, index );
                break;
            default:
                System.out.println( "Oh bother." );
                break;
        }
    }
    
    public static void addAssociate( String tableName, String columnName, int [] associates, int index )
    {
        int [] indices;
        for( int associate: associates )
        {
            indices = new int [] { associate, index };
            SQLAmbassador.addAssociation( tableName, columnName, indices );
        }
    }
    
    public static void addAssociate( String tableName, String columnName, int index, int [] associates )
    {
        int [] indices;
        for( int associate: associates )
        {
            indices = new int [] { index, associate };
            SQLAmbassador.addAssociation( tableName, columnName, indices );
        }
    }
}
