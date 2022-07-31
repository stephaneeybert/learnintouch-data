package com.thalasoft.learnintouch.data.jpa;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thalasoft.learnintouch.data.config.DatabaseConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfiguration.class })
public abstract class AbstractRepositoryTest {

    protected String intToString(int num, int digits) {
        String output = Integer.toString(num);
        while (output.length() < digits) {
            output = "0" + output;
        }
        return output;
    }

}
