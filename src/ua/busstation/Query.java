package ua.busstation;

/**
 * Query.
 * 
 * @author O.Soklakov
 *
 */
public class Query {
	
	// routes
	public static final String SELECT_ALL_ROUTES = "SELECT * FROM routes";
	public static final String ROUTE_BY_NAME = "SELECT * FROM routes where name = (?)";

	// buses
	public static final String GET_BUS_BY_ROUTE_ID = "SELECT * FROM buses WHERE route_id=(?)";
	
	// users
	public static final String SELECT_ALL_USERS = "SELECT * FROM users_new";
	public static final String USER_BY_LOGIN = "SELECT * FROM users_new where login = (?)";
	public static final String DELETE_USER = "DELETE FROM users_new WHERE id = ?";

}
