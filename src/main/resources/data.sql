---------------------------------- user ---------------------------------------------------
INSERT INTO "user" (id, name)
       select 1 , 'Cudeson'
       WHERE NOT EXISTS (SELECT true FROM "user" WHERE id=1);
       
INSERT INTO "user" (id, name)
       select 2 , 'Jason'
       WHERE NOT EXISTS (SELECT true FROM "user" WHERE id=2);