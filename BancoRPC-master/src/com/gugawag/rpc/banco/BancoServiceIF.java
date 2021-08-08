package com.gugawag.rpc.banco;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    String addConta(String numero, double saldo) throws RemoteException;
    List<Conta> pesquisaConta(String numero) throws RemoteException;
    String removeConta(String numero) throws RemoteException;

}
