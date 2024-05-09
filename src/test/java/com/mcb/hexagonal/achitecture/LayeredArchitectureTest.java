package com.mcb.hexagonal.achitecture;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "com.mcb.hexagonal")
public class LayeredArchitectureTest {

	
	//Teste para definir quais camadas podem acessar o que.
	//exemplo Adpters in pode só ser acessada no config (usada para criar os beans de userCase)
	//exemplo2 ninguem precisa acessar config (para implementar ou instanciar ele)
	@ArchTest
	public static final ArchRule layered_architecture_test = layeredArchitecture()
	.consideringAllDependencies()
	.layer("AdaptersIn").definedBy("..adapters.in..")
	.layer("AdaptersOut").definedBy("..adapters.out..")
	.layer("UseCase").definedBy("..application.core.usecase..")
	.layer("PortsIn").definedBy("..application.ports.in..")
	.layer("PortsOut").definedBy("..application.ports.out..")
	.layer("Config").definedBy("..config..")
	.whereLayer("AdaptersIn").mayOnlyBeAccessedByLayers("Config")
	.whereLayer("AdaptersOut").mayOnlyBeAccessedByLayers("Config")
	.whereLayer("UseCase").mayOnlyBeAccessedByLayers("Config")
	.whereLayer("PortsIn").mayOnlyBeAccessedByLayers("UseCase", "AdaptersIn")
	.whereLayer("PortsOut").mayOnlyBeAccessedByLayers("UseCase", "AdaptersOut")
	.whereLayer("Config").mayNotBeAccessedByAnyLayer();

}