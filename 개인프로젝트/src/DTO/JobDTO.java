package DTO;


//직무 테이블 DTO입니다.
public class JobDTO {
	private int 직무_ID;
	private String 직무_이름;
	private String 직무_내용;
	public int get직무_ID() {
		return 직무_ID;
	}
	public void set직무_ID(int 직무_ID) {
		this.직무_ID = 직무_ID;
	}
	public String get직무_이름() {
		return 직무_이름;
	}
	public void set직무_이름(String 직무_이름) {
		this.직무_이름 = 직무_이름;
	}
	public String get직무_내용() {
		return 직무_내용;
	}
	public void set직무_내용(String 직무_내용) {
		this.직무_내용 = 직무_내용;
	}
}
