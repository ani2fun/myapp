To run on local machine , Instructions :

1) Import this repository using command : git clone
2) run:    mvn clean compile . (note:  Maven blobal setting should be configuire properly in your system)
3)(Use Intellij idea to import the project...)

4) To run/debug this applications needs "edit configurations" App.java as main file.
5) Go to -> Edit Configurations -> "Main class" as: "org.tiger.App"
                                -> "Program arguments" as : " server config.yaml"
6) Apply and Run App.java (note: config.yaml is needed for dropwizard to initialise the classes for application path and rootPath information.)

7) Go to Chrome browser and Enter: http://localhost:8080/index.html
8) you will see view is being render by http jetty container.
9) Make sure to change baseURL in controller.js and service.js
   inside "resources/restoDemo/app/scripts" to "http://localhost:8080/service/" (bug: currently it's being set manually for heroku app address ..., we can modify it later for dynamic update )
10) Also you can configure MongoClient inside App.java class according to your personal mongodb database address.
11) To run on local machine we need to change monogoclient's address of MONGOLAB_URI to "mongodb://127.0.0.1:27017/{your-db-name}"