package DTO;

//위치 테이블 DTO 클래스 입니다
public class 위치_DTO {
	private int 발전소_ID;
	private String 건물_이름;
	private int 최대_발전량;
	private String 주소;
	public int get발전소_ID() {
		return 발전소_ID;
	}
	public void set발전소_ID(int 발전소_ID) {
		this.발전소_ID = 발전소_ID;
	}
	public String get건물_이름() {
		return 건물_이름;
	}
	public void set건물_이름(String 건물_이름) {
		this.건물_이름 = 건물_이름;
	}
	public int get최대_발전량() {
		return 최대_발전량;
	}
	public void set최대_발전량(int 최대_발전량) {
		this.최대_발전량 = 최대_발전량;
	}
	public String get주소() {
		return 주소;
	}
	public void set주소(String 주소) {
		this.주소 = 주소;
	}
}
