package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private final Map<String, Double> saldoContas;
    private List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
        saldoContas = new HashMap<>();
        saldoContas.put("1", 100.0);
        saldoContas.put("2", 156.0);
        saldoContas.put("3", 950.0);

        contas = new ArrayList<Conta>();
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return saldoContas.get(conta);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return saldoContas.size();
    }

    @Override
    public String addConta(String numero, double saldo) throws RemoteException {
        Conta conta = new Conta(numero, saldo);
        contas.add(conta);
        return "Conta adicionada com sucesso";
    }

    @Override
    public List<Conta> pesquisaConta(String numero) throws RemoteException {
        List<Conta> result = new ArrayList<Conta>();
        for (Conta conta : contas){
            if(conta.getNumero().contains(numero)){
                result.add(conta);
            }
        }
        return result;
    }

    @Override
    public String removeConta(String numero) throws RemoteException {
        for (Conta conta : contas){
            if(conta.getNumero() == numero) {
                this.contas.remove(conta);
            }
        }

        return "Conta removida com sucesso";
    }

}
