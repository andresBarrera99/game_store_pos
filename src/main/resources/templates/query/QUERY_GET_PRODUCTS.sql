SELECT 
	prod.product_id, 
	prod.product_name, 
	prod.product_description, 
	prod.anio, 
	prod.product_value, 
	prod.brand_id, 
	br.brand_name,
	prod_tec.tech_id,
	prod_tec.quantity,
	tec.tech_name
FROM
	game_store.products prod,
	game_store.brands br,
	game_store.technologies tec,
	game_store.products_technologies prod_tec
WHERE
	prod.brand_id = br.brand_id AND
	prod_tec.product_id = prod.product_id AND
	prod_tec.tech_id = tec.tech_id AND
	UPPER(prod.product_name) LIKE UPPER(?)