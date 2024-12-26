package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.DTO.emergencyRoom;

public interface EmergencyService {

	List<emergencyRoom> getALLemergencyRoomList(String sort); //ok
	List<emergencyRoom> searchEmergencyRooms(String keyword, String sort); // 검색 메서드 추가
	List<emergencyRoom> getemergencyRoomListByAddress(String address);
	List<emergencyRoom> getemergencyRoomListByChange(String ischanged);
	emergencyRoom getemergencyRoomByNum(int number);

	List<emergencyRoom> getemergencyRoomListByCategory(String category);
	Set<emergencyRoom> getemergencyRoomListByFilter(Map<String,List<String>> filter);
	emergencyRoom getRoomByNumber(int number);

	public void setNewemergencyRoom(emergencyRoom emergencyRoom);
	public void setUpdateemergencyRoom(emergencyRoom emergencyRoom);
	public void setDeleteemergencyRoom(int number);
	public void deleteRoom(int number) ; //ajax

}
