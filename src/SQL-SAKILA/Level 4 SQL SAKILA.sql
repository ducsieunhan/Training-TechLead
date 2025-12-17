-- Level 4
-- 1. Write a SQL query to update the rental rate of all films in the database that have been rented more than 100 times, setting the new rental rate to be 10% higher than the current rate.
use sakila;

UPDATE film
SET rental_rate = rental_rate * 1.10
WHERE film_id IN (
    SELECT film_id FROM (
        SELECT i.film_id
        FROM inventory i
        JOIN rental r ON i.inventory_id = r.inventory_id
        GROUP BY i.film_id
        HAVING COUNT(*) > 100
    ) AS t
);

-- 2. Write a SQL query to update the rental duration of all films in the database that have been rented more than 5 times,
-- setting the new duration to be 5% longer than the current duration.

UPDATE film
SET rental_duration = rental_duration * 1.05
Where film_id IN (
	select film_id from (
		SELECT i.film_id
        FROM inventory i
        JOIN rental r ON i.inventory_id = r.inventory_id
        GROUP BY i.film_id
        HAVING COUNT(*) > 5
    ) as t 
); 

-- 3. Write a SQL query to update the rental rate of all films in the 'Action' category that were released before the year 2005,
-- setting the new rate to be 20% higher than the current rate.

UPDATE film
SET rental_rate = rental_rate * 1.10
WHERE film_id IN (
    SELECT film_id FROM (
        select f.film_id from
        film_category fc 
        Join category c on fc.category_id = c.category_id
        Join film f on fc.film_id = f.film_id
        where c.name = "Action"
        AND f.release_year < 2005 
    ) AS t
);

select f.film_id, f.rental_rate, f.title, f.release_year from
        film_category fc 
        Join category c on fc.category_id = c.category_id
        Join film f on fc.film_id = f.film_id
        where c.name = "Action" ;
        
-- 4. Write a SQL query to update the email address of all customers who have rented a film from the 'Horror' category 
-- in the month of October 2022, setting the new email address to be a combination of their current email address and the string 'horrorlover'.

update customer 
set email = CONCAT(email, 'horrorlover')
where customer_id IN (
	select customer_id from (
		select c.customer_id
        from customer c 
        join rental r ON c.customer_id = r.customer_id
        Join inventory i ON r.inventory_id = i.inventory_id
		join film f ON i.film_id = f.film_id
        Join film_category fc ON f.film_id = fc.film_id
        Join category ca on fc.category_id = ca.category_id
        WHERE ca.name = "Horror"
        and r.rental_date between '2022-10-01' AND '2022-10-30'
	) as t
);

-- 5. Write a SQL query to update the rental rate of all films in the database that have been rented by more than 10 customers, 
-- setting the new rate to be 5% higher than the current rate, but not higher than $4.00.

UPDATE film
SET rental_rate = Least(rental_rate * 1.05, 4.00) 
WHERE film_id IN (
    SELECT film_id FROM (
        SELECT i.film_id
        FROM inventory i
        JOIN rental r ON i.inventory_id = r.inventory_id
        GROUP BY i.film_id
        HAVING COUNT(distinct r.customer_id) > 10
    ) AS t
);

-- 6. Write a SQL query to update the rental rate of all films in the database that have a rating of 'PG-13' and a length of more than 2 hours,
-- setting the new rate to be $3.50.

UPDATE film
SET rental_rate = 3.5
WHERE film_id IN (
    SELECT film_id FROM (
        select f.film_id
        from film f 
        where f.rating = "PG-13" and f.length > 120 
    ) AS t
);


-- 7. Write a SQL query to update the rental duration of all films in the 'Sci-Fi' category that were released in the year 2010,
-- setting the new duration to be equal to the length of the film in minutes.

UPDATE film
SET rental_duration = length
WHERE film_id IN (
    SELECT film_id FROM (
        select f.film_id 
        from film f
        Join film_category fc ON f.film_id = fc.film_id
        Join category ca on fc.category_id = ca.category_id
        Where ca.name = "Sci-Fi" and f.release_year between '2022-01-01' AND '2022-12-30'
    ) AS t
);


-- 8. Write a SQL query to update the address of all customers who live in the same city as another customer with the same last name,
-- setting the new address to be the concatenation of their current address and the string 'samecity'.

Update customer c 
join address a on c.address_id = a.address_id
SET a.address = concat(a.address, "samecity")
Where (a.city_id, c.last_name) IN (
	Select city_id, last_name from (
		Select a1.city_id, c1.last_name 
        from customer c1 
        join address a1 on c1.address_id = a1.address_id
        group by a1.city_id, c1.last_name 
        having count(*) > 1
	) as t
);

-- 9. Write a SQL query to update the rental rate of all films in the 'Comedy' category that were released in the year 2007 or later,
-- setting the new rate to be 15% lower than the current rate.

UPDATE film
SET rental_rate = rental_rate * 0.85
WHERE film_id IN (
    SELECT film_id FROM (
        select f.film_id 
        from film f
        Join film_category fc ON f.film_id = fc.film_id
        Join category ca on fc.category_id = ca.category_id
        Where ca.name = "Comedy" and f.release_year > '2027-01-01'
    ) AS t
);

-- 10. Write a SQL query to update the rental rate of all films in the database
-- that have a rating of 'G' and a length of less than 1 hour, setting the new rate to be $1.50.

UPDATE film
SET rental_rate = 1.5
WHERE film_id IN (
    SELECT film_id FROM (
        select f.film_id
        from film f 
        where f.rating = "G" and f.length < 60  
    ) AS t
);


-- 11. ---> 20 tables not exist
