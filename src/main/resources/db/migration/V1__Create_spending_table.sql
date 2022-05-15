create table spending (
    id_spending int unsigned primary key auto_increment,
    amount_spending double not null,
    description_spending varchar(200),
    label_spending varchar(20)
);