package seriedl;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class SeriedlController {
	 public static void main(String[] args) throws Exception {
	        String crawlStorageFolder = "C:\\Users\\Kean\\Documents\\GitHub\\crawlStorage";
	        int numberOfCrawlers = 1;

	        CrawlConfig config = new CrawlConfig();
	        config.setMaxDepthOfCrawling(4);
	        config.setCrawlStorageFolder(crawlStorageFolder);
	        config.setUserAgentString("cheezymcgee");
	        
//	        System.out.println(config.toString());
	        /*
	         * Instantiate the controller for this crawl.
	         */
	        PageFetcher pageFetcher = new PageFetcher(config);
	        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
	        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
	        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

	        /*
	         * For each crawl, you need to add some seed urls. These are the first
	         * URLs that are fetched and then the crawler starts following links
	         * which are found in these pages
	         */
	        controller.addSeed("https://eztv.ag/search/brooklyn");

	        /*
	         * Start the crawl. This is a blocking operation, meaning that your code
	         * will reach the line after this only when crawling is finished.
	         */
	        controller.start(SeriedlCrawler.class, numberOfCrawlers);
	    }

}
