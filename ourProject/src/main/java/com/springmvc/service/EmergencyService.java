package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.DTO.emergencyRoom;

public interface EmergencyService {
	
	List<emergencyRoom> getALLemergencyRoomList(); //ok
	List<emergencyRoom> getemergencyRoomListByCategory(String category);
	Set<emergencyRoom> getemergencyRoomListByFilter(Map<String,List<String>> filter);
	emergencyRoom getRoomByNumber(int number);
	void setNewemergencyRoom(emergencyRoom emergencyRoom);
	void setUpdateemergencyRoomk(emergencyRoom emergencyRoom);
	void setDeleteemergencyRoom(int number);

}
