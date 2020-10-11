SELECT COUNT(*) 
FROM	
    (SELECT 
		max(modification_date),
		st.state_alias 
	FROM 
		hist_user_states hus, 
		states st
	WHERE 
		st.state_id = hus.state_id AND
		hus.user_id = ?
	group BY hus.user_id) res
WHERE res.state_alias = 'USER_ON';