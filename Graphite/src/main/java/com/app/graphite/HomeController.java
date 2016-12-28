package com.app.graphite;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		//IndexQuery query = new IndexQueryBuilder().withIndexName("").build();
		boolean isExist = elasticsearchTemplate.typeExists("CDB", "STOREDATA");
		
		model.addAttribute("isExist", isExist );
				
		return "home";
	}
	
	@RequestMapping(value = "/sachin", method = RequestMethod.GET)
	public String homee(Locale locale, Model model) {
		logger.info("Welcome Sachin", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", "Hello bey" );
		
		return "home";
	}
	
}
