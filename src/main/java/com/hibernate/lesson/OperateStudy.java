package com.hibernate.lesson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//新建数据库 创建内容
public class OperateStudy {
    public static void main(String[] args) {

        Configuration con=new Configuration().configure();//创建配置文件
        SessionFactory sf=con.buildSessionFactory();//创建会话工厂

        Session session=sf.openSession();//新建session 管理器
        Transaction tx=null;//增加修改的时候创建Transaction
        try {
            tx=session.beginTransaction();//添加事务
            StudyEntity s=new StudyEntity();//保存数据
            s.setName("hibernate2");//开始创建数据
            s.setLesson("1105");

            session.save(s);//调用数据库中的一条数据

            tx.commit();//提交事务
        }catch (Exception e){
            if (tx!=null) {
                tx.rollback();
            }
        }

    }
}
