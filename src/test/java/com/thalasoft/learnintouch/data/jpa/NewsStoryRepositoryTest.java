package com.thalasoft.learnintouch.data.jpa;

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
import com.thalasoft.learnintouch.data.jpa.repository.NewsPaperRepository;
import com.thalasoft.learnintouch.data.jpa.repository.NewsPublicationRepository;
import com.thalasoft.learnintouch.data.jpa.repository.NewsStoryRepository;

public class NewsStoryRepositoryTest extends AbstractRepositoryTest {

	@Autowired 
	private NewsPublicationRepository newsPublicationRepository;

	@Autowired 
	private NewsPaperRepository newsPaperRepository;

	@Autowired 
	private NewsStoryRepository newsStoryRepository;

	private List<NewsStory> manyNewsStories;

	private NewsPaper newsPaper0;
	private NewsPublication newsPublication0;
	
	public NewsStoryRepositoryTest() {
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
	    newsPublicationRepository.saveAndFlush(newsPublication0);
		newsPaperRepository.saveAndFlush(newsPaper0);
		for (NewsStory oneNewsStory : manyNewsStories) {
			oneNewsStory = newsStoryRepository.saveAndFlush(oneNewsStory);
		}
	}

    @After
    public void afterAnyTest() throws Exception {
    	for (NewsStory oneNewsStory : manyNewsStories) {
    		if (null != oneNewsStory.getId()) {
    			newsStoryRepository.delete(oneNewsStory.getId());
    		}
    	}
    	if (null != newsPaper0.getId()) {
    		newsPaperRepository.delete(newsPaper0.getId());
    	}
    	if (null != newsPublication0.getId()) {
    		newsPublicationRepository.delete(newsPublication0.getId());
    	}
    }

	@Test
	public void testFindNextByListOrder() {
		NewsStory nextNewsStory = newsStoryRepository.findByNextListOrder(newsPaper0, null, 1);
		assertThatNewsStory(nextNewsStory).exists();
	}
	
    @Test
    public void testFindPreviousByListOrder() {
        NewsStory nextNewsStory = newsStoryRepository.findByPreviousListOrder(newsPaper0, null, 3);
        assertThatNewsStory(nextNewsStory).exists();
    }
    
}