package com.thalasoft.learnintouch.data.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.thalasoft.learnintouch.data.jpa.domain.ElearningSubscription;
import com.thalasoft.learnintouch.data.jpa.domain.EmailAddress;
import com.thalasoft.learnintouch.data.jpa.domain.UserAccount;
import com.thalasoft.learnintouch.data.jpa.repository.ElearningSubscriptionRepository;
import com.thalasoft.learnintouch.data.jpa.repository.UserAccountRepository;

public class ElearningSubscriptionRepositoryTest extends AbstractRepositoryTest {

	@Autowired 
	ElearningSubscriptionRepository elearningSubscriptionRepository;

    @Autowired 
    UserAccountRepository userAccountRepository;

    private EmailAddress email;
	private EmailAddress email0;
    private EmailAddress email1;
    private EmailAddress email2;
    private EmailAddress email3;

    private UserAccount userAccount0;
    private UserAccount userAccount1;
    private UserAccount userAccount2;
    private UserAccount userAccount3;

    private ElearningSubscription elearningSubscription0;
	private ElearningSubscription elearningSubscription1;
	private ElearningSubscription elearningSubscription2;
    private ElearningSubscription elearningSubscription3;
	private List<ElearningSubscription> manyElearningSubscriptions;

	public ElearningSubscriptionRepositoryTest() {
	    email0 = new EmailAddress("mittiprovence@yahoo.se");
	    userAccount0 = new UserAccount();
	    userAccount0.setFirstname("Stephane");
	    userAccount0.setLastname("Eybert");
	    userAccount0.setEmail(email0);
	    userAccount0.setPassword("toto");
	    userAccount0.setPasswordSalt("toto");
	    userAccount0.setUnconfirmedEmail(true);
	    userAccount0.setLastLogin(new LocalDateTime());
	    userAccount0.setImported(false);
	    userAccount0.setMailSubscribe(false);
	    userAccount0.setSmsSubscribe(false);
	    elearningSubscription0 = new ElearningSubscription();
	    elearningSubscription0.setUserAccount(userAccount0);
	    elearningSubscription0.setWatchLive(false);

        email1 = new EmailAddress("marc@yahoo.se");
        userAccount1 = new UserAccount();
        userAccount1.setFirstname("Marc");
        userAccount1.setLastname("Eybert");
        userAccount1.setEmail(email1);
        userAccount1.setPassword("toto");
        userAccount1.setPasswordSalt("toto");
        userAccount1.setUnconfirmedEmail(true);
        userAccount1.setLastLogin(new LocalDateTime());
        userAccount1.setImported(false);
        userAccount1.setMailSubscribe(false);
        userAccount1.setSmsSubscribe(false);
        elearningSubscription1 = new ElearningSubscription();
        elearningSubscription1.setUserAccount(userAccount1);
        elearningSubscription1.setWatchLive(false);

        email2 = new EmailAddress("cyr@yahoo.se");
        userAccount2 = new UserAccount();
        userAccount2.setFirstname("Cyr");
        userAccount2.setLastname("Eybert");
        userAccount2.setEmail(email2);
        userAccount2.setPassword("toto");
        userAccount2.setPasswordSalt("toto");
        userAccount2.setUnconfirmedEmail(true);
        userAccount2.setLastLogin(new LocalDateTime());
        userAccount2.setImported(false);
        userAccount2.setMailSubscribe(false);
        userAccount2.setSmsSubscribe(false);
        elearningSubscription2 = new ElearningSubscription();
        elearningSubscription2.setUserAccount(userAccount2);
        elearningSubscription2.setWatchLive(false);

        email3 = new EmailAddress("marie@yahoo.se");
        userAccount3 = new UserAccount();
        userAccount3.setFirstname("Marie");
        userAccount3.setLastname("Eybert");
        userAccount3.setEmail(email3);
        userAccount3.setPassword("toto");
        userAccount3.setPasswordSalt("toto");
        userAccount3.setUnconfirmedEmail(true);
        userAccount3.setLastLogin(new LocalDateTime());
        userAccount3.setImported(false);
        userAccount3.setMailSubscribe(false);
        userAccount3.setSmsSubscribe(false);
        elearningSubscription3 = new ElearningSubscription();
        elearningSubscription3.setUserAccount(userAccount3);
        elearningSubscription3.setWatchLive(false);

        manyElearningSubscriptions = new ArrayList<ElearningSubscription>();
		for (int i = 0; i < 31; i++) {
		    UserAccount oneUserAccount = new UserAccount();
            ElearningSubscription oneElearningSubscription = new ElearningSubscription();
			String index = intToString(i, 3);
	        email = new EmailAddress("joe" + index + "@yahoo.se");
	        oneUserAccount = new UserAccount();
	        oneUserAccount.setFirstname("Zoe" + index);
	        oneUserAccount.setLastname("Eybert");
	        oneUserAccount.setEmail(email);
	        oneUserAccount.setPassword("toto");
	        oneUserAccount.setPasswordSalt("toto");
	        oneUserAccount.setUnconfirmedEmail(true);
	        oneUserAccount.setLastLogin(new LocalDateTime());
	        oneUserAccount.setImported(false);
	        oneUserAccount.setMailSubscribe(false);
	        oneUserAccount.setSmsSubscribe(false);
	        oneElearningSubscription = new ElearningSubscription();
	        oneElearningSubscription.setUserAccount(oneUserAccount);
	        oneElearningSubscription.setWatchLive(false);
	        manyElearningSubscriptions.add(oneElearningSubscription);
		}
	}

