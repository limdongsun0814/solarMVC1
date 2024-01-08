package DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
//@Getter
//@Setter
//@NoArgsConstructor
//직원 테이블 DTO 클래스 입니다.롬복이 없는 경우 getter, setter를 꼭 설정해주세요
public class empDTO {
	private int 직원_ID;
	private String 이름;
	private String 이메일;
	private String 전화번호;
	private String 부서_이름;
	private String login_ID;
	private String login_password;
	private String 직무_이름;
	private String 퇴직유무;
	
	public int get직원_ID() {
		return 직원_ID;
	}
	public void set직원_ID(int 직원_ID) {
		this.직원_ID = 직원_ID;
	}
	public String get이름() {
		return 이름;
	}
	public void set이름(String 이름) {
		this.이름 = 이름;
	}
	public String get이메일() {
		return 이메일;
	}
	public void set이메일(String 이메일) {
		this.이메일 = 이메일;
	}
	public String get전화번호() {
		return 전화번호;
	}
	public void set전화번호(String 전화번호) {
		this.전화번호 = 전화번호;
	}
	public String get부서_이름() {
		return 부서_이름;
	}
	public void set부서_이름(String 부서_이름) {
		this.부서_이름 = 부서_이름;
	}
	public String getLogin_ID() {
		return login_ID;
	}
	public void setLogin_ID(String login_ID) {
		this.login_ID = login_ID;
	}
	public String getLogin_password() {
		return login_password;
	}
	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}
	public String get직무_이름() {
		return 직무_이름;
	}
	public void set직무_이름(String 직무_이름) {
		this.직무_이름 = 직무_이름;
	}
	public String get퇴직유무() {
		return 퇴직유무;
	}
	public void set퇴직유무(String 퇴직유무) {
		this.퇴직유무 = 퇴직유무;
	}
	

	
}
