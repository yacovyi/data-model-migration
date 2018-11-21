# Webserver Template Project
***
This project is supposed to be a template for a basic webserver micro-service.
***

**You should use this template if your microservice answers the following restrictions:**
1. It does one or all of the following:
    1. Receive rest calls and responds
    2. Retrieves data from DB to answer a rest call
    3. Updates data in DB due to a rest call
    4. Sends messages to kafka to inform about what the webserver did
2. It does not do any of the following:
    1. Consume messages from kafka
    2. Background work of any kind
    3. Send messages to kafka on topics not specific to this webserver!
    
**It should:**    
1. Not need to call other micro-services in order to respond a rest call.

***
**Please follow the guidelines in the wiki when implementing your microservice!**
***

**This template uses:**
1. Maven 3.3.9+
1. Java 8
1. Grizzly webserver
1. Jersey as the rest framework on top of grizzly
1. Jackson as the JSON library
1. Junit 5 as the testing framework
1. Docker as the containerization layer


***
**Some Explanations:**
- Main.java is the runnable (Bootstrapper)
- As long as the APIs/Handlers are in the same package as Main (or under it), 
you do not need to register them manually in Main for them to be recognized
- Create the jar using `mvn package`
- Create the docker image using the `create_image.sh` script *(takes 2 minutes)*
- Run the docker image locally using the `start_container.sh` script
***
##### Please do not forget to change all template names in POM and scripts and update this readme according to your microservice



**Missing from the template:**
1. Configuration management
1. Elasticsearch Client
1. Redis Client
1. Kafka Producer
1. unit-test example
1. proper documentation
1. template variables

#liquibase commands

###Generate ChangeLogFile
`mvn liquibase:generateChangeLog -Dliquibase.outputChangeLogFile=output.xml`
###Run all liquibase changes
`mvn liquibase:update`
###Run Rolleback to tag
`mvn liquibase:rollback -Dliquibase.rollbackTag=1.0`
###update to tag
`mvn liquibase:update -Dliquibase.toTag=1.1`

###generate sql to rollback 1 version backwards  
`mvn liquibase:rollbackSQL -Dliquibase.rollbackCount=2` 

###generate sql to rollback to specific tag  
`mvn liquibase:rollbackSQL -Dliquibase.rollbackTag=1.0
`