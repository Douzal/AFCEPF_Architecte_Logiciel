INSERT INTO banque_personne (personne_id, personne_naissance, personne_mail, personne_nom, personne_mot_de_passe) VALUES (1, '2012-12-21', 'conseil@banque.fr', 'conseil', 'conseil');
INSERT INTO banque_personne (personne_id, personne_naissance, personne_mail, personne_nom, personne_mot_de_passe) VALUES (2, '2012-12-21', 'client1@banque.fr', 'client1', 'client1');
INSERT INTO banque_personne (personne_id, personne_naissance, personne_mail, personne_nom, personne_mot_de_passe) VALUES (3, '2012-12-21', 'societe1@banque.fr', 'societe1', 'societe1');
INSERT INTO banque_personne (personne_id, personne_naissance, personne_mail, personne_nom, personne_mot_de_passe) VALUES (4, '2012-12-21', 'client2@banque.fr', 'client2', 'client2');
INSERT INTO banque_personne (personne_id, personne_naissance, personne_mail, personne_nom, personne_mot_de_passe) VALUES (5, '2012-12-21', 'societe2@banque.fr', 'societe2', 'societe2');
INSERT INTO banque_conseiller (personne_id) VALUES (1);
INSERT INTO banque_particulier (interdit_bancaire, personne_id, id_conseiller) VALUES (0, 2, 1);
INSERT INTO banque_particulier (interdit_bancaire, personne_id, id_conseiller) VALUES (0, 4, 1);
INSERT INTO banque_societe (societe_siret, personne_id, id_conseiller) VALUES ('000e56565a565', 3, 1);
INSERT INTO banque_societe (societe_siret, personne_id, id_conseiller) VALUES ('000e56565a566', 5, 1);
INSERT INTO banque_compte (type_de_compte, compte_numero, compte_date_creation, id_particulier) VALUES ('compte_particulier', 1, '2012-12-21', 2);
INSERT INTO banque_compte (type_de_compte, compte_numero, compte_date_creation, id_particulier) VALUES ('compte_particulier', 2, '2012-12-21', 2);
INSERT INTO banque_compte (type_de_compte, compte_numero, compte_date_creation, id_particulier) VALUES ('compte_particulier', 3, '2012-12-21', 4);
INSERT INTO banque_compte (type_de_compte, compte_numero, compte_date_creation, id_particulier) VALUES ('compte_particulier', 4, '2012-12-21', 4);
INSERT INTO banque_compte (type_de_compte, compte_numero, compte_date_creation, id_particulier) VALUES ('compte_particulier', 5, '2012-12-21', 4);
INSERT INTO banque_compte (type_de_compte, compte_numero, compte_date_creation, id_societe) VALUES ('compte_pro', 6, '2012-12-21', 3);
INSERT INTO banque_compte (type_de_compte, compte_numero, compte_date_creation, id_societe) VALUES ('compte_pro', 7, '2012-12-21', 3);
INSERT INTO banque_compte (type_de_compte, compte_numero, compte_date_creation, id_societe) VALUES ('compte_pro', 8, '2012-12-21', 5);
INSERT INTO banque_compte (type_de_compte, compte_numero, compte_date_creation, id_societe) VALUES ('compte_pro', 9, '2012-12-21', 5);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (1, '2012-12-21', 350.20, 1);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (2, '2012-12-21', 75.10, 1);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (3, '2012-12-21', 2580.00, 9);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (5, '2012-12-21', 759.25, 9);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (6, '2012-12-21', 452.00, 8);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (7, '2012-12-21', 125.20, 8);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (7, '2012-12-21', 25.20, 1);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (8, '2012-12-21', 350.20, 2);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (9, '2012-12-21', 12.10, 2);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (10, '2012-12-21', 45.23, 3);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (11, '2012-12-21', 78.54, 3);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (12, '2012-12-21', 775.45, 4);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (13, '2012-12-21', 1257.20, 4);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (14, '2012-12-21', 55.45, 4);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (15, '2012-12-21', 4798.65, 5);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (16, '2012-12-21', 8690.25, 5);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (17, '2012-12-21', 7850.00, 5);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (18, '2012-12-21', 2500.20, 5);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (19, '2012-12-21', 350.20, 6);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (20, '2012-12-21', 75.10, 6);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (21, '2012-12-21', 2580.00, 6);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (22, '2012-12-21', 759.25, 7);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (23, '2012-12-21', 452.00, 7);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (24, '2012-12-21', 125.20, 7);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (25, '2012-12-21', 25.20, 8);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (26, '2012-12-21', 350.20, 8);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (27, '2012-12-21', 12.10, 8);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (28, '2012-12-21', 45.23, 1);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (29, '2012-12-21', 78.54, 3);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (30, '2012-12-21', 775.45, 4);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (131, '2012-12-21', 1257.20, 4);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (132, '2012-12-21', 55.45, 4);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (133, '2012-12-21', 15000.65, 5);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (134, '2012-12-21', 8690.25, 5);
INSERT INTO banque_credit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (135, '2012-12-21', 7850.00, 8);
INSERT INTO banque_debit(operation_id, operation_date_operation, operation_montant, id_compte) VALUES (136, '2012-12-21', 2500.20, 5);
INSERT INTO hibernate_sequences (next_val, sequence_name) VALUES (137, 'Operation');
