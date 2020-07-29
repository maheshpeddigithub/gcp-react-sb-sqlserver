1. created SQL Server instance in GCP Cloud SQL

2. add network config with '0.0.0.0' in 'Network' of 'Connections' tab of the instance to allow all traffic

4. create database, user and specify password for it

4. updated GCP SQL Server IP address, database name, user name and password in application.properties

% mvn spring-boot:run