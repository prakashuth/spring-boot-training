DROP TABLE IF EXISTS catalog;
 
CREATE TABLE catalog (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  rating int DEFAULT NULL
);
 
INSERT INTO catalog (name, description, rating) VALUES
  ('Transformers', 'Transformers desc', 0),
  ('SuperMan', 'SuperMan desc', 0),
  ('Avengers', 'Avengers desc', 0);
