package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastrarFuncionarioTest {
	
	WebDriver driver;

	@Dado("^Acessar a página de cadastro de funcionário$")
	public void acessar_a_página_de_cadastro_de_funcionário() {
		
		//driver do google
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		
		//inicializar o selenium WebDriver
		driver = new ChromeDriver();
		
		//Maximizando a janela do navegador
		driver.manage().window().maximize();
		
		//acessar a página de cadastro
		driver.get("http://exerctestes01-001-site1.btempurl.com/Home/Exercicio01");
	}
	    

	@Dado("^Informar o nome do funcionário \"([^\"]*)\"$")
	public void informar_o_nome_do_funcionário(String nome) {
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys(nome);
	}
	
	@Dado("^Informar o cpf do funcionário \"([^\"]*)\"$")
	public void informar_o_cpf_do_funcionário(String cpf) {
		driver.findElement(By.xpath("//*[@id=\"CPF\"]")).sendKeys(cpf);
	}
	
	@Dado("^Informar a data de admissão do funcionário \"([^\"]*)\"$")
	public void informar_a_data_de_admissão_do_funcionário(String dataAdmissao) {
		driver.findElement(By.xpath("//*[@id=\"DataAdmissao\"]")).sendKeys(dataAdmissao);
	}
	
	@Dado("^informar o resumo de atividades \"([^\"]*)\"$")
	public void informar_o_resumo_de_atividades(String resumoAtividades) {
		driver.findElement(By.xpath("//*[@id=\"ResumoAtividades\"]")).sendKeys(resumoAtividades);
	}
	
	@Quando("^Solicitar a realização do cadastro$")
	public void solicitar_a_realização_do_cadastro() {
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
	}
	
	@Então("^Sistema informa que o cadastro do funcionário foi realizado com sucesso$")
			public void sistema_informa_que_o_cadastro_do_funcionário_foi_realizado_com_sucesso() {
			//ler a mensagem retornada pelo sistema
			// e armazena-la em uma variavel
			String mensagem = driver.findElement
			(By.xpath("//*[@id=\"mensagem\"]")).getText();
			//comparando resultado obtido X resultado esperado
			assertEquals(mensagem, "Funcionário cadastrado com sucesso");
			}
	
	@Então("^Sistema informa que todos os campos são de preenchimento obrigatório$")
	public void sistema_informa_que_todos_os_campos_são_de_preenchimento_obrigatório() {
	   //Ler cada mensagem de erro exibida pelo sistema no formulário
		String erroNome = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[1]/span")).getText();
		String erroCpf = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[2]/span")).getText();
		String erroDataAdmissao = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[1]/span")).getText();
		String erroResumoAtividades = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[2]/span")).getText();
		
		//verificando cada mensagem obtida.
		assertEquals(erroNome, "Informe o nome do funcionário.");
		assertEquals(erroCpf, "Informe o cpf do funcionário.");
		assertEquals(erroDataAdmissao, "Informe a data de admissão do funcionário.");
		assertEquals(erroResumoAtividades, "Informe o resumo de atividades do funcionário");
		try {
			//gerando a evidência do teste
			File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(evidencia, new File("c:\\testes\\Validação de campos obrigatórios no cadastro do funcionário.png"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
