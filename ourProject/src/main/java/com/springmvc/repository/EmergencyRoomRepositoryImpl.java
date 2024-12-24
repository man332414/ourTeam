package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;


import javax.sql.DataSource;

import com.springmvc.DTO.emergencyRoom;
import com.springmvc.DTO.parentingDiary;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.DTO.emergencyRoom;

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

	//	String SQL = "select * from emergencyRoom";
		
	//	List<emergencyRoom> listOfRooms = template.query(SQL,new EmergencyRoomRowMapper());
		System.out.println("EmergencyRoomRepositoryImpl 진입 ");
		System.out.println("getALLemergencyRoomList 진입 " +listOfRooms);

		 
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
	public emergencyRoom getemergencyRoomByNum(int number) {
		
		System.out.println("getemergencyRoomByNum: 진입" + number);
		emergencyRoom emergencyRoomInfo = null;
		
		String SQL = "select count(*) from emergencyroom where num = ?";
		int rowCount = template.queryForObject(SQL,Integer.class, number);
		System.out.println("30.ERI getemergencyRoomByNum: rowCount ="+rowCount);

		if(rowCount!=0) {
			SQL = "select * from emergencyroom where num = ?";
			emergencyRoomInfo=template.queryForObject(SQL, new Object[] {number},new EmergencyRoomRowMapper());
		} 
		
		System.out.println("getemergencyRoomkByNum  SQL= " + SQL);

		if(emergencyRoomInfo == null) {
			System.out.println("에러입니다 " + SQL);
		} 
		
		System.out.println("getemergencyRoomkByNum  emergencyRoomInfo= " + emergencyRoomInfo);
		return emergencyRoomInfo;
		
	}

	public List<emergencyRoom> getemergencyRoomListByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	 
	 

	@Override
	public void setNewemergencyRoom(emergencyRoom emergencyRoom) {
		
	//	System.out.println("ERI setNewemergencyRoom 진입 "+ emergencyRoom);
		String SQL = "INSERT INTO emergencyroom VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		template.update(SQL,emergencyRoom.getNumber(),emergencyRoom.getHosName(),emergencyRoom.getHosaddr(),
				emergencyRoom.getDistance(),emergencyRoom.getTravelTime(),emergencyRoom.getNumOfBad(),
				emergencyRoom.isPediatrics(),emergencyRoom.isObstetricsAndGynecology(),emergencyRoom.getLatitude(),emergencyRoom.getLongitude());
		
	}
	

	@Override
	public void setUpdateemergencyRoom(emergencyRoom emergencyRoom) {
		
		System.out.println("ERI setUpdateemergencyRoomk 진입 "+ emergencyRoom);
		System.out.println("emergencyRoom.getHosName()= "+ emergencyRoom.getHosName());
		System.out.println("emergencyRoom.getHosaddr()= "+ emergencyRoom.getHosaddr());
		System.out.println("emergencyRoom.getTravelTime()= "+ emergencyRoom.getTravelTime());
		
		String SQL = "UPDATE emergencyroom SET hosName = ?, hosaddr = ?, distance = ?, travelTime = ?, numOfBad = ?, isPediatrics = ?, isObstetricsAndGynecology = ?  where num = ? ";
        template.update(SQL, emergencyRoom.getHosName(), emergencyRoom.getHosaddr(), emergencyRoom.getDistance(), emergencyRoom.getTravelTime(), emergencyRoom.getNumOfBad(), emergencyRoom.isPediatrics(), emergencyRoom.isObstetricsAndGynecology(), emergencyRoom.getNumber());
		
		System.out.println("ERI setUpdateemergencyRoomk SQL2= "+ SQL);
		System.out.println("sql= "+"name: "+emergencyRoom.getHosName()+"addr: "+emergencyRoom.getHosaddr()+"dis: "+
				emergencyRoom.getDistance()+"time: "+emergencyRoom.getTravelTime()+"bed: "+emergencyRoom.getNumOfBad()+"baby: "+
				emergencyRoom.isPediatrics()+"lady: "+emergencyRoom.isObstetricsAndGynecology()+"num: "+emergencyRoom.getNumber());
		}

	
	@Override
	public void setDeleteemergencyRoom(int number) {
		String SQL="delete from emergencyroom where num=?";
		this.template.update(SQL,number);
		
	}

	//ajax
	@Override
	public void deleteByNumber(int number) {
		String SQL="delete from emergencyroom where num=?";
		this.template.update(SQL,number);
		System.out.println("deleteByNumber SQL = " +SQL+number );
	}

}
