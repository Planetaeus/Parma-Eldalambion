/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import vocab.Word;

/**
 *
 * @author Michael
 */
public class SQLAmbassador
{
    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL = "jdbc:sqlserver://localhost:40015;" +
                                "databaseName=ParmaQuenion;";
    
    private static final String USER = "username";
    private static final String PASS = "pass";
    
    public static HashMap mapWords( String tableName, String columnName )
    {
        String query = "SELECT id, " + columnName + " FROM " + tableName + " ORDER BY id ASC;";
        Map list = new HashMap();
        
        Process block = (ResultSet rs) ->
        {
            Map returnable = new HashMap();
            while(rs.next())
                {
                    int id = rs.getInt("id");
                    String word = rs.getString( columnName );
                    returnable.put(id, word);
                }
            return returnable;
        };
        
        list = (HashMap)query( query, block );
        
        return (HashMap)list;
    }
    
    public static void addWord( String table, String columns, String [] components )
    {
        Connection conn = null;
        Statement stmt = null;
        
        String c = "";
        for( int i = 0; i < components.length; i++ )
        {
            c +=  "'" + components[ i ];
            if( i < components.length - 1 )
                c += "', ";
        }
        
        String query = "INSERT INTO " + table + "( " + columns + " ) VALUES ( "+ c.trim() + "' );";
        
        update( query );
    }
    
    public static void addAssociation( String table, String columns, int [] numbers )
    {
        String [] components = new String [ numbers.length ];
        for( int i = 0; i < numbers.length; i++ )
        {
            components[ i ] = numbers[ i ] + "";
        }
        addWord( table, columns, components );
    }
    
    public static Word getRandomWord( String eTable, String eColumn, String qTable, String qColumn )
    {
        Word word = null;
        
        String query = "SELECT TOP 1 " + eTable + "." + eColumn + " AS 'English', "
                        + qTable + "." + qColumn + " AS 'Quenya'"
                        + " FROM " + eTable + " JOIN " + qTable
                        + " ON " + eTable + ".id = " + qTable + ".id "
                        + "ORDER BY NEWID()";
        
        Process block = (ResultSet rs) ->
        {
            Word returnable = null;
            while( rs.next() )
            {
                int index = rs.getInt( "id" );
                String e = rs.getString( "English" );
                String q = rs.getString( "Quenya" );
                returnable = new Word( e, q, index );
            }
            
            return returnable;
        };
        
        word = (Word)query( query, block );
        
        return word;
    }
    
    public static int findRandomOtherIndex( String table, String knownColumn, String desiredColumn, int id )
    {
        int index = -1;
        
        String query = "SELECT TOP 1 " + desiredColumn + " FROM " + table
                        + " WHERE " + knownColumn + " = " + id + " ORDER BY NEWID();";
        
        Process block = (ResultSet rs) ->
        {
            int returnable = -1;
            while(rs.next())
            {
                returnable = rs.getInt(desiredColumn);
            }
            return returnable;
        };
        
        index = (int)query( query, block );
        
        return index;
    }
    
    public static Word findWord( String table, String column, int id )
    {
        String word = "";
        
        String query = "SELECT " + column + " FROM " + table
                        + " WHERE id = " + id + ";";
        
        Process block = (ResultSet rs) ->
        {
            String returnable = "";
            while(rs.next())
            {
                returnable = rs.getString(column);
            }
            return returnable;
        };
        
        word = (String)query( query, block );
        
        return new Word( word, word, id );
    }
    
    public static int findIndex( String table, String column, String word )
    {
        int index = -1;
        String query = "SELECT id FROM " + table
                        + " WHERE " + column + " LIKE '" + word + "';";
        
        Process block = (ResultSet rs) ->
        {
            int returnable = -1;
            while (rs.next())
            {
                returnable = rs.getInt( "id" );
            }
            return returnable;
        };
        
        index = (int)( query( query, block ) );
        
        return index;
    }
    
    public static Object query( String query, Process block )
    {
        Object returned = null;
        
        Connection conn = null;
        Statement stmt = null;
        try
        {
            // TODO code application logic here
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery( query );
            
            returned = block.execute( rs );
            
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(SQLAmbassador.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(SQLAmbassador.class.getName()).log(Level.SEVERE, null, ex);
            }
            try
            {
                if(conn != null)
                    conn.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(SQLAmbassador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return returned;
    }
    
    public static void update( String query )
    {
        Connection conn = null;
        Statement stmt = null;
        
        try
        {
            // TODO code application logic here
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = conn.createStatement();
            stmt.executeUpdate( query );
            
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(SQLAmbassador.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(SQLAmbassador.class.getName()).log(Level.SEVERE, null, ex);
            }
            try
            {
                if(conn != null)
                    conn.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(SQLAmbassador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private interface Process
    {
        Object execute( ResultSet rs ) throws SQLException;
    }
}