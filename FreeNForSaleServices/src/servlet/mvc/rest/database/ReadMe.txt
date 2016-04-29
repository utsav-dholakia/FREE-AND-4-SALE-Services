Project Requirements:
Webserver: Apache Tomcat v 8.0.33 (2 instance : 1 for Webserver and other for Rest Service)
Cache Server: Cache: MemCache Cache Server.
Execution Environment: JDk 1.8
Database: MySQL v5.7.11
Broswer: Mozilla Firefox v45.0.2

Considering above configurations are done. Follow the below steps:
1) Run the script provided to create database.
2) Start the MemCache Server which is configured on localhost:11211
3) Keep the war files in respective Tomcat Server Instance(Webserver named as Client and RestService Server named as Service)
4) Make the changes in server.xml for database and  https port.
5) We are using port 9443 for website and port 8443 for restService Server.
6) Start the servers and go to following URL in browser: https://localhost:9443/FreeNForSaleWebpage/

