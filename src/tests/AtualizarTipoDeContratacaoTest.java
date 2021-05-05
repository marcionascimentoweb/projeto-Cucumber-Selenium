package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent�o;
import cucumber.api.java.pt.Quando;

public class AtualizarTipoDeContratacaoTest {

	// atributo
	private WebDriver driver;

	@Dado("^Acessar a p�gina de atualiza��o de tipo de contrata��o$")
	public void acessar_a_p�gina_de_atualiza��o_de_tipo_de_contrata��o() {

		// driver googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");

		// iniciliazando o selenium WebDriver
		driver = new ChromeDriver();

		// Maximizando a janela do navegador
		driver.manage().window().maximize();

		// acessando a p�gina de cadastro
		driver.get("http://exerctestes01-001-site1.btempurl.com/Home/Exercicio02");
	}

	@Dado("^Selecionar o funcion�rio desejado \"([^\"]*)\"$")
	public void selecionar_o_funcion�rio_desejado(String funcionario) {

		// capturando o campo de sele��o de funcion�rio
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Funcionario\"]"));

		// tratar o campo como um DropDownList
		Select select = new Select(element);

		// Selecionar o funcion�rio desejado
		select.selectByVisibleText(funcionario);

	}

	@Dado("^Selecionar o tipo de contrata��o \"([^\"]*)\"$")
	public void selecionar_o_tipo_de_contrata��o(String tipoContratacao) {
		
		//capturando o campo de sele��o de funcion�rio
		WebElement element = driver.findElement(By.xpath("//*[@id=\"TipoContratacao\"]"));
		
		//tratar o campo como um DropDownList (campo de sele��o)
		Select select = new Select(element);
		
		//Selecionar o tipo de contrata��o desejado
		select.selectByVisibleText(tipoContratacao);
	}

	@Quando("^Solicitar a atualiza��o do tipo de contrata��o do funcion�rio$")
			public void solicitar_a_atualiza��o_do_tipo_de_contrata��o_do_funcion�rio() {
			//clicando no bot�o de a��o do formul�rio
			driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
			}

	@Ent�o("^Sistema informa que o tipo de contrata��o do funcion�rio foi atualizado com sucesso$")
	public void sistema_informa_que_o_tipo_de_contrata��o_do_funcion�rio_foi_atualizado_com_sucesso() {
		
		//ler a mensagem exibida na p�gina do sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		//comparando o resultado esperado com o resultado obtido
		assertEquals(mensagem, "Dados atualizados com sucesso");
	}

	@Ent�o("^Sistema informa que os campos s�o obrigat�rios para atualizar os dados$")
	public void sistema_informa_que_os_campos_s�o_obrigat�rios_para_atualizar_os_dados() {
		
		//ler as mensagens de erro de cada campo obrigatorio
		String erroFuncionario = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[1]/span")).getText();
		String erroTipoContratacao = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[2]/span")).getText();
		
		//comparando as mensagens
		assertEquals(erroFuncionario, "Por favor, selecione o funcion�rio.");
		assertEquals(erroTipoContratacao, "Por favor, informe o tipo de contrata��o.");
		
		try {
			//gerando evid�ncias do teste
			File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(evidencia, new File("c:\\testes\\Valida��o de campos obrigat�rios na atualiza��o do tipo de.png"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
