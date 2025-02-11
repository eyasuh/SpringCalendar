CREATE TABLE IF NOT EXISTS Content (
  id Integer auto_increment,
  title varchar(255) not null,
    desc text,
    status Varchar(20) not null,
    content_type varchar(50) not null,
    date_created timestamp not null,
    date_updated timestamp,
    url varchar(255),
    primary key (id)
);

INSERT INTO Content(title, desc, status, content_type, date_created)
VALUES ('My schema title', 'A schema post', 'IDEA', 'ARTICLE', CURRENT_TIME);