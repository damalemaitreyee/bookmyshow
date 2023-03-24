CREATE schema IF NOT EXISTS movie_booking;

DROP TABLE IF EXISTS movie_booking.userinfo CASCADE;
CREATE TABLE IF NOT EXISTS movie_booking.userinfo ( 	
   user_name VARCHAR(50) unique not null,
   user_id INT PRIMARY KEY,
   user_password VARCHAR(50) not NULL
);

DROP TABLE IF EXISTS movie_booking.movie CASCADE;
CREATE TABLE IF NOT EXISTS movie_booking.movie (
   movie_name VARCHAR(50) unique not null,
   movie_id INT PRIMARY KEY
);

DROP TABLE IF EXISTS movie_booking.movie_show CASCADE;
CREATE TABLE IF NOT EXISTS movie_booking.movie_show (
   movie_id INT,
   show_id INT PRIMARY KEY,
   timing VARCHAR(50) not NULL,
	CONSTRAINT fk_movieid
      FOREIGN KEY(movie_id) 
	  REFERENCES movie_booking.movie(movie_id)
);

DROP TABLE IF EXISTS movie_booking.screen CASCADE;
CREATE TABLE IF NOT EXISTS movie_booking.screen (
   show_id INT,
   screen_id INT,
   movie_id INT,
	total_seats Int not null,
	remaining_seats Int not null,
	CONSTRAINT fk_showid
      FOREIGN KEY(show_id) 
	  REFERENCES movie_booking.movie_show(show_id),
	CONSTRAINT fk_movieid
      FOREIGN KEY(movie_id) 
	  REFERENCES movie_booking.movie(movie_id),
	primary key(screen_id,show_id)
);

DROP TABLE IF EXISTS movie_booking.seat CASCADE;
CREATE TABLE IF NOT EXISTS movie_booking.seat (
   seat_id INT,
   screen_id INT,
	primary key(seat_id, screen_id)
);

DROP TABLE IF EXISTS movie_booking.booking CASCADE;
CREATE TABLE IF NOT EXISTS movie_booking.booking (
   user_id INT,
   booking_id INT PRIMARY KEY,
   show_id INT,
   screen_id INT,
	seats Int [] not null,
	CONSTRAINT fk_showid
      FOREIGN KEY(show_id) 
	  REFERENCES movie_booking.movie_show(show_id),
	CONSTRAINT fk_userid
      FOREIGN KEY(user_id) 
	  REFERENCES movie_booking.userinfo(user_id)
-- 	CONSTRAINT fk_screenid
--       FOREIGN KEY(screen_id) 
-- 	  REFERENCES movie_booking.screen(screen_id)
);

INSERT INTO movie_booking.userinfo(
	user_name, user_id, user_password)
	VALUES ('mad',1, '1234mad'),
	('djoshi',2, '1234dj'),
	('mukta',3, '1234mukta');

INSERT INTO movie_booking.movie(
	movie_name, movie_id)
	VALUES ('DDLJ', 1),
	('K3G', 2),
	('RHTDM', 3);
	
INSERT INTO movie_booking.movie_show(
	movie_id, show_id, timing)
	VALUES (2, 1, '12pm-3pm'),
	(3, 2, '1pm-4pm'),
	(1, 3, '8am-11am'),
	(3, 4, '5pm-8pm');

INSERT INTO movie_booking.screen(
	show_id, screen_id, movie_id, total_seats, remaining_seats)
	VALUES (3, 2, 1, 3, 1),
	(4, 3, 3, 3, 1),
	(1, 2, 2, 3, 1);
	
INSERT INTO movie_booking.seat(seat_id, screen_id)
	VALUES (1, 2),
	(2, 2),
	(3, 2),
	(1, 3),
	(2, 3),
	(3, 3);

INSERT INTO movie_booking.booking(
	user_id, booking_id, show_id, screen_id, seats)
	VALUES
	(1, 1, 3, 2, '{1,3}'),
	(2, 2, 4, 3, '{1,2}'),
	(3, 3, 1, 2, '{2,3}');
	
	
select * from movie_booking.userinfo;
select * from movie_booking.movie;
