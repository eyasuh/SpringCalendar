CREATE TABLE IF NOT EXISTS Content (
  id Integer auto_increment,
  title varchar(255) not null,
    desc text,
    status Varchar(20) not null,
    dontent_type varchar(50) not null,
    date_created timestamp not null,
    date_updated timestamp,
    url varchar(255),
    primary key (id)
);