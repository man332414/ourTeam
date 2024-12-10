package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.springmvc.DTO.buyCheckList;

import org.springframework.jdbc.core.RowMapper;

public class BuyCheckListRowMapper implements RowMapper<buyCheckList> {

	@Override
	public buyCheckList mapRow(ResultSet rs, int rowNum) throws SQLException {
		 
		buyCheckList list = new buyCheckList();
		
		list.setNum(rs.getInt(1));
		list.setUseCategory(rs.getString(2));
		list.setGradeCategory(rs.getString(3));
		list.setProductName(rs.getString(3));
		list.setProductPrice(rs.getInt(5));
		list.setQuantity(rs.getInt(6));
		list.setAcquisitionPath(rs.getString(7));
		list.setAcquisitionMethod(rs.getString(8));
		
		return list;
	}

	 
}
