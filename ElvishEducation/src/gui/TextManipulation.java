/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
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
    //Addresses of the vocabulary text files
    public static final String E_ADJECTIVES_TABLE = "English_Adjectives";
    public static final String E_ADJECTIVES_COLUMNS = "singular, adverb";
    
    public static final String Q_ADJECTIVES_TABLE = "Quenya_Adjectives";
    public static final String Q_ADJECTIVES_COLUMNS = "singular, plural, adverb";
    
    public static final String E_NOUNS_TABLE = "English_Nouns";
    public static final String E_NOUNS_COLUMNS = "singular, plural";
    
    public static final String Q_NOUNS_TABLE = "Quenya_Nouns";
    public static final String Q_NOUNS_COLUMNS = "stem, singular, dual, plural";
    
    public static final String E_VERBS_TABLE = "English_Verbs";
    public static final String E_VERBS_COLUMNS = "infinitive, past, perfect, aorist, aorist_third, active_participle, passive_participle";
    
    public static final String Q_VERBS_TABLE = "Quenya_Verbs";
    public static final String Q_VERBS_COLUMNS = "stem, present_tense, past_tense, future_tense, aorist, perfect, infinitive, active_participle, passive_participle, gerund";
    
    public static final String CONJUNCTIONS_TABLE = "Conjunctions";
    public static final String CONJUNCTIONS_COLUMNS = "english, quenya, type";
    
    public static final String PREPOSITIONS_TABLE = "Prepositions";
    public static final String PREPOSITIONS_COLUMNS = "english, quenya_singular, quenya_dual, quenya_plural, quenya_independent, quenya_type";
    
    public static final String SUBJECTS_TABLE = "Subject_Actions";
    public static final String SUBJECTS_COLUMNS = "subject_id, action_id";
    
    public static final String DESCRIPTORS_TABLE = "Noun_Adjectives";
    public static final String DESCRIPTORS_COLUMNS = "noun_id, adjective_id";
    
    public static final String OBJECTS_TABLE = "Action_Objects";
    public static final String OBJECTS_COLUMNS = "action_id, object_id";
    
    public static final String INDIRECT_TABLE = "Action_Prepositions";
    public static final String INDIRECT_COLUMNS = "action_id, preposition_id";
    
    public static final String ADVERBS_TABLE = "Action_Adverbs";
    public static final String ADVERBS_COLUMNS = "action_id, adverb_id";
    
    //Scanner to read the text files
    private static Scanner lector;
    //PrintWriter to modify text files
    private static PrintWriter author;
    
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
     * This method goes through the necessary processes of adding a verb to the
     * program's vocabulary as well as associating it with the proper subjects,
     * objects, and prepositions.
     * 
     * @param qi The currently running instance of the Instructor GUI
     */
    public static void addVerb( Instructor qi )
    {   
        //English
        String eInfinitive = qi.eInfinitiveBox.getText(); String ePast = qi.ePastBox.getText(); String ePerfect = qi.ePerfectBox.getText(); 
        String eAorist = qi.eAoristBox.getText(); String eAorist3 = qi.eAoristAltBox.getText(); String eActive = qi.eActiveBox.getText();
        String ePassive = qi.ePassiveBox.getText();
        
        String [] components = { eInfinitive, ePast, ePerfect, eAorist, eAorist3, eActive, ePassive };
        
        SQLAmbassador.addWord( E_VERBS_TABLE, E_VERBS_COLUMNS, components);
        
        //Quenya
        String qStem = qi.qStemBox.getText(); String qPast = qi.qPastBox.getText(); String qFuture = qi.qFutureBox.getText();
        String qPerfect = qi.qPerfectBox.getText(); String qPresent = qi.qPresentBox.getText(); String qAorist = qi.qAoristBox.getText();
        String qInfinitive = qi.qInfinitiveBox.getText(); String qActive = qi.qActiveBox.getText(); String qPassive = qi.qPassiveBox.getText();
        String qVerbal = qi.qVerbalBox.getText();
        
        components = new String [] { qStem, qPast, qFuture, qPerfect, qPresent, qAorist, qInfinitive, qActive, qPassive, qVerbal };
        
        SQLAmbassador.addWord( Q_VERBS_TABLE, Q_VERBS_COLUMNS, components);
        
        //Subjects
        int[] associates = qi.subjectList.getSelectedIndices();
        int index = SQLAmbassador.findIndex( Q_VERBS_TABLE, "stem", qStem );
        int [] indices;
        for( int i = 0; i < associates.length; i++)
        {
            indices = new int [] { associates[ i ], index };
            SQLAmbassador.addAssociation( SUBJECTS_TABLE, SUBJECTS_COLUMNS, indices );
        }
        
        //Prepositions
        associates = qi.prepositionList.getSelectedIndices();
        for( int i = 0; i < associates.length; i++)
        {
            indices = new int [] { index, associates[ i ] };
            SQLAmbassador.addAssociation( INDIRECT_TABLE, INDIRECT_COLUMNS, indices );
        }
        
        //Adverbs
        associates = qi.adverbList.getSelectedIndices();
        for( int i = 0; i < associates.length; i++ )
        {
            indices = new int [] { index, associates[ i ] };
            SQLAmbassador.addAssociation( ADVERBS_TABLE, ADVERBS_COLUMNS, indices);
        }
        
        //Objects
        associates = qi.objectList.getSelectedIndices();
        for( int i = 0; i < associates.length; i++ )
        {
            indices = new int [] { index, associates[ i ] };
            SQLAmbassador.addAssociation( OBJECTS_TABLE, OBJECTS_TABLE, indices);
        }
    }

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
     * This method goes through the necessary processes of adding a preposition to the
     * program's vocabulary as well as modifying the related verbs already in the system.
     * 
     * @param qi The currently running instance of the Instructor GUI
     */
    public static void addPreposition( Instructor qi )
    {
        
    }

    /**
     * Reads the first words from each line in a file in order to create a model
     * to be used by the JList components used in selecting related words
     * 
     * @param source The name of the file to be read
     * @return A DefaultListModel object containing the first word of each line in the file
     */
    public static DefaultListModel createModel( String source )
    {
        DefaultListModel model = new DefaultListModel();
        try
        {
            lector = new Scanner(new File(source));
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (lector.hasNextLine())
        {
            lector.next();
            String word = lector.next();
            model.addElement(word.substring(0, word.length() - 1));
            if( lector.hasNextLine() )
                lector.nextLine();
        }
        lector.close();
        return model;
    }
    
}
