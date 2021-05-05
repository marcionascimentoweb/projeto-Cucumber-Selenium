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
import cucumber.api.java.pt.Ent�o;
import cucumber.api.java.pt.Quando;

public class CadastrarFuncionarioTest {
	
	WebDriver driver;

	@Dado("^Acessar a p�gina de cadastro de funcion�rio$")
	public void acessar_a_p�gina_de_cadastro_de_funcion�rio() {
		
		//driver do google
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		
		//inicializar o selenium WebDriver
		driver = new ChromeDriver();
		
		//Maximizando a janela do navegador
		driver.manage().window().maximize();
		
		//acessar a p�gina de cadastro
		driver.get("http://exerctestes01-001-site1.btempurl.com/Home/Exercicio01");
	}
	    

	@Dado("^Informar o nome do funcion�rio \"([^\"]*)\"$")
	public void informar_o_nome_do_funcion�rio(String nome) {
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys(nome);
	}
	
	@Dado("^Informar o cpf do funcion�rio \"([^\"]*)\"$")
	public void informar_o_cpf_do_funcion�rio(String cpf) {
		driver.findElement(By.xpath("//*[@id=\"CPF\"]")).sendKeys(cpf);
	}
	
	@Dado("^Informar a data de admiss�o do funcion�rio \"([^\"]*)\"$")
	public void informar_a_data_de_admiss�o_do_funcion�rio(String dataAdmissao) {
		driver.findElement(By.xpath("//*[@id=\"DataAdmissao\"]")).sendKeys(dataAdmissao);
	}
	
	@Dado("^informar o resumo de atividades \"([^\"]*)\"$")
	public void informar_o_resumo_de_atividades(String resumoAtividades) {
		driver.findElement(By.xpath("//*[@id=\"ResumoAtividades\"]")).sendKeys(resumoAtividades);
	}
	
	@Quando("^Solicitar a realiza��o do cadastro$")
	public void solicitar_a_realiza��o_do_cadastro() {
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
	}
	
	@Ent�o("^Sistema informa que o cadastro do funcion�rio foi realizado com sucesso$")
			public void sistema_informa_que_o_cadastro_do_funcion�rio_foi_realizado_com_sucesso() {
			//ler a mensagem retornada pelo sistema
			// e armazena-la em uma variavel
			String mensagem = driver.findElement
			(By.xpath("//*[@id=\"mensagem\"]")).getText();
			//comparando resultado obtido X resultado esperado
			assertEquals(mensagem, "Funcion�rio cadastrado com sucesso");
			}
	
	@Ent�o("^Sistema informa que todos os campos s�o de preenchimento obrigat�rio$")
	public void sistema_informa_que_todos_os_campos_s�o_de_preenchimento_obrigat�rio() {
	   //Ler cada mensagem de erro exibida pelo sistema no formul�rio
		String erroNome = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[1]/span")).getText();
		String erroCpf = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[2]/span")).getText();
		String erroDataAdmissao = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[1]/span")).getText();
		String erroResumoAtividades = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[2]/span")).getText();
		
		//verificando cada mensagem obtida.
		assertEquals(erroNome, "Informe o nome do funcion�rio.");
		assertEquals(erroCpf, "Informe o cpf do funcion�rio.");
		assertEquals(erroDataAdmissao, "Informe a data de admiss�o do funcion�rio.");
		assertEquals(erroResumoAtividades, "Informe o resumo de atividades do funcion�rio");
		try {
			//gerando a evid�ncia do teste
			File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(evidencia, new File("c:\\testes\\Valida��o de campos obrigat�rios no cadastro do funcion�rio.png"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
