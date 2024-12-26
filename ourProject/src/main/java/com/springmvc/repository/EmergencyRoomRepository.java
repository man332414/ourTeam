package com.springmvc.repository;

import java.util.List;

import com.springmvc.DTO.emergencyRoom;

public interface EmergencyRoomRepository    {
	List<emergencyRoom> getALLemergencyRoomList(String sort); //ok
	List<emergencyRoom> searchEmergencyRooms(String keyword,String sort); // 검색 메서드 추가
	
	List<emergencyRoom> getemergencyRoomListByAddress(String category);
	List<emergencyRoom> getemergencyRoomListByChange(String ischanged);
	emergencyRoom getemergencyRoomByNum(int number);
	void setNewemergencyRoom(emergencyRoom emergencyRoom);
	void setUpdateemergencyRoom(emergencyRoom emergencyRoom);
	void setDeleteemergencyRoom(int number);

	public void deleteByNumber(int number); //ajax


}
