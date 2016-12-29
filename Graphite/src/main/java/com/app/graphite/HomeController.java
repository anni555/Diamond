package com.app.graphite;

import static org.elasticsearch.common.settings.Settings.settingsBuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.internal.InternalSettingsPreparer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	
	private ElasticsearchTemplate elasticsearchTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws UnknownHostException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Settings settings = InternalSettingsPreparer.prepareSettings(Settings.EMPTY);
		settings = settingsBuilder()
                .put("cluster.name", "elasticsearch")
                .build();
		
		TransportClient.Builder builder = new TransportClient.Builder();
		builder.settings(settings);
		TransportClient tc = builder.build();
		InetAddress adr = InetAddress.getByAddress(new byte[]{(byte)10, (byte)237, (byte)53, (byte)192});
		tc.addTransportAddress(new InetSocketTransportAddress(adr, 9300));
		
		
		
		elasticsearchTemplate = new ElasticsearchTemplate(tc);
		
		
		
		
		//IndexQuery query = new IndexQueryBuilder().withIndexName("").build();
		boolean isExist = elasticsearchTemplate.typeExists("cdb", "storedata");
		
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
