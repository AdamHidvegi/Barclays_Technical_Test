About the second task (Mobile Banking Analysis - SQL):

I think I have the right queries for all of the questions (
1. Count the number of new accounts opened per day by people based in London.
2. Rank accounts in terms of total time spent in the app (highest usage first) but excluding anyone who has been active for less than 5 minutes.
3. Identify how many accounts were opened on '2019-12-01' in Glasgow and then were still active after their first 10 days.
).

I had only one daily_activity.date data for every account, but I used the SUM() method during the second question, because if I had more than one data, in theory the query still would be usable.
Without the SUM(), only for one daily_usage_mins value my query would look like this:
SELECT (daily_usage_mins, account_number) FROM daily_activity WHERE (daily_usage_mins >= 5) GROUP BY account_number ORDER BY daily_usage_mins DESC;
