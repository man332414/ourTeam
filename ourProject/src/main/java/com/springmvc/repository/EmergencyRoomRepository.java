package com.springmvc.repository;

import java.util.List;

import com.springmvc.DTO.emergencyRoom;

public interface EmergencyRoomRepository {
	List<emergencyRoom> getALLemergencyRoomList(); //ok
	List<emergencyRoom> getemergencyRoomListByAddress(String category);
	List<emergencyRoom> getemergencyRoomListByChange(String ischanged);
	emergencyRoom getemergencyRoomkByNum(int number);
	void setNewemergencyRoom(emergencyRoom emergencyRoom);
	void setUpdateemergencyRoomk(emergencyRoom emergencyRoom);
	void setDeleteemergencyRoom(int number);

}
