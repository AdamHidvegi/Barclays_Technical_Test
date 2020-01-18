-- dropping tables every single time we run the file in order to have a "clean sheet" at the start
DROP TABLE daily_activity;
DROP TABLE account_details;

-- creating tables
CREATE TABLE account_details(
  account_number SERIAL4 NOT NULL PRIMARY KEY,
  start_date DATE,
  city VARCHAR(255)
);

CREATE TABLE daily_activity(
  account_number SERIAL4 PRIMARY KEY REFERENCES account_details(account_number),
  daily_usage_mins INT4,
  date DATE
);

-- account details examples
INSERT INTO account_details (start_date, city) VALUES ('2019-12-01', 'Glasgow');
INSERT INTO account_details (start_date, city) VALUES ('2020-02-02', 'London');
INSERT INTO account_details (start_date, city) VALUES ('2020-02-02', 'London');
INSERT INTO account_details (start_date, city) VALUES ('2019-12-01', 'Glasgow');
INSERT INTO account_details (start_date, city) VALUES ('2020-04-04', 'London');
INSERT INTO account_details (start_date, city) VALUES ('2019-12-01', 'London');
INSERT INTO account_details (start_date, city) VALUES ('2020-05-05', 'Budapest');

-- daily activity examples
INSERT INTO daily_activity (daily_usage_mins, date) VALUES (10, '2019-12-05');
INSERT INTO daily_activity (daily_usage_mins, date) VALUES (2, '2020-02-05');
INSERT INTO daily_activity (daily_usage_mins, date) VALUES (15, '2020-02-06');
INSERT INTO daily_activity (daily_usage_mins, date) VALUES (4, '2020-02-10');
INSERT INTO daily_activity (daily_usage_mins, date) VALUES (20, '2020-03-05');
INSERT INTO daily_activity (daily_usage_mins, date) VALUES (25, '2020-04-05');
INSERT INTO daily_activity (daily_usage_mins, date) VALUES (1, '2020-05-05');

-- Testing the tables:
-- SELECT * FROM account_details;
-- SELECT * FROM daily_activity;

-- Count the number of new accounts opened per day by people based in London.
SELECT (COUNT(account_number), start_date) FROM account_details WHERE city='London' GROUP BY start_date;

-- Rank accounts in terms of total time spent in the app (highest usage first) but excluding anyone who has been active for less than 5 minutes.
SELECT (SUM(daily_usage_mins), account_number) FROM daily_activity WHERE (daily_usage_mins >= 5) GROUP BY account_number ORDER BY SUM(daily_usage_mins) DESC;

--  Identify how many accounts were opened on '2019-12-01' in Glasgow and then were still active after their first 10 days.
SELECT COUNT(account_details.account_number) FROM account_details INNER JOIN daily_activity ON account_details.account_number=daily_activity.account_number WHERE (account_details.start_date = '2019-12-01' AND account_details.city = 'Glasgow' AND (10 < (daily_activity.date - account_details.start_date)));
