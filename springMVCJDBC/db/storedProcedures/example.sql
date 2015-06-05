use contactdb;
/*call InsertNewContact('Ivanov Ivan', 'ivanov.ivan@mail.ru', 'Kishinev', '069 258 954');
*/
call UpdateContact('Petrov Petr', 'petr.petrov@mail.ru', 'Kausheni', '079 852 321', 1);
call DeleteContact(1);
call SelectAllContacts();
call InsertNewContact('Ivanov Ivan', 'ivanov.ivan@mail.ru', 'Kishinev', '069 258 954');
call SelectAllContacts();