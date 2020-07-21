package com.company.java_poo_1;

import javax.swing.*;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Estoque {

    public void gravaEstoqueInicio(CarrinhoGenerico carrinhoGenericoArquivoTexto){
        FileOutputStream fo;
        ObjectOutput oo;
        File tmpDir = new File("estoque.ojb");
        if(tmpDir.exists())
            return;




        try {

            FileWriter fw;
            fw = new FileWriter("estoque.txt");
            Produto p ;
            for(int i=0;i<carrinhoGenericoArquivoTexto.p.length;i++){
                if(carrinhoGenericoArquivoTexto.p[i]!=null){
                    p = (Produto) carrinhoGenericoArquivoTexto.p[i].get();
                    fw.write(p.toStringFile());
                }
            }
            fw.close();


//            fo = new FileOutputStream("estoque.obj");
//            oo = new ObjectOutputStream(fo);
//            oo.writeObject(carrinhoGenericoArquivoTexto);
//            oo.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar o cadastro em arquivo!");
            e.printStackTrace();
        }

    }

    public CarrinhoGenerico leEstoque(){
        CarrinhoGenerico  carrinhoGenerico=null;
        FileInputStream fis;
        ObjectInputStream ois;

        FileReader fr;
        BufferedReader bf;

        try{

            fr=new FileReader("estoque.txt");
            bf=new BufferedReader(fr);
            String linha;
            linha=bf.readLine();
            String[] produto;
            int id,quantidade;
            float preco;
            ProdutoGenerico produtoGenerico;
            produtoGenerico = new ProdutoGenerico();

            carrinhoGenerico = new CarrinhoGenerico<>(10);
            Produto p;

            while(linha!=null){
                produtoGenerico = new ProdutoGenerico();
                produto=linha.split(";");
                id=Integer.parseInt(produto[0]);
                quantidade=Integer.parseInt(produto[3]);
                preco=Float.parseFloat(produto[2]);
                //1;P2;100.0;5
                p=new Produto(produto[1], preco, quantidade, id);
                //System.out.println("id = "+id);
                produtoGenerico.add(p);
                carrinhoGenerico.guarda(produtoGenerico);
                linha=bf.readLine();
            }



//            fis = new FileInputStream("estoque.obj");
//            ois = new ObjectInputStream(fis);
//            carrinhoGenerico = (CarrinhoGenerico) ois.readObject();
//            ois.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar o cadastro em arquivo!");
            e.printStackTrace();
        }
        return carrinhoGenerico;
    }
}