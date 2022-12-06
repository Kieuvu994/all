package test;

import java.util.List;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class RestfulTest {
	public static void main(String[] args) throws Exception {
		System.out.println("========getForObject String Start==============");
		RestTemplate restTemplate = new RestTemplate();
		String resultStr = restTemplate.getForObject(
				"http://localhost:8080/samplerestful-server/restful/glue/restful-service/data/30", String.class);
		System.out.println("result:::::" + resultStr);
		System.out.println("========getForObject String End==============");
		System.out.println("========getForObject Map Start==============");
		Map<?, ?> result = restTemplate.getForObject(
				"http://localhost:8080/samplerestful-server/restful/glue/restful-service/data/30", Map.class);
		System.out.println("result:::::" + result);
		List<Map> resultList = (List<Map>) result.get("search_result");
		for (int i = 0; i < resultList.size(); i++) {
			Map emp = resultList.get(i);
			System.out.println(emp);
		}
		System.out.println("========getForObject Map End==============");
	}
}
