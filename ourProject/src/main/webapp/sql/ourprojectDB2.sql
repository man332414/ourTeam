-- 1. 멤버 테이블
create table member
(
	userId varchar(30) primary key,
    password varchar(100),
    email varchar(50),
    name varchar(30),
    nikName varchar(30),
    babyBirthDay date,
    telecom varchar(10),
    phone char(13),
    role ENUM('ROLE_USER', 'ROLE_ADMIN', 'ROLE_MANAGER') DEFAULT 'ROLE_USER'
);

insert into member values('administrator', 'rhksflwk1!', 'myEmail1@email.com', 'myName1', 'nicName1', '2024-12-16', 'skt', '0101010101', 'ROLE_ADMIN');
insert into member(userId, password, email, name, nikName, babyBirthDay, telecom, phone) values('myid1', 'myPassword1', 'myEmail1@email.com', 'myName1', 'nicName1', '2024-12-20', 'skt', '0101010101');
insert into member(userId, password, email, name, nikName, babyBirthDay, telecom, phone) values('myid2', 'myPassword2', 'myEmail2@email.com', 'myName2', 'nicName2', '2024-12-19', 'kt', '0101010101');
insert into member(userId, password, email, name, nikName, babyBirthDay, telecom, phone) values('myid3', 'myPassword3', 'myEmail3@email.com', 'myName3', 'nicName3', '2024-12-16', 'lgu+', '0101010101');

select * from member;
SELECT userId, password FROM member WHERE userId = 'administrator';
SELECT role FROM member WHERE userId = 'administrator';

-- 2. 게시판 테이블
create table board
(
	number int auto_increment primary key,
    date DATETIME, 
    title varchar(100),
    category char(10),
    viewCount int,
    supportDeadline date,
    content varchar(10000)
);

insert into board values(null, '2024-01-01 00:00:00', '아이돌봄 서비스', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00000024&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '산모, 신생아 건강관리 지원사업', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001188&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '청소년 산모 임신, 출산 의료비 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003246&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '지역사회서비스 투자사업', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001061&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '출산육아기 고용안정장려금', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003224&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '긴급복지 해산비 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003178&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '해산급여', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001135&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '영유아보육료 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003250&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '저소득층 기저귀,조제분유 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00000092&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '부모급여 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00004657&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '가정양육수당 지원사업', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003253&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '발달재활서비스', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003195&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '장애아보육료지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001067&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '다문화보육료지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001183&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '육아종합지원서비스', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00000030&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '첫만남이용권', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00004656&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '인플루엔자 국가예방접종 지원사업', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003213&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '의료급여임신, 출산진료비지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00000061&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '고위험 임산부 의료비 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001088&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '아동수당 지급', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001171&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '그 밖의 연장형 보육료 등 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001147&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '입양숙려기간 모자지원사업', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00000807&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '고용보험 미적용자 출산급여 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00000838&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '우체국대한민국 엄마 보험', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00005631&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '시간제보육 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00000037&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '표준모자보건수첩 제공', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001161&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '다문화가족 자녀 언어발달지원서비스', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003282&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '양육비 이행 원스톱 종합서비스', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003186&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '여성장애인 출산비용 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003278&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '모성보호육아지원(출산전후휴가(유산, 사산휴가 포함) 급여, 육아휴직 등 급여', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003226&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '어린이 국가예방접종 지원사업', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003242&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '의료급여 수급권자 영유아 건강검진비 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001185&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '의료급여(요양비)', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00000056&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '아동용품 구입비 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00005033&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '전문아동보호비 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00005032&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '아동 통합서비스 지원(드림스타트사업)', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003283&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '입양,가정위탁아동 심리치료 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003270&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '미숙아 및 선천성이상아 의료비 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003237&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '선천성 난청검사 및 보청기 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001130&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '선천성대사이상 검사 및 환아관리', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00000040&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '유아학비 지원(만3~5세 누리과정 지원)', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00000969&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '공동육아나눔터 운영', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00000028&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '(특수교육대상자) 치료지원서비스', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001113&wlfareInfoReldBztpCd=01');
insert into board values(null, '2024-01-01 00:00:00', '스포츠강좌이용권', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00000076&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '장애입양아동 의료비지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001121&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '입양비용지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001116&wlfareInfoReldBztpCd=01');
insert into board values(null, '2024-01-01 00:00:00', '장애아동입양 양육보조금', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001021&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '입양아동 양육수당 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00003235&wlfareInfoReldBztpCd=01'); 
insert into board values(null, '2024-01-01 00:00:00', '장애학생 정보격차 해소 지원', '복지로', 0, null, 'https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001075&wlfareInfoReldBztpCd=01'); 

-- 3. 달력 이벤트 테이블
CREATE TABLE CalendarEvent (
    id INT AUTO_INCREMENT PRIMARY KEY,            -- 고유 ID (자동 증가)
    title VARCHAR(255) NOT NULL,                   -- 이벤트 제목
    start DATETIME NOT NULL,                       -- 시작 날짜 및 시간
    end DATETIME,                                  -- 종료 날짜 및 시간 (선택적)
    all_day BOOLEAN,                               -- 하루 종일 이벤트 여부
    description TEXT,                              -- 이벤트 설명 (선택적)
    location VARCHAR(255),                         -- 이벤트 위치 (선택적)
    category VARCHAR(255),                         -- 이벤트 카테고리
	userId INT,                                   -- 사용자 ID (member 테이블의 userId 참조)
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- 생성일시
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일시
    FOREIGN KEY (userId) REFERENCES member(userId) ON DELETE CASCADE -- 외래키 제약조건, 삭제시 Cascade
);

insert into CalendarEvent values(null, 'mySchedule', '2024-12-20 16:00:00', NULL, '0', NULL, NULL, '회의', '2024-12-20 16:00:00', '2024-12-20 16:00:02');
insert into CalendarEvent values(null, 'mySchedule2', '2024-12-20 16:00:00', NULL, '0', NULL, NULL, '회의', '2024-12-20 16:00:00', '2024-12-20 16:00:02');
insert into CalendarEvent values(null, 'mySchedule3', '2024-12-20 16:00:00', NULL, '0', NULL, NULL, '회의', '2024-12-20 16:00:00', '2024-12-20 16:00:02');

select * from member;
select * from CalendiarEvent;
select * from board;
delete from member where userId='231';
drop table CalendarEvent;
drop table member;
drop table board;