USE exam24h;

-- PARTICIPANTS
    INSERT INTO participants (name, age, gender, club) VALUES ("Allan", 30, "male", "A-team");
    INSERT INTO participants (name, age, gender, club) VALUES ("Birthe", 32, "female", "B-team");
    INSERT INTO participants (name, age, gender, club) VALUES ("Christoffer", 24, "male", "C-team");

-- DISCIPLINES
    INSERT INTO disciplines (name, result_type) VALUES ("100m-løb", "time");
    INSERT INTO disciplines (name, result_type) VALUES ("Diskoskast", "length");
    INSERT INTO disciplines (name, result_type) VALUES ("tre-spring", "length");

-- RESULTS
    INSERT INTO results (result_type, result_value, participant_id, discipline_id) VALUES ("time", "00.09.58", 1, 1);
    INSERT INTO results (result_type, result_value, participant_id, discipline_id) VALUES ("length", "28.12", 2, 2);
    INSERT INTO results (result_type, result_value, participant_id, discipline_id) VALUES ("length", "14.59", 3, 3);
    INSERT INTO results (result_type, result_value, participant_id, discipline_id) VALUES ("time", "00.11.11", 2, 1);
    INSERT INTO results (result_type, result_value, participant_id, discipline_id) VALUES ("length", "25.01", 3, 2);
    INSERT INTO results (result_type, result_value, participant_id, discipline_id) VALUES ("length", "10.01", 1, 3);

-- PARTICIPANT_DISCIPLINE ASSOCIATIONS
    INSERT INTO participant_discipline (participant_id, discipline_id) VALUES (1, 1);
    INSERT INTO participant_discipline (participant_id, discipline_id) VALUES (2, 2);
    INSERT INTO participant_discipline (participant_id, discipline_id) VALUES (3, 3);
    INSERT INTO participant_discipline (participant_id, discipline_id) VALUES (1, 3);
    INSERT INTO participant_discipline (participant_id, discipline_id) VALUES (2, 1);
    INSERT INTO participant_discipline (participant_id, discipline_id) VALUES (3, 2);