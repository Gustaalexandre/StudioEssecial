-- Pessoas
INSERT INTO tbPessoa(nome, sexo, endereco) VALUES
  ('Pessoa A', 'M', 'Rua A, 190, Canaa, Ipatinga-MG'),
  ('Pessoa B', 'F', 'Rua B, 130, Bethania, Ipatinga-MG'),
  ('Pessoa C', 'M', 'Rua C, 230, Esperança, Ipatinga-MG');

-- Telefones (assumindo que a tabela é tbTelefone e existe a coluna pessoaId)
INSERT INTO tbTelefone(telefone, pessoaId) VALUES
  ('31999990001', 1),
  ('31999990002', 2),
  ('31999990003', 3);

-- Procedimentos
INSERT INTO tbProcedimento(nome, descricao, preco, duracao) VALUES
  ('Corte de Cabelo', 'Corte masculino', 40.00, '30'),
  ('Manicure', 'Manicure completa', 35.00, '45'),
  ('Sobrancelha', 'Design de sobrancelha', 25.00, '20');

-- Agendamentos
INSERT INTO tbAgendamento(pessoaId, procedimentoId, nmProduto, quantidade, data, situacao, numeroParcelas, valorTotal) VALUES
  (1, 1, 'Corte de Cabelo', 1, '2025-07-04', 'PENDENTE', 1, 40.00),
  (2, 2, 'Manicure', 1, '2025-07-04', 'CONFIRMADO', 2, 70.00),
  (3, 3, 'Sobrancelha', 1, '2025-07-05', 'CANCELADO', 1, 25.00);

-- Pagamentos
INSERT INTO tbPagamento(dataPagamento, dataVencimento, valor, formaPagamengo, numeroParcela, agendamentoId) VALUES
  ('2025-07-04', '2025-07-04', 40.00, 'DINHEIRO', 1, 1),
  ('2025-07-04', '2025-07-04', 35.00, 'CARTAO', 1, 2),
  ('2025-07-05', '2025-07-05', 25.00, 'PIX', 1, 3);