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

	public EemergencyServiceImpl() {
		
		return ;
	}
	
	@Override
	public List<emergencyRoom> getALLemergencyRoomList() {
		// TODO Auto-generated method stub
		System.out.println("EemergencyServiceImpl 진입");
		return emergencyRoomRepository.getALLemergencyRoomList();
	}

	@Override
	public List<emergencyRoom> getemergencyRoomListByAddress(String address) {
		List<emergencyRoom> roomsByAddress = emergencyRoomRepository.getemergencyRoomListByAddress(address);
		
		return roomsByAddress;
	}

	@Override
	public List<emergencyRoom> getemergencyRoomListByChange(String ischanged) {

		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public emergencyRoom getemergencyRoomkByNum(int number) {
	// TODO Auto-generated method stub
		return null;
	}

	@Override
	public emergencyRoom getRoomByNumber(int number) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setNewemergencyRoom(emergencyRoom emergencyRoom) {
	
		emergencyRoomRepository.setNewemergencyRoom(emergencyRoom);
		
	}

	@Override
	public void setUpdateemergencyRoomk(emergencyRoom emergencyRoom) {
		System.out.println("130.EemergencyServiceImpl setUpdateemergencyRoomk: 진입");
		emergencyRoomRepository.setUpdateemergencyRoomk(emergencyRoom);
		
	}

	@Override
	public void setDeleteemergencyRoom(int number) {
		System.out.println("140.EemergencyServiceImpl setDeleteemergencyRoom: 진입");
		emergencyRoomRepository.setDeleteemergencyRoom(number);
		
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
	
}
