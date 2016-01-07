INSERT INTO make(name) VALUES ('honda'),('toyota'),('ford'),('suzuki'),('hyundai'),('hummer');

INSERT INTO model(name,make_id) VALUES ('accord',1),('CRV',1),('4Runner',2),('Rav4',2),('escort',3);

INSERT INTO vehicle(year,color,plate_number,plate_state,model_id)VALUES (1997,'white','995-HTO','OR',1),(1995,'green','646-GTO','OR',5);

INSERT INTO customer(first_name,last_name,phone,email) VALUES ('James','Kirk','5555555555','kirk@enterprise.com'),('Spock','Of Vulcan','5555555556','spock@enterprise.com');

INSERT INTO pass(is_active, exp_date, price,type,customer_id,vehicle_id) VALUES (true,'1/1/2017',19.99,'weekend',1,1);