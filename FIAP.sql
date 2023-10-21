


INSERT INTO t_gasto (cd_gasto, tp_despesa, cd_movimentacao, cd_extrato, nm_movimentacao, ds_movimentacao, vl_movimentacao, dt_movimentacao, qtd_parcelas)
VALUES (SEQ_GASTO.nextval, 'Contas', SEQ_MOVIMENTACAO.nextval, SEQ_EXTRATO.nextval, 'CONTA DE LUZ', 'MÊS DE OUTUBRO', 56.32, TO_DATE('16/10/2023', 'dd/mm/yyyy'), 1);

INSERT INTO T_GASTO VALUES ('20', '20', '20', '20.0', '20', '20', '20', '2023-02-02', '20')


UPDATE t_gasto
    SET cd_gasto = 1
        WHERE
                cd_gasto = 1
            AND tp_despesa = :v1
            AND cd_movimentacao = :v2
            AND cd_extrato = :v3
            AND nm_movimentacao = :v4
            AND ds_movimentacao = :v5
            AND vl_movimentacao = :v6
            AND dt_movimentacao = :v7
            AND qtd_parcelas = :v8;
    
DELETE FROM t_gasto WHERE cd_gasto = 1;
    
SELECT cd_gasto, tp_despesa, cd_movimentacao, cd_extrato, nm_movimentacao, ds_movimentacao, vl_movimentacao, dt_movimentacao, qtd_parcelas FROM t_gasto;


SELECT
    placa,
    modelo,
    potencia
FROM
    carro;
    
    
    SELECT
    cd_ganho,
    tp_receita,
    cd_movimentacao,
    cd_extrato,
    nm_movimentacao,
    ds_movimentacao,
    vl_movimentacao,
    dt_movimentacao,
    qtd_parcelas
FROM
    t_ganho;
    
    DROP TABLE CARRO;

    ALTER TABLE T_GANHO RENAME COLUMN TP_DESPESA TO TP_RECEITA;
