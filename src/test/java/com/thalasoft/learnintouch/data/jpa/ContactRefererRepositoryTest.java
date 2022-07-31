package com.thalasoft.learnintouch.data.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.thalasoft.learnintouch.data.jpa.domain.ContactReferer;
import com.thalasoft.learnintouch.data.jpa.repository.ContactRefererRepository;

public class ContactRefererRepositoryTest extends AbstractRepositoryTest {

	@Autowired 
	ContactRefererRepository contactRefererRepository;

	private ContactReferer contactReferer0;
	private ContactReferer contactReferer1;
	private ContactReferer contactReferer2;
    private ContactReferer contactReferer3;

	public ContactRefererRepositoryTest() {
		contactReferer0 = new ContactReferer();
		contactReferer0.setDescription("SVT");
		contactReferer0.setListOrder(3);
		
		contactReferer1 = new ContactReferer();
		contactReferer1.setDescription("DN");
		contactReferer1.setListOrder(1);

		contactReferer2 = new ContactReferer();
		contactReferer2.setDescription("Aftonbladet");
        contactReferer2.setListOrder(4);

        contactReferer3 = new ContactReferer();
        contactReferer3.setDescription("Metro");
        contactReferer3.setListOrder(2);
	}

	@Before
	public void beforeAnyTest() throws Exception {
		contactReferer0 = contactRefererRepository.saveAndFlush(contactReferer0);
		contactReferer1 = contactRefererRepository.saveAndFlush(contactReferer1);
		contactReferer2 = contactRefererRepository.saveAndFlush(contactReferer2);
        contactReferer3 = contactRefererRepository.saveAndFlush(contactReferer3);
	}

    @After
    public void afterAnyTest() throws Exception {
    	if (null != contactReferer0.getId()) {
    		contactRefererRepository.delete(contactReferer0.getId());
    	}
    	if (null != contactReferer1.getId()) {
    		contactRefererRepository.delete(contactReferer1.getId());
    	}
    	if (null != contactReferer2.getId()) {
    		contactRefererRepository.delete(contactReferer2.getId());
    	}
    	if (null != contactReferer3.getId()) {
    		contactRefererRepository.delete(contactReferer3.getId());
    	}
    }
    
	@Test
	public void testSaveAndRetrieve() {
		assertNotNull(contactReferer2.getId());
		contactReferer2.setDescription("A new description");
		ContactReferer loadedContactReferer = contactRefererRepository.findOne(contactReferer2.getId());
		assertNotNull(loadedContactReferer.getId());
		assertFalse(contactReferer2.getDescription().equals(loadedContactReferer.getDescription()));
		assertEquals(contactReferer2.getListOrder(), loadedContactReferer.getListOrder());
		assertNotSame(contactReferer2.hashCode(), 0L);
		assertEquals(contactReferer2.hashCode(), loadedContactReferer.hashCode());
		assertFalse(contactReferer2.toString().equals(""));
	}
	
	@Test
	public void testDeleteById() {
		ContactReferer loadedContactReferer = contactRefererRepository.findOne(contactReferer0.getId());
		assertNotNull(loadedContactReferer);
		loadedContactReferer = contactRefererRepository.deleteById(contactReferer0.getId());
		loadedContactReferer = contactRefererRepository.findOne(contactReferer0.getId());
		assertNull(loadedContactReferer);
		contactReferer0 = contactRefererRepository.saveAndFlush(contactReferer0);
		assertNotNull(contactReferer0);
	}

//    @Test
//    public void testFindAll() {
//        assertEquals(4, contactRefererRepository.count());
//        Pageable pageRequest = new PageRequest(0, 3);
//        Page<ContactReferer> contactReferers = contactRefererRepository.findAll(pageRequest);
//        assertEquals(3, contactReferers.getContent().size());
//        assertEquals(contactReferer1.getDescription(), contactReferers.getContent().get(0).getDescription());
//        assertEquals(contactReferer3.getDescription(), contactReferers.getContent().get(1).getDescription());
//        assertEquals(contactReferer0.getDescription(), contactReferers.getContent().get(2).getDescription());
//        pageRequest = new PageRequest(1, 2);
//        contactReferers = contactRefererRepository.findAll(pageRequest);
//        assertEquals(2, contactReferers.getContent().size());
//        assertEquals(contactReferer0.getDescription(), contactReferers.getContent().get(0).getDescription());
//        assertEquals(contactReferer2.getDescription(), contactReferers.getContent().get(19).getDescription());
//    }

    @Test
    public void testFindAllOrderById() {
        assertEquals(4, contactRefererRepository.count());
        List<ContactReferer> contactReferers = contactRefererRepository.findAllOrderById();
        assertEquals(4, contactReferers.size());
        assertEquals(contactReferer0.getDescription(), contactReferers.get(0).getDescription());
        assertEquals(contactReferer1.getDescription(), contactReferers.get(1).getDescription());
        assertEquals(contactReferer2.getDescription(), contactReferers.get(2).getDescription());
        assertEquals(contactReferer3.getDescription(), contactReferers.get(3).getDescription());
    }

//	@Test
//	public void testFindFirst() {
//		ContactReferer loadedContactReferer = contactRefererRepository.findFirst();
//		assertEquals(contactReferer1.getDescription(), loadedContactReferer.getDescription());
//	}
	
//	@Test
//	public void testFindByNextListOrder() {
//		ContactReferer loadedContactReferer = contactRefererRepository.findByNextListOrder(contactReferer3.getListOrder());
//		assertEquals(contactReferer0.getListOrder(), loadedContactReferer.getListOrder());
//	}
//
//    @Test
//    public void testFindByPreviousListOrder() {
//        ContactReferer loadedContactReferer = contactRefererRepository.findByPreviousListOrder(contactReferer2.getListOrder());
//        assertEquals(contactReferer0.getListOrder(), loadedContactReferer.getListOrder());
//    }

    @Test
    public void testFindByListOrder() {
        List<ContactReferer> loadedContactReferers = contactRefererRepository.findByListOrder(contactReferer0.getListOrder());
        assertEquals(1, loadedContactReferers.size());
        assertEquals(contactReferer0.getListOrder(), loadedContactReferers.get(0).getListOrder());
    }

    @Test
    public void testFindDuplicateListOrders() {
        contactReferer3.setListOrder(3);
        contactReferer3 = contactRefererRepository.saveAndFlush(contactReferer3);
        Long count = contactRefererRepository.countDuplicateListOrders();
        assertEquals(2, count.intValue());
    }
	
}