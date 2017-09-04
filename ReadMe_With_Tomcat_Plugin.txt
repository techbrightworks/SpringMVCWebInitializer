MavenBuild
-----------
1.Go to the Directory SpringMVCWebInitializer
2.Use Command: mvn clean install eclipse:clean eclipse:eclipse -Dwtpversion=2.0
3.Use Command: to Skip Tests use -DskipTests
4.Once the  Build  is successful, Refresh the project on your IDE.
5.SpringMVCWebInitializer.war would be now found in the  target Folder of the project.
6a.mvn tomcat7:run-war would  run with an embedded Apache Tomcat and helps to quickly develop your application 
   without needing to install a standalone Tomcat instance.
6b.Example url with port 8080, http://localhost:8080/SpringMVCWebInitializer/helloworld.html 
6c.If you wanted to use Standalone Tomcat Instance then you can Deploy the war in the Tomcat,version of Tomcat that can be used is 7.0.37.