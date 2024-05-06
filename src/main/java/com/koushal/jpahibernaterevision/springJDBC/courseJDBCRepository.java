package com.koushal.jpahibernaterevision.springJDBC;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//This is the bean/component which interact with database
//For firing this query at start of application spring provided interface which we implement
//known as CommandLineRunner
@Repository
public class courseJDBCRepository {

    //This is the class provided by spring to interact with database using jdbc
    @Autowired
    JdbcTemplate springJDBCTemplate;
    public static String INSERT_QUERY=
            """ 
                                       insert into course (id, name, author)
                                       values (?,?,?);
            """;

    public static String DELETE_QUERY_WITH_ID=
            """ 
                                       delete from course where id=?;
            """;

    public static String SELECT_QUERY_WITH_ID=
            """ 
                                       select * from course where id=?;
            """;

    public void insert(){
        springJDBCTemplate.update(INSERT_QUERY);
    }

    public void insert(Course course){
        springJDBCTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }

    public void deleteCourse(int id){
        springJDBCTemplate.update(DELETE_QUERY_WITH_ID,id);
    }

    public Course getCourseWithID(int id){
        //This will return row which is converted to bean by spring and automatically working we should have
        //attribute name same as column name in sql table.
        //ResultSet ==> Bean ==> RowMapper
        return springJDBCTemplate.queryForObject(SELECT_QUERY_WITH_ID,new BeanPropertyRowMapper<>(Course.class),id);
    }

}
