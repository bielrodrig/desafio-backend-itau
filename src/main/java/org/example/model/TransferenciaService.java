package org.example.model;

public class TransferenciaService {

    public String realizarTransferencia(Usuario emissor, Usuario receptor,double valor, TipoTransferencia tipo) {
        switch (tipo) {
            case PIX:
                if (valor > 5000) {
                    return "Sua transferência não foi completa pois PIX permite no maximo R$5.000";
                }
                break;
            case TED:
                if (valor <= 5000 || valor > 10000) {
                    return "Sua transferência não foi completa pois TED permite valor entre R$5.000 e R$10.000";
                }
                break;
            case DOC:
                if (valor <= 10000) {
                    return "Sua transferência não foi completa pois DOC so permite valor acima de R$10.000";
                }
                break;
        }
        if (emissor.getSaldo() < valor) {
            return "Sua transferência não pode ser concluida por conta que não tem saldo na conta";
        }
        emissor.debitar(valor);
        receptor.creditar(valor);

        return "Transferência concluida com sucesso" + "saldo do emissor: " + emissor.getSaldo() + "saldo do receptor: " + receptor.getSaldo();

    }
}
