package com.wesley.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HouseService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("init com parametros");
		
		// Não esquecer do super init da super classe
		super.init(config);
		
		// Parametros via ServletContext
		Enumeration<String> initContexto = getServletContext().getInitParameterNames();
		while(initContexto.hasMoreElements()){
			System.out.println(initContexto.nextElement());
		}
		Enumeration<String> initContexto2 = config.getServletContext().getInitParameterNames();
		while(initContexto2.hasMoreElements()){
			System.out.println(initContexto2.nextElement());
		}
				
		// Parametros via InitParametros da Servlet
		Enumeration<String> initConfigParametro = config.getInitParameterNames();
		while(initConfigParametro.hasMoreElements()){
			System.out.println(initConfigParametro.nextElement());			
		}
		Enumeration<String> initConfigParametro2 = getServletConfig().getInitParameterNames();
		while(initConfigParametro2.hasMoreElements()){
			System.out.println(initConfigParametro2.nextElement());			
		}
		
		// Nome da Servelt
		System.out.println(config.getServletName());
		
		// Nome do projeto
		System.out.println("Nome do Projeto no web.xml: " + config.getServletContext().getServletContextName());
		
		// Adicionando um atributo
		getServletContext().setAttribute("teste", "teste");
		
		// Lendo todos os atributos
		Enumeration<String> attributeNames = config.getServletContext().getAttributeNames();
		while(attributeNames.hasMoreElements()){
			try{
				System.out.println(attributeNames.nextElement());							
			}catch (Exception e) {
				System.err.println(e);
			}
		}
		
		// INFO GenericServlet
		log("LOG 1");
		
		// ERRO GenericServlet
		log("LOG 2", null);
		
		
		// INFO servetContext
		getServletContext().log("LOG 3");
		
		// ERRO servetContext
		getServletContext().log("LOG 4", new Exception("ERRO DE LOG"));
		
		
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init sem parametros");
		// Não esquecer do super init da super classe
		super.init();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		System.out.println("DoGet");
		
		PrintWriter out = resp.getWriter();
		
		// Parametro int da servlet
		out.println(this.getInitParameter("name"));
		
		// Parametro do context
		out.println(this.getServletContext().getInitParameter("email"));
		
		// Mostrando o atributo
		out.println(this.getServletContext().getAttribute("teste"));
	}
	
	// Service da httpServelt
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Obetendo servletContext da super classe
		getServletContext();
		
		// Obtendo servletConfig da super classe
		getServletConfig();
		
		// Obtendo serveltContext da requisição
		req.getServletContext();
		
		// Chamando manualmente
//		doGet(req, resp);
		
		// Caso não chame o super da superClasse os métodos Get, Post etc não são chamados.
		super.service(req, resp);
		
	}
	
	// Service da superclasse - Executado primeiro
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// Obetendo servletContext da super classe
 		getServletContext();
		
		// Obtendo servletConfig da super classe
		getServletConfig();
		
		// Obtendo serveltContext da requisição
		req.getServletContext();
		
		// Caso sobrescreva esse método service da superclasse e não efetue uma chamada ao super o service da HttpServelt não é chamado, logo, nenhum outro método GET,POST,DELETE etc.
		super.service(req, resp);
	}
	
//Métodos http
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoPost");
		PrintWriter out = resp.getWriter();
		out.print("Teste Post");
		// Caso seja efetuada a chamada do super, retorna que não existe implementação.
//		super.doPost(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoDelete");
		PrintWriter out = resp.getWriter();
		out.print("Teste Delete");
		// Caso seja efetuada a chamada do super, retorna que não existe implementação.
//		super.doDelete(req, resp);
	}
	
	// Caso tenha esse método chama ambos o HEAD e depois do GET
//	@Override
//	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("DoHead");
//		PrintWriter out = resp.getWriter();
//		out.print("Teste Head");
//		super.doHead(req, resp);
//	}
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoOptions");
		PrintWriter out = resp.getWriter();
		out.print("Teste Options");
		// 	Caso retirar a chamada do método da superclasse ele não retorna no cabeçalho os tipos de protocolos permitidos.
		super.doOptions(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoPut");
		PrintWriter out = resp.getWriter();
		out.print("Teste Put");
		// Caso seja efetuada a chamada do super, retorna que não existe implementação.
//		super.doPut(req, resp);
	}
	
	// Não é chamado no OPTIONS
	@Override
	protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoTrace");
		PrintWriter out = resp.getWriter();
		out.print("Teste Trace");
		super.doTrace(req, resp);
	}

	
}
