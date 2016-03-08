Running Instructions :

1) Import this repository using command : git clone
2) run:    mvn clean compile . (note:  Maven blobal setting should be configuire properly in your system)
3) To run/debug this applications needs "edit configurations" App.java as main file.
4) Go to -> Edit Configurations -> "Main class" as: "org.tiger.App"
                                -> "Program arguments" as : " server config.yaml"
5) Apply and Run App.java

6) Go to Chrome browser and Enter: http://localhost:8080/index.html
7) you will see view is being render by http jetty container.
8) Make sure to change baseURL in controller.js and service.js
   inside "resources/restoDemo/app/scripts" to "http://localhost:8080/service/"
9) Also you can configure MongoClient inside App.java class