package com.springmvc.DAO.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springmvc.DAO.repository.boardRepository;
import com.springmvc.DTO.Board;

public class boardServiceImpl implements boardService 
{
	@Autowired
	private boardRepository boardRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Board> getAllBoards() 
	{
		List<Board> boards = boardRepository.getAllBoards();
		return boards;
	}

	@Override
	public List<Board> fatchBoardFormApi() 
	{
		//step 1 url 작성하기
		String reqUrl = "https://apis.data.go.kr/1371037/ktvBoard/noticeList?"
				+ "serviceKey=%2FRQc%2BsltwaX9aUxJzxpKaOzbNQg18j1Sv56GlvnpzROKDRqSvRjDX9hcg%2FlcEcB%2FN%2F9zUZpg708yaYcsfkfAXg%3D%3D&"
				+ "numOfRows=10&"
				+ "pageNo=1&"
				+ "orderBy=regDate&"
				+ "startDate=20200101";
		
		ResponseEntity<List<Board>> response = restTemplate.exchange(reqUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Board>>() {});
		
		return response.getBody();
	}

	@Override
	public void saveBoardsFromJson(List<Board> apiBoards) 
	{
		List<Board> boards = apiBoards.stream().map(Board::toEntity).collect(Collectors.toList());
		
		boardRepository.saveAll(boards);
	}

}
