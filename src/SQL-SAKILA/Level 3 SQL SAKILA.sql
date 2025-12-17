use sakila;  
-- level 3 

-- 1. Write a SQL query to return the average rental duration for each combination of actor and category in the database, excluding actors who have not appeared in any films in a category.

select AVG(f.rental_duration)
from film f
join film_actor fa on f.film_id = fa.film_id
join actor a on a.actor_id = fa.actor_id
join film_category fc on f.film_id = fc.film_id
join category c on fc.category_id = c.category_id
group by a.actor_id, c.category_id; 


-- 2. Write a SQL query to return the names of all actors who have appeared in a film with a rating of 'R' and a length of more than 2 hours, but have never appeared in a film with a rating of 'G'.

select a.first_name, a.last_name 
from actor a
Join film_actor fa on a.actor_id = fa.actor_id
Join film f  on fa.film_id = f.film_id
group by a.actor_id
Having sum(f.rating = 'R' AND f.length > 2) > 0 and sum(f.rating = 'G') = 0 ;


-- 3. Write a SQL query to return the names of all customers who have rented more than 10 films in a single transaction, along with the number of films they rented and the total rental fee.

SELECT 
    c.first_name,
    c.last_name,
    COUNT(*) AS numberMovies,
    Sum(p.amount)
FROM rental r
JOIN customer c ON r.customer_id = c.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
Join payment p on p.rental_id = r.rental_id
GROUP BY c.customer_id, r.rental_date, i.film_id
HAVING COUNT(i.film_id) > 10;

-- 4. Write a SQL query to return the names of all customers who have rented every film in a category, along with the total number of films rented and the total rental fee.
Select c.first_name, c.last_name, count(f.film_id) total_movies, count(p.amount) total_expense
FROM customer c
Join rental r ON c.customer_id = r.customer_id
Join inventory i ON r.inventory_id = i.inventory_id
Join payment p on p.rental_id = r.rental_id
Join film f ON i.film_id = f.film_id
Join film_category fc ON f.film_id = fc.film_id
group by c.customer_id, fc.category_id
having total_movies
=
(SELECT COUNT(*) FROM film_category fc2
WHERE fc2.category_id = fc.category_id);

-- 5. Write a SQL query to return the titles of all films in the database that have been rented by the same customer more than once in a single day,
-- along with the names of the customers who rented them and the number of times they were rented.

Select f.title
FROM customer c
Join rental r ON c.customer_id = r.customer_id
Join inventory i ON r.inventory_id = i.inventory_id
Join payment p on p.rental_id = r.rental_id
Join film f ON i.film_id = f.film_id
group by c.customer_id, f.film_id, Date(r.rental_date)
having Count(*) > 1 ; 

-- 6. Write a SQL query to return the names of all actors who have appeared in at least one film with every other actor in the database, 
-- along with the number of films they appeared in together.

SELECT 
    a.actor_id,
    a.first_name,
    a.last_name,
    COUNT(DISTINCT fa2.actor_id) AS co_star_count
FROM actor a
JOIN film_actor fa1 ON a.actor_id = fa1.actor_id
JOIN film_actor fa2 
    ON fa1.film_id = fa2.film_id
    AND fa1.actor_id <> fa2.actor_id
GROUP BY a.actor_id, a.first_name, a.last_name
HAVING COUNT(DISTINCT fa2.actor_id) = (
    SELECT COUNT(*) - 1 FROM actor
);




-- 7. Write a SQL query to return the names of all customers who have rented at least one film from each category in the database, along with the number of films rented from each category.
Select c.first_name, c.last_name, count(DISTINCT fc.category_id)
FROM customer c
Join rental r ON c.customer_id = r.customer_id
Join inventory i ON r.inventory_id = i.inventory_id
Join payment p on p.rental_id = r.rental_id
Join film f ON i.film_id = f.film_id
Join film_category fc ON f.film_id = fc.film_id
group by c.customer_id
having count(DISTINCT fc.category_id) = (
    SELECT count(*) FROM category
);

-- 8. Write a SQL query to return the titles of all films in the database that have been rented more than 100 times,
-- but have never been rented by any customer who has rented a film with a rating of 'G'.

select f.title 
from film f
Join inventory i on i.film_id = f.film_id
Join rental r on i.inventory_id = r.inventory_id
Where r.customer_id NOt IN (
	SELECT DISTINCT r2.customer_id
    from rental r2
    Join inventory i2 ON r2.inventory_id = i2.inventory_id
    Join film f2 ON i2.film_id = f2.film_id
    Where f2.rating = 'G'
)
GROUP BY f.film_id, f.title
HAVING COUNT(*) > 100;

-- 9. Write a SQL query to return the names of all customers who have rented a film from a category they have never rented from before,
-- and have also never rented a film longer than 3 hours.
SELECT 
	c.first_name, c.last_name
FROM customer c
Join rental r ON c.customer_id = r.customer_id
Join inventory i ON r.inventory_id = i.inventory_id
Join film f ON i.film_id = f.film_id
Join film_category fc on f.film_id = fc.film_id
Join category ca on fc.category_id = ca.category_id
where r.rental_date IN 
(
		SELECT MIN(r2.rental_date)
		From rental r2
		Join inventory i2 ON r2.inventory_id = i2.inventory_id
		Join film f2 ON i2.film_id = f2.film_id
		Join film_category fc2 ON f2.film_id = fc2.film_id
		Where r2.customer_id = c.customer_id
		and fc2.category_id = ca.category_id
        and f.length > 180 
);

-- 10. Write a SQL query to return the names of all actors who have appeared in a film with a rating of 'PG-13' and a length of more than 2 hours, and have also appeared in a film with a rating of 'R' and a length of less than 90 minutes.

SELECT 
    a.actor_id,
    a.first_name,
    a.last_name
FROM actor a
Where exists 
(select * from 
film_actor fa1
Join film f  on fa1.film_id = f.film_id
Where fa1.actor_id = a.actor_id
and (f.rating = 'PG-13' and f.length > 120)
)
And exists
(
select * from 
 film_actor fa2 
Join film f  on fa2.film_id = f.film_id
Where fa2.actor_id = a.actor_id
and (f.rating = 'R' and f.length < 90 )
)

 
