package com.koushal.jpahibernaterevision.springJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class courseJDBCCommandLineRunner implements CommandLineRunner {

    @Autowired
    courseJDBCRepository courseJDBCRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJDBCRepository.insert(new Course(1,"Learn AWS","Koushal"));
        courseJDBCRepository.insert(new Course(2,"Learn AWS 2","Koushal"));
        courseJDBCRepository.insert(new Course(3,"Learn AWS 3","Koushal"));
        courseJDBCRepository.insert(new Course(4,"Learn AWS 4","Koushal"));
        courseJDBCRepository.deleteCourse(2);
        //select query
        System.out.println(courseJDBCRepository.getCourseWithID(3));
        System.out.println(courseJDBCRepository.getCourseWithID(4));

        //output
//        Course{id=3, name='Learn AWS 3', author='Koushal'}
//        Course{id=4, name='Learn AWS 4', author='Koushal'}

    }
}