	@Before
	public void beforeAnyTest() throws Exception {
        userAccount0 = userAccountRepository.saveAndFlush(userAccount0);
        userAccount1 = userAccountRepository.saveAndFlush(userAccount1);
        userAccount2 = userAccountRepository.saveAndFlush(userAccount2);
	    userAccount3 = userAccountRepository.saveAndFlush(userAccount3);
	    elearningSubscription0 = elearningSubscriptionRepository.saveAndFlush(elearningSubscription0);
	    elearningSubscription1 = elearningSubscriptionRepository.saveAndFlush(elearningSubscription1);
	    elearningSubscription2 = elearningSubscriptionRepository.saveAndFlush(elearningSubscription2);
		elearningSubscription3 = elearningSubscriptionRepository.saveAndFlush(elearningSubscription3);
		for (ElearningSubscription oneElearningSubscription : manyElearningSubscriptions) {
		    UserAccount oneUserAccount = oneElearningSubscription.getUserAccount();
		    oneUserAccount = userAccountRepository.saveAndFlush(oneUserAccount);
		    oneElearningSubscription = elearningSubscriptionRepository.saveAndFlush(oneElearningSubscription);
		}
	}

    @After
    public void afterAnyTest() throws Exception {
    	for (ElearningSubscription oneElearningSubscription : manyElearningSubscriptions) {
    		if (null != oneElearningSubscription.getId()) {
    			UserAccount oneUserAccount = oneElearningSubscription.getUserAccount();
    			elearningSubscriptionRepository.delete(oneElearningSubscription.getId());
    			userAccountRepository.delete(oneUserAccount.getId());
    		}
    	}
    	if (null != elearningSubscription0.getId()) {
    		elearningSubscriptionRepository.delete(elearningSubscription0.getId());
    	}
    	if (null != elearningSubscription1.getId()) {
    		elearningSubscriptionRepository.delete(elearningSubscription1.getId());
    	}
    	if (null != elearningSubscription2.getId()) {
    		elearningSubscriptionRepository.delete(elearningSubscription2.getId());
    	}
    	if (null != elearningSubscription3.getId()) {
    		elearningSubscriptionRepository.delete(elearningSubscription3.getId());
    	}
    	if (null != userAccount0.getId()) {
    		userAccountRepository.delete(userAccount0.getId());
    	}
    	if (null != userAccount1.getId()) {
    		userAccountRepository.delete(userAccount1.getId());
    	}
    	if (null != userAccount2.getId()) {
    		userAccountRepository.delete(userAccount2.getId());
    	}
    	if (null != userAccount3.getId()) {
    		userAccountRepository.delete(userAccount3.getId());
    	}
    }
    
	@Test
	public void testSaveAndRetrieve() {
		assertNotNull(elearningSubscription0.getId());
		elearningSubscription0.setWatchLive(true);
		ElearningSubscription loadedElearningSubscription = elearningSubscriptionRepository.findOne(elearningSubscription0.getId());
		assertNotNull(loadedElearningSubscription.getId());
		assertFalse(elearningSubscription0.getWatchLive() == loadedElearningSubscription.getWatchLive());
		assertEquals(elearningSubscription0.getUserAccount().getEmail(), loadedElearningSubscription.getUserAccount().getEmail());
		assertNotSame(elearningSubscription0.hashCode(), 0L);
		assertEquals(elearningSubscription0.hashCode(), loadedElearningSubscription.hashCode());
		assertFalse(elearningSubscription0.toString().equals(""));
	}
	
	@Test
	public void testDeleteById() {
	    ElearningSubscription loadedElearningSubscription = elearningSubscriptionRepository.findOne(elearningSubscription0.getId());
		assertNotNull(loadedElearningSubscription);
		loadedElearningSubscription = elearningSubscriptionRepository.deleteById(elearningSubscription0.getId());
		loadedElearningSubscription = elearningSubscriptionRepository.findOne(elearningSubscription0.getId());
		assertNull(loadedElearningSubscription);
	    elearningSubscription0 = elearningSubscriptionRepository.saveAndFlush(elearningSubscription0);
		assertNotNull(elearningSubscription0);
	}
	
    @Test
    public void testFindAll() {
        assertEquals(35, elearningSubscriptionRepository.count());
        Pageable pageRequest = new PageRequest(0, 10);
        Page<ElearningSubscription> elearningSubscriptions = elearningSubscriptionRepository.findAllPlease(pageRequest);
        assertEquals(10, elearningSubscriptions.getContent().size());
        assertEquals("Cyr" , elearningSubscriptions.getContent().get(0).getUserAccount().getFirstname());
        assertEquals("Marc" , elearningSubscriptions.getContent().get(1).getUserAccount().getFirstname());
        assertEquals("Marie" , elearningSubscriptions.getContent().get(2).getUserAccount().getFirstname());
        assertEquals("Stephane" , elearningSubscriptions.getContent().get(3).getUserAccount().getFirstname());
        assertEquals("Zoe000" , elearningSubscriptions.getContent().get(4).getUserAccount().getFirstname());
        pageRequest = new PageRequest(1, 20);
        elearningSubscriptions = elearningSubscriptionRepository.findAllPlease(pageRequest);
        assertEquals(15, elearningSubscriptions.getContent().size());
        assertEquals("Zoe016" , elearningSubscriptions.getContent().get(0).getUserAccount().getFirstname());
        assertEquals("Zoe030" , elearningSubscriptions.getContent().get(14).getUserAccount().getFirstname());
    }

    @Test
    public void testSearch() {
        Pageable pageRequest = new PageRequest(0, 10);
        Page<ElearningSubscription> elearningSubscriptions = elearningSubscriptionRepository.search("Zoe", pageRequest);
        assertEquals(10, elearningSubscriptions.getContent().size());
    }
    
}