package com.hibernate.lesson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SelectStudy {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure();
        SessionFactory sf=con.buildSessionFactory();
        Session se=sf.openSession();

        //查询操作
        StudyEntity sty=(StudyEntity) se.get(StudyEntity.class,3);//get方法返回的是一个对象
        System.out.println(sty.getName()+" "+sty.getLesson());

        //更新操作
        sty.setLesson("java");
        sty.setName("spring");
        Transaction tx=se.beginTransaction();
        se.save(sty);
        tx.commit();
        //重新查看
        sty=(StudyEntity) se.get(StudyEntity.class,3);
        System.out.println(sty.getName()+" "+sty.getLesson());
        //删除操作
        tx=se.beginTransaction();
        sty=(StudyEntity) se.get(StudyEntity.class,3);
        se.delete(sty);
        tx.commit();
        se.close();

    }
}
