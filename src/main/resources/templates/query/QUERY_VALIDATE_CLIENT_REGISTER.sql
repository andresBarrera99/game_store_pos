SELECT 
	count(*)
FROM 
	game_store.customers
WHERE 
	doc_type_id = ? AND
	doc_number = ?