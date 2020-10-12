UPDATE 
	game_store.customers 
SET
	customer_names = ?,
	customer_last_name1 = ?,
	customer_last_name2 = ?,
	address = ?,
	age = ?,
	phone = ?,
	cellphone = ?
WHERE
	doc_type_id = ? AND
	doc_number = ?