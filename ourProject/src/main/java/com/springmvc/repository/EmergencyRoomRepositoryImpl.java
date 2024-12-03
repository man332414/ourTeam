package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import com.springmvc.DTO.emergencyRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class EmergencyRoomRepositoryImpl implements EmergencyRoomRepository {

	private List<emergencyRoom> listOfRooms = new ArrayList<emergencyRoom>();
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template= new JdbcTemplate(dataSource);
	}
	
	public EmergencyRoomRepositoryImpl() {
		
		System.out.println("EmergencyRoomRepositoryImpl: 진입");
		
		System.out.println("EmergencyRoomRepositoryImpl: listOfRooms=" + listOfRooms);
		
		return ;
	}
	
	@Override
	public List<emergencyRoom> getALLemergencyRoomList() {
		System.out.println("getALLemergencyRoomList: 진입");
		
		String SQL = "select * from emergencyroom";
		
		List<emergencyRoom> listOfRooms = template.query(SQL,new EmergencyRoomRowMapper());
		
		System.out.println("getALLemergencyRoomList  listOfRooms= " +listOfRooms);
		 
		return listOfRooms;
	}

	@Override
	public List<emergencyRoom> getemergencyRoomListByAddress(String address) {
		System.out.println("getemergencyRoomListByAddress: 진입");
		
		String SQL = "select * from emergencyroom where hosAddr like '%" + address +"%'";
		List<emergencyRoom> roomsByAddress = template.query(SQL,new EmergencyRoomRowMapper());
		
		System.out.println("getemergencyRoomListByAddress  roomsByAddress= " + roomsByAddress);
		 
		return roomsByAddress;
	}

	@Override
	public List<emergencyRoom> getemergencyRoomListByChange(String ischanged) {
		System.out.println("getemergencyRoomListByChange: 진입");
		
		String SQL = "select * from emergencyroom where isPediatrics = true"  ;
		List<emergencyRoom> roomsByChange = template.query(SQL,new EmergencyRoomRowMapper());
		
		System.out.println("getemergencyRoomListByChange  roomsByChange= " + roomsByChange);
		 
		return roomsByChange;
	}

	@Override
	public emergencyRoom getemergencyRoomkByNum(int number) {
		
		System.out.println("getemergencyRoomkByNum: 진입");
		emergencyRoom emergencyRoomInfo = null;
		String SQL = "select * from emergencyroom where num = " + number   ;
		//emergencyRoomInfo = (emergencyRoom) template.query(SQL,new EmergencyRoomRowMapper());
		// query 메서드 대신 queryForObject 메서드 사용
		emergencyRoomInfo = (emergencyRoom) template.queryForObject(SQL, new EmergencyRoomRowMapper());
				
		System.out.println("getemergencyRoomkByNum  emergencyRoomInfo= " + emergencyRoomInfo);

		return emergencyRoomInfo;
	}

	@Override
	public void setNewemergencyRoom(emergencyRoom emergencyRoom) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpdateemergencyRoomk(emergencyRoom emergencyRoom) {
		// TODO Auto-generated method stub

	}

	
	
	@Override
	public void setDeleteemergencyRoom(int number) {
		// TODO Auto-generated method stub
		
	}

	
}
