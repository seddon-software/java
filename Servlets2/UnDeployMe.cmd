REM -----------------------------------------------------------------
REM
REM	Undeploying using the Deployer Tool
REM
REM -----------------------------------------------------------------

  cls
  
REM -- set paths
  set CLASSPATH=.;C:\Oracle\Middleware\wlserver_10.3\server\lib\weblogic.jar
  set PATH=.;C:\Oracle\Middleware\jdk160_14_R27.6.5-32\bin

REM -- undeploy to cluster
  java weblogic.Deployer ^
       -adminurl t3://localhost:7001 ^
       -name "Clustered servlets" ^
       -user weblogic -password weblogic1 ^
       -undeploy

pause

