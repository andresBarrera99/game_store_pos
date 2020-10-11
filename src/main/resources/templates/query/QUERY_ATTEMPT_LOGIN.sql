SELECT 
    u.user_id,
    u.user_names,
    u.last_name1,
    u.last_name2,
    u.doc_type_id,
    u.doc_number 
FROM
	users u,
    users_security usec
WHERE 
    u.doc_number = ? AND
    usec.user_password = ?