//memberentity 데이터테이블 생성
create table memberentity
(
    coDeuserCd varchar(20)  null,
    coUserCd   varchar(20)  null,
    coAddress  varchar(100) null,
    coDeparCd  varchar(10)  null,
    coDeuserNm varchar(50)  null,
    coEmail    varchar(100) null,
    coId       varchar(20)  not null
        primary key,
    coJoinDate date         null,
    coName     varchar(50)  null,
    coPhone    varchar(15)  null,
    coPosiCd   varchar(10)  null,
    coPwd      varchar(100) null,
    coUserNm   varchar(50)  null
);




