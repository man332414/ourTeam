-- 1. 멤버 테이블
create table member
(
	userId varchar(30) primary key,
    password varchar(50),
    email varchar(50),
    name varchar(30),
    nikName varchar(30),
    babyBirthDay date,
    telecom varchar(10),
    phone char(11)
);

insert into member values('myid1', 'myPassword1', 'myEmail1@email.com', 'myName1', 'nicName1', '2024-12-20', 'skt', '0101010101');
insert into member values('myid2', 'myPassword2', 'myEmail2@email.com', 'myName2', 'nicName2', '2024-12-19', 'kt', '0101010101');
insert into member values('myid3', 'myPassword3', 'myEmail3@email.com', 'myName3', 'nicName3', '2024-12-18', 'lgu+', '0101010101');

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

insert into board values(null, '2024-12-20 16:00:00', 'myTitle', '공지사항', 0, null, 'myContent'); 
insert into board values(null, '2024-12-20 16:00:00', 'myTitle1', '공지사항', 0, null, 'myContent1'); 
insert into board values(null, '2024-12-20 16:00:00', 'myTitle2', '공지사항', 0, null, 'myContent2'); 

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
--     user_id INT,                                   -- 사용자 ID (member 테이블의 userId 참조)
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- 생성일시
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 수정일시
--     FOREIGN KEY (user_id) REFERENCES member(userId) ON DELETE CASCADE -- 외래키 제약조건, 삭제시 Cascade
);

insert into CalendarEvent values(null, 'mySchedule', '2024-12-20 16:00:00', NULL, '0', NULL, NULL, '회의', '2024-12-20 16:00:00', '2024-12-20 16:00:02');
insert into CalendarEvent values(null, 'mySchedule2', '2024-12-20 16:00:00', NULL, '0', NULL, NULL, '회의', '2024-12-20 16:00:00', '2024-12-20 16:00:02');
insert into CalendarEvent values(null, 'mySchedule3', '2024-12-20 16:00:00', NULL, '0', NULL, NULL, '회의', '2024-12-20 16:00:00', '2024-12-20 16:00:02');

select * from member;

delete from member where userId=231;