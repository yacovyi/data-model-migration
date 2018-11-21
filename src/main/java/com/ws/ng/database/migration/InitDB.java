package com.ws.ng.database.migration;

import com.ws.ng.StatusHandler;
import com.ws.ng.configuration.ConfigurationProvider;
import com.ws.ng.configuration.ServiceProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import javax.inject.Inject;
import java.io.File;
import java.util.EnumSet;

public class InitDB {
    static final Logger logger = LogManager.getLogger(StatusHandler.class.getName());
    public static final String SCRIPT_FILE = "exportScript.sql";

    private ServiceProperties serviceProperties;
    @Inject
    public InitDB(ServiceProperties serviceProperties){
        this.serviceProperties = serviceProperties;
    }
    public void createTabelsFromEntities(){

        // Create the ServiceRegistry from hibernate-xxx.cfg.xml
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
                .configure(serviceProperties.getProperties().getProperty("hibernate_filename")).build();

        // Create a metadata sources using the specified service registry.
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        SchemaExport export = getSchemaExport();

        logger.info("Drop Database...");
        // Drop Database
        dropDataBase(export, metadata);

        logger.info("Create Database...");
        // Create tables
        createDataBase(export, metadata);

    }
    public SchemaExport getSchemaExport() {

        SchemaExport export = new SchemaExport();
        // Script file.
        File outputFile = new File(SCRIPT_FILE);
        String outputFilePath = outputFile.getAbsolutePath();

        logger.info("Export file: " + outputFilePath);

        export.setDelimiter(";");
        export.setOutputFile(outputFilePath);

        // No Stop if Error
        export.setHaltOnError(false);
        //
        return export;
    }

    public void dropDataBase(SchemaExport export, Metadata metadata) {
        // TargetType.DATABASE - Execute on Databse
        // TargetType.SCRIPT - Write Script file.
        // TargetType.STDOUT - Write log to Console.
        EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);

        export.drop(targetTypes, metadata);
    }

    public void createDataBase(SchemaExport export, Metadata metadata) {
        // TargetType.DATABASE - Execute on Databse
        // TargetType.SCRIPT - Write Script file.
        // TargetType.STDOUT - Write log to Console.

        EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);

        SchemaExport.Action action = SchemaExport.Action.CREATE;
        //
        export.execute(targetTypes, action, metadata);

        logger.info("Export OK");

    }
}
