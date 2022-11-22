import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Database {

    private final static String JDBC_DRIVER = "org.postgresql.Driver";

    private final static String url = "jdbc:postgresql://localhost/JavaCRUD";
    private final static String user = "kalimara";
    private final static String password = "hitman";

    private final static String PROJECT_ID_QUERY = "select id from projetos where titulo_projeto = ?";
    private final static String ALL_PROJECTS_QUERY = "select titulo_projeto from projetos";
    private final static String SEARCH_PROJECT_QUERY = "select id, titulo_projeto, cidade, estado, categoria, descricao from projetos where titulo_projeto = ?";
    private final static String DELETE_PROJECT_QUERY = "delete from projetos where id = ?";
    private final static String UPDATE_PROJECT_QUERY = "update projetos set titulo_projeto = ?, cidade = ?, estado = ?, categoria = ?, descricao = ? where id = ?";
    private final static String CREATE_PROJECT_QUERY = "insert into projetos values(?, ?, ?, ?, ?, ?)";
    private final static String CREATE_NEW_PERSON_QUERY = "insert into participantes_projeto values (?, ?, ?, ?, ?)";
    
    
    public int ReturnProjectId(String title) {
    	
    	try(Connection connection = DriverManager.getConnection(url, user, password)){

            PreparedStatement query = connection.prepareStatement(PROJECT_ID_QUERY);
            query.setString(1, title);
            
            ResultSet result = query.executeQuery();


            while(result.next()) {
            	return result.getInt("id");
            }
            
            
        } catch (SQLException error) {
            printSQLException(error);
        }
    
    	return 0;
    	
    }
    
    
    public void CreateNewTeamMember(String name, String email, String telephone, int ProjectID) {
    	try(Connection connection = DriverManager.getConnection(url, user, password)){

            PreparedStatement query = connection.prepareStatement(CREATE_NEW_PERSON_QUERY);
            
            Random generator = new Random();
    		int id = generator.nextInt(1000000000);
    		
            query.setInt(1, id);
            query.setString(2, name);
            query.setString(3, email);
            query.setString(4, telephone);
            query.setInt(5, ProjectID);
            
            query.executeUpdate();
            
            
        } catch (SQLException error) {
            printSQLException(error);
        }
    
    }
    
    
    public void SearchProject(String title){

        try(Connection connection = DriverManager.getConnection(url, user, password)){

            PreparedStatement query = connection.prepareStatement(SEARCH_PROJECT_QUERY);
            query.setString(1, title);

            ResultSet result = query.executeQuery();
            
            while (result.next()) {
            	int id = result.getInt("id");
            	String titleProject = result.getString("titulo_projeto");
            	String city = result.getString("cidade");
            	String state = result.getString("estado");
            	String category = result.getString("categoria");
            	String description = result.getString("descricao");
            	
            	ProjectPage newWindow = new ProjectPage(id, titleProject, city, state, category, description);
            }            
            
        } catch (SQLException error) {
            printSQLException(error);
        }

    }
    
    
    public void DeleteProject(int id) {
    	try (Connection connection = DriverManager.getConnection(url, user, password)){
    		PreparedStatement query = connection.prepareStatement(DELETE_PROJECT_QUERY);
            query.setInt(1, id);
            query.executeUpdate();
            
    	} catch (SQLException error) {
            printSQLException(error);
        }
    }
    
    
    public void UpdateProject(String title, String city, String state, String category, String description, int id) {
    	try (Connection connection = DriverManager.getConnection(url, user, password)){
    		PreparedStatement query = connection.prepareStatement(UPDATE_PROJECT_QUERY);
            query.setString(1, title);
            query.setString(2, city);
            query.setString(3, state);
            query.setString(4, category);
            query.setString(5, description);
            query.setInt(6, id);
            
            query.executeUpdate();
            
    	} catch (SQLException error) {
            printSQLException(error);
        }
    }
    
    public void CreateProject(String title, String city, String state, String category, String description) {
    	try (Connection connection = DriverManager.getConnection(url, user, password)){
    		PreparedStatement query = connection.prepareStatement(CREATE_PROJECT_QUERY);
    		
    		Random generator = new Random();
    		int id = generator.nextInt(1000000000);
    		
    		query.setInt(1, id);
            query.setString(2, title);
            query.setString(3, city);
            query.setString(4, state);
            query.setString(5, category);
            query.setString(6, description);
            
            query.executeUpdate();
            
    	} catch (SQLException error) {
            printSQLException(error);
        }
    }
    
    public String[] ReturnAllProjects() {
		String[] allProjects = new String[10];

    	try (Connection connection = DriverManager.getConnection(url, user, password)){
    		PreparedStatement query = connection.prepareStatement(ALL_PROJECTS_QUERY);
    		
    		ResultSet result = query.executeQuery();
    		
    		int counter = 0;
    		
    		while (result.next()) {
            	allProjects[counter] = result.getString("titulo_projeto");
            	counter = counter + 1;
            }
    		
            
    	} catch (SQLException error) {
            printSQLException(error);
        }
    	
		return allProjects;

    }


    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Mensagem: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Causa: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}