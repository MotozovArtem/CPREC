CREATE TABLE IF NOT EXISTS currency_exchange (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    "value" real(10) NOT NULL,
    nominal integer NOT NULL,
    currency_name varchar(100) NOT NULL,
    currency_code varchar(3) NOT NULL,
    "date" date
);
