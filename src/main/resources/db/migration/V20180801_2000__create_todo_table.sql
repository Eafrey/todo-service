CREATE TABLE todo (
  id int PRIMARY KEY AUTO_INCREMENT,
  content TEXT,
  complete BOOLEAN,
  readOnly BOOLEAN,
  visible BOOLEAN,
  deleted BOOLEAN,
  date DATETIME
)