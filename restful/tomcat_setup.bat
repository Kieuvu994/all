@echo off
 
:: 프로젝트 이름
set project_name=GlueSample

:: Maven에서 빌드후 생성해주는 war 파일
set to_gen_war=GlueSample.war

:: 빌드후 생성된 war 파일을 복사할 대상 war 파일, 톰캣에서 바라보는 webapps 디렉토리
set target_webapp_dir=C:\apache-tomcat-8.5.60\webapps\

:: 프로젝트의 컨텍스트 패스
set target_webapp_war_name=GlueSample

:: 변수 설정 끝

:: 기존 배포된 디렉토리 지우기
::rd /s /q %target_webapp_dir%%target_webapp_war_name%

:: maven 으로 war 파일 생성될때까지 기다림
start /wait cmd /c mvn install

cd target

:: war 파일을 개발서버 톰캣 webapps 폴더로 복사
copy %to_gen_war% %target_webapp_dir%%target_webapp_war_name%.war

:: 톰캣 시작
C:\apache-tomcat-8.5.60\bin\startup.bat