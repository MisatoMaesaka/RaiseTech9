DROP TABLE IF EXISTS cats;

CREATE TABLE cats (
  id INT unsigned AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  age INT NOT NULL,
  favorite_snack VARCHAR(30) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO cats (name,age,favorite_snack) VALUES ("Roku",4,"ちゅ〜る贅沢まぐろ味");
INSERT INTO cats (name,age,favorite_snack) VALUES ("Tom",1,"またたびスナック");
INSERT INTO cats (name,age,favorite_snack) VALUES ("Lucca",1,"ロイヤルカナンのパウチ");
INSERT INTO cats (name,age,favorite_snack) VALUES ("Bungaku",0,"にぼし");
INSERT INTO cats (name,age,favorite_snack) VALUES ("Hinata",0,"鰹節");
