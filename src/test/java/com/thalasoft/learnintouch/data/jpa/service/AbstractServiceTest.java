package com.thalasoft.learnintouch.data.jpa.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.config.DatabaseConfiguration;
import com.thalasoft.learnintouch.data.config.JpaService;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { DatabaseConfiguration.class, JpaService.class })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public abstract class AbstractServiceTest {

	protected String intToString(int num, int digits) {
		String output = Integer.toString(num);
		while (output.length() < digits) {
			output = "0" + output;
		}
		return output;
	}
	
}
