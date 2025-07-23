package com.anujl.hospitalManagement;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anujl.hospitalManagement.entity.Patient;
import com.anujl.hospitalManagement.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootTest
// @RequiredArgsConstructor
public class PatientTest {
    @Autowired
     PatientRepository patientRepository;
      private static final Logger log = LoggerFactory.getLogger(PatientTest.class);
    @Test
    public void test(){
//       log.info("asdfa");
        System.out.println("Fetching patients...");
        List<Patient> list=patientRepository.findAll();
        System.out.println("List size: " + list.size()); // add for confirmation

for(Patient p:list){
System.out.println(p.toString());
}
System.out.println("message");
    }

}
