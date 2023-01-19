-- some test users
-- INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
-- VALUES (1, 'lachezar.balev@gmail.com', 'Lucho', 'Balev', null, 1, '57e7759fd2d59275fc3c3cd5dd2ace5013b39ee972999412f3f5f5c3382b6765c2571ef86648abe2');

INSERT INTO brands (id, name)
VALUES(1, 'Ford'),
      (2, 'Toyota');
--
INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, null, 1, 'upload.1.jpg'),
       (2, 'Escort', 'CAR', 1968, 2000, 1, 'upload.1.jpg'),
       (3, 'Yaris', 'CAR', 1999, null, 2, 'upload.3.jpj')