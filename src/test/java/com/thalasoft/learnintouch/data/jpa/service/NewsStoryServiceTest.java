package com.thalasoft.learnintouch.data.jpa.service;

import static com.thalasoft.learnintouch.data.jpa.assertion.NewsStoryAssert.assertThatNewsStory;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.thalasoft.learnintouch.data.jpa.domain.NewsPaper;
import com.thalasoft.learnintouch.data.jpa.domain.NewsPublication;
import com.thalasoft.learnintouch.data.jpa.domain.NewsStory;
import com.thalasoft.learnintouch.data.service.jpa.NewsPaperService;
import com.thalasoft.learnintouch.data.service.jpa.NewsPublicationService;
import com.thalasoft.learnintouch.data.service.jpa.NewsStoryService;

public class NewsStoryServiceTest extends AbstractServiceTest {

	@Autowired 
	private NewsPublicationService newsPublicationService;

	@Autowired 
	private NewsPaperService newsPaperService;

	@Autowired 
	private NewsStoryService newsStoryService;

	private List<NewsStory> manyNewsStories;

	private NewsPaper newsPaper0;
	private NewsPublication newsPublication0;
	
	public void setNewsStoryService(NewsStoryService newsStoryService) {
		this.newsStoryService = newsStoryService;
	}

	public NewsStoryServiceTest() {
		newsPublication0 = new NewsPublication();
		newsPublication0.setName("My news publication 0");
		newsPaper0 = new NewsPaper();
		newsPaper0.setTitle("My newspaper 0");
		newsPaper0.setNewsPublication(newsPublication0);
		manyNewsStories = new ArrayList<NewsStory>();
		for (int i = 0; i < 40; i++) {
			String index = intToString(i, 3);
			NewsStory oneNewsStory = new NewsStory();
			oneNewsStory.setHeadline("My headline " + index);
			oneNewsStory.setLink("http://link" + index + ".com");
			oneNewsStory.setNewsPaper(newsPaper0);
			oneNewsStory.setListOrder(i + 1);
			manyNewsStories.add(oneNewsStory);
		}		
	}
	
	@Before
	public void beforeAnyTest() throws Exception {
  	    newsPublicationService.add(newsPublication0);
		newsPaperService.add(newsPaper0);
		for (NewsStory oneNewsStory : manyNewsStories) {
			oneNewsStory = newsStoryService.add(oneNewsStory);
		}
	}

    @After
    public void afterAnyTest() throws Exception {
    	for (NewsStory oneNewsStory : manyNewsStories) {
    		if (null != oneNewsStory.getId()) {
    			newsStoryService.delete(oneNewsStory.getId());
    		}
    	}
    	if (null != newsPaper0.getId()) {
    		newsPaperService.delete(newsPaper0.getId());
    	}
    	if (null != newsPublication0.getId()) {
    		newsPublicationService.delete(newsPublication0.getId());
    	}
    }
    
    @Test
	public void testFindNextByListOrder() {
		NewsStory nextNewsStory = newsStoryService.findByNextListOrder(newsPaper0, null, 1);
		assertThatNewsStory(nextNewsStory).exists();
	}
	
}