package DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//발전 테이블 DTO 클래스 입니다.롬복이 없는 경우 getter, setter를 꼭 설정해주세요
public class 발전DTO {
	private int 발전소_ID;
	private String 측정_날짜;
	private int 발전량;
	
}
