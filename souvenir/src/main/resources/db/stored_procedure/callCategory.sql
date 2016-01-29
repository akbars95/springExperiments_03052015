/*
CALL `souvenir`.`insertCategory`('Category 1');
CALL `souvenir`.`insertCategory`('Category 2');
CALL `souvenir`.`insertCategory`('Category 3');
CALL `souvenir`.`insertCategory`('Category 4');
CALL `souvenir`.`insertCategory`('Category 5');

CALL `souvenir`.`insertCategory`('Category 6');
CALL `souvenir`.`updateCategory`('Category 999', 6);
CALL `souvenir`.`deleteCategoryById`(6);
*/
CALL `souvenir`.`getAllCategories`();
CALL `souvenir`.`getCategoryById`(3);

CALL `souvenir`.`getCategoryByNameLike`('%tego%');
CALL `souvenir`.`getCategoryByNameLike`('_a%');
CALL `souvenir`.`getCategoryByNameLike`('% 2');
CALL `souvenir`.`getCategoryByNameLike`('%gf% or \'a\' = \'a\'');

CALL `souvenir`.`getLastAddedCategoryId`();


