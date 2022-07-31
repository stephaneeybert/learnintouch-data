package com.thalasoft.learnintouch.data.jpa;

import static com.thalasoft.learnintouch.data.jpa.assertion.AdminAssert.assertThatAdmin;
import static org.junit.Assert.assertEquals;

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
import com.thalasoft.learnintouch.data.jpa.repository.AdminRepository;

public class AdminRepositoryTest extends AbstractRepositoryTest {

	@Autowired 
	AdminRepository adminRepository;

	private Admin admin0;
	private Admin admin1;
	private Admin admin2;
    private Admin admin3;
	private List<Admin> manyAdmins;

	public AdminRepositoryTest() {
		admin0 = new Admin.AdminBuilder("Stephane", "Eybert", "stephane@thalasoft.com", "stephane")
		.setPassword("toto")
        .setPasswordSalt("")
        .build();

		admin1 = new Admin.AdminBuilder("Marc", "Eybert", "marceybert@yahoo.fr", "marc")
		.setPassword("marcus")
        .setPasswordSalt("")
        .build();

		admin2 = new Admin.AdminBuilder("Cyril", "Eybert", "cyril@yahoo.es", "cyril")
		.setPassword("cyr")
        .setPasswordSalt("")
        .build();

		admin3 = new Admin.AdminBuilder("Stefan", "Eybert", "stefan@thalasoft.com", "stefan")
		.setPassword("kiki")
        .setPasswordSalt("")
        .setSuperAdmin(true)
        .build();

		manyAdmins = new ArrayList<Admin>();
		for (int i = 0; i < 40; i++) {
			String index = intToString(i, 3);
			Admin oneAdmin = new Admin.AdminBuilder("spirou" + index, "zlastname" + index, "zemail" + index + "@thalasoft.com", "zlogin" + index)
			.setPassword("zpassword" + index)
	        .setPasswordSalt("")
			.setSuperAdmin(true)
			.build();
			manyAdmins.add(oneAdmin);
		}
	}

	@Before
	public void beforeAnyTest() throws Exception {
		admin0 = adminRepository.saveAndFlush(admin0);
		admin1 = adminRepository.saveAndFlush(admin1);
		admin2 = adminRepository.saveAndFlush(admin2);
        admin3 = adminRepository.saveAndFlush(admin3);
		for (Admin oneAdmin : manyAdmins) {
			oneAdmin = adminRepository.saveAndFlush(oneAdmin);
		}
	}

    @After
    public void afterAnyTest() throws Exception {
    	if (null != admin0.getId()) {
    		adminRepository.delete(admin0.getId());
    	}
    	if (null != admin1.getId()) {
    		adminRepository.delete(admin1.getId());
    	}
    	if (null != admin2.getId()) {
    		adminRepository.delete(admin2.getId());
    	}
    	if (null != admin3.getId()) {
    		adminRepository.delete(admin3.getId());
    	}
		for (Admin admin : manyAdmins) {
	    	if (null != admin.getId()) {
	    		adminRepository.delete(admin.getId());
	    	}
		}
    }
    
	@Test
	public void testSaveAndRetrieve() {
		Admin admin = new Admin.AdminBuilder(admin2)
		.setPassword("mypass")
		.build();
		assertThatAdmin(admin).hasAnIdNotNull();
		Admin loadedAdmin = adminRepository.findOne(admin2.getId());
		assertThatAdmin(loadedAdmin)
		.hasAnIdNotNull()
		.hasEmail(admin2.getEmail())
		.hasPassword(admin2.getPassword())
		.isSameAs(admin2);
	}
	
	@Test
	public void testDeleteById() {
		Admin loadedAdmin = adminRepository.findOne(admin0.getId());
		assertThatAdmin(loadedAdmin).exists();
		loadedAdmin = adminRepository.deleteById(admin0.getId());
		loadedAdmin = adminRepository.findOne(admin0.getId());
		assertThatAdmin(loadedAdmin).doesNotExist();
		admin0 = adminRepository.saveAndFlush(admin0);
		assertThatAdmin(admin0).exist();
	}
	
	@Test
	public void testDeleteByAdminId() {
		Admin loadedAdmin = adminRepository.findOne(admin0.getId());
		assertThatAdmin(loadedAdmin).exists();
		loadedAdmin = adminRepository.deleteByAdminId(admin0.getId());
		loadedAdmin = adminRepository.findOne(admin0.getId());
		assertThatAdmin(loadedAdmin).doesNotExist();
		admin0 = adminRepository.saveAndFlush(admin0);
		assertThatAdmin(admin0).exist();
	}
	
	@Test
	public void testFindByEmail() {
		Admin loadedAdmin = adminRepository.findByEmail(admin0.getEmail());
		assertThatAdmin(loadedAdmin).hasEmail(admin0.getEmail());
	}
	
	@Test
	public void testFindByLogin() {
		Admin loadedAdmin = adminRepository.findByLogin(admin0.getLogin());
		assertThatAdmin(loadedAdmin).hasLogin(admin0.getLogin());
	}

