SELECT 
	customer_id, 
	customer_names, 
	customer_last_name1 last_name1, 
	customer_last_name2 last_name2, 
	address, 
	birth_date, 
	phone, 
	cellphone 
FROM
	game_store.customers 
WHERE
	doc_type_id = ? AND
	doc_number = ?