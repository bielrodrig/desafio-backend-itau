package org.example.model;

import org.example.dao.UsuarioEmissorDAO;
import org.example.dao.UsuarioEmissorLoginDAO;
import org.example.dao.UsuarioReceptorLoginDAO;

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

        emissor.setSaldo(emissor.getSaldo() - valor);
        receptor.setSaldo(receptor.getSaldo() + valor);

        boolean sucessoEmissor = new UsuarioEmissorLoginDAO().atualizarSaldo(emissor);
        boolean sucessorReceptor = new UsuarioReceptorLoginDAO().atualizarSaldo(receptor);

        if (sucessoEmissor && sucessorReceptor) {
            return "Transferência efetuada com sucesso";
        } else {
            return "Erro ao atualizar a transferência";
        }
    }
}
