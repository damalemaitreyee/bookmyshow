CREATE schema IF NOT EXISTS movie_booking;

DROP TABLE IF EXISTS movie_booking.userinfo CASCADE;
CREATE TABLE IF NOT EXISTS movie_booking.userinfo (
   user_id INT PRIMARY KEY,
   user_name VARCHAR(50) unique not null,
   user_password VARCHAR(50) not NULL
);

DROP TABLE IF EXISTS movie_booking.movie CASCADE;
CREATE TABLE IF NOT EXISTS movie_booking.movie (
   movie_id INT PRIMARY KEY,
   movie_name VARCHAR(50) unique not null
);

DROP TABLE IF EXISTS movie_booking.show CASCADE;
CREATE TABLE IF NOT EXISTS movie_booking.show (
   show_id INT PRIMARY KEY,
   movie_id INT,
   screen_id INT,
   start_time VARCHAR(50) not NULL,
   end_time VARCHAR(50) not NULL,
   CONSTRAINT fk_movie_id
   FOREIGN KEY(movie_id)
   REFERENCES movie_booking.movie(movie_id)
);

DROP TABLE IF EXISTS movie_booking.screen CASCADE;
CREATE TABLE IF NOT EXISTS movie_booking.screen (
   screen_id INT PRIMARY KEY,
   total_seats INT
);

DROP TABLE IF EXISTS movie_booking.seat CASCADE;
CREATE TABLE IF NOT EXISTS movie_booking.seat (
   seat_id INT primary key,
   screen_id INT,
   CONSTRAINT fk_screen_id
      FOREIGN KEY(screen_id)
      REFERENCES movie_booking.screen(screen_id)
);

DROP TABLE IF EXISTS movie_booking.booking CASCADE;
CREATE TABLE IF NOT EXISTS movie_booking.booking (
   booking_id INT PRIMARY KEY,
   show_id INT,
   user_id INT,

	CONSTRAINT fk_showid
      FOREIGN KEY(show_id)
	  REFERENCES movie_booking.show(show_id),
	CONSTRAINT fk_userid
      FOREIGN KEY(user_id)
	  REFERENCES movie_booking.userinfo(user_id)
);

DROP TABLE IF EXISTS movie_booking.seat_reserved CASCADE;
CREATE TABLE IF NOT EXISTS movie_booking.seat_reserved (
   id INT primary key,
   seat_id INT,
   show_id INT,
   booking_id INT,
   CONSTRAINT fk_seat_id
      FOREIGN KEY(seat_id)
      REFERENCES movie_booking.seat(seat_id),

   CONSTRAINT fk_show_id
         FOREIGN KEY(show_id)
         REFERENCES movie_booking.show(show_id),

   CONSTRAINT fk_booking_id
         FOREIGN KEY(booking_id)
         REFERENCES movie_booking.booking(booking_id)
);


INSERT INTO movie_booking.userinfo(user_name, user_id, user_password)
	VALUES
	('mad',1, '1234mad'),
	('djoshi',2, '1234dj'),
	('mukta',3, '1234mukta');

INSERT INTO movie_booking.movie(
	movie_name, movie_id)
	VALUES ('DDLJ', 1),
	('K3G', 2),
	('RHTDM', 3);

INSERT INTO movie_booking.show(show_id, movie_id, screen_id, start_time, end_time)
	VALUES
	(1, 1, 1, 9, 12),
	(2, 1, 2, 9, 12),
	(3, 2, 2, 12, 3),
	(4, 3, 1, 12, 3);

INSERT INTO movie_booking.screen(screen_id, total_seats)
	VALUES
	(1, 3),
	(2, 3);

INSERT INTO movie_booking.seat(seat_id, screen_id)
	VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(4, 2),
	(5, 2),
	(6, 2);

INSERT INTO movie_booking.booking(booking_id, show_id, user_id)
	VALUES
	(1, 1, 1),
	(2, 2, 2),
	(3, 3, 3),
	(4, 4, 1);

INSERT INTO movie_booking.seat_reserved(id, seat_id, show_id, booking_id)
	VALUES
	(1, 1, 1, 1),
	(2, 2, 1, 1),
	(3, 4, 2, 2),
	(4, 5, 2, 2),
	(5, 4, 3, 3),
	(6, 1, 4, 4),
	(7, 2, 4, 4),
	(8, 3, 4, 4);

select * from movie_booking.userinfo;
select * from movie_booking.booking;
select * from movie_booking.movie;
select * from movie_booking.show;
select * from movie_booking.screen;
select * from movie_booking.seat;
select * from movie_booking.seat_reserved;