package com.thalasoft.learnintouch.data.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.thalasoft.learnintouch.data.jpa.domain.Admin;
import com.thalasoft.learnintouch.data.jpa.domain.AdminModule;
import com.thalasoft.learnintouch.data.jpa.repository.AdminModuleRepository;
import com.thalasoft.learnintouch.data.jpa.repository.AdminRepository;

public class AdminModuleRepositoryTest extends AbstractRepositoryTest {

	@Autowired 
	AdminRepository adminRepository;

	@Autowired 
	AdminModuleRepository adminModuleRepository;

	private Admin admin0;
	private Admin admin1;
	private AdminModule adminModule0;
	private AdminModule adminModule1;
	private AdminModule adminModule2;
	private List<AdminModule> manyAdminModules;

	public AdminModuleRepositoryTest() {

		admin0 = new Admin.AdminBuilder("Stephane", "Eybert", "stephane@thalasoft.com", "stephane")
		.setPassword("toto")
        .setPasswordSalt("")
        .build();

		admin1 = new Admin.AdminBuilder("Marc", "Eybert", "marceybert@yahoo.fr", "marc")
		.setPassword("marcus")
        .setPasswordSalt("")
        .build();

		adminModule0 = new AdminModule();
		adminModule0.setAdmin(admin0);
		adminModule0.setModule("webpage");

		adminModule1 = new AdminModule();
		adminModule1.setAdmin(admin1);
		adminModule1.setModule("elearning");

		adminModule2 = new AdminModule();
		adminModule2.setAdmin(admin1);
		adminModule2.setModule("mail");

		manyAdminModules = new ArrayList<AdminModule>();
		for (int i = 0; i < 40; i++) {
			AdminModule oneAdminModule = new AdminModule();
			String index = intToString(i, 2);
			oneAdminModule.setAdmin(admin1);
			oneAdminModule.setModule("module" + index);
			manyAdminModules.add(oneAdminModule);
		}
	}

	@Before
	public void beforeAnyTest() throws Exception {
		admin0 = adminRepository.saveAndFlush(admin0);
		admin1 = adminRepository.saveAndFlush(admin1);
		adminModule0 = adminModuleRepository.saveAndFlush(adminModule0);
		adminModule1 = adminModuleRepository.saveAndFlush(adminModule1);
		adminModule2 = adminModuleRepository.saveAndFlush(adminModule2);
		for (AdminModule oneAdminModule : manyAdminModules) {
			oneAdminModule = adminModuleRepository.saveAndFlush(oneAdminModule);
		}
	}

    @After
    public void afterAnyTest() throws Exception {
    	if (null != adminModule0.getId()) {
    		adminModuleRepository.delete(adminModule0.getId());
    	}
    	if (null != adminModule1.getId()) {
    		adminModuleRepository.delete(adminModule1.getId());
    	}
    	if (null != adminModule2.getId()) {
    		adminModuleRepository.delete(adminModule2.getId());
    	}
		for (AdminModule oneAdminModule : manyAdminModules) {
	    	if (null != oneAdminModule.getId()) {
	    		adminModuleRepository.delete(oneAdminModule.getId());
	    	}
		}
		if (null != admin0.getId()) {
			adminRepository.delete(admin0.getId());
		}
		if (null != admin1.getId()) {
			adminRepository.delete(admin1.getId());
		}
    }

	@Test
	public void testSaveAndRetrieve() {
		assertNotNull(adminModule2.getId());
		adminModule2.setModule("mymodule");
		AdminModule loadedAdminModule = adminModuleRepository.findOne(adminModule2.getId());
		assertNotNull(loadedAdminModule.getId());
		assertEquals(adminModule2.getAdmin(), loadedAdminModule.getAdmin());
		assertFalse(adminModule2.getModule().equals(loadedAdminModule.getModule()));
		assertNotSame(adminModule2.hashCode(), 0L);
		assertEquals(adminModule2.hashCode(), loadedAdminModule.hashCode());
		assertFalse(adminModule2.toString().equals(""));
	}
	
	@Test
	public void testDeleteById() {
		AdminModule loadedAdmin = adminModuleRepository.findOne(adminModule0.getId());
		assertNotNull(loadedAdmin);
		loadedAdmin = adminModuleRepository.deleteById(adminModule0.getId());
		loadedAdmin = adminModuleRepository.findOne(adminModule0.getId());
		assertNull(loadedAdmin);
		adminModule0 = adminModuleRepository.saveAndFlush(adminModule0);
		assertNotNull(adminModule0);
	}

	@Test
	public void testFindAll() {
		assertEquals(43, adminModuleRepository.count());
		Pageable pageRequest = new PageRequest(0, 10);
		Page<AdminModule> adminModules = adminModuleRepository.findAll(pageRequest);
		assertEquals(10, adminModules.getContent().size());
		assertEquals(adminModule0.getModule(), adminModules.getContent().get(0).getModule());
		assertEquals(adminModule1.getModule(), adminModules.getContent().get(1).getModule());
		assertEquals(adminModule2.getModule(), adminModules.getContent().get(2).getModule());
		assertEquals(manyAdminModules.get(0).getModule(), adminModules.getContent().get(3).getModule());
		pageRequest = new PageRequest(1, 20);
		adminModules = adminModuleRepository.findAll(pageRequest);
		assertEquals(20, adminModules.getContent().size());
		assertEquals(manyAdminModules.get(17).getModule(), adminModules.getContent().get(0).getModule());
        assertEquals(manyAdminModules.get(18).getModule(), adminModules.getContent().get(1).getModule());
	}

	@Test
	public void testFindByAdmin() {
		Page<AdminModule> adminModules = adminModuleRepository.findByAdmin(admin0, new PageRequest(0, 10));
        assertEquals(1, adminModules.getContent().size());
        assertEquals(adminModule0.getModule(), adminModules.getContent().get(0).getModule());
        adminModules = adminModuleRepository.findByAdmin(admin1, new PageRequest(0, 10));
        assertEquals(10, adminModules.getContent().size());
        assertEquals(adminModule1.getModule(), adminModules.getContent().get(0).getModule());
        assertEquals(adminModule2.getModule(), adminModules.getContent().get(1).getModule());
        adminModules = adminModuleRepository.findByAdmin(admin1, new PageRequest(1, 10));
        assertEquals(manyAdminModules.get(8).getModule(), adminModules.getContent().get(0).getModule());
        assertEquals(manyAdminModules.get(9).getModule(), adminModules.getContent().get(1).getModule());
	}
	
    @Test
    public void testFindByModule() {
        Page<AdminModule> adminModules = adminModuleRepository.findByModule(adminModule0.getModule(), new PageRequest(0, 10));
        assertEquals(1, adminModules.getContent().size());
        assertEquals(adminModule0.getModule(), adminModules.getContent().get(0).getModule());
        adminModules = adminModuleRepository.findByModule(adminModule1.getModule(), new PageRequest(0, 10));
        assertEquals(1, adminModules.getContent().size());
        assertEquals(adminModule1.getModule(), adminModules.getContent().get(0).getModule());
    }

    @Test
    public void testFindByAdminAndModule() {
        AdminModule adminModule = adminModuleRepository.findByAdminAndModule(admin0, adminModule0.getModule());
        assertEquals(adminModule0.getModule(), adminModule.getModule());
        adminModule = adminModuleRepository.findByAdminAndModule(admin1, adminModule1.getModule());
        assertEquals(adminModule1.getModule(), adminModule.getModule());
        adminModule = adminModuleRepository.findByAdminAndModule(admin1, adminModule0.getModule());
        assertNull(adminModule);
    }
	
}