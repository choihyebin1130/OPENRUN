package com.openrun.ticket.seller;

//판매자Vo
public class SellerVo {

	int seller_no; //판매자 회원번호
	String s_level ; //판매자 등급
	String s_id; //판매자 아이디
	String s_pw; //판매자 비밀번호
	String s_business_name; //사업자명
	int s_business_reg_no; //사업자등록번호
	String s_address; //판매자 주소
	int s_phone; //판매자 휴대폰번호
	String s_email; //판매자 이메일
	String s_bank_name; //판매자 은행명
	int s_account_no; //판매자 계좌번호
	String s_join_date;// 판매자 회원가입일자
	
	public int getSeller_no() {
		return seller_no;
	}
	public void setSeller_no(int seller_no) {
		this.seller_no = seller_no;
	}
	public String getS_level() {
		return s_level;
	}
	public void setS_level(String s_level) {
		this.s_level = s_level;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_pw() {
		return s_pw;
	}
	public void setS_pw(String s_pw) {
		this.s_pw = s_pw;
	}
	public String getS_business_name() {
		return s_business_name;
	}
	public void setS_business_name(String s_business_name) {
		this.s_business_name = s_business_name;
	}
	public int getS_business_reg_no() {
		return s_business_reg_no;
	}
	public void setS_business_reg_no(int s_business_reg_no) {
		this.s_business_reg_no = s_business_reg_no;
	}
	public String getS_address() {
		return s_address;
	}
	public void setS_address(String s_address) {
		this.s_address = s_address;
	}
	public int getS_phone() {
		return s_phone;
	}
	public void setS_phone(int s_phone) {
		this.s_phone = s_phone;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public String getS_bank_name() {
		return s_bank_name;
	}
	public void setS_bank_name(String s_bank_name) {
		this.s_bank_name = s_bank_name;
	}
	public int getS_account_no() {
		return s_account_no;
	}
	public void setS_account_no(int s_account_no) {
		this.s_account_no = s_account_no;
	}
	public String getS_join_date() {
		return s_join_date;
	}
	public void setS_join_date(String s_join_date) {
		this.s_join_date = s_join_date;
	}
}
