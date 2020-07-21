package com.company.java_poo_1;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Produto p = new Produto();
        System.out.println(p.toString());
        p = new Produto("Notebook",1500.00f);
        System.out.println(p.toString());
        Carrinho carrinho = new Carrinho();
        System.out.println(carrinho.getP().length);
        carrinho.getP()[0]=p;

        Produto p2;
        p2 = new Produto("Pen",30.0f);
        carrinho.getP()[1]=p2;

        Armazenamento armazenamento;
        armazenamento = new Armazenamento();
        armazenamento.setNome("SSD");
        armazenamento.setUnidade("T");
//        System.out.println(armazenamento.getNome());
//        System.out.println(armazenamento.getPreco());
//        System.out.println(armazenamento.getCapacidade());
//        System.out.println(armazenamento.getUnidade());

        Armazenamento armazenamento2;
        armazenamento2 = new Armazenamento();
        armazenamento2.setCapacidade(32);

        carrinho.getP()[2]=armazenamento;
        carrinho.getP()[3]=armazenamento2;

        for (int i =0;i<carrinho.getP().length;i++){
            if(carrinho.getP()[i]!=null){
                System.out.println(carrinho.getP()[i].toString());
            }
        }

        carrinho.remove(1);
        System.out.println("-----------------");
        for (int i =0;i<carrinho.getP().length;i++){
            if(carrinho.getP()[i]!=null){
                System.out.println(carrinho.getP()[i].toString());
            }
        }
        System.out.println("Testes genericos");
        CarrinhoGenerico carrinhoGenerico;
        carrinhoGenerico = new CarrinhoGenerico<>(10);
        ProdutoGenerico produtoGenerico;
        produtoGenerico=new ProdutoGenerico();

        produtoGenerico.add(p);
        carrinhoGenerico.guarda(produtoGenerico);

        produtoGenerico = new ProdutoGenerico();
        produtoGenerico.add(armazenamento);
        carrinhoGenerico.guarda(produtoGenerico);

        produtoGenerico = new ProdutoGenerico();
        produtoGenerico.add(armazenamento2);
        carrinhoGenerico.guarda(produtoGenerico);

        System.out.println("Impressão do Carrinho Genérico");
        for (int i=0;i<carrinhoGenerico.p.length;i++){
            if (carrinhoGenerico.p[i]!=null){
                System.out.println(carrinhoGenerico.p[i].toString());
            }
        }

        System.out.println("Retira SSD");
        carrinhoGenerico.retira(1);

        System.out.println("impressão depois de retirar o SSD");
        for (int i = 0; i < carrinhoGenerico.p.length; i++) {
            if(carrinhoGenerico.p[i]!=null){
                System.out.println(carrinhoGenerico.p[i].toString());
            }
        }

        Mouse mouse;
        mouse = new Mouse("USB","Preto");
        produtoGenerico=new ProdutoGenerico();
        produtoGenerico.add(mouse);
        carrinhoGenerico.guarda(produtoGenerico);
        System.out.println("Com o Mouse");
        for (int i = 0; i < carrinhoGenerico.p.length; i++) {
            if(carrinhoGenerico.p[i]!=null){
                System.out.println(carrinhoGenerico.p[i].toString());
            }
        }

        System.out.println("####################################");
        Mouse m_ = (Mouse) produtoGenerico.get();
        System.out.println("o m é um mouse USB preto");
        System.out.println(m_.toString());

        Object m2 = produtoGenerico.get();//é o mesmo mouse USB preto
        Armazenamento a = new Armazenamento();
        if(m2.getClass().isInstance(a)){
            a=(Armazenamento)m2;
            System.out.println("é um armazenamento "+a.toString());
            a.setCapacidade(10);
        }

        Mouse m3 = new Mouse();
        if(m2.getClass().isInstance(m3)){
            m3=(Mouse) m2;
            m3.setCor("Branco");
            System.out.println("é um mouse "+m3.toString());
        }

        System.out.println("----teste No arquivo Texto");
        ProdutoGenerico produtoGenerico2;
        CarrinhoGenerico estoqueNoArquivoTexto;
        estoqueNoArquivoTexto = new CarrinhoGenerico<>(13);

        for (int i=0;i<10; i++){
            p = new Produto("Pen ",(50.0f)+(i*5),(i+2),i);
            produtoGenerico2=new ProdutoGenerico();
            produtoGenerico2.add(p);
            estoqueNoArquivoTexto.guarda(produtoGenerico2);
        }

        produtoGenerico2=new ProdutoGenerico();
        produtoGenerico2.add(mouse);
        estoqueNoArquivoTexto.guarda(produtoGenerico2);

        produtoGenerico2=new ProdutoGenerico();
        produtoGenerico2.add(armazenamento);
        estoqueNoArquivoTexto.guarda(produtoGenerico2);

        produtoGenerico2=new ProdutoGenerico();
        produtoGenerico2.add(armazenamento2);
        boolean armazenou = estoqueNoArquivoTexto.guarda(produtoGenerico2);
        if(armazenou){
            System.out.println("O produto foi armzenado com sucesso");
        }

        Estoque estoque;
        estoque = new Estoque();
        estoque.gravaEstoqueInicio(estoqueNoArquivoTexto);

        CarrinhoGenerico estoqueCarregado = estoque.leEstoque();
        System.out.println("Estoque estoqueCarregado ***************************");
        for (int i = 0; i < estoqueCarregado.p.length; i++) {
            if(estoqueCarregado.p[i]!=null){
                System.out.println(estoqueCarregado.p[i].toString());
            }
        }

    }
}
