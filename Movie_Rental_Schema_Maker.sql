CREATE SCHEMA Movie_Rental;

CREATE TABLE Movie_Rental.customers(
	customer_ID int,
    address varchar(11),
    fname varchar(11),
    minit varchar(11),
    lname varchar(11)
);

CREATE TABLE Movie_Rental.movie(
	movie_ID int,
    movie_Format varchar(11),
	movie_Genre varchar(11),
	movie_Rating varchar(11),
    movie_Director varchar(11),
    movie_Actors varchar(11)
);

CREATE TABLE Movie_Rental.inventory(
	num_of_Movies int,
    m_ID int,
    inventory_Locations varchar(11)
);

CREATE TABLE Movie_Rental.store(
	store_ID int,
    store_Location varchar(11),
    inventory_Locations varchar(11)
);

CREATE TABLE Movie_Rental.rent(
	rent_ID int,
    start_Date date,
    end_Date date,
    overdue double
);

CREATE TABLE Movie_Rental.payment(
	paid double,
    payment_Method varchar(11),
    startDate date,
    endDate date
);