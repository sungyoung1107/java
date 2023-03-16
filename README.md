#   프로젝트 이름 : KB 미니 인터넷뱅킹

## 5조는 인터페이스/클래스와 ORACLE DB를 활용해 KB국민은행 미니 인터넷뱅킹을 구현하였습니다.
사용자가 회원가입과 로그인을 통해 접속할 수 있고, 기능은 다음과 같습니다.
 - 계좌 만들기 : 사용자가 계좌를 만들 수 있음
 - 내 계좌 보기 : 인터넷뱅킹 ID로 나의 계좌 리스트 볼 수 있음
 - 이체하기 : ORACLE DB에 있는 사용자에게 이체할 수 있음
 - 계좌 해지하기 : 계좌를 해지할 수 있음
 - 내 정보 수정하기 : 비밀번호, 이름, 연락처를 변경할 수 있음
 - 인터넷 뱅킹 해지하기 : 인터넷 뱅킹 탈퇴할 수 있음


### 프로젝트 구조
<img width="800" src="https://github.com/sungyoung1107/java/blob/assignment/final_ws0315/BANK_Final.jpg" >

​
### DB 구조

CREATE TABLE account(
	
	accNum VARCHAR2(20) PRIMARY KEY,
	accHolder VARCHAR2(10),
	balance NUMBER(10),
	userId VARCHAR2(10)
);

CREATE TABLE transaction(
	
	transDate DATE PRIMARY KEY,
	accNum VARCHAR2(20),
	money NUMBER(10),
	type VARCHAR2(3), 
	rAcc VARCHAR2(20)
);


CREATE TABLE bankuser(
	
	id VARCHAR2(10) PRIMARY KEY,
	pw VARCHAR2(10),
	name VARCHAR2(10),
	contact VARCHAR2(10)
);
​
# 적용 기술 및 개발자 정보
​
## 기술 스택
  ### Back-end
    - 자바 11
    - 오라클 버전
​
## 개발 인원 및 일자
- 개발 인원 : 4명 (이성영, 조현손, 김진희, 정인보)
- 개발 일자 : 2023.03.15


# Reference
​
- 이 프로젝트는 5조의 땀이 담긴 순수 학습목적으로 제작된 뱅킹 시스템입니다.
- 학습용으로 만들었기 떄문에 이 코드를 활용하여 이득을 취하거나 무단 배포할 경우 법적으로 심히 문제될 수 있습니다.
- 이 프로젝트에서 사용하고 있는 로고와 배너는 해당 프로젝트 팀 소유이므로 해당 프로젝트 외부인이 사용할 수 없습니다.
​
![Footer](https://capsule-render.vercel.app/api?type=waving&color=ff385c&height=100&section=footer)
