### Spring

Spring 프로젝트를 처음 시작할 때 순서를 정리 하기 위한 문서.

추후 Spring-start 폴더로 예제와 함께 옮겨질 예정

#### 환경

- Java-version: java version "1.8.0_241"
  - `````bash
        $java -version
        java version "1.8.0_241"
        Java(TM) SE Runtime Environment (build 1.8.0_241-b07)
        Java HotSpot(TM) 64-Bit Server VM (build 25.241-b07, mixed mode)
        ```
        ````
    `````
- IDE: Spring tool suite 4
- WAS: Tomcat 8.5

#### 참고

- spring tool suite4 의 경우 설치후 `new - spring legecy project` 메뉴가 없다.
  - `help- eclipse marketplace` 에서 `Spring Tools 3 Add-On for Spring Tools 4`를 찾아 인스톨 한다.
- spring starter project 는 spring boot 프로젝트이다.

#### 순서

- tomcat

- new -> spring regecy project
  ```- simple java
      - 최상위 패키지 없이 기본 spring 구성 및 java 빌드를 사용해 간단한 spring 프로젝트를 생성
  - simple spring maven
      - spring 라이브러리의 기본 세트를 포함하는 maven을 사용해 간단한 spring프로젝트를 생성
  - simple spring web maven
      - spring 웹 라이브러리의 기본 세트를 포함, maven을 사용하여 간단한 spring 웹 프로젝트를 생성
  - spring mvc project
      - 기본적인 mvc 형태로 maven까지 세팅이 되어 생성.
  ```
  - spring mvc project 프로젝트 생성
    - **todo: workingset?** [X]
  - com.springsample.sampleapp
  - finish

https://download.oracle.com/otn/nt/oracle11g/xe/OracleXE112_Win64.zip?AuthParam=1584943334_791b99831cb3f2a52ee051c8d53df286
https://download.springsource.com/release/STS/3.9.3.RELEASE/dist/e4.8/spring-tool-suite-3.9.3.RELEASE-e4.8.0-win32-x86_64.zip
http://mirror.apache-kr.org/tomcat/tomcat-8/v8.5.53/bin/apache-tomcat-8.5.53-windows-x64.zip
