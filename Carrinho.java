import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Fornecedor {  //criação da classe Fornecedor
    private String razaoSocial;
    private String cnpj;

    public Fornecedor(String razaoSocial, String cnpj) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }


}

abstract class Produto implements itemCarrinho { // criacao da classe abstrata Produto 
    private String nome;
    private double precoUnitario;
    private int quantidade;
    private Fornecedor fornecedor;
    
    public Produto(String nome, double precoUnitario, Fornecedor fornecedor) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidade = 0;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

   public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

interface itemCarrinho { // define o comportamento dos itens do carrinho
    void exibirDetalhes();
    double calcularTotalItem();
} 

class Eletronico extends Produto  { // classe Eletronico que herda os atributos (getters, setter e construtor)de Produto e implementa itemCarrinho
    private int mesesGarantia; 

    public Eletronico(String nome, double precoUnitario, Fornecedor fornecedor, int mesesGarantia) {
        super(nome, precoUnitario, fornecedor);
        
        if (mesesGarantia == 12 || mesesGarantia == 24) 
            this.mesesGarantia = mesesGarantia;
    }

    @Override // implementação do método exibirDetalhes() da interface itemCarrinho
    public void exibirDetalhes() {
        System.out.println("Resultado da busca:");
        System.out.println("Item encontrado com sucesso");
        System.out.println("Nome oficial do item: " + getNome());
        System.out.println("Quantidade no carrinho: " + getQuantidade());
        System.out.println("Preço Unitário: R$ " + getPrecoUnitario());
        System.out.println("Detalhes completos: ");
        System.out.printf("[ELETRÔNICO] Produto: %s | Qtd: %d | UN: R$%.2f | Total: R$%.2f | Garantia: %d meses | Fornecedor: %s\n\n",
                getNome(), getQuantidade(), getPrecoUnitario(), calcularTotalItem(), mesesGarantia, getFornecedor().getRazaoSocial()
        );
    }

    @Override // implementação do método calcularTotalItem() da interface itemCarrinho
    public double calcularTotalItem() {
        return getPrecoUnitario() * getQuantidade();
    }

}
class Vestuario extends Produto { // classe Vestuario que herda os atributos (getters, setter e construtor)de Produto e implementa itemCarrinho
    private String tamanho;

    public Vestuario (String nome, double precoUnitario, Fornecedor fornecedor, String tamanho) {
        super(nome, precoUnitario, fornecedor);
        this.tamanho = tamanho;
    }

    @Override // implementação do método exibirDetalhes() da interface itemCarrinho
    public void exibirDetalhes() {
        System.out.println("Resultado da busca:");
        System.out.println("Item encontrado com sucesso");
        System.out.println("Nome oficial do item: " + getNome());
        System.out.println("Quantidade no carrinho: " + getQuantidade());
        System.out.println("Preço Unitário: R$ " + getPrecoUnitario());
        System.out.println("Detalhes completos: ");
        System.out.printf("[VESTUÁRIO] Produto: %s | Qtd: %d | UN: R$%.2f | Total: R$%.2f | Tamanho: %s | Fornecedor: %s\n\n",
                getNome(), getQuantidade(), getPrecoUnitario(), calcularTotalItem(), tamanho, getFornecedor().getRazaoSocial()
        );
    }
    
    @Override // implementação do método calcularTotalItem() da interface itemCarrinho
    public double calcularTotalItem() {
        return getPrecoUnitario() * getQuantidade();
    }

    
}
class Alimento extends Produto { // classe Alimento que herda os atributos (getters, setter e construtor)de Produto e implementa itemCarrinho
   private String dataValidade;
   
   public Alimento (String nome, double precoUnitario, Fornecedor fornecedor, String dataValidade) {
        super(nome, precoUnitario, fornecedor);
        this.dataValidade = dataValidade;
    }

    @Override // implementação do método exibirDetalhes() da interface itemCarrinho
    public void exibirDetalhes() {
        System.out.println("Resultado da busca:");
        System.out.println("Item encontrado com sucesso");
        System.out.println("Nome oficial do item: " + getNome());
        System.out.println("Quantidade no carrinho: " + getQuantidade());
        System.out.println("Preço Unitário: R$ " + getPrecoUnitario());
        System.out.println("Detalhes completos: ");
        System.out.printf("[ALIMENTO] Produto: %s | Qtd: %d | UN: R$%.2f | Total: R$%.2f | Validade: %s | Fornecedor: %s\n\n",
                getNome(), getQuantidade(), getPrecoUnitario(), calcularTotalItem(), dataValidade, getFornecedor().getRazaoSocial()
        );
    }
    
    @Override // implementação do método calcularTotalItem() da interface itemCarrinho
    public double calcularTotalItem() {
        return getPrecoUnitario() * getQuantidade();
    }
}

public class Carrinho { // "main" ; classe principal onde é criado o carrinho, os fornecedores, os produtos e a busca pelo nome do produto
    public static void main(String[] args) {
        List<Produto> carrinho = new ArrayList<>();
        Fornecedor fornecedor1 = new Fornecedor("Tech Corp", "12.345.678/0001-90");
        Fornecedor fornecedor2 = new Fornecedor("Modas Brasil", "98.765.432/0001-10");
        Fornecedor fornecedor3 = new Fornecedor("Agro Vitta", "56.789.012/0001-34");

        Produto eletronico1 = new Eletronico("Smartphone XYZ", 1500.00, fornecedor1, 24);
        Produto vestuario1 = new Vestuario("Camiseta Estampada", 80.00, fornecedor2, "M");
        Produto alimento1 = new Alimento("Chocolate Amargo", 15.00, fornecedor3, "31/12/2026");

        Produto eletronico2 = new Eletronico("Smartphone ABC", 2500.00, fornecedor1, 12);
        Produto vestuario2 = new Vestuario("Camiseta Lisa", 100.00, fornecedor2, "G");
        Produto alimento2 = new Alimento("Chocolate ao Leite", 10.00, fornecedor3, "08/10/2026");

        
    carrinho.add(eletronico1);
    carrinho.add(eletronico2);

    carrinho.add(vestuario1);
    carrinho.add(vestuario2);

    carrinho.add(alimento1);
    carrinho.add(alimento2);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o nome do produto que deseja buscar: ");
    String nomeBusca = scanner.nextLine();

    boolean encontrado = false;

    Produto p1 = null; // variável para armazenar o produto encontrado, caso exista


    for (Produto produto : carrinho) { //faz busca pelo nome do produto 
        
       if (produto.getNome().equalsIgnoreCase(nomeBusca)) {
            p1 = produto;
            encontrado = true;
            break;
        }
       

    }
     if (encontrado) { // se o produto for encontrado, exibe os detalhes do produto
        p1.exibirDetalhes();
        

        }else{ // se o produto não for encontrado, exibe mensagem de erro
        System.out.println("O item " + nomeBusca + " não foi encontrado no carrinho."); 

    }


    }
}