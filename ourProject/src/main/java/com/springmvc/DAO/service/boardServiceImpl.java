package com.springmvc.DAO.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springmvc.DAO.repository.boardRepository;
import com.springmvc.DTO.Board;

@Service
public class boardServiceImpl implements boardService 
{
	@Autowired
	private boardRepository boardRepository;
		
	@Override
	public List<Board> getAllBoards() 
	{
		List<Board> boards = boardRepository.getAllBoards();
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
				+ "startDate=20200101";
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
			while(true)
			{
				JSONObject first = (JSONObject)item.get(i);
				Board bd = new Board();
				bd.setTitle(first.getString("title"));
				bd.setDate(first.getString("registDate"));
				bd.setCategory(first.getString("boardName"));
				bd.setContent(first.getString("content"));
				
				if(first == null || first.isEmpty() || first.isEmpty())
				{
					System.out.println("반복문 나가기 : " + first);
					break;				
				}
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
	public List<Map<String,Object>> getSearchResult(Map<String, String> searchFor) 
	{
		List<Map<String,Object>> searchResult = boardRepository.getSearchResult(searchFor);
		return searchResult;
	}

}