	@Test
	public void testFindByLoginAndPassword() {
		Admin loadedAdmin = adminRepository.findByLoginAndPassword(admin0.getLogin(), "toto");
		assertThatAdmin(loadedAdmin).hasLogin(admin0.getLogin());
	}

	@Test
	public void testFindByFirstnameStartingWithOrLastnameStartingWith() {
		Page<Admin> admins = adminRepository.findByFirstnameStartingWithOrLastnameStartingWith("spirou", new PageRequest(0, 10));
		assertEquals(10, admins.getContent().size());
		admins = adminRepository.findByFirstnameStartingWithOrLastnameStartingWith("noname", new PageRequest(0, 10));
		assertEquals(0, admins.getContent().size());
	}

	@Test
	public void testFindAll() {
		assertEquals(44, adminRepository.count());
		Pageable pageRequest = new PageRequest(0, 10);
		Page<Admin> admins = adminRepository.all(pageRequest);
		assertEquals(10, admins.getContent().size());
		assertEquals("Cyril", admins.getContent().get(0).getFirstname());
		assertEquals("Marc", admins.getContent().get(1).getFirstname());
		assertEquals("Stefan", admins.getContent().get(2).getFirstname());
        assertEquals("Stephane", admins.getContent().get(3).getFirstname());
		assertEquals("spirou000", admins.getContent().get(4).getFirstname());
        pageRequest = new PageRequest(1, 20);
		admins = adminRepository.all(pageRequest);
		assertEquals(20, admins.getContent().size());
		assertEquals("spirou016", admins.getContent().get(0).getFirstname());
		assertEquals("spirou035", admins.getContent().get(19).getFirstname());
	}
	
    @Test
    public void testSearchByFirstname() {
        Page<Admin> admins = adminRepository.findByFirstnameStartingWithOrLastnameStartingWith("spirou", new PageRequest(0, 10));
        assertEquals(10, admins.getContent().size());	
        admins = adminRepository.findByFirstnameStartingWithOrLastnameStartingWith("Ste", new PageRequest(0, 10));
        assertEquals(2, admins.getContent().size()); 
        admins = adminRepository.findByFirstnameStartingWithOrLastnameStartingWith("Steph", new PageRequest(0, 10));
        assertEquals(1, admins.getContent().size()); 
    }

	@Test
	public void testSearch() {
		Page<Admin> admins = adminRepository.search("spirou", new PageRequest(0, 10));
		assertEquals(10, admins.getContent().size());
		assertEquals(40, admins.getTotalElements());
		assertEquals(4, admins.getTotalPages());
		assertEquals("spirou000", admins.getContent().get(0).getFirstname());
		assertEquals("spirou001", admins.getContent().get(1).getFirstname());
		admins = adminRepository.search("spirou", new PageRequest(1, 20));
		assertEquals(20, admins.getContent().size());
		assertEquals("spirou020", admins.getContent().get(0).getFirstname());
		assertEquals("spirou039", admins.getContent().get(19).getFirstname());
	}

	@Test
	public void testFindAllNonSuperAdminPlusOneWithLogin() {
		Page<Admin> admins = adminRepository.findAllNonSuperAdminPlusOneWithLogin("nosuchlogin", new PageRequest(0, 10));
		assertEquals(3, admins.getContent().size());
		assertEquals("Cyril", admins.getContent().get(0).getFirstname());
		assertEquals("Stephane", admins.getContent().get(2).getFirstname());
		admins = adminRepository.findAllNonSuperAdminPlusOneWithLogin("cyril", new PageRequest(0, 10));	
		assertEquals(3, admins.getContent().size());
		assertEquals("Cyril", admins.getContent().get(0).getFirstname());
		assertEquals("Marc", admins.getContent().get(1).getFirstname());
		assertEquals("Stephane", admins.getContent().get(2).getFirstname());
	}

	@Test
	public void testUpdate() {
		adminRepository.update("Toto", "LeHeros", "qwerty", admin0.isSuperAdmin(), admin0.isPreferenceAdmin(), admin0.getAddress(), admin0.getZipCode(), admin0.getCity(), admin0.getCountry(), admin0.getEmail(), admin0.getProfile(), admin0.getPostLoginUrl(), admin0.getId());
		adminRepository.getEntityManager().clear();
		Admin loadedAdmin = adminRepository.findOne(admin0.getId());
		assertEquals("Toto", loadedAdmin.getFirstname());
		assertEquals("LeHeros", loadedAdmin.getLastname());
	}
	
	@Test
	public void testUpdatePassword(){
	    adminRepository.updatePassword("blabla", "1283721847646145136", admin0.getId());
        adminRepository.getEntityManager().clear();
        Admin loadedAdmin = adminRepository.findOne(admin0.getId());
        assertEquals("blabla", loadedAdmin.getPassword());
        assertEquals("1283721847646145136", loadedAdmin.getPasswordSalt());
	}
	
}