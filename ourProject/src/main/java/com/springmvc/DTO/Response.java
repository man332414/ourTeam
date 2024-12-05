package com.springmvc.DTO;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Response {
    @JacksonXmlProperty(localName = "header")
    private Header header;

    @JacksonXmlProperty(localName = "body")
    private Body body;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

    // Getters and Setters
}

class Header {
    private String resultCode;
    private String resultMsg;
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

    // Getters and Setters
}

class Body {
    private Items items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public int getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(int numOfRows) {
		this.numOfRows = numOfRows;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

    // Getters and Setters
}

class Items {
    private List<Item> item;

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

    // Getters and Setters
}

class Item {
    private String addr;
    private String clCd;
    private String clCdNm;
    private int cmdcGdrCnt;
    // Add other fields as needed
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getClCd() {
		return clCd;
	}
	public void setClCd(String clCd) {
		this.clCd = clCd;
	}
	public String getClCdNm() {
		return clCdNm;
	}
	public void setClCdNm(String clCdNm) {
		this.clCdNm = clCdNm;
	}
	public int getCmdcGdrCnt() {
		return cmdcGdrCnt;
	}
	public void setCmdcGdrCnt(int cmdcGdrCnt) {
		this.cmdcGdrCnt = cmdcGdrCnt;
	}

    // Getters and Setters
}
