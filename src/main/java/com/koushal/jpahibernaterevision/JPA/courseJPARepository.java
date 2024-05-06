package com.koushal.jpahibernaterevision.JPA;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class courseJPARepository {
    //@Autowired or we can use
    @PersistenceContext
    EntityManager entityManager;

    //this will insert course in to DB, no need to write query
    public void insert(Course course){
        entityManager.merge(course);
    }

    //this is select query
    public Course getCourseById(int id){
        return entityManager.find(Course.class,id);
    }

    //for deleting first we wil find and then we will delete
    public void deleteById(int id){
        Course course=entityManager.find(Course.class,id);
        entityManager.remove(course);
    }
}
