package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

<<<<<<< HEAD
import javax.sql.DataSource;

import com.springmvc.DTO.emergencyRoom;

import org.springframework.beans.factory.annotation.Autowired;
=======
import com.springmvc.DTO.emergencyRoom;
>>>>>>> 878c28593c852c6fe9dbdcad05f7eb3913744ffb
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class EmergencyRoomRepositoryImpl implements EmergencyRoomRepository {

	private List<emergencyRoom> listOfRooms = new ArrayList<emergencyRoom>();
	private JdbcTemplate template;
	
<<<<<<< HEAD
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template= new JdbcTemplate(dataSource);
	}
	
	public EmergencyRoomRepositoryImpl() {
		
		System.out.println("EmergencyRoomRepositoryImpl: 진입");
		
		System.out.println("EmergencyRoomRepositoryImpl: listOfRooms=" + listOfRooms);
		
		return ;
=======
	public EmergencyRoomRepositoryImpl() {
		emergencyRoom room1 = new emergencyRoom(1,"창원병원","양덕동17번길3");
		room1.setDistance(10);    //거리 (Km)
		room1.setNumOfBad(5);   //침상수
		room1.setTravelTime("60"); //이동시간(분)
		room1.setObstetricsAndGynecology(false); //산부인과
		room1.setPediatrics(false);   //소아과
		
		emergencyRoom room2 = new emergencyRoom(1,"창원산부인과","팔용동10번길1");
		room2.setDistance(5);    //거리(Km)
		room2.setNumOfBad(5);   //침상수
		room2.setTravelTime("30"); //이동시간(분)
		room2.setObstetricsAndGynecology(true); //산부인과
		room2.setPediatrics(true);   //소아과
		
		emergencyRoom room3 = new emergencyRoom(1,"삼성종합병원","팔용동10번길1");
		room3.setDistance(7);    //거리(Km)
		room3.setNumOfBad(10);   //침상수
		room3.setTravelTime("45"); //이동시간(분)
		room3.setObstetricsAndGynecology(true); //산부인과
		room3.setPediatrics(true);   //소아과
		
		listOfRooms.add(room1);
		listOfRooms.add(room2);
		listOfRooms.add(room3);
		
>>>>>>> 878c28593c852c6fe9dbdcad05f7eb3913744ffb
	}
	
	@Override
	public List<emergencyRoom> getALLemergencyRoomList() {
<<<<<<< HEAD
		System.out.println("getALLemergencyRoomList: 진입");
		
		String SQL = "select * from emergencyroom";
		
		List<emergencyRoom> listOfRooms = template.query(SQL,new EmergencyRoomRowMapper());
		
		System.out.println("getALLemergencyRoomList  listOfRooms= " +listOfRooms);
=======
	//	String SQL = "select * from emergencyRoom";
		
	//	List<emergencyRoom> listOfRooms = template.query(SQL,new EmergencyRoomRowMapper());
		System.out.println("EmergencyRoomRepositoryImpl 진입 ");
		System.out.println("getALLemergencyRoomList 진입 " +listOfRooms);
>>>>>>> 878c28593c852c6fe9dbdcad05f7eb3913744ffb
		 
		return listOfRooms;
	}

	@Override
<<<<<<< HEAD
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
=======
	public List<emergencyRoom> getemergencyRoomListByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<emergencyRoom> getemergencyRoomListByFilter(Map<String, List<String>> filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public emergencyRoom getBookById(String roomId) {
		// TODO Auto-generated method stub
		return null;
>>>>>>> 878c28593c852c6fe9dbdcad05f7eb3913744ffb
	}

	@Override
	public void setNewemergencyRoom(emergencyRoom emergencyRoom) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpdateemergencyRoomk(emergencyRoom emergencyRoom) {
		// TODO Auto-generated method stub

	}

<<<<<<< HEAD
	
	
	@Override
	public void setDeleteemergencyRoom(int number) {
		// TODO Auto-generated method stub
		
	}

	
=======
	@Override
	public void setDeleteemergencyRoom(String roomId) {
		// TODO Auto-generated method stub

	}

>>>>>>> 878c28593c852c6fe9dbdcad05f7eb3913744ffb
}
