insert into title_segments (id, description, format)
values (nextval('ge_title_segment'),
        'Seniority',
        '%s');
insert into title_segments (id, description, format)
values (nextval('ge_title_segment'),
        'Title',
        '%t');

insert into title_values (id, segment_id, value)
values (nextval('ge_title_value'),
        (select id from title_segments where format = '%s'),
        'Senior');
insert into title_values (id, segment_id, value)
values (nextval('ge_title_value'),
        (select id from title_segments where format = '%s'),
        'Master');
insert into title_values (id, segment_id, value)
values (nextval('ge_title_value'),
        (select id from title_segments where format = '%s'),
        'Arch');
insert into title_values (id, segment_id, value)
values (nextval('ge_title_value'),
        (select id from title_segments where format = '%s'),
        'Grandmaster');
insert into title_values (id, segment_id, value)
values (nextval('ge_title_value'),
        (select id from title_segments where format = '%s'),
        'Godly');

insert into title_values (id, segment_id, value)
values (nextval('ge_title_value'),
        (select id from title_segments where format = '%t'),
        'World Greeter');
insert into title_values (id, segment_id, value)
values (nextval('ge_title_value'),
        (select id from title_segments where format = '%t'),
        'Entrepreneur');
insert into title_values (id, segment_id, value)
values (nextval('ge_title_value'),
        (select id from title_segments where format = '%t'),
        'Maiar');
insert into title_values (id, segment_id, value)
values (nextval('ge_title_value'),
        (select id from title_segments where format = '%t'),
        'Flyfighter');
insert into title_values (id, segment_id, value)
values (nextval('ge_title_value'),
        (select id from title_segments where format = '%t'),
        'Scarecrow');

insert into title_formats (id, name, format)
values (nextval('ge_title_format'),
    'standard',
    '%s %t');
insert into title_formats (id, name, format)
values (nextval('ge_title_format'),
    'so_senior',
    '%s %s %t');

