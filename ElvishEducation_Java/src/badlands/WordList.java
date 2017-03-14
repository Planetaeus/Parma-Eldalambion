package badlands;
 
/**
 * Contains all of the vocabulary words for the section,
 * as well as a method to find a random word.
 * 
 * @author Michael Taft Morris 
 * @version 15.08.15
 */

/**
public class WordList
{
    public static final int NOUN_LENGTH = 10,
                            ADJECTIVES_LENGTH = 10,
                            PREPOSITIONS_LENGTH = 10,
                            VERBS_LENGTH = 10;
    public static final Preposition [] PREPOSITIONS =  { new Preposition( new Word( "under" ), new Word( "nu" ), new int [] { 6, 7, 12, 13, 17, 19, 21, 23 } ),
                                                         new Preposition( new Word( "over" ), new Word( "or" ), new int [] { 1, 2, 7, 8, 21, 23 } ),
                                                         new Preposition( new Word( "between" ), new Word( "imbë" ), new int [] { 0, 2, 3, 4, 6, 7, 8, 11, 13, 16, 18, 21, 23, 24, 25, 27, 30, 31} ),
                                                         new Preposition( new Word( "into" ), new Word( "mir" ), new int [] { 0, 2, 7, 13, 16, 17, 21, 23, 32 } ),
                                                         new Preposition( new Word( "through" ), new Word( "ter" ), new int [] { 0, 2, 6, 7, 13, 16, 21, 23, 32 } )};
    
    public static final VocabAdjective [] ADJECTIVES = { new VocabAdjective( new EAdjective( "beautiful", "most" ), new QAdjective( "vanya", "a" ) ), //0
                                                         new VocabAdjective( new EAdjective( "black", "est" ), new QAdjective( "morë", "ë" ) ), //1
                                                         new VocabAdjective( new EAdjective( "bright", "est" ), new QAdjective( "calima", "a" ) ), //2
                                                         new VocabAdjective( new EAdjective( "dead", "est" ), new QAdjective( "firin", "con" ) ), //3
                                                         new VocabAdjective( new EAdjective( "evil", "est" ), new QAdjective( "úmëa", "ëa" ) ), //4
                                                         new VocabAdjective( new EAdjective( "great", "est" ), new QAdjective( "alta", "a" ) ), //5
                                                         new VocabAdjective( new EAdjective( "mighty", "most" ), new QAdjective( "taura", "a" ) ), //6
                                                         new VocabAdjective( new EAdjective( "red", "most" ), new QAdjective( "carnë", "ë" ) ), //7
                                                         new VocabAdjective( new EAdjective( "white", "most" ), new QAdjective( "fána", "a" ) ), //8
                                                         new VocabAdjective( new EAdjective( "wise", "most" ), new QAdjective( "saila", "a" ) ), //9
                                                         new VocabAdjective( new EAdjective( "thick", "est" ), new QAdjective( "tiuca", "a" ) ) }; //10
    
    public static final VocabNoun [] NOUNS = { new VocabNoun( new ENoun( "arm", "arms" ), new ENoun( "ranco", "rancur" ), //0
                                                              new int [] { 0, 1, 3, 4, 5, 6, 7, 8, 10 },
                                                              new int []{ 8, 11, 17, 18, 20, 21, 22, 23, 25, 29, 30 } ),
                                               new VocabNoun( new ENoun( "bird", "birds" ), new ENoun( "aiwë", "aiwi" ), //1
                                                              new int [] { 0, 1, 3, 4, 5, 6, 7, 8, 9, 10 },
                                                              new int []{ 0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 13, 14, 15, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "book", "books" ), new ENoun( "parma", "parmar" ), //2
                                                              new int [] { 0, 1, 4, 5, 7, 8, 10 },
                                                              new int [] { 2, 6, 12, 15, 18, 20, 23, 25, 30 } ),
                                               new VocabNoun( new ENoun( "Dwarf", "Dwarves" ), new ENoun( "Nauco", "Naucor" ), //3
                                                              new int [] { 0, 3, 4, 5, 6, 9, 10 },
                                                              new int []{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "Elf", "Elves" ), new ENoun( "Elda", "Eldar" ), //4
                                                              new int [] { 0, 3, 4, 5, 6, 9, 10 },
                                                              new int []{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "eye", "eyes" ), new ENoun( "hen", "hendi" ), //5
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
                                                              new int [] { 1, 5, 8, 9, 10, 12, 13, 14, 17, 18, 27, 28, 30 } ),
                                               new VocabNoun( new ENoun( "floor", "floors" ), new ENoun( "talan", "talami" ), //6
                                                              new int [] { 0, 1, 4, 5, 6, 7, 8, 10 }, 
                                                              new int [] { 2, 12, 21 } ),
                                               new VocabNoun( new ENoun( "gate", "gates" ), new ENoun( "anto", "antor" ), //7
                                                              new int [] { 0, 1, 3, 4, 6, 8, 10 },
                                                              new int [] { 2, 12, 20, 21, 29 } ),
                                               new VocabNoun( new ENoun( "horse", "horses" ), new ENoun( "rocco", "roccor" ), //8
                                                              new int [] { 0, 1, 3, 4, 5, 6, 7, 8, 9, 10 },
                                                              new int [] { 0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 13, 14, 15, 17, 18, 19, 20, 21, 22, 23, 24, 26, 27, 29, 30 } ),
                                               new VocabNoun( new ENoun( "king", "kings" ), new ENoun( "aran", "arani" ), //9
                                                              new int [] { 0, 1, 3, 4, 5, 6, 7, 8, 9, 10 },
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "maiden", "maidens" ), new ENoun( "vendë", "vendi" ), //10
                                                              new int [] { 0, 3, 4, 5, 6, 9, 10 },
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "man", "men" ), new ENoun( "nér", "neri" ), //11
                                                              new int [] { 0, 3, 4, 5, 6, 9, 10 },
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "Moon", "moons" ), new ENoun( "Isil", "isili" ), //12
                                                              new int [] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                                                              new int [] { 2, 8, 12, 15, 18, 20, 21, 25, 30 } ),
                                               new VocabNoun( new ENoun( "mountain", "mountains" ), new ENoun( "oron", "oronti" ), //13
                                                              new int [] { 0, 1, 3, 4, 5, 6, 7, 8, 10 },
                                                              new int [] { 2, 5, 13, 21, 23, 29, 30 } ),
                                               new VocabNoun( new ENoun( "people", "peoples" ), new ENoun( "lië", "lier" ), //14
                                                              new int [] { 0, 3, 4, 5, 6, 9, 10 },
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "queen", "queens" ), new ENoun( "tári", "tárir" ), //15
                                                              new int [] { 0, 1, 3, 4, 5, 6, 7, 8, 9, 10 },
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "ship", "ships" ), new ENoun( "cirya", "ciryar" ), //16
                                                              new int [] { 0, 1, 3, 4, 5, 6, 7, 8, 10 },
                                                              new int [] { 2, 11, 18, 19, 21, 24, 29, 30 } ),
                                               new VocabNoun( new ENoun( "star", "stars" ), new ENoun( "elen", "eleni" ), //17
                                                              new int [] { 0, 1, 2, 3, 4, 5, 7, 8, 9, 10 },
                                                              new int [] { 2, 5, 10, 12, 15, 17, 18, 20, 21, 25, 26, 30 } ),
                                               new VocabNoun( new ENoun( "stone", "stones" ), new ENoun( "sar", "sardi" ), //18
                                                              new int [] { 0, 1, 4, 5, 7, 8, 10 },
                                                              new int [] { 12, 18, 20, 29, 30 } ),
                                               new VocabNoun( new ENoun( "Sun", "suns" ), new ENoun( "Anar", "anari" ), //19
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                                                              new int [] { 2, 8, 12, 15, 18, 20, 23, 25, 29, 30 } ),
                                               new VocabNoun( new ENoun( "treasure", "treasures" ), new ENoun( "harma", "harmar" ), //20
                                                              new int [] { 0, 1, 2, 4, 5, 6, 7, 8, 10 },
                                                              new int [] { 12, 18, 21, 25, 26, 28, 30 } ),
                                               new VocabNoun( new ENoun( "tree", "trees" ), new ENoun( "alda", "aldar" ), //21
                                                              new int [] { 0, 1, 3, 5, 6, 7, 8, 10 },
                                                              new int [] { 2, 6, 13, 14, 17, 19, 20, 21, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "woman", "women" ), new ENoun( "nís", "nissi" ), //22
                                                              new int [] { 0, 3, 4, 5, 6, 9, 10 },
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "willow", "willows" ), new ENoun( "tasar", "tasari" ), //23
                                                              new int [] { 0, 1, 3, 5, 6, 7, 8, 10 },
                                                              new int [] { 2, 6, 13, 14, 17, 19, 20, 21, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "Man", "Men" ), new ENoun( "Atan", "Atani" ), //24
                                                              new int [] { 0, 3, 4, 5, 6, 9, 10 },
                                                              new int []{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "warrior", "warriors" ), new ENoun( "ohtar", "ohtari" ), //25
                                                              new int [] { 0, 3, 4, 5, 6, 9, 10 },
                                                              new int []{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "world", "worlds" ), new ENoun( "Ambar", "ambari" ), //26
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                                                              new int []{ 1, 2, 3, 10, 13, 14, 15, 17, 20, 23, 25, 26, 30 } ),
                                               new VocabNoun( new ENoun( "lion", "lions" ), new ENoun( "rá", "rávi" ), //27
                                                              new int [] { 0, 1, 3, 4, 5, 6, 7, 8, 9, 10 },
                                                              new int []{ 0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 13, 14, 15, 17, 19, 20, 21, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "flesh" ), new ENoun( "hrávë" ), //28
                                                              new int [] { 1, 3, 4, 5, 7, 10 },
                                                              new int [ 0 ] ),
                                               new VocabNoun( new ENoun( "sword", "swords" ), new ENoun( "macil", "macili" ), //29
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 10 },
                                                              new int [] { 2, 8, 13, 18, 19, 20, 24, 29, 30 } ),
                                               new VocabNoun( new ENoun( "boy", "boys" ), new ENoun( "seldo", "seldor" ), //30
                                                              new int [] { 0, 3, 4, 5, 6, 9, 10 },
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "slave", "slaves" ), new ENoun( "mól", "móli" ), //31
                                                              new int [] { 0, 3, 4, 5, 6, 9, 10 },
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabNoun( new ENoun( "house", "houses" ), new ENoun( "coa", "coar" ), //32
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
                                                              new int [] { 0, 2, 3, 12, 13, 17, 18, 21, 30 } )};
    
    public static final VocabVerb [] VERBS = { new VocabVerb( new EVerb( "eat", "eating", new String [] { "ate", "eaten" } ), new QVerb( "mat", "P" ), //0
                                                              new int[]{ 1, 5, 8, 27, 28, 32 },
                                                              new int [] { 0, 2 } ),
                                               new VocabVerb( new EVerb( "find", "finding", "found" ), new QVerb( "hir", "P" ), //1
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 },
                                                              new int [] { 0, 2 } ),
                                               new VocabVerb( new EVerb( "guard", "guarding", "guarded" ), new QVerb( "tir", "P" ), //2
                                                              new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 },
                                                              new int [] { 0, 2 }  ),
                                               new VocabVerb( new EVerb( new String [] { "have", "has" }, "having", "had" ), new QVerb( "harya", "Y" ), //3
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 27, 29, 30, 31, 32 },
                                                              new int [] { 0, 1, 2 }  ),
                                               new VocabVerb( new EVerb( "jump", "jumping", "jumped" ), new QVerb( "cap", "P" ), //4
                                                              new int [] {},
                                                              new int [] { 0, 1, 2, 3, 4 } ),
                                               new VocabVerb( new EVerb( "laugh", "laughing", "laughed" ), new QVerb( "lala", "A" ), //5
                                                              new int[ 0 ],
                                                              new int [] { 0, 2 } ),
                                               new VocabVerb( new EVerb( "lay", "laying", "laid" ), new QVerb( "caita", "Ad" ), //6
                                                              new int [ 0 ],
                                                              new int [] { 0, 2 } ),
                                               new VocabVerb( new EVerb( "love", "loving", "loved" ), new QVerb( "mel", "P" ), //7
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 },
                                                              new int [] { 0, 2 },
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 } ),
                                               new VocabVerb( new EVerb( "raise", "raising", "raised" ), new QVerb( "orta", "Ac" ), //8
                                                              new int [] { 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 14, 15, 16, 18, 19, 20, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32 },
                                                              new int [] { 1, 2, 3, 4 } ),
                                               new VocabVerb( new EVerb( "read", "reading", "read" ), new QVerb( "cenda", "Ac" ), //9
                                                              new int [] { 2 },
                                                              new int [] { 0, 1, 2, 3, 4 } ),
                                               new VocabVerb( new EVerb( "see", "seeing", new String [] { "saw", "seen" } ), new QVerb( "cen", "P" ), //10
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 },
                                                              new int [] { 0, 1, 2, 4 } ),
                                               new VocabVerb( new EVerb( "seize", "seizing", "seized" ), new QVerb( "mapa", "A" ), //11
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 },
                                                              new int [] { 0, 1, 2 }  ),
                                               new VocabVerb( new EVerb( "shine", "shining", "shone" ), new QVerb( "sil", "P" ), //12
                                                              new int [ 0 ],
                                                              new int [] { 0, 1, 2, 3, 4 } ),
                                               new VocabVerb( new EVerb( "sing", "singing", new String [] { "sang", "sung" } ), new QVerb( "linda", "Ac" ), //13
                                                              new int [ 0 ],
                                                              new int [] { 0, 1, 2, 3, 4 } ),
                                               new VocabVerb( new EVerb( "speak", "speaking", new String [] { "spoke", "spoken" } ), new QVerb( "quet", "P" ), //14
                                                              new int [ 0 ],
                                                              new int [] { 0, 1, 2, 3, 4 } ),
                                               new VocabVerb( new EVerb( "summon", "summoning", "summoned" ), new QVerb( "tulta", "Ac" ), //15
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 27, 29, 30, 31, 32 },
                                                              new int [] { 0, 1, 2, 3 } ),
                                               new VocabVerb( new EVerb( "write", "writing", new String [] { "wrote", "written" } ), new QVerb( "tec", "P" ), //16
                                                              new int [] { 2 },
                                                              new int [] { 0, 2, 3 } ),
                                               new VocabVerb( new EVerb( "die", "dying", "died" ), new QVerb( "fir", "P" ), //17
                                                              new int [ 0 ],
                                                              new int [] { 0, 2 } ),
                                               new VocabVerb( new EVerb( "control", "controlling", "controlled" ), new QVerb( "tur", "P" ), //18
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 },
                                                              new int [] { 0 } ),
                                               new VocabVerb( new EVerb( "come", "coming", new String [] { "came", "come" } ), new QVerb( "tul", "P" ), //19
                                                              new int [ 0 ],
                                                              new int [] { 0, 1, 2, 4 } ),
                                               new VocabVerb( new EVerb( "fall", "falling", new String [] { "fell", "fallen" } ), new QVerb( "lanta", "Ac" ), //20
                                                              new int [ 0 ],
                                                              new int [] { 0, 2, 4 } ),
                                               new VocabVerb( new EVerb( "hide", "hiding", new String [] { "hid", "hidden" } ), new QVerb( "nurta", "Ac" ), //21
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 },
                                                              new int [] { 0, 1, 2 } ),
                                               new VocabVerb( new EVerb( "release", "releasing", "released" ), new QVerb( "lerya", "Y" ), //22
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 },
                                                              new int [] { 0, 2 } ),
                                               new VocabVerb( new EVerb( "end", "ending", "ended" ), new QVerb( "metya", "Y" ), //23
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 },
                                                              new int [] { 0, 1, 2 } ),
                                               new VocabVerb( new EVerb( "pursue", "pursuing", "pursued" ), new QVerb( "roita", "Ad" ), //24
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 },
                                                              new int [] { 0, 1, 2, 3, 4 } ),
                                               new VocabVerb( new EVerb( new String [] { "bless", "blesses" }, "blessing", "blessed" ), new QVerb( "laita", "Ad" ), //25
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 },
                                                              new int [] { 0, 1, 2 } ),
                                               new VocabVerb( new EVerb( "want", "wanting", "wanted" ), new QVerb( "mer", "P" ), //26
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32},
                                                              new int [] { 0, 1, 2, 3, 4 },
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 27, 28, 29, 30 }),
                                               new VocabVerb( new EVerb( "hear", "hearing", "heard" ), new QVerb( "hlar", "P" ), //27
                                                              new int [ 0 ],
                                                              new int [] { 0, 1, 2, 3, 4 } ),
                                               new VocabVerb( new EVerb( "dare", "daring", "dared" ), new QVerb( "verya", "Ay" ), //28
                                                              new int [ 0 ],
                                                              new int [] { 0, 1, 2, 3, 4 } ),
                                               new VocabVerb( new EVerb( "stop", "stopping", "stopped" ), new QVerb( "pusta", "Ac" ), //29
                                                              new int [ 0 ],
                                                              new int [] { 0, 1, 2 },
                                                              new int [] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 30 }),
                                               new VocabVerb( new EVerb( "terrify", "terrifying", "terrified" ), new QVerb( "ruhta", "Ac" ), //30
                                                              new int [ 0 ],
                                                              new int [] { 0, 1, 2 } )};
    
                                                  
    public static Vocab rand( int type )
    {
        int index;
        switch( type )
        {
            case 1: //Nouns
                index = (int)( Math.random() * NOUNS.length );
                return NOUNS[ index ];
            case 2: //Verbs
                index = (int)( Math.random() * VERBS.length );
                return VERBS[ index ];
            case 3: //Adjectives
                index = (int)( Math.random() * ADJECTIVES.length );
                return ADJECTIVES[ index ];
            case 4: //Mixed
                Vocab [] v = Stream.concat( Arrays.stream( NOUNS ), Arrays.stream( VERBS ) ).toArray(Vocab[]::new);
                index = (int)( Math.random() * v.length );
                return v[ index ];
            default:
                throw new IllegalArgumentException( "The type argument was neither 1, 2, 3, nor 4." );
        }
    }
    
    public static Vocab rand()
    {
        return rand( 4 );
    }
}
*/