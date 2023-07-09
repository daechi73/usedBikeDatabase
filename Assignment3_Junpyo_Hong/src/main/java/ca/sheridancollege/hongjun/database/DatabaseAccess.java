package ca.sheridancollege.hongjun.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.hongjun.beans.Bike;
import ca.sheridancollege.hongjun.beans.Manufacturer;
import ca.sheridancollege.hongjun.beans.User;

/**
 * The DatabaseAccess class holds all the methods needed to access certain
 * data from the database. 
 * @author Jp
 *
 */

@Repository
public class DatabaseAccess {
	
	@Autowired 
	private NamedParameterJdbcTemplate jdbc;
	
	public User findUserAccount(String email) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();  
		String query = "SELECT * FROM sec_user where email=:email"; 
		
		parameters.addValue("email",email);
		ArrayList<User> users = (ArrayList<User>)jdbc.query(query, parameters,new  
				BeanPropertyRowMapper<User>(User.class));
		if (users.size()>0) return users.get(0);  
		else return null;
		
	}
	
	public List<String> getRolesById(Long userId){
		ArrayList<String> roles = new ArrayList<String>();  
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();  
		String query = "select user_role.userId, sec_role.roleName "
				+ "FROM user_role, sec_role "
				+ "WHERE user_role.roleId=sec_role.roleId "
				+ "AND userId=:userId";
		parameters.addValue("userId",userId);
		List<Map<String,Object>>rows=jdbc.queryForList(query,parameters);
		for(Map<String,Object>row:rows){roles.add((String)row.get("roleName"));}
		return roles;
		}
	
	public void insertBike(int manufactureId, String bikeModel, 
					int year, String colour, double price ) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = " INSERT INTO bike "
				+ "(manufacturerID, bikeModel, year, colour, price)"
				+ " VALUES (:manufacturerID, :bikeModel, :year, :colour, :price)";
		parameters.addValue("manufacturerID", manufactureId);
		parameters.addValue("bikeModel", bikeModel);
		parameters.addValue("year", year);
		parameters.addValue("colour", colour);
		parameters.addValue("price", price);
		jdbc.update(query,parameters);
	}

	public List<Manufacturer> getManufacturer(){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM manufacturer";
		return jdbc.query(query, namedParameters, 
				new BeanPropertyRowMapper<Manufacturer>(Manufacturer.class));		
	}
	public List<Bike> getBike(){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM bike";
		return jdbc.query(query, namedParameters, 
				new BeanPropertyRowMapper<Bike>(Bike.class));
		
	}
	public List<Bike> getBikeById(int id){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM bike WHERE bikeID = :id";
		namedParameters.addValue("id",id);
		return jdbc.query(query, namedParameters, 
				new BeanPropertyRowMapper<Bike>(Bike.class));
		
	}
	
	public void updateBike(String bikeModel, double price, int bikeID) {
		if(bikeID != 0) {
			MapSqlParameterSource namedParameters = new MapSqlParameterSource();
			String query = "UPDATE bike SET bikeModel=:bikeModel, price=:price WHERE bikeID=:bikeID";
			namedParameters.addValue("bikeModel", bikeModel);
			namedParameters.addValue("price", price);
			namedParameters.addValue("bikeID", bikeID);
			jdbc.update(query, namedParameters);
		}
		System.out.println(bikeID);
	}
	
	
	public void deleteBike(int id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "DELETE FROM bike where bikeID = :id";
		namedParameters.addValue("id", id);
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Deleted student " + id + " from database");
	}
	




}
