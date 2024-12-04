package com.springmvc.repository;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Map;
import java.util.Set;
>>>>>>> 878c28593c852c6fe9dbdcad05f7eb3913744ffb

import com.springmvc.DTO.emergencyRoom;

public interface EmergencyRoomRepository {
	List<emergencyRoom> getALLemergencyRoomList(); //ok
<<<<<<< HEAD
	List<emergencyRoom> getemergencyRoomListByAddress(String category);
	List<emergencyRoom> getemergencyRoomListByChange(String ischanged);
	emergencyRoom getemergencyRoomkByNum(int number);
	void setNewemergencyRoom(emergencyRoom emergencyRoom);
	void setUpdateemergencyRoomk(emergencyRoom emergencyRoom);
	void setDeleteemergencyRoom(int number);
=======
	List<emergencyRoom> getemergencyRoomListByCategory(String category);
	Set<emergencyRoom> getemergencyRoomListByFilter(Map<String,List<String>> filter);
	emergencyRoom getBookById(String roomId);
	void setNewemergencyRoom(emergencyRoom emergencyRoom);
	void setUpdateemergencyRoomk(emergencyRoom emergencyRoom);
	void setDeleteemergencyRoom(String roomId);
>>>>>>> 878c28593c852c6fe9dbdcad05f7eb3913744ffb

}
