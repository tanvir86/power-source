DROP TABLE IF EXISTS sources ;
CREATE TABLE sources ( id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, name VARCHAR(100) NOT NULL, postcode integer NOT NULL,capacity_in_watt decimal NOT NULL);
