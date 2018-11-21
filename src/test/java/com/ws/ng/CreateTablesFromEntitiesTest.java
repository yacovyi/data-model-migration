package com.ws.ng;

import com.ws.ng.database.migration.InitDB;
import com.ws.ng.database.model.Chapter;
import com.ws.ng.database.model.Investigation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateTablesFromEntitiesTest {
    static final Logger logger = LogManager.getLogger(StatusHandler.class.getName());

    @Test
    public void createTabelsFromEntities(){



        Transaction transObj = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            //drop all tables and recreate tables
            InitDB.createTabelsFromEntities();

            //begin transaction
            transObj = session.beginTransaction();;

            //create investigation
            Investigation investigation ;
            investigation = new Investigation();
            investigation.setInvestigation_wsid("IN2");
            investigation.setCase_wsid("CA1");

            //create chapter
            List<Chapter> chapters = new ArrayList<>();
            for(int i=1;i<=10;i++){

                //create new chapter
                Chapter chapter = new Chapter();

                //set chapter details
                chapter.setChapterWSID("CH" + i);
                chapter.setChapterName("chapter " + i);
                chapter.setChapterName("chapter description -- " + i);
                //set investigation (fk)
                chapter.setInvestigation(investigation);

                //add chapter to chapters
                chapters.add(chapter);
            }

            //save investigation first
            session.save(investigation);

            //save chapters after saving investigation
            for (Chapter chapter : chapters) {
                session.save(chapter);
            }

            //commit
            transObj.commit();


        }catch (Exception err){
            logger.error(err);
            //rollback on error
            if (transObj!= null){
                transObj.rollback();
            }
            throw new RuntimeException(err);
        }

    }



}
