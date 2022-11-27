CREATE TABLE public.cw6_client (
	id varchar(255) NOT NULL,
	birth_date date NULL,
	inn varchar(255) NULL,
	name varchar(255) NULL,
	passport_serial varchar(255) NULL,
	patronymic varchar(255) NULL,
	phone varchar(255) NULL,
	sex bool NULL,
	surname varchar(255) NULL,
	CONSTRAINT cw6_client_pkey PRIMARY KEY (id)
);

CREATE TABLE public.cw6_office (
	id varchar(255) NOT NULL,
	address varchar(255) NULL,
	cabinets_count int4 NULL,
	law_address varchar(255) NULL,
	"name" varchar(255) NULL,
	CONSTRAINT cw6_office_pkey PRIMARY KEY (id)
);


CREATE TABLE public.cw6_position (
	id varchar(255) NOT NULL,
	"name" varchar(255) NULL,
	salary int4 NULL,
	CONSTRAINT cw6_position_pkey PRIMARY KEY (id)
);

CREATE TABLE public.cw6_stuff (
	id varchar(255) NOT NULL,
	birth_date date NULL,
	"name" varchar(255) NULL,
	patronymic varchar(255) NULL,
	salary_multiplier float8 NULL,
	sex bool NULL,
	surname varchar(255) NULL,
	position_id varchar(255) NOT NULL,
	CONSTRAINT cw6_stuff_pkey PRIMARY KEY (id)
);
ALTER TABLE public.cw6_stuff ADD CONSTRAINT fka7n3xtcu5ndh4mdbd620qo37o FOREIGN KEY (position_id) REFERENCES public.cw6_position(id);

CREATE TABLE public.cw6_offer (
	id varchar(255) NOT NULL,
	ending_date DATE NULL,
	serial_number varchar(255) NULL,
	sign_date DATE NULL,
	start_date DATE NULL,
	client_id varchar(255) NOT NULL,
	office_id varchar(255) NOT NULL,
	stuff_id varchar(255) NOT NULL,
	CONSTRAINT cw6_offer_pkey PRIMARY KEY (id)
);

ALTER TABLE public.cw6_offer ADD CONSTRAINT fk3lxcsuyqy7179vvjhpdkcqaq8 FOREIGN KEY (office_id) REFERENCES public.cw6_office(id);
ALTER TABLE public.cw6_offer ADD CONSTRAINT fkau05e5en34p6wka1x606w7bsf FOREIGN KEY (stuff_id) REFERENCES public.cw6_stuff(id);
ALTER TABLE public.cw6_offer ADD CONSTRAINT fkreo9uevxgoef2sqpy2vk476l1 FOREIGN KEY (client_id) REFERENCES public.cw6_client(id);


INSERT INTO public.cw6_client
(id, birth_date, inn, "name", passport_serial, patronymic, phone, sex, surname)
VALUES
    ('593e767d-4adc-4b8f-af53-4cda8eb0e357', now(), '123415', 'NameClient1', '1234', 'PatronymicClient1', '88005553535', true, 'SurnameClient1'),
    ('e07f6609-bdcd-4f97-86bc-961cf692803e', now(), '345031', 'NameClient2', '1234', 'PatronymicClient2', '88005553531', false, 'SurnameClient2');

INSERT INTO public.cw6_office
(id, address, cabinets_count, law_address, "name")
VALUES
('a68062fe-bac2-4408-af87-85ebd882d7a4', 'Addr1',100, 'Law1', 'Head Leasing Office'),
('f0b9b8b5-629d-4415-8399-62dbd9a271f4', 'Addr2',2000, 'Law2', 'Now');

INSERT INTO public.cw6_position
(id, "name", salary)
VALUES
('ab57869a-56a3-4bb1-a5ee-3a2bedb99d46', 'Position1', 10000),
('bca290bb-d657-48b1-8d55-7b795ffc4038', 'Position2', 20000);

INSERT INTO public.cw6_stuff
(id, birth_date, "name", patronymic, salary_multiplier, sex, surname, position_id)
VALUES
('a1cea7ce-e9b3-44fb-934c-abc333de9577', now(), 'Name1', 'Patronymic1', 1.0, false, 'Surname1', 'ab57869a-56a3-4bb1-a5ee-3a2bedb99d46'),
('fba9151d-6c2c-4f50-a3ca-c5d56669263c', now(), 'Name2', 'Patronymic2', 1.1, true, 'Surname2', 'bca290bb-d657-48b1-8d55-7b795ffc4038');


INSERT INTO public.cw6_offer
(id, ending_date, serial_number, sign_date, start_date, client_id, office_id, stuff_id)
VALUES
('2254d388-e6cc-492a-9134-461909a399c0', now(), '12355', now(), now(), '593e767d-4adc-4b8f-af53-4cda8eb0e357', 'a68062fe-bac2-4408-af87-85ebd882d7a4', 'a1cea7ce-e9b3-44fb-934c-abc333de9577'),
('baeb3246-b1b1-454a-b8cb-5594a77bffb5', now(), '55342', now(), now(), 'e07f6609-bdcd-4f97-86bc-961cf692803e', 'f0b9b8b5-629d-4415-8399-62dbd9a271f4', 'fba9151d-6c2c-4f50-a3ca-c5d56669263c');

