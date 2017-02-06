/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import sql.SQLAmbassador;

/**
 * This class is just a place to keep all of the table and column names for
 * everything in the SQL database.
 * @author Michael
 */
public class Index
{
    //Addresses of the vocabulary text files
    public static final String E_ADJECTIVES_TABLE = "English_Adjectives";
    public static final String E_ADJECTIVES_COLUMNS = "singular, adverb";
    
    public static final String E_NOUNS_TABLE = "English_Nouns";
    public static final String E_NOUNS_COLUMNS = "singular, plural";
    
    public static final String E_VERBS_TABLE = "English_Verbs";
    public static final String E_VERBS_COLUMNS = "infinitive, past, perfect, aorist, aorist_third, active_participle, passive_participle";
    
    public static final String Q_ADJECTIVES_TABLE = "Quenya_Adjectives";
    public static final String Q_ADJECTIVES_COLUMNS = "singular, plural, adverb";
    
    public static final String Q_NOUNS_TABLE = "Quenya_Nouns";
    public static final String Q_NOUNS_COLUMNS = "stem, singular, dual, plural";
    
    public static final String Q_VERBS_TABLE = "Quenya_Verbs";
    public static final String Q_VERBS_COLUMNS = "stem, present_tense, past_tense, future_tense, aorist, perfect, infinitive, active_participle, passive_participle, gerund";
    
    public static final String ADVERBS_TABLE = "Action_Adverbs";
    public static final String ADVERBS_COLUMNS = "action_id, adverb_id";
    
    public static final String CONJUNCTIONS_TABLE = "Conjunctions";
    public static final String CONJUNCTIONS_COLUMNS = "english, quenya, type";
    
    public static final String DESCRIPTORS_TABLE = "Noun_Adjectives";
    public static final String DESCRIPTORS_COLUMNS = "noun_id, adjective_id";
    
    public static final String INDIRECT_TABLE = "Action_Prepositions";
    public static final String INDIRECT_COLUMNS = "action_id, preposition_id";
    
    public static final String OBJECTS_TABLE = "Action_Objects";
    public static final String OBJECTS_COLUMNS = "action_id, object_id";
    
    public static final String PREPOSITIONS_TABLE = "Prepositions";
    public static final String PREPOSITIONS_COLUMNS = "english, quenya_singular, quenya_dual, quenya_plural";
    
    public static final String SUBJECTS_TABLE = "Subject_Actions";
    public static final String SUBJECTS_COLUMNS = "subject_id, action_id";
}
