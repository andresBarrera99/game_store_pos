UPDATE 
	game_store.products_technologies 
SET
	quantity = ?
WHERE
	product_id = ? AND
	tech_id = ?