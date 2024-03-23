package com.ftn.realestatemanagement;

import com.ftn.realestatemanagement.model.Admin;
import com.ftn.realestatemanagement.repository.AdminRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AdminRepostioryTests {

    @Autowired
    private AdminRepository adminRepository;
    @Test
    public void saveAdminTest(){
        Admin admin = new Admin("a", "a", "Dragan", "Bijelic");
        adminRepository.save(admin);

        Assertions.assertThat(admin.getId()).isGreaterThan(0);
    }
}
