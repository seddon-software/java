REM -----------------------------------------------------------------
REM
REM	Using the Deployer Tool
REM
REM -----------------------------------------------------------------

  cls
  
REM -- set paths
  set CLASSPATH=.;C:\Oracle\Middleware\wlserver_10.3\server\lib\weblogic.jar
  set PATH=.;C:\Oracle\Middleware\jdk160_14_R27.6.5-32\bin

REM -- deploy to cluster
  java weblogic.Deployer ^
       -adminurl t3://localhost:7001 ^
       -name "Clustered servlets" ^
       -source C:\Workspace\logica\Servlets\ServletDemos.war ^
       -targets Cluster_1 ^
       -user weblogic -password weblogic1 ^
       -deploy

pause

