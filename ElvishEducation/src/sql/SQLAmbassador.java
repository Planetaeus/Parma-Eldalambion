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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://localhost:40015;" +
                                "databaseName=ParmaQuenion;";
    
    static final String USER = "username";
    static final String PASS = "pass";
    
    public static HashMap mapWords( String tableName, String columnName )
    {
        Connection conn = null;
        Statement stmt = null;
        String query = "SELECT id, " + columnName + " FROM " + tableName + " ORDER BY " + columnName + " ASC;";
        Map list = new HashMap();
        
        try
        {
            // TODO code application logic here
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            
            while(rs.next())
            {
                int id = rs.getInt("id");
                String word = rs.getString( columnName );
                
                list.put( word, id );
            }
            rs.close();
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
        
        
        try
        {
            // TODO code application logic here
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = conn.createStatement();
            stmt.execute(query);
            
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
    
    public static void addAssociation( String table, String columns, int [] numbers )
    {
        String [] components = new String [ numbers.length ];
        for( int i = 0; i < numbers.length; i++ )
        {
            components[ i ] = numbers[ i ] + "";
        }
        addWord( table, columns, components );
    }
    
    public static Word getRandomWord( String table, String column )
    {
        String word = "";
        int index = 0;
        Connection conn = null;
        Statement stmt = null;
        try
        {
            // TODO code application logic here
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String addSQL = "SELECT COUNT(*) AS numbers FROM " + table + ";";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(addSQL);
            rs.next();
            index = rs.getInt("numbers");
            index = (int)(Math.random()*index)+1;
            
            String sql = "SELECT " + column + " FROM " + table
                        + " WHERE id = " + index + ";";
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                word = rs.getString(column);
            }
            rs.close();
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
        
        return new Word( word, index );
    }
    
    public static int findRandomOtherIndex( String table, String knownColumn, String desiredColumn, int id )
    {
        List<Integer> list = new ArrayList<Integer>();
        int index = 0;
        
        Connection conn = null;
        Statement stmt = null;
        try
        {
            // TODO code application logic here
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "SELECT " + desiredColumn + " FROM " + table
                        + " WHERE " + knownColumn + " = " + id + ";";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                list.add(rs.getInt(desiredColumn));
            }
            rs.close();
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
        
        index = (int)(Math.random()*list.size());
        
        return list.get( index );
    }
    
    public static Word findWord( String table, String column, int id )
    {
        String word = "";
        Connection conn = null;
        Statement stmt = null;
        try
        {
            // TODO code application logic here
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "SELECT " + column + " FROM " + table
                        + " WHERE id = " + id + ";";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                word = rs.getString(column);
            }
            rs.close();
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
        
        return new Word( word, id );
    }
    
    public static int findIndex( String table, String column, String word )
    {
        int index = -1;
        Connection conn = null;
        Statement stmt = null;
        try
        {
            // TODO code application logic here
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            
            String sql = "SELECT id FROM " + table
                        + " WHERE " + column + " LIKE '" + word + "';";
            
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                index = rs.getInt( "id" );
            }
            
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
        
        return index;
    }
}
