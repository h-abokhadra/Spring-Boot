INSERT INTO sec_user(email, encryptedPassword, enabled)
VALUES ('abokhadr@sheridancollege.ca','$2a$10$1ltibqiyyBJMJQ4hqM7f0OusP6np/IHshkYc4TjedwHnwwNChQZCy', 1 );

INSERT INTO sec_user(email, encryptedPassword, enabled)
VALUES ('student@sheridancollege.ca','$2a$10$PrI5Gk9L.tSZiw9FXhTS8O8Mz9E97k2FZbFvGFFa5siTUIl.TCrFu', 1 );

INSERT INTO sec_role (roleName)
VALUES ('ROLE_ADMIN');

INSERT INTO sec_role (roleName)
VALUES ('ROLE_USER');

INSERT INTO user_role (userId, roleId)
VALUES (1, 1);

INSERT INTO user_role (userId, roleId)
VALUES (1, 2);

INSERT INTO user_role (userId, roleId)
VALUES (2, 2);
