package com.ws.ng;

import com.ws.ng.database.migration.InitDB;
import com.ws.ng.database.model.Chapter;
import com.ws.ng.database.model.Investigation;
import com.ws.ng.providers.PropertiesProvider;
import com.ws.ng.providers.SessionFactoryCreator;
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
    public void createTabelsFromEntities() throws ClassNotFoundException {


        try
        {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e)
        {
            throw new ClassNotFoundException("PostgreSQL JDBC driver NOT detected in library path.", e);
        }
        Transaction transObj = null;

        try(Session session = new SessionFactoryCreator(new PropertiesProvider()).getSessionFactory().openSession())
        {
            //session.getSessionFactory().getAllClassMetadata()
            //drop all tables and recreate tables
            new InitDB(new PropertiesProvider()).createTabelsFromEntities();

            //begin transaction
            transObj = session.beginTransaction();

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
