package br.com.curso;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.curso.domain.Categoria;
import br.com.curso.domain.Cidade;
import br.com.curso.domain.Cliente;
import br.com.curso.domain.Endereco;
import br.com.curso.domain.Estado;
import br.com.curso.domain.Pagamento;
import br.com.curso.domain.PagamentoComBoleto;
import br.com.curso.domain.PagamentoComCartao;
import br.com.curso.domain.Pedido;
import br.com.curso.domain.Produto;
import br.com.curso.domain.enums.SituacaoPagamento;
import br.com.curso.domain.enums.TipoCliente;
import br.com.curso.repository.CategoriaRepository;
import br.com.curso.repository.CidadeRepository;
import br.com.curso.repository.ClienteRepository;
import br.com.curso.repository.EnderecoRepository;
import br.com.curso.repository.EstadoRepository;
import br.com.curso.repository.PagamentoRepository;
import br.com.curso.repository.PedidoRepository;
import br.com.curso.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Executa na execução da aplicação

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorip");
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado("Minas Gerais");
		Estado est2 = new Estado("Sao Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maia Carmo", "maria@gmail", "01002003020", TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "Marco Lanela", "maria@gmail", "01002003020", TipoCliente.PESSOAJURIDICA);

		cli1.getTelefones().addAll(Arrays.asList("3131132165", "64874515151"));
		cli2.getTelefones().addAll(Arrays.asList("64874515151", "4848485151", "548499798"));

		Endereco end = new Endereco(null, "RUA TESTE", "275", "Americana", "20310200", "CASA", cli1, c1);
		Endereco end2 = new Endereco(null, "RUA Quadrada", "320", "Americana", "20310200", "Apartamento", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(end2, end));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end, end2));

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Pedido ped1 = new Pedido(new Date(System.currentTimeMillis()), cli1, end);
		Pedido ped2 = new Pedido(new Date(System.currentTimeMillis()), cli1, end2);

		Pagamento pgto1 = new PagamentoComCartao(null, SituacaoPagamento.QUITADO, ped1, 6);
		Pagamento pgto2 = new PagamentoComBoleto(null, SituacaoPagamento.PENDENTE, ped2,
				format.parse("20/07/2017 11:25:02"), format.parse("20/07/2017 11:25:02"));

		ped1.setPagamento(pgto1);
		ped2.setPagamento(pgto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));

	}

}
