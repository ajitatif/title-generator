create table title_segments
(
    id          bigint primary key,
    description varchar(255),
    format      varchar(255)
);

create sequence ge_title_segment;

create table title_values
(
    id         bigint primary key,
    segment_id bigint references title_segments (id),
    value      varchar(63)
);

create sequence ge_title_segment;

create table title_formats
(
    id          bigint primary key,
    name varchar(255),
    format      varchar(255)
);

create sequence ge_title_format;
