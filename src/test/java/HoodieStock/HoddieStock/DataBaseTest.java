package HoodieStock.HoddieStock;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.DataBase;
import model.Hoodie;
import org.junit.*;

public class DataBaseTest {

	// URL del database di test 
    public static final String TEST_DB_URL =  "jdbc:sqlite:TestDB.db";
    
    
    //METODI DI SUPPORTO PER TEST GESTIONE DB
  
    //Creazione tabella 
    public void setup() {
    	String sql1 = ("CREATE TABLE TABLETEST (" + " ID NUMERIC," + " MODELLO TEXT, "
    			+ "TAGLIA TEXT, " + "COLORE TEXT)");
    	DataBase.createTable(TEST_DB_URL, sql1);
    }
    
    // Elimina la tabella di test dopo ogni test
    public void cleanup() {
        try (Connection conn = DriverManager.getConnection(TEST_DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS TABLETEST");
        } catch (SQLException e) {
            fail("Eccezione SQL durante l'eliminazione: " + e.getMessage());
        }
    }
    
    
	
	//TEST 1: CREATE TABLE
    
    @Test
    public void testCreateTable() { 
    	
    	final String CREATE_TABLE_SQL  = "CREATE TABLE TABLETEST (" + " ID NUMERIC," + " MODELLO TEXT, "
    			+ "TAGLIA TEXT, " + "COLORE TEXT)";
    	
        DataBase.createTable(TEST_DB_URL, CREATE_TABLE_SQL);
        
        try {
			assertTrue(isTableExists("TABLETEST"));
			
		} catch (SQLException e) {
			fail("Eccezione SQL durante il test: " + e.getMessage());	
		}   
        
        cleanup(); 
    }
    
    private boolean isTableExists(String tableName) throws SQLException {
        try (Connection conn = DriverManager.getConnection(TEST_DB_URL);
             ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null)) {
             return rs.next();
        }
    }

   
    
    //TEST 2: INSERT IN DB
   
    @Test
    public void testInsertInDB() {
    	
    	setup(); 
    	
        Hoodie testHoodie = new Hoodie("23", "A", "L", "ROSSO");

        try {
            DataBase.insertInDB(testHoodie, TEST_DB_URL, "TABLETEST" );
            assertTrue(isRecordExists(testHoodie.getId()));
            
        } catch (SQLException e) {
            fail("Eccezione durante l'inserimento nel database: " + e.getMessage());
        }
        
        
        
        cleanup(); //Elimino tabella dopo test 
    }

  
    //TEST 3: REMOVE FROM DB
    
    @Test
    public void testRemoveFromDb() {
    	
    	setup(); 
    	
        Hoodie testHoodie = new Hoodie("3", "A", "L", "ROSSO");
        DataBase.insertInDB(testHoodie, TEST_DB_URL, "TABLETEST");

        try {
            DataBase.removeFromDb(testHoodie, TEST_DB_URL, "TABLETEST");
            assertFalse(isRecordExists(testHoodie.getId()));
            
            
        } catch (SQLException e) {
            fail("Eccezione durante l'eliminazione dal database: " + e.getMessage());
        }
        
        cleanup(); //Elimino tabella dopo test 
    }
   
    private boolean isRecordExists(String id) throws SQLException {
        String query = "SELECT COUNT(*) FROM TABLETEST WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(TEST_DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Restituisce true se il conteggio è maggiore di zero
                } else {
                    return false; // Nessun risultato restituito dalla query
                }
            }
        }
    }


    
 
    
    
  
}
