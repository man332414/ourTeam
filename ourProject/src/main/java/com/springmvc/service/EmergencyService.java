package com.springmvc.service;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Map;
import java.util.Set;
>>>>>>> 878c28593c852c6fe9dbdcad05f7eb3913744ffb

import com.springmvc.DTO.emergencyRoom;

public interface EmergencyService {
	
	List<emergencyRoom> getALLemergencyRoomList(); //ok
<<<<<<< HEAD
	List<emergencyRoom> getemergencyRoomListByAddress(String address);
	List<emergencyRoom> getemergencyRoomListByChange(String ischanged);
	emergencyRoom getemergencyRoomkByNum(int number);
=======
	List<emergencyRoom> getemergencyRoomListByCategory(String category);
	Set<emergencyRoom> getemergencyRoomListByFilter(Map<String,List<String>> filter);
	emergencyRoom getRoomByNumber(int number);
>>>>>>> 878c28593c852c6fe9dbdcad05f7eb3913744ffb
	void setNewemergencyRoom(emergencyRoom emergencyRoom);
	void setUpdateemergencyRoomk(emergencyRoom emergencyRoom);
	void setDeleteemergencyRoom(int number);

}
