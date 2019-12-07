:: To geerate javadocs from Eclipse use Export/Java/Javadoc

@REM -- set paths
  set PATH="C:\Program Files\Java\jdk1.6.0_26\bin"

@REM -- change drive and directory
  rem %~d0
  cd /d %~dp0
  cd ../src
  cd
    
@REM -- create JavaDocs
  javadoc -sourcepath . -d ../doc myclasses
  
pause








