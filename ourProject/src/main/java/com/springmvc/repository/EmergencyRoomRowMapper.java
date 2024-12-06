package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.springmvc.DTO.emergencyRoom;

import org.springframework.jdbc.core.RowMapper;

public class EmergencyRoomRowMapper implements RowMapper<emergencyRoom> {

	@Override
	public emergencyRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
		 
		emergencyRoom room = new emergencyRoom();
		
		room.setNumber(rs.getInt(1));
		room.setHosName(rs.getString(2));
		room.setHosaddr(rs.getString(3));
		room.setDistance(rs.getInt(4));
		room.setTravelTime(rs.getString(5));
		room.setNumOfBad(rs.getInt(6));
		room.setPediatrics(rs.getBoolean(7));
		room.setObstetricsAndGynecology(rs.getBoolean(8));
		
	//	System.out.println("Room RowMapper 진입" +room.isPediatrics());
	//	System.out.println("Room RowMapper 진입" +room.isObstetricsAndGynecology());
		return room;
	}

	 
}
