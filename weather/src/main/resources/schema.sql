DROP TABLE IF EXISTS weather_data;

CREATE TABLE weather_data(
	id INT AUTO_INCREMENT PRIMARY KEY,
	userId VARCHAR(25) NOT NULL,
	pincode INT NOT NULL,
	txtDate VARCHAR(50),
	country VARCHAR(3),
	temperature NUMERIC(10,2),
	temperatureMin NUMERIC(10,2),
	temperatureMax NUMERIC(10,2),
	pressure INT,
	humidity INT,
	seaLevel INT,
	visibility INT,
	windSpeed NUMERIC(10,2)
	);