create table spending (
    idSpending int unsigned primary key auto_increment,
    amountSpending double not null,
    descriptionSpending varchar(200),
    labelSpending varchar(20)
);