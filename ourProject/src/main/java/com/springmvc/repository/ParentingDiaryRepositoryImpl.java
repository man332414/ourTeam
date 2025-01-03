package com.springmvc.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.DTO.parentingDiary;

@Repository
public class ParentingDiaryRepositoryImpl implements ParentingDiaryRepository {

	private List<parentingDiary> diaryOfLists = new ArrayList<>();
	private JdbcTemplate template;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template= new JdbcTemplate(dataSource);
	}

	public ParentingDiaryRepositoryImpl() {

		System.out.println("ParentingDiaryRepositoryImpl: 진입");

		System.out.println("ParentingDiaryRepositoryImpl: diaryOfLists=" + diaryOfLists);

		return ;
	}


	@Override
	public List<parentingDiary> getALLparentingDiary(String userId) {

		System.out.println("ParentingDiaryRepositoryImpl 진입 ");

		System.out.println("getALLparentingDiary: 진입");

		String SQL = "select * from parentingDiary where userId=?";

		System.out.println("getALLparentingDiary 진입 SQL= " + SQL);
		List<parentingDiary> diaryOfLists = template.query(SQL, new Object[] {userId}, new ParentingDiaryRowMapper());

		System.out.println("getALLparentingDiary  diaryOfLists= " + diaryOfLists);

		return diaryOfLists;
	}

	@Override
	public parentingDiary getparentingDiaryById(int id) {

		System.out.println("getparentingDiaryById: 진입" + id );
		parentingDiary diaryInfo = null;

		String SQL = "select count(*) from parentingDiary where id = ?";
		int rowCount = template.queryForObject(SQL,Integer.class, id);
		System.out.println("30.PRI getparentingDiaryById: rowCount ="+rowCount);
		if(rowCount!=0) {
			SQL = "select * from parentingDiary where id =?";
			diaryInfo=template.queryForObject(SQL, new Object[] {id},new ParentingDiaryRowMapper());
		}

		System.out.println("getparentingDiaryById 진입 SQL= " + SQL);

	    if(diaryInfo == null) {
				System.out.println("에러입니다 " + SQL);
		}

		System.out.println("getparentingDiaryById  parentingDiary= " + diaryInfo);
		return diaryInfo;
	}

	@Override
	public void setNewparentingDiary(parentingDiary parentingDiary) {
		System.out.println("ERI setNewparentingDiary 진입 "+ parentingDiary);
			String SQL = "INSERT INTO parentingDiary VALUES(?,?,?,?,?,?,?)";
			System.out.println("insert = " + SQL);
			System.out.println("getToday() = " + parentingDiary.getToday());
			System.out.println("getWeather() = " + parentingDiary.getWeather());
			System.out.println("getMyMood() = " + parentingDiary.getMyMood());
			System.out.println("getDiaryText() = " + parentingDiary.getDiaryText());
			System.out.println("getFileName() = " + parentingDiary.getFileName());

			try {
		        // LocalDateTime을 Timestamp로 변환
		        LocalDateTime today = parentingDiary.getToday();
		        Timestamp timestamp = Timestamp.valueOf(today);

		        // 데이터베이스에 데이터 삽입
		        template.update(SQL, null, timestamp, parentingDiary.getWeather(),
		                parentingDiary.getMyMood(), parentingDiary.getDiaryText(), parentingDiary.getFileName(), parentingDiary.getUserId());
		    } catch (Exception e) {
		        e.printStackTrace(); // 예외 처리
		    }

		}

	@Override
	public void setUpdateparentingDiary(parentingDiary parentingDiary) {
		System.out.println("PRI setUpdateparentingDiary 진입 "+ parentingDiary);

		String SQL = "UPDATE parentingDiary SET today = ?, weather = ?, myMood = ?, diaryText = ?, fileName = ?  where id = ? ";
        template.update(SQL, parentingDiary.getToday(),parentingDiary.getWeather(), parentingDiary.getMyMood(), parentingDiary.getDiaryText(), parentingDiary.getFileName(), parentingDiary.getId());

		System.out.println("ERI setUpdateparentingDiary SQL2= "+ SQL);
		System.out.println("sql= "+"날씨: "+parentingDiary.getWeather()+parentingDiary.getMyMood());
		}

	//ajax
	@Override
	public void deleteById(int id) {
		String SQL="delete from parentingDiary where id=?";
		this.template.update(SQL,id);
		System.out.println("deleteById SQL = " +SQL+id );
	}

}
