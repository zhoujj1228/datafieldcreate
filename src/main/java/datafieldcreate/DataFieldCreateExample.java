package datafieldcreate;


import util.FastJsonUtil;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping("/datafieldcreate")
public class DataFieldCreateExample {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DataFieldCreateExample.class, args);
	}

	@RequestMapping("/getDataField")
	String initDataField(String domainName) {
		DataField dataField = DataFieldParser.dataFieldMap.get(domainName);

		String strByObject = FastJsonUtil.getStrByObject(dataField);
		System.out.println(strByObject);

		return strByObject;
	}
	
	@RequestMapping("/add")
	public String add(String domain) {
		System.out.println(domain);
		return "add";
	}
}

