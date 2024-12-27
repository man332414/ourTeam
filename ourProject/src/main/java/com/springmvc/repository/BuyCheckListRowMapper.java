package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.DTO.buyCheckList;

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
		list.setFileName(rs.getString(9)); // 파일 이름을 저장

		return list;
	}


}
