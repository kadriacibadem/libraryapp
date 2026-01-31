create table if not exists publisher(
                                        publisher_id bigint generated always as identity primary key,
                                        publisher_name varchar(255)
    );
create table if not exists book(
                                   book_id bigint generated always as identity primary key,
                                   title varchar(255),
    price decimal(10,2),
    isbn_13 varchar(255),
    publisher_id bigint,
    author_id bigint
    );
create table if not exists author(
                                     author_id bigint generated always as identity primary key,
                                     author_name_surname varchar(255)
    );