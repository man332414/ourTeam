package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.DTO.emergencyRoom;

public interface EmergencyRoomRepository {
	List<emergencyRoom> getALLemergencyRoomList(); //ok
	List<emergencyRoom> getemergencyRoomListByCategory(String category);
	Set<emergencyRoom> getemergencyRoomListByFilter(Map<String,List<String>> filter);
	emergencyRoom getBookById(String roomId);
	void setNewemergencyRoom(emergencyRoom emergencyRoom);
	void setUpdateemergencyRoomk(emergencyRoom emergencyRoom);
	void setDeleteemergencyRoom(String roomId);

}
