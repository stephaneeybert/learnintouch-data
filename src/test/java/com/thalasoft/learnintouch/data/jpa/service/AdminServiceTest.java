package com.thalasoft.learnintouch.data.jpa.service;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.thalasoft.learnintouch.data.jpa.domain.Admin;
import com.thalasoft.learnintouch.data.service.event.admin.CreateAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.CreatedAdminEvent;
import com.thalasoft.learnintouch.data.service.event.admin.EventAdmin;
import com.thalasoft.learnintouch.data.service.event.admin.SearchAdminsEvent;
import com.thalasoft.learnintouch.data.service.event.admin.SearchedAdminsEvent;
import com.thalasoft.learnintouch.data.service.jpa.AdminService;

public class AdminServiceTest extends AbstractServiceTest {

    @Autowired
	private AdminService adminService;

	private Admin admin0;
	private List<Admin> manyAdmins;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public AdminServiceTest() {
	}

    @Before
    public void beforeAnyTest() throws Exception {
		admin0 = new Admin.AdminBuilder("Stephane", "Eybert", "stephane@thalasoft.com", "stephane")
		.setPassword("toto")
        .setPasswordSalt("")
        .build();

		CreatedAdminEvent adminCreatedEvent = adminService.add(new CreateAdminEvent(EventAdmin.newFrom(admin0)));
		admin0.setId(adminCreatedEvent.getAdminId());
		
		manyAdmins = new ArrayList<Admin>();
		for (int i = 0; i < 40; i++) {
			String index = intToString(i, 2);
			Admin oneAdmin = new Admin.AdminBuilder("zfirstname" + index, "zlastname" + index, "zemail" + index + "@thalasoft.com", "zlogin" + index)
			.setPassword("zpassword" + index)
	        .setPasswordSalt("")
			.setSuperAdmin(true)
			.build();
			CreatedAdminEvent oneAdminCreatedEvent = adminService.add(new CreateAdminEvent(EventAdmin.newFrom(oneAdmin)));
			oneAdmin.setId(oneAdminCreatedEvent.getAdminId());
			manyAdmins.add(oneAdmin);
		}
    }

    @After
    public void afterAnyTest() throws Exception {
    	if (null != admin0.getId()) {
    		adminService.delete(admin0.getId());
    	}
		for (Admin admin : manyAdmins) {
	    	if (null != admin.getId()) {
	    		adminService.delete(admin.getId());
	    	}
		}
    }
    
	@Test
	public void testFindByLogin() {
		admin0 = adminService.findByLogin("stephane");
		assertEquals("Stephane", admin0.getFirstname());
	}

	@Test
	public void testAdd() {
		Admin admin = new Admin.AdminBuilder("Marc", "Lopez", "marco@thalasoft.com", "marco")
		.setPassword("pireloup")
        .setPasswordSalt("")
        .build();
		
        CreatedAdminEvent adminCreatedEvent = adminService.add(new CreateAdminEvent(EventAdmin.newFrom(admin)));
	    assertNotNull(adminCreatedEvent.getAdminId());
        assertEquals(admin.getFirstname(), adminCreatedEvent.getEventAdmin().getFirstname());
        assertEquals(admin.getLastname(), adminCreatedEvent.getEventAdmin().getLastname());
        assertEquals(admin.getEmail(), adminCreatedEvent.getEventAdmin().getEmail());
        assertEquals(admin.getLogin(), adminCreatedEvent.getEventAdmin().getLogin());
        assertEquals(admin.getPassword(), adminCreatedEvent.getEventAdmin().getPassword());
        assertEquals(admin.getPasswordSalt(), adminCreatedEvent.getEventAdmin().getPasswordSalt());
	}
	
	@Test
	public void testSearch() {
		Pageable pageRequest = buildPageRequest(0, 10);
		Page<Admin> admins = adminService.search("zfirstname", pageRequest);
		assertEquals(10, admins.getContent().size());
		assertEquals(manyAdmins.get(0).getFirstname(), admins.getContent().get(0).getFirstname());
		assertEquals(manyAdmins.get(1).getFirstname(), admins.getContent().get(1).getFirstname());
		pageRequest = buildPageRequest(1, 20);
		admins = adminService.search("zfirstname", pageRequest);
		assertEquals(20, admins.getContent().size());
		assertEquals(manyAdmins.get(20).getFirstname(), admins.getContent().get(0).getFirstname());
		assertEquals(manyAdmins.get(39).getFirstname(), admins.getContent().get(19).getFirstname());
		
		pageRequest = buildPageRequest(0, 10);
		SearchedAdminsEvent searchedAdminsEvent = adminService.search(new SearchAdminsEvent("zfirstname", pageRequest));
		assertEquals(10, searchedAdminsEvent.getEventAdmins().size());
		assertEquals(manyAdmins.get(0).getFirstname(), searchedAdminsEvent.getEventAdmins().get(0).getFirstname());
		pageRequest = buildPageRequest(1, 20);
		searchedAdminsEvent = adminService.search(new SearchAdminsEvent("zfirstname", pageRequest));
		assertEquals(20, searchedAdminsEvent.getEventAdmins().size());
		assertEquals(manyAdmins.get(20).getFirstname(), searchedAdminsEvent.getEventAdmins().get(0).getFirstname());
		assertEquals(manyAdmins.get(39).getFirstname(), searchedAdminsEvent.getEventAdmins().get(19).getFirstname());
		searchedAdminsEvent = adminService.search(new SearchAdminsEvent("nottobefound", pageRequest));
		if (searchedAdminsEvent.getTotalElements() != 0) {
			fail("Searching a non existing admin should have returned none.");			
		}
	}

	private Pageable buildPageRequest(int pageIndex, int pageSize) {
		Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "lastname"), new Sort.Order(Sort.Direction.ASC, "firstname"));
		return new PageRequest(pageIndex, pageSize, sort);
	}

}