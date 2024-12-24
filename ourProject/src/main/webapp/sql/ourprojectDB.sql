-- 1. emergencyroom:응급실 테이블
CREATE TABLE emergencyroom -- 응급실 테이블
(   num 	INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
	hosName VARCHAR(100),        -- 병원이름
	hosaddr VARCHAR(100),        -- 병원주소
	distance int,              -- 거리
	travelTime time,           -- 이동시간
	numOfBad int,              -- 응급실병상수
	isPediatrics boolean,      -- 소아과보유여부
    isObstetricsAndGynecology boolean   -- 산부인과보유여부
    xPos DECIMAL(10, 8),         -- 위도
    yPos DECIMAL(11, 8)          -- 경도
);

INSERT INTO emergencyroom VALUES(0, '창원병원', '경남 창원시 성산구 창원대로 721', 11, '0:20', 10, false,true,37.27798550,127.02742710);
INSERT INTO emergencyroom VALUES(0, '삼성창원병원', '경남 창원시 마산회원구 팔용로 158', 3, '0:08', 15, true,true,37.27798550,127.02742710);
INSERT INTO emergencyroom VALUES(0, '창원경상국립대학교병원', '경남 창원시 성산구 삼정자로 11', 21, '0:30', 20, true,false,37.27798550,127.02742710);

-- 2. buychecklist: 용품 테이블
CREATE TABLE buychecklist -- 용품 테이블
(   num 	INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
	useCategory VARCHAR(100),        -- 분류(용도)
	gradeCategory VARCHAR(100),      -- 분류(사용시기): a-출산,b-육아
    productName VARCHAR(100),        -- 품명
	productPrice int,                -- 취득가격
	quantity int,                    -- 구매갯수
	acquisitionPath VARCHAR(100),    -- 취득경로
    acquisitionMethod VARCHAR(100)   -- 취득방법
);

INSERT INTO buychecklist VALUES(0, '산모용', '출산','손목보호대', 20000, 2, '인터넷쇼핑몰','현금');
INSERT INTO buychecklist VALUES(0, '산모용', '출산','오버나티트', 20000, 10, '인터넷쇼핑몰','현금');
INSERT INTO buychecklist VALUES(0, '산모용', '출산','가습기', 100000, 1, '인터넷쇼핑몰','현금');

-- 3. parentingDiary: 성장일기 테이블
CREATE TABLE parentingDiary 
(   id INT AUTO_INCREMENT PRIMARY KEY,
    today DATETIME NOT NULL,
    weather VARCHAR(255),
    myMood VARCHAR(255),
    diaryText TEXT NOT NULL,
    fileName VARCHAR(255)
);

INSERT INTO parentingDiary VALUES(0, '2024-12-10', '맑음','즐거움', '즐거운 하루','');
INSERT INTO parentingDiary VALUES(0, '2024-12-09 13:00:00', '좋음','즐거움', '즐거운 하루','');
INSERT INTO parentingDiary VALUES(0, '2024-12-08 13:00:00', '흐림','흐려도 좋음', '날마다 계속되는 즐거운 하루','');
