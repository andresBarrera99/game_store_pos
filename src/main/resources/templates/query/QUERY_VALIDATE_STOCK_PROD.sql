SELECT 
	prod_tec.quantity
FROM
	game_store.products_technologies prod_tec
WHERE
	prod_tec.product_id = ? AND
	prod_tec.tech_id = ? 