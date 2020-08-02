package data;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.postgresql.util.PSQLException;

import enums.Environment;
import io.cucumber.plugin.event.Result;

/**
 *
 * This class establishes database connection and has methods defined to fetch
 * data from the database.
 * 
 * @author rupeshkumar02
 *
 */
public class DBUtils {

	private static Logger log = Logger.getLogger(DBUtils.class);

	private static Connection conn;
	private static Statement stm;
	private static ResultSet resultSet;

	private static void setUpDBConnection(String dbName) {
		log.info("Setting Up Database Connection");

		try {
			Class.forName("org.postgresql.Driver").newInstance();

			switch (ConfigReader.getProperty("environment")) {

			case Environment.DEV:
				conn = DriverManager.getConnection(ConfigReader.getProperty("databaseUrl_DEV") + "/" + dbName + "?",
						ConfigReader.getProperty("databaseUsername_DEV"), ConfigReader.getProperty("databasePassword"));
				break;

			case Environment.QA:
				conn = DriverManager.getConnection(ConfigReader.getProperty("databaseUrl_QA") + "/" + dbName + "?",
						ConfigReader.getProperty("databaseUsername_QA"), ConfigReader.getProperty("databasePassword"));
				break;

			case Environment.PREPROD:
				conn = DriverManager.getConnection(ConfigReader.getProperty("databaseUrl_PREPROD") + "/" + dbName + "?",
						ConfigReader.getProperty("databaseUsername_PREPROD"),
						ConfigReader.getProperty("databasePassword"));
				break;

			default:
				System.err.println("please enter env as DEV, QA or PREPROD");
				break;
			}

			log.info("Database connection established successfully on " + ConfigReader.getProperty("environment")
					+ " environment");

		} catch (PSQLException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void closeDBConnection() {

		try {
			if (conn != null)
				conn.close();
			stm.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * returns value from DB
	 * 
	 * @param dbName
	 * @param query
	 * @return
	 */
	public static String getData(String dbName, String query) {

		List<Object> reqData = new ArrayList<Object>();

		if (conn == null)
			setUpDBConnection(dbName);

		try {
			log.info("executing query " + query);
			stm = conn.createStatement();

			try {
				resultSet = stm.executeQuery(query);
			} catch (PSQLException e) {
				if (!resultSet.next())
					System.err.println("NO DATA FETCHED");
			}

			int columnCount = resultSet.getMetaData().getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				if (resultSet.next())
					reqData.add(resultSet.getObject(i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBConnection();
		}

		if (reqData.size() == 0) {
			log.info("NO DATA FETCHED");
			return "LIST IS EMPTY AS NO DATA FETCHED";
		}

		return String.valueOf(reqData.get(0));
	}

	public static List<String> getDataInList(String dbName, String query) {

		List<String> reqData = new ArrayList<String>();

		if (conn == null)
			setUpDBConnection(dbName);

		try {
			log.info("executing query " + query);
			stm = conn.createStatement();
			resultSet = stm.executeQuery(query);
			while (resultSet.next())
				reqData.add(resultSet.getString(1));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBConnection();
		}

		Collections.sort(reqData);
		return reqData;
	}

	/**
	 * executes query (UPDATE, INSERT)
	 * 
	 * @param dbName
	 * @param query
	 */
	public static void executeQuery(String dbName, String query) {

		setUpDBConnection(dbName);

		try {
			log.info("executing query: " + query);
			stm = conn.createStatement();
			resultSet = stm.executeQuery(query);
		} catch (PSQLException e) {
			if (e.getMessage().contains("No results were returned by the query."))
				log.info("query ran successfully");
			else
				e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBConnection();
		}
	}

	public static List<Object> getAllColumnDataInList(String dbName, String query) {

		List<Object> reqData = new ArrayList<Object>();

		if (conn == null)
			setUpDBConnection(dbName);

		try {
			log.info("executing query " + query);
			stm = conn.createStatement();
			resultSet = stm.executeQuery(query);

			int columnCount = 0;

			if (!resultSet.next())
				System.err.println("NO DATA FETCHED");
			else
				columnCount = resultSet.getMetaData().getColumnCount();

			for (int i = 1; i <= columnCount; i++) {
				reqData.add(resultSet.getObject(i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBConnection();
		}

		return reqData;
	}

	/**
	 * 
	 * @param dbName
	 * @param query
	 * @param key
	 * @param value
	 * @return {@link Map}
	 */
	public static Map<String, String> getDataInMap(String dbName, String query, String key, String value) {

		Map<String, String> data = new TreeMap<String, String>();

		if (conn == null)
			setUpDBConnection(dbName);

		try {
			log.info("executing query " + query);
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = stm.executeQuery(query);

			if (!resultSet.next())
				System.err.println("NO DATA FETCHED");
			resultSet.beforeFirst();
			while (resultSet.next())
				data.put(resultSet.getString(key).trim(), resultSet.getString(value).trim());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBConnection();
		}
		return data;
	}

	public static Map<String, Map<String, String>> getDataInMap(String dbName, String query, String key, String subKey,
			String value) {

		Map<String, Map<String, String>> map = new LinkedHashMap<>();

		if (conn == null)
			setUpDBConnection(dbName);

		try {
			log.info("executing query " + query);
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = stm.executeQuery(query);

			if (!resultSet.next())
				System.err.println("NO DATA FETCHED");
			resultSet.beforeFirst();
			while (resultSet.next()) {

				if (!map.containsKey(resultSet.getString(key))) {
					Map<String, String> subMap = new LinkedHashMap<>();
					map.put(resultSet.getString(key), subMap);
					map.get(resultSet.getString(key)).put(resultSet.getString(subKey), resultSet.getString(value));
				} else {
					map.get(resultSet.getString(key)).put(resultSet.getString(subKey), resultSet.getString(value));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBConnection();
		}
		return map;
	}

	public static HashMap<?, ?> getAllColumnDataInMapAndList(String dbName, String query) {

		HashMap<Object, Object> finalResultSet = new HashMap<>();

		if (conn == null)
			setUpDBConnection(dbName);

		try {
			log.info("executing query " + query);
			stm = conn.createStatement();
			resultSet = stm.executeQuery(query);

			int columnCount = resultSet.getMetaData().getColumnCount();
			List<String> reqData = new ArrayList<String>();
			Object key = null;
			int count = 0;
			while (resultSet.next()) {
				if (count == 0)
					key = resultSet.getString(1);
				for (int i = 2; i <= columnCount; i++)
					reqData.add(resultSet.getString(i));
				count++;
			}
			finalResultSet.put(key, reqData);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBConnection();
		}

		return finalResultSet;
	}

}
