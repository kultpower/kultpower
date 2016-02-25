CREATE TABLE `ausgabe` (
  `id` varchar(255) NOT NULL,
  `zeitschrift` varchar(255) NOT NULL,
  `shortname` varchar(255) NOT NULL,
  `erscheinungsdatum` DATE,
  `jahr` int NOT NULL,
  `nummer` INTEGER NOT NULL,
  `name` varchar(255),
  `coverFile` varchar(255),
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;
ALTER TABLE `ausgabe` ADD UNIQUE `zeitschrift_jahr_und_nummer`(`zeitschrift`, `jahr`, `nummer`);
ALTER TABLE `ausgabe` ADD FOREIGN KEY (zeitschrift) REFERENCES zeitschrift(id);
