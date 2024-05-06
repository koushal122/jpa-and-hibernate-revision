package com.koushal.jpahibernaterevision.springDataJPA;

import org.springframework.data.jpa.repository.JpaRepository;

//this will take care of everything
//this interface act as same as we have written courseJPARepository class where we are using JPA
//but here we are using concept of SpringJPA
public interface courseSpringDataJPARepository extends JpaRepository<Course,Long> {

}
