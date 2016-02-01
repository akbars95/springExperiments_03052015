CREATE DEFINER=`souvenir`@`localhost` TRIGGER `souvenir`.`souvenirs_AFTER_UPDATE` AFTER UPDATE ON `souvenirs` FOR EACH ROW
BEGIN

update souvenirs_audit set last_update_datetime = now() where souvenir_id = OLD.souvenir_id;

END