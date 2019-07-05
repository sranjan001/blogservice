CREATE TABLE IF NOT EXISTS post (
    id int(11) NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE post_comment (
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    post_id int(11) NOT NULL,
    review VARCHAR(255) NOT NULL,
    FOREIGN KEY (post_id) REFERENCES post(id)
);

