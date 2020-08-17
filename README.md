Spring Boot mysql Rest Crud

Database:
I used mysql and it is changeable by changing the url at applicaiton.properties file and also add the dependencies at POM file.

Database url:
Change the database url and also username and password at application.properties file

Server Port:

I am using 8083 and it is changeable at application.properties file.

Compile application.

Application will compile at any Id's (Eclipse, intellij)

Build and Run by maven.

mvn clean install 

java -jar restcrud-1.0.jar

After running the application use to check test url.
localhost:8083/restcrud/persons

PostMan collection:

Post man colletion is also availabe with code to test all crud oprations. I have writen json in the body of the request.

If you have any question or need any help email me at ghm.murtaza@gmail.com



