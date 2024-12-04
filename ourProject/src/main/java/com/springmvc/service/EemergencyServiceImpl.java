package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.DTO.emergencyRoom;
import com.springmvc.repository.EmergencyRoomRepository;

@Service
public class EemergencyServiceImpl implements EmergencyService {
	
	@Autowired
	private EmergencyRoomRepository emergencyRoomRepository;

	@Override
	public List<emergencyRoom> getALLemergencyRoomList() {
		// TODO Auto-generated method stub
		System.out.println("EemergencyServiceImpl 진입");
		return emergencyRoomRepository.getALLemergencyRoomList();
	}

	@Override
<<<<<<< HEAD
	public List<emergencyRoom> getemergencyRoomListByAddress(String address) {
		List<emergencyRoom> roomsByAddress = emergencyRoomRepository.getemergencyRoomListByAddress(address);
		
		return roomsByAddress;
	}

	@Override
	public List<emergencyRoom> getemergencyRoomListByChange(String ischanged) {
=======
	public List<emergencyRoom> getemergencyRoomListByCategory(String category) {
>>>>>>> 878c28593c852c6fe9dbdcad05f7eb3913744ffb
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD


	@Override
	public emergencyRoom getemergencyRoomkByNum(int number) {
=======
	@Override
	public Set<emergencyRoom> getemergencyRoomListByFilter(Map<String, List<String>> filter) {
>>>>>>> 878c28593c852c6fe9dbdcad05f7eb3913744ffb
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD

=======
	@Override
	public emergencyRoom getRoomByNumber(int number) {
		// TODO Auto-generated method stub
		return null;
	}
>>>>>>> 878c28593c852c6fe9dbdcad05f7eb3913744ffb

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
