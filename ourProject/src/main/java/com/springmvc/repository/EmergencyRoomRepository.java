package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
 
import com.springmvc.DTO.emergencyRoom;

public interface EmergencyRoomRepository    {
	List<emergencyRoom> getALLemergencyRoomList(); //ok

	List<emergencyRoom> getemergencyRoomListByAddress(String category);
	List<emergencyRoom> getemergencyRoomListByChange(String ischanged);
	emergencyRoom getemergencyRoomByNum(int number);
	void setNewemergencyRoom(emergencyRoom emergencyRoom);
	void setUpdateemergencyRoom(emergencyRoom emergencyRoom);
	void setDeleteemergencyRoom(int number);

	public void deleteByNumber(int number); //ajax


}
