package com.springmvc.DAO.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.DAO.repository.boardRepository;
import com.springmvc.DTO.Board;

@Service
public class boardServiceImpl implements boardService 
{
	@Autowired
	private boardRepository boardRepository;
		
	@Override
	public List<Board> getAllBoards(int currentPage, int numberOfRows) 
	{
		List<Board> boards = boardRepository.getAllBoards(currentPage, numberOfRows);
		return boards;
	}
	
	public void saveAll()
	{
		System.out.println("boardService.saveAll 입장");
		List<Board> boardsIntoDB = new ArrayList<Board>();
		
		//step 1 url 작성하기
		String reqUrl = "https://apis.data.go.kr/1371037/ktvBoard/noticeList?"
				+ "serviceKey=%2FRQc%2BsltwaX9aUxJzxpKaOzbNQg18j1Sv56GlvnpzROKDRqSvRjDX9hcg%2FlcEcB%2FN%2F9zUZpg708yaYcsfkfAXg%3D%3D&"
				+ "numOfRows=100&"
				+ "pageNo=1&"
				+ "orderBy=regDate&"
				+ "startDate=20150101";
//		요청변수(Request Parameter)
//		serviceKey	//	-		//공공데이터포털 발급 인증 키
//		numOfRows	//	1		//한페이지 결과 수
//		pageNo		//	10		//페이지 번호
//		orderBy		//	viewCnt	//정렬 기준(등록일:regDate, 조회수:viewCnt)
//		startDate	//	20240101//시작일(등록일[registDate] 기준, 미 입력 시 종료일 이전 30일)
//		endDate		//	20240831//종료일(등록일[registDate] 기준, 미 입력 시 오늘날짜)
//		title		//	안내		//제목
		//step 2 커넥션 생성
		try
		{
			URL url = new URL(reqUrl);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			// step 3 데이터 수신하기
			int responseCode = con.getResponseCode();
			System.out.println("응답코드 : " + responseCode);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			// step 4 수신한 데이터 문자열
			String line;
			StringBuffer data = new StringBuffer();
			
			while((line = br.readLine()) != null)
			{
				data.append(line);
			}
			br.close();
			System.out.println("뭐 들었나? : "+data);
			
			// step 5 데이터 json 객체로 변환하기
			JSONTokener tok = new JSONTokener(data.toString());
			JSONObject obj = new JSONObject(tok);
			JSONObject response = obj.getJSONObject("response");
			JSONObject body = response.getJSONObject("body");
			JSONObject items = body.getJSONObject("items");
			JSONArray item = items.getJSONArray("item");
			
			int i = 0;
			int cnt = 0;
			while(true)
			{
				JSONObject first = (JSONObject)item.get(i);
				if(first == null || first.isEmpty())
				{
					System.out.println("반복문 나가기 : " + first);
					break;				
				}
				Board bd = new Board();
				boolean isBoardList = boardRepository.isBoardList(first.getString("title"));
				if(isBoardList) 
				{
					cnt++;
					System.out.println(i+1 + "번 컨텐츠에서 중복이 발생했습니다. 현재까지 "+ cnt + "건 중복");
					i++;
					continue;
				}
				bd.setTitle(first.getString("title"));
				bd.setDate(first.getString("registDate"));
				bd.setCategory(first.getString("boardName"));
				bd.setContent(first.getString("content"));
				
				System.out.println("잘 넣었나 보자 : " + bd.getTitle());
				boardsIntoDB.add(bd);
				i++;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		boardRepository.saveAll(boardsIntoDB);
	}

	@Override
	public Board getOneBoard(Integer number)
	{
		Board board = boardRepository.getOneBoard(number);
		return board;
	}

	@Override
	public List<Map<String, Object>> getSearchResult(Map<String, String> searchFor, int currentPage, int numberOfRows) 
	{
		List<Map<String, Object>> searchResult = boardRepository
				.getSearchResult(searchFor , currentPage, numberOfRows);
		return searchResult;
	}

	@Override
	public int getTotalPage(int numberOfRows) 
	{
		int totalPage = boardRepository.getTotalPage(numberOfRows);
		return totalPage;
	}

	@Override
	public void deleteBoard(List<Integer> number)
	{
		boardRepository.deleteBoard(number);
	}

	@Override
	public void updateBoard(Board board)
	{
		boardRepository.updateBoard(board);
	}

	@Override
	public void addBoard(Board board) 
	{
		boardRepository.addBoard(board);
	}
	
	public int getTotalPageForSeach(Map<String, String> searchFor, int numberOfRows)
	{
		return boardRepository.getTotalPageForSeach(searchFor, numberOfRows);
	}
	
	// 오버로딩
	@Override
	public int getTotalPageForSeach(String searchFor, int numberOfRows) {
		// TODO Auto-generated method stub
		return boardRepository.getTotalPageForSeach(searchFor, numberOfRows);
	}

	@Override
	public List<Board> getSearchedBoards(String searchFor, int currentPage, int numberOfRows) 
	{
//		System.out.println("boardServiceImpl.getSearchedBoards() 입장");
		List<Board> boards = boardRepository.getSearchedBoards(searchFor,currentPage,numberOfRows);
		return boards;
	}

}
