package com.ws.ng;

import com.ws.ng.database.migration.InitDB;
import com.ws.ng.database.model.Chapter;
import com.ws.ng.database.model.Investigation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

public class CreateTablesFromEntitiesTest {

    @Test
    public void createTabelsFromEntities(){

        InitDB.createTabelsFromEntities();

        Transaction transObj = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            //begin transaction
            transObj = session.beginTransaction();;

            //create investigation
            Investigation investigation ;
            investigation = new Investigation();
            investigation.setInvestigation_wsid("IN1");
            investigation.setCase_wsid("CA1");

            //create chapter
            Chapter chapter = new Chapter();

            chapter.setChapterWSID("CH1");
            chapter.setInvestigation(investigation);

            //save entites
            session.save(investigation);
            session.save(chapter);

            //commit
            transObj.commit();


        }catch (Exception err){

            //rollback on error
            if (transObj!= null){
                transObj.rollback();
            }
        }

    }



}
