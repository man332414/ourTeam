package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.DTO.emergencyRoom;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class EmergencyRoomRepositoryImpl implements EmergencyRoomRepository {

	private List<emergencyRoom> listOfRooms = new ArrayList<emergencyRoom>();
	private JdbcTemplate template;
	
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
		
	}
	
	@Override
	public List<emergencyRoom> getALLemergencyRoomList() {
	//	String SQL = "select * from emergencyRoom";
		
	//	List<emergencyRoom> listOfRooms = template.query(SQL,new EmergencyRoomRowMapper());
		System.out.println("EmergencyRoomRepositoryImpl 진입 ");
		System.out.println("getALLemergencyRoomList 진입 " +listOfRooms);
		 
		return listOfRooms;
	}

	@Override
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
	public void setDeleteemergencyRoom(String roomId) {
		// TODO Auto-generated method stub

	}

}
