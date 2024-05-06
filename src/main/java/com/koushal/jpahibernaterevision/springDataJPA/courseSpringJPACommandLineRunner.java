package com.koushal.jpahibernaterevision.springDataJPA;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class courseSpringJPACommandLineRunner implements CommandLineRunner {

    @Autowired
   courseSpringDataJPARepository courseSpringDataJPARepository;

    @Override
    public void run(String... args) throws Exception {
        //only here insert method changed to save
        //courseSpringDataJPARepository.insert(new Course(5,"Learn Aws JPA","Koushal"));
        courseSpringDataJPARepository.save(new Course(9,"Learn Aws Spring JPA","Koushal"));
        courseSpringDataJPARepository.save(new Course(10,"Learn Aws Spring JPA 2","Koushal"));
        courseSpringDataJPARepository.save(new Course(11,"Learn Aws Spring JPA 3","Koushal"));
        courseSpringDataJPARepository.save(new Course(12,"Learn Aws Spring JPA 4","Koushal"));

        //select query
        System.out.println(courseSpringDataJPARepository.findById(10L));
        System.out.println(courseSpringDataJPARepository.findById(11L));

        //delete query
        //here it is necessary to provide long because we have told as long in JPARepository interface
        courseSpringDataJPARepository.deleteById(9L);
    }
}


//Output
//Course{id=6, name='Learn Aws JPA 2', author='Koushal'}
//Course{id=7, name='Learn Aws JPA 3', author='Koushal'}
