package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.DTO.buyCheckList;

@Repository
public class BuyCheckListRepositoryImpl implements BuyCheckListRepository {

	private List<buyCheckList> listOfLists = new ArrayList<>();
	private JdbcTemplate template;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template= new JdbcTemplate(dataSource);
	}

	public BuyCheckListRepositoryImpl() {

		System.out.println("buyCheckListRepositoryImpl: 진입");

		System.out.println("buyCheckListRepositoryImpl: listOfLists=" + listOfLists);

		return ;
	}

	@Override
	public List<buyCheckList> getALLbuyCheckList() {

		System.out.println("getALLbuyCheckList: 진입");

		String SQL = "select * from buychecklist";

		System.out.println("getALLbuyCheckList 진입 SQL= " + SQL);
		List<buyCheckList> listOfLists = template.query(SQL,new BuyCheckListRowMapper());

		System.out.println("getALLbuyCheckList  listOfLists= " + listOfLists);


		System.out.println("BuyCheckListRepositoryImpl 진입 ");


		return listOfLists;
	}

	@Override

	public List<buyCheckList> getbuyCheckListByuseCategory(String useCategory) {
		System.out.println("getbuyCheckListByAddress: 진입");

		String SQL = "select * from buyCheckList where useCategory like '%" + useCategory +"%'";
		List<buyCheckList> listsByuseCategory = template.query(SQL,new BuyCheckListRowMapper());

		System.out.println("getbuyCheckListByuseCategory  listsByuseCategory= " + listsByuseCategory);

		return listsByuseCategory;
	}

	@Override
	public List<buyCheckList> getbuyCheckListByChange(String ischanged) {
		System.out.println("getbuyCheckListByChange: 진입");

		String SQL = "select * from buyCheckList where isPediatrics = true"  ;
		List<buyCheckList> roomsByChange = template.query(SQL,new BuyCheckListRowMapper());

		System.out.println("getbuyCheckListByChange  roomsByChange= " + roomsByChange);

		return roomsByChange;
	}

	@Override
	public buyCheckList getbuyCheckListkByNum(int number) {

		System.out.println("getbuyCheckListkByNum: 진입 " + number );
		buyCheckList buyCheckListInfo = null;
	
		String SQL = "select count(*) from buychecklist where num = ?";
		int rowCount = template.queryForObject(SQL,Integer.class, number);
		if(rowCount!=0) {
			SQL = "select * from buychecklist where num =?";
			buyCheckListInfo=template.queryForObject(SQL, new Object[] {number},new BuyCheckListRowMapper());
		}
	
		System.out.println("getbuyCheckListkByNum 진입 SQL= " + SQL);
	
	    if(buyCheckListInfo == null) {
				System.out.println("에러입니다 " + SQL);
		}
	
		System.out.println("getbuyCheckListkByNum  buyCheckList= " + buyCheckListInfo);
		return buyCheckListInfo;
	}

	public List<buyCheckList> getbuyCheckListByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void setNewbuyCheckList(buyCheckList buyCheckList) {

	//	System.out.println("ERI setNewbuyCheckList 진입 "+ buyCheckList);
		String SQL = "INSERT INTO buyCheckList VALUES(?,?,?,?,?,?,?,?,?)";
		System.out.println("insert = " + SQL);

		template.update(SQL,buyCheckList.getNum(),buyCheckList.getUseCategory(),buyCheckList.getGradeCategory(),
				buyCheckList.getProductName(),buyCheckList.getProductPrice(),buyCheckList.getQuantity(),
				buyCheckList.getAcquisitionPath(),buyCheckList.getAcquisitionMethod(), buyCheckList.getFileName());

	}


	@Override
	public void setUpdatebuyCheckList(buyCheckList buyCheckList) {

		System.out.println("ERI setUpdatebuyCheckListk 진입 "+ buyCheckList);

		String SQL = "UPDATE buyCheckList SET hosName = ?, hosaddr = ?, distance = ?, travelTime = ?, numOfBad = ?, isPediatrics = ?, isObstetricsAndGynecology = ?  where num = ? ";
        template.update(SQL, buyCheckList.getUseCategory(), buyCheckList.getGradeCategory(), buyCheckList.getProductName(), buyCheckList.getProductPrice(), buyCheckList.getQuantity(), buyCheckList.getAcquisitionPath(), buyCheckList.getAcquisitionMethod(), buyCheckList.getNum());

		System.out.println("ERI setUpdatebuyCheckListk SQL2= "+ SQL);
		System.out.println("sql= "+"name: "+buyCheckList.getProductName()+buyCheckList.getNum());
		}


	@Override
	public void setDeletebuyCheckList(int number) {
		String SQL="delete from buyCheckList where num=?";
		this.template.update(SQL,number);

	}

	@Override
	public void deleteByNum(int number) {
		String SQL="delete from buychecklist where num=?";
		this.template.update(SQL,number);
		System.out.println("deleteByNum SQL = " +SQL+number );
		
	}



}
