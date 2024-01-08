package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.empService;

public class insert_발전_데이터 {
	public static void main(String[] args) {
		//해당 코드는 DB에 발전 데이터를 넣기 위한 코드 입니다.
		//sleep을 설정하지 않을 시 입력 속도가 빨라서 에러가 발생할 수 있습니다.
		//따라서 sleep을 설정하여 세팅하시면 됩니다. 집에 있는 컴퓨터로 테스트한 결과 최적의 속도는 50ms입니다.
		
		//id는 발전소 id를 넣어주시면 됩니다.
		String id = "9";
		// max는 해당 발전소의 최대 발전량을 넣어주시면 됩니다.
		double max = 80;
		// flog_save가 true이면 csv로 자동 생성되고 DB에 업로드는 되지 않습니다.
		// flog_save가 false이면 csv로 생성되지 않고 DB에 바로 업로드 됩니다.
		boolean flog_save = true;
		
		File csv = new File("src/util/"+id+"번 발전소.csv");

		empService service = new empService();
		
		Calendar date =  Calendar.getInstance();
		date.set(2022, 0,1,0,0,0);
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String str_date=date_format.format(date.getTime());
		//new FileWriter(csv,true) => true로 설정되면 해당 csv에 있는 파일을 이어서 작성됩니다.
		//처음 해당 코드를 실행하면 true로 설정하지 말고 false로 설정하여 덮어쓰기로 설정하시면 됩니다.
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(csv,true));
				BufferedReader	br=Files.newBufferedReader(Paths.get("src/util/dataset.csv"))
			){
			
			String line = "";
			while((line = br.readLine()) != null) {
				List<String> tmpList = new ArrayList<String>();
				String array[] = line.split(",");
				tmpList = Arrays.asList(array);
				str_date=date_format.format(date.getTime());
				//200 최대
				System.out.println(str_date+" "+tmpList.get(2));

				if(flog_save) {
				String wr_data = id + "," + str_date + "," +
						         String.valueOf(Double.parseDouble(tmpList.get(2))*max/200);
				
				bw.write(wr_data);
				bw.newLine();
				}else {
					service.발전_insert_service(id,str_date,
							String.valueOf(Double.parseDouble(tmpList.get(2))*max/200));
					try {
					Thread.sleep(50);} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				date.add(Calendar.HOUR, 1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
