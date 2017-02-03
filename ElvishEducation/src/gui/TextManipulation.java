/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        int [] indices;
        if( associates.length > 0 )
        {
            for( int i = 0; i < associates.length; i++)
            {
                indices = new int [] { associates[ i ], index };
                SQLAmbassador.addAssociation(Index.INDIRECT_TABLE, Index.INDIRECT_COLUMNS, indices );
            }
        }
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
        
        //Subjects
        int[] associates = qi.verbSubjects.getSelectedIndices();
        int index = SQLAmbassador.findIndex( Index.Q_VERBS_TABLE, "stem", qStem );
        int [] indices;
        if( associates.length > 0 )
        {
            for( int i = 0; i < associates.length; i++)
            {
                indices = new int [] { associates[ i ], index };
                SQLAmbassador.addAssociation(Index.SUBJECTS_TABLE, Index.SUBJECTS_COLUMNS, indices );
            }
        }
        
        //Prepositions
        associates = qi.verbPreposition.getSelectedIndices();
        if( associates.length > 0 )
        {
            for( int i = 0; i < associates.length; i++)
            {
                indices = new int [] { index, associates[ i ] };
                SQLAmbassador.addAssociation(Index.INDIRECT_TABLE, Index.INDIRECT_COLUMNS, indices );
            }
        }
        
        //Adverbs
        associates = qi.verbAdverbs.getSelectedIndices();
        if( associates.length > 0 )
        {
            for( int i = 0; i < associates.length; i++ )
            {
                indices = new int [] { index, associates[ i ] };
                SQLAmbassador.addAssociation(Index.ADVERBS_TABLE, Index.ADVERBS_COLUMNS, indices);
            }
        }
        
        //Objects
        associates = qi.verbObjects.getSelectedIndices();
        if( associates.length > 0 )
        {
            for( int i = 0; i < associates.length; i++ )
            {
                indices = new int [] { index, associates[ i ] };
                SQLAmbassador.addAssociation(Index.OBJECTS_TABLE, Index.OBJECTS_COLUMNS, indices);
            }
        }
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
        DefaultListModel model = new DefaultListModel();
        
        Map wordList = SQLAmbassador.mapWords( tableName, columnName );
        
        if( wordList.size() > 0 )
        {
            for( int i = 0; i < wordList.size(); i++ )
            {
                model.add( i, wordList.get( i ) );
                
                System.out.println( i + " " + model.get( i ) );
            }
        }   
        else
        {
            model.add( 0, "Null" );
        }
        
        return model;
    }
    
}
