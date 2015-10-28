package com.nPlusOne;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class NPlusOne {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PencilRepository pencilRepository;

    @Autowired
    SchoolRepository schoolRepository;

    @Before
    public void setUp() throws Exception {
        School school1 = new School();
        schoolRepository.save(school1);

        Student student1 = new Student();
        student1.setSchool(school1);
        Student persistedStudent1 = studentRepository.save(student1);

        
        School school2 = new School();
        schoolRepository.save(school2);

        Student student2 = new Student();
        student2.setSchool(school2);
        Student persistedStudent2 = studentRepository.save(student2);

        Pencil pencil6 = new Pencil();
        pencil6.setStudent(persistedStudent2);
        pencilRepository.save(pencil6);


        Pencil pencil1 = new Pencil();
        pencil1.setStudent(persistedStudent1);
        pencilRepository.save(pencil1);

        Pencil pencil2 = new Pencil();
        pencil2.setStudent(persistedStudent1);
        pencilRepository.save(pencil2);

        Pencil pencil3 = new Pencil();
        pencil3.setStudent(persistedStudent1);
        pencilRepository.save(pencil3);

        Pencil pencil4 = new Pencil();
        pencil4.setStudent(persistedStudent1);
        pencilRepository.save(pencil4);

        Pencil pencil5 = new Pencil();
        pencil5.setStudent(persistedStudent1);
        pencilRepository.save(pencil5);
    }

    @Test
	public void basicAssociation() {
        System.out.println("IN THE TEST");
        System.out.println("IN THE TEST");
        System.out.println("IN THE TEST");
        System.out.println("IN THE TEST");

        studentRepository.findAll();
        System.out.println("SEARCHING FOR PENCILS");
        System.out.println("SEARCHING FOR PENCILS");
        System.out.println("SEARCHING FOR PENCILS");
        System.out.println("SEARCHING FOR PENCILS");
        List<Pencil> pencils = pencilRepository.findAll();
        System.out.println("PENCILS COUNT:" + pencils.size());

        System.out.println("SEARCHING FOR SCHOOLS");
        System.out.println("SEARCHING FOR SCHOOLS");
        System.out.println("SEARCHING FOR SCHOOLS");
        System.out.println("SEARCHING FOR SCHOOLS");
        List<School> schools = schoolRepository.findAll();
        System.out.println("SCHOOLS COUNT:" + schools.size());
    }

}
