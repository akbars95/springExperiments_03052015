CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `fullselectsouvenirs` AS
select `s`.`souvenir_id` AS `souvenir_id`,`s`.`souvenir_name` AS `souvenir_name`,`s`.`souvenir_description` AS `souvenir_description`,`s`.`souvenir_show` AS `souvenir_show`,`s`.`souvenir_path` AS `souvenir_path`,`s`.`souvenir_category_id` AS `souvenir_category_id`,`s`.`souvenir_price` AS `souvenir_price`,`s`.`souvenir_count_of_days_for_order` AS `souvenir_count_of_days_for_order`,`sc`.`souvenir_category` AS `souvenir_category`
from (`souvenirs` `s` join `souvenir_categories` `sc` on((`s`.`souvenir_category_id` = `sc`.`souvenir_category_id`)));