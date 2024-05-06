package com.koushal.jpahibernaterevision.JPA;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class courseJPACommandLineRunner implements CommandLineRunner {

    @Autowired
    courseJPARepository courseJPARepository;

    @Override
    public void run(String... args) throws Exception {
        courseJPARepository.insert(new Course(5,"Learn Aws JPA","Koushal"));
        courseJPARepository.insert(new Course(6,"Learn Aws JPA 2","Koushal"));
        courseJPARepository.insert(new Course(7,"Learn Aws JPA 3","Koushal"));
        courseJPARepository.insert(new Course(8,"Learn Aws JPA 4","Koushal"));

        //select query
        System.out.println(courseJPARepository.getCourseById(6));
        System.out.println(courseJPARepository.getCourseById(7));

        //delete query
        courseJPARepository.deleteById(7);
    }
}


//Output
//Course{id=6, name='Learn Aws JPA 2', author='Koushal'}
//Course{id=7, name='Learn Aws JPA 3', author='Koushal'}
