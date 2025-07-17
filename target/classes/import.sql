-- Pessoas (OK)
INSERT INTO tb_pessoa(nome, sexo, endereco) VALUES ('Pessoa A', 'M', 'Rua A, 190, Canaa, Ipatinga-MG'), ('Pessoa B', 'F', 'Rua B, 130, Bethania, Ipatinga-MG'), ('Pessoa C', 'M', 'Rua C, 230, Esperança, Ipatinga-MG');

-- Telefones (OK)
INSERT INTO tb_telefone(telefone, pessoa_id) VALUES ('31999990001', 1), ('31999990002', 2), ('31999990003', 3);

-- Procedimentos (OK)
INSERT INTO tb_procedimento(nome, descricao, preco, duracao) VALUES ('Corte de Cabelo', 'Corte masculino', 40, '30'), ('Manicure', 'Manicure completa', 35, '45'), ('Sobrancelha', 'Design de sobrancelha', 25, '20');

-- Agendamentos (OK)
INSERT INTO tb_agendamento(pessoa_id, procedimento_id, nm_produto, quantidade, data, situacao, numero_parcelas, valor_total) VALUES (1, 1, 'Corte de Cabelo', 1, '2025-07-04', 'PENDENTE', 1, 40), (2, 2, 'Manicure', 1, '2025-07-04', 'CONFIRMADO', 2, 70), (3, 3, 'Sobrancelha', 1, '2025-07-05', 'CANCELADO', 1, 25);

-- Pagamentos (OK)
INSERT INTO tb_pagamento(data_pagamento, data_vencimento, valor, forma_pagamento, numero_parcela, agendamento_id) VALUES ('2025-07-04', '2025-07-04', 40.00, 'DINHEIRO', 1, 1), ('2025-07-04', '2025-07-04', 35.00, 'CARTAO', 1, 2), ('2025-07-05', '2025-07-05', 25.00, 'PIX', 1, 3);

-- Usuários (OK)
INSERT INTO tb_usuario(login, senha, nivel_acesso, pessoa_id) VALUES ('AAA', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'FUNCIONARIO', 1), ('BBB', '222', 'CLIENTE', 2), ('CCC', '333', 'FUNCIONARIO', 3);