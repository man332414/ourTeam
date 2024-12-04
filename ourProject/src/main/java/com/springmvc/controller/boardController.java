package com.springmvc.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.DAO.service.boardService;
import com.springmvc.DTO.Board;

@Controller
@RequestMapping("/board")
public class boardController
{
	@Autowired
	private boardService boardService;	
	
	@GetMapping
	public ResponseEntity<String> connApi()
	{
		System.out.println("boardController 입장");
		
		List<Board> apiBoards = boardService.fatchBoardFormApi();
		
		boardService.saveBoardsFromJson(apiBoards);
		
		return ResponseEntity.ok("동기화 완료");
		
//		//step 1 url 작성하기
//		String reqUrl = "https://apis.data.go.kr/1371037/ktvBoard/noticeList?"
//				+ "serviceKey=%2FRQc%2BsltwaX9aUxJzxpKaOzbNQg18j1Sv56GlvnpzROKDRqSvRjDX9hcg%2FlcEcB%2FN%2F9zUZpg708yaYcsfkfAXg%3D%3D&"
//				+ "numOfRows=10&"
//				+ "pageNo=1&"
//				+ "orderBy=regDate&"
//				+ "startDate=20200101";
//		//step 2 커넥션 생성
//		try
//		{
//			URL url = new URL(reqUrl);
//			HttpURLConnection con = (HttpURLConnection)url.openConnection();
//			// step 3 데이터 수신하기
//			int responseCode = con.getResponseCode();
//			System.out.println("응답코드" + responseCode);
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
//			// step 4 수신한 데이터 문자열
//			String line;
//			StringBuffer data = new StringBuffer();
//			
//			while((line = br.readLine()) != null)
//			{
//				data.append(line);
//			}
//			br.close();
//			System.out.println("뭐 들었나? : "+data);
//			
//			// step 5 데이터 json 객체로 변환하기
//			JSONTokener tok = new JSONTokener(data.toString());
//			JSONObject obj = new JSONObject(tok);
//			JSONObject response = obj.getJSONObject("response");
//			JSONObject body = response.getJSONObject("body");
//			JSONObject items = body.getJSONObject("items");
//			JSONArray item = items.getJSONArray("item");
//			
//			JSONObject first = (JSONObject)item.get(0);
//			Board bd = new Board();
//			bd.setSubject(first.getString("title"));
//			bd.setDate(first.getString("registDate"));
//			bd.setCategory(first.getString("boardName"));
//			
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
	}
	
	@GetMapping
	public String readAllBoards(Model model)
	{
		List<Board> boards = boardService.getAllBoards();
		
		model.addAttribute("boards",boards);
		
		return "board";
	}
}
