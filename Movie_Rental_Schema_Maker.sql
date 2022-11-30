CREATE SCHEMA Movie_Rental;

CREATE TABLE Movie_Rental.customers(
	customer_ID int,
    address varchar(100),
    fname varchar(11),
    minit varchar(11),
    lname varchar(11),
    Primary key (customer_ID)
);

CREATE TABLE Movie_Rental.movie(
	movie_ID int,
    movie_name varchar(45),
    movie_runtime varchar(8),
	movie_Genre varchar(11),
	movie_Rating varchar(10),
    movie_Director varchar(45),
    movie_releaseDate varchar(10),
    primary key (movie_ID)
);

CREATE TABLE Movie_Rental.store(
	store_ID int,
    store_Location varchar(45),
    primary key (store_ID),
    UNIQUE (store_Location)
);

CREATE TABLE Movie_Rental.inventory(
	num_of_Movies int,
    m_ID int,
    inventory_Locations varchar(45),
    primary key (num_of_Movies),
    foreign key (inventory_Locations) references store(store_Location)
);

CREATE TABLE Movie_Rental.rent(
	rent_ID int,
    start_Date date,
    end_Date date,
    overdue double,
    primary key (rent_ID),
    UNIQUE (start_Date),
    UNIQUE (end_Date)
);

CREATE TABLE Movie_Rental.payment(
	payment_ID int,
    paid double,
    payment_Method varchar(11),
    startDate date,
    endDate date,
    primary key (payment_ID),
    foreign key (startDate) references rent(start_Date),
    foreign key (endDate) references rent(end_Date)
);