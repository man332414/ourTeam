package com.springmvc.service;

import java.util.List;

import com.springmvc.DTO.emergencyRoom;

public interface EmergencyService {
	
	List<emergencyRoom> getALLemergencyRoomList(); //ok
	List<emergencyRoom> getemergencyRoomListByAddress(String address);
	List<emergencyRoom> getemergencyRoomListByChange(String ischanged);
	emergencyRoom getemergencyRoomkByNum(int number);
	void setNewemergencyRoom(emergencyRoom emergencyRoom);
	void setUpdateemergencyRoomk(emergencyRoom emergencyRoom);
	void setDeleteemergencyRoom(int number);

}
