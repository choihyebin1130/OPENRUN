package com.openrun.ticket.vo;

import java.sql.Date;

public class SelectVO {
	
	private int ticketNo;
	private int categoryNo;
	private String ticketName;
	private String body;
	private Date regDate;

	public NoticeVO() {
		
	}

	public NoticeVO(int noticeNo, int categoryNo, String category, String title, String body, Date regDate) {
		this.noticeNo = noticeNo;
		this.categoryNo = categoryNo;
		this.category = category;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
	}

	/* 상품 id */
	private int bookId;
	
	/* 상품 이름 */
	private String bookName;
	
	/* 카테고리 이름 */
	private String cateName;
	
	private double ratingAvg;	
	
	/* 상품 이미지 */
	private List<AttachImageVO> imageList;
}
